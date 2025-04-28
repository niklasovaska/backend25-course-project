## Album collection back-end
Spring Boot back-end application communicating with MariaDB database, handling JWT authentication and exposing REST APIs for Album collection React application.  

[Front-end GitHub respository](https://github.com/niklasovaska/course-project-album-app-front) 
### JWT authentication diagram
```mermaid
sequenceDiagram
    participant client
    participant server 

    client->>server: Sends login details to /login <br/>POST {username, password}
    note over server: User authentication
    
    activate server
    server-->>client: Server response with JWT
    note over client: JWT stored

    client->>server: Request resource <br/> JWT stored in Authorization header
    activate server
    note over server: Token verification
    server-->>client: Server response with data
```