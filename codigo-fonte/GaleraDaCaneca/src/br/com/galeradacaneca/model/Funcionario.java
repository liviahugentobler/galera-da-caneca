package br.com.galeradacaneca.model;

public class Funcionario extends Usuario {

    protected double metaMensal;
    protected double totalVendas;

    public void cadastrarCliente() {
        System.out.println("Cliente cadastrado pelo funcionário");
    }

    public void registrarPedido() {
        System.out.println("Pedido registrado pelo funcionário");
    }
}
