package com.github.pagehelper.autoconfigure;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;

import com.github.pagehelper.PageInterceptor;

/**
 * Unit test for {@link SqlSessionFactoryIsolatedPageHelperProperties} and {@link PageHelperAutoConfiguration}.
 *
 * @author tigerzhao
 * @date 2026-01-10 21:22
 */
@SpringBootTest(classes = {SqlSessionFactoryIsolatedPageHelperPropertiesTest.SqlSessionFactoryConfiguration.class,
    PageHelperAutoConfiguration.class})
@TestPropertySource(properties = {"pagehelper.dialect=com.github.pagehelper.dialect.helper.OracleDialect",
    "pagehelper.sql-session-factory-group.sqlSessionFactory1.dialect=com.github.pagehelper.dialect.helper.MySqlDialect",
    "pagehelper.sqlSessionFactoryGroup.sqlSessionFactory2.dialect=com.github.pagehelper.dialect.helper.PostgreSqlDialect"})
class SqlSessionFactoryIsolatedPageHelperPropertiesTest {

    public static class SqlSessionFactoryConfiguration {

        @Bean
        public SqlSessionFactory sqlSessionFactory1() {
            return new DefaultSqlSessionFactory(new Configuration());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory2() {
            return new DefaultSqlSessionFactory(new Configuration());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory3() {
            return new DefaultSqlSessionFactory(new Configuration());
        }

    }

    private static final Logger LOGGER =
        LoggerFactory.getLogger(SqlSessionFactoryIsolatedPageHelperPropertiesTest.class);

    @Autowired
    private Map<String, SqlSessionFactory> sqlSessionFactoryMap;

    private static Field pageHelperDialectField;

    static {
        try {
            pageHelperDialectField = PageInterceptor.class.getDeclaredField("dialect");
            pageHelperDialectField.setAccessible(true);
        } catch (NoSuchFieldException | SecurityException e) {
            LOGGER.warn("Failed to get pageHelper dialect field", e);
        }
    }

    @Test
    public void testForIsolatedPageHelperConfiguration() {
        sqlSessionFactoryMap.forEach((sqlSessionFactoryBeanName, sqlSessionFactory) -> {
            if ("sqlSessionFactory1".equals(sqlSessionFactoryBeanName)) {
                assertInterceptorConfiguration(sqlSessionFactory, "com.github.pagehelper.dialect.helper.MySqlDialect");
            } else if ("sqlSessionFactory2".equals(sqlSessionFactoryBeanName)) {
                assertInterceptorConfiguration(sqlSessionFactory,
                    "com.github.pagehelper.dialect.helper.PostgreSqlDialect");
            } else {
                assertInterceptorConfiguration(sqlSessionFactory, "com.github.pagehelper.dialect.helper.OracleDialect");
            }
        });
    }

    private void assertInterceptorConfiguration(SqlSessionFactory sqlSessionFactory, String expectedDialectClassName) {
        List<Interceptor> interceptors = sqlSessionFactory.getConfiguration().getInterceptors();
        Assertions.assertFalse(interceptors.isEmpty());
        Interceptor interceptor = interceptors.get(0);
        Assertions.assertInstanceOf(PageInterceptor.class, interceptor);
        if (null != pageHelperDialectField) {
            try {
                Assertions.assertEquals(expectedDialectClassName,
                    pageHelperDialectField.get(interceptor).getClass().getName());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                LOGGER.warn("Failed to get pageHelper dialect", e);
            }
        }
    }

}