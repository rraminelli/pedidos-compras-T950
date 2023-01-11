package br.com.ada.itau950.pedidos.compras.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal desconto;
    private Integer estoque;
    private String foto;

}
