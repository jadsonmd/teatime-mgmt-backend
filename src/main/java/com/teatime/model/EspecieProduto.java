package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "especie_produtos")
public class EspecieProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="ID", nullable = false)
    private Long id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="PREFIXO", nullable = true)
    private String prefixo;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_ESPECIE_PRODUTO_PARCEIRO"))
    private Parceiro parceiro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
}