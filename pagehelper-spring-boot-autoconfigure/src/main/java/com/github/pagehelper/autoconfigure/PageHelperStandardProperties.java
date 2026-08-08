package com.github.pagehelper.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Optional;

/**
 * 原来的{@link PageHelperProperties}继承了{@link java.util.Properties}<br>
 * 在使用中发现SpringBoot会直接将application.yml(application.properties)的配置名原样set到集合中，
 * 这样会导致配置文件里的kebab-case风格配置映射到配置类中还是kebab-case而不是camelCase，
 * 之后设置属性的时候就会因为找不到camelCase的配置导致失效。
 * <br>
 * 所有kebab-case风格的配置项都会产生这个问题，即配置不生效。
 * <br>
 * 这个类不继承{@link java.util.Properties}，用于提前接收配置文件中的配置项，
 * 由于没有继承{@link java.util.Properties}，SpringBoot可以做正常的风格转换，
 * 转换完成后再将camelCase风格的配置放到原来的{@link PageHelperProperties}中
 *
 * @author showen
 */
@ConfigurationProperties(prefix = PageHelperProperties.PAGEHELPER_PREFIX)
public class PageHelperStandardProperties {
    private PageHelperProperties properties;
    private Boolean offsetAsPageNum;
    private Boolean rowBoundsWithCount;
    private Boolean pageSizeZero;
    private Boolean reasonable;
    private Boolean supportMethodsArguments;
    private String dialect;
    private String helperDialect;
    private Boolean autoRuntimeDialect;
    private Boolean autoDialect;
    private Boolean closeConn;
    private String params;
    private Boolean defaultCount;
    private String dialectAlias;
    private String autoDialectClass;
    private Boolean useSqlserver2012;
    private String countColumn;
    private String replaceSql;
    private String sqlCacheClass;
    private String boundSqlInterceptors;
    private Boolean keepOrderBy;
    private Boolean keepSubSelectOrderBy;
    private String sqlParser;
    private Boolean asyncCount;
    private String countSqlParser;
    private String orderBySqlParser;
    private String sqlServerSqlParser;
    private Boolean debug;
    private String countSuffix;
    private String countMsIdGen;
    private String msCountCache;
    private String aggregateFunctions;
    private Integer asyncCountParallelism;

    public PageHelperStandardProperties() {
        this(new PageHelperProperties());
    }

    @Autowired
    public PageHelperStandardProperties(PageHelperProperties properties) {
        this.properties = properties;
    }

    public PageHelperProperties getProperties() {
        return properties;
    }

    public Boolean getOffsetAsPageNum() {
        return offsetAsPageNum;
    }

    public void setOffsetAsPageNum(Boolean offsetAsPageNum) {
        this.offsetAsPageNum = offsetAsPageNum;
        Optional.ofNullable(offsetAsPageNum).ifPresent(properties::setOffsetAsPageNum);
    }

    public Boolean getRowBoundsWithCount() {
        return rowBoundsWithCount;
    }

    public void setRowBoundsWithCount(Boolean rowBoundsWithCount) {
        this.rowBoundsWithCount = rowBoundsWithCount;
        Optional.ofNullable(rowBoundsWithCount).ifPresent(properties::setRowBoundsWithCount);
    }

