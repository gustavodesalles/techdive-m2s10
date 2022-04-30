package br.senai.m2s10.repository;

import br.senai.m2s10.model.Curso;
import br.senai.m2s10.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class UsuarioRepo {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioRepo() {
        usuarios.add(new Usuario("admin", "Administrador", "1234"));
        usuarios.add(new Usuario("user", "Usuário", "2501"));
    }

    public List<Usuario> obterUsuarios() {
        Collections.sort(usuarios, Comparator.comparing((Usuario::getNome)));
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> obterPor(String login, String senha) {
        return usuarios.stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u -> u.getSenha().equals(senha))
                .findFirst();
    }
}
