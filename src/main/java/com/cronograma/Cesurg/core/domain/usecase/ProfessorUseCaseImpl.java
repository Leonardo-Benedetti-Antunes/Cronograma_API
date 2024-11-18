package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.ProfessorRepository;
import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
import com.cronograma.Cesurg.core.domain.entity.DiasdaSemana;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import com.cronograma.Cesurg.core.domain.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorUseCaseImpl implements ProfessorUseCase {
    @Autowired
    private ProfessorRepository professorRepository;


    @Override
    public void criar(Professor professor) {
        professorRepository.criar(professor);
    }

    @Override
    public void deletar(int id) {
        professorRepository.deletar(id);
    }

    @Override
    public void atualizarStatus(int id, Professor professor) {
        professorRepository.atualizarStatus(id, professor);
    }

    @Override
    public void atualizarProfesor(int id, Professor professor) {
        professorRepository.atualizarProfesor(id, professor);
    }

    @Override
    public List<Professor> listarProfessor() {
        return professorRepository.listarProfessor();
    }

    @Override
    public Professor listarPorId(int id) {
        return professorRepository.listarPorId(id);
    }

    @Override
    public List<DiasdaSemana> listarProfessorDia(int idProfessor) {
        return professorRepository.listarProfessorDia(idProfessor);
    }

    @Override
    public void adicionarDiaProfessor(int idProfessor, int idDia) {
        professorRepository.adicionarDiaProfessor(idProfessor,idDia);
    }

    @Override
    public void adicionarMateriaProfessor(int idProfessor, int idMateria) {
        professorRepository.adicionarMateriaProfessor(idProfessor, idMateria);
    }

    @Override
    public List<Materia> listarMateriaProfessor(int idProfessor) {
        return professorRepository.listarMateriaProfessor(idProfessor);
    }

    @Override
    public void removerDiaDoProfessor(int idProfessor, int idDia) {
        professorRepository.removerDiaDoProfessor(idProfessor, idDia);
    }

    @Override
    public void removerMateriaDoProfessor(int idProfessor, int idMateria) {
        professorRepository.removerMateriaDoProfessor(idProfessor, idMateria);
    }
}

