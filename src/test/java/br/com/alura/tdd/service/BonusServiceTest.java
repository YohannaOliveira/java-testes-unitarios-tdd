package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    @Test
    public void deveCalcularBonusFuncionarioSalarioAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Yohanna", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    public void deveCalcularBonusFuncionarioSalarioBaixo() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Yohanna", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void deveCalcularBonusFuncionarioSalarioBonusMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Yohanna", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}