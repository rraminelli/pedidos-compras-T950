package br.com.ada.itau950.pedidos.compras.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoImportDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private BigDecimal discountPercentage;
    private Integer stock;
    private String thumbnail;

}
