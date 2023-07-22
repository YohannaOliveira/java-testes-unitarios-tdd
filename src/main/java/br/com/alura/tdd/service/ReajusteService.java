package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void calculaReajuste(Funcionario funcionario, DesempenhoEnum desempenhoEnum) {
        BigDecimal percentualReajuste = desempenhoEnum.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
        funcionario.salarioReajustado(reajuste);
    }
}
