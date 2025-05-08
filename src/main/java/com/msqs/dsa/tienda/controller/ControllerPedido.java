package com.msqs.dsa.tienda.controller;

import com.msqs.dsa.tienda.entity.Pedido;
import com.msqs.dsa.tienda.service.ServicePedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class ControllerPedido {

    private final ServicePedido servicio;

    public ControllerPedido(ServicePedido servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/con-detalles")
    public List<Pedido> listarConDetalles() {
        return servicio.listarPedidosConDetalles();
    }

    @GetMapping("/por-cliente/{nombre}")
    public List<Pedido> buscarPorNombreCliente(@PathVariable String nombre) {
        return servicio.buscarPorNombreCliente(nombre);
    }
}

