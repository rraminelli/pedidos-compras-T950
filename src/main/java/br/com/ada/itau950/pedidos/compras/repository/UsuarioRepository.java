package br.com.ada.itau950.pedidos.compras.repository;

import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
