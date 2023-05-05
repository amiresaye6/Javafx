module com.example.javafxexercise {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxexercise to javafx.fxml;
    exports com.example.javafxexercise;
}