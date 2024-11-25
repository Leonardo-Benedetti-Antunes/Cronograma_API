package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Materia;
import com.cronograma.Cesurg.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorRepository {
  
    // criar professor
    public void criar (Professor professor);

    // deletar professor
    public void deletar (int id);

    // desativar e ativar professor
    public void atualizarStatus(int id, Professor professor);

    // atualizar professor
    public void atualizarProfesor (int id, Professor professor);

    // listar professor
    public List<Professor> listarProfessor();

    // pegar um professor especifico
    public Professor listarPorId(int id);

    // inserir uma materia no professor
    public void adicionarMateriaProfessor(int idProfessor, int idMateria);

    // listar materias do professor
    public List<Materia> listarMateriaProfessor(int idProfessor);

    public void removerDiaDoProfessor(int idProfessor, int idDia);

    public void removerMateriaDoProfessor (int idProfessor, int idMateria);
}

