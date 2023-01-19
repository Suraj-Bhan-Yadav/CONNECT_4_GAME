package com.example.connect_4_game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private HelloController controller;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        GridPane rootGridPane = fxmlLoader.load();

        controller = fxmlLoader.getController();

        controller.createPlayGround();


        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        stage.setTitle("Connect Four Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(actionEvent -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());

        fileMenu.getItems().addAll(newGame , resetGame, separatorMenuItem , exitGame);

        Menu helpMenu = new Menu("Help");

        MenuItem aboutGame = new MenuItem("About Connect four Game");
        aboutGame.setOnAction(actionEvent -> aboutConnect4Game());

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutMe());

        helpMenu.getItems().addAll(aboutGame, separatorMenuItem1, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;


    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Devloper");
        alert.setHeaderText("Suarj Bhan Yadav");
        alert.setContentText("I Love To Play Different Game So I Develope  This Game");
        alert.show();
    }

    private void aboutConnect4Game() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four Game");
        alert.setHeaderText("How To Play");
        alert.setContentText("Connect Four is a two-player connection game in which the " +
                "players first choose a color and then take turns dropping colored discs " +
                "from the top into a seven-column,six-row vertically suspended grid. " +
                "The pieces fall straight down, occupying the next available space within the column." +
                " The objective of the game is to be the first to form a horizontal, vertical,or diagonal " +
                "line of four of one's own discs. Connect Four is a solved game. " +
                "The first player can always win by playing the right moves");

        alert.show();

    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {

    }

    public static void main(String[] args) {
        launch();
    }
}