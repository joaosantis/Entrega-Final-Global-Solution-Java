# 🧠 SYNAPSE - Rede Viva de Inteligência Coletiva
**Global Solution 2025 - O Futuro do Trabalho**

Este projeto integra **Internet of Bodies (IoB)** e **IA Generativa** para monitorar o bem-estar de colaboradores e otimizar a produtividade.

## 📺 Vídeo de Demonstração (IMPORTANTE)
Como a solução envolve múltiplos componentes rodando em paralelo, a demonstração completa está gravada aqui:
👉 **https://youtu.be/qcRG6lV19JM?si=U8oIn6QqV4M_W6Z5**

## 🚀 Como Rodar o Projeto (Passo a Passo)

Siga este roteiro para subir o ambiente completo na sua máquina local.

Rodar a API (Backend Java)
Na pasta raiz do projeto, execute:

Linux/Mac: ./mvnw spring-boot:run

Windows: .\mvnw spring-boot:run

A API estará disponível em: http://localhost:8080

🔐 Acesso ao Sistema
Documentação (Swagger): http://localhost:8080/swagger-ui/index.html

Login (Basic Auth):

Usuário: admin

Senha: admin

(O acesso de leitura GET está liberado, mas operações de escrita exigem login).

🛠️ Estrutura Técnica
Java 17 + Spring Boot 3: API RESTful com Validação, Paginação e Segurança.

Python 3: Agente inteligente com Google Gemini (GenAI).

PostgreSQL: Persistência de dados via Docker.
