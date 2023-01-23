package br.com.ada.itau950.pedidos.compras.repository;

import br.com.ada.itau950.pedidos.compras.dto.response.ProdutoSelectDto;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByNomeContainsIgnoreCaseOrDescricaoContainsIgnoreCase(String nome, String descricao, Pageable pageable);

    @Query("select p from Produto p " +
            "where p.nome = :filter " +
            "or p.descricao = :filter")
    List<Produto> findAllProdutos(@Param("filter") String filter);

    @Query(value = "select new br.com.ada.itau950.pedidos.compras.dto.response.ProdutoSelectDto(" +
            "   p.nome, p.descricao " +
            ") " +
            "from Produto p " +
            "where p.nome = :filter "
        )
    List<ProdutoSelectDto> findByProdutosNative(@Param("filter") String filter);

}
