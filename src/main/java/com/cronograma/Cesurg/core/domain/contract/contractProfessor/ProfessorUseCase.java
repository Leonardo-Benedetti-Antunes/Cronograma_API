package com.cronograma.Cesurg.core.domain.contract.contractProfessor;

import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import com.cronograma.Cesurg.core.domain.entity.Materia;

import java.util.List;

public interface ProfessorUseCase {
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

    // listar dias que o professor esta
    public List<DiasdaSemana> listarProfessorDia(int idProfessor);

    // adicionar um dia no professor
    public void adicionarDiaProfessor(int idProfessor, int idDia);

    // inserir uma materia no professor
    public void adicionarMateriaProfessor(int idProfessor, int idMateria);

    // listar materias do professor
    public List<Materia> listarMateriaProfessor(int idProfessor);

    public void removerDiaDoProfessor(int idProfessor, int idDia);

    public void removerMateriaDoProfessor (int idProfessor, int idMateria);
}
