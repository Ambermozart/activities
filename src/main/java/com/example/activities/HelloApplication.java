package com.example.activities;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        String s = "Wybierz bad, good or neutral";
        Label label = new Label("Wybierz bad, good or moderate lub dodaj opcję do pliku");
        TextField textField = new TextField();
      //  TextField textField2 = new TextField("dodaj linijke do bad");
        Label label1 = new Label();
        Button button = new Button("zatwierdź");
        Button button2 = new Button("dodaj bad");
        Button button3 = new Button("dodaj moderate");
        Button button4 = new Button("dodaj good");

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String mood = textField.getText();
                //button.setDisable(true);
                try {
                    label1.setText((ActionRandomizer.actions(mood)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
              //  button.setDisable(true);
                textField.setDisable(false);
            }
        };

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String badMood = System.lineSeparator() + textField.getText();
                try {
                    FilesRepository filesRepository = new FilesRepository();
                    filesRepository.addBadLine(badMood);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                button2.setDisable(true);
                textField.setDisable(false);
            }
        };    EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String moderateMood = System.lineSeparator() + textField.getText();
                try {
                    FilesRepository filesRepository = new FilesRepository();
                    filesRepository.addModerateLine(moderateMood);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                button3.setDisable(true);
                textField.setDisable(false);
            }
        };    EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String goodMood = System.lineSeparator() + textField.getText();
                try {
                    FilesRepository filesRepository = new FilesRepository();
                    filesRepository.addGoodLine(goodMood);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                button4.setDisable(true);
                textField.setDisable(false);
            }
        };

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setDisable(true);
                button.setDisable(false);
                button2.setDisable(false);
                button3.setDisable(false);
                button4.setDisable(false);
            }
        };

        label.setStyle("-fx-font: 14 arial;");
        button.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        //   button.setAlignment("CENTER");
        button.setOnAction(event);
        button2.setOnAction(event3);
        button3.setOnAction(event4);
        button4.setOnAction(event5);
        textField.setOnAction(event2);

        VBox vBox = new VBox(20);

        vBox.getChildren().add(label);
        vBox.getChildren().add(textField);
      //  vBox.getChildren().add(textField2);
        vBox.getChildren().add(button);
        vBox.getChildren().add(button2);
        vBox.getChildren().add(button3);
        vBox.getChildren().add(button4);
        vBox.getChildren().add(label1);

        Scene scene = new Scene(vBox, 400, 400);
        stage.setTitle("Witam");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException {

        FilesRepository filesRepository = new FilesRepository();
        filesRepository.loadBad();
        filesRepository.loadGood();
        filesRepository.loadModerate();
        launch();
    }
}