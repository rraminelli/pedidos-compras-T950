package br.com.ada.itau950.pedidos.compras.entity;

import br.com.ada.itau950.pedidos.compras.entity.enums.StatusPedidoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataPedido;

    private String mensagemStatus;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itens;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;

}
