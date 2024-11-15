package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaUseCaseImpl implements SalaUseCase {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public void criar(Sala sala) {
        salaRepository.criar(sala);
    }

    @Override
    public void deletar(int id) {
        salaRepository.deletar(id);
    }


    @Override
    public void atualizar(int id, Sala sala) {
        salaRepository.atualizar(id, sala);
    }

    @Override
    public List<Sala> listar() {
        return salaRepository.listar();
    }

    @Override
    public Sala listarPorID(int id) {
        return salaRepository.listarPorID(id);
    }

    @Override
    public void adicionarCategoria(int salaID, int categoryID) {
        salaRepository.adicionarCategoria(salaID, categoryID);
    }

    @Override
    public List<Sala> listarCategoria(int salaID) {
        return salaRepository.listarCategoria(salaID);
    }

    @Override
    public void atualizarCategoria(int salaID, Sala sala) {
        salaRepository.atualizarCategoria(salaID, sala);
    }

    @Override
    public void deletarCategoria(int id) {
        salaRepository.deletarCategoria(id);
    }

    @Override
    public void adicionarTurma(int salaID, int turmaID) {
        salaRepository.adicionarTurma(salaID, turmaID);
    }

    @Override
    public List<Sala> listarTurma(int turmaID) {
        return salaRepository.listarTurma(turmaID);
    }

    @Override
    public void atualizarTurma(int salaID, Sala sala) {
        salaRepository.atualizarTurma(salaID, sala);
    }

    @Override
    public void deletarTurma(int id) {
        salaRepository.deletarTurma(id);
    }
}
