package com.myTrip.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class ViagemTest 
{
	FormaDePagamento f1;
	TipoPlano t1;
	Set<FormaDePagamento> f2;
	private Viagem v1,v2;
	private Cliente c1;
	private Agencia a1;
	private Local l1,l2;

	@BeforeEach
	public void setup()
	{
		f1 = FormaDePagamento.CREDITO;
		f2.add(f1);
		t1 = TipoPlano.SIMPLES;
		c1 = Cliente.novoCliente("03470019045", "Michael Leite Serpa da Rosa", f1);
		a1 = Agencia.novaAgencia("11382610000113", "VIAGEM FELIZ", f2);
		l1 = Local.novoLocal("Irlanda", "Dublin");
		l2 = Local.novoLocal("Brasil", "Porto Alegre");
		v1 = Viagem.novaViagem(2, l2, l1, c1, a1, t1, 200.42);
		v2 = Viagem.viagemExistente(1, l2, l1, c1, a1, t1, 200.42);
    }
    
    @DisplayName("Testa id")
	@Test
	public void testaID()
	{
		assertEquals(1, v1.id());
	}

	@DisplayName("Testa cidade origem")
	@Test
	public void testaOrigem()
	{
		assertEquals(l1.nomeCidade(), v1.origem().nomeCidade());
    }
	
	@DisplayName("Testa Pais origem")
	@Test
	public void testaPaisOrigem()
	{
		assertEquals(l1.nomePais(), v2.origem().nomePais());
	}

	@DisplayName("Testa cidade destino")
	@Test
	public void testaDestino()
	{
		assertEquals(l1.nomeCidade(), v1.destino().nomeCidade());
    }
	
	@DisplayName("Testa país destino")
	@Test
	public void testaPaisDestino()
	{
		assertEquals(l1.nomePais(), v2.destino().nomePais());
	}
	
    @DisplayName("Testa agencia")
	@Test
	public void testaAgencia()
	{
		assertEquals(a1.cnpj(), v2.agencia().cnpj());
	}

	@DisplayName("Testa cliente")
	@Test
	public void testeCliente()
	{
		assertEquals(c1.cpf(), v1.cliente().cpf());
	}

	@DisplayName("Testa Custo")
	@Test
	public void testaCusto()
	{
		assertEquals(200.42, v1.custo());
	}
}