# User CRUD REST API with Spring Boot + PostgreSQL + Swagger

This project is a REST API built with Spring Boot that performs CRUD operations on a PostgreSQL database, and exposes API documentation via Swagger UI.

## Features
- CRUD operations (Create, Read, Update, Delete) for managing `User` entities.
- PostgreSQL database hosted on the cloud.
- H2 database for local tests.
- Swagger UI for API documentation and testing.
- JUnit tests for API endpoints.

## Prerequisites

- **Java 11** or higher
- **Maven 3.6** or higher
- **PostgreSQL** (Cloud instance or locally installed)

##  My Cloud Implementation
 - You can try my Implementation on Railway by using this the link Below.
 - https://restapi-production-16b9.up.railway.app/swagger-ui/index.html#/
 - If you encounter an error while accessing my implementation, try reloading the page. The app might take a few seconds to come online because it is in sleep mode.


## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/RAMONBRX/RestApi.git


2. **Database Configuration**:
 - You need to set your Spring Environment Variable to SPRING_PROFILES_ACTIVE=dev to use local H2 database or SPRING_PROFILES_ACTIVE=prd to use PostgreSQL.
2.1 **PostgreSQL Configuration**:
- Below is an example of the `application-prd.yml` file, which is used to configure the Spring Boot application to connect to a PostgreSQL database using environment variables.

    ```yaml
    spring:
        datasource:
            url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
            username: ${PGUSER}
            password: ${PGPASSWORD}
        jpa:
            open-in-view: false
            hibernate:
                ddl-auto: create

- ${PGHOST}, ${PGPORT}, ${PGDATABASE}, ${PGUSER}, and ${PGPASSWORD} are environment variables that need to be set in your system or container.
- hibernate.ddl-auto is set to create but can be adjusted to update, validate, etc.

3. **Swagger UI**:
 - After the application starts, you can access the Swagger UI to explore the API at:
    ```bash
        http://localhost:8080/swagger-ui/index.html

## API Endpoints

Below are the available API endpoints for managing `User` entities.

| HTTP Method | Endpoint               | Description                     | Request Body                      | Response                            |
|-------------|------------------------|----------------------------------|------------------------------------|-------------------------------------|
| `GET`       | `/api/users`           | Retrieve all users               | None                               | List of users (200 OK)              |
| `GET`       | `/api/users/{id}`      | Retrieve a user by ID            | None                               | User details (200 OK) or 404 if not found |
| `POST`      | `/api/users`           | Create a new user                | JSON body with user details        | Created user (201 Created)          |
| `PUT`       | `/api/users/{id}`      | Update an existing user          | JSON body with updated user details| Updated user (200 OK) or 404 if not found |
| `DELETE`    | `/api/users/{id}`      | Delete a user                    | None                               | 204 No Content or 404 if not found |

## Technologies Used

The following technologies are used in this project:

- **Spring Boot**: A framework for building Java-based, enterprise-level web applications and microservices.
- **PostgreSQL**: An open-source relational database system to store and manage user data.
- **Spring Data JPA**: A part of Spring that helps simplify the data access layer by providing ORM (Object-Relational Mapping) for interacting with the database.
- **Hibernate**: A framework used under Spring Data JPA to manage the persistence of Java objects in relational databases.
- **Swagger (Springdoc OpenAPI)**: Provides interactive API documentation via Swagger UI for testing and visualizing API endpoints.
- **Springdoc OpenAPI UI**: Automatically generates Swagger documentation from the code and exposes it via the `/swagger-ui` endpoint.
- **JUnit 5**: A testing framework used for writing unit and integration tests.
- **Gradle**: A powerful build automation tool used for dependency management and building the project.
