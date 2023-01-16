package br.com.ada.itau950.pedidos.compras.dto;

import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
