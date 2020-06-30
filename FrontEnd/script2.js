
    document.getElementById("btDados").onclick = async function () {
	let cpf = document.getElementById("txtCpf").value;
    console.log(cpf);
    let origem = document.getElementById("txtOrigem").value;
    let destino = document.getElementById("txtDestino").value;
    let fpagamento = document.getElementById("txtFPag").value;
    let ftipo = document.getElementById("txtTPlano").value;
    let url = "http://localhost:8080/myTrip/solicitarviagem";
    url = url + "?cpf="+cpf+"&lOrig="+origem+"&lDest="+destino+"&formaPgto="+fpagamento+"&tViagem="+ftipo;
    let resposta = await fetch(url);
    console.log(resposta);
    let value = await resposta.json();
    if (resposta.ok){
        let nome = document.getElementById("nomeValor");
        nome.innerHTML = value.cliente.nome;
        let g1 = document.getElementById("origemValor");
        g1.innerHTML = value.origem.nomeCidade+" - "+value.origem.nomePais;
        let g2 = document.getElementById("destinoValor");
        g2.innerHTML = value.destino.nomeCidade+" - "+value.destino.nomePais;
		let g3 = document.getElementById("agenciaValor");
        g3.innerHTML = value.agencia.nome;
        let g4 = document.getElementById("custoValor");
        g4.innerHTML = "R$ "+value.custo;
        erro = document.getElementById("erro");
        erro.innerHTML = "Viagem criada com sucesso";
        //let json = document.getElementById("jsonValor");
        //json.innerHTML = JSON.stringify(resposta);
    }else{
        let nome = document.getElementById("nomeValor");
        nome.innerHTML = " - ";
        let g1 = document.getElementById("origemValor");
        g1.innerHTML = " - ";
        let g2 = document.getElementById("destinoValor");
        g2.innerHTML = " -";
        let g3 = document.getElementById("agenciaValor");
        g3.innerHTML = " -";
        let g4 = document.getElementById("custoValor");
        g4.innerHTML = " -";
        erro = document.getElementById("erro");
        erro.innerHTML = value.message;
    } 
}