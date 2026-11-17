# Baozi Store - API REST

Trabalho de Desenvolvimento Web Back-End (UNINTER) - Paulo Sergio Oliveira da Silva, RU 5231866.

API REST simples para controlar clientes, produtos e pedidos de uma loja de pao chines.

## Tecnologias
Java 17, Spring Boot 3.3.5, Spring Data JPA, banco H2 (arquivo), Maven.

## Como rodar
```
mvn spring-boot:run
```
A API sobe em http://localhost:8080. O banco e criado sozinho na pasta `data/`.
Console do banco: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:file:./data/baozidb`, usuario `sa`, senha vazia).

## Endpoints
| Metodo | URL | O que faz |
|---|---|---|
| POST | /clientes, /produtos, /pedidos | cria um registro |
| GET | /clientes, /produtos, /pedidos | lista todos |
| GET | /clientes/{id}, /produtos/{id}, /pedidos/{id} | busca por id |
| DELETE | /clientes/{id}, /produtos/{id}, /pedidos/{id} | apaga por id |

Exemplos de JSON:
```
POST /clientes  {"nome": "PauloSergio5231866", "clienteDesde": "2026-11-17"}
POST /produtos  {"nome": "Baozi de Carne", "preco": 8.50, "estoque": true}
POST /pedidos   {"clienteId": 1, "produtoId": 1, "quantidade": 6}
```
Regras: o pedido exige cliente e produto existentes e quantidade > 0 (senao 400);
cliente ou produto com pedido nao pode ser apagado (409).

## Estrutura
`model` (entidades), `repository` (JpaRepository) e `controller` (endpoints REST).
