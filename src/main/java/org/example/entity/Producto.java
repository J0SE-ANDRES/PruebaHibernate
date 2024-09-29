package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Clase de la entidad productos
 */
@Entity(name = "productos")
public class Producto {

    // Creacion de Atributos
    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productoId;

    private String producto;
    private boolean existencia;
    @Column(name = "valor_unitario")
    private int valorUnitario;
    @Column(name = "valor_total")
    private int valorTotal;

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    // Creacion de Constructores
    public Producto() {
    }

    public Producto(String producto, boolean existencia, int valorUnitario, int valorTotal) {
        this.producto = producto;
        this.existencia = existencia;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    // Metodos Getters and Setters
    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public boolean isExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    // ToString para la representacion del objeto Producto
    @Override
    public String toString() {
        return  "productoId = " + productoId +
                ", producto = '" + producto + '\'' +
                ", existencia = " + existencia +
                ", valorUnitario = " + valorUnitario +
                ", valorTotal = " + valorTotal +
                ", facturas = " + facturas
                ;
    }
}
