/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.fabricasconcretas;

import entidade.Veiculo;
import java.util.Iterator;
import persistencia.PVeiculo;
import util.fabricaabstrata.CategoriaAbstrata;

/**
 *
 * @author rodri
 */
public class CarroEspecial extends CategoriaAbstrata{

    public CarroEspecial() {
        codCategoria = 3;
        descricao = "Carro Especial";
    }

    @Override
    public Iterator<Veiculo> getListaDeVeiculos() {
        try {
            return new PVeiculo().listarPorFiltro(codCategoria, null);
        } catch (Exception e) {
            return null;
        }
    }
}