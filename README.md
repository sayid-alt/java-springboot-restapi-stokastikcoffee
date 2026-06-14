# Coffee Shop Application

A Spring Boot REST API with database persistence for managing a coffee shop's menu. This project provides endpoints to perform CRUD operations on coffee items with PostgreSQL database support.

## Project Overview

This application serves as a backend service for a coffee shop, allowing users to:
- Retrieve a list of all available coffee items.
- Search for a specific coffee by its unique identifier.
- Add new coffee items to the menu with validation for price and naming.
- Remove coffee items from the menu.

The project follows a standard Spring Boot architecture with a clear separation of concerns between controllers, services, repositories, and models, using JPA for database persistence.

## Features

- **RESTful API**: Clean and intuitive endpoints for menu management.
- **Database Persistence**: Uses PostgreSQL for persistent data storage.
- **Spring Data JPA**: Simplified database operations with repository pattern.
- **Input Validation**: Ensures that coffee names are not blank and prices are positive values.
- **Global Exception Handling**: Centralized error handling for scenarios like "Coffee Not Found".
- **Docker Support**: Easy database setup using Docker Compose.
- **Dependency Injection**: Utilizes Spring's core features for manageable and testable code.

## Directory Structure

The project follows the standard Maven directory layout:

```text
coffeeshop/
├── src/
│   ├── main/
│   │   ├── java/com/stokastik/coffeeshop/
│   │   │   ├── controller/     # REST Controllers for handling HTTP requests
│   │   │   │   └── CoffeeController.java
│   │   │   ├── model/          # JPA Entities representing coffee entities
│   │   │   │   └── Coffee.java
│   │   │   ├── service/        # Business logic layer
│   │   │   │   └── CoffeeService.java
│   │   │   ├── repository/     # Spring Data JPA repository
│   │   │   │   └── CoffeeRepository.java
│   │   │   ├── exception/      # Custom exception classes and global handler
│   │   │   │   ├── CoffeeNotFoundException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   └── CoffeeshopApplication.java # Main application entry point
│   │   └── resources/
│   │       └── application.properties # Application configuration
│   └── test/                   # Test suite for the application
├── pom.xml                     # Maven project configuration
├── docker-compose.yaml         # Docker Compose for PostgreSQL database
├── mvnw                        # Maven wrapper script (Unix)
└── mvnw.cmd                    # Maven wrapper script (Windows)
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven (or use the provided Maven wrapper)
- Docker and Docker Compose (for database setup)

### Setting Up the Database

1. Start the PostgreSQL database using Docker Compose:
   ```bash
   docker-compose up -d
   ```

   This will spin up a PostgreSQL container with the following configuration:
   - Host: `localhost`
   - Port: `5332`
   - Database: `coffeeshop`
   - Username: `heykalsayid`
   - Password: `admin`

### Running the Application

1. Make sure the database is running.
2. Navigate to the project root:
   ```bash
   cd coffeeshop
   ```
3. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080/api/coffees`.
