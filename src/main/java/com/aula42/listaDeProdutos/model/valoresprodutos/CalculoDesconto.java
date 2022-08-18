package com.aula42.listaDeProdutos.model.valoresprodutos;

public class CalculoDesconto {

    public Double descontoProduto(Double valor, Double porcentagemDesconto){
        Double resultado = valor * (porcentagemDesconto/100);
        return resultado;
    }

    public Double valorFinal(Double valor, Double valorDesconto){
        Double resultadoFinal = valor - valorDesconto;
        return resultadoFinal;
    }

    public Double valorIcms(Double valorFinal){
        Double valorIcms = valorFinal * 0.08;
        return valorIcms;
    }
}
