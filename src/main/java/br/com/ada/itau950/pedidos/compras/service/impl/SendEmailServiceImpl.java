package br.com.ada.itau950.pedidos.compras.service.impl;

import br.com.ada.itau950.pedidos.compras.dto.request.SendEmailDto;
import br.com.ada.itau950.pedidos.compras.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendEmailServiceImpl implements SendEmailService {

    final JavaMailSender javaMailSender;

    public SendEmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    @Override
    public void send(SendEmailDto sendEmailDto) {

        log.info("INICIO - Envio email - " + sendEmailDto);

        final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(sendEmailDto.getPara());
        simpleMailMessage.setSubject(sendEmailDto.getAssunto());
        simpleMailMessage.setText(sendEmailDto.getMensagem());
        javaMailSender.send(simpleMailMessage);

        log.info("FIM - Envio email - " + sendEmailDto);

    }

}
