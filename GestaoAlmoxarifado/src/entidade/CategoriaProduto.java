package entidade;

/**
 *
 * @author Savio
 */
public class CategoriaProduto {
    private int id;
    private String nome;

    public CategoriaProduto(int id, String descricao) {
        this.id = id;
        this.nome = descricao;
    }

    public CategoriaProduto() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
