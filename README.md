# PageHelper integration with Spring Boot

PageHelper-Spring-Boot-Starter 帮助你集成分页插件到 Spring Boot。

PageHelper-Spring-Boot-Starter will help you use PageHelper with Spring Boot.

Support PageHelper 6.x

## How to use
在 pom.xml 中添加如下依赖：

Add the following dependency to your pom.xml:

```xml

<dependency>
  <groupId>com.github.pagehelper</groupId>
  <artifactId>pagehelper-spring-boot-starter</artifactId>
  <version>4.1.0</version>
</dependency>
```

## 微信公众号

<img src="wx_mybatis.jpg" height="300"/>

## v4.1.0 - 2026-05-29

- 将最低支持 JDK 版本降级到 JDK17

## v4.0.0 - 2026-04-23

- 升级 mybatis-spring-boot-starter 到 4.0.1
- 升级 spring-boot-dependencies 到 4.0.2
- 当前版本支持 JDK21+

## v2.1.1 - 2025-06-20

- 升级 PageHelper 到 6.1.1
- 升级 MyBatis 到 3.5.19
- 修复 autoconfigure 模块 MyBatis 依赖版本不一致问题（3.5.10 → 3.5.19）
- 新增 Spring Boot 属性映射：`debug`、`countSuffix`、`countMsIdGen`、`msCountCache`、`aggregateFunctions`、`asyncCountParallelism`
- Maven 发布从旧 OSSRH (oss.sonatype.org) 迁移到新的 Maven Central Portal (central.sonatype.com)

**当前版本支持 JDK17+ 和以下依赖版本：**

- mybatis-spring-boot-starter 3.0.4
- spring-boot-dependencies 3.5.0

## v2.1.0 - 2023-12-17

