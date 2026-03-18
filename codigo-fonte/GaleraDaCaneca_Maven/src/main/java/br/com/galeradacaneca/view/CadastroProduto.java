package br.com.galeradacaneca.view;

import br.com.galeradacaneca.dao.ProdutoDAO;
import br.com.galeradacaneca.model.Produto;
import br.com.galeradacaneca.model.Vendedor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Tela de listagem de Produtos — RF004, RF005, RF010 (Gerente)
 */
public class CadastroProduto extends javax.swing.JFrame {

    private final Vendedor vendedorLogado;
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private DefaultTableModel tableModel;

    public CadastroProduto(Vendedor vendedor) {
        this.vendedorLogado = vendedor;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Galera da Caneca — Catálogo de Produtos");
        configurarTabela();
        carregarProdutos();
    }

    private void configurarTabela() {
        tableModel = new DefaultTableModel(
            new String[]{"ID", "Nome do Produto", "Preço (R$)", "Estoque", "Entradas", "Saídas"}, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        jTable1.setModel(tableModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void carregarProdutos() {
        tableModel.setRowCount(0);
        List<Produto> lista = produtoDAO.listarTodos();
        for (Produto p : lista) {
            tableModel.addRow(new Object[]{
                p.getId(), p.getNomeProd(),
                String.format("%.2f", p.getPreco()),
                p.getQuantidade(), p.getEntradas(), p.getSaidas()
            });
        }
    }

    private void pesquisar() {
        String termo = jTextField1.getText().trim();
        tableModel.setRowCount(0);
        List<Produto> lista = termo.isEmpty()
            ? produtoDAO.listarTodos()
            : produtoDAO.pesquisarPorNome(termo);
        for (Produto p : lista) {
            tableModel.addRow(new Object[]{
                p.getId(), p.getNomeProd(),
                String.format("%.2f", p.getPreco()),
                p.getQuantidade(), p.getEntradas(), p.getSaidas()
            });
        }
    }

    private void excluirSelecionado() {
        if (!vendedorLogado.isGerente()) {
            JOptionPane.showMessageDialog(this, "Apenas gerentes podem excluir produtos.", "Acesso negado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int row = jTable1.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Selecione um produto."); return; }
        int id = (int) tableModel.getValueAt(row, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Excluir produto selecionado?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                produtoDAO.excluir(id);
                carregarProdutos();
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCadastroFuncionario = new javax.swing.JButton();
        btnRegistroPedidos = new javax.swing.JButton();
        btnCadastroProdutos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNovoProduto = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/User.png")));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/File text.png")));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/Book open.png")));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/Log in.png")));

        btnCadastroFuncionario.setBackground(new java.awt.Color(0, 153, 204));
        btnCadastroFuncionario.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnCadastroFuncionario.setForeground(java.awt.Color.WHITE);
        btnCadastroFuncionario.setText("Funcionários");
        btnCadastroFuncionario.setBorder(null);
        btnCadastroFuncionario.addActionListener(evt -> { new CadastroFuncionarios(vendedorLogado).setVisible(true); this.dispose(); });

        btnRegistroPedidos.setBackground(new java.awt.Color(0, 153, 204));
        btnRegistroPedidos.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnRegistroPedidos.setForeground(java.awt.Color.WHITE);
        btnRegistroPedidos.setText("Clientes");
        btnRegistroPedidos.setBorder(null);
        btnRegistroPedidos.addActionListener(evt -> { new CadastroClientes(vendedorLogado).setVisible(true); this.dispose(); });

        btnCadastroProdutos.setBackground(new java.awt.Color(0, 153, 204));
        btnCadastroProdutos.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnCadastroProdutos.setForeground(java.awt.Color.WHITE);
        btnCadastroProdutos.setText("Dashboard");
        btnCadastroProdutos.setBorder(null);
        btnCadastroProdutos.addActionListener(evt -> { new DashbordGerente(vendedorLogado).setVisible(true); this.dispose(); });

        btnSair.setBackground(new java.awt.Color(0, 153, 204));
        btnSair.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnSair.setForeground(java.awt.Color.WHITE);
        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.addActionListener(evt -> { this.dispose(); new Login().setVisible(true); });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup().addGap(10,10,10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel4).addGap(5,5,5).addComponent(btnCadastroFuncionario))
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel3).addGap(5,5,5).addComponent(btnRegistroPedidos))
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel5).addGap(5,5,5).addComponent(btnCadastroProdutos))
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel6).addGap(5,5,5).addComponent(btnSair)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup().addGap(20,20,20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel4).addComponent(btnCadastroFuncionario)).addGap(15,15,15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel3).addComponent(btnRegistroPedidos)).addGap(15,15,15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel5).addComponent(btnCadastroProdutos)).addGap(15,15,15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel6).addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 16));
        jLabel1.setText("Catálogo de Produtos");

        btnNovoProduto.setBackground(new java.awt.Color(0, 153, 204));
        btnNovoProduto.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnNovoProduto.setForeground(java.awt.Color.WHITE);
        btnNovoProduto.setText("+ Novo Produto");
        btnNovoProduto.setVisible(vendedorLogado.isGerente());
        btnNovoProduto.addActionListener(evt -> {
            new FormularioCadastroProduto(vendedorLogado, null, this).setVisible(true);
            this.setVisible(false);
        });

        btnExcluir.setBackground(new java.awt.Color(204, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnExcluir.setForeground(java.awt.Color.WHITE);
        btnExcluir.setText("Excluir");
        btnExcluir.setVisible(vendedorLogado.isGerente());
        btnExcluir.addActionListener(evt -> excluirSelecionado());

        jLabel2.setText("Pesquisar:");
        jTextField1.setColumns(20);
        btnPesquisar.setText("Buscar");
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/search.png")));
        btnPesquisar.addActionListener(evt -> pesquisar());
        jTextField1.addActionListener(evt -> pesquisar());

        jScrollPane1.setViewportView(jTable1);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 300));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnNovoProduto).addGap(10,10,10).addComponent(btnExcluir))
                    .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel2).addGap(5,5,5).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5,5,5).addComponent(btnPesquisar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup().addGap(15,15,15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel1).addComponent(btnNovoProduto).addComponent(btnExcluir))
                .addGap(15,15,15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel2).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnPesquisar))
                .addGap(10,10,10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void recarregar() { carregarProdutos(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroFuncionario, btnCadastroProdutos, btnExcluir;
    private javax.swing.JButton btnNovoProduto, btnPesquisar, btnRegistroPedidos, btnSair;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    private javax.swing.JPanel jPanel1, jPanel4, jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
