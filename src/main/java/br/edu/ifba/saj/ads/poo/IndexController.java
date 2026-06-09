package br.edu.ifba.saj.ads.poo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class IndexController {

    @FXML
    private BorderPane pane;

    @FXML
    public void abrirCadastro(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Cadastro.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirPesquisa(ActionEvent event) {
        try {
            pane.setCenter(FXMLLoader.load(getClass().getResource("Pesquisa.fxml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