- 升级 PageHelper 到 6.1.0，支持异步 count
  等功能，详细查看 [6.1.0](https://github.com/pagehelper/Mybatis-PageHelper/releases/tag/v6.1.0)
- 升级 MyBatis 到 3.5.15
- 升级 springboot 到 2.7.18
- 新增参数 `orderBySqlParser`，`OrderBySqlParser`改为接口，允许通过`orderBySqlParser`参数替换为自己的实现
- 新增参数 `sqlServerSqlParser`，`SqlServerSqlParser`改为接口，允许通过`sqlServerSqlParser`参数替换为自己的实现
- 接口 `CountSqlParser`,`OrderBySqlParser`,`SqlServerSqlParser` 还支持SPI方式覆盖默认实现，优先级低于参数指定

## v2.0.0 - 2023-11-05

- 升级 PageHelper 到 6.0.0，支持异步 count 等功能，详细查看 [6.0](https://github.com/pagehelper/Mybatis-PageHelper/releases/tag/v6.0.0)
- 升级 MyBatis 到 3.5.15
- 升级 springboot 到 2.7.17
- 新增参数 `asyncCount`，增加异步count支持，默认`false`，单次设置：`PageHelper.startPage(1, 10).enableAsyncCount()`;
- 新增参数 `countSqlParser`，`CountSqlParser`改为接口，允许通过`countSqlParser`参数替换为自己的实现

参数示例：
```properties
pagehelper.async-count=true
```

## v1.4.7 - 2023-06-03

- 升级 PageHelper 到 5.3.3
- 升级 MyBatis 到 3.5.13
- 升级 MyBatis Starter 到 2.3.1
- 升级 springboot 到 2.7.12

## v1.4.6 - 2022-11-28

- 兼容 Spring Boot 3.0 by [pky920216344](https://github.com/pky920216344)
- 功能完善：存在PageInterceptor及其子类就不再添加过滤器 by [jingheee](https://github.com/jingheee)

## v1.4.5 - 2022-09-18

- 升级 PageHelper 到 5.3.2

## v1.4.4 - 2022-09-16

- 修复配置文件中kebab-case风格的配置项失效的问题 pr#138, by ShoWen
- 兼容性支持，demo配置修改
- 升级 springboot 到 2.7.3

## v1.4.3 - 2022-06-18

- 升级 PageHelper 到 5.3.1
- 升级 MyBatis 到 3.5.10
- 升级 springboot 到 2.7.0

## v1.4.2 - 2022-04-06

- 升级 MyBatis 到 3.5.9
- 升级 MyBatis Starter 到 2.2.2
- 升级 springboot 到 2.6.6

## v1.4.1 - 2021-11-24

- 升级 springboot 到 2.6.0，兼容性修复，解决循环依赖

## v1.4.0 - 2021-10-07

- 升级 PageHelper 到 5.3.0
- 升级 springboot 到 2.5.5
- 增加 `autoDialectClass` 参数，详情看 PageHelper 更新日志


## v1.3.1 - 2021-06-20

- 升级 PageHelper 到 5.2.1
- 升级 MyBatis 到 3.5.7
- 升级 MyBatis Starter 到 2.2.0
- 升级 springboot 到 2.5.1
- `PageHelperAutoConfiguration` 使用 `InitializingBean` 接口代替 `@PostConstruct` 注解

## v1.3.0 - 2020-07-26

- 升级 PageHelper 到 5.2.0，包含大量改动，详细内容参考：[PageHelper 更新日志](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/Changelog.md)
- 升级 MyBatis 到 3.5.5
- 升级 MyBatis Starter 到 2.1.3
- 升级 springboot 到 2.3.1.RELEASE
- `PageHelperAutoConfiguration` 增加 `@Lazy(false)` 注解，当配置延迟加载时，避免分页插件出错
- 添加分页插件时判断是否已经配置过同一个实例（不同的配置是不同的实例）

## v1.2.13 - 2019-11-26

- 升级 PageHelper 到 5.1.11
- 升级 MyBatis 到 3.5.3
- 升级 MyBatis Starter 到 2.1.1
- 升级 springboot 到 2.2.1.RELEASE

## v1.2.12 - 2019-06-05

- 升级 PageHelper 到 5.1.10

## v1.2.11 - 2019-05-29

- 升级 PageHelper 到 5.1.9
- 升级 MyBatis 到 3.5.1
- 升级 MyBatis Starter 到 2.0.1
- 升级 springboot 到 2.1.5.RELEASE

## v1.2.10 - 2018-11-11

- 升级 PageHelper 到 5.1.8
- 升级 springboot 到 2.1.0.RELEASE

## v1.2.9 - 2018-10-11

- 升级 PageHelper 到 5.1.7

>v1.2.8 由于未修改版本，仍然和 v1.2.7 相同。

## v1.2.7 - 2018-09-04

- 升级 PageHelper 到 5.1.6


## v1.2.6 - 2018-09-04

- 升级 PageHelper 到 5.1.5


## v1.2.5 - 2018-04-22

- 升级 PageHelper 到 5.1.4（默认增加对达梦数据库的支持）
- 升级 MyBatis 到 3.4.6

## v1.2.4 - 2018-04-07

- 升级 PageHelper 到 5.1.3
- 升级 springboot 到 2.0.1.RELEASE
- 增加 dialectAlias 参数，允许配置自定义实现的 别名，可以用于根据JDBCURL自动获取对应实现，允许通过此种方式覆盖已有的实现，配置示例如(多个配置用分号`;`隔开)：
  ```properties
  pagehelper.dialect-alias=oracle=com.github.pagehelper.dialect.helper.OracleDialect
  ```
- 增加 defaultCount 参数，用于控制默认不带 count 查询的方法中，是否执行 count 查询，默认 true 会执行 count 查询，这是一个全局生效的参数，多数据源时也是统一的行为。配置示例如：
  ```properties
  pagehelper.default-count=false
  ```


## v1.2.3 - 2017-09-25

- 修改属性获取方式，兼容 Spring Boot 1.x 和 2.x
- 第三方扩展分页插件时使用到额外属性时，配置属性要和属性名完全匹配
- 升级 springboot 到 1.5.7.RELEASE
- 升级 MyBatis-Starter 版本到 1.3.1

## v1.2.2 - 2017-09-18

- 升级 pagehelper 到 5.1.2

## v1.2.1 - 2017-08-30

- 升级 pagehelper 到 5.1.1

## v1.2.0 - 2017-08-28

- 升级 pagehelper 到 5.1.0

## v1.1.3 - 2017-08-01

- 升级 pagehelper 到 5.0.4
- 升级 springboot 到 1.5.6.RELEASE

## v1.1.2 - 2017-06-28 by [drtrang](https://github.com/drtrang)

- 升级 pagehelper 到 5.0.3
- 升级 springboot 到 1.5.4.RELEASE
- 将 maven-compiler-plugin 和 maven-source-plugin 从 release profile 中提出来作为全局插件，并且增加继承属性，解决 `PageHelperAutoConfiguration` 类中的 `@Override` 报错问题。

## v1.1.1 - 2017-04-25
- 增加多数据源支持 [#pr6](https://github.com/pagehelper/pagehelper-spring-boot/pull/6) by [yangBin666](https://github.com/yangBin666)
- 升级分页插件 PageHelper 版本到 5.0.1
- 升级 MyBatis 版本到 3.4.4
- 升级 Spring Boot 版本到 1.5.3.RELEASE
- 升级 MyBatis-Starter 版本到 1.3.0

## v1.1.0 - 2017-02-04
- 解决可能会注册两次分页插件的问题。
- 增加 PageHelperProperties 注入，常用属性可以通过 IDE 自动提示

![IDE 自动提示](properties.png)

## Example
>https://github.com/abel533/MyBatis-Spring-Boot

## PageHelper
>https://github.com/pagehelper/Mybatis-PageHelper

## Special Configurations
一般情况下，你不需要做任何配置。

Normally, you don't need to do any configuration.

如果需要配置，可以使用如下方式进行配置：

You can config PageHelper as the following:

application.properties:
```properties
pagehelper.propertyName=propertyValue
```
注意 pagehelper 配置，大部分常用参数支持 IDE 自动提示和 kebab-case 风格配置（如 `offset-as-page-num`），
如果自己扩展了分页插件参数，对于无法自动提示的参数，直接使用原始参数名配置即可。

关于可配置的属性请参考 [如何使用分页插件](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md)。

You can configure the properties of the reference here [How to use the PageHelper](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md).

## Interceptor Order

如果你想要控制 拦截器插件的顺序，可以通过下面注解控制：

If you want to control the order in which the interceptor plug-in, you can use the following annotation control:
```java
@AutoConfigureAfter(PageHelperAutoConfiguration.class)
//Or
@AutoConfigureBefore(PageHelperAutoConfiguration.class)
```

## 感谢所有项目贡献者！

<a href="https://github.com/pagehelper/pagehelper-spring-boot/graphs/contributors">
  <img src="https://contributors-img.web.app/image?repo=pagehelper/pagehelper-spring-boot" />
</a>
