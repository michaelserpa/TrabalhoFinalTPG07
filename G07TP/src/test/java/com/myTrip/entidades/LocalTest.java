package com.myTrip.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocalTest
{
    private Local l1,l2,l3;

	@BeforeEach
	public void setup()
	{
        l1 = Local.novoLocal("Irlanda", "Dublin");
        l2 = Local.novoLocal("França", "Paris");
        l3 = Local.novoLocal("Peru", "Cusco");
        
    }

	@DisplayName("Testa nome pais 1")
	@Test
	public void testaNomeP1()
	{
		assertEquals("Irlanda", l1.nomePais());
    }
    
    @DisplayName("Testa nome pais 2")
	@Test
	public void testaNomeP2()
	{
		assertEquals("França", l2.nomePais());
    }

    @DisplayName("Testa nome cidade 2")
	@Test
	public void testaNomeC2()
	{
		assertEquals("Paris", l2.nomeCidade());
    }

    @DisplayName("Testa nome cidade 2")
	@Test
	public void testaNomeC3()
	{
		assertEquals("Cusco", l3.nomeCidade());
    }
}