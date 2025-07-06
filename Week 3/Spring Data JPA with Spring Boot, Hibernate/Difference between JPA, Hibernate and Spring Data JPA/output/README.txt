
# JPA vs Hibernate vs Spring Data JPA

##  Comparison Table

| Feature                    | JPA (Java Persistence API)                                | Hibernate                                           | Spring Data JPA                                              |
|----------------------------|------------------------------------------------------------|-----------------------------------------------------|---------------------------------------------------------------|
| Type                       | Specification (Interface/Guideline)                        | ORM Framework (Implementation of JPA)              | Abstraction Framework over JPA Implementations                |
| Purpose                    | Defines how to persist Java objects in DB                  | Provides actual implementation of JPA               | Simplifies data access with less boilerplate code             |
| Implementation             | No direct implementation                                   | Implements JPA                                      | Uses JPA implementations like Hibernate                       |
| Boilerplate Code           | Requires boilerplate code (e.g., EntityManager)            | Needs session management, transaction handling      | Eliminates boilerplate with CRUD interfaces                   |
| Transaction Management     | Needs manual configuration                                 | Manually managed in code                            | Handled automatically via Spring annotations (@Transactional) |
| Querying Support           | Supports JPQL                                               | Supports JPQL + Native SQL + Criteria API           | Supports derived queries, JPQL, Criteria, and native queries  |
| Ease of Use                | Moderate                                                    | Moderate to complex                                 | Easiest and most developer-friendly                           |

---

 Hibernate Example Output

```
Added Employee ID: 1
```

Explanation: The Hibernate method opens a session, starts a transaction, saves an employee, and returns the generated ID. If successful, it prints the employee ID.

---

Spring Data JPA Example Output

Console output from logs:

```
Hibernate: 
    insert 
    into
        employee
        (first_name, last_name, salary) 
    values
        (?, ?, ?)
```

If you add a print statement after saving:
```
Employee saved successfully.
```

Explanation: Spring handles the transaction and repository interaction. Just calling `save(employee)` adds the entity to the DB.

---
