package com.myTrip.entidades;

public class Cliente {
    private String cpf;
	private String nome;
	private FormaDePagamento formaPagamento;
	private int qtdViagens;
	private int qtdAvaliacoes;

    public Cliente(String cpf, String nome, FormaDePagamento formaPagamento, int qtdViagens, int qtdAvaliacoes)
	{
		this.cpf = cpf;
        this.nome = nome;
        this.formaPagamento = formaPagamento;
        this.qtdViagens = qtdViagens;
        this.qtdAvaliacoes = qtdAvaliacoes;
    }

    public static Cliente novoCliente(String cpf, String nome, FormaDePagamento formaPagamento)
	{
		final int qtdViagensInicial = 0;
		final int qtdAvaliacoesInicial = 0;
		return new Cliente(cpf, nome, formaPagamento, qtdViagensInicial, qtdAvaliacoesInicial);
    }
    
    public static Cliente clienteExistente(String cpf, String nome, FormaDePagamento formaPagamento, int qtdViagens, int qtdAvaliacoes)
	{
		return new Cliente(cpf, nome, formaPagamento, qtdAvaliacoes, qtdAvaliacoes);
	}
    
    public String cpf(){
        return cpf;
    }

    public String nome(){
        return nome;
    }

    public FormaDePagamento formaPagamento(){
        return formaPagamento;
    }

    public int qtdViagens(){
        return qtdViagens;
    }

    public int qtdAvaliacoes(){
        return qtdAvaliacoes;
    }

    public void formaPagamento(FormaDePagamento formaPagamento)
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

		Cliente otherCliente = (Cliente) other;

		return this.cpf.equals(otherCliente.cpf);
	}

    @Override
	public String toString()
	{
		return nome + " - " + cpf;
	}
}