package org.example;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Temperature Converter");

        Label inputLabel = new Label("Enter Temperature:");
        TextField inputField = new TextField();
        Label unitLabel = new Label("Select Unit:");
        ComboBox<String> unitComboBox = new ComboBox<>();
        unitComboBox.getItems().addAll("Celsius", "Fahrenheit", "Kelvin");
        unitComboBox.setValue("Celsius"); ///default value
        Label resultLabel = new Label("Converted Temperature:");
        Label firstResultValueLabel = new Label();
        Label secondResultValueLabel = new Label();
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(30, 30, 30, 30));
        vBox.getChildren().addAll(inputLabel, inputField, unitLabel,
                unitComboBox, resultLabel, firstResultValueLabel,secondResultValueLabel);
        unitComboBox.setOnAction(event -> {
            String selectedUnit = unitComboBox.getValue();
            String inputValue = inputField.getText();
            try{
                double resultFirst;
                double resultSecond;
                switch (selectedUnit) {
                    case "Celsius":
                        resultFirst = new TemperatureConverter(inputValue,selectedUnit)
                                .celsiusToFahrenheit();
                        resultSecond = new TemperatureConverter(inputValue,selectedUnit)
                                .celsiusToKelvin();
                        break;
                    case "Fahrenheit":
                        resultFirst = new TemperatureConverter(inputValue,selectedUnit)
                                .fahrenheitToCelsius();
                        resultSecond = new TemperatureConverter(inputValue,selectedUnit)
                                .fahrenheitToKelvin();
                        break;
                    case "Kelvin":
                        resultFirst = new TemperatureConverter(inputValue,selectedUnit)
                                .kelvinToCelsius();
                        resultSecond = new TemperatureConverter(inputValue,selectedUnit)
                                .kelvinToFahrenheit();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid unit");
                }
                if(selectedUnit.equals("Celsius")){
                    firstResultValueLabel.setText(String.format("Converted temperature: %.2f "+"Fahrenheit", resultFirst));
                    secondResultValueLabel.setText(String.format("Converted temperature: %.2f"+"Kelvin", resultSecond));
                }
                else if (selectedUnit.equals("Fahrenheit")){
                    firstResultValueLabel.setText(String.format("Converted temperature: %.2f "+"Celsius", resultFirst));
                    secondResultValueLabel.setText(String.format("Converted temperature: %.2f"+"Kelvin", resultSecond));
                }
                else if(selectedUnit.equals("Kelvin")){
                    firstResultValueLabel.setText(String.format("Converted temperature: %.2f "+"Celsius", resultFirst));
                    secondResultValueLabel.setText(String.format("Converted temperature: %.2f"+"Fahrenheit", resultSecond));

                }




            } catch (NumberFormatException e) {
            firstResultValueLabel.setText("Invalid input. Please enter a valid number.");
            secondResultValueLabel.setText("Invalid input. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            firstResultValueLabel.setText(e.getMessage());
        }

            // Add your conversion logic here based on the selected unit
            // Display the result or update another field with the converted value
        });
        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}