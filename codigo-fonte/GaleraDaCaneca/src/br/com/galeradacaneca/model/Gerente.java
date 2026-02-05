package br.com.galeradacaneca.model;

public class Gerente extends Funcionario {

    public void cadastrarFuncionario() {
        System.out.println("Funcionário cadastrado");
    }

    public void cadastrarProduto() {
        System.out.println("Produto cadastrado");
    }

    public void editarProduto() {
        System.out.println("Produto editado");
    }

    public void controlarEstoque() {
        System.out.println("Estoque atualizado");
    }

    public void realizarBackup() {
        System.out.println("Backup realizado");
    }

    public void alterarSenha() {
        System.out.println("Senha alterada pelo gerente");
    }
}
