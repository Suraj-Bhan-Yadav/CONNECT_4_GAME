module com.example.connect_4_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.connect_4_game to javafx.fxml;
    exports com.example.connect_4_game;
}