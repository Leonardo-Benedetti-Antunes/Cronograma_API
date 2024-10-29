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
}
