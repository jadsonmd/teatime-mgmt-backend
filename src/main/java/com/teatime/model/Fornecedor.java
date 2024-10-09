package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "fornecedor")
public class Fornecedor {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="CNPJ")
    private String cnpj;

    @Column(name = "fone")
    private String fone;

    @Column(name = "email")
    private String email;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_FORNECEDOR_PARCEIRO"))
    private Parceiro parceiro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }
}
