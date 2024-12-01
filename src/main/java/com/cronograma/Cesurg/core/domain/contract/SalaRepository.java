package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.SalaCategoriaOutput;
import com.cronograma.Cesurg.core.dto.SalaMateriaOutput;
import com.cronograma.Cesurg.core.dto.SalaTurmaOutput;

import java.util.List;

public interface SalaRepository {
    public void criar(Sala sala);
    public void deletar(int id);
    public void atualizar(int id, Sala sala);
    public List<Sala> listar();
    public Sala listarPorID(int id);
    // Fazer vinculos com as sala_categoria
    public void adicionarCategoria(int salaID, int categoriaID); // Faz a vinculação entre sala e categoria;
    public SalaCategoriaOutput listarSalaCategoriaPorID(int salaID); // Lista a categoria de uma sala
    public List<SalaCategoriaOutput> listarSalaCategoria(); // Lista todas as vinculações que existem na tabela sala_categoria
    public void atualizarCategoria(int id, int categoriaID); //Em construção...
    public void deletarCategoria(int id); //Em construção...
    // Fazer vinculos com as tabelas sala_turma
    public void adicionarTurma(int salaID, int turmaID); // // Faz a vinculação entre sala e turma;
    public List<SalaTurmaOutput> listarSalaTurmaPorID(int salaID); // Lista a(s) turma(s) de uma sala
    public List<SalaTurmaOutput> listarSalaTurma(); // Lista todas as vinculações que existem na tabela sala_turma
    public void atualizarTurma(int salaID, Sala sala); //Em construção...
    public void deletarTurma(int id); //Em construção...
    // Fazer vinculos com a tabela sala_materia
    public void adicionarMateria(int salaID, int materiaID); // Faz a vinculação entre sala e turma;
    public List<SalaMateriaOutput> listarSalaMateriaPorID(int salaID); // Lista a(s) materia(s) de uma sala
    public List<SalaMateriaOutput> listarSalaMateria(); // Lista todas as vinculações que existem na tabela sala_materia
    public void atualizarMateria(int salaID, int materiaID); // Em construção...
    public void deletarMateria(int id); //Em construção...
}
