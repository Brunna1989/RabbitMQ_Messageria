**_Projeto de Integração com RabbitMQ usando o Padrão PUB/SUB + Docker:_**

_Este projeto exemplifica a implementação de uma integração entre duas aplicações independentes -
utilizando o padrão Publish/Subscribe (PUB/SUB) via RabbitMQ. O objetivo principal é demonstrar a comunicação assíncrona e o desacoplamento temporal entre serviços, evitando dependências fortes e pontos de falha._

**_Contexto:_**

_Na atual era dos microserviços, enfrentamos desafios na comunicação entre diferentes partes de um sistema. A utilização de processos assíncronos e a separação temporal entre serviços são abordagens essenciais para garantir a resiliência e escalabilidade dos sistemas. O padrão de mensageria PUB/SUB é uma técnica que se alinha bem a essa abordagem, permitindo que uma aplicação envie mensagens (Publisher) para uma fila ou tópico, enquanto outra aplicação as processa (Subscriber)._

**_Funcionalidades Principais:_**

_1)_**API (Publisher):** _A API é responsável por receber requisições via endpoint e enviar mensagens para uma fila no RabbitMQ. Ela ilustra como a comunicação assíncrona pode ser implementada, enviando mensagens para que sejam processadas posteriormente._

_2)_**Aplicação de Linha de Comando (Consumer):** _A aplicação de linha de comando atua como um consumidor de mensagens. Ela se conecta à fila do RabbitMQ, recebe as mensagens enviadas pela API e as processa de acordo com a lógica de negócios definida._

**_Como Executar o Projeto:_**

_1)_ **Configuração do RabbitMQ:**

* _Instale o Docker, caso ainda não o tenha;_

* _Execute o RabbitMQ usando um contêiner Docker:_
* **docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management**

* _Acesse o painel de controle do RabbitMQ em http://localhost:15672, inserindo usuário e senhas iguais: **rabbitmq** e utilize as seguintes filas:_

_pagamento-request-queue_

_pagamento-response-erro-queue_

_pagamento-responde-sucesso-queue_

_2)_ **Compilando e Executando as Aplicações:**

* _Compile e execute a API e a aplicação de linha de comando, utilizando as bibliotecas RabbitMQ mencionadas na documentação._

* _Certifique-se de configurar corretamente a conexão com o RabbitMQ em ambas as aplicações._

_3)_ **Observando o Funcionamento:**

* _Envie uma requisição para a API via endpoint. Isso resultará no envio de uma mensagem para a fila do RabbitMQ._

* _A aplicação de linha de comando (Consumer) estará escutando a fila e processará a mensagem assim que estiver disponível._

**_Extra: Padrão Dead-Letter:_**

_Este projeto também inclui uma simulação de erro aleatório durante o processo de consumo da mensagem. Quando esse erro ocorre, a mensagem é enviada para uma fila de "dead-letter". Isso ilustra como lidar com situações de erro de maneira apropriada e permite que a aplicação de linha de comando identifique e trate os erros de processamento._

**_Bibliotecas e Frameworks:_**

Este projeto foi desenvolvido com o foco em demonstrar a integração usando o RabbitMQ e não depende de frameworks específicos. Foram utilizadas as bibliotecas do RabbitMQ para Java mencionadas na documentação.

**_Conclusão:_**

_Este projeto serve como um guia introdutório para implementar a comunicação assíncrona entre diferentes partes de um sistema usando o padrão PUB/SUB via RabbitMQ. O uso inteligente de mensageria e a separação temporal entre serviços podem melhorar a escalabilidade e a robustez de um sistema, evitando dependências excessivas. Em cenários reais, é importante considerar aspectos de gerenciamento de erros, escalabilidade e monitoramento para garantir o sucesso da arquitetura de comunicação._