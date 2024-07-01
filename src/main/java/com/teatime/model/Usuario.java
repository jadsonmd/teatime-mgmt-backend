package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "usuarios")
public class Usuario {

    @Id
    @Column(name="ID", nullable = false)
    private String id;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="EMAIL", nullable = false)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
