/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Validation;

/**
 *
 * @author rodri
 */
public class Teste {
    public static void main(String[] args) {
        try {
            String texto = " ";
            Validation.invalidCaracAndLetters(texto);
            //Validacao.invalidNumbers(texto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
//        String content = "G0dofredo";
//        Pattern pattern = Pattern.compile("a-zA-Z|[0-9]]+");
//        Matcher matcher = pattern.matcher(content);
//
//        while (matcher.find()) {
//            if (matcher.group().length() > 0) {
//                System.out.println(content + " contém " + matcher.group().length() + " ou mais letras");
//            }
//        }   
    }
}
