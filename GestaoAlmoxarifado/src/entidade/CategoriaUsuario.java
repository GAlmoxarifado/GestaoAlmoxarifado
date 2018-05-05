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
public enum CategoriaUsuario {
    
    SISTEMA("Sistema"),
    ALMOXARIFADO("Almoxarifado");
    
    String categoria;
    
    CategoriaUsuario(String categoria){
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }
}
