package br.com.galeradacaneca.model;

public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;

    public void atualizarEstoque() {
        System.out.println("Estoque atualizado");
    }

    public void atualizarPreco() {
        System.out.println("Preço atualizado");
    }
}
