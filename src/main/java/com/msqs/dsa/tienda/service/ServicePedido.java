package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.Pedido;
import com.msqs.dsa.tienda.repository.RepositoryPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePedido {

    private final RepositoryPedido repoPedido;

    public ServicePedido(RepositoryPedido repoPedido) {
        this.repoPedido = repoPedido;
    }

    public List<Pedido> listarPedidosConDetalles() {
        return repoPedido.findAllPedidosConDetalles();
    }

    public List<Pedido> buscarPorNombreCliente(String nombreCliente) {
        return repoPedido.findByClienteNombre(nombreCliente);
    }
}
