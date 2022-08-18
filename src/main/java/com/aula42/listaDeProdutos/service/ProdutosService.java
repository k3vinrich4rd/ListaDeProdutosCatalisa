package com.aula42.listaDeProdutos.service;
//Service: Responsável em ficar como intermediário entre Controller e Repository

import com.aula42.listaDeProdutos.model.ProdutosModel;
import com.aula42.listaDeProdutos.model.valoresprodutos.CalculoDesconto;
import com.aula42.listaDeProdutos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired // Injeção de dependência, realiza a ligação (Significa que repository está ligado a service)
    private ProdutosRepository produtosRepository;

    public List<ProdutosModel> buscarTodos() {
        return produtosRepository.findAll(); // Buscar por todos
    }

    public Optional<ProdutosModel> buscarId(Long codigo) {

        return produtosRepository.findById(codigo);
    }

    public ProdutosModel cadastrar(ProdutosModel produtosModel, CalculoDesconto calculoDesconto) {
        Double resultado = calculoDesconto.descontoProduto(produtosModel.getValor(), produtosModel.getPorcentagemDesconto());
        Double resultadoFinal = calculoDesconto.valorFinal(produtosModel.getValor(), resultado);

        produtosModel.getCodigo();
        produtosModel.getNome();
        produtosModel.getValor();
        produtosModel.getPorcentagemDesconto();
        produtosModel.setValorDesconto(resultado);
        produtosModel.setValorFinal(resultadoFinal);

        Double resultadoIcms = calculoDesconto.valorIcms(produtosModel.getValorFinal());
        produtosModel.setValorIcms(resultadoIcms);

        return produtosRepository.save(produtosModel);
    }

    public ProdutosModel alterar(ProdutosModel produtosModel) {

        produtosModel.getCodigo();
        produtosModel.getNome();
        produtosModel.getValor();

        return produtosRepository.save(produtosModel);
    }

    public void deletar(Long codigo) {
        produtosRepository.deleteById(codigo);
    }

}
