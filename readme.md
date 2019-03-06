# springboot-mybatis

---

## 一、开发前准备
  * 1.1 环境参数
  * 1.2 创建工程
  * 1.3 创建数据库和user用户表
  * 1.4 配置pom文件中的相关依赖
  * 1.5 配置application.properties
  * 1.6 创建用户类Bean
  
## 二、会注解的方式

  * 2.1 Dao层开发
  * 2.2 Service开发
  * 2.3 Controller开发
  * 2.4 启动类
  * 2.5 简单测试
  
## 三、xml方式
  
  * 3.1 xml路径地址
  * 3.2 配置文件的改动路径地址
  
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
  
        > User.java 代码例子：
            >   
                public class User {
                    private String id;
                    private String name;
                    private String age;
                    private String sex;
                }

## 二、会注解的方式
                
  > 2.1 Dao层开发
       
        > UserDao.java 代码例子：
          
   ````
            @Mapper
            public interface UserDao {
            
                /**
                 * 根据名字查询用户信息
                 * @param name
                 * @return
                 */
                @Select("select * from user  where name = #{name}")
                public User findByUserName(@Param("name") String name);
            
            } 
   ````
              
  > 2.2 Service层开发
        
        > UserService.java 代码例子：
                        
   ````
           @Service
           public class UserService {
               @Autowired
               private UserDao userDao;
           
               public User selectUserByName(String name){
                   return userDao.findByUserName(name);
               }
           }
   ````
              
  > 2.3 Controller层开发
  
       > Controller.java 代码例子：
    
   ````    
          @RestController
          @RequestMapping("/user")
          public class UserController {
              @Autowired
              private UserService userService;
          
              @RequestMapping("/query")
              public User testQuery(){
                  return userService.selectUserByName("Daisy");
              }
          }
   ````         
             
                     
  > 2.4 启动类
  
       > DemoApplication.java 代码例子：
        
   ````
          // 此注解标识SprigBoot启动类
                    @SpringBootApplication
                    
                    //此注解是为了找到dao层的包，不加这块注释也可以找到
                    @MapperScan("com.example.demo.dao")
                    public class DemoApplication {
                        
                        public static void main(String[] args) {
                            SpringApplication.run(DemoApplication.class, args);
                        }
                    }  
   ```` 
                   
  > 2.5 简单测试
  
  
  
## 三、xml方式
  
  > 3.1 xml路径地址
  
  ````
    
  ```` 
  > UserMappper.xml
   
  ````
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
              "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
      
      <mapper namespace="com.example.demo.dao.UserDao">
      
          <select id="findUserByName" parameterType="String" resultType="com.example.demo.bean.User">
              SELECT * FROM user WHERE name = #{name}
          </select>
      
      </mapper>
  ````
  
  > 3.2 配置文件的改动路径地址
  
  `mybatis.mapper-locations=classpath:mapper/*.xml`
  
                       
        
      

      