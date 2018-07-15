Book Finder Project
=============
# 1. 실행순서
##1) DB 생성
 host : localhost
 port : 3306
 id : root
 pw : root
 DB : bookFinder
 encoding : utf8_general_ci
 
##2) mvn clean
##3) mvn clean install
##4) target 폴더로 이동
##5) java -jar bookFinder-0.0.1-SNAPSHOT.jar 실행
##6) http://localhost:8080/ 접속

# 2. 사용 기술
##1) Front End
### - jquery, thymeleaf, thymeleaf-extras-springsecurity
##2) Back End
### - Spring Boot 2.0.0, Spring JPA, Spring Security
##3) DB
### - MariaDb 10.2
