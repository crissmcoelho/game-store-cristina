# Game Store Cristina

Uma aplicação para gerenciar uma loja de jogos (Game Store), onde é possível cadastrar produtos, consultar, editar e remover, etc.

## 🧩 Tecnologias Utilizadas

- Java  
- Gradle  
- (Se aplicável) Spring / Spring Boot / JPA / Hibernate / REST APIs / etc  
- (Se aplicável) Banco de dados (H2, MySQL, PostgreSQL, etc)  
- (Opcional) Frontend (React, Angular, Thymeleaf etc)  

## 📁 Estrutura do Projeto
```
├── gradle/ …
├── src/
│ ├── main/
│ │ ├── java/ …
│ │ └── resources/ …
│ └── test/ …
├── build.gradle
├── settings.gradle
├── pom.xml
├── gradlew
├── gradlew.bat
├── .gitignore
└── produto.txt
```


- `src/` — código-fonte da aplicação  
- `build.gradle` / `pom.xml` — arquivo(s) de build (dependências, plugins etc)  
- `produto.txt` — arquivo auxiliar (descrição de produtos, exemplos etc)  
- Scripts do Gradle (`gradlew`, `gradlew.bat`) — wrappers para facilitar build cross-platform  

## 🚀 Como Executar o Projeto (Passo a Passo)

> As instruções abaixo podem variar conforme as dependências do projeto. Ajuste conforme o seu caso.

1. Clone o repositório  
   ```bash
   git clone https://github.com/crissmcoelho/game-store-cristina.git
   cd game-store-cristina
./gradlew build
./gradlew bootRun   # ou a tarefa equivalente para executar
./gradlew clean bootRun
./gradlew test
🧪 Funcionalidades Principais

Cadastro de produtos

Consulta de produtos

Atualização de produtos

Remoção de produtos

Validações de dados (nome, preço, estoque etc)

(Se aplicável) Busca / filtros / paginação

(Se aplicável) API REST para operações CRUD

📦 Dependências / Plugins Importantes

Spring Boot Starter Web

Spring Boot Starter Data JPA

Driver do banco de dados (MySQL, H2, PostgreSQL etc)

Plugin de Lombok (se usado)

Plugin de testes (JUnit, Mockito etc)

🛠️ Boas Práticas & Sugestões para Melhorias

Tratar exceções e erros de maneira padronizada (por exemplo, controller advice)

Validações dos inputs (usando Bean Validation — @Valid, @NotNull, @Size etc)

Documentar API (Swagger / OpenAPI)

Autenticação / autorização (Spring Security)

Testes de integração

Persistência paginada / lazy loading

🧾 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE

👤 Autora

Cristina Coelho
GitHub: crissmcoelho

