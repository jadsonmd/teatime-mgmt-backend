package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "usuarios")
public class Usuario {

    @Id
    @Column(name="ID", nullable = false)
    private String id;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="EMAIL", nullable = false)
    private String email;

    @Column(name="ID_PARCEIRO", nullable = true)
    private String idParceiro;

    @Column(name="ID_UNIDADE", nullable = true)
    private Long idUnidade;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_USUARIO_PARCEIRO"))
    private Parceiro parceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_USUARIO_UNIDADE"))
    private Unidade unidade;

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

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}
