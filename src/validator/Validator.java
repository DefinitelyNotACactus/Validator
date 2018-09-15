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
    
    //N�meros de CPF: 
    //cadeias de 3 d�gitos, seguidos de ponto, mais 3 d�gitos, ponto, 3 d�gitos, h�fen, 2 d�gitos.
    public static boolean validateCPF(String cpf) {
        String cpf_regex = "^\\d{3}\\.\\d{3}\\.\\d{3}\\.\\d{2}$";
        Pattern pattern = Pattern.compile(cpf_regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }
    
    //N�mero de telefone: 
    //4 d�gitos, h�fen, 4 d�gitos. Opcional: fazer um padr�o que possa reconhecer a primeira parte com 4 ou 5 d�gitos (para incluir o quinto d�gito dos n�meros de celular)
    public static boolean validatePhone(String number){
        String phone_regex = "^\\d{4,5}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(phone_regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
    
    //Placa de carro: 
    //3 letras mai�sculas, h�fen, 4 d�gitos
    public static boolean validatePlate(String plate){
        String plate_regex = "^[A-Z]{3}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(plate_regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }
    
    //URL simples da web: 
    //deve ser no formato www (3 letras w) seguidas de ponto, depois um nome de dom�nio com letras ou n�meros, seguido de .com ou .org
    public static boolean validateUrl(String url){
        String url_regex = "^[w]{3}\\.\\w+\\.(com|org)";
        Pattern pattern = Pattern.compile(url_regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
