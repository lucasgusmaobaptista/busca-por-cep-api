
# Busca por CEP API

Esta API permite a busca de informações de um endereço a partir de um CEP utilizando uma API externa. A API foi desenvolvida com o Spring Boot, integrando o consumo de uma API externa e a utilização de Redis para cache, sendo o Redis executado em um container Docker.

## Funcionalidades

- Buscar informações de endereço a partir de um CEP.
- Integração com uma API externa para busca de CEP.
- Armazenamento de dados de CEP no Redis para otimizar o desempenho.
  
## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada.
- **Spring Boot**: Framework principal para a construção da API.
- **Spring Web**: Utilizado para criação da API REST.
- **Spring Cloud OpenFeign**: Utilizado para facilitar a comunicação com a API externa.
- **Redis**: Usado como cache para armazenar as respostas das buscas de CEP.
- **Docker**: Para containerizar o Redis e facilitar a execução do ambiente de desenvolvimento.
  
## Endpoints

### `GET /cep/{cep}`

Realiza a busca de um endereço com base no CEP fornecido.

**Parâmetros de Entrada**:
- `cep` (string): O CEP para a busca.

**Resposta**:
- **Código 200**: Retorna as informações do endereço.
- **Código 404**: Se o CEP não for encontrado.

### Exemplo de resposta:
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

## Configuração do Ambiente

### Docker para Redis

O Redis é executado em um container Docker. Para iniciar o Redis, execute o seguinte comando:

```bash
docker run --name redis -p 6379:6379 -d redis
```

Isso fará com que o Redis seja executado na porta `6379` do seu ambiente local.

### Configuração do Spring Cloud para API Externa

A aplicação utiliza o Spring Cloud para consumir uma API externa para a busca de informações de CEP. O Spring Cloud gerencia a comunicação com a API externa através de uma configuração simples. Certifique-se de que a URL da API externa esteja configurada corretamente no arquivo `application.properties`.

### Arquivo `application.properties`

```properties
# Configuração do Redis
spring.redis.host=localhost
spring.redis.port=6379

# URL da API externa
api.cep.url=https://viacep.com.br/ws/{cep}/json/
```

### Como Rodar o Projeto Localmente

1. Inicie o Redis usando Docker:
    ```bash
    docker run --name redis -p 6379:6379 -d redis
    ```

2. Clone este repositório:
    ```bash
    git clone https://github.com/seu-usuario/busca-por-cep-api.git
    cd busca-por-cep-api
    ```

3. Execute o projeto Spring Boot:
    ```bash
    ./mvnw spring-boot:run
    ```

4. A API estará disponível em `http://localhost:8080`.

## Documentação com Swagger

A API conta com integração do Swagger para documentação e teste dos endpoints. Acesse a interface de Swagger na URL:

```
http://localhost:8080/swagger-ui.html
```

Lá você poderá visualizar os endpoints disponíveis e testar a API diretamente.
