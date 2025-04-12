# Todo List Experiment

Este é um pojeto de **estudo** que visa entender os princípios de Clean Code e Clean Architecture. Essa é a primeira versão do projeto, uma simples API de **TODO-LIST**. <br>
Ao longo do tempo, vou refazer esse mesmo código aplicando conceitos do livro Clean Code e depois do Clean Architecture, ambos do Robert Cecil Martin (**Uncle Bob**).

## Objetivo
O objetivo deste projeto é entender e dominar o que é ensinado nesses livros. A primeira versão do projeto usa uma simples arquitetura de camadas, sem **testes** e sem seguir os pricípio **S.O.L.I.D** ou qualquer outro tipo de arquitetura. <br>

## 🛠 Tecnologias
- ☕ Java 21
- 🌱 Spring Boot
- 🌐 Spring Web
- 🗃️ Spring Data JPA
- 🧠 H2 Database (Banco de Dados em Memória)

## ⚙️ Funcionalidaes
As funcionalidades do projeto são bem básicas, apenas um C.R.U.D simples. 
- ➕ Cadastrar uma nova tarefa
- 🔍 Listar uma tarefa pelo ID
- 📋 Listar todas as tarefas baseadas na prioridade
- ✏️ Editar uma tarefa
- ❌ Excluir uma tarefa
- 🗑️Excluir todas as tarefas

## 🔗 Endpoints
Os endpoints são: <br>
@POST /api/task/
- 📌 Cria uma nova tarefa

@PUT /api/task/{id}
- 🔄 Atualiza uma tarefa

@GET /api/task/list
- 📜 Lista todas as tarefas

@GET /api/task/{id}
- 🔎 Busca uma taredfa específica com base no Id

@DELETE /api/task/{id}
- 🗑️ Deleta uma tarefa com base no ID

@DELETE /api/task/delete-all
- 💥 Deleta todas as tarefas criadas

## 🚀 Como Testar a API
- 📥 Clone o repositório <br>
```bash
git clone https://github.com/cesar-404/todo-list-experiment
```
- 🏗️ Construa o projeto com Maven/Gradle
- ▶️ Execute a aplicação
- 🧪 Teste os endpoints usando Postman/Insomnia
- 📊 Verifique o banco H2
