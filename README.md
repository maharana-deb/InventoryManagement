This project is a Spring Boot REST API designed for managing products and users with role-based access control. It demonstrates CRUD operations on a database with global exception handling, JWT-based authentication, and Swagger UI for API documentation.

Features

CRUD Operations:

Manage products (add, update, delete, view) with ProductController.
Manage users (register, update, delete, view) with UserController.

Role-Based Authorization:

Regular users can only view products.
Admin users can perform CRUD operations on both users and products.

JWT Authentication:

Secure API endpoints using JSON Web Tokens.
Only an admin can register new users and assign roles (admin or user).

Global Exception Handling:

Handle common exceptions globally using GlobalExceptionHandler.

Swagger UI:

For API documentation.

Spring Boot Validation:

Validation with spring-boot-starter-validation.
