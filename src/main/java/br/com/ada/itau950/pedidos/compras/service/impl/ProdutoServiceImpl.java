package br.com.ada.itau950.pedidos.compras.service.impl;

import br.com.ada.itau950.pedidos.compras.client.ProdutosClient;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoImportDto;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoImportListDto;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import br.com.ada.itau950.pedidos.compras.repository.ProdutoRepository;
import br.com.ada.itau950.pedidos.compras.service.ProdutoService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    private ProdutosClient produtosClient;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ProdutosClient produtosClient) {
        this.produtoRepository = produtoRepository;
        this.produtosClient = produtosClient;
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
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

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public Page<Produto> findAll(String filter, Pageable pageable) {

        /*List<ProdutoSelectDto> produtoSelectDtosTest =
                produtoRepository.findByProdutosNative(filter);*/



        return produtoRepository.
                findByNomeContainsIgnoreCaseOrDescricaoContainsIgnoreCase(filter, filter, pageable);
    }

    @Override
    public void importProdutos() {

        if (produtoRepository.count() > 0) {
            log.info("tabela produtos com registros");
            return;
        }

        List<Produto> produtos = new ArrayList<>();

        ProdutoImportListDto produtoImportListDto = produtosClient.find("phone");

        for (ProdutoImportDto produtoImportDto : produtoImportListDto.getProducts()) {
            Produto produto = new Produto(
                    produtoImportDto.getId(),
                    produtoImportDto.getTitle(),
                    produtoImportDto.getDescription(),
                    produtoImportDto.getPrice(),
                    produtoImportDto.getDiscountPercentage(),
                    produtoImportDto.getStock(),
                    produtoImportDto.getThumbnail()
            );
            produtos.add(produto);
        }

        produtoRepository.saveAll(produtos);

    }

}
