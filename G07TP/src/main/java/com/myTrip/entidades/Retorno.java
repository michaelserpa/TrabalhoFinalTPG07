package com.myTrip.entidades;

public class Retorno<E>
{
	private boolean ok;
	private String mensagem;
	private E dados;

	private Retorno(boolean ok, E dados, String mensagem)
	{
		this.ok = ok;
		this.mensagem = mensagem;
		this.dados = dados;
	}

	public static <T> Retorno<T> retornarSucesso(T conteudo)
	{
		return new Retorno<>(true, conteudo, "Sucesso");
	}

	public static <T> Retorno<T> retornarFalha(String mensagem)
	{
		return new Retorno<>(false, null, mensagem);
	}

	public boolean ok()
	{
		return this.ok;
	}

	public String mensagem()
	{
		return this.mensagem;
	}

	public E dados()
	{
		return this.dados;
	}
}