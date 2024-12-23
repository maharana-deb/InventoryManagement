Spring boot rest api to perform crud operations on the database.
There are mainly two entities - product and user.
User entity is for handling the crud operations on product. 
Used role based authorization with jwt.
In it, only an admin can register a person and can grant his authority as user or admin.
The user can only view the products only, but the admin can perform all crud operations both on the user and product db.
Implemented global exception handling for managing some commonly faced exceptions.
Implemented swagger ui.
