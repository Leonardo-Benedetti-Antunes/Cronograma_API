package com.cronograma.Cesurg.core.domain.contract.contractMateria;

import com.cronograma.Cesurg.core.domain.entity.Materia;

import java.util.List;

public interface MateriaRepository {
    // criar materia
    public void criar (Materia materia);

    // atualizar materia
    public void atualizar(int id, Materia materia);

    // deletar materia
    public void deletar(int id);

    // listar materia
    public List<Materia> listarMateria ();
}
