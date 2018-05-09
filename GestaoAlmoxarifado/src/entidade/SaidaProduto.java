package entidade;

import java.sql.Date;

/**
 *
 * @author Savio
 */
public class SaidaProduto {

    private Integer id;
    private Date data_Saida;
    private Integer quantidade;
    private Integer produto;
    private Integer usuario_sis;
    
    public SaidaProduto() {
    }

    public SaidaProduto(Integer id, Date data_Saida, Integer quantidade, Integer produto, Integer usuario_sis) {
        this.id = id;
        this.data_Saida = data_Saida;
        this.quantidade = quantidade;
        this.produto = produto;
        this.usuario_sis = usuario_sis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_Saida() {
        return data_Saida;
    }

    public void setData_Saida(Date data_Saida) {
        this.data_Saida = data_Saida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getUsuario_sis() {
        return usuario_sis;
    }

    public void setUsuario_sis(Integer usuario_sis) {
        this.usuario_sis = usuario_sis;
    }
}
