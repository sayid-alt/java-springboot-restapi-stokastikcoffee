# Coffee Shop Application

A simple Spring Boot REST API for managing a coffee shop's menu. This project provides endpoints to perform CRUD operations on coffee items.

## Project Overview

This application serves as a backend service for a coffee shop, allowing users to:
- Retrieve a list of all available coffee items.
- Search for a specific coffee by its unique identifier.
- Add new coffee items to the menu with validation for price and naming.
- Remove coffee items from the menu.

The project follows a standard Spring Boot architecture with a clear separation of concerns between controllers, services, and models.

## Features

- **RESTful API**: Clean and intuitive endpoints for menu management.
- **Input Validation**: Ensures that coffee names are not blank and prices are positive values.
- **Global Exception Handling**: Centralized error handling for scenarios like "Coffee Not Found".
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
│   │   │   ├── model/          # Data models representing coffee entities
│   │   │   │   └── Coffee.java
│   │   │   ├── service/        # Business logic layer
│   │   │   │   └── CoffeeService.java
│   │   │   ├── exception/      # Custom exception classes and global handler
│   │   │   │   ├── CoffeeNotFoundException.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   └── CoffeeshopApplication.java # Main application entry point
│   │   └── resources/
│   │       └── application.properties # Application configuration
│   └── test/                   # Test suite for the application
├── pom.xml                     # Maven project configuration
├── mvnw                        # Maven wrapper script (Unix)
└── mvnw.cmd                    # Maven wrapper script (Windows)
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven (or use the provided Maven wrapper)

### Running the Application
1. Clone the repository.
2. Navigate to the project root:
   ```bash
   cd coffeeshop
   ```
3. Run the application using Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080/api/coffees`.
