package com.cronograma.Cesurg.core.domain.contract;

import com.cronograma.Cesurg.core.domain.entity.Professor;

import java.util.List;

public interface ProfessorUseCase {
    public void insert (Professor professor);
    public void delete (int id);
    public void updateStatus(int id, Professor professor);
    public void update (int id, Professor professor);
    public List<Professor> fetch();
    public Professor get(int id);
}
