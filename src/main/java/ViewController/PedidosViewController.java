package ViewController;

import ColaPrioridad.ColasPrioritarias;
import Model.Envios;
import Model.Pedidos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uq.colasprioritarias.Iniciar;

import java.io.IOException;

public class PedidosViewController {


    @FXML
    private Button BttAgregarPedido;

    @FXML
    private Button BttPedidos;

    @FXML
    private RadioButton RdAseoHogar;

    @FXML
    private RadioButton RdComida;

    @FXML
    private RadioButton RdElectronomesticos;

    @FXML
    private TextField TxtDireccion;

    @FXML
    private TextField TxtNombre;

    @FXML
    private TextField TxtTelefono;



    public ColasPrioritarias<Pedidos>colasPrioritarias=new ColasPrioritarias<>();
    public ColasPrioritarias<Pedidos>colasMenos=new ColasPrioritarias<>();
    Envios envios;
    Pedidos pedidos;


    @FXML
    void initialize(){
        envios=Envios.getIntance();
        pedidos=Pedidos.getInstance();

    }

    public void agregarPedido(ActionEvent event){
        String nombre=TxtNombre.getText();
        String telefono=TxtTelefono.getText();
        String direccion=TxtDireccion.getText();
        String tipo="";
        if(RdComida.isSelected()){
            tipo="Comida";
        }
        if(RdAseoHogar.isSelected()){
            tipo="Productos de aseo";
        } else if (RdElectronomesticos.isSelected()) {
            tipo="Electrodomesticos";

        }
       pedidos=new Pedidos(direccion,nombre,direccion,tipo);
        entregaPrioritaria(tipo,pedidos);
        limpiar();
    }

    public void ver(ActionEvent event){
        this.loadWindow("pedido.fxml");
        System.out.println("Pedidos pendientes");

    }

    private void loadWindow(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Iniciar.class.getResource(fxmlFile));
            AnchorPane root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void limpiar(){
        TxtNombre.setText("");
        TxtTelefono.setText("");
        TxtDireccion.setText("");
    }

    private void quita(){
    }

    public ColasPrioritarias<Pedidos> entregaPrioritaria(String tipo, Pedidos pedidos){
        ColasPrioritarias<Pedidos>aux=new ColasPrioritarias<>();
        if(tipo.equals("Comida")) {
           envios.getPedidosPrioritarios().encolar(pedidos);
           aux=envios.getPedidosPrioritarios();

        }else{
            envios.getPedidos().encolar(pedidos);
        }
        return aux;
    }



}
