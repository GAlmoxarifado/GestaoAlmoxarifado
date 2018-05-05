package entidade;

import java.sql.Date;

/**
 *
 * @author Savio
 */
public class EntradaProduto {
    private Integer id;
    private Integer quantidade;
    private Date dataEntrada;

    public EntradaProduto(Integer id, Integer quantidade, Date dataEntrada) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
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

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
