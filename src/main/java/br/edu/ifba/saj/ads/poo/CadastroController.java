package br.edu.ifba.saj.ads.poo;

import br.edu.ifba.saj.ads.poo.data.Acervo;
import br.edu.ifba.saj.ads.poo.model.Livro;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CadastroController {

    @FXML private TextField txTitulo;
    @FXML private TextField txAutor;
    @FXML private TextField txCategoria;

    @FXML private TableView<Livro>           tbLivros;
    @FXML private TableColumn<Livro, String> colTitulo;
    @FXML private TableColumn<Livro, String> colAutor;
    @FXML private TableColumn<Livro, String> colCategoria;

    @FXML
    private void initialize() {
        colTitulo   .setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor    .setCellValueFactory(new PropertyValueFactory<>("autor"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        tbLivros.setItems(FXCollections.observableArrayList(Acervo.livros));
    }

    @FXML
    void salvarLivro(ActionEvent event) {
        String titulo    = txTitulo.getText().trim();
        String autor     = txAutor.getText().trim();
        String categoria = txCategoria.getText().trim();

        if (titulo.isEmpty() || autor.isEmpty() || categoria.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.").showAndWait();
            return;
        }

        Acervo.livros.add(new Livro(titulo, autor, categoria));

        txTitulo.clear();
        txAutor.clear();
        txCategoria.clear();

        tbLivros.setItems(FXCollections.observableArrayList(Acervo.livros));
        new Alert(Alert.AlertType.INFORMATION, "Livro cadastrado com sucesso!").showAndWait();
    }
}
