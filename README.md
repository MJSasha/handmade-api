# Handmade API

**Study project*

In this project, I am trying to implement the REST API myself.

## Libraries used

- [Spring Core](https://mvnrepository.com/artifact/org.springframework/spring-core)
- [Spring Data Core](https://mvnrepository.com/artifact/org.springframework.data/spring-data-commons)
- [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)
- [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok)

## Tasks

- [ ] Implement methods:
    - [x] Get all models
    - [x] Get model by id
    - [x] Add model
    - [ ] Model editing
    - [x] Delete model
- [ ] Deploy the project to the server

## What I'm struggling with

> The findAll() method throws an error. Googled for a few days, then gave up and posted a 
> [question on StackOverflow](https://stackoverflow.com/questions/71442906/crudrepository-findall). 
> While waiting for an answer

Problem solved, I rebuilt the project and recreated the database and everything worked.