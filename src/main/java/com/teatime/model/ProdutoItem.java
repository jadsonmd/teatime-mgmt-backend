package com.teatime.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(schema = "teatime", name = "PRODUTO_ITEM")
public class ProdutoItem {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="ID_PRODUTO", nullable = false)
    private String idProduto;

    @Column(name="LOTE", nullable = false)
    private String lote;

    @Column(name="QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name="PRECO_COMPRA", nullable = false)
    private BigDecimal precoCompra;

    @Column(name="DATA_VALIDADE", nullable = false)
    private Date dataValidade;

    @Column(name="IN_USO", nullable = false)
    private Boolean inUso;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PRODUTO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_ITEM_PRODUTO"))
    private Produto produto;

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public Boolean getInUso() {
        return inUso;
    }

    public void setInUso(Boolean inUso) {
        this.inUso = inUso;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}