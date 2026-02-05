package br.com.galeradacaneca.model;

public class Pagamento {

    private String tipoPagamento;
    private String statusPagamento;

    public void processarPagamento() {
        System.out.println("Pagamento processado");
    }

    public void confirmarPagamento() {
        System.out.println("Pagamento confirmado");
    }
}
