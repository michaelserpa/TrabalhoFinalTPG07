package com.myTrip.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest
{
	FormaDePagamento f1, f2;
	private Cliente clienteNovo;
	private Cliente clienteExistente;

	@BeforeEach
	public void setup()
	{
		f1 = FormaDePagamento.CREDITO;
		f2 = FormaDePagamento.BOLETO;
		clienteNovo = Cliente.novoCliente("03470019045", "Michael Leite Serpa da Rosa", f1);
		clienteExistente = Cliente.clienteExistente("91413346049", "Claudia Leite Serpa da Rosa", f2, 11, 9);
    }
    
    @DisplayName("Testa cpf")
	@Test
	public void testaCpf()
	{
		assertEquals("03470019045", clienteNovo.cpf());
	}

	@DisplayName("Testa nome")
	@Test
	public void testaNome()
	{
		assertEquals("Michael Leite Serpa da Rosa", clienteNovo.nome());
    }
    
    @DisplayName("Testa forma de pagamento")
	@Test
	public void testaFormaPgto()
	{
		assertTrue(clienteExistente.formaPagamento() == FormaDePagamento.BOLETO);
	}

	@DisplayName("Testa qtd de viagens")
	@Test
	public void testaQtdViagens()
	{
		assertEquals(11, clienteExistente.qtdViagens());
	}

	@DisplayName("Testa qtd de avaliacoes")
	@Test
	public void testaQtdAvaliacoes()
	{
		assertEquals(9, clienteExistente.qtdAvaliacoes());
	}
}