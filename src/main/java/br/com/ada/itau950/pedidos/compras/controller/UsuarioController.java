package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.UsuarioResponseDto;
import br.com.ada.itau950.pedidos.compras.dto.UsuarioSaveRequestDto;
import br.com.ada.itau950.pedidos.compras.dto.UsuarioSaveResponseDto;
import br.com.ada.itau950.pedidos.compras.entity.Endereco;
import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import br.com.ada.itau950.pedidos.compras.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioSaveResponseDto> save(@RequestBody @Valid UsuarioSaveRequestDto usuarioRequest) {
        log.info(usuarioRequest.toString());

        Endereco endereco = new Endereco();
        endereco.setBairro(usuarioRequest.getEndereco().getBairro());
        endereco.setCep(usuarioRequest.getEndereco().getCep());
        endereco.setLogradouro(usuarioRequest.getEndereco().getLogradouro());
        //...

        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPerfil(usuarioRequest.getPerfil());
        usuario.setEndereco(endereco);
        usuario.setSenha(usuarioRequest.getSenha());

        usuario = usuarioService.save(usuario);

        UsuarioSaveResponseDto usuarioSaveResponseDto = new UsuarioSaveResponseDto();
        usuarioSaveResponseDto.setId(usuario.getId());

        return ResponseEntity.ok(usuarioSaveResponseDto);
    }

    //http://localhost:8080/usuarios/123
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable(value = "id") Long userId) {

        Optional<Usuario> usuario = usuarioService.findById(userId);

        if (usuario.isPresent()) {
            UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();
            usuarioResponseDto.setEmail(usuario.get().getEmail());
            usuarioResponseDto.setCpf(usuario.get().getCpf());
            //...
            return ResponseEntity.ok(usuarioResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
