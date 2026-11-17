package br.com.baozistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.baozistore.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Usados para impedir que um cliente/produto com pedidos seja apagado
    boolean existsByClienteId(Long clienteId);

    boolean existsByProdutoId(Long produtoId);
}
