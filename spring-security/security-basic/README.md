# Spring Security HTTP Basic

- Default authentication provided by Spring
	- username : user
	- password : will be given while booting the project
	- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-security.html
- InMemory authentication
- Access control based on User Role
- Run
	- http://localhost:8082/api/users -- Access to all users and roles
	- http://localhost:8082/api/users/1 -- Only accessible to ADMIN Role
	- http://localhost:8082/api/users/current -- Login user details
- Credential
	- un : admin, pwd : admin, role : ADMIN
	- un : user, pwd : user, role : USER