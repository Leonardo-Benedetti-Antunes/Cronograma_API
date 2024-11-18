package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.CursoRepository;
import com.cronograma.Cesurg.core.domain.contract.CursoUseCase;
import com.cronograma.Cesurg.core.domain.entity.Curso;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoUseCaseImpl implements CursoUseCase {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void criar(Curso curso) {
        cursoRepository.criar(curso);
    }

    @Override
    public void deletar(int id) {
        cursoRepository.deletar(id);
    }

    @Override
    public void atualizar(int id, Curso curso) {
        cursoRepository.atualizar(id, curso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.listarCursos();
    }

    @Override
    public void inserirMateria(int idCurso, int idMateria) {
        cursoRepository.inserirMateria(idCurso, idMateria);
    }

    @Override
    public void deletarMateria(int idCurso, int idMateria) {

    }

    @Override
    public List<Materia> listarMateria(int idCurso) {
        return cursoRepository.listarMateria(idCurso);
    }
}

