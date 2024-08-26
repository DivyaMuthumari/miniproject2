Medical Appointment System
Introduction
The Medical Appointment System is a Spring Boot application that allows users to manage medication-related operations,It includes functionalities to create, read, update, and delete Operations on medication data. The project also integrates Swagger (OpenAPI) for interactive API documentation.

Table of Contents
Technologies Used
Prerequisites
Project Setup
Configuration
Running the Application
API Documentation
API Endpoints
Technologies Used
Java: Programming language.
Spring Boot: Framework for building Java applications.
Spring Data JPA: For database access and ORM.
Thymeleaf: Template engine for rendering web pages.
Swagger (OpenAPI): For API documentation.
Maven: Build automation tool.
MySQL: Database.
HTML: Markup language for creating web pages.
CSS: Style sheet language for designing web pages.
Prerequisites
Java 8 or higher
Maven 3.6.0 or higher
Git (optional)
Project Setup
Clone the Repository (if applicable):

git clone [https://github.com/rshc07/Spring-Medical-Appointment-System.git]
cd Medical-Appointment-System
Import the Project into Your IDE:

Open your IDE (e.g., IntelliJ IDEA, Eclipse).
Import the project as a Maven project.
Build the Project:

mvn clean install
Configuration
Application Properties:

Open src/main/resources/application.properties and configure the database settings as per your environment:

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/hospitalmanagement_db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Msdhoni1997*
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server Configuration
server.port=8080
Ensure you have a MySQL database running with the name hospitalmanagement_db and update the username and password accordingly.

Running the Application
Run the Application:

You can run the application using your IDE or via the command line:

mvn spring-boot:run
The application will start on the port configured in application.properties (default is 8080).

Access the Application:

Open your web browser and navigate to http://localhost:8080.

