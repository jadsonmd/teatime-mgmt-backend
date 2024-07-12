package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "tipo_produtos")
public class TipoProduto {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TIPO_PRODUTO_PARCEIRO"))
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