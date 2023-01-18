package br.com.ada.itau950.pedidos.compras.service;

import br.com.ada.itau950.pedidos.compras.entity.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    Optional<Usuario> findById(Long idUsuario);

}
