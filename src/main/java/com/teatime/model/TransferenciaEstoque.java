package com.teatime.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "teatime", name = "transferencia_estoque")
public class TransferenciaEstoque {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="ID_PRODUTO_ITEM", nullable = false)
    private String idProdutoItem;

    @Column(name="ID_UNIDADE", nullable = false)
    private Long idUnidade;

    @Column(name="QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_PARCEIRO"))
    private Parceiro parceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PRODUTO_ITEM", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_PRODUTO_ITEM"))
    private ProdutoItem produtoItem;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_TRANSFERENCIA_ESTOQUE_UNIDADE"))
    private Unidade unidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProdutoItem() {
        return idProdutoItem;
    }

    public void setIdProdutoItem(String idProdutoItem) {
        this.idProdutoItem = idProdutoItem;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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

    public ProdutoItem getProdutoItem() {
        return produtoItem;
    }

    public void setProdutoItem(ProdutoItem produtoItem) {
        this.produtoItem = produtoItem;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}