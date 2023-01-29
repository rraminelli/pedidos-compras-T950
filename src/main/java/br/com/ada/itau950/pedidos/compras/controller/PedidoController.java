package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.request.RealizarPedidoDto;
import br.com.ada.itau950.pedidos.compras.dto.response.RealizarPedidoResponseDto;
import br.com.ada.itau950.pedidos.compras.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PreAuthorize("hasAnyRole('CLIENTE')")
    @PostMapping
    public ResponseEntity<RealizarPedidoResponseDto> realizarPedido(@RequestBody RealizarPedidoDto realizarPedidoDto) {
        return ResponseEntity.ok(pedidoService.realizarPedido(realizarPedidoDto));
    }

}
