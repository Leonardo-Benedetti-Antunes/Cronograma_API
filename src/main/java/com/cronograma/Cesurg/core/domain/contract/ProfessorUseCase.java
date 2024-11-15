package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorUseCase {
    public void criar(Professor professor);
    public void deletar(int id);
    public void atualizarStatus( int id, Professor professor);
    public void atualizar(int id, Professor professor);
    public List<Professor> listar();
    public Professor listarPorId(int id);
}
