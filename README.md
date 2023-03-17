### Restful API with Spring Boot

---

### Database: H2
* Config for h2 database in file application.properties with port 8083
```
server.port=8083

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
# default path: h2-console
spring.h2.console.path=/h2-ui

```
* Use url http://localhost:8083/h2-ui/ to access h2 database

This is example for screen you will see when you login into H2 database

![Untitled2](https://user-images.githubusercontent.com/93864928/225974346-9fa88291-f7cc-4331-9a93-b63a988c1769.png)


### Tools: Use Postman to test API

* Test for @PostMapping

Send request to http://localhost:8083/api/tutorials with content

```
{
    "description": "Tutorial 1",
    "title": "Title 1"
}
```

![Untitled3](https://user-images.githubusercontent.com/93864928/225975312-69c7b908-5c8a-4a0e-8f6c-76ed6adeeb51.png)



