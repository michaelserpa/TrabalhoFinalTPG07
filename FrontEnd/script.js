
    document.getElementById("btDados").onclick = async function () {
	let cpf = document.getElementById("cpf").value;
    let url = "http://localhost:8080/myTrip/buscarcliente";
    url = url + "?cpf="+cpf;
    let resposta = await fetch(url);
    console.log(resposta);
    let value = await resposta.json();
    if (resposta.ok){
        let nome = document.getElementById("nomeValor");
        nome.innerHTML = value.nome;
        let g1 = document.getElementById("formaValor");
        g1.innerHTML = value.formaPagamento;
        let g2 = document.getElementById("qtdVValor");
        g2.innerHTML = value.qtdViagens;
		let g3 = document.getElementById("qtdAValor");
        g3.innerHTML = value.qtdAvaliacoes;
        erro = document.getElementById("erro");
        erro.innerHTML = "Consulta realizada com sucesso";
        //let json = document.getElementById("jsonValor");
        //json.innerHTML = JSON.stringify(resposta);
    }else{
        let nome = document.getElementById("nomeValor");
        nome.innerHTML = " - ";
        let g1 = document.getElementById("formaValor");
        g1.innerHTML = " - ";
        let g2 = document.getElementById("qtdVValor");
        g2.innerHTML = " -";
        let g3 = document.getElementById("qtdAValor");
        g3.innerHTML = " -";
        erro = document.getElementById("erro");
        erro.innerHTML = value.message;;
    } 
}

