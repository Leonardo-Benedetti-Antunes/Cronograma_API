package com.cronograma.Cesurg.core.domain.usecase;

import com.cronograma.Cesurg.core.domain.contract.MateriaRepository;
import com.cronograma.Cesurg.core.domain.contract.MateriaUseCase;
import com.cronograma.Cesurg.core.domain.entity.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaUseCaseImpl implements MateriaUseCase {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public void criar(Materia materia) {
        materiaRepository.criar(materia);
    }

    @Override
    public void atualizar(int id, Materia materia) {
        materiaRepository.atualizar(id, materia);
    }

    @Override
    public void deletar(int id) {
        materiaRepository.deletar(id);
    }

    @Override
    public List<Materia> listarMateria() {
        return materiaRepository.listarMateria();
    }
}
