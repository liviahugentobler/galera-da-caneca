package br.com.galeradacaneca.view;

import br.com.galeradacaneca.dao.ProdutoDAO;
import br.com.galeradacaneca.model.Produto;
import br.com.galeradacaneca.model.Vendedor;
import javax.swing.*;
import java.math.BigDecimal;

/**
 * Formulário de cadastro e edição de Produto — RF005, RF010
 * Apenas Gerente pode salvar.
 */
public class FormularioCadastroProduto extends javax.swing.JFrame {

    private final Vendedor vendedorLogado;
    private final Produto produtoEditando;
    private final CadastroProduto telaAnterior;
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public FormularioCadastroProduto(Vendedor vendedor, Produto produto, CadastroProduto anterior) {
        this.vendedorLogado = vendedor;
        this.produtoEditando = produto;
        this.telaAnterior = anterior;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(produto == null ? "Novo Produto" : "Editar Produto");
        if (produto != null) preencherFormulario(produto);
    }

    private void preencherFormulario(Produto p) {
        txtNomeProduto.setText(p.getNomeProd());
        txtPreco.setText(p.getPreco().toPlainString());
        txtQuantidade.setText(String.valueOf(p.getQuantidade()));
        txtEntradas.setText(String.valueOf(p.getEntradas()));
        txtSaidas.setText(String.valueOf(p.getSaidas()));
    }

    private void salvar() {
        if (!vendedorLogado.isGerente()) {
            JOptionPane.showMessageDialog(this, "Apenas gerentes podem cadastrar produtos.", "Acesso negado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nome  = txtNomeProduto.getText().trim();
        String precoStr = txtPreco.getText().trim().replace(",", ".");
        String qtdStr   = txtQuantidade.getText().trim();
        String entStr   = txtEntradas.getText().trim();
        String saiStr   = txtSaidas.getText().trim();

        if (nome.isEmpty() || precoStr.isEmpty() || qtdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha Nome, Preço e Quantidade.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        BigDecimal preco;
        int qtd, ent, sai;
        try {
            preco = new BigDecimal(precoStr);
            qtd   = Integer.parseInt(qtdStr);
            ent   = entStr.isEmpty() ? 0 : Integer.parseInt(entStr);
            sai   = saiStr.isEmpty() ? 0 : Integer.parseInt(saiStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valores numéricos inválidos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Produto p = produtoEditando != null ? produtoEditando : new Produto();
            p.setNomeProd(nome);
            p.setPreco(preco);
            p.setQuantidade(qtd);
            p.setEntradas(ent);
            p.setSaidas(sai);

            if (produtoEditando == null) produtoDAO.salvar(p);
            else produtoDAO.atualizar(p);

            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            telaAnterior.recarregar();
            telaAnterior.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        txtNomeProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        txtSaidas = new javax.swing.JTextField();
        txtEntradas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setForeground(java.awt.Color.WHITE); jLabel1.setText("Nome Produto:");
        jLabel2.setForeground(java.awt.Color.WHITE); jLabel2.setText("Preço (ex: 29.90):");
        jLabel3.setForeground(java.awt.Color.WHITE); jLabel3.setText("Quantidade em Estoque:");
        jLabel8.setForeground(java.awt.Color.WHITE); jLabel8.setText("Saídas:");
        jLabel9.setForeground(java.awt.Color.WHITE); jLabel9.setText("Entradas:");

        btnEnviar.setBackground(new java.awt.Color(0, 80, 160));
        btnEnviar.setForeground(java.awt.Color.WHITE);
        btnEnviar.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnEnviar.setText("Salvar");
        btnEnviar.addActionListener(evt -> salvar());

        btnCancelar.setBackground(new java.awt.Color(150, 150, 150));
        btnCancelar.setForeground(java.awt.Color.WHITE);
        btnCancelar.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> { telaAnterior.setVisible(true); this.dispose(); });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addGap(20,20,20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1).addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2).addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3).addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9).addComponent(txtEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8).addComponent(txtSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(10,10,10).addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addGap(15,15,15)
                .addComponent(jLabel1).addGap(3,3,3).addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel2).addGap(3,3,3).addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel3).addGap(3,3,3).addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel9).addGap(3,3,3).addComponent(txtEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel8).addGap(3,3,3).addComponent(txtSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15,15,15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar, btnEnviar;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel8, jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEntradas, txtNomeProduto, txtPreco, txtQuantidade, txtSaidas;
    // End of variables declaration//GEN-END:variables
}
