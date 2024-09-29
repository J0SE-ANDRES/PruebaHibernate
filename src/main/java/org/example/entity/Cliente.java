package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de la entidad clientes
 */
@Entity(name = "clientes")
@Table(
    uniqueConstraints = {
            @UniqueConstraint(columnNames = "correo", name = "correoUniqueConstraint"),
            @UniqueConstraint(columnNames = "identificacion", name = "identificacionUniqueConstraint")
    }
)
public class Cliente {

    // Atributos de la Clase
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clienteId;

    @Column(name = "identificacion")
    private long identificacion;
    private String nombres;
    private String apellidos;
    @Column(name = "razon_social")
    private String razonSocial;
    private String ciudad;
    private String direccion;
    private int telefono;
    private String correo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas;

    // Constructores
    public Cliente() {
    }

    public Cliente(long identificacion, String nombres, String apellidos, String razonSocial, String ciudad, String direccion, int telefono, String correo) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.razonSocial = razonSocial;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(long identificacion, String nombres, String apellidos, String razonSocial, String ciudad, String direccion, int telefono, String correo, List<Factura> facturas) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.razonSocial = razonSocial;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.facturas = facturas;
    }

    // Metodos Getters and Setters
    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    /**
     * Metodo para añadir una factura
     * @param factura
     */
    public void addFactura(Factura factura) {
        if (facturas == null) {
            facturas = new ArrayList<Factura>();
        }
        facturas.add(factura);
    }

    // ToString para la representacion del objeto Cliente
    @Override
    public String toString() {
        return  "clienteId = " + clienteId +
                ", identificacion = " + identificacion +
                ", nombres = '" + nombres + '\'' +
                ", apellidos = '" + apellidos + '\'' +
                ", razonSocial = '" + razonSocial + '\'' +
                ", ciudad = '" + ciudad + '\'' +
                ", direccion = '" + direccion + '\'' +
                ", telefono = " + telefono +
                ", correo = '" + correo + '\'' +
                ", facturas = " + facturas
                ;
    }
}
