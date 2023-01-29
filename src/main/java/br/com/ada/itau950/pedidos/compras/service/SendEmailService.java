package br.com.ada.itau950.pedidos.compras.service;

import br.com.ada.itau950.pedidos.compras.dto.request.SendEmailDto;

public interface SendEmailService {

    void send(SendEmailDto sendEmailDto);

}
