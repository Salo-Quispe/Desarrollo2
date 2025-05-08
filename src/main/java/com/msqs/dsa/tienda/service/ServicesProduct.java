package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.Proveedor;
import com.msqs.dsa.tienda.repository.RepositoryCategoria;
import com.msqs.dsa.tienda.repository.RepositoryProduct;
import com.msqs.dsa.tienda.repository.RepositoryProveedor;
import com.msqs.dsa.tienda.entity.Categoria;
import com.msqs.dsa.tienda.entity.Producto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProduct {

    private final RepositoryProduct repoP;
    private final RepositoryCategoria repoC;
    private final RepositoryProveedor repoProv;

    public ServicesProduct(RepositoryProduct repoP, RepositoryCategoria repoC, RepositoryProveedor repoProv) {
        this.repoP = repoP;
        this.repoC = repoC;
        this.repoProv = repoProv;
    }

    public Producto crearProducto(double precioOriginal, String nombreCategoria, Long idProveedor) {
        Categoria categoria = repoC.findByNombreIgnoreCase(nombreCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Proveedor proveedor = repoProv.findById(idProveedor)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        double descuento = 0;
        if (categoria.getNombre().equalsIgnoreCase("Electrónicos")) {
            descuento = 0.10;
        } else if (categoria.getNombre().equalsIgnoreCase("Ropa")) {
            descuento = 0.05;
        }

        double precioConDescuento = precioOriginal - (precioOriginal * descuento);
        double envio = (precioConDescuento > 50) ? 0 : 5;
        double precioFinal = precioConDescuento + envio;

        Producto producto = new Producto();
        producto.setNombre("Producto genérico");
        producto.setPrecioOriginal(precioOriginal);
        producto.setPrecioFinal(precioFinal);
        producto.setCategoria(categoria);
        producto.setProveedor(proveedor);

        return repoP.save(producto);
    }

    public List<Producto> listar() {
        return repoP.findAll();
    }

    // 🟦 Consultas JPQL agregadas:

    public List<Producto> listarProductosOrdenadosPorPrecioFinal() {
        return repoP.findAllOrderByPrecioFinalDesc();
    }

    public List<Producto> buscarPorCategoria(String nombreCategoria) {
        return repoP.findByNombreCategoria(nombreCategoria);
    }

    public List<Producto> buscarPorPrecioMayorA(double precio) {
        return repoP.findByPrecioFinalMayorA(precio);
    }
}
