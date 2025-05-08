package com.msqs.dsa.tienda.controller;

import com.msqs.dsa.tienda.entity.Proveedor;
import com.msqs.dsa.tienda.service.ServiceProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ControllerProveedor {
    private final ServiceProveedor servicio;

    public ControllerProveedor(ServiceProveedor servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Proveedor crear(@RequestBody Proveedor pr) {
        return servicio.guardarProveedor(pr);
    }

    @GetMapping
    public List<Proveedor> listar() {
        return servicio.listarProveedores();
    }
}
