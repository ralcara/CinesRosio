/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import jakarta.persistence.*;
import java.util.List;
/**
 *
 * @author rocio
 */
@Entity
@Table(name = "cliente")
public class Cliente {

    // Clave primaria k se autoincrementa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idCliente;

    // Columna nombre en la tabla cliente
    @Column(name = "nombre")
    private String nombre;

    // Columna apellido en la tabla cliente
    @Column(name = "apellido")
    private String apellido;

    // Columna correo electrónico en la tabla cliente
    @Column(name = "correo")
    private String email; 

    // Columna teléfono en la tabla cliente
    @Column(name = "telefono")
    private String telefono;

  
    public Cliente() {}

    public Cliente(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

 
    @Override
    public String toString() {
        return "Cliente{" + 
               "idCliente=" + idCliente + 
               ", nombre=" + nombre + 
               ", apellido=" + apellido + 
               ", email=" + email + 
               ", telefono=" + telefono + 
               '}';
    }
}
