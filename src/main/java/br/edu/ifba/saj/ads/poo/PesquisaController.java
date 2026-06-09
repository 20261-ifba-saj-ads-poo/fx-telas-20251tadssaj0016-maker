package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.data.Acervo;
import br.edu.ifba.saj.ads.poo.model.Livro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class PesquisaController {

    @FXML private TextField txBusca;
    @FXML private TableView<Livro>           tbLivros;
    @FXML private TableColumn<Livro, String> colTitulo;
    @FXML private TableColumn<Livro, String> colAutor;
    @FXML private TableColumn<Livro, String> colCategoria;

    @FXML
    private void initialize() {
        colTitulo .setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
    }

    @FXML
    void pesquisar(ActionEvent event) {
        String termo = txBusca.getText().trim().toLowerCase();

        if (termo.isEmpty()) {
            tbLivros.setItems(FXCollections.observableArrayList(Acervo.livros));
            return;
        }

        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : Acervo.livros) {
            if (livro.getTitulo().toLowerCase().contains(termo)
             || livro.getAutor().toLowerCase().contains(termo)
             || livro.getCategoria().toLowerCase().contains(termo)) {
                resultado.add(livro);
            }
        }

        tbLivros.setItems(FXCollections.observableArrayList(resultado));
    }
}
