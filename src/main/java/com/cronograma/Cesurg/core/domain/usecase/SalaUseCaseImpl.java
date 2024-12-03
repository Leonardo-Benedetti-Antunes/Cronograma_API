package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.SalaRepository;
import com.cronograma.Cesurg.core.domain.contract.SalaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaUseCaseImpl implements SalaUseCase {
    @Autowired
    private SalaRepository salaRepository;

    // Métodos básicos de sala
    @Override
    public Sala criar(Sala sala) {
        return salaRepository.criar(sala);
    }

    @Override
    public Sala deletar(int id) {
        return salaRepository.deletar(id);
    }

    @Override
    public Sala atualizar(int id, Sala sala) {
        return salaRepository.atualizar(id, sala);
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
    public SalaCategoriaCreat adicionarCategoria(int salaID, int categoriaID) {
        return salaRepository.adicionarCategoria(salaID, categoriaID);
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
    public SalaCategoriaCreat atualizarCategoria(int id, int categoriaID) {
        return salaRepository.atualizarCategoria(id, categoriaID);
    }

    @Override
    public SalaCategoriaCreat deletarCategoria(int id) {
        return salaRepository.deletarCategoria(id);
    }

    // Métodos de sala_turma
    @Override
    public SalaTurmaCreat adicionarTurma(int salaID, int turmaID) {
        return salaRepository.adicionarTurma(salaID, turmaID);
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
    public SalaTurmaCreat atualizarTurma(int id, int salaID) {
        return salaRepository.atualizarTurma(id, salaID);
    }

    @Override
    public SalaTurmaCreat deletarTurma(int id) {
        return salaRepository.deletarTurma(id);
    }

    // Métodos de sala_materia
    @Override
    public SalaMateriaCreat adicionarMateria(int salaID, int materiaID) {
        return salaRepository.adicionarMateria(salaID, materiaID);
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
    public SalaMateriaCreat atualizarMateria(int id, int materiaID) {
        return salaRepository.atualizarMateria(id, materiaID);
    }

    @Override
    public SalaMateriaCreat deletarMateria(int id) {
        return salaRepository.deletarMateria(id);
    }

}
