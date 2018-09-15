/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David
 */
public class Validator {
    
    //Números de CPF: 
    //cadeias de 3 dígitos, seguidos de ponto, mais 3 dígitos, ponto, 3 dígitos, hífen, 2 dígitos.
    public static boolean validateCPF(String cpf) {
        String cpf_regex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\.\\d{2}$";
        Pattern pattern = Pattern.compile(cpf_regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }
    
    //Número de telefone: 
    //4 dígitos, hífen, 4 dígitos. Opcional: fazer um padrão que possa reconhecer a primeira parte com 4 ou 5 dígitos (para incluir o quinto dígito dos números de celular)
    public static boolean validatePhone(String number){
        String phone_regex = "^\\d{4,5}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(phone_regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    
    //Placa de carro: 
    //3 letras maiúsculas, hífen, 4 dígitos
    public static boolean validatePlate(String plate){
        String plate_regex = "^[A-Z]{3}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(plate_regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }
    
    //URL simples da web: 
    //deve ser no formato www (3 letras w) seguidas de ponto, depois um nome de domínio com letras ou números, seguido de .com ou .org
    public static boolean validateUrl(String url){
        String url_regex = "^[w]{3}\\.\\w+\\.(com|org)";
        Pattern pattern = Pattern.compile(url_regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
