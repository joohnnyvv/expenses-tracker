# Expense Tracker API

## Overview
This API is designed for tracking user expenses. It provides endpoints for registering and logging in users, and managing expenses. The main functionalities include adding expenses and retrieving a user's expenses.

## Table of Contents
- [Overview](#overview)
- [Table of Contents](#table-of-contents)
- [Endpoints](#endpoints)
  - [User Endpoints](#user-endpoints)
    - [Register a User](#register-a-user)
    - [Login a User](#login-a-user)
  - [Expense Endpoints](#expense-endpoints)
    - [Add an Expense](#add-an-expense)
    - [Get User Expenses](#get-user-expenses)
- [Models](#models)
  - [User](#user)
  - [Expense](#expense)
  - [LoginRequest](#loginrequest)
  - [UserDTO](#userdto)
- [Setup](#setup)
- [Notes](#notes)

## Endpoints

### User Endpoints

### Register a User
**Endpoint:** `POST /api/v1/user/register`

**Request Body:**
```json
{
  "name": "John",
  "surname": "Smith",
  "email": "example@mail.com",
  "password": "password",
  "currency": 20, // Currency id from currencies table
  "monthlyIncome": 4500
}
```

**Response:**
- **200 OK:** User registered successfully
- **400 Bad Request:** Error message

### Login a User
**Endpoint:** `POST /api/v1/user/login`

**Request Body:**
```json
{
  "email": "example@mail.com",
  "password": "password"
}
```

**Response:**
- **200 OK:** UserDTO object
- **401 Unauthorized:** Error message

### Expense Endpoints

### Add an Expense
**Endpoint:** `POST /api/v1/expenses/addExpense`

**Request Body:**
```json
{
  "userId": 1,
  "amount": 2000,
  "categoryId": 1, // id of category from categories table
  "description": "First expense"
}
```

**Response:**
- **200 OK:** Expense object with the current date and time

### Get User Expenses
**Endpoint:** `GET /api/v1/expenses/{userId}`

**Response:**
- **200 OK:** List of Expense objects
- **204 No Content:** No expenses found

### Get User Expenses By Day
**Endpoint:** `POST /api/v1/expenses/getExpensesByDay`

**Request Body:**
```json
{
  "userId": 1,
  "date": "2024-06-17"
}
```

**Response:**
- **200 OK:** List of Expense objects
- **204 No Content:** No expenses found
- 
### Get User Expenses By Month
**Endpoint:** `POST /api/v1/expenses/getExpensesByMonth`

**Request Body:**
```json
{
  "userId": 1,
  "date": "2024-06"
}
```

**Response:**
- **200 OK:** List of Expense objects
- **204 No Content:** No expenses found

### Get User Expenses By Year
**Endpoint:** `POST /api/v1/expenses/getExpensesByYear`

**Request Body:**
```json
{
  "userId": 1,
  "date": "2024"
}
```

**Response:**
- **200 OK:** List of Expense objects
- **204 No Content:** No expenses found

## Models

### User
```java
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String currency;
    
    // Getters and setters
}
```

### Expense
```java
public class Expense {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private LocalDateTime date;
    private Long categoryId;
    private String description;
    
    // Getters and setters
}
```

### LoginRequest
```java
public class LoginRequest {
    private String email;
    private String password;
    
    // Getters and setters
}
```

### UserDTO
```java
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String currency;
    
    // Getters and setters
}
```

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-repo/expense-tracker.git
   ```

2. **Navigate to the project directory:**
   ```sh
   cd expense-tracker
   ```

3. **Install dependencies:**
   ```sh
   mvn install
   ```

4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

5. **Access the API documentation:**
    - API endpoints can be tested using tools like Postman or cURL.

## Notes
- Ensure your database is properly configured in `application.properties`.
- Default port for the API is `8080`, and it can be accessed via `http://localhost:8080/api/v1/`.
