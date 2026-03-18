package br.com.galeradacaneca.view;

import br.com.galeradacaneca.dao.ClienteDAO;
import br.com.galeradacaneca.model.Cliente;
import br.com.galeradacaneca.model.Vendedor;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Formulário de cadastro e edição de Cliente — RF001
 */
public class FormularioCadastroClientes extends javax.swing.JFrame {

    private final Vendedor vendedorLogado;
    private final Cliente clienteEditando;
    private final CadastroClientes telaAnterior;
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /** Construtor para NOVO cliente */
    public FormularioCadastroClientes(Vendedor vendedor, Cliente cliente, CadastroClientes anterior) {
        this.vendedorLogado = vendedor;
        this.clienteEditando = cliente;
        this.telaAnterior = anterior;
        initComponents();
        setLocationRelativeTo(null);
        setTitle(cliente == null ? "Novo Cliente" : "Editar Cliente");
        if (cliente != null) preencherFormulario(cliente);
    }

    private void preencherFormulario(Cliente c) {
        txtNomeCompleto.setText(c.getNomeCompleto());
        txtCpf.setText(c.getCpf());
        if (c.getNascimento() != null) txtDataNascimento.setText(c.getNascimento().format(FMT));
        txtTelefone.setText(c.getTelefone());
        txtEmail.setText(c.getEmail());
        txtEndereco.setText(c.getEndereco());
        jComboBox2.setSelectedItem(c.getSexo() != null ? c.getSexo() : "M");
    }

    private void salvar() {
        String nome  = txtNomeCompleto.getText().trim();
        String cpf   = txtCpf.getText().trim().replaceAll("[^0-9]", "");
        String nasc  = txtDataNascimento.getText().trim();
        String tel   = txtTelefone.getText().trim();
        String email = txtEmail.getText().trim();
        String end   = txtEndereco.getText().trim();
        String sexo  = (String) jComboBox2.getSelectedItem();
        String senha = new String(txtSenha.getPassword()).trim();

        if (nome.isEmpty() || cpf.isEmpty() || nasc.isEmpty() || tel.isEmpty() || email.isEmpty() || end.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF deve conter 11 dígitos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        LocalDate dataNasc;
        try {
            dataNasc = LocalDate.parse(nasc, FMT);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Use o formato dd/MM/yyyy.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Cliente c = clienteEditando != null ? clienteEditando : new Cliente();
            c.setNomeCompleto(nome);
            c.setCpf(cpf);
            c.setNascimento(dataNasc);
            c.setTelefone(tel);
            c.setEmail(email);
            c.setEndereco(end);
            c.setSexo(sexo);
            if (!senha.isEmpty()) c.setSenha(senha);
            else if (clienteEditando == null) c.setSenha("123456"); // senha padrão

            if (clienteEditando == null) clienteDAO.salvar(c);
            else clienteDAO.atualizar(c);

            JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");
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
        txtNomeCompleto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtDataNascimento = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setForeground(java.awt.Color.WHITE); jLabel1.setText("Nome Completo:");
        jLabel2.setForeground(java.awt.Color.WHITE); jLabel2.setText("CPF:");
        jLabel3.setForeground(java.awt.Color.WHITE); jLabel3.setText("Data Nascimento (dd/MM/yyyy):");
        jLabel4.setForeground(java.awt.Color.WHITE); jLabel4.setText("Telefone:");
        jLabel5.setForeground(java.awt.Color.WHITE); jLabel5.setText("Sexo:");
        jLabel6.setForeground(java.awt.Color.WHITE); jLabel6.setText("Email:");
        jLabel7.setForeground(java.awt.Color.WHITE); jLabel7.setText("Senha:");
        jLabel9.setForeground(java.awt.Color.WHITE); jLabel9.setText("Endereço:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"M", "F"}));

        btnEnviar.setBackground(new java.awt.Color(0, 80, 160));
        btnEnviar.setForeground(java.awt.Color.WHITE);
        btnEnviar.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnEnviar.setText("Salvar");
        btnEnviar.addActionListener(evt -> salvar());

        btnCancelar.setBackground(new java.awt.Color(150, 150, 150));
        btnCancelar.setForeground(java.awt.Color.WHITE);
        btnCancelar.setFont(new java.awt.Font("Gadugi", 1, 12));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(evt -> {
            telaAnterior.setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addGap(20,20,20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1).addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2).addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3).addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4).addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9).addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7).addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(10,10,10).addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup().addGap(15,15,15)
                .addComponent(jLabel1).addGap(3,3,3).addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel2).addGap(3,3,3).addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel3).addGap(3,3,3).addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel4).addGap(3,3,3).addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel5).addGap(3,3,3).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel6).addGap(3,3,3).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel9).addGap(3,3,3).addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(8,8,8)
                .addComponent(jLabel7).addGap(3,3,3).addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15,15,15)
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
