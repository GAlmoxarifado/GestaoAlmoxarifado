/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author aluno
 */
public class Usuario {
    
    private int idUsuario;
    private String email;
    private String senha;
    private long cpf;
    private Funcionario funcionario;
    
    public Usuario(){
    this.funcionario = new Funcionario();
    }
    
    public Usuario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    
    public Usuario(Funcionario funcionario, int idUsuario, String email, String senha,
            long cpf){
        this.funcionario = funcionario;
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
