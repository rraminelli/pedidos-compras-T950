package br.com.ada.itau950.pedidos.compras.dto;

import br.com.ada.itau950.pedidos.compras.entity.enums.PerfilEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioSaveRequestDto {


    @NotNull @NotBlank private String nome;

    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "CPF invalido")
    private String cpf;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private EnderecoDto endereco;

    @NotNull(message = "Perfil é obrigatorio")
    private PerfilEnum perfil;

}
