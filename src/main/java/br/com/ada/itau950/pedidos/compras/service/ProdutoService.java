package br.com.ada.itau950.pedidos.compras.service;

import br.com.ada.itau950.pedidos.compras.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Produto save(Produto produto);

    Optional<Produto> findById(Long idProduto);

    void delete(Long idProduto);

    Page<Produto> findAll(String filter, Pageable pageable);

    void importProdutos();

}
