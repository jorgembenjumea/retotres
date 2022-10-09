package com.usa.misiontic.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity // 1. para que la clase Producto sea una entidad
@Table(name = "product") // 2. las tablas van a tener un nombre
public class Product implements Serializable { // Serializable cuando estoy trabajando con sokets o diferentes elementos y toca mandarConvierte a unos y cero para que al otro lado se reconstruya

    @Id // 4. Como hago para que 3 se convierta en una columna y sea un Id con @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 5. como generar un autoIncrement
    private Integer id; //3.cuando trabajamos con JPA no trabajamos con objetos primitivos
    private String name; //Campo de la tabla llamado name
    private Integer year;

    // Producto
    @ManyToOne // Muchos productos tendar una categoria
    @JoinColumn(name = "categoryId")    // Puedo indicarle como se llama la columna que tendra la llave foranea
    @JsonIgnoreProperties("products") // En el momento que imprima las categorias que elemento debo ignorar
    private Category category;


// Construyo los Getes y seters con Generate/ geter an setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
