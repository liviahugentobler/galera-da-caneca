package br.com.galeradacaneca.view;

import br.com.galeradacaneca.dao.VendedorDAO;
import br.com.galeradacaneca.model.Vendedor;
import javax.swing.JOptionPane;

/**
 * Tela de Login — RF003
 * Autentica vendedores e gerentes pelo email + senha.
 */
public class Login extends javax.swing.JFrame {

    private final VendedorDAO vendedorDAO = new VendedorDAO();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Galera da Caneca — Login");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        LName = new javax.swing.JLabel();
        LPassword = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Gadugi", 0, 36));
        jLabel2.setText("GALERA DA CANECA");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/galeradacaneca/view/icon.png")));

        jTextField2.setFont(new java.awt.Font("Gadugi", 0, 12));
        jTextField2.addActionListener(evt -> jPasswordField1.requestFocus());

        jPasswordField1.addActionListener(evt -> realizarLogin());

        LName.setFont(new java.awt.Font("Gadugi", 0, 12));
        LName.setForeground(new java.awt.Color(153, 153, 153));
        LName.setText("Insira o seu e-mail:");

        LPassword.setFont(new java.awt.Font("Gadugi", 0, 12));
        LPassword.setForeground(new java.awt.Color(153, 153, 153));
        LPassword.setText("Insira a sua senha:");

        jToggleButton1.setBackground(new java.awt.Color(0, 102, 255));
        jToggleButton1.setFont(new java.awt.Font("Gadugi", 1, 12));
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Entrar");
        jToggleButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        jToggleButton1.addActionListener(evt -> realizarLogin());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LPassword).addComponent(LName)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField2)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2))
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25).addComponent(LName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30).addComponent(LPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE)));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ── Lógica de autenticação ────────────────────────────────────────────────
    private void realizarLogin() {
        String email = jTextField2.getText().trim();
        String senha = new String(jPasswordField1.getPassword()).trim();

        if (email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o e-mail e a senha.",
                "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Vendedor vendedor = vendedorDAO.autenticar(email, senha);
            if (vendedor == null) {
                JOptionPane.showMessageDialog(this, "E-mail ou senha incorretos.",
                    "Acesso negado", JOptionPane.ERROR_MESSAGE);
                jPasswordField1.setText("");
                jToggleButton1.setSelected(false);
                return;
            }
            this.dispose();
            if (vendedor.isGerente()) {
                new DashbordGerente(vendedor).setVisible(true);
            } else {
                new DashbordFuncionario(vendedor).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao conectar com o banco de dados.\n" + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            jToggleButton1.setSelected(false);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName()); break;
                }
            }
        } catch (Exception ex) { }
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
