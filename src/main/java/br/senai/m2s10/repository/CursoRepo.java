package br.senai.m2s10.repository;

import br.senai.m2s10.model.Curso;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class CursoRepo {

    private List<Curso> cursos = new ArrayList<>();

    public CursoRepo() {
        cursos.add(new Curso("JAVA", "Java", LocalDate.of(2022, 5, 2),
                LocalDate.of(2022, 5, 5)));
        cursos.add(new Curso("PYTHON", "Python", LocalDate.of(2022, 6, 6),
                LocalDate.of(2022, 6, 10)));
        cursos.add(new Curso("CLOJURE", "Clojure", LocalDate.of(2022, 4, 26),
                LocalDate.of(2022, 4, 27)));
    }

    public List<Curso> obter() {
        cursos.sort(Comparator.comparing(Curso::getDataInicio));
        return cursos;
    }

    public void inserir(Curso curso) {
        cursos.add(curso);
    }

    public void alterar(Curso cursoAtualizado) {
        excluir(cursoAtualizado.getCodigo());
        cursos.add(cursoAtualizado);
    }

    public void excluir(String codCurso) {
        cursos.removeIf(curso -> curso.getCodigo().equals(codCurso));
    }

}
