package br.com.galeradacaneca.main;

import br.com.galeradacaneca.model.Gerente;
import br.com.galeradacaneca.model.Produto;
import br.com.galeradacaneca.model.Cliente;
import br.com.galeradacaneca.model.Pedido;

public class Principal {

    public static void main(String[] args) {

        Gerente gerente = new Gerente();
        gerente.setNome("Administrador");
        gerente.setLogin("admin");

        Produto produto = new Produto();
        produto.atualizarPreco();
        produto.atualizarEstoque();

        Cliente cliente = new Cliente();
        cliente.setNome("Lívia");

        Pedido pedido = new Pedido();
        pedido.adicionarItem();
        pedido.calcularTotal();
        pedido.atualizarStatus();

        System.out.println("Protótipo executado com sucesso!");
    }
}
