package application.bookstore.controllers;

import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class FilterController {
    public static ComboBox<String> createFilterComboBox(ArrayList<String> categories) {
            ComboBox<String> comboBox = new ComboBox<>();
            for(String string : categories) {
                comboBox.getItems().add(string);
            }
        comboBox.getSelectionModel().selectFirst();
            return comboBox;
    }
}
