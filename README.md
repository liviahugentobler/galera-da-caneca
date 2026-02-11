# Galera da Caneca - Interface do Sistema

## 📌 Sobre o Projeto

O **Galera da Caneca** é um sistema desenvolvido com foco na gestão de vendas e personalização de canecas, contemplando dois perfis principais de usuários:

- **Cliente**
- **Administrador/Gerente**

A proposta da interface foi construída pensando na experiência do usuário, organização das informações e separação clara entre área administrativa e área do cliente.

Foram desenvolvidas **13 telas**, simulando o funcionamento completo do sistema, desde autenticação até controle de metas e backup.

---

## 🎨 Conceito Visual

O layout foi projetado com:

- Padrão visual consistente
- Identidade visual única
- Hierarquia clara de informações
- Navegação lateral fixa para área administrativa
- Componentização visual reutilizável

Mesmo que a implementação futura em **Java** apresente alterações estruturais, o objetivo é manter:

- ✅ Paleta de cores
- ✅ Identidade visual
- ✅ Organização lógica das funcionalidades
- ✅ Experiência do usuário

A principal alteração futura será a substituição do **catálogo visual por planilhas de consulta**, priorizando visualização de dados e controle administrativo.

---

# 🖥️ Estrutura das Telas

## 🔐 1. Login
Tela de autenticação com:
- Campo de usuário
- Campo de senha
- Controle de acesso por perfil

---

## 📊 2. Dashboard Administrativo
Exibe:
- Resumo de vendas
- Total de pedidos
- Indicadores financeiros
- Últimos pedidos realizados
- Alertas de estoque crítico

Objetivo: visão gerencial rápida e estratégica.

---

## 👥 3. Cadastro de Clientes
Funcionalidades:
- Listagem paginada
- Busca por nome ou e-mail
- Cadastro de novo cliente
- Informações completas (telefone, endereço, observações)

---

## 📦 4. Registro de Pedidos
Controle de:
- Histórico de pedidos
- Status do pedido
- Visualização detalhada

---

## 🛍️ 5. Catálogo de Produtos (Modo Cliente)
Apresenta:
- Produtos com imagem
- Categoria
- Preço
- Status de estoque
- Botão de adicionar ao carrinho

Inclui filtro por categoria e campo de busca.

---

## 🛒 6. Carrinho de Compras
Funcionalidades:
- Alteração de quantidade
- Cálculo automático de total
- Cálculo de frete (PAC e Sedex)
- Campo para observações
- Finalização da compra

---

## 💳 7. Pagamento
Métodos disponíveis:
- Cartão de crédito
- Cartão de débito
- PIX
- Boleto
- Dinheiro

Inclui:
- Resumo do pedido
- Status do pagamento

---

## 📦 8. Acompanhamento de Pedido
Linha do tempo do pedido:
- Pago
- Produção
- Enviado
- Entregue

Exibição de:
- Produtos comprados
- Valores
- Status de envio

---

## 📋 9. Controle de Estoque
Painel administrativo para:
- Gerenciar quantidade disponível
- Identificar estoque crítico
- Atualizar produtos

---

## 👨‍💼 10. Cadastro de Funcionários
Permite:
- Cadastro de colaboradores
- Definição de cargo
- Status (Ativo/Inativo)

---

## 📈 11. Controle de Metas
Dashboard de desempenho contendo:
- Meta individual
- Meta da equipe
- Percentual atingido
- Histórico mensal
- Insights automáticos

Foco em gestão estratégica.

---

## 💾 12. Backup e Segurança
Funcionalidades:
- Backup automático diário
- Backup manual
- Histórico de backups
- Download de arquivos

Objetivo: segurança e integridade dos dados.

---

## 👤 13. Minha Conta (Área do Cliente)
Contém:
- Histórico de pedidos
- Total gasto
- Status das compras
- Edição de dados pessoais

---

# 🏗️ Direcionamento para Implementação em Java

Na futura implementação:

- O catálogo visual será adaptado para formato mais consultivo.
- Parte da navegação poderá ser ajustada para modelo mais técnico.
- O foco será maior na manipulação de dados e regras de negócio.
- A lógica administrativa será priorizada.

A interface atual serve como **modelo conceitual e estrutural do produto final**.

---

# 🎯 Objetivo do Projeto

Criar uma base visual completa para um sistema de:

- Gestão de vendas
- Controle administrativo
- Experiência de compra online
- Acompanhamento de desempenho
- Segurança de dados

---

## 👩‍💻 Autora

**Lívia Hugentobler**  
Desenvolvedora de Sistemas  
