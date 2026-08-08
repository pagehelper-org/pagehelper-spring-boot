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

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;

/**
 * Configuration properties for PageHelper.
 *
 * @author liuzh
 */
@ConfigurationProperties(prefix = PageHelperProperties.PAGEHELPER_PREFIX)
public class PageHelperProperties extends Properties {
    public static final String PAGEHELPER_PREFIX = "pagehelper";

    public Boolean getOffsetAsPageNum() {
        return Boolean.valueOf(getProperty("offsetAsPageNum"));
    }

    public void setOffsetAsPageNum(Boolean offsetAsPageNum) {
        setProperty("offsetAsPageNum", offsetAsPageNum.toString());
    }

    public Boolean getRowBoundsWithCount() {
        return Boolean.valueOf(getProperty("rowBoundsWithCount"));
    }

    public void setRowBoundsWithCount(Boolean rowBoundsWithCount) {
        setProperty("rowBoundsWithCount", rowBoundsWithCount.toString());
    }

    public Boolean getPageSizeZero() {
        return Boolean.valueOf(getProperty("pageSizeZero"));
    }

    public void setPageSizeZero(Boolean pageSizeZero) {
        setProperty("pageSizeZero", pageSizeZero.toString());
    }

    public Boolean getReasonable() {
        return Boolean.valueOf(getProperty("reasonable"));
    }

    public void setReasonable(Boolean reasonable) {
        setProperty("reasonable", reasonable.toString());
    }

    public Boolean getSupportMethodsArguments() {
        return Boolean.valueOf(getProperty("supportMethodsArguments"));
    }

    public void setSupportMethodsArguments(Boolean supportMethodsArguments) {
        setProperty("supportMethodsArguments", supportMethodsArguments.toString());
    }

    public String getDialect() {
        return getProperty("dialect");
    }

    public void setDialect(String dialect) {
        setProperty("dialect", dialect);
    }

    public String getHelperDialect() {
        return getProperty("helperDialect");
    }

    public void setHelperDialect(String helperDialect) {
        setProperty("helperDialect", helperDialect);
    }

    public Boolean getAutoRuntimeDialect() {
        return Boolean.valueOf(getProperty("autoRuntimeDialect"));
    }

    public void setAutoRuntimeDialect(Boolean autoRuntimeDialect) {
        setProperty("autoRuntimeDialect", autoRuntimeDialect.toString());
    }

    public Boolean getAutoDialect() {
        return Boolean.valueOf(getProperty("autoDialect"));
    }

    public void setAutoDialect(Boolean autoDialect) {
        setProperty("autoDialect", autoDialect.toString());
    }

    public Boolean getCloseConn() {
        return Boolean.valueOf(getProperty("closeConn"));
    }

    public void setCloseConn(Boolean closeConn) {
        setProperty("closeConn", closeConn.toString());
    }

    public String getParams() {
        return getProperty("params");
    }

    public void setParams(String params) {
        setProperty("params", params);
    }

    public Boolean getDefaultCount() {
        return Boolean.valueOf(getProperty("defaultCount"));
    }

    public void setDefaultCount(Boolean defaultCount) {
        setProperty("defaultCount", defaultCount.toString());
    }

    public String getDialectAlias() {
        return getProperty("dialectAlias");
    }

    public void setDialectAlias(String dialectAlias) {
        setProperty("dialectAlias", dialectAlias);
    }

    public String getAutoDialectClass() {
        return getProperty("autoDialectClass");
    }

    public void setAutoDialectClass(String autoDialectClass) {
        setProperty("autoDialectClass", autoDialectClass);
    }

    public Boolean getAsyncCount() {
        return Boolean.valueOf(getProperty("asyncCount"));
    }

    public void setAsyncCount(Boolean asyncCount) {
        setProperty("asyncCount", asyncCount.toString());
    }

    public Integer getAsyncCountParallelism() {
        String value = getProperty("asyncCountParallelism");
        return value != null ? Integer.valueOf(value) : null;
    }

    public void setAsyncCountParallelism(Integer asyncCountParallelism) {
        setProperty("asyncCountParallelism", asyncCountParallelism.toString());
    }

    public String getCountSqlParser() {
        return getProperty("countSqlParser");
    }

    public void setCountSqlParser(String countSqlParser) {
        setProperty("countSqlParser", countSqlParser);
    }

    public String getOrderBySqlParser() {
        return getProperty("orderBySqlParser");
    }

    public void setOrderBySqlParser(String orderBySqlParser) {
        setProperty("orderBySqlParser", orderBySqlParser);
    }

    public String getSqlServerSqlParser() {
        return getProperty("sqlServerSqlParser");
    }

    public void setSqlServerSqlParser(String sqlServerSqlParser) {
        setProperty("sqlServerSqlParser", sqlServerSqlParser);
    }

    public void setBannerEnabled(Boolean bannerEnabled) {
        setProperty("banner",bannerEnabled.toString());
    }

    public Boolean getBannerEnabled() {
        return Boolean.valueOf(getProperty("banner"));
    }

    public Boolean getDebug() {
        return Boolean.valueOf(getProperty("debug"));
    }

    public void setDebug(Boolean debug) {
        setProperty("debug", debug.toString());
    }

    public String getCountSuffix() {
        return getProperty("countSuffix");
    }

    public void setCountSuffix(String countSuffix) {
        setProperty("countSuffix", countSuffix);
    }

    public String getCountMsIdGen() {
        return getProperty("countMsIdGen");
    }

    public void setCountMsIdGen(String countMsIdGen) {
        setProperty("countMsIdGen", countMsIdGen);
    }

    public String getMsCountCache() {
        return getProperty("msCountCache");
    }

    public void setMsCountCache(String msCountCache) {
        setProperty("msCountCache", msCountCache);
    }

    public String getAggregateFunctions() {
        return getProperty("aggregateFunctions");
    }

    public void setAggregateFunctions(String aggregateFunctions) {
        setProperty("aggregateFunctions", aggregateFunctions);
    }
}
