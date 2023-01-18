package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.ProdutoResponseDTO;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoSaveRequestDTO;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoSaveResponseDTO;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import br.com.ada.itau950.pedidos.compras.repository.ProdutoRepository;
import br.com.ada.itau950.pedidos.compras.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoSaveResponseDTO> save(@RequestBody @Valid ProdutoSaveRequestDTO produtoRequest) {

        log.info(produtoRequest.toString());

        Produto produto = new Produto();
        produto.setFoto(produtoRequest.getFoto());
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setPreco(produtoRequest.getPreco());
        produto.setNome(produtoRequest.getNome());
        produto.setDesconto(produtoRequest.getDesconto());

        //save
        produtoService.save(produto);

        ProdutoSaveResponseDTO produtoResponse = new ProdutoSaveResponseDTO();
        produtoResponse.setId(produto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity update(@PathVariable Long idProduto, @RequestBody ProdutoSaveRequestDTO produtoRequest) {

        Optional<Produto> produto = produtoService.findById(idProduto);

        if (produto.isPresent()) {
            produto.get().setFoto(produtoRequest.getFoto());
            produto.get().setDescricao(produtoRequest.getDescricao());
            produto.get().setPreco(produtoRequest.getPreco());
            produto.get().setNome(produtoRequest.getNome());
            produto.get().setDesconto(produtoRequest.getDesconto());
            produtoService.save(produto.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping(value = "/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> getById(@PathVariable(value = "idProduto") Long id) {

        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        Optional<Produto> produto = produtoService.findById(id);

        if (produto.isPresent()) {
            ProdutoResponseDTO produtoDto = new ProdutoResponseDTO();
            produtoDto.setNome(produto.get().getNome());
            produtoDto.setDescricao(produto.get().getDescricao());
            produtoDto.setPreco(produto.get().getPreco());
            produtoDto.setDesconto(produto.get().getDesconto());
            produtoDto.setEstoque(produto.get().getEstoque());
            produtoDto.setId(id);
            return ResponseEntity.ok(produtoDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{idProduto}/{qtdeEstoque}")
    public ResponseEntity updateEstoque(@PathVariable Long idProduto, @PathVariable Integer qtdeEstoque) {
        //atualiza estoque
        log.info("idProduto: {} qtde: {}", idProduto, qtdeEstoque);

        Optional<Produto> produto = produtoService.findById(idProduto);

        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            produto.get().setEstoque(qtdeEstoque);
            produtoService.save(produto.get());
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<String> delete(@PathVariable Long idProduto) {

        Optional<Produto> produto = produtoService.findById(idProduto);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // delete
        produtoService.delete(idProduto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        //select
        return ResponseEntity.ok(new ArrayList<>());
    }

}