    public Boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
        Optional.ofNullable(pageSizeZero).ifPresent(properties::setPageSizeZero);
    }

    public Boolean getReasonable() {
        return reasonable;
    }

    public void setReasonable(Boolean reasonable) {
        this.reasonable = reasonable;
        Optional.ofNullable(reasonable).ifPresent(properties::setReasonable);
    }

    public Boolean getSupportMethodsArguments() {
        return supportMethodsArguments;
    }

    public void setSupportMethodsArguments(Boolean supportMethodsArguments) {
        this.supportMethodsArguments = supportMethodsArguments;
        Optional.ofNullable(supportMethodsArguments).ifPresent(properties::setSupportMethodsArguments);
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
        Optional.ofNullable(dialect).ifPresent(properties::setDialect);
    }

    public String getHelperDialect() {
        return helperDialect;
    }

    public void setHelperDialect(String helperDialect) {
        this.helperDialect = helperDialect;
        Optional.ofNullable(helperDialect).ifPresent(properties::setHelperDialect);
    }

    public Boolean getAutoRuntimeDialect() {
        return autoRuntimeDialect;
    }

    public void setAutoRuntimeDialect(Boolean autoRuntimeDialect) {
        this.autoRuntimeDialect = autoRuntimeDialect;
        Optional.ofNullable(autoRuntimeDialect).ifPresent(properties::setAutoRuntimeDialect);
    }

    public Boolean getAutoDialect() {
        return autoDialect;
    }

    public void setAutoDialect(Boolean autoDialect) {
        this.autoDialect = autoDialect;
        Optional.ofNullable(autoDialect).ifPresent(properties::setAutoDialect);
    }

    public Boolean getCloseConn() {
        return closeConn;
    }

    public void setCloseConn(Boolean closeConn) {
        this.closeConn = closeConn;
        Optional.ofNullable(closeConn).ifPresent(properties::setCloseConn);
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
        Optional.ofNullable(params).ifPresent(properties::setParams);
    }

    public Boolean getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Boolean defaultCount) {
        this.defaultCount = defaultCount;
        Optional.ofNullable(defaultCount).ifPresent(properties::setDefaultCount);
    }

    public String getDialectAlias() {
        return dialectAlias;
    }

    public void setDialectAlias(String dialectAlias) {
        this.dialectAlias = dialectAlias;
        Optional.ofNullable(dialectAlias).ifPresent(properties::setDialectAlias);
    }

    public String getAutoDialectClass() {
        return autoDialectClass;
    }

    public void setAutoDialectClass(String autoDialectClass) {
        this.autoDialectClass = autoDialectClass;
        Optional.ofNullable(autoDialectClass).ifPresent(properties::setAutoDialectClass);
    }

    public Boolean getUseSqlserver2012() {
        return useSqlserver2012;
    }

    public void setUseSqlserver2012(Boolean useSqlserver2012) {
        this.useSqlserver2012 = useSqlserver2012;
        Optional.ofNullable(useSqlserver2012).ifPresent(v -> properties.setProperty("useSqlserver2012", v.toString()));
    }

    public String getCountColumn() {
        return countColumn;
    }

    public void setCountColumn(String countColumn) {
        this.countColumn = countColumn;
        Optional.ofNullable(countColumn).ifPresent(v -> properties.setProperty("countColumn", v));
    }

    public String getReplaceSql() {
        return replaceSql;
    }

    public void setReplaceSql(String replaceSql) {
        this.replaceSql = replaceSql;
        Optional.ofNullable(replaceSql).ifPresent(v -> properties.setProperty("replaceSql", v));
    }

    public String getSqlCacheClass() {
        return sqlCacheClass;
    }

    public void setSqlCacheClass(String sqlCacheClass) {
        this.sqlCacheClass = sqlCacheClass;
        Optional.ofNullable(sqlCacheClass).ifPresent(v -> properties.setProperty("sqlCacheClass", v));
    }

    public String getBoundSqlInterceptors() {
        return boundSqlInterceptors;
    }

    public void setBoundSqlInterceptors(String boundSqlInterceptors) {
        this.boundSqlInterceptors = boundSqlInterceptors;
        Optional.ofNullable(boundSqlInterceptors).ifPresent(v -> properties.setProperty("boundSqlInterceptors", v));
    }

    public Boolean getKeepOrderBy() {
        return keepOrderBy;
    }

    public void setKeepOrderBy(Boolean keepOrderBy) {
        this.keepOrderBy = keepOrderBy;
        Optional.ofNullable(keepOrderBy).ifPresent(v -> properties.setProperty("keepOrderBy", v.toString()));
    }

    public Boolean getKeepSubSelectOrderBy() {
        return keepSubSelectOrderBy;
    }

    public void setKeepSubSelectOrderBy(Boolean keepSubSelectOrderBy) {
        this.keepSubSelectOrderBy = keepSubSelectOrderBy;
        Optional.ofNullable(keepSubSelectOrderBy).ifPresent(v -> properties.setProperty("keepSubSelectOrderBy", v.toString()));
    }

    public String getSqlParser() {
        return sqlParser;
    }

    public void setSqlParser(String sqlParser) {
        this.sqlParser = sqlParser;
        Optional.ofNullable(sqlParser).ifPresent(v -> properties.setProperty("sqlParser", v));
    }

    public Boolean getAsyncCount() {
        return asyncCount;
    }

    public void setAsyncCount(Boolean asyncCount) {
        this.asyncCount = asyncCount;
        Optional.ofNullable(asyncCount).ifPresent(v -> properties.setProperty("asyncCount", v.toString()));
    }

    public String getCountSqlParser() {
        return countSqlParser;
    }

    public void setCountSqlParser(String countSqlParser) {
        this.countSqlParser = countSqlParser;
        Optional.ofNullable(countSqlParser).ifPresent(v -> properties.setProperty("countSqlParser", v));
    }

    public String getOrderBySqlParser() {
        return orderBySqlParser;
    }

    public void setOrderBySqlParser(String orderBySqlParser) {
        this.orderBySqlParser = orderBySqlParser;
        Optional.ofNullable(orderBySqlParser).ifPresent(v -> properties.setProperty("orderBySqlParser", v));
    }

    public String getSqlServerSqlParser() {
        return sqlServerSqlParser;
    }

    public void setSqlServerSqlParser(String sqlServerSqlParser) {
        this.sqlServerSqlParser = sqlServerSqlParser;
        Optional.ofNullable(sqlServerSqlParser).ifPresent(v -> properties.setProperty("sqlServerSqlParser", v));
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
        Optional.ofNullable(debug).ifPresent(v -> properties.setProperty("debug", v.toString()));
    }

    public String getCountSuffix() {
        return countSuffix;
    }

    public void setCountSuffix(String countSuffix) {
        this.countSuffix = countSuffix;
        Optional.ofNullable(countSuffix).ifPresent(v -> properties.setProperty("countSuffix", v));
    }

    public String getCountMsIdGen() {
        return countMsIdGen;
    }

    public void setCountMsIdGen(String countMsIdGen) {
        this.countMsIdGen = countMsIdGen;
        Optional.ofNullable(countMsIdGen).ifPresent(v -> properties.setProperty("countMsIdGen", v));
    }

    public String getMsCountCache() {
        return msCountCache;
    }

    public void setMsCountCache(String msCountCache) {
        this.msCountCache = msCountCache;
        Optional.ofNullable(msCountCache).ifPresent(v -> properties.setProperty("msCountCache", v));
    }

    public String getAggregateFunctions() {
        return aggregateFunctions;
    }

    public void setAggregateFunctions(String aggregateFunctions) {
        this.aggregateFunctions = aggregateFunctions;
        Optional.ofNullable(aggregateFunctions).ifPresent(v -> properties.setProperty("aggregateFunctions", v));
    }

    public Integer getAsyncCountParallelism() {
        return asyncCountParallelism;
    }

    public void setAsyncCountParallelism(Integer asyncCountParallelism) {
        this.asyncCountParallelism = asyncCountParallelism;
        Optional.ofNullable(asyncCountParallelism).ifPresent(v -> properties.setProperty("asyncCountParallelism", v.toString()));
    }
}
