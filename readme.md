# 🫖 Galera da Caneca — Sistema de Gestão

> Projeto Integrador I — SENAC EAD  
> Responsável: Lívia Hugentobler  
> Versão: 1.1

Sistema desktop para gestão de vendas, cadastros e controle de pedidos de uma loja virtual especializada em canecas personalizadas. Desenvolvido em Java com interface Swing (JFrame) e persistência via JPA + Hibernate + MySQL.

---

## 📋 Índice

- [Tecnologias](#-tecnologias)
- [Pré-requisitos](#-pré-requisitos)
- [Como configurar o banco de dados](#-como-configurar-o-banco-de-dados)
- [Como conectar o projeto ao banco](#-como-conectar-o-projeto-ao-banco)
- [Como importar e rodar no NetBeans](#-como-importar-e-rodar-no-netbeans)
- [Usuários de teste](#-usuários-de-teste)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Funcionalidades por perfil](#-funcionalidades-por-perfil)
- [Requisitos funcionais implementados](#-requisitos-funcionais-implementados)

---

## 🛠 Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 17 | Linguagem principal |
| Maven | 3.x | Gerenciamento de dependências |
| Hibernate | 5.6.15 | Implementação JPA / ORM |
| JPA (javax.persistence) | 2.2 | API de persistência |
| MySQL Connector/J | 8.0.33 | Driver JDBC para MySQL |
| MySQL | 8.x | Banco de dados relacional |
| Java Swing (JFrame) | — | Interface gráfica desktop |

---

## ✅ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- **JDK 17** ou superior → [Baixar aqui](https://www.oracle.com/java/technologies/downloads/)
- **Apache Maven 3.x** → [Baixar aqui](https://maven.apache.org/download.cgi)
- **MySQL 8.x** → [Baixar aqui](https://dev.mysql.com/downloads/mysql/)
- **MySQL Workbench** → [Baixar aqui](https://dev.mysql.com/downloads/workbench/)
- **NetBeans IDE 17+** → [Baixar aqui](https://netbeans.apache.org/)

---

## 🗄 Como configurar o banco de dados

### Passo 1 — Verificar se o MySQL está rodando

1. Pressione `Win + R`, digite `services.msc` e pressione **Enter**
2. Na lista de serviços, procure por **MySQL80** (ou simplesmente **MySQL**)
3. Verifique o status na coluna **Status**:
   - ✅ **Running** → MySQL está rodando, pode prosseguir
   - ❌ **Stopped** → Clique com botão direito → **Start** e aguarde

> **Dica:** Para iniciar automaticamente com o Windows, clique com botão direito no serviço → Propriedades → Tipo de inicialização → **Automático**

### Passo 2 — Criar o banco de dados no Workbench

1. Abra o **MySQL Workbench**
2. Conecte-se ao servidor local (geralmente `localhost:3306`)
3. Vá em **File → Open SQL Script** e selecione o arquivo:
   ```
   banco_GaleraDaCaneca.sql
   ```
   (ele está na raiz do projeto junto com o `pom.xml`)

4. Clique em **Execute (⚡)** ou pressione `Ctrl + Shift + Enter` para rodar todo o script
5. No painel **Schemas** (lado esquerdo), clique no botão de atualizar (🔄) e verifique se o banco `galera_da_caneca` aparece com as tabelas:

```
galera_da_caneca
├── cargos
├── clientes
├── pagamentos
├── produtos
├── vendas
└── vendedores
```

---

## 🔌 Como conectar o projeto ao banco

A configuração da conexão fica no arquivo:

```
src/main/resources/META-INF/persistence.xml
```

Abra esse arquivo e ajuste as propriedades conforme o seu ambiente:

```xml
<!-- conexao com o banco -->
  <property name="javax.persistence.jdbc.driver"   value="com.mysql.cj.jdbc.Driver"/>
  <property name="javax.persistence.jdbc.url"      value="jdbc:mysql://localhost/galera_da_caneca"/>
  <property name="javax.persistence.jdbc.user"     value="root"/>
  <property name="jakarta.persistence.jdbc.password" value="SUA_SENHA_AQUI"/>
```

## 🚀 Como importar e rodar no NetBeans

1. Abra o **NetBeans IDE**
2. Vá em **File → Open Project**
3. Navegue até a pasta `GaleraDaCaneca_Maven` e clique em **Open Project**
   - O NetBeans reconhece automaticamente como projeto Maven
4. Aguarde o download das dependências (primeira vez pode demorar alguns minutos)
5. Confirme que o banco está rodando e o `persistence.xml` está com a senha correta
6. Clique em **Run Project (F6)** ou no botão ▶️

> **Atenção:** o ponto de entrada é a classe `br.com.galeradacaneca.main.Principal`. Se o NetBeans pedir para selecionar a classe principal, escolha esta.

---

## 👤 Usuários de teste

O banco já vem populado com dados iniciais. Use os logins abaixo para testar cada perfil:

### Perfil Gerente / Supervisor

| Nome | E-mail | Senha | Cargo |
|---|---|---|---|
| Renata Borges | renata.borges@email.com | 695314 | Supervisor |
| Fernando Alves | fernando.alves@email.com | 218940 | Supervisor |

> Gerentes têm acesso a **todas** as telas: cadastro de funcionários, produtos, clientes, backup e dashboard com meta de **R$ 6.000,00**.

### Perfil Vendedor

| Nome | E-mail | Senha | Cargo |
|---|---|---|---|
| Lucas Ribeiro | lucas.ribeiro@email.com | 583920 | Vendedor |
| Amanda Costa | amanda.costa@email.com | 147893 | Vendedor |
| Thiago Martins | thiago.martins@email.com | 920471 | Vendedor |
| Juliana Rocha | juliana.rocha@email.com | 306258 | Vendedor |
| Marcos Lima | marcos.lima@email.com | 781423 | Vendedor |

> Vendedores têm acesso ao cadastro de clientes e ao dashboard pessoal com meta de **R$ 2.000,00**.

---

## 📁 Estrutura do projeto

```
GaleraDaCaneca_Maven/
│
├── pom.xml                          ← Dependências Maven (JPA, Hibernate, MySQL)
├── banco_GaleraDaCaneca.sql         ← Script completo do banco de dados
├── README.md                        ← Este arquivo
│
└── src/main/
    ├── java/br/com/galeradacaneca/
    │   │
    │   ├── main/
    │   │   └── Principal.java       ← Ponto de entrada da aplicação
    │   │
    │   ├── model/                   ← Entidades JPA (mapeamento do banco)
    │   │   ├── Cargo.java
    │   │   ├── Cliente.java
    │   │   ├── Pagamento.java
    │   │   ├── Produto.java
    │   │   ├── Venda.java
    │   │   └── Vendedor.java
    │   │
    │   ├── dao/                     ← Acesso ao banco de dados (CRUD via JPA)
    │   │   ├── JPAUtil.java         ← Fábrica do EntityManager (singleton)
    │   │   ├── CargoDAO.java
    │   │   ├── ClienteDAO.java
    │   │   ├── PagamentoDAO.java
    │   │   ├── ProdutoDAO.java
    │   │   ├── VendaDAO.java
    │   │   └── VendedorDAO.java
    │   │
    │   └── view/                    ← Telas JFrame (interface gráfica)
    │       ├── Login.java
    │       ├── DashbordGerente.java
    │       ├── DashbordFuncionario.java
    │       ├── CadastroClientes.java
    │       ├── CadastroFuncionarios.java
    │       ├── CadastroProduto.java
    │       ├── FormularioCadastroClientes.java
    │       ├── FormularioCadastroFuncionario.java
    │       ├── FormularioCadastroProduto.java
    │       └── Backup.java
    │
    └── resources/
        ├── META-INF/
        │   └── persistence.xml      ← Configuração da conexão com o banco
        └── br/com/galeradacaneca/view/
            └── *.png                ← Ícones e imagens da interface
```

---

## 🔐 Funcionalidades por perfil

| Funcionalidade | Vendedor | Gerente/Supervisor |
|---|:---:|:---:|
| Login com autenticação | ✅ | ✅ |
| Dashboard pessoal com metas | ✅ | ✅ |
| Cadastro de clientes | ✅ | ✅ |
| Pesquisa de clientes | ✅ | ✅ |
| Catálogo de produtos (visualizar) | ✅ | ✅ |
| Cadastro de funcionários | ❌ | ✅ |
| Cadastro e edição de produtos | ❌ | ✅ |
| Exclusão de registros | ❌ | ✅ |
| Controle de estoque | ❌ | ✅ |
| Dashboard com total geral de vendas | ❌ | ✅ |
| Backup manual do banco | ❌ | ✅ |

---

## 📌 Requisitos funcionais implementados

| RF | Descrição | Status |
|---|---|---|
| RF001 | Cadastro e atualização de clientes | ✅ |
| RF002 | Cadastro de funcionários (apenas gerente) | ✅ |
| RF003 | Login com autenticação por senha | ✅ |
| RF004 | Catálogo de produtos (todos os perfis) | ✅ |
| RF005 | Cadastro e edição de produtos (apenas gerente) | ✅ |
| RF009 | Controle de metas mensais por perfil | ✅ |
| RF010 | Controle de estoque (apenas gerente) | ✅ |
| RF011 | Backup manual via mysqldump | ✅ |

---

## 📝 Observações técnicas

- As senhas dos funcionários são armazenadas em **texto simples** no banco, conforme o escopo acadêmico do projeto.
- O backup manual (RF011) requer que o `mysqldump` esteja disponível no PATH do sistema. Ele é instalado automaticamente com o MySQL Server.

---
