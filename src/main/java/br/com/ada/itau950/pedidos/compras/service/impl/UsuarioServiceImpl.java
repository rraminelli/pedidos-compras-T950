package br.com.ada.itau950.pedidos.compras.service.impl;

import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import br.com.ada.itau950.pedidos.compras.repository.UsuarioRepository;
import br.com.ada.itau950.pedidos.compras.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService  {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

}
