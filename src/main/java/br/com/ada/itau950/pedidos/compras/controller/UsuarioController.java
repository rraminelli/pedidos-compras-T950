package br.com.ada.itau950.pedidos.compras.controller;

import br.com.ada.itau950.pedidos.compras.dto.UsuarioResponseDto;
import br.com.ada.itau950.pedidos.compras.dto.UsuarioSaveRequestDto;
import br.com.ada.itau950.pedidos.compras.dto.UsuarioSaveResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<UsuarioSaveResponseDto> save(@RequestBody UsuarioSaveRequestDto usuario) {
        log.info(usuario.toString());
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/usuarios/123
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok().build();
    }

}
