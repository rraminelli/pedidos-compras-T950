package br.com.ada.itau950.pedidos.compras.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProdutosResponseListDto {

  private List<ProdutoResponseDTO> content;
  private int size;
  private int page;
  private int totalPages;
  private long count;

}
