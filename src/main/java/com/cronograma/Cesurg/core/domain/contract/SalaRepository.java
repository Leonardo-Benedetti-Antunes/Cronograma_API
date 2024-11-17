package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.SalaCategoriaOutput;
import com.cronograma.Cesurg.core.dto.SalaTurmaOutput;

import java.util.List;

public interface SalaRepository {
    public void criar(Sala sala);
    public void deletar(int id);
    public void atualizar(int id, Sala sala);
    public List<Sala> listar();
    public Sala listarPorID(int id);
    // Fazer vinculos com as tabelas sala_turma e sala_categoria
    public void adicionarCategoria(int salaID, int categoriaID);
    public SalaCategoriaOutput listarCategoria(int salaID);
    public void atualizarCategoria(int salaID, int categoriaID);
    public void deletarCategoria(int id);
    public void adicionarTurma(int salaID, int turmaID);
    public List<SalaTurmaOutput> listarTurma(int turmaID);
    public void atualizarTurma(int salaID, Sala sala);
    public void deletarTurma(int id);
}
