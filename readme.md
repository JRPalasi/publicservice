Public service of subscription system

Uses Open feign clients for communication with email and subscription systems. Not enought time for implementing rest 
of Spring Cloud technologies (Eureka) for services communication, will do on next steps.
Rest API for controller.
SpringDoc for OpenAPI documentation.
Spring security with basic auth. Next step is to implement JWT.

Run separately the email and subscription services. If the ports or passwords are changed, modify the feign clients.
Not running with docker yet :(

Run with maven plugin spring-boot:run.
Unit tests can be run with maven test goal.

Swagger UI
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config