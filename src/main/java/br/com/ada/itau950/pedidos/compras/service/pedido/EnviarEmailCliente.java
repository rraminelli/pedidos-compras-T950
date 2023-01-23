package br.com.ada.itau950.pedidos.compras.service.pedido;

import br.com.ada.itau950.pedidos.compras.dto.request.SendEmailDto;
import br.com.ada.itau950.pedidos.compras.entity.Pedido;
import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@Order(30)
public class EnviarEmailCliente implements ValidarPedido {

    //final SendEmailService sendEmailService;

    /*public EnviarEmailCliente(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }*/

    public void validar(Pedido pedido) {
        log.info("EnviarEmailCliente");

        final String mensagem = this.criarMensagem(pedido);

        final SendEmailDto sendEmailDto = SendEmailDto.builder()
                .assunto("Status do pedido")
                .para(pedido.getUsuario().getEmail())
                .mensagem(mensagem)
                .build();

        //sendEmailService.send(sendEmailDto);

    }

    private String criarMensagem(final Pedido pedido) {
        final Usuario usuario = pedido.getUsuario();

        final String dataPedido =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(pedido.getDataPedido());

        final StringBuilder mensagem = new StringBuilder();
        mensagem.append(usuario.getNome()).append(", ").append("\n");
        mensagem.append("Pedido: ").append(pedido.getId()).append("\n");
        mensagem.append("Data: ").append(dataPedido).append("\n");
        mensagem.append("Produtos: ").append("\n");
        pedido.getItens().forEach(item -> {
            mensagem.append(item.getQuantidade()).append("x ").append(item.getProduto().getNome()).append("\n");
        });

        mensagem.append("Status: ").append(pedido.getStatus()).append("\n");
        if (StatusPedidoEnum.CANCELADO.equals(pedido.getStatus())) {
            mensagem.append(pedido.getMensagemStatus()).append("\n");;
        }

        return mensagem.toString();
    }

}
