# springboot-mybatis

---

## 一、开发前准备

  * 1.1 环境参数
  * 1.2 创建工程
  * 1.3 创建数据库和user用户表
  * 1.4 配置pom文件中的相关依赖
  * 1.5 配置application.properties
  * 1.6 创建用户类Bean
  
## 一、开发前准备

  > 1.1 环境参数
  * 开发工具：idea
  * 基础工具：Maven+jdk8
  * 所用技术：springboot+mybatis
  * springboot版本：2.1.3
  
  > 1.2 创建工程
  
  创建一个基本的SpringBoot项目，参考一下连接。
  https://blog.csdn.net/qq_34337272/article/details/79563606
  https://blog.csdn.net/qq_39505065/article/details/81568056
  
  > 1.3 创建用户表
  
  * 用户id，姓名，年龄 如下图所示：
  
     |id|name|age|
     |:-:|:-:|:-:|
     |1|张三|15|
     |2|李四|16|
     |3|王五|17|
     
  * 建表语句：
  create table 'user'(
    'id' int(13) NOT NULL AUTO_INCREMENT COMMENT '主键'
   )
   
   
  > 1.4 配置pom文件中的相关依赖
  
          <dependency>
              <groupId>org.apache.commons</groupId>
              <artifactId>commons-lang3</artifactId>
              <version>3.4</version>
          </dependency>
  
          <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-core</artifactId>
          </dependency>
  
          <dependency>
              <groupId>com.fasterxml.jackson.core</groupId>
              <artifactId>jackson-databind</artifactId>
          </dependency>
  
          <dependency>
              <groupId>com.fasterxml.jackson.datatype</groupId>
              <artifactId>jackson-datatype-joda</artifactId>
          </dependency>
  
          <dependency>
              <groupId>com.fasterxml.jackson.module</groupId>
              <artifactId>jackson-module-parameter-names</artifactId>
          </dependency>
          <!-- 分页插件 -->
          <!-- alibaba的druid数据库连接池 -->
          <dependency>
              <groupId>com.alibaba</groupId>
              <artifactId>druid-spring-boot-starter</artifactId>
              <version>1.1.9</version>
          </dependency>
          <!--添加依赖结束-->
     
  > 1.5 配置application.properties
   
      server.port=8333
      spring.datasource.url=jdbc:mysql://127.0.0.1:3306/erp?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8
      spring.datasource.username=root
      spring.datasource.password=root
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  > 1.6 创建用户类Bean
      User.java 
      
      (```)
      
      public class User {
      
          private String id;
      
          private String name;
      
          private String age;
      
          private String sex;
      }
      
      (```)
