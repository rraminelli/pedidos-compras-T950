package br.com.ada.itau950.pedidos.compras.repository;

import br.com.ada.itau950.pedidos.compras.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
