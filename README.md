# CRUD Cliente - Spring Boot REST API

API REST completa para gerenciamento de clientes, desenvolvida com Spring Boot e banco de dados H2 em memória.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Validation (Bean Validation)
- Banco de dados H2 (em memória)
- Maven

---

## Como executar o projeto

### Pré-requisitos

- Java 21 ou superior
- Maven 3.x

### Rodando a aplicação

```bash
# Clonar o repositório
git clone https://github.com/RonaldoFaustino/credclient.git

# Entrar na pasta do projeto
cd crudcliente

# Executar
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

O console do H2 estará disponível em: `http://localhost:8080/h2-console`

---

## Configuração do banco H2

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.defer-datasource-initialization=true
spring.jpa.hibernate.ddl-auto=create-drop
```

---

## Modelo de dados

### Client

| Campo       | Tipo        | Descrição                        |
|-------------|-------------|----------------------------------|
| id          | Long        | Identificador único (gerado auto)|
| name        | String      | Nome completo do cliente         |
| cpf         | String      | CPF do cliente                   |
| income      | Double      | Renda mensal                     |
| birthDate   | LocalDate   | Data de nascimento               |
| children    | Integer     | Número de filhos                 |

---

## Endpoints da API

Base URL: `http://localhost:8080/clients`

### Busca paginada de clientes

```
GET /clients?page=0&size=12&sort=name
```

Resposta `200 OK`:
```json
{
    "content": [
        {
            "id": 1,
            "name": "Maria Silva",
            "cpf": "481.257.930-12",
            "income": 3500.0,
            "birthDate": "1985-03-12",
            "children": 2
        }
    ],
    "totalElements": 20,
    "totalPages": 2,
    "number": 0
}
```

---

### Busca de cliente por id

```
GET /clients/{id}
```

Resposta `200 OK`:
```json
{
    "id": 1,
    "name": "Maria Silva",
    "cpf": "481.257.930-12",
    "income": 3500.0,
    "birthDate": "1985-03-12",
    "children": 2
}
```

Resposta `404 Not Found` (id inexistente):
```json
{
    "timestamp": "2024-01-15T10:30:00Z",
    "status": 404,
    "error": "Recurso não encontrado",
    "path": "/clients/99"
}
```

---

### Inserir novo cliente

```
POST /clients
```

Body:
```json
{
    "name": "Maria Silva",
    "cpf": "481.257.930-12",
    "income": 3500.0,
    "birthDate": "1985-03-12",
    "children": 2
}
```

Resposta `201 Created`.

---

### Atualizar cliente

```
PUT /clients/{id}
```

Body:
```json
{
    "name": "Maria Silva Souza",
    "cpf": "481.257.930-12",
    "income": 4500.0,
    "birthDate": "1985-03-12",
    "children": 3
}
```

Resposta `200 OK`.

---

### Deletar cliente

```
DELETE /clients/{id}
```

Resposta `204 No Content`.

Resposta `404 Not Found` (id inexistente).

---

## Validações

| Campo      | Regra                                    |
|------------|------------------------------------------|
| name       | Não pode ser vazio                       |
| cpf        | Não pode ser vazio                       |
| income     | Obrigatório e deve ser valor positivo    |
| birthDate  | Obrigatória e não pode ser data futura   |
| children   | Obrigatório e não pode ser negativo      |

Resposta `422 Unprocessable Entity` quando as validações falham:
```json
{
    "timestamp": "2024-01-15T10:30:00Z",
    "status": 422,
    "error": "birthDate: A data não pode ser futura",
    "path": "/clients"
}
```

---

## Estrutura do projeto

```
src/main/java/com/devsuperior/crudcliente/
├── controllers/
│   ├── ClientController.java
│   └── handlers/
│       ├── ControllerExceptionHandler.java
│       └── CustomError.java
├── dto/
│   └── ClientDTO.java
├── entities/
│   └── Client.java
├── repositories/
│   └── ClientRepository.java
└── services/
    ├── ClientService.java
    └── exceptions/
        └── ResourceNotFoundException.java
```

---

## Autor

Desenvolvido como desafio do curso **DevSuperior**.
