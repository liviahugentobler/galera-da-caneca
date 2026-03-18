package br.com.galeradacaneca.main;

import br.com.galeradacaneca.dao.JPAUtil;
import br.com.galeradacaneca.view.Login;

/**
 * Ponto de entrada da aplicação Galera da Caneca
 */
public class Principal {

    public static void main(String[] args) {
        // Inicializa o EntityManagerFactory ao iniciar
        try {
            JPAUtil.getFactory();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "Erro ao conectar com o banco de dados.\n" +
                "Verifique se o MySQL está rodando e se o banco 'Galera_da_Caneca' existe.\n\n" +
                "Detalhe: " + e.getMessage(),
                "Erro de Conexão", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // Aplica Look and Feel Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        // Abre a tela de login
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));

        // Garante fechamento do EntityManagerFactory ao encerrar
        Runtime.getRuntime().addShutdownHook(new Thread(JPAUtil::close));
    }
}
