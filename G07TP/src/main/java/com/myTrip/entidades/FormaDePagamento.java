package com.myTrip.entidades;

public enum FormaDePagamento
{
	CREDITO(0), DEBITO(1), BOLETO(2);
	public final int value;

	FormaDePagamento(int valor) { value = valor; }
}