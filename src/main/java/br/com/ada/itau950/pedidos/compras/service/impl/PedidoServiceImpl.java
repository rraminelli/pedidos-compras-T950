package br.com.ada.itau950.pedidos.compras.service.impl;

import br.com.ada.itau950.pedidos.compras.config.security.JwtUtils;
import br.com.ada.itau950.pedidos.compras.dto.request.RealizarPedidoDto;
import br.com.ada.itau950.pedidos.compras.dto.response.RealizarPedidoResponseDto;
import br.com.ada.itau950.pedidos.compras.entity.ItemPedido;
import br.com.ada.itau950.pedidos.compras.entity.Pedido;
import br.com.ada.itau950.pedidos.compras.entity.Produto;
import br.com.ada.itau950.pedidos.compras.entity.Usuario;
import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import br.com.ada.itau950.pedidos.compras.repository.PedidoRepository;
import br.com.ada.itau950.pedidos.compras.repository.ProdutoRepository;
import br.com.ada.itau950.pedidos.compras.repository.UsuarioRepository;
import br.com.ada.itau950.pedidos.compras.service.PedidoService;
import br.com.ada.itau950.pedidos.compras.service.pedido.ValidarPedido;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    final PedidoRepository pedidoRepository;
    final ProdutoRepository produtoRepository;
    final List<ValidarPedido> validacoes;
    final UsuarioRepository usuarioRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, List<ValidarPedido> validacoes, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.validacoes = validacoes;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public RealizarPedidoResponseDto realizarPedido(final RealizarPedidoDto realizarPedidoDto) {

        final Pedido pedido = this.criarPedido(realizarPedidoDto);

        validacoes.forEach(validarPedido -> validarPedido.validar(pedido));

        return new RealizarPedidoResponseDto(pedido.getId());
    }

    private Pedido criarPedido(RealizarPedidoDto realizarPedidoDto) {

        String email = JwtUtils.getEmailFromContext();

        Usuario usuario = usuarioRepository.findByEmail(email).get();

        Set<ItemPedido> itensPedido = realizarPedidoDto.getItens().stream()
                .map(pedidoItemDto -> {

                    final Produto produto = produtoRepository.findById(pedidoItemDto.getProdutoId()).get();

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(pedidoItemDto.getQuantidade());
                    itemPedido.setProduto(produto);
                    itemPedido.setPreco(produto.getPreco());
                    itemPedido.setDesconto(produto.getDesconto());

                    return itemPedido;

                })
                .collect(Collectors.toSet());

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedidoEnum.NOVO);
        pedido.setUsuario(usuario);
        pedido.setItens(itensPedido);

        pedidoRepository.save(pedido);

        return pedido;

    }

}
