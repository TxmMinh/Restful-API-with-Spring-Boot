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

! Important: H2 database is a memory database so all data which is save in this database will be deleted when you turn off server.

### Tool: Use Postman to test API

* Test for @PostMapping

Use method POST and send request to http://localhost:8083/api/tutorials with content

```
{
    "description": "Tutorial 1",
    "title": "Title 1"
}
```

![Untitled3](https://user-images.githubusercontent.com/93864928/225975312-69c7b908-5c8a-4a0e-8f6c-76ed6adeeb51.png)

Data will be saved in database

![Untitled5](https://user-images.githubusercontent.com/93864928/225976982-d79ca3da-6c1c-4dc9-bba6-a94acc930c8a.png)

* Test for @GetMapping

Use method GEST send request to http://localhost:8083/api/tutorials

![Untitled4](https://user-images.githubusercontent.com/93864928/225975972-440ad6bf-99d4-49c5-b27d-b6634115d629.png)

* Test for @PutMapping

Use method PUT send request to http://localhost:8083/api/tutorials/{id} - {id} which is ID you when to update

![Untitled6](https://user-images.githubusercontent.com/93864928/225977581-f154eb96-3779-48e5-8dd3-c8fccb732eef.png)

* Test for @DeleteMapping

Use method DELETE send request to http://localhost:8083/api/tutorials/{id} - {id} which is ID you when to delete

![Untitled7](https://user-images.githubusercontent.com/93864928/225977827-c9b98d43-7531-4f34-9172-4becd02f1189.png)

And now data will be deleted in database

![Untitled2](https://user-images.githubusercontent.com/93864928/225974346-9fa88291-f7cc-4331-9a93-b63a988c1769.png)
