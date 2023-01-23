package br.com.ada.itau950.pedidos.compras.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoSelectDto {

    public ProdutoSelectDto() {

    }

    public ProdutoSelectDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    private String nome;
    private String descricao;

}
