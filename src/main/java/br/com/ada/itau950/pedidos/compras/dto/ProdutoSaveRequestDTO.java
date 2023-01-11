package br.com.ada.itau950.pedidos.compras.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProdutoSaveRequestDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal desconto;
    private String foto;

}
