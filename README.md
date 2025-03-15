Blog Management System

Overview
The Blog Management System is a Spring Boot application that allows users to create, read, update, and delete (CRUD) blog posts. It also features AI-powered text summarization using OpenAI's API. The project follows a structured service-repository pattern and includes proper response handling.

Features
* Blog CRUD Operations (Create, Read, Update, Delete)
* AI-powered blog summarization using OpenAI API
* Centralized response handling with BlogResponse
* Timestamps for blog creation and updates
* RESTful API implementation using Spring Boot
* MySQL database support
* Docker support for easy deployment
* Spring Data JPA for efficient data handling

Technologies Used:
* Java 17
* Spring Boot 3.x
* Spring Data JPA
* PostgreSQL/MySQL
* OpenAI API (ChatGPT)
* Docker


Installation & Setup
Prerequisites:
* Java 17 or later
* Gradle
* MySQL
* OpenAI API Key (for AI-powered summarization)

Clone the Repository
$ git clone https://github.com/your-username/blog-management-system.git
$ cd blog-management-system

Configure Database
Update application.properties in src/main/resources/:
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Add OpenAI API Key
Update application.properties:
openai.api.key=your_openai_api_key

Build and Run the Application
$ ./gradlew clean build
$ ./gradlew bootRun

API Endpoints
Blog Endpoints:

Method                Endpoint                 Description
POST                  /api/blogs              Add a new blog
GET                   /api/blogs              Get all blogs
GET                   /api/blogs/{id}         Get a blog by ID
PUT                   /api/blogs/{id}         Update a blog
DELETE                /api/blogs/{id}         Delete a blog


AI Summarization Endpoint:

Method                Endpoint                   Description
POST                  /api/blogs/summarize       Summarize blog content using AI























