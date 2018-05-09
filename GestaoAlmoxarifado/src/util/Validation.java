/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Utilitário para validação de string.
 * 
 * @author Rodrigo Leite
 */
public class Validation {
    
    /**
     * Limita a quantidade de caracteres em um campo de texto a partir da ação
     * das teclas do teclado.
     * 
     * <p> A {@code String} faz referência ao que for digitado em um
     * campo de texto, sendo avaliado seu tamanho e posteriormente sendo
     * limitado.
     * 
     * 
     * @param quantidadeMax Quantidade limite de caracteres
     * @param texto String a ser limitada
     * @param evt Ação da tecla do teclado
     * @throws Exception Alerta de limite
     */
    public static void limitMaxCaracter(int quantidadeMax, String texto, KeyEvent evt) throws Exception{
        if(texto.trim().length() >= quantidadeMax){
            evt.consume();
            throw new Exception("Quantidade máxima de caracteres: " + quantidadeMax);
        }
    }
    
    public static void limitMinCaracter(int quantidadeMin, String texto) throws Exception{
        if(texto.trim().length() < quantidadeMin){
            throw new Exception("Quantidade mínima de caracteres: " + quantidadeMin);
        }
    }
    
    public static void limitMaxMinCaracter(int quantidadeMax, int quantidadeMin, String texto) throws Exception{
        if(texto.trim().length() < quantidadeMin || texto.trim().length() >= quantidadeMax){
            throw new Exception("Quantidade mínima de caracteres: " + quantidadeMin +
                    "\nQuantidade máxima de caracteres: " + quantidadeMax);
        }
    }
    
    /**
     * 
     * @param texto
     * @throws Exception 
     */
    public static void invalidCaracters(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020-\u002D|\u002F-\u003F|"
                + "\\u005B-\u005E|\u0060|\u007B-\u02AF]");
        Matcher matcher = pattern.matcher(texto);
        
        if(matcher.find()){
            throw new Exception("Caracter(es) inválidos!");
        }
    }
    
    public static void invalidCaracters(ArrayList<String> string) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020-\u002D|\u002F-\u003F|"
                + "\\u005B-\u005E|\u0060|\u007B-\u02AF]");
        for (String texto : string) {
            Matcher matcher = pattern.matcher(texto);

            if(matcher.find()){
                throw new Exception("Caracter(es) inválidos!");
            }
        }
    }
    
    public static void invalidCaracAndNumbers(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0021-\u0040|\\u005B-\\u005D|"
                + "\u005F-\u0060|\u007B-\u007D|\u00A1-\u00BF]");
        Matcher matcher = pattern.matcher(texto);
        
        if(matcher.find()){
            throw new Exception("Caracter(es) inválidos!");
        }
    }
    
    public static void invalidCaracAndNumbers(ArrayList<String> string) throws Exception{
        Pattern pattern = Pattern.compile("[\u0021-\u0040|\\u005B-\\u005D|"
                + "\u005F-\u0060|\u007B-\u007D|\u00A1-\u00BF]");
        
        for (String texto : string) {
            Matcher matcher = pattern.matcher(texto);
            if(matcher.find()){
                throw new Exception("Caracter(es) inválidos!");
            }
        }
    }
    
    public static void invalidCaracAndLetters(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020-\u002F|\u003A-\u02AF]");
        Matcher matcher = pattern.matcher(texto);
        
        if(matcher.find()){
            throw new Exception("Caracter(es) inválido(s)!");
        }
    }
    
    public static void invalidCaracAndLetters(ArrayList<String> string) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020-\u002F|\u003A-\u02AF]");
        for (String texto : string) {
            Matcher matcher = pattern.matcher(texto);
        
            if(matcher.find()){
                throw new Exception("Caracter(es) inválido(s)!");
            }
        }
    }
    
    public static void invalidNumbers(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0030-\u0039]");
        Matcher matcher = pattern.matcher(texto);
        if(matcher.find()){
            throw new Exception("Número(s) não permitido(s)!");
        }
    }
    
    public static void invalidLetters(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0041-\u005A|\u0061-\u007A|"
                + "\u00C0-\u01BF]");
        Matcher matcher = pattern.matcher(texto);
        if(matcher.find()){
            throw new Exception("Letra(s) não permitida(s)!");
        }
    }
    
    public static void invalidLetters(ArrayList<String> string) throws Exception{
        Pattern pattern = Pattern.compile("[\u0041-\u005A|\u0061-\u007A|"
                + "\u00C0-\u01BF]");
        
        for (String texto : string) {
            Matcher matcher = pattern.matcher(texto);
            if(matcher.find()){
                throw new Exception("Letra(s) não permitida(s)!");
            }
        }
        
    }
    
    public static void invalidSpaces(String texto) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020]");
        Matcher matcher = pattern.matcher(texto);
        if(matcher.find()){
            throw new Exception("Espaço(s) não permitido(s)!");
        }
    }
    
    public static void invalidSpaces(ArrayList<String> string) throws Exception{
        Pattern pattern = Pattern.compile("[\u0020]");
        for (String texto : string) {
            Matcher matcher = pattern.matcher(texto);
            if(matcher.find()){
                throw new Exception("Espaço(s) não permitido(s)!");
            }
        }
    }
    
    public static void isEmpty(String texto) throws Exception{
        if(texto.isEmpty()) throw new Exception("Campo(s) vazio(s)!");
    }
    
    public static void isEmpty(ArrayList<String> texto) throws Exception{
        for (String string : texto) {
            if(string.isEmpty()) throw new Exception("Campo(s) vazio(s)!");
        }
    }
}
