## springMVC 整合 Hibernate Validator 进行数据校验

JAR版本：
```
    <dependency>
   
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
       <scope>test</scope>
   </dependency>

   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-log4j12</artifactId>
       <version>1.7.9</version>
   </dependency>


   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>4.2.5.RELEASE</version>
   </dependency>

   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-core</artifactId>
       <version>4.2.5.RELEASE</version>
   </dependency>

   <dependency>
       <groupId>org.hibernate</groupId>
       <artifactId>hibernate-validator</artifactId>
       <version>5.1.3.Final</version>
   </dependency>

   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>2.4.2</version>
   </dependency>

   <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>servlet-api</artifactId>
       <version>2.5</version>
       <scope>provided</scope>
   </dependency>
       
```
开发环境：
tomcat7 插件运行, jdk 1.7, maven 3.3.9

注意点：
本案例只控制 post 
