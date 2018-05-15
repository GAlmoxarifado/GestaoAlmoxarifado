package entidade;

import java.sql.Date;

/**
 *
 * @author Savio
 */
public class EntradaProduto {
    private Integer id;
    private Date data_Validade;
    private Date data_Entrada;
    private Double quantidade;
    private int acao;
    private Produto produto;
    private Usuario usuario_Sis;

    public EntradaProduto(Integer id, Date data_Validade, Date dataEntrada, 
            Double quantidade, int acao, Produto produto, 
            Usuario usuario_Sis) {
        this.id = id;
        this.data_Validade = data_Validade;
        this.data_Entrada = dataEntrada;
        this.quantidade = quantidade;
        this.acao = acao;
        this.produto = produto;
        this.usuario_Sis = usuario_Sis;
    }

   

    public EntradaProduto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_Entrada() {
        return data_Entrada;
    }

    public void setData_Entrada(Date data_Entrada) {
        this.data_Entrada = data_Entrada;
    }

    public Date getData_Validade() {
        return data_Validade;
    }

    public void setData_Validade(Date data_Validade) {
        this.data_Validade = data_Validade;
    }

    public int getAcao() {
        return acao;
    }

    public void setAcao(int acao) {
        this.acao = acao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario_Sis() {
        return usuario_Sis;
    }

    public void setUsuario_Sis(Usuario usuario_Sis) {
        this.usuario_Sis = usuario_Sis;
    }    
}
