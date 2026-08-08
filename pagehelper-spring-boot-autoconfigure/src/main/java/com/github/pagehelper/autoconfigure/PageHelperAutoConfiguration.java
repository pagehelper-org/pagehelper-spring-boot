/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.pagehelper.autoconfigure;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Map;

/**
 * 自定注入分页插件
 *
 * @author liuzh
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(SqlSessionFactory.class)
@EnableConfigurationProperties({PageHelperProperties.class, PageHelperStandardProperties.class,
    SqlSessionFactoryIsolatedPageHelperProperties.class})
@AutoConfigureAfter(MybatisAutoConfiguration.class)
//@Import(PageHelperProperties.class)
@Lazy(false)
public class PageHelperAutoConfiguration implements InitializingBean {

    private final Map<String, SqlSessionFactory> sqlSessionFactoryMap;

    private final PageHelperProperties properties;

    private final SqlSessionFactoryIsolatedPageHelperProperties sqlSessionFactoryIsolatedPageHelperProperties;

    public PageHelperAutoConfiguration(Map<String, SqlSessionFactory> sqlSessionFactoryMap,
        PageHelperStandardProperties standardProperties,
        SqlSessionFactoryIsolatedPageHelperProperties sqlSessionFactoryIsolatedPageHelperProperties) {
        this.sqlSessionFactoryMap = sqlSessionFactoryMap;
        this.properties = standardProperties.getProperties();
        this.sqlSessionFactoryIsolatedPageHelperProperties = sqlSessionFactoryIsolatedPageHelperProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // prepare default interceptor
        PageInterceptor defaultInterceptor = new PageInterceptor();
        defaultInterceptor.setProperties(this.properties);
        // prepare isolated properties
        Map<String, SqlSessionFactoryIsolatedPageHelperProperties.PageHelperDedicatedProperties> propertiesMap =
            sqlSessionFactoryIsolatedPageHelperProperties.getSqlSessionFactoryGroup();
        sqlSessionFactoryMap.forEach((sqlSessionFactoryBeanName, sqlSessionFactory) -> {
            // try to find dedicated properties
            SqlSessionFactoryIsolatedPageHelperProperties.PageHelperDedicatedProperties dedicatedProperties =
                null == propertiesMap ? null : propertiesMap.get(sqlSessionFactoryBeanName);
            PageInterceptor interceptor;
            if (null == dedicatedProperties) {
                // use default interceptor
                interceptor = defaultInterceptor;
            } else {
                // build dedicated interceptor
                interceptor = new PageInterceptor();
                interceptor.setProperties(dedicatedProperties.getProperties());
            }
            // register interceptor
            org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
            if (!containsInterceptor(configuration, interceptor)) {
                configuration.addInterceptor(interceptor);
            }
        });
    }

    /**
     * 是否已经存在相同的拦截器
     *
     * @param configuration
     * @param interceptor
     * @return
     */
    private boolean containsInterceptor(org.apache.ibatis.session.Configuration configuration, Interceptor interceptor) {
        try {
            // getInterceptors since 3.2.2
            return configuration.getInterceptors().stream().anyMatch(config->interceptor.getClass().isAssignableFrom(config.getClass()));
        } catch (Exception e) {
            return false;
        }
    }

}
