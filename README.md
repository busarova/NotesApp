# NotesApp
springboot-sample-app

Requirements for building and running the application:

- JDK 1.11
- Maven 3
- Docker
- Docker Compose

Running the application locally:

1.Run Postgres database as Docker container:
  - Create and start container: docker run -e 'POSTGRES_PASSWORD=12345' -p 5432:5432 --name postgres -d postgres

2.Execute the main method in the com/busarova/noteapp/NoteappApplication class from your IDE.
Alternatively you can go to location of pom.xml and run Spring Boot application: mvn spring-boot:run

3.Test API using Postman:  
  - Create your user at: http://localhost:8080/api/noteapp/users/create
    - POST with body: 
      {
        "email": "your email",
        "password": "your password"
      }
  - Get access token to authorize requests       
    ![image](https://user-images.githubusercontent.com/20371871/139601245-cdeed96c-e738-44af-b233-1680e265a57a.png)
  - Create notes at http://localhost:8080/api/noteapp/notes
    - POST with body:
      {
        "title": "your note title",
        "description": "your note description"
      }
  - Get all your notes at: http://localhost:8080/api/noteapp/notes - GET    
  - Get your notes by title at: http://localhost:8080/api/noteapp/notes/title - GET  
  - Delete your notes at: http://localhost:8080/api/noteapp/notes - DELETE  
