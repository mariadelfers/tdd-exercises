/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Fer Enriquez'
 */
public class Drink {
    
    private static boolean isNumber (String line){
        try{
            Integer.parseInt(line);
            return true;
        }catch (NumberFormatException x){
            return false;
        }
    }
    
    public String correctInput (boolean line){
        if(line){
            return "T";
        }
        else
            return "F";
    }
    
    public String checkInput (String line){
        boolean result = false;
        
        if(line.length() < 2){
            //result = "The name is incorrect";
            return correctInput (result);
        }
        //Separado por comas
        String[] arrLine = line.split(",",-1);
       
        result = checkName(arrLine[0]);
        if(!result){
            return correctInput(result);
        }
        
        result = checkSize(arrLine);
        
        return correctInput(result);
    }
    
    public boolean checkName (String name){
        if (name.length() < 2 || name.length() > 48){
            //return "You must enter a name less tha 48 characters";
            return false;
        }
        
        Pattern patron = Pattern.compile("[^A-Za-z ]");
        Matcher encaja = patron.matcher(name);
        if(encaja.find()){
            //return "The name is not alphabetic";
            return false;
        }
        
        return true;
    }
    
    public boolean checkSize (String []arrSize){
        for(int i = 1; i < 5; i++){
            if(arrSize[i] == null || arrSize[i] == "-1"){
                arrSize[i] = "1000000000";
            }
        }
        boolean aSize = isNumber(arrSize[1]);
        boolean bSize = isNumber(arrSize[2]);
        boolean cSize = isNumber(arrSize[3]);
        boolean dSize = isNumber(arrSize[4]);
        
        if(aSize){
            if(bSize){
                if(cSize){
                    if(dSize){
                        int[] arrInt = new int[5];
                        arrInt[0] = Integer.parseInt (arrSize[1]);
                        arrInt[1] = Integer.parseInt (arrSize[2]);
                        arrInt[2] = Integer.parseInt (arrSize[3]);
                        arrInt[3] = Integer.parseInt (arrSize[4]);
                        arrInt[4] = 1000000000;
                        
                        for(int i = 1; i < 4; i++){
                            if(arrInt[i] >= 1 || arrInt[i] >= 49){
                                if(arrInt[i] > arrInt[i+1]){
                                    return false;
                                }
                            }
                            else if(arrInt[i] != 1000000000){
                                return false;
                            }
                        }
                        
                        return true;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }
}
