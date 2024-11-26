//package com.cronograma.Cesurg.core.domain.solution;
//
//import java.util.List;
//
//import com.cronograma.Cesurg.core.api.domain.solution.PlanningEntity;
//import com.cronograma.Cesurg.core.domain.entity.Sala;
//import com.cronograma.Cesurg.core.domain.entity.Turma;
//import com.cronograma.Cesurg.core.domain.solution.solucao;
//import com.cronograma.Cesurg.core.domain.valuerange.ValueRangeProvider;
//import com.cronograma.Cesurg.core.score.buildin.hardsoft.HardSoftScore;
//import com.cronograma.Cesurg.core.domain.entity.Organizacao.java;
//import org.optaplanner.core.api.domain.solution.PlanningScore;
//import org.optaplanner.core.api.domain.solution.PlanningSolution;
//
//
//@PlanningSolution
//public class Solucao {
//
//    private List<Turma> turmas; // Todas as turmas para alocar
//
//    @ValueRangeProvider(id = "salasDisponiveis")
//    private List<Sala> salas;  // Todas as salas disponíveis
//
//    @PlanningScore
//    private HardSoftScore score; // Pontuação da solução
//
//    // Getters e Setters
//    public List<Turma> getTurmas() {
//        return turmas;
//    }
//
//    public void setTurmas(List<Turma> turmas) {
//        this.turmas = turmas;
//    }
//
//    public List<Sala> getSalas() {
//        return salas;
//    }
//
//    public void setSalas(List<Sala> salas) {
//        this.salas = salas;
//    }
//
//    public HardSoftScore getScore() {
//        return score;
//    }
//
//    public void setScore(HardSoftScore score) {
//        this.score = score;
//    }
//}
