package br.com.galeradacaneca.model;

public class Pedido {

    private int id;
    private String data;
    private String status;
    private double valorTotal;

    public void adicionarItem() {
        System.out.println("Item adicionado ao pedido");
    }

    public void calcularTotal() {
        System.out.println("Total calculado");
    }

    public void atualizarStatus() {
        System.out.println("Status do pedido atualizado");
    }
}
