package br.com.ada.itau950.pedidos.compras.service.pedido;

import br.com.ada.itau950.pedidos.compras.entity.Pedido;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import br.com.ada.itau950.pedidos.compras.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Order(10)
public class ValidarEstoquePedido implements ValidarPedido {

    final ProdutoService produtoService;

    public ValidarEstoquePedido(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void validar(Pedido pedido) {
        log.info("ValidarEstoquePedido");

        pedido.getItens().forEach(item -> {
            final Produto produto = produtoService.findById(item.getProduto().getId()).get();
            if (produto.getEstoque() < item.getQuantidade()) {
                pedido.setStatus(StatusPedidoEnum.CANCELADO);
                pedido.setMensagemStatus("Quantidade do produto " + produto.getNome() + " nao disponivel em estoque");
            }
        });


    }

}
