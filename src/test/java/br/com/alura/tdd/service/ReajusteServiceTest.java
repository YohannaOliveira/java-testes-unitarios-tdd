package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.DesempenhoEnum;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService reajusteService;
    private Funcionario funcionario;

    @BeforeEach
    public void setup() {
         this.reajusteService = new ReajusteService();
         this.funcionario = new Funcionario("Yohanna", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void deveTerReajusteTresPorcentoQuandoDesempenhoADesejar() {
        reajusteService.calculaReajuste(funcionario, DesempenhoEnum.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void deveTerReajusteQuinzePorcentoQuandoDesempenhoADesejar() {
        reajusteService.calculaReajuste(funcionario, DesempenhoEnum.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void deveTerReajusteVintePorcentoQuandoDesempenhoADesejar() {
        reajusteService.calculaReajuste(funcionario, DesempenhoEnum.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}