package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    
    //Requisito 1
    @Test
    void testSetNumeroValido() {
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);
    }
    @Test
    void testSetNumeroInvalidoExcecao(){
        final Conta instance = new Conta();
        final String esperado = "123";
        IllegalArgumentException assertThrows = assertThrows(IllegalArgumentException.class, () -> instance.setNumero(esperado));
    }
    @Test
    void testSetNumeroInvalidoNaoArmazena(){
        final Conta instance = new Conta();
        final String esperado = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(esperado));
        final String obtido = instance.getNumero();
        assertNotEquals(esperado, obtido);
    }
    
    //Requisito 2
    @Test
    void testInstanciaPadraoPoupanca(){
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    //Requisito 3
    @Test
    void testSetLimiteContaEspecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    @Test
    void testSetLimiteContaNaoEspecial(){
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
    }
    
    //Requisito 4
    @Test
    void testHistoricoNotNull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
    
    @Test
    void testGetSaldoTotal(){
        final double limite = 500;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido);        
    }
    
    @Test
    void testDepositoDinheiro(){
        final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);        
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }
    
    //TIPO DA MOVIMENTAÇÃO - CREDITO
    @Test
    void testTipoMovimentacaoCredito(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final Character esperado = 'C';
        instance.setTipo(esperado);
        final Character obtido = instance.getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testTipoMovimentacaoDebito(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final Character esperado = 'D';
        instance.setTipo(esperado);
        final Character obtido = instance.getTipo();
        assertEquals(esperado, obtido);
    }
    
    //SE FOI CONFIRMADA
    @Test
    void testMovimentacaoConfirmada(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final boolean esperado = true;
        instance.setConfirmada(esperado);
        final boolean obtido = instance.isConfirmada();
        assertEquals(esperado, obtido);
    }
    
    //VALOR ATRIBUIDO
    @Test
    void testMovimentacaoValorAtribuido(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final double esperado = 1000;
        instance.setValor(esperado);
        final double obtido = instance.getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testMovimentacaoValorAtribuidoNegativo(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final double esperado = -2;
        instance.setValor(esperado);
        final double obtido = instance.getValor();
        assertEquals(esperado, obtido);
    }
}