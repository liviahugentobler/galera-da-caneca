package br.com.galeradacaneca.model;

public class Usuario {

    protected int id;
    protected String nome;
    protected String login;
    protected String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void login() {
        System.out.println("Usuário autenticado");
    }

    public void logout() {
        System.out.println("Usuário deslogado");
    }
}
