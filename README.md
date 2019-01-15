spring-boot-starterx
============================
## 1、spring-boot-starterx-monitor
  自定义 spring-boot starter
>*  Annotation： @Monitor ElementType.METHOD
>*  输出：方法名称；方法参数；执行时间
>*  使用：在Spring boot 项目中直接 maven pom 引入依赖
```
<dependency>
     <groupId>org.windwant.starter.monitor</groupId>
     <artifactId>spring-boot-starter-monitor</artifactId>
     <version>1.0-SNAPSHOT</version>
 </dependency>
```
  >*  然后在需要监控的方法上面注解：@Monitor
