# E-Commerce Shopping Platform

A Spring Boot REST API for a small product catalog with JWT-based authentication --
register, log in, and manage products behind a stateless auth layer.

## Stack

- Java 17, Spring Boot 3.3
- Spring Security + JWT (jjwt)
- Spring Data JPA + H2 (in-memory)
- Bean Validation

## Running it

```bash
mvn spring-boot:run
```

The app starts on `http://localhost:8080` and seeds a few sample products on boot.

## API

| Method | Endpoint             | Auth required | Description                |
|--------|-----------------------|:--------------:|----------------------------|
| POST   | `/api/auth/register`  | No             | Create an account, returns a JWT |
| POST   | `/api/auth/login`     | No             | Log in, returns a JWT       |
| GET    | `/api/products`       | No             | List all products           |
| GET    | `/api/products/{id}`  | No             | Get a single product        |
| POST   | `/api/products`       | Yes            | Create a product            |
| DELETE | `/api/products/{id}`  | Yes            | Delete a product            |

Authenticated requests send `Authorization: Bearer <token>`.

### Example

```bash
curl -X POST localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"email":"me@example.com","password":"password123"}'

curl -X POST localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <token>" \
  -d '{"name":"Desk Lamp","description":"LED, dimmable","price":24.99,"stock":100}'
```

## Project structure

```
src/main/java/com/vamsi/ecommerce/
|---- EcommerceApplication.java
|---- controller/    # REST endpoints
|---- security/      # JWT issuing/validation, Spring Security config
|---- repository/    # Spring Data JPA repositories
|---- model/         # JPA entities
`---- dto/           # Request/response records
```
