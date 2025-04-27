module uq.colasprioritarias {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens uq.colasprioritarias to javafx.fxml;
    exports uq.colasprioritarias;
opens Model to javafx.fxml;
exports Model;
    opens ViewController to javafx.fxml;
    exports ViewController;
    opens ColaPrioridad to javafx.fxml;
    exports ColaPrioridad;

}