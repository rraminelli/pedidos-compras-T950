package br.com.ada.itau950.pedidos.compras.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    private String descricao;

    private BigDecimal preco;

    private BigDecimal desconto;
    private Integer estoque;
    private String foto;

}
