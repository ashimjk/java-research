# Spring Security Using Database

- H2 Database Authentication
- Access control based on User Role
- Run
	- http://localhost:8082/api/users -- Access to all users and roles
	- http://localhost:8082/api/users/1 -- Only accessible to ADMIN Role
	- http://localhost:8082/api/users/current -- Login user details
- Credential
	- un : admin, pwd : admin, role : ADMIN
	- un : user, pwd : user, role : USER
- Docs
	- https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html
	- http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html
	- https://www.mkyong.com/java8/java-8-optional-in-depth/