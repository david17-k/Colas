package Model;

import ColaPrioridad.ColasPrioritarias;
import ColaPrioridad.ListaSimple;

public class Envios {

    public ColasPrioritarias<Pedidos>pedidos=new ColasPrioritarias<>();
   public ColasPrioritarias<Pedidos>pedidosPrioritarios=new ColasPrioritarias<>();
   public ListaSimple<Pedidos>lista=new ListaSimple<>();
    private static Envios instancia;

    public Pedidos pedido;

    public Envios() {

    }
    public synchronized static Envios getIntance(){
        if(instancia==null){
            instancia=new Envios();
        }
        return instancia;
    }
    public Pedidos obtenerInformacion(){
        Pedidos pedidos1 = null;
        for (Pedidos c:pedidosPrioritarios){
            System.out.println(c.getTipo());
            return c;
        }
        return pedidos1;
    }

    public Envios(ColasPrioritarias<Pedidos> pedidos, ColasPrioritarias<Pedidos> pedidosPrioritarios) {
        this.pedidos = pedidos;
        this.pedidosPrioritarios = pedidosPrioritarios;
    }

    public ColasPrioritarias<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ColasPrioritarias<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public ColasPrioritarias<Pedidos> getPedidosPrioritarios() {
        return pedidosPrioritarios;
    }

    public void setPedidosPrioritarios(ColasPrioritarias<Pedidos> pedidosPrioritarios) {
        this.pedidosPrioritarios = pedidosPrioritarios;
    }
}
