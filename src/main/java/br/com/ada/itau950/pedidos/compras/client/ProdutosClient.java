package br.com.ada.itau950.pedidos.compras.client;

import br.com.ada.itau950.pedidos.compras.dto.ProdutoImportListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "produtosClient",
        url = "https://dummyjson.com"
)
public interface ProdutosClient {

    @GetMapping(value = "/products/search")
    ProdutoImportListDto find(@RequestParam("q") String filter);

}
