# 使用SpringMVC搭配maven重写webTest项目，旨在熟悉该框架

* 基础Java web配置
1. 首先创建一个由maven管理的Java web项目；
2. 在pom.xml文件中添加servlet的依赖包；
3. 建好的项目中没有resources文件夹，新建一个标记为resources root；
4. 在java文件夹中创建需要的包，我这边分为model、controller、mapper、service；
5. 此时可以配置tomcat，运行后能看到页面了；

* spring配置
1. 在pom.xml文件中加入spring的依赖包；
2. 创建spring的配置文件，我这边叫spring-mvc.xml；
3. 在web.xml中配置好dispatcherServlet，在其中指定要加载的配置文件；
4. 此时可以建一个controller文件，运行项目，在浏览器中能通过controller中配置的路径访问页面了；

* 整合mybatis
1. 在pom.xml中引入mybatis和jdbc的依赖包；
2. 建一个jdbc.properties文件，配置好数据库信息；
3. 建一个mybatis的配置文件供spring使用，这边叫spring-mybatis.xml，在里面配置mybatis的内容；
4. 建一个mybatis的配置文件，这边叫mybatis-config.xml，配置mybatis使用的信息；
5. 接下去创建entity.java、mapper.xml、mapper.java、service.java、controller.java;
6. 大功告成。