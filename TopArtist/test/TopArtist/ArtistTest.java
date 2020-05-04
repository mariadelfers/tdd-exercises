/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TopArtist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import junit.framework.TestCase;

/**
 *
 * @author Fer Enriquez'
 */
public class ArtistTest extends TestCase {
    
    //Atributes
    Artist art = new Artist();
    
    //Constructor
    public ArtistTest(String line){
        super(line);
    }
    
    //Methods
    public void testCorrect(){
        assertEquals(Artist.CORRECT, art.checkArtist("Queen,10,Doors,9,Nirvana,8,Metallica,7,Aerosmith,6"));
    }
    public void testLengthMin(){
        assertEquals(Artist.LESS_INP, art.checkArtist("Queen,10,Doors,9,Nirvana,8,Metallica,7"));
    }
    public void testLengthMinn(){
        assertEquals(Artist.LESS_ART, art.checkArtist("Dooooooooooooooooooooooooooooooooors,1"));
    }
    public void testLengthMax(){
        assertEquals(Artist.MAX_INP, art.checkArtist("ab,20,ac,19,ad,18,ae,17,af,16,ag,15,ah,14,ai,13,aj,12,ak,11,a1,12"));
    }
    public void testComLeng(){
        assertEquals(Artist.COMB_LENG, art.checkArtist("Nir/vana/10/Nir/vana/10/Nirvana"));
    }
    public void testInpFormat(){
        assertEquals(Artist.INP_FORMAT, art.checkArtist("a1,a,b1,b,c1,c,d1,d,e1,e,f1,e"));
    }
    public void testInpOrder(){
        assertEquals(Artist.INP_ORDER, art.checkArtist("a,1,a,2,3,a,4,b,5,c,6,d"));
    }
    public void testPosition(){
        assertEquals(Artist.POSITION, art.checkArtist("10,aa,9,ab,8,ac,7,ad,6,af,5,a"));
    }
    public void testFormatOrder(){
        assertEquals(Artist.FORMAT_ORDER, art.checkArtist("aa-10,aa-9,aa-8,aa-7,aa-6,aa-5,aa-4,aa-3,aa-2,aa-1"));
    }
    public void testFormatSep(){
        assertEquals(Artist.FORMAT_SEP, art.checkArtist("aa/10ab/9/ac/8/ad/7/af/6/ag/5"));
    }
    public void testInpPair(){
        assertEquals(Artist.INP_PAIR, art.checkArtist("10a,9,9a,8,8a,7,7a,6,6a,5,aerosmith"));
    }
    public void testIntOrder(){
        assertEquals(Artist.INT_ORDER, art.checkArtist("ab,10,ac,9,ad,18,ae,20,af,21,ag,29"));
    }
    public void testIntOrderr(){
        assertEquals(Artist.INT_ORDERR, art.checkArtist("Queen,6,Door,7,Nirvana,8,Metallica,9,Aersmith,10"));
    }
    public void testIntOrderCon(){
        assertEquals(Artist.INT_ORDER_CON, art.checkArtist("aaaaaaaaaaaaaaaaaaaa,20,b,32,c,1,d,101,e,5"));
    }
    public void testIntOrderCont(){
        assertEquals(Artist.INT_ORDER_CONT, art.checkArtist("Aerosmith,10,9,8,7,6,5,4,3,2,1,0"));
    }
    public void testIntRepeat(){
        assertEquals(Artist.INT_REPEAT, art.checkArtist("Queen,10,Doors,10,Nirvana,9,Metallica,8,Aerosmith,7"));
    }
    public void testIntFloat(){
        assertEquals(Artist.INT_FLOAT, art.checkArtist("Queen,1.9,Doors,1.8,Nirvana,1.7,Metallica,1.6,Aerosmith,1.5"));
    }
    public void testIntNegative(){
        assertEquals(Artist.INT_NEGATIVE, art.checkArtist("a,-5,b,-4,c,-3,d,-2,e,-1,f,-1"));
    }
    public void testCharMax(){
        assertEquals(Artist.CHAR_MAX, art.checkArtist("Qeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen,10,Doors,9,Niv,8,Met,7,GR,6"));
    }
    public void testCharAlpha(){
        assertEquals(Artist.CHAR_ALPHA, art.checkArtist("Que-een,10,Doors,9,Nirvana,8,Me*lica,7,Aerosmith,6"));
    }
}
