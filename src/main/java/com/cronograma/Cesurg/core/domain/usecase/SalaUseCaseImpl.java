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
    public void insert(Sala sala) {
        salaRepository.insert(sala);
    }

    @Override
    public void delete(int id) {
        salaRepository.delete(id);
    }


    @Override
    public void update(int id, Sala sala) {
        salaRepository.update(id, sala);
    }

    @Override
    public List<Sala> fetch() {
        return salaRepository.fetch();
    }

    @Override
    public Sala get(int id) {
        return salaRepository.get(id);
    }

    @Override
    public void addCategory(int salaID, int categoryID) {
        salaRepository.addCategory(salaID, categoryID);
    }

    @Override
    public List<Sala> fetchCategory(int salaID) {
        return salaRepository.fetchCategory(salaID);
    }

    @Override
    public void updateCategory(int salaID, Sala sala) {

    }

    @Override
    public void deleteCategory(int id) {

    }

    @Override
    public void addClass(int salaID, int turmaID) {
        salaRepository.addClass(salaID, turmaID);
    }

    @Override
    public List<Sala> fetchClass(int turmaID) {
        return salaRepository.fetchClass(turmaID);
    }

    @Override
    public void updateClass(int salaID, Sala sala) {

    }

    @Override
    public void deleteClass(int id) {

    }
}
