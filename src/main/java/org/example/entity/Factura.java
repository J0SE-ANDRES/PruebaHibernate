package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la entidad facturas
 */
@Entity(name = "facturas")
public class Factura {

    // Creacion de Atributos
    @Id
    @Column(name = "factura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long facturaId;

    private int iva;
    @Column(name = "orden_compra")
    private String ordenCompra;
    private LocalDateTime fecha;
    private int descuento;
    private int subTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id",
                foreignKey = @ForeignKey(name = "FK_factura-cliente"))
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "facturas_productos",
            joinColumns = @JoinColumn(name = "factura_id", referencedColumnName = "factura_id",
                    foreignKey = @ForeignKey(name = "FK_factura-producto")),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "producto_id",
                    foreignKey = @ForeignKey(name = "FK_producto-factura")))
    private List<Producto> productos;

    // Creacion de Constructores
    public Factura() {
    }

    public Factura(int iva, String ordenCompra, LocalDateTime fecha, int descuento, int subTotal) {
        this.iva = iva;
        this.ordenCompra = ordenCompra;
        this.fecha = fecha;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }

    public Factura(int iva, String ordenCompra, LocalDateTime fecha, int descuento, int subTotal, Cliente cliente, List<Producto> productos) {
        this.iva = iva;
        this.ordenCompra = ordenCompra;
        this.fecha = fecha;
        this.descuento = descuento;
        this.subTotal = subTotal;
        this.cliente = cliente;
        this.productos = productos;
    }

    // Metodos Getters and Setters

    public long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(long facturaId) {
        this.facturaId = facturaId;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public String getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(String ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Metodo para añadir un producto
     * @param producto
     */
    public void addProducto(Producto producto) {
        if (productos == null) {
            productos = new ArrayList<Producto>();
        }
        productos.add(producto);
    }

    // ToString para la representacion del objeto Factura
    @Override
    public String toString() {
        return  "facturaId = " + facturaId +
                ", iva = " + iva +
                ", ordenCompra = '" + ordenCompra + '\'' +
                ", fecha = " + fecha +
                ", descuento = " + descuento +
                ", subTotal = " + subTotal +
                ", cliente = " + cliente +
                ", productos = " + productos
                ;
    }
}
