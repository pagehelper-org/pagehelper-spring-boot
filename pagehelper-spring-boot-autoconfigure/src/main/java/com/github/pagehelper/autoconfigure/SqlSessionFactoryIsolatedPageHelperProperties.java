package com.github.pagehelper.autoconfigure;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * SqlSessionFactory isolated configuration properties for PageHelper.
 *
 * @author tigerzhao
 */
@ConfigurationProperties(prefix = PageHelperProperties.PAGEHELPER_PREFIX)
public class SqlSessionFactoryIsolatedPageHelperProperties {

    public static class PageHelperDedicatedProperties extends PageHelperStandardProperties {

        public PageHelperDedicatedProperties() {
            super(new PageHelperProperties());
        }

    }

    private Map<String, PageHelperDedicatedProperties> sqlSessionFactoryGroup;

    public Map<String, PageHelperDedicatedProperties> getSqlSessionFactoryGroup() {
        return sqlSessionFactoryGroup;
    }

    public void setSqlSessionFactoryGroup(Map<String, PageHelperDedicatedProperties> sqlSessionFactoryGroup) {
        this.sqlSessionFactoryGroup = sqlSessionFactoryGroup;
    }

}
