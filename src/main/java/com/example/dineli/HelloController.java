package com.example.dineli;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.IllegalBlockingModeException;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.example.dineli.FoodQ.Cashier;
import static com.example.dineli.FoodQ.waitingListSize;

public class HelloController {
    @FXML
    private Label FoodFave;

    @FXML
    private TextField CustomerName;
    @FXML
    private Button SearchCustomerName;
    @FXML
    private Button Exit;
    @FXML
    private Label Cash1;
    @FXML
    private Label Cash2;
    @FXML
    private Label Cash3;
    @FXML
    private Label WaitingList;
    @FXML
    private Label X1;
    @FXML
    private Label X2;
    @FXML
    private Label X3;
    @FXML
    private Label X4;
    @FXML
    private Label X5;
    @FXML
    private Label X6;
    @FXML
    private Label X7;
    @FXML
    private Label X8;
    @FXML
    private Label X9;
    @FXML
    private Label X10;
    @FXML
    private Label X11;
    @FXML
    private Label X12;
    @FXML
    private Label X13;
    @FXML
    private Label X14;
    @FXML
    private Label X15;
    @FXML
    private TextArea View;

    public void FoodFave(MouseEvent mouseEvent) {

        FoodQ obj = null;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {

                if (obj.Cashier[0][0] == null) {
                    X1.setText("X");
                } else {
                    X1.setText("0 - " + obj.Cashier[0][0].getFirstName() + " " + obj.Cashier[0][0].getLastName());
                }

                if (obj.Cashier[0][1] == null) {
                    X2.setText("X");
                } else {
                    X2.setText("0 - " + obj.Cashier[0][1].getFirstName() + " " + obj.Cashier[0][1].getLastName());
                }


            } else if (i == 1) {
                if (obj.Cashier[1][0] == null) {
                    X3.setText("X");
                } else {
                    X3.setText("0 - " + obj.Cashier[1][0].getFirstName() + " " + obj.Cashier[1][0].getLastName());
                }

                if (obj.Cashier[1][1] == null) {
                    X4.setText("X");
                } else {
                    X4.setText("0 - " + obj.Cashier[1][1].getFirstName() + " " + obj.Cashier[1][1].getLastName());
                }

                if (obj.Cashier[1][2] == null) {
                    X5.setText("X");
                } else {
                    X5.setText("0 - " + obj.Cashier[1][2].getFirstName() + " " + obj.Cashier[1][2].getLastName());
                }

            } else if (i == 2) {
                if (obj.Cashier[2][0] == null) {
                    X6.setText("X");
                } else {
                    X6.setText("0 - " + obj.Cashier[2][0].getFirstName() + " " + obj.Cashier[2][0].getLastName());
                }

                if (obj.Cashier[2][1] == null) {
                    X7.setText("X");
                } else {
                    X7.setText("0 - " + obj.Cashier[2][1].getFirstName() + " " + obj.Cashier[2][1].getLastName());
                }

                if (obj.Cashier[2][2] == null) {
                    X8.setText("X");
                } else {
                    X8.setText("0 - " + obj.Cashier[2][2].getFirstName() + " " + obj.Cashier[2][2].getLastName());
                }

                if (obj.Cashier[2][3] == null) {
                    X9.setText("X");
                } else {
                    X9.setText("0 - " + obj.Cashier[2][3].getFirstName() + " " + obj.Cashier[2][3].getLastName());
                }

                if (obj.Cashier[2][4] == null) {
                   X10.setText("X");
                } else {
                  X11.setText("0 - " + obj.Cashier[2][4].getFirstName() + " " + obj.Cashier[2][4].getLastName());
                }

            } else {
                if (obj.WaitingQueue[0] == null) {
                    X11.setText("X");
                } else {
                    X11.setText("0 - " + obj.WaitingQueue[0].getFirstName() + " " + obj.WaitingQueue[0].getLastName());
                }

                if (obj.WaitingQueue[1] == null) {
                    X12.setText("X");
                } else {
                    X12.setText("0 - " + obj.WaitingQueue[1].getFirstName() + " " + obj.WaitingQueue[1].getLastName());
                }

                if (obj.WaitingQueue[2] == null) {
                    X13.setText("X");
                } else {
                    X13.setText("0 - " + obj.WaitingQueue[2].getFirstName() + " " + obj.WaitingQueue[2].getLastName());
                }

                if (obj.WaitingQueue[3] == null) {
                    X14.setText("X");
                } else {
                    X14.setText("0 - " + obj.WaitingQueue[3].getFirstName() + " " + obj.WaitingQueue[3].getLastName());
                }

                if (obj.WaitingQueue[4] == null) {
                    X15.setText("X");
                } else {
                    X15.setText("0 - " + obj.WaitingQueue[4].getFirstName() + " " + obj.WaitingQueue[4].getLastName());
                }
            }
        }


    }

}