package br.com.ada.itau950.pedidos.compras.service;

import br.com.ada.itau950.pedidos.compras.dto.request.RealizarPedidoDto;
import br.com.ada.itau950.pedidos.compras.dto.response.RealizarPedidoResponseDto;

public interface PedidoService {

    RealizarPedidoResponseDto realizarPedido(RealizarPedidoDto realizarPedidoDto);

}
