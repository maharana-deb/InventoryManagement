This project is a Spring Boot REST API designed for managing products and users with role-based access control. It demonstrates CRUD operations on a database with global exception handling, JWT-based authentication, and Swagger UI for API documentation.

Features:-

CRUD Operations:
Managing products (add, update, delete, view) with ProductController.
Managing users (register, update, delete, view) with UserController.

Role-Based Authorization:
Regular users can only view products.
Admin users can perform CRUD operations on both users and products.

JWT Authentication:
Secured API endpoints using JSON Web Tokens.
Only an admin can register new users and assign roles (admin or user).

Global Exception Handling:
Handled common exceptions globally using GlobalExceptionHandler.

Swagger UI:
Used For API documentation.

Spring Boot Validation:
Used for validating entity variables while sending values.
