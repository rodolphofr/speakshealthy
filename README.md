# SpeakSHealthy

> Sistema web de apoio à fonoaudiologia, desenvolvido para auxiliar especialistas no acompanhamento, treinamento e evolução de pacientes.

## 📖 Sobre o projeto

O **SpeakSHealthy** é uma aplicação desenvolvida com foco em auxiliar profissionais da área de fonoaudiologia no gerenciamento de pacientes, exercícios e histórico de gravações relacionadas ao desenvolvimento da fala.

O projeto foi desenvolvido utilizando tecnologias tradicionais do ecossistema Java Web, seguindo uma arquitetura organizada em camadas (*Controller*, *Service*, *Repository* e *Model*), com integração ao banco de dados utilizando Hibernate e Spring Framework.

Além do gerenciamento de dados, o sistema possui funcionalidades voltadas para:

* Cadastro de pacientes e especialistas;
* Gerenciamento de exercícios fonéticos;
* Histórico de gravações;
* Upload de arquivos;
* Controle de sessões;
* Organização de fonemas e treinamentos.

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura baseada em camadas:

```text
Controller → Service → Repository → Database
```

### Estrutura principal

```text
src/main/java/br/site
├── controller
├── db
├── model
├── service
└── util
```

### Camadas

| Camada          | Responsabilidade                 |
| --------------- | -------------------------------- |
| Controller      | Recebimento das requisições HTTP |
| Service         | Regras de negócio                |
| Repository (db) | Comunicação com banco de dados   |
| Model           | Entidades e DTOs                 |
| Util            | Classes utilitárias              |

---

## ⚙️ Tecnologias utilizadas

### Backend

* Java
* Spring Framework 3
* Spring MVC
* Hibernate
* Hibernate Validator
* Hibernate Search
* Maven
* JSP
* Servlet API

### Banco de dados

* MySQL

### Bibliotecas auxiliares

* SLF4J
* Log4j
* Apache Commons
* CGLIB

---

## 📂 Funcionalidades identificadas

### 👨‍⚕️ Especialistas

* Cadastro de especialistas;
* Controle de sessões;
* Gerenciamento de treinamentos.

### 🧑 Pacientes

* Cadastro de pacientes;
* Associação de exercícios;
* Histórico de gravações.

### 🗣️ Fonética e Treinamentos

* Gerenciamento de fonemas;
* Exercícios fonéticos;
* Registro de evolução.

### 📤 Uploads

* Upload de arquivos de mídia;
* Organização de registros.

---

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de iniciar, é necessário possuir instalado:

* Java 7 ou superior
* Maven
* MySQL
* Apache Tomcat

---

### 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
```

---

### 2. Configurar o banco de dados

Criar um banco MySQL e ajustar as configurações de conexão do projeto.

Exemplo:

```properties
jdbc.url=jdbc:mysql://localhost:3306/speakshealthy
jdbc.username=root
jdbc.password=senha
```

---

### 3. Build do projeto

```bash
mvn clean install
```

---

### 4. Executar no Tomcat

Deploy do `.war` gerado no servidor Apache Tomcat.

---

## 🧪 Estrutura do domínio

As principais entidades identificadas no projeto:

* Patient
* Expert
* Exercise
* RecordingHistory
* Phoneme
* CRFa

---

## 📸 Possíveis melhorias futuras

Como projeto desenvolvido há alguns anos, diversas evoluções modernas poderiam ser aplicadas:

* Migração para Spring Boot;
* APIs REST;
* Frontend moderno (React/Vue/Angular);
* Docker;
* Autenticação JWT;
* Testes automatizados mais robustos;
* Pipeline CI/CD;
* Observabilidade;
* Deploy em nuvem.

---

## 🎯 Objetivo acadêmico/profissional

Este projeto representa um estudo prático envolvendo:

* Desenvolvimento web com Java;
* Arquitetura MVC;
* Persistência com Hibernate;
* Organização em camadas;
* Integração com banco de dados relacional;
* Construção de sistemas voltados à área da saúde.

---

## 👨‍💻 Autor

Desenvolvido por Rodolpho Rodrigues.

---

## 📄 Licença

Este projeto possui finalidade educacional e de estudo.
