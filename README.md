# 🔐 Auth API

API REST de autenticação com JWT desenvolvida em Java com Spring Boot.

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- MySQL 8
- Docker e Docker Compose
- Maven

## 📋 Funcionalidades

- ✅ Cadastro de usuário
- ✅ Login com geração de token JWT
- ✅ Rotas protegidas por autenticação
- ✅ Atualização e remoção da própria conta
- ✅ Controle de acesso por perfil (USER / ADMIN)
- ✅ Listagem e remoção de usuários (admin)

## 🔧 Como rodar o projeto

### Pré-requisitos
- Docker e Docker Compose instalados

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/Paccanaro18/auth.api.git

# Entre na pasta
cd auth-api

# Copie o arquivo de variáveis e preencha os valores
cp .env.example .env

# Suba os containers
docker-compose up --build
```

A aplicação estará disponível em `http://localhost:8080`

## 🔑 Variáveis de ambiente

| Variável | Descrição |
|---|---|
| `DATABASE_USERNAME` | Usuário do banco |
| `DATABASE_PASSWORD` | Senha do banco |
| `JWT_KEY` | Chave secreta do JWT |
| `JWT_EXPIRATION` | Tempo de expiração em ms |
| `MYSQL_ROOT_PASSWORD` | Senha root do MySQL |

## 📌 Endpoints

### Auth — público
| Método | Rota | Descrição |
|---|---|---|
| POST | `/v1/auth/register` | Cadastro de usuário |
| POST | `/v1/auth/login` | Login e geração do token |

### Usuário — requer token
| Método | Rota | Descrição |
|---|---|---|
| GET | `/v1/usuarios/me` | Dados do usuário logado |
| PUT | `/v1/usuarios/me` | Atualiza dados do usuário |
| DELETE | `/v1/usuarios/me` | Remove a própria conta |

### Admin — requer token + role ADMIN
| Método | Rota | Descrição |
|---|---|---|
| GET | `/v1/admin/usuarios` | Lista todos os usuários |
| DELETE | `/v1/admin/usuarios/{id}` | Remove qualquer usuário |

## 👤 Autor

Artur Paccanaro

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/artur-paccanaro-196b34359/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white)](https://github.com/Paccanaro18)