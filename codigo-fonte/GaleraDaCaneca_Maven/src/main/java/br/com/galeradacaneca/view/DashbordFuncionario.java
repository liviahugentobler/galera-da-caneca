package br.com.galeradacaneca.view;

import br.com.galeradacaneca.dao.VendaDAO;
import br.com.galeradacaneca.model.Vendedor;
import javax.swing.*;
import java.math.BigDecimal;

/**
 * Dashboard do Funcionário (Vendedor/Supervisor) — RF009
 * Exibe total de vendas pessoais e meta mensal de R$ 2.000,00.
 */
public class DashbordFuncionario extends javax.swing.JFrame {

    private final Vendedor vendedorLogado;
    private final VendaDAO vendaDAO = new VendaDAO();
    private static final double META_VENDEDOR = 2000.00;

    public DashbordFuncionario(Vendedor vendedor) {
        this.vendedorLogado = vendedor;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Galera da Caneca — Funcionário: " + vendedor.getNomeCompleto());
        carregarDados();
    }

    private void carregarDados() {
        try {
            BigDecimal total = vendaDAO.totalPorVendedor(vendedorLogado.getId());
            long qtd = vendaDAO.contarPorVendedor(vendedorLogado.getId());
            lblTotalvendas.setText("R$ " + String.format("%.2f", total));
            lblTotalpedidos.setText(String.valueOf(qtd));
            double pct = (total.doubleValue() / META_VENDEDOR) * 100;
            lblMeta.setText(String.format("Meta: R$ %.2f | %.1f%%", META_VENDEDOR, Math.min(pct, 100)));
        } catch (Exception e) {
            lblTotalvendas.setText("Erro");
            lblTotalpedidos.setText("Erro");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCadastroClientes = new javax.swing.JButton();
        btnRegistroPedidos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        PnlVendas = new javax.swing.JPanel();
        lblTotalvendas = new javax.swing.JLabel();
        PnlPedidos = new javax.swing.JPanel();
        lblTotalpedidos = new javax.swing.JLabel();
        lblMeta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/User.png")));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/File text.png")));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/Log in.png")));

        btnCadastroClientes.setBackground(new java.awt.Color(0, 153, 204));
        btnCadastroClientes.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnCadastroClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastroClientes.setText("Cadastro de Clientes");
        btnCadastroClientes.setBorder(null);
        btnCadastroClientes.addActionListener(evt -> {
            new CadastroClientes(vendedorLogado).setVisible(true);
            this.dispose();
        });

        btnRegistroPedidos.setBackground(new java.awt.Color(0, 153, 204));
        btnRegistroPedidos.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnRegistroPedidos.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistroPedidos.setText("Registro de Vendas");
        btnRegistroPedidos.setBorder(null);
        btnRegistroPedidos.addActionListener(evt ->
            JOptionPane.showMessageDialog(this, "Funcionalidade de registro de vendas disponível nas próximas versões.", "Info", JOptionPane.INFORMATION_MESSAGE));

        btnSair.setBackground(new java.awt.Color(0, 153, 204));
        btnSair.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setBorder(null);
        btnSair.addActionListener(evt -> { this.dispose(); new Login().setVisible(true); });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup().addGap(10,10,10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel4).addGap(5,5,5).addComponent(btnCadastroClientes))
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel3).addGap(5,5,5).addComponent(btnRegistroPedidos))
                    .addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel6).addGap(5,5,5).addComponent(btnSair)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup().addGap(20,20,20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel4).addComponent(btnCadastroClientes))
                .addGap(15,15,15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel3).addComponent(btnRegistroPedidos))
                .addGap(15,15,15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(jLabel6).addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(245, 245, 245));

        PnlVendas.setBackground(new java.awt.Color(0, 153, 204));
        lblTotalvendas.setFont(new java.awt.Font("Gadugi", 1, 22));
        lblTotalvendas.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalvendas.setText("R$ 0,00");
        javax.swing.GroupLayout pvl = new javax.swing.GroupLayout(PnlVendas);
        PnlVendas.setLayout(pvl);
        pvl.setHorizontalGroup(pvl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pvl.createSequentialGroup().addContainerGap().addComponent(lblTotalvendas).addContainerGap()));
        pvl.setVerticalGroup(pvl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pvl.createSequentialGroup().addContainerGap().addComponent(lblTotalvendas).addContainerGap()));

        PnlPedidos.setBackground(new java.awt.Color(0, 102, 153));
        lblTotalpedidos.setFont(new java.awt.Font("Gadugi", 1, 22));
        lblTotalpedidos.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalpedidos.setText("0");
        javax.swing.GroupLayout ppl = new javax.swing.GroupLayout(PnlPedidos);
        PnlPedidos.setLayout(ppl);
        ppl.setHorizontalGroup(ppl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(ppl.createSequentialGroup().addContainerGap().addComponent(lblTotalpedidos).addContainerGap()));
        ppl.setVerticalGroup(ppl.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(ppl.createSequentialGroup().addContainerGap().addComponent(lblTotalpedidos).addContainerGap()));

        lblMeta = new javax.swing.JLabel("Meta: R$ 2000,00 | 0%");
        lblMeta.setFont(new java.awt.Font("Gadugi", 1, 13));
        lblMeta.setForeground(new java.awt.Color(0, 102, 153));

        jLabel1 = new javax.swing.JLabel("Minhas Vendas");
        jLabel1.setFont(new java.awt.Font("Gadugi", 0, 12));
        jLabel2 = new javax.swing.JLabel("Pedidos Registrados");
        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 12));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup().addGap(20,20,20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1).addComponent(PnlVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2).addComponent(PnlPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMeta))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup().addGap(30,30,30)
                .addComponent(jLabel1).addGap(5,5,5)
                .addComponent(PnlVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20,20,20).addComponent(jLabel2).addGap(5,5,5)
                .addComponent(PnlPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20,20,20).addComponent(lblMeta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlPedidos;
    private javax.swing.JPanel PnlVendas;
    private javax.swing.JButton btnCadastroClientes;
    private javax.swing.JButton btnRegistroPedidos;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblMeta;
    private javax.swing.JLabel lblTotalpedidos;
    private javax.swing.JLabel lblTotalvendas;
    // End of variables declaration//GEN-END:variables
}
