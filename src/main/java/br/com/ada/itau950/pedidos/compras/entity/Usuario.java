package br.com.ada.itau950.pedidos.compras.entity;

import br.com.ada.itau950.pedidos.compras.entity.enums.PerfilEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private PerfilEnum perfil;

}
