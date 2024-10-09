package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "unidade_medida")
public class UnidadeMedida {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name = "SIGLA", nullable = false)
    private String sigla;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_UNIDADE_MEDIDA_PARCEIRO"))
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
