package com.usa.misiontic.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// 1. convertimos la class Category en Serializable con implements
@Entity // Las entidades son aquellos objetos que me van a relacionar las tablas con las clases
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="category")  //Cascada es que va a pasar con los cambios que yo haga, pues le digo que los haga PERSISTIR
    // mappedBy: como se llama el atributo con relacion a la otra tabla
    @JsonIgnoreProperties("category") // Acada producto que propiedad le ignoro la category
    private List<Product> products; // hacemos la relacion de Uno a Muchos

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
