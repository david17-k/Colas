package Model;

import ColaPrioridad.ColasPrioritarias;

public class Pedidos {

    private String nombre,telefono,direccion;
    private String tipo;

    private static Pedidos instancia;
public Pedidos(){

}

public static   Pedidos getInstance(){
    if(instancia==null){
        instancia=new Pedidos();
    }
    return instancia;
}

    public Pedidos(String direccion, String nombre, String telefono, String tipo) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

public void agregar(String direccion, String nombre, String telefono, String tipo){
    instancia=new Pedidos( direccion, nombre,  telefono, tipo);
}
}
