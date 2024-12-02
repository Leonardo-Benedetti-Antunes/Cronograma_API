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

    // Métodos básicos de sala
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

    // Métodos de sala_categoria
    @Override
    public void adicionarCategoria(int salaID, int categoriaID) {
        salaRepository.adicionarCategoria(salaID, categoriaID);
    }

    @Override
    public SalaCategoriaOutput listarSalaCategoriaPorID(int salaID) {
        return salaRepository.listarSalaCategoriaPorID(salaID);
    }

    @Override
    public List<SalaCategoriaOutput> listarSalaCategoria() {
        return salaRepository.listarSalaCategoria();
    }

    @Override
    public void atualizarCategoria(int id, int categoriaID) {
        salaRepository.atualizarCategoria(id, categoriaID);
    }

    @Override
    public void deletarCategoria(int id) {
        salaRepository.deletarCategoria(id);
    }

    // Métodos de sala_turma
    @Override
    public void adicionarTurma(int salaID, int turmaID) {
        salaRepository.adicionarTurma(salaID, turmaID);
    }

    @Override
    public List<SalaTurmaOutput> listarSalaTurmaPorID(int salaID) {
        return salaRepository.listarSalaTurmaPorID(salaID);
    }

    @Override
    public List<SalaTurmaOutput> listarSalaTurma() {
        return salaRepository.listarSalaTurma();
    }

    @Override
    public void atualizarTurma(int id, int salaID) {
        salaRepository.atualizarTurma(id, salaID);
    }

    @Override
    public void deletarTurma(int id) {
        salaRepository.deletarTurma(id);
    }

    // Métodos de sala_materia
    @Override
    public void adicionarMateria(int salaID, int materiaID) {
        salaRepository.adicionarMateria(salaID, materiaID);
    }

    @Override
    public List<SalaMateriaOutput> listarSalaMateriaPorID(int salaID) {
        return salaRepository.listarSalaMateriaPorID(salaID);
    }

    @Override
    public List<SalaMateriaOutput> listarSalaMateria() {
        return salaRepository.listarSalaMateria();
    }

    @Override
    public void atualizarMateria(int id, int materiaID) {
        salaRepository.atualizarMateria(id, materiaID);
    }

    @Override
    public void deletarMateria(int id) {
        salaRepository.deletarMateria(id);
    }

}
