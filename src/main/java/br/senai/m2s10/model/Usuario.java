package br.senai.m2s10.model;

import javax.validation.constraints.NotNull;

public class Usuario {

    @NotNull
    private String login;

    @NotNull
    private String nome;

    @NotNull
    private String senha;

    public Usuario() {
    }

    public Usuario(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
