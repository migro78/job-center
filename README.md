# Job Center

## 1.Quick start

````docker run -d --name job-center -p 8080:8080  -v $PWD/config:/config -v $PWD/logs:/logs migro78/job-center:v1.0.0````

## 2.Change application.yml
````
spring:
  #数据库配置
  datasource:
    driver-class-name: org.postgresql.Driver
    url: jdbc:postgresql://127.0.0.1:5432/job_center
    username: postgre
    password: postgre

# 连接的zookeeper 地址
job:
  dubbo-regist-url: zookeeper://127.0.0.1:2181

````

## 3.Create db
Find the db init file in  job-center/src/main/resources/db/migration/V20200427__init.sql

## 4.Source address
https://github.com/migro78/job-center