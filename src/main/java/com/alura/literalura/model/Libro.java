package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;

    private String idiomas;
    private Double numeroDeDescargas;

    @ManyToOne()
    private Autor autor;

    public Libro() {
    }

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idiomas = datosLibro.idiomas().get(0);
        this.numeroDeDescargas = OptionalDouble.of(Double.valueOf(datosLibro.numeroDeDescargas())).orElse(0);
        this.autor = new Autor(datosLibro.autor().get(0));
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----- LIBRO -----\n");
        sb.append("Titulo: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor.getNombre()).append("\n");
        sb.append("Idioma: ").append(idiomas).append("\n");
        sb.append("Numero de descargas: ").append(numeroDeDescargas).append("\n");
        sb.append("------------------\n");
        return sb.toString();
    }
}
