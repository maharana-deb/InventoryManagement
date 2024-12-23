1. Spring boot rest api to perform crud operations on the database.
2. There are mainly two entities - product and user.
3. User entity is for handling the crud operations on product. 
4. Used role based authorization with jwt.
5. In it, only an admin can register a person and can grant his authority as user or admin.
6. The user can only view the products only, but the admin can perform all crud operations both on the user and product db.
7. Implemented global exception handling for managing some commonly faced exceptions.
8. Implemented swagger ui.
