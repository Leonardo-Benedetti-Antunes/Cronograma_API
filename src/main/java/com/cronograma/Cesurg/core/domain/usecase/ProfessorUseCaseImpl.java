package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.ProfessorRepository;
import com.cronograma.Cesurg.core.domain.contract.ProfessorUseCase;
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
    public void atualizar(int id, Professor professor) {
        professorRepository.atualizar(id, professor);
    }

    @Override
    public List<Professor> listar() {
        return professorRepository.listar();
    }

    @Override
    public Professor listarPorId(int id) {
        return professorRepository.listarPorId(id);
    }
}
