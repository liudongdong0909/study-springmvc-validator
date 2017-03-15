## springMVC 整合 Hibernate Validator 进行数据校验

JAR版本：

     <dependencies>
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
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-rest-webmvc</artifactId>
            <version>2.6.0.RELEASE</version>
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

    </dependencies>

开发环境：
tomcat7 插件运行, jdk 1.7, maven 3.3.9

## 运行案例与结果：

### 第一：直接来个复杂的：POST 提交 JSON 多实体嵌套校验

商品类：
![](http://i.imgur.com/nCZnUju.png)

商品详情类：
![](http://i.imgur.com/FNDjlef.png)

controller：
![](http://i.imgur.com/hdNGvHH.png)

postman测试：

提交的数据：
![](http://i.imgur.com/cR4JnWP.png)

验证结果：

![](http://i.imgur.com/S6RmjU1.png)

### 第二：POST 提交 x-www-form-urlencoded 多实体嵌套校验

controller:
![](http://i.imgur.com/nsqwDYE.png)

postman 测试：

提交的数据：
![](http://i.imgur.com/mXcaN52.png)

验证的结果：

![](http://i.imgur.com/gZEjEZF.png)

### 第三： GET 提交 多实体嵌套校验
controller: 

这里肯定验证的是查询一类的GET请求(主要是多个参数的查询封装成对象)，此处截图只是为了说明问题。
![](http://i.imgur.com/NIyS75z.png)

postman 测试：

提交的数据：
![](http://i.imgur.com/1ByZBPp.png)

验证的结果：

![](http://i.imgur.com/aYmGRtT.png)