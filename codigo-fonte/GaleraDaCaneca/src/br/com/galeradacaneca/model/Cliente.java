package br.com.galeradacaneca.model;

public class Cliente extends Usuario {

    private String cpf;
    private String endereco;

    public void realizarPedido() {
        System.out.println("Pedido realizado pelo cliente");
    }

    public void acompanharPedido() {
        System.out.println("Acompanhando pedido");
    }
}
