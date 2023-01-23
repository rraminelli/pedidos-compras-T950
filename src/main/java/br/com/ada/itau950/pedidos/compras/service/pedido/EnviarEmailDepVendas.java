package br.com.ada.itau950.pedidos.compras.service.pedido;

import br.com.ada.itau950.pedidos.compras.dto.request.SendEmailDto;
import br.com.ada.itau950.pedidos.compras.entity.Pedido;
import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@Order(40)
public class EnviarEmailDepVendas implements ValidarPedido {

    //final String emailDepVendas;
    //final SendEmailService sendEmailService;

    /*public EnviarEmailDepVendas(@Value("${app.email.vendas}") String emailDepVendas, SendEmailService sendEmailService) {
        this.emailDepVendas = emailDepVendas;
        this.sendEmailService = sendEmailService;
    }*/

    public void validar(Pedido pedido) {
        log.info("EnviarEmailDepVendas");

        if (StatusPedidoEnum.CANCELADO.equals(pedido.getStatus())) {
            return;
        }

        final String mensagem = this.criarMensagem(pedido);

        final SendEmailDto sendEmailDto = SendEmailDto.builder()
                .assunto("Novo pedido de compras")
                //.para(emailDepVendas)
                .mensagem(mensagem)
                .build();

        //sendEmailService.send(sendEmailDto);

    }

    private String criarMensagem(final Pedido pedido) {

        final String dataPedido =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(pedido.getDataPedido());

        final StringBuilder mensagem = new StringBuilder();
        mensagem.append("Cliente: ").append(pedido.getUsuario().getNome()).append("\n");
        mensagem.append("Pedido: ").append(pedido.getId()).append("\n");
        mensagem.append("Data: ").append(dataPedido).append("\n");
        mensagem.append("Produtos: ").append("\n");
        pedido.getItens().forEach(item -> {
            mensagem.append(item.getQuantidade()).append("x ").append(item.getProduto().getNome()).append("\n");
        });
        return mensagem.toString();
    }

}
