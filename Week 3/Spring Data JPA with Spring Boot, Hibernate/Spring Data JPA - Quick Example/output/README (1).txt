
Spring Data JPA Hands-on 1 - Quick Example
==========================================

Overview:
---------
This project demonstrates a quick example of Spring Data JPA using the "orm-learn" project.
- Software pre-requisites:
  - MySQL Server 8.0, MySQL Workbench 8
  - Eclipse IDE for Enterprise Java Developers
  - Maven 3.6.2
- The project is created using Spring Initializr with:
  - Group: com.cognizant
  - Artifact Id: orm-learn
  - Dependencies: Spring Boot DevTools, Spring Data JPA, MySQL Driver
- The application is configured via Maven and application.properties for logging and database connection.

Project Structure:
------------------
- **src/main/java**: Contains application code.
  - `OrmLearnApplication.java`: Main application class with the `main()` method.
  - **com.cognizant.ormlearn.model**: Contains entity classes (e.g., `Country.java`).
  - **com.cognizant.ormlearn.repository**: Contains repository interfaces (e.g., `CountryRepository.java`).
  - **com.cognizant.ormlearn.service**: Contains service classes (e.g., `CountryService.java`).
- **src/main/resources**: Contains configuration files, particularly `application.properties`.
- **src/test/java**: Contains test code for the application.

Key Components:
---------------
1. **OrmLearnApplication.java**
   - Annotated with `@SpringBootApplication`.
   - Logs entry into the main method using SLF4J.
   - Retrieves the `CountryService` bean from the application context.
   - Calls `testGetAllCountries()` to fetch and log all countries.
2. **Country.java**
   - Maps to the `country` table in the database using `@Entity` and `@Table`.
   - Uses `@Id` and `@Column` to map primary key and columns.
3. **CountryRepository.java**
   - Extends `JpaRepository<Country, String>` for CRUD operations.
   - Annotated with `@Repository`.
4. **CountryService.java**
   - Annotated with `@Service`.
   - Autowires `CountryRepository` and defines `getAllCountries()` method marked with `@Transactional`.

Database Setup:
---------------
- Create a MySQL schema named `ormlearn` and execute the following SQL commands:

```
CREATE SCHEMA IF NOT EXISTS ormlearn;
USE ormlearn;

CREATE TABLE country (
    co_code VARCHAR(2) PRIMARY KEY,
    co_name VARCHAR(50)
);

INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');
```

Expected Console Output:
------------------------
When running the application, the console logs should include output similar to the following:

```
06-07-25 21:42:01.123 main       INFO  com.cognizant.ormlearn.OrmLearnApplication         main               16 Inside main
06-07-25 21:42:01.456 main       INFO  com.cognizant.ormlearn.OrmLearnApplication         testGetAllCountries  21 Start
06-07-25 21:42:01.789 main       DEBUG com.cognizant.ormlearn.OrmLearnApplication         testGetAllCountries  23 countries=[Country [code=IN, name=India], Country [code=US, name=United States of America]]
06-07-25 21:42:01.790 main       INFO  com.cognizant.ormlearn.OrmLearnApplication         testGetAllCountries  24 End
```

Steps to Run the Application:
-----------------------------
1. Import the project into Eclipse as an existing Maven project.
2. Ensure that the MySQL schema "ormlearn" is created and the `country` table is populated with data.
3. Build the project using the Maven command:
   ```
   mvn clean package -Dhttp.proxyHost=proxy.cognizant.com -Dhttp.proxyPort=6050 -Dhttps.proxyHost=proxy.cognizant.com -Dhttps.proxyPort=6050 -Dhttp.proxyUser=123456
   ```
4. Run the `OrmLearnApplication.java` main class. 
5. Verify the logs in the console to see if the `main()` method is called and if data from the database is retrieved successfully.

Conclusion:
-----------
This hands-on example demonstrates the use of Spring Data JPA for retrieving data from a MySQL database in a Spring Boot application. The logged output verifies that the application successfully fetches records from the `country` table, providing a practical example of how to integrate Spring Data JPA in a real-world project.
