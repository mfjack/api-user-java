# api-user

API RESTful simples para gerenciamento de usuários desenvolvida com Spring Boot e MongoDB.

## Visão geral

Este projeto oferece as operações CRUD básicas para usuários via HTTP. A aplicação usa Spring Web MVC para o controlador REST, Spring Data MongoDB para persistência e um modelo `User` com os campos `id`, `name` e `email`.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data MongoDB
- MongoDB
- Apache Maven

## Pré-requisitos

- Java 25 instalado
- Maven instalado ou uso do wrapper `mvnw` / `mvnw.cmd`
- MongoDB rodando localmente em `mongodb://localhost:27017/local`

> A configuração padrão está em `src/main/resources/application.properties`.

## Como executar a aplicação

No Windows:

```powershell
./mvnw spring-boot:run
```

Ou com Maven instalado:

```bash
mvn spring-boot:run
```

A aplicação será iniciada em `http://localhost:8080`.

## Endpoints

Base: `http://localhost:8080/users`

- `POST /users`
  - Cria um novo usuário.
  - Exemplo de corpo JSON:
    ```json
    {
      "name": "João",
      "email": "joao@example.com"
    }
    ```

- `GET /users`
  - Retorna todos os usuários.

- `PUT /users`
  - Atualiza um usuário existente.
  - É necessário enviar o `id` no corpo JSON.
    ```json
    {
      "id": "6342a1b2c3d4e5f6a7b8c9d0",
      "name": "João Silva",
      "email": "joao.silva@example.com"
    }
    ```

- `DELETE /users?id={id}`
  - Exclui o usuário com o `id` informado.

## Estrutura do projeto

- `src/main/java/com/jack/api_user/controller/UserController.java`
  - Controlador REST que gerencia as rotas de usuários.
- `src/main/java/com/jack/api_user/business/UserService.java`
  - Lógica de negócio e interação com o repositório.
- `src/main/java/com/jack/api_user/infrastructure/entities/User.java`
  - Entidade mapeada para o MongoDB.
- `src/main/java/com/jack/api_user/infrastructure/repository/UserRepository.java`
  - Repositório MongoDB para CRUD de `User`.
- `src/main/resources/application.properties`
  - Configurações da aplicação, incluindo conexão com MongoDB.

## Observações

- Não há testes implementados no momento.
- O projeto usa um banco MongoDB local por padrão. Para usar outro banco ou URI, altere `spring.mongodb.uri` em `application.properties`.
