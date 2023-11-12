# Spring Boot Social Media Application

## Overview
This is a straightforward social media application crafted with Spring Boot, Hibernate, and PostgreSQL. It offers essential features such as user registration, posting, following/unfollowing other users, and liking/unliking posts.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Testing](#testing)
- [Code Quality](#code-quality)
- [Conversation Logs](#conversation-logs)
- [Project Feedback](#project-feedback)
- [Contributing](#contributing)
- [License](#license)

## Features
- User registration and authentication
- Create, view, and delete posts
- Follow and unfollow other users
- Like and unlike posts
- Retrieve posts by a specific user and posts from users they are following

## Prerequisites
Make sure you have the following installed before running the application:
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- PostgreSQL Database

## Getting Started
1. **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/your-spring-boot-app.git
    cd your-spring-boot-app
    ```

2. **Build and run the application:**
    ```bash
    mvn spring-boot:run
    ```

3. Access the application at [http://localhost:8080](http://localhost:8080).

## Configuration
- Configure the database connection in `application.properties`.
- Customize other application properties as needed.

## Endpoints
### User Endpoints:
- `POST /users/register`: Register a new user.
- `GET /users`: Get all users.
- `POST /users/{userId}/follow/{followerId}`: Follow a user.
- `POST /users/{userId}/unfollow/{followerId}`: Unfollow a user.

### Post Endpoints:
- `POST /posts`: Create a new post.
- `GET /posts`: Get all posts.
- `GET /posts/user/{userId}`: Get posts by a specific user.
- `GET /posts/user/{userId}/followed`: Get posts by a specific user and their followed users.
- `POST /posts/{postId}/like/{userId}`: Like a post.
- `POST /posts/{postId}/unlike/{userId}`: Unlike a post.

## Testing
Unit tests are available for controllers and services. Run tests with:
```bash
mvn test
```
## Code Quality

Code quality is checked using Checkstyle, PMD, and FindBugs. SonarQube is used for continuous inspection of code quality.
## Conversation Logs

ChatGPT conversation logs are available in the file [chat.log](src/main/resources/chat.log).
Conversation link: https://chat.openai.com/share/c91f2e01-e2f4-4413-91a5-41180eb67d8b

# Project Feedback

- **Was it easy to complete the task using AI?**
    - Absolutely, leveraging AI made the task significantly more straightforward.

- **How long did the task take you to complete?**
    - The task was completed in approximately 1 hour.

- **Was the code ready to run after generation? What did you have to change to make it usable?**
    - The generated code was ready to run; I made minor adjustments to the readme for clarity.

- **Which challenges did you face during completion of the task?**
    - The primary challenge revolved around formulating questions in a manner that AI could understand, leading to satisfactory responses.

## Contributing
Feel free to contribute to the development of this application by opening issues or pull requests.