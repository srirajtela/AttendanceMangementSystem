# Attendance Management System

## Project Overview

The **Attendance Management System** is a web application designed to help educational institutions and organizations manage and track attendance efficiently. It supports multiple user roles (Admin, Faculty, and Student) and provides functionalities like adding, updating, and viewing attendance records.

## Features

- **Admin Role**:
  - Manage user roles and attendance records.
  - CRUD operations for Admin, Faculty, and Student data.

- **Faculty Role**:
  - Record attendance for students as Present or Absent.
  - View attendance records based on date and student details.

- **Student Role**:
  - View individual attendance records and track attendance status.

## Technologies Used

- **Java**: Backend logic implementation.
- **Spring Boot**: Framework for building the application.
- **Spring MVC**: Model-View-Controller architecture.
- **Spring Data JPA**: For database interaction.
- **MySQL**: Relational database management.
- **Thymeleaf**: Template engine for rendering dynamic HTML pages.
- **Maven**: Dependency management and build tool.
- **Tomcat**: Embedded server for deploying and running the application.

## Project Setup

### Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher
- MySQL Server


## Database configuration(application properties)
spring.datasource.url=jdbc:mysql://localhost:3306/attendance_db?createDatabaseIfNotExist=true

spring.datasource.username=your_username

spring.datasource.password=your_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


## Hibernate settings
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

## Thymeleaf Configuration
spring.thymeleaf.enabled=true

spring.thymeleaf.prefix=classpath:/templates/

spring.thymeleaf.suffix=.html

## Server Configuration
server.port=8080

## Logging Configuration
logging.level.org.springframework=INFO
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE


## Project Structure

| Directory/File                                           | Description                                          |
|---------------------------------------------------------|------------------------------------------------------|
| `attendance-management-system/`                         | Root directory of the project                        |
| `├── src/`                                             | Source code directory                                 |
| `│   ├── main/`                                       | Main application code                                 |
| `│   │   ├── java/`                                   | Java source files                                     |
| `│   │   │   └── com/example/attendance/`             | Package for the attendance application                |
| `│   │   │       ├── controller/`                     | Contains all controller classes                       |
| `│   │   │       ├── model/`                          | Contains entity classes                              |
| `│   │   │       ├── repository/`                     | Contains JPA repository interfaces                    |
| `│   │   │       ├── service/`                        | Contains service layer classes                        |
| `│   │   │       └── AttendanceManagementSystemApplication.java` | Main application class                          |
| `│   │   ├── resources/`                              | Resources directory                                   |
| `│   │   │   ├── static/`                             | Contains static files (CSS, JS, images)             |
| `│   │   │   ├── templates/`                          | Contains Thymeleaf HTML templates                    |
| `│   │   │   └── application.properties`              | Application configuration file                        |
| `│   └── test/`                                       | Contains test classes                                |
| `└── pom.xml`                                         | Maven configuration file                              |



## Usage

### Admin
- Manage user records and attendance data.
- Navigate to `/admin/list` to view all admins.

### Faculty
- Record attendance for students.
- Navigate to `/attendance/mark` to mark attendance.

### Student
- View personal attendance records.
- Navigate to `/student/attendance` to check attendance status.







