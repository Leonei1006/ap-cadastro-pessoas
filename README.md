# API de Gerenciamento de Pessoas

Esta é uma API desenvolvida em Java 21 com Spring Boot para o gerenciamento de pessoas, incluindo informações pessoais e endereços.

## Funcionalidades

- Criar, editar e consultar uma ou mais pessoas.
- Criar, editar e consultar um ou mais endereços de uma pessoa.
- Indicar qual endereço será considerado o principal de uma pessoa.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 2.x
- Spring Web 
- Spring Data JPA
- H2 Database (banco de dados em memória)
- Lombok (para reduzir a verbosidade do código)
- JUnit 5 (para testes unitários)

## Estrutura do Projeto

O projeto segue uma arquitetura hexagonal com as seguintes camadas:

- Controller
- Service
- DTOs (Data Transfer Objects)
- Repository
- Entity

## Configuração do Ambiente de Desenvolvimento

Para rodar a aplicação localmente, certifique-se de ter o seguinte instalado em seu ambiente de desenvolvimento:

- Java JDK 21
- Maven
- Postman (ou outra ferramenta para testar a API)

## Como Executar

1. Clone este repositório: `git clone https://github.com/Leonei1006/ap-cadastro-pessoas.git`
2. Navegue até o diretório do projeto: `cd ap-cadastro-pessoas`
3. Execute o comando Maven para compilar e executar a aplicação: `mvn spring-boot:run`
4. Acesse a API em `http://localhost:8080`

## Testes

A aplicação possui testes unitários escritos com JUnit. Você pode executar os testes usando o Maven: `mvn test`.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver alguma sugestão de melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request.
