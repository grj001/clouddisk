云盘系统业务需求
1.上传文件
2.下载文件
3.文件管理：删除文件、重命名
4.目录管理
5.回收站
7.移动文件
8.分享文件
9.用户登录注册管理
10.好友

设计数据模型(powerdesigner+mysql)

springmvc+spring+mybatis
springmvc接受并且处理用户的请求，并将请求的结果以html或者json的方式返回给用户。它是一个MVC框架，用来控制与用户的交互逻辑过程，即用来控制前端交互
，V是指视图，展现给用户的可见界面，C是控制器，即对什么样的请求返回什么样的V视图，M是数据，即C和V之间交互的数据。
spring是一个代码解耦工具同时也是对象管理容器，IOC实现容器管理和代码解耦，同时AOP面向切面的编程模型可以简化我们的代码。
mybatis orm,对象和数据库映射框架，它将数据库中的表映射成java中的类，将表的字段映射成java类的属性，表中的每一条记录映射成java类的一个对象，我们可以
在java代码里通过对对象的操作来完成对数据库的操作。

框架集成的好处
spring集成mvc框架，它能够接受并且负责mvc中的c层（springmvc的controller类或者struts中的action类）的实例化过程，以及c层依赖的service层的对象自动注入过程
另外spring还可以将web应用的后台分成servcie层和dao层，service负责业务逻辑，dao只负责数据库操作，使各层之间自动依赖注入实现代码解耦
spring集成mybatis框架，首先它可以负责mybatis对数据库的操作即dao层和service层之间的实例管理以及依赖注入，更重要是，spring可以接管mybatis的事务，这样可以
使我们的编程不用考虑事务的开启和提交，一般情况下事务是被添加在servcie层。


1.创建maven项目，选择maven-archetype-webapp模板
2.修改build path中的jdk----选中本地的jdk配置
3.修改web.xml的头信息，改成较新的版本，替换前两行内容为：
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
4.添加servlet-api依赖
5.添加框架依赖
  <!-- 添加springmvc，因为它依赖于spring所以会自动添加spring依赖 -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-webmvc</artifactId>
	    <version>4.3.7.RELEASE</version>
	</dependency>
	<!-- 添加mybatis依赖 -->
	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis</artifactId>
	    <version>3.4.1</version>
	</dependency>
	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis-spring</artifactId>
	    <version>1.3.1</version>
	</dependency>
	<!-- 添加动态代理库的依赖 -->
	<dependency>
	    <groupId>org.aspectj</groupId>
	    <artifactId>aspectjweaver</artifactId>
	    <version>1.8.10</version>
	</dependency>
	<!-- 添加spring 管理实务依赖库 -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-tx</artifactId>
	    <version>4.3.7.RELEASE</version>
	</dependency>
	<!-- 添加spring jdbc数据库处理依赖库 -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-jdbc</artifactId>
	    <version>4.3.7.RELEASE</version>
	</dependency>
	<!-- 添加dbcp数据源依赖 -->
	<dependency>
	    <groupId>commons-dbcp</groupId>
	    <artifactId>commons-dbcp</artifactId>
	    <version>1.4</version>
	</dependency>
	<!-- springmvc json返回数据转换依赖 -->
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-core</artifactId>
	    <version>2.8.6</version>
	</dependency>
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.8.6</version>
	</dependency>
	<!-- springmvc 文件上传依赖commons-fileupload -->
	<dependency>
	    <groupId>commons-fileupload</groupId>
	    <artifactId>commons-fileupload</artifactId>
	    <version>1.3.2</version>
	</dependency>
	<!-- 添加数据库驱动依赖 -->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>5.1.39</version>
	</dependency>
6.将spring和springmvc引入到web项目中
<!-- 配置spring的配置文件路径参数 -->
  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>classpath:spring-*.xml</param-value>
  </context-param>
  <!-- 引入spring到项目中 -->
  <listener>
  	<description>get spring in the project</description>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  <!-- 防止spring内存溢出监听器 -->
  <listener>
  	<listener-class>org.springframework.web.util.IntrospectorCleanupListener</listener-class>
  </listener>
  <!-- 引入springmvc框架 -->
  <servlet>
  	<servlet-name>springMVCServlet</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>classpath:springmvc.xml</param-value>
  	</init-param>
  	<load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
  	<servlet-name>springMVCServlet</servlet-name>
  	<url-pattern>/</url-pattern>
  </servlet-mapping>

7.配置spring
8.配置springmvc
9.配置mybatis


























过滤器是专门过滤请求的
1.写一个类型实现javax.servlet.Filter接口
  实现接口的init、doFilter、destroy
  在doFilter里面实现过滤的过程
  chain.doFilter
public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain){

	xxxxxxxxxxxxx;
	xxxxxxxxxxxxxxxxxxxxxxxxx;
	xxxxxxxxxxxxxxxxxxxxxxxxx
	chain.doFilter
	yyyyyyyyyyyyyyyyyyyyyyyyy;
	yyyyyyyyyyyyyyyyyyyyyyyy;

}
2.在web.xml把自定义的filter定义成一个Filter

3.配置filter-mapping


spring mvc拦截器的实现
1.定义一个类，实现HandlerInterceptor接口
2.  preHandle        请求进入controller方法之前会被调用
    postHandle       请求在controller方法被执行之后会被调用
    afterCompletion  请求在返回客户端之前会被调用
3.将interceptor配置到springmvc的配置文件中<mvc:intercetpros>标签配置



bug修复
1.注册用户，检查用户名重复




index页面展现用户根目录下的所有文件或文件夹


container 一个页面一个container的div
row 页面上的每一行是一个row
每个row里面col-sm-6 col-sm-6


