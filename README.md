# Spring Boot Tomcat Application

A Spring Boot application configured to be deployed as a WAR file on Apache Tomcat server. This project demonstrates a simple REST API with basic endpoints.

## Prerequisites

- **Java 21** or higher
- **Maven 3.8.0** or higher
- **Apache Tomcat 9.0** or higher (for WAR deployment)
- **Git** (for version control)

## Project Overview

This is a Maven-based Spring Boot project that packages as a WAR file for deployment on Tomcat. The application includes a simple REST controller with sample endpoints.

### Technologies Used

- **Spring Boot 3.2.1** - Application framework
- **Spring Web** - REST API support
- **Java 21** - Programming language
- **Maven** - Build tool
- **Tomcat** - Application server

## Project Structure

```
jenkins-deploy-spring-boot-in-tomcat/
├── pom.xml                                          # Maven configuration
├── .gitignore                                       # Git ignore file
├── README.md                                        # This file
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/app/
    │   │       ├── SpringBootTomcatApplication.java # Main application class
    │   │       └── controller/
    │   │           └── HelloController.java          # REST controller
    │   └── resources/
    │       └── application.properties                # Application configuration
    └── test/
        └── java/                                     # Test files (placeholder)
```

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd jenkins-deploy-spring-boot-in-tomcat
```

### Build the Project

Using Maven, build the WAR file:

```bash
mvn clean package
```

This generates a WAR file at: `target/springboot-tomcat-app-1.0.0.war`

### Run Locally (Development)

You can run the application locally with embedded Tomcat:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### 1. Welcome Endpoint
- **URL:** `GET /`
- **Response:** `Welcome to Spring Boot application deployed on Tomcat!`
- **Example:**
  ```bash
  curl http://localhost:8080/
  ```

### 2. Message Endpoint
- **URL:** `GET /api/message`
- **Response:** `This is a sample Spring Boot API running successfully on Tomcat server.`
- **Example:**
  ```bash
  curl http://localhost:8080/api/message
  ```

## Deployment on Tomcat

### Prerequisites
- Tomcat server installed and running
- CATALINA_HOME environment variable set

### Steps

1. **Build the WAR file:**
   ```bash
   mvn clean package
   ```

2. **Copy WAR file to Tomcat:**
   ```bash
   cp target/springboot-tomcat-app-1.0.0.war $CATALINA_HOME/webapps/
   ```

3. **Start Tomcat:**
   ```bash
   $CATALINA_HOME/bin/startup.sh
   ```

4. **Access the application:**
   - Open browser and navigate to `http://localhost:8080/springboot-tomcat-app/`
   - Or access the API endpoints directly

5. **Check Tomcat logs:**
   ```bash
   tail -f $CATALINA_HOME/logs/catalina.out
   ```

## Configuration

Application settings can be modified in `src/main/resources/application.properties`:

```properties
spring.application.name=springboot-tomcat-app
server.servlet.context-path=/
server.port=8080
logging.level.root=INFO
logging.level.com.example.app=DEBUG
```

**Note:** When deployed on Tomcat, the `server.port` and `server.servlet.context-path` may be overridden by Tomcat configuration.

## Development

### IDE Setup

#### IntelliJ IDEA
1. Open the project
2. Maven dependencies will be automatically downloaded
3. Configure SDK to Java 21

#### Eclipse
1. Open project as Maven project
2. Update Maven project (Alt + F5)
3. Configure JRE to Java 21

#### VS Code
1. Install Extension Pack for Java
2. Open the project folder
3. VS Code will detect and configure automatically

## Building and Testing

### Clean Build
```bash
mvn clean install
```

### Run Tests
```bash
mvn test
```

### Build without Tests
```bash
mvn clean package -DskipTests
```

## Troubleshooting

### Issue: Port 8080 already in use
**Solution:** Change the port in `application.properties` or stop the service using port 8080

### Issue: Java version mismatch
**Solution:** Ensure Java 21 is installed and set as JAVA_HOME
```bash
java -version
export JAVA_HOME=/path/to/java21
```

### Issue: WAR deployment fails on Tomcat
**Solution:** 
- Check Tomcat catalina.out log for errors
- Ensure Tomcat version is 9.0 or higher
- Verify write permissions in CATALINA_HOME/webapps/

## Git Ignore

The `.gitignore` file is configured to ignore:
- Maven build artifacts (`target/`, `*.war`, `*.jar`)
- IDE files (`.idea/`, `.vscode/`, `.classpath`, `.project`)
- OS files (`.DS_Store`, `Thumbs.db`)
- Build files and logs

## Project Artifact Details

- **Artifact ID:** springboot-tomcat-app
- **Version:** 1.0.0
- **Packaging:** WAR
- **Java Version:** 21

## License

This project is licensed under the MIT License - see LICENSE file for details.

## Support

For issues or questions:
1. Check the troubleshooting section
2. Review Tomcat logs in `$CATALINA_HOME/logs/`
3. Check application logs for DEBUG level messages

## Next Steps

- Add more REST endpoints as needed
- Implement database connectivity (JPA/Hibernate)
- Add authentication and security
- Set up CI/CD pipeline for automated deployment
