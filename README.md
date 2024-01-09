# Sistema de Pagamentos com RabbitMQ e Spring Boot

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring AMQP (RabbitMQ)
- Docker
- Gradle

## Estrutura do Projeto

### Módulo `Consumer`

#### `PagamentoErroProdutor` e `PagamentoSucessoProdutor`

Classes responsáveis por produzir mensagens de sucesso ou erro para o RabbitMQ.

#### `PagamentoRequestConsumidor`

Classe que consome mensagens da fila `pagamento-request-queue`, simula processamento e envia uma resposta para as filas `pagamento-response-sucesso-queue` ou `pagamento-response-erro-queue`.

#### `ConsumerApplication`

Classe principal Spring Boot que inicia a aplicação do consumidor.

### Módulo `ApiBackEnd`

#### `PagamentoRequestProducer`

Classe que produz mensagens contendo solicitações de pagamento para o RabbitMQ.

#### `PagamentoFacade`

Classe que encapsula a lógica de negócios para solicitar pagamentos, tratando respostas de sucesso e erro.

#### `PagamentoDTO`

Classe que representa a estrutura de dados para informações de pagamento.

#### `PagamentoResponseSucessoConsumidor` e `PagamentoResponseErroConsumidor`

Classes que consomem respostas de sucesso ou erro do RabbitMQ e chamam métodos adequados na classe `PagamentoFacade`.

#### `PagamentoApi`

Controlador Spring Boot que define o endpoint REST para processar solicitações de pagamento.

#### `ApiBackEndApplication`

Classe principal Spring Boot que inicia a aplicação da API de backend.

## Como Testar e Executar o Projeto

Certifique-se de ter o Docker instalado e seguir os passos abaixo:

1. Clone o repositório.
2. Abra o terminal na pasta do projeto.
3. Execute o comando `docker-compose up` para iniciar os contêineres do RabbitMQ e das aplicações.
4. As aplicações estarão disponíveis em http://localhost:8081 (API Backend) e http://localhost:8082 (Consumer).

### Endpoints da API Backend

- Processar Pagamento:
  - Método: POST
  - URL: http://localhost:8081/pagamentos
  - Corpo: JSON com dados do pagamento (Número do Pedido, Valor, Produto).

## Observações

- Este projeto é um exemplo educacional de integração entre microsserviços utilizando RabbitMQ.
- Certifique-se de ajustar as configurações do RabbitMQ conforme necessário nos arquivos de propriedades das aplicações.
