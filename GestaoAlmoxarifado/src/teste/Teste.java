/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.Validation;

/**
 *
 * @author rodri
 */
public class Teste {
    public static void main(String[] args) {
        DateFormat c = new SimpleDateFormat("dd/MM/yyyy");
        Date b = new Date();
        Timestamp a = new Timestamp(b.getTime());
//        try {
//            String texto = " ";
//            Validation.invalidCaracAndLetters(texto);
//            //Validacao.invalidNumbers(texto);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        
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
