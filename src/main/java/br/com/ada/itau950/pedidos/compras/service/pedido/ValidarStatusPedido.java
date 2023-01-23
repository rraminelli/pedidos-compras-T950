package br.com.ada.itau950.pedidos.compras.service.pedido;

import br.com.ada.itau950.pedidos.compras.entity.Pedido;
import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import br.com.ada.itau950.pedidos.compras.repository.PedidoRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(50)
public class ValidarStatusPedido implements ValidarPedido {

    final PedidoRepository pedidoRepository;

    public ValidarStatusPedido(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void validar(Pedido pedido) {

        if (!StatusPedidoEnum.NOVO.equals(pedido.getStatus())) {
            pedidoRepository.save(pedido);
        }

    }


}
