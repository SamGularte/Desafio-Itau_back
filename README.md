# 💰 API de Transações - Desafio Itaú
Este projeto é uma implementação de um desafio técnico proposto pelo Itaú, com o objetivo de construir uma API REST para processamento de transações financeiras e cálculo de estatísticas em tempo real.

A aplicação foi desenvolvida utilizando **Java + Spring Boot**, seguindo boas práticas de desenvolvimento, validação de dados e arquitetura.

---

## 📎 Referência

Este projeto foi desenvolvido com base no desafio técnico disponibilizado no repositório abaixo:

🔗 Repositório original:  
https://github.com/feltex/desafio-itau-backend

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Maven
- Spring Web
- Spring Validation
- Spring Actuator (healthcheck)
- Swagger / OpenAPI (documentação)
- SLF4J / Logback (logs)

---

## 📌 Funcionalidades

A API permite:

- Receber transações financeiras
- Limpar todas as transações armazenadas
- Calcular estatísticas em tempo real (últimos N segundos)

---

## ⚙️ Diferenciais implementados

Além dos requisitos obrigatórios, foram adicionadas melhorias importantes:

### 🔍 Logs
- Implementação de logs com SLF4J
- Rastreamento de requisições e erros
- Facilita debug e manutenção

### ❤️ Healthcheck (Observabilidade)
- Endpoint de verificação da saúde da aplicação
- Disponível via Spring Actuator:

```bash
GET /actuator/health
```

### ⚠️ Tratamento de erros
- Customização das respostas de erro  
- Retorno mais claro para o cliente da API  

### 📚 Documentação da API
- Documentação interativa com Swagger/OpenAPI  
- Permite testar endpoints diretamente pelo navegador  

### ⚙️ Configuração dinâmica
- A janela de tempo para cálculo das estatísticas é configurável  