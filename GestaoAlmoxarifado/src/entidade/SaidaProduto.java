package entidade;

import java.sql.Date;

/**
 *
 * @author Savio
 */
public class SaidaProduto {

    private Integer id;
    private Date data_Saida;
    private Double quantidade;
    private EntradaProduto produto;
    private Funcionario funcionario;
    
    public SaidaProduto() {
    }

    public SaidaProduto(Integer id, Date data_Saida, Double quantidade, 
            EntradaProduto produto, Funcionario funcionario) {
        this.id = id;
        this.data_Saida = data_Saida;
        this.quantidade = quantidade;
        this.produto = produto;
        this.funcionario = funcionario;
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

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public EntradaProduto getEntradaProduto() {
        return produto;
    }

    public void setEntradaProduto(EntradaProduto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
