package com.teatime.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(schema = "teatime", name = "produtos", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CODIGO_IDPARCEIRO", columnNames = {"CODIGO", "ID_PARCEIRO"})
})
public class Produto {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(name="CODIGO", nullable = false)
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
    private String idTipoProduto;

    @Column(name="ID_ESPECIE_PRODUTO")
    private String idEspecieProduto;

    @Column(name="ID_UNIDADE_MEDIDA")
    private String idUnidadeMedida;

    @Column(name="ID_FORNECEDOR")
    private String idFornecedor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PARCEIRO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_PARCEIRO"))
    private Parceiro parceiro;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TIPO_PRODUTO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_TIPO_PRODUTO"))
    private TipoProduto tipoProduto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ESPECIE_PRODUTO", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_ESPECIE_PRODUTO"))
    private EspecieProduto especieProduto;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_FORNECEDOR", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_FORNECEDOR"))
    private Fornecedor fornecedor;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_UNIDADE_MEDIDA", updatable=false, insertable=false, foreignKey = @ForeignKey(name = "FK_PRODUTO_UNIDADE_MEDIDA"))
    private UnidadeMedida unidadeMedida;

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

    public String getIdEspecieProduto() {
        return idEspecieProduto;
    }

    public void setIdEspecieProduto(String idEspecieProduto) {
        this.idEspecieProduto = idEspecieProduto;
    }

    public String getIdParceiro() {
        return idParceiro;
    }

    public void setIdParceiro(String idParceiro) {
        this.idParceiro = idParceiro;
    }

    public String getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(String idTipoProduto) {
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

    public String getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(String idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}