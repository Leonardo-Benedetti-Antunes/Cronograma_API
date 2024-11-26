package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.SalaCategoriaOutput;
import com.cronograma.Cesurg.core.dto.SalaMateriaOutput;
import com.cronograma.Cesurg.core.dto.SalaTurmaOutput;
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
    public void adicionarCategoria(int salaID, int categoriaID) {
        salaRepository.adicionarCategoria(salaID, categoriaID);
    }

    @Override
    public SalaCategoriaOutput listarCategoria(int salaID) {
        return salaRepository.listarCategoria(salaID);
    }

    @Override
    public void atualizarCategoria(int salaID, int categoriaID) {
        salaRepository.atualizarCategoria(salaID, categoriaID);
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
    public List<SalaTurmaOutput> listarTurma(int salaID) {
        return salaRepository.listarTurma(salaID);
    }

    @Override
    public void atualizarTurma(int salaID, Sala sala) {
        salaRepository.atualizarTurma(salaID, sala);
    }

    @Override
    public void deletarTurma(int id) {
        salaRepository.deletarTurma(id);
    }

    @Override
    public void adicionarMateria(int salaID, int materiaID) {
        salaRepository.adicionarMateria(salaID, materiaID);
    }

    @Override
    public List<SalaMateriaOutput> listarMateria(int salaID) {
        return salaRepository.listarMateria(salaID);
    }

    @Override
    public void atualizarMateria(int salaID, Sala sala) {
        salaRepository.atualizarMateria(salaID, sala);
    }

    @Override
    public void deletarMateria(int id) {
        salaRepository.deletarMateria(id);
    }

}
