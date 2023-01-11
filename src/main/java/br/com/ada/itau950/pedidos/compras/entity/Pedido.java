package br.com.ada.itau950.pedidos.compras.entity;

import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class Pedido {

    private Long id;
    private Usuario usuario;
    private LocalDateTime dataPedido;
    private String mensagemStatus;
    private Set<ItemPedido> itens;
    private StatusPedidoEnum status;

}
