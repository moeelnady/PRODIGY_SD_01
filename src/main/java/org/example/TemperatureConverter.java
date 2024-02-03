package org.example;

public class TemperatureConverter {
 private double inputValue;
 private String selectedUnit;
 public TemperatureConverter(String inputValue,String selectedUnit){
     this.inputValue=Double.parseDouble(inputValue);
     this.selectedUnit=selectedUnit;
 }
    public double celsiusToFahrenheit() {
        return (inputValue * 9 / 5) + 32;
    }

    public double celsiusToKelvin() {
        return inputValue + 273.15;
    }

    public double fahrenheitToCelsius() {
        return (inputValue - 32) * 5 / 9;
    }

    public double fahrenheitToKelvin() {
        return (inputValue + 459.67) * 5 / 9;
    }

    public double kelvinToCelsius() {
        return inputValue - 273.15;
    }

    public double kelvinToFahrenheit() {
        return inputValue * 9 / 5 - 459.67;
    }


}
