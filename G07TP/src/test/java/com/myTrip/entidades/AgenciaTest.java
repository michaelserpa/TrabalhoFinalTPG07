package com.myTrip.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class AgenciaTest
{
    FormaDePagamento f1, f2;
    Set<FormaDePagamento> f3;
	private Agencia agenciaNova;
	private Agencia agenciaExistente;

	@BeforeEach
	public void setup()
	{
		f1 = FormaDePagamento.CREDITO;
        f2 = FormaDePagamento.DEBITO;
        f3.add(f1);
        f3.add(f2);
		agenciaNova = Agencia.novaAgencia("11382610000113", "CVC", f3);
		agenciaExistente = Agencia.agenciaExistente("00000000000191", "HotelUrbano", f3);
    }
    
    @DisplayName("Testa cnpj")
	@Test
	public void testaCnpj()
	{
		assertEquals("11382610000113", agenciaNova.cnpj());
	}

	@DisplayName("Testa nome")
	@Test
	public void testaNome()
	{
		assertEquals("HotelUrbano", agenciaExistente.nome());
    }
    
    @DisplayName("Testa forma de pagamento credito")
	@Test
	public void testaFormaPgtoCredito()
	{
		assertTrue(agenciaNova.formaPagamento().contains(FormaDePagamento.CREDITO));
    }
    
    @DisplayName("Testa forma de pagamento credito")
	@Test
	public void testaFormaPgtoDebito()
	{
		assertTrue(agenciaNova.formaPagamento().contains(FormaDePagamento.DEBITO));
	}
}