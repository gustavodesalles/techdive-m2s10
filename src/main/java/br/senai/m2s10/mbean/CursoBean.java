package br.senai.m2s10.mbean;

import br.senai.m2s10.model.Curso;
import br.senai.m2s10.repository.CursoRepo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CursoBean implements Serializable {

    @Inject
    private CursoRepo cursoRepo;

    private List<Curso> cursos = new ArrayList<>();

    private Curso curso = new Curso();

    public void onload() {
        List<Curso> cursosBD = cursoRepo.obter();
        cursos = cursosBD;
    }

    public String excluir(Curso curso) {
        cursoRepo.excluir(curso.getCodigo());
        return null;
    }

    public String editar(Curso curso) {
        this.curso = curso;
        return "cadastro?faces-redirect=true";
    }

    public String salvar() {
        boolean novo = !cursos.stream().anyMatch(c -> c.equals(curso));
        if (novo) {
            cursoRepo.inserir(curso);
        } else {
            cursoRepo.alterar(curso);
        }
        this.curso = new Curso();
        return "principal?faces-redirect=true";
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
