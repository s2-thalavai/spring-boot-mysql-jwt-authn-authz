# spring-boot-mysql-jwt-authn-authz
Spring Boot MySQL JWT Security Authentication and Authorization

Common Actuator Endpoints

Spring Boot Actuator provides a variety of built-in endpoints. Below are some of the most commonly used ones:

- /actuator/health: Displays the health status of the application.
- /actuator/info: Displays arbitrary application information.
- /actuator/metrics: Shows ‘metrics’ information for the current application.
- /actuator/env: Displays properties from the `Environment`.
- /actuator/beans: Displays a complete list of all Spring beans in your application.


Example: Health Endpoint

The health endpoint provides basic information about the application’s health. To access it, navigate to `/actuator/health` in your browser or use a tool like `curl`:

curl http://localhost:9001/api/v1/actuator/health

The response will look something like this:

{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "MySQL",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 53690372096,
        "free": 41438420992,
        "threshold": 10485760,
        "path": "D:\\git\\spring-boot-mysql-jwt-authn-authz\\.",
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    },
    "ssl": {
      "status": "UP",
      "details": {
        "validChains": [],
        "invalidChains": []
      }
    }
  }
}


You can add custom health indicators to include more detailed information. 

For example:


Metrics and Monitoring

The `/actuator/metrics` endpoint provides various application metrics. For example, to see JVM memory usage, you can query:

curl http://localhost:8080/actuator/metrics/jvm.memory.used

The response will look like this:



Package and Run the Application
In this final step, you will package the application into a JAR file and run the Spring Boot service.

Open a terminal and navigate to the root directory of your project using the following command:
cd ~/project/springbootyaml/
 Explain Code
 Practice Now
Run the following commands to package and start the Spring Boot service:
mvn clean package
mvn spring-boot:run


