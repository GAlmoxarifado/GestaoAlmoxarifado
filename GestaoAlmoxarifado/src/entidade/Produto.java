package entidade;

/**
 *
 * @author Savio
 */
public class Produto {
    private String nome;
    private String descricao;
    private Integer id_prod;
    private Integer codigoBusca;
    private Double valorUnitario;
    private Integer categoria;

    public Produto(String nome, String descricao, Integer id_prod, Integer codigoBusca, Double valorUnitario, Integer categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.id_prod = id_prod;
        this.codigoBusca = codigoBusca;
        this.valorUnitario = valorUnitario;
        this.categoria = categoria;
    }

    public Produto() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Integer getId_prod() {
        return id_prod;
    }

    public void setId_prod(Integer id_prod) {
        this.id_prod = id_prod;
    }

    public Integer getCodigoBusca() {
        return codigoBusca;
    }

    public void setCodigoBusca(Integer codigoBusca) {
        this.codigoBusca = codigoBusca;
    }
}
