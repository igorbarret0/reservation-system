<h1>Bank Application</h1>

Esta aplicação é um sistema de reserva de passagens aéreas e hotéis, desenvolvido com princípios de Clean Architecture. Ela inclui rotas para processamento de pagamentos, gestão de reservas e verificação de disponibilidade, oferecendo uma estrutura flexível e robusta para gerenciar reservas de forma eficiente.


## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Docker](https://www.docker.com/)
- [RabbitMQ](https://www.rabbitmq.com/)
- [Spring Scheduling](https://spring.io/guides/gs/scheduling-tasks)


## Como Executar

- Clonar repositório git
```
git clone git@github.com:igorbarret0/reservation-system.git
```

- Construir o projeto:
```
./mvnw clean package
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/)

-  USER
```
POST /api/v1/users - Criar um usuário
```

```
GET /api/v1/users - Obert todos os usuários
```

```
GET /api/v1/users/{user-id} - Ober um usuário pelo ID
```

-  FLIGHT
```
POST /api/v1/flights - Registrar um Vôo
```

```
GET /api/v1/flights - Ober uma lista com todos os vôos disponíveis
```

```
GET /api/v1/flights/destination/{destination-name} - Obter todos os vôos pelo destino da viagem
```

```
GET /api/v1/flights/{flight-id} -> Obter um vôo pelo ID
```


-  HOTEL
```
POST /api/v1/hotels - Registrar um Hotel
```

```
POST /api/v1/hotels/{hotel-id} - Ober um hotel pelo ID
```

```
POST /api/v1/hotels - Ober todos os hotéis
```

```
POST /api/v1/hotels/location/{location-name} - Obter os hotéis pela sua localização
```

- FLIGHT RESERVATION
```
POST /api/v1/flight/reservation - Fazer a reserva de lugar em um vôo
```

- HOTEL RESERVATION
```
POST /api/v1/hotel/reservation - Fazer a reserva de quarto em um hotel
```

- PAYMENT
```
POST /api/v1/payments - Realizar o pagamento de uma reserva
```