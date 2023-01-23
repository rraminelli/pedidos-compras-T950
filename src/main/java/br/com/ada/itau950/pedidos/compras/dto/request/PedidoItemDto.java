package br.com.ada.itau950.pedidos.compras.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDto {

    private Long produtoId;
    private Integer quantidade;

}
