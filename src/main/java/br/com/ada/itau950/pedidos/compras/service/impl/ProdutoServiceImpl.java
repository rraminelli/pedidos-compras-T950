package br.com.ada.itau950.pedidos.compras.service.impl;

import br.com.ada.itau950.pedidos.compras.entity.Produto;
import br.com.ada.itau950.pedidos.compras.repository.ProdutoRepository;
import br.com.ada.itau950.pedidos.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Optional<Produto> findById(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    @Override
    public void delete(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

}
