package com.cronograma.Cesurg.core.domain.contract.contractCurso;

import com.cronograma.Cesurg.core.domain.entity.Curso;
import com.cronograma.Cesurg.core.domain.entity.Materia;

import java.util.List;

public interface CursoRepository {
    //criar um curso
    public void criar(Curso curso);

    //deletar um curso
    public void deletar(int id);

    //Atualizar Curso
    public void atualizar(int id, Curso curso);

    // listar curso
    public List<Curso> listarCursos();

    // inserir materia no curso
    public void inserirMateria(int idCurso, int idMateria);

    // Deletar materia do curso
    public void deletarMateria(int idCurso, int idMateria);

    //listar materia num curso
    public List<Materia> listarMateria(int idCurso);
}
