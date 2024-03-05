module com.example.shaggy {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.dineli to javafx.fxml;
    exports com.example.dineli;
}