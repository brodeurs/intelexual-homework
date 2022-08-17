## Projects App
Spring boot microservice using JPA. Following assignment specifications, three entities were created, Project, File, and User. The assignment specification for entity relationships has been captured in an [ERD](doc/projects-app-erd.jpg)

### Use of DTOs
Jackson FasterXML stackoverflow events caused by circular Entity references in the Many-to-one and Many-to-many relationships required the usage of DTOs to wrap the entity exposure to the REST endpoints interface. I tried the @JsonIgnore annotation on the relationship declarations, however, only DTO mappings solved the issue.

### Paging/Sorting
The Project repository has the annotations required for paging, however, due to the React app not yet implementing this, they fall back to the defaults.

### Postgresql database
1. My local environment is setup with Postgresql 9.x
2. Database configuration in application.properties uses a database named 'project_db'
3. Initial table creation was established using hibernate.ddl-auto 'CREATE' setting, then set to 'UPDATE' for testing. If you want to execute this service, you can do the same.
4. A [SoapUI project file](SoapUI/REST-Project-1-soapui-project.xml) is included that contains a POST method for creating Project and related entities. There are get methods for several entities as well.

### CORS
The CORS configuration in the MvcConfig component is set to wildcard settings just for expediency.

### Unit Tests
By no means comprehensive, the ProjectDtoTest demonstrates the use of the Spock unit testing framework, which by means of its DSL, is quite readable and quickly implemented.

### Spring Boot Tests
Again, not comprehensive, but shows the ability to test controller endpoints.
