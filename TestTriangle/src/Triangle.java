/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanManuel
 */

public class Triangle {
    
    public static final int EMPTY =       -1;
    public static final int SPECIAL =     -2;
    public static final int NEGATIVE =    -3;
    public static final int ZERO =        -4;
    public static final int INVALID =      0;
    public static final int EQUILATERAL =  +1;
    public static final int ISOSCELES =    +2;
    public static final int SCALENE =      +3;
    
    
    private static boolean isNumber (String line){
        try{
            Integer.parseInt(line);
            return true;
        }catch (NumberFormatException x){
            return false;
        }
    }
    
    public String zero (String a, String b, String c){
        String ans = "";
        if(a.charAt(0) == '0')
            ans = "Wrong input! You put a zero in the first option, you have to write an integer number.";
        else if (b.charAt(0) == '0')
            ans = "Wrong input! You put a zero in the second option, you have to write an integer number.";
        else if (c.charAt(0) == '0')
            ans = "Wrong input! You put a zero in the last option, you have to write an integer number";
        else 
            ans = "";
       
        return ans;
    }
    
    public String negative (String a, String b, String c){
        String ans = "";
        if (a.charAt(0) == '-'){
            ans =  "Wrong input! You put a negative number in the first option, \nxyou have to write a positive number";
        }
        else if (b.charAt(0) == '-'){
            ans = "Wrong input! You put a negative number in the second option, you have to write a positive number.";
        }
        else if (c.charAt(0) == '-'){
            ans = "Wrong input! You put a negative number in the last option, you have to write a positive number";
        }
        else 
            ans = "";      
        
        return ans;
    }
         
    public String type (int a, int b, int c){ 
        String ans;   
        if (a == b && a == c)
            ans = "El triangulo es: Equilatero";
        else if (a == c && a != b)
            ans = "El triangulo es: Escaleno";
        else if (b == c)
            ans = "El triangulo es: Escaleno";
        else
            ans = "Isoceles";
        
        return ans;    
    }
            
    public String checkTriangle(String a, String b, String c){ 
       String ans = "";
       boolean aT = isNumber(a);
       boolean bT = isNumber(b);
       boolean cT = isNumber(c);
       
       if (aT){
           if (bT){
               if (cT){
                   ans = zero (a,b,c);
                   if(ans.length() == 0){
                       ans = negative (a,b,c);
                   }
                   if(ans.length() == 1){
                       int aN = Integer.parseInt (a);
                       int bN = Integer.parseInt (b);
                       int cN = Integer.parseInt (c);
                        ans = type(aN,bN,cN);
                   }
               }
               else
                   ans = "Wrong input! The last option is not a number.";
           }
           else if (cT){
               ans = "Wrong input! The second option is not a number.";
           }
           else{
               ans = "Wrong input! Just the first option is a number.";
           }    
       }
       else if (bT){
           if(cT)
               ans = "Wrong input! The first option is not a number.";
           else
               ans = "Wrong input! Just the second options is a number";
       }
       else if (cT){
           ans = "Wrong input! Just the last option is a number.";
       }
       else{
           ans = "Wrong input! Any option is number.";
       }
           
        
        return ans;
    }
    public String readType(int type){
        // Returns the input for jScrollPanelResult.
        switch (type){
            case EMPTY:
                return "You can not enter empty spaces.";
            case SPECIAL:
                return "You can not enter especial characters";
            case NEGATIVE:
                return "You can not enter negative numbers";
            case ZERO:
                return "You can no enter zero values";
            case EQUILATERAL:
                return "El triangulo es equilatero.";
            case ISOSCELES:
                return "El triangulo es isosceles.";
            case SCALENE:
                return "El triangulo es escaleno.";
            default:
                return "Error";
        }
    }
}
