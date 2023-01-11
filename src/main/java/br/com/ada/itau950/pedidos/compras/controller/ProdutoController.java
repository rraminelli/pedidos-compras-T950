package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.ProdutoResponseDTO;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoSaveRequestDTO;
import br.com.ada.itau950.pedidos.compras.dto.ProdutoSaveResponseDTO;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @PostMapping
    public ResponseEntity<ProdutoSaveResponseDTO> save(@RequestBody ProdutoSaveRequestDTO produtoRequest) {

        log.info(produtoRequest.toString());

        Produto produto = new Produto();
        produto.setFoto(produtoRequest.getFoto());
        produto.setDescricao(produto.getDescricao());
        produto.setPreco(produtoRequest.getPreco());

        //save
        produto.setId(122L);

        ProdutoSaveResponseDTO produtoResponse = new ProdutoSaveResponseDTO();
        produtoResponse.setId(produto.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @GetMapping(value = "/{idProduto}")
    public ResponseEntity<ProdutoResponseDTO> getById(@PathVariable(value = "idProduto") Long id) {

        //return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        ProdutoResponseDTO produto = new ProdutoResponseDTO();
        produto.setNome("teclado");
        produto.setId(id);
        return ResponseEntity.ok(produto);
    }

    @PatchMapping("/{idProduto}/{qtdeEstoque}")
    public ResponseEntity updateEstoque(@PathVariable Long idProduto, @PathVariable Integer qtdeEstoque) {
        //update
        log.info("idProduto: {} qtde: {}", idProduto, qtdeEstoque);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idProduto}")
    public ResponseEntity<String> delete(@PathVariable Long idProduto) {

        if (idProduto == 2) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID nao encontrado");
        }

        // delete

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
        //select
        return ResponseEntity.ok(new ArrayList<>());
    }

}
