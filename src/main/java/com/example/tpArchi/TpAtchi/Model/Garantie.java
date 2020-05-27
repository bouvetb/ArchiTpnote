package com.example.tpArchi.TpAtchi.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garantie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String Nom;

    private Integer Montant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Integer getMontant() {
        return Montant;
    }

    public void setMontant(Integer montant) {
        Montant = montant;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Description;


}
