package com.myTrip.entidades;

import java.util.Set;

public class Agencia {
    private String cnpj;
	private String nome;
	private Set<FormaDePagamento> formaPagamento;

    public Agencia(String cnpj, String nome, Set<FormaDePagamento> formaPagamento)
	{
		this.cnpj = cnpj;
        this.nome = nome;
        this.formaPagamento = formaPagamento;
    }

    public static Agencia novaAgencia(String cnpj, String nome, Set<FormaDePagamento> formaPagamento)
	{
		return new Agencia(cnpj, nome, formaPagamento);
    }
    
    public static Agencia agenciaExistente(String cnpj, String nome, Set<FormaDePagamento> formaPagamento)
	{
		return new Agencia(cnpj, nome, formaPagamento);
	}
    
    public String cnpj(){
        return cnpj;
    }

    public String nome(){
        return nome;
    }

    public Set<FormaDePagamento> formaPagamento(){
        return formaPagamento;
    }

    public void formaPagamento(Set<FormaDePagamento> formaPagamento)
	{
		this.formaPagamento = formaPagamento;
    }

    @Override
	public boolean equals(Object other)
	{
		if (this == other)
		{ return true; }

		if (other == null || other.getClass() != this.getClass())
		{ return false; }

		Agencia otherAgencia = (Agencia) other;

		return this.cnpj.equals(otherAgencia.cnpj);
	}

    @Override
	public String toString()
	{
		return nome + " - " + cnpj;
	}
}