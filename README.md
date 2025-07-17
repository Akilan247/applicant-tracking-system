# applicant-tracking-system
# Applicant Tracking System (ATS) - Backend

This is the backend implementation of a simple Applicant Tracking System built using Spring Boot. It handles user authentication, job posting, application tracking, and resume storage using RESTful APIs and follows clean architecture practices.

Tech Stack :

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- JWT (JSON Web Tokens)

 Features :

- User registration and login (JWT-based authentication)
- Admin and user role-based access control
- Job posting and management
- Resume upload and storage (local/file or database)
- Apply for jobs
- Application status management
- Global exception handling with standardized responses
- DTO-based request and response handling

Folder Structure :

src/
├── controller/
├── service/
├── dto/
├── model/
├── repository/
├── config/
└── exception/

API Testing :

- Use Postman or Swagger UI (if enabled)
- Authenticate using /authenticate
- Register users using /api/users/register
- Explore job, application, and resume endpoints

Future Enhancements :

* Frontend (HTML + Bootstrap or React)
* Email notifications
* Pagination & filtering on job listings
* Resume parsing & scoring
