package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Sala;
import com.cronograma.Cesurg.core.dto.*;

import java.util.List;

public interface SalaUseCase {
    public Sala criar(Sala sala);
    public Sala deletar(int id);
    public Sala atualizar(int id, Sala sala);
    public List<Sala> listar();
    public Sala listarPorID(int id);
    // Fazer vinculos com as sala_categoria
    public SalaCategoriaCreat adicionarCategoria(int salaID, int categoriaID); // Faz a vinculação entre sala e categoria;
    public SalaCategoriaOutput listarSalaCategoriaPorID(int salaID); // Lista a categoria de uma sala
    public List<SalaCategoriaOutput> listarSalaCategoria(); // Lista todas as vinculações que existem na tabela sala_categoria
    public SalaCategoriaCreat atualizarCategoria(int id, int categoriaID); //Atualiza a categoria de alguma sala
    public SalaCategoriaCreat deletarCategoria(int id); //Deleta a vinculação entre sala e categoria
    // Fazer vinculos com as tabelas sala_turma
    public SalaTurmaCreat adicionarTurma(int salaID, int turmaID); // // Faz a vinculação entre sala e turma;
    public List<SalaTurmaOutput> listarSalaTurmaPorID(int salaID); // Lista a(s) turma(s) de uma sala
    public List<SalaTurmaOutput> listarSalaTurma(); // Lista todas as vinculações que existem na tabela sala_turma
    public SalaTurmaCreat atualizarTurma(int id, int salaID); // Atualiza a turma de alguma sala
    public SalaTurmaCreat deletarTurma(int id); //Deleta a vinculação entre sala e turma.
    // Fazer vinculos com a tabela sala_materia
    public SalaMateriaCreat adicionarMateria(int salaID, int materiaID); // Faz a vinculação entre sala e turma;
    public List<SalaMateriaOutput> listarSalaMateriaPorID(int salaID); // Lista a(s) materia(s) de uma sala
    public List<SalaMateriaOutput> listarSalaMateria(); // Lista todas as vinculações que existem na tabela sala_materia
    public SalaMateriaCreat atualizarMateria(int id, int materiaID); // Atualiza a turma de alguma sala
    public SalaMateriaCreat deletarMateria(int id); // Deleta a vinculação entre sala e turma.
}
