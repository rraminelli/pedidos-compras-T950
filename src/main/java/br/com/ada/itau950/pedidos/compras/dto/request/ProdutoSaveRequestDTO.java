package br.com.ada.itau950.pedidos.compras.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ProdutoSaveRequestDTO {

    @NotNull @NotBlank
    private String nome;

    private String descricao;

    @NotNull @DecimalMin(value = "0.1")
    private BigDecimal preco;

    @NotNull
    private BigDecimal desconto;

    private String foto;

}
