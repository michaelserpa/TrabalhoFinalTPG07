package com.myTrip.entidades;

public enum TipoPlano
{
	SIMPLES(0), PADRAO(1), LUXO(2);
	public final int value;

	TipoPlano(int valor) { value = valor; }
}