package br.edu.ifba.saj.ads.poo.model;

public class Livro {

    private String titulo;
    private String autor;
    private String categoria;

    public Livro(String titulo, String autor, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getTitulo() { return titulo; }
    public String getAutor(){ return autor; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return titulo;
    }
}
