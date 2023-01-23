package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.request.RealizarPedidoDto;
import br.com.ada.itau950.pedidos.compras.dto.response.RealizarPedidoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PostMapping
    public ResponseEntity<RealizarPedidoResponseDto> realizarPedido(@RequestBody RealizarPedidoDto realizarPedidoDto) {
        return ResponseEntity.ok().build();
    }

}
