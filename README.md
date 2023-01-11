## eDnipro Test

## Description of project

This is an API, for work with Excel files, rework it to PDF, 
and save all data to Database.
- For beginning work, go to ```/register```, register, and use you email and password, for entering.
- Upload you excel and take pdf on endpoin ```/```.
- And you can find the table, by information from cell. use ```/workbook?with={you looking value}```, and you can see all tables, what contains similar info
- Download table in pdf what contains in DB by id, use ```/workbook/{id}``` of table what you're looking for}
- See history of any table(with the same name), by endpoint 
```/{id}/history```

## Technologies

- Java 17
- Spring Boot 3
- Spring Data JPA
- Spring Security
- MySQL
- Lombok
- Swagger
- Liquibase
- Docker

## Project Structure

I use N-tier architecture.

| Tier       | Description                                                     |
|------------|-----------------------------------------------------------------|
| Control    | At this tier user can work with program api                     |
| Service    | Calculate all logic, and response for transfer data to DAO-tier |
| Repository | Response for work with database                                 |

## What I'm actually done

- Saving data in database
- Uploading of .xls or .xlsx tables and saving rework them to DB 
- Search by value in cell
- Downloading in pdf
- Registration and logging with token

## How to start

If you have docker, in terminal:
1. Download repo to you computer
2. Use
````
./mvnw clean package
````
3. Use, and wait booting
````
docker-compose up
````

If not:
1. Download repo to you computer
2. Change 
src/main/resources/application.properties
, change values to you database, i create this application for work with MySQl, so recommend use the same  
3. Use 
```
./mvnw spring-boot:run
```` 
in command line, from directory.
4. Register and have fun
