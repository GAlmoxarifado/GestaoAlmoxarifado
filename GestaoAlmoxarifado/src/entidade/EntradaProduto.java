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
    private Integer quantidade;
    private int acao;
    private Integer produto;
    private Integer usuario_Sis;
    private Integer funcionario;

    public EntradaProduto(Integer id, Date data_Validade, Date dataEntrada, Integer quantidade, int acao, Integer produto, Integer usuario_Sis, Integer funcionario) {
        this.id = id;
        this.data_Validade = data_Validade;
        this.data_Entrada = dataEntrada;
        this.quantidade = quantidade;
        this.acao = acao;
        this.produto = produto;
        this.usuario_Sis = usuario_Sis;
        this.funcionario = funcionario;
    }

   

    public EntradaProduto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
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

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getUsuario_Sis() {
        return usuario_Sis;
    }

    public void setUsuario_Sis(Integer usuario_Sis) {
        this.usuario_Sis = usuario_Sis;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }
}
