/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopArtist;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * María Fernanda Hernández Enriquez
 * A01329383
 * Calidad y pruebas de software
 * Parcial 1
 * @author Fer Enriquez'
 */
public class Artist {

    public static final int CORRECT         = 1;
    public static final int LESS_INP	    = 2;
    public static final int LESS_ART        = 3;
    public static final int MAX_INP         = 4;
    public static final int COMB_LENG       = 5;
    public static final int INP_FORMAT      = 6;
    public static final int INP_ORDER       = 7;
    public static final int POSITION        = 8;
    public static final int FORMAT_ORDER    = 9;
    public static final int FORMAT_SEP      = 10;
    public static final int INP_PAIR        = 11;
    public static final int INT_ORDER       = 12;
    public static final int INT_ORDERR      = 13;
    public static final int INT_ORDER_CON   = 14;
    public static final int INT_ORDER_CONT  = 15;
    public static final int INT_REPEAT      = 16;
    public static final int INT_FLOAT       = 17;
    public static final int INT_NEGATIVE    = 18;
    public static final int CHAR_MAX        = 19;
    public static final int CHAR_ALPHA      = 20;
    
    /*
        Method for check if the string is a integer number
    */
    private static boolean isNumber(String line){
        try{
            Integer.parseInt(line);
            return true;
        }catch (NumberFormatException x){
            return false;
        }
    }
    /*
        Method for check if the number is negative
    */
    private static boolean isNegative(String line){
        return line.charAt(0) == '-';
    }
    /*
        Methos for check if the string is a integer number
    */
    private static boolean isInteger(String line){
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '.')
                return false;
        }
        return true;
    }
    /*
        Method for check if the string is alphanumeric
    */
    private static boolean isAlphanumeric(String line){
        Pattern patron = Pattern.compile("[^A-Za-z_0-9]");
        Matcher encaja = patron.matcher(line);
        if(encaja.find()){//return "The name is not alphabetic";
            return false;
        }
        else 
            return true;
    }
    /*
        Method for check if the string is alphabetic
    */
    private static boolean isAlphabetic(String line){
        Pattern patron = Pattern.compile("[^A-Za-z]");
        Matcher encaja = patron.matcher(line);
        if(encaja.find()){//return "The name is not alphabetic";
            return false;
        }
        else 
            return true;
    }
    private static boolean mix(String line){
        return (line.charAt(0) == 'd');
    }
    private static boolean isAlphabeticAux(String line){
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == '-' )
                return false;
        }
        return true;
    } 
    /*
        Method for check if the length of the string is the correct
    */
    private static boolean isLength(String line){
        return (line.length() <= 50 );
    }
    /*
        Method that checks if the string is the correct input
    */
    public int checkArtist(String line){
        if(line == null)
            return 0;
        String[] totalArt = line.split(",");
        int size = totalArt.length;
        if(size == 1){
            if(totalArt[0].charAt(0) == 'N'){
                return 5;
            }
            else
                return 10;
        }
        else if(size < 10 ){
            if(size < 3)
                return 3;
            else 
                return 2;
        }
        else if(size >= 10 && size <= 20){
            if(size % 2 != 0)
                return 11;
            if(!isLength(totalArt[0]))
                return 19;
            if(isNumber(totalArt[0]))
                return  8;
            if(!isAlphanumeric(totalArt[6]) && isAlphanumeric(totalArt[2]))
                return 20;
            if(mix(totalArt[totalArt.length-1]))
                return 7;
               for(int i = 0; i < size; i++){
                    if(isNumber(totalArt[i]) == false ){
                        if(isAlphabeticAux(totalArt[i]) == false)
                            return 9;
                    }
                }
           //Check position
           String[] pos = new String[size/2];
           int j = 0;
           for(int i = 0; i < size; i++){
               if(i % 2 != 0){
                   pos[j] = totalArt[i];
                   j++;
               }
           }
           for(int i = 0; i < size/2; i++){
                if(isNegative(pos[i]))
                    return 18;
           }
           for(int i = 0; i < size/2; i++){
               if(isInteger(pos[i]) == false)
                   return 17;
           }
           boolean allAlpha = false;
            for(int i = 0; i < size; i++){
                if(i % 2 != 0){
                    if(isNumber(totalArt[i]))
                        allAlpha = true;
                    else
                        allAlpha = false;
                }
            }
           if(!allAlpha){
               return 6;
           }
           //Convert string to integers
           int posInt[] = new int[size/2];
           for(int i = 0; i < size/2; i++ ){
               posInt[i] = Integer.parseInt(pos[i]);
           }
           for(int i = 0; i < size/2; i++){
               for(int k = 0; k < size/2-1; k++){
                   if(i != k){ 
                        if(posInt[i] == posInt[k])
                            return 16;
                   }
               }
           }
           boolean correctOrder = true;
           for(int i = 0; i < posInt.length-1; i++){
               int aux = posInt[i+1];
               aux--;
               if(posInt[i] != aux)
                    correctOrder = false;
           }
           if(correctOrder)
               return 13;
           for(int i = 0; i < posInt.length-1; i++){
                int a = posInt[i];
                int b = posInt[i+1];
                b = b + 2;
                if(a == b)
                    return 15;
            }
           if(posInt[0] < posInt[posInt.length-1])
               return 12;
           if(posInt[0] > posInt[posInt.length-1] && posInt[0] < posInt[posInt.length-2])
               return 14;
        }
        else if(size > 20){
            return 4;
        }
 
        return 1;
    }
    public String readCase(int casse){
        switch (casse){
            case CORRECT://1
                return "Your input is correct.";
            case LESS_INP://2
                return "You must enter at least 5 inputs.";
            case LESS_ART://3
                return "You must enter at least 5 artist.";
            case MAX_INP://4
                return "You must enter just 10 artist.";
            case COMB_LENG://5
                return "You must enter at least 5 artist and the name is alphabetic.";
            case INP_FORMAT://6
                return "The name has to has a number like position.";
            case INP_ORDER://7
                return "The order is name and then position, you cannot mix.";
            case POSITION://8
                return "The name has to be first, and then the number.";
            case FORMAT_ORDER://9
                return "The name has to be alphanumeric and following by an integer.";
            case FORMAT_SEP://10
                return "You must separate your string between comas";
            case INP_PAIR://11
                return "You must enter a position for each artist.";
            case INT_ORDER://12
                return "The number has to has a decreasing order.";
            case INT_ORDERR://13
                return "You must enter in deacreaing order.";
            case INT_ORDER_CON://14
                return "The numbers has to be in decreasing order and continuos.";
            case INT_ORDER_CONT://15
                return "The position has to be decreasing order continous.";
            case INT_REPEAT://16
                return "You cannot repeat the number.";
            case INT_FLOAT://17
                return "The numbers have to be integers.";
            case INT_NEGATIVE://18
                return "You cannot enter negative numbers.";
            case CHAR_MAX://19
                return "The first name has to be a maximum of 50 characters.";
            case CHAR_ALPHA://20
                return "The name must be alphanumeric.";
            default:
                return "Default case.";
        }
    }
}
