# Employee Management System

This is a Spring Boot application for managing employees. It provides CRUD operations for employee data and basic security using Spring Security.

## Features

- Create, Read, Update, and Delete (CRUD) operations for employees
- RESTful API endpoints
- Basic security with role-based access control
- Integration with a relational database using JPA and Hibernate

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate
- REST API
- Maven

## Requirements

- Java 17 or higher
- Maven 3.6 or higher
- MySQL or any other relational database

## Setup Instructions

1. **Clone the repository**

   ```bash
   git clone https://github.com/rakey09/employee-management-system.git
   cd employee-management-system
   ```

2. **Configure the database**

   Update the `application.properties` file with your database configuration:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. **Create the database tables**

   Run the following SQL scripts to create the necessary tables:

   ```sql
   CREATE TABLE employee (
       employee_id INT AUTO_INCREMENT PRIMARY KEY,
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       email VARCHAR(50),
       salary DOUBLE
   );

   CREATE TABLE members (
       user_id VARCHAR(50) PRIMARY KEY,
       pw VARCHAR(100),
       active BOOLEAN
   );

   CREATE TABLE roles (
       user_id VARCHAR(50),
       role VARCHAR(50),
       FOREIGN KEY (user_id) REFERENCES members(user_id)
   );
   ```

4. **Build the project**

   ```bash
   mvn clean install
   ```

5. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

- **GET /api/employees** - Get all employees (ROLE_EMPLOYEE)
- **GET /api/employees/{id}** - Get an employee by ID (ROLE_EMPLOYEE)
- **POST /api/employees** - Add a new employee (ROLE_MANAGER)
- **PUT /api/employees** - Update an employee (ROLE_MANAGER)
- **DELETE /api/employees/{id}** - Delete an employee (ROLE_ADMIN)

## Security Roles

- **ROLE_EMPLOYEE** - Can view employee details
- **ROLE_MANAGER** - Can add and update employee details
- **ROLE_ADMIN** - Can delete employee details

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

- Spring Boot
- Spring Data JPA
- Spring Security

## Author

Rakesh Vuyyuru

