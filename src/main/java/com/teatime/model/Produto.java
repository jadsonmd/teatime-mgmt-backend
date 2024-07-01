package com.teatime.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(schema = "teatime", name = "produtos")
public class Produto {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="CODIGO", unique=true, nullable = false)
    private String codigo;

    @Column(name="NOME", nullable = false)
    private String nome;

    @Column(name="marca")
    private String marca;

    @Column(name="PRECO_VENDA", nullable = false)
    private BigDecimal precoVenda;

    @Column(name="ESTOQUE_MIN", nullable = false)
    private Integer estoqueMin;

    @Column(name="ESTOQUE_MAX", nullable = false)
    private Integer estoqueMax;

    @Column(name="ESTOQUE", nullable = false)
    private Integer estoque;

    @Column(name="ID_PARCEIRO", nullable = false)
    private String idParceiro;

    @Column(name="ID_TIPO_PRODUTO")
    private Long idTipoProduto;

    @Column(name="ID_ESPECIE_PRODUTO")
    private Long idEspecieProduto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_PARCEIRO"))
    private Parceiro parceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TIPO_PRODUTO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_TIPO_PRODUTO"))
    private TipoProduto tipoProduto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ESPECIE_PRODUTO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_ESPECIE_PRODUTO"))
    private EspecieProduto especieProduto;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EspecieProduto getEspecieProduto() {
        return especieProduto;
    }

    public void setEspecieProduto(EspecieProduto especieProduto) {
        this.especieProduto = especieProduto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Integer getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(Integer estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdEspecieProduto() {
        return idEspecieProduto;
    }

    public void setIdEspecieProduto(Long idEspecieProduto) {
        this.idEspecieProduto = idEspecieProduto;
    }

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public Long getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(Long idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}