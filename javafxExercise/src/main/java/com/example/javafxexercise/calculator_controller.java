package com.example.javafxexercise;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class calculator_controller {

    @FXML
    private Label privnumber;

    @FXML
    private Label result;

    @FXML
    private Button clear;


    private double num1 = 0;
    private  double num2 = 0;
    private double total = 0;
    private String operator = "";
    private  boolean check = true;
    public Double creat(double num1, double num2, String operator){
        switch (operator){
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "X":
                return (num1 * num2);
            case "/":
                if (num2 == 0)
                    return 0.0;
                return (num1 / num2);
            default:
                break;
        }
        return 0.0;
    }

    public void number(String number){
        result.setText(result.getText() + number);
    }

    public void prevnum(String number){
        privnumber.setText(privnumber.getText() + number);
    }

    public void prevOperator(String operator){
        privnumber.setText(privnumber.getText() + " " + operator + " ");
    }

    public  void comuteprocess(ActionEvent event){
        if (check){
            result.setText("");
            privnumber.setText("");
            check = false;
        }
        Button button = (Button)event.getSource()  ;
        String value = button.getText();

        number(value);
        prevnum(value);
    }

    public  void operatorProcess(ActionEvent event){
        Button button = (Button)event.getSource();
        String value = button.getText();

        if (!value.equals("=")){
            if (!operator.isEmpty())
                return;
            operator = value;
            prevOperator(operator);
            num1 = Double.parseDouble(result.getText());
            result.setText("");

        }
        else {
            if (operator.isEmpty())
                return;
            Double num2 = Double.parseDouble(result.getText());
            total = creat(num1, num2, operator);
            result.setText(String.valueOf(total));
            operator = "";
            check = true;

        }
    }
    public void clear(ActionEvent event){
        if (event.getSource() == clear){
            result.setText("0.0");
            privnumber.setText("");
        }
    }

    public void exit(){
        System.exit(0);
    }



}
