package com.msqs.dsa.tienda.controller;

import com.msqs.dsa.tienda.entity.Cliente;
import com.msqs.dsa.tienda.service.ServiceCliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ControllerCliente {
    private final ServiceCliente servicio;

    public ControllerCliente(ServiceCliente servicio){
        this.servicio=servicio;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cl){
        return servicio.guadarCliente(cl);
    }
    @GetMapping
    public List<Cliente> listar(){
        return servicio.listarClientes();
    }
}
