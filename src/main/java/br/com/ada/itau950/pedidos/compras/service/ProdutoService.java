package br.com.ada.itau950.pedidos.compras.service;

import br.com.ada.itau950.pedidos.compras.entity.Produto;

import java.util.Optional;

public interface ProdutoService {

    Produto save(Produto produto);

    Optional<Produto> findById(Long idProduto);

    void delete(Long idProduto);

}
