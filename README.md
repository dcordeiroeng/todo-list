# Todo List Application

Este é um projeto de exemplo de uma aplicação de lista de tarefas (Todo List) usando Spring Boot. A aplicação permite criar, listar, atualizar e deletar tarefas.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.2
- Spring Data JPA
- MySQL Database
- Spring Web
- Jakarta Validation

## Estrutura do Projeto

- `controller`: Contém os controladores REST.
- `entity`: Contém as entidades JPA.
- `service`: Contém a lógica de negócios.
- `repository`: Contém os repositórios JPA.
- `exception`: Contém as classes de exceção e manipuladores de exceção.

## Endpoints da API

### Criar um *todo*

- **URL**: `/todos`
- **Método**: `POST`
- **Request Body**:
  ```json
  {
    "title": "string",
    "description": "string",
    "finished": "boolean",
    "priority": "integer"
  }

### Atualizar um *todo*

- **URL**: `/todos`
- **Método**: `PUT`
- **Request Body**:
  ```json
  {
    "id": "integer",
    "title": "string",
    "description": "string",
    "finished": "boolean",
    "priority": "integer"
  }

### Deletar um *todo*

- **URL**: `/todos/{id}`
- **Método**: `DELETE`
- **Response**: Lista de todos sem o item deletado.

### Listar os *todos*

- **URL**: `/todos`
- **Método**: `GET`
- **Response**: Lista de todos.

### Detalhar um *todo* por ID

- **URL**: `/todos/{id}`
- **Método**: `GET`
- **Response**: Detalhes do todo.

## Como Executar a Aplicação

Clone o repositório:

`git clone https://github.com/dcordeiroeng/todo-list.git`

Navegue até o diretório do projeto:

`cd todo-list`

Execute a aplicação:

`./mvnw spring-boot:run`

## Testes

Para executar os testes, use o seguinte comando:

`./mvnw test`

## Contribuição

Faça um fork do projeto.

Crie uma nova branch:

`git checkout -b minha-nova-feature`

Faça suas alterações e commit:

`git commit -m 'Adiciona nova feature'`

Envie para o repositório remoto:

`git push origin minha-nova-feature`

Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

Este `README.md` fornece uma visão geral do projeto, instruções sobre como executar a aplicação, detalhes sobre os endpoints da API e exemplos de uso. Sinta-se à vontade para personalizá-lo conforme necessário.
