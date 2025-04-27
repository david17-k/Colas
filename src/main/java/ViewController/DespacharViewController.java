package ViewController;

import Model.Envios;
import Model.Pedidos;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DespacharViewController  {


    @FXML
    private TableView<Pedidos> tablePedidos;
    @FXML
    private TableColumn<Pedidos, String> direccion;

    @FXML
    private TableColumn<Pedidos, String> nombre;
    @FXML
    private TableColumn<Pedidos, String> telefono;
    @FXML
    private TableColumn<Pedidos, String> tipo;

   private ObservableList<Pedidos>pedidosObservableList= FXCollections.observableArrayList();

  private  Envios envios;



    @FXML
    void initialize(){
        envios=Envios.getIntance();
        tabla();
        cargarPedidosPrioritarios();
        cargarPediodos();
    }


    public void actualizar(ActionEvent event){
        System.out.println("Actulizar");
      int selection=tablePedidos.getSelectionModel().getSelectedIndex();
      tablePedidos.getItems().remove(selection);
      pedidosObservableList.clear();
    }



    public void entregar(ActionEvent event){
        envios.pedidosPrioritarios.desencolar();
        System.out.println("Producto enviado");

    }

  public void tabla(){
        tipo.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("tipo"));
        direccion.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("direccion"));
        telefono.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("telefono"));
        nombre.setCellValueFactory(new PropertyValueFactory<Pedidos,String>("nombre"));

    }

    private void cargarPedidosPrioritarios() {
        pedidosObservableList.clear();
            for (Pedidos c : envios.pedidosPrioritarios) {
                pedidosObservableList.addAll(c);
            }
                tablePedidos.getItems().addAll(pedidosObservableList);
            tablePedidos.refresh();
    }

    private void cargarPediodos(){
        pedidosObservableList.clear();
        for(Pedidos p:envios.pedidos){
            pedidosObservableList.addAll(p);
        }
        tablePedidos.getItems().addAll(pedidosObservableList);
    }









}
