import junit.framework.TestCase;

/**
 *
 * @author drag
 */
public class TestJavaTriangle extends TestCase{
    
    // Atributos
    Triangle tri = new Triangle();
    
    // Constructor
    public TestJavaTriangle(String name) {
        super(name);
    }
    
    // Metodos
    public void testNullInput(){
        try {
            tri.checkTriangle(null, null, null);
            fail("Should throw a NullPointerException.");
        } catch (NullPointerException npe){
            assertTrue(true);
        }
    }
    
    public void testEmptyInput(){
        assertEquals(Triangle.EMPTY, tri.checkTriangle("", "55", ""));
    }
    
    public void testSpecialInput(){
        assertEquals(Triangle.SPECIAL, tri.checkTriangle("/25r", "58", "g60*"));
    }
    
    public void testNegativeInput(){
        assertEquals(Triangle.NEGATIVE, tri.checkTriangle("59", "-8", "54"));
    }
    
    public void testZeroInput(){
        assertEquals(Triangle.zero, tri.checkTriangle("0", "59", "65"));
    }
    
    public void testEquilateralTriangle(){
        assertEquals(Triangle.EQUILATERAL, tri.checkTriangle("25", "25", "25"));
    }
    
    public void testIsoscelesTriangle(){
        assertEquals(Triangle.ISOSCELES, tri.checkTriangle("31", "57", "31"));
    }
    
    public void testScaleneTriangle(){
        assertEquals(Triangle.SCALENE, tri.checkTriangle("82", "44", "79"));
    }
    
    public void testErrorHierarchyEmpty(){
        assertEquals(Triangle.EMPTY, tri.checkTriangle("", "8df", "-72"));
    }
    
    public void testErrorHierarchySpecial(){
        assertEquals(Triangle.SPECIAL, tri.checkTriangle("0", "d85", "-89"));
    }
    
    public void testErrorHierarchyNegative(){
        assertEquals(Triangle.NEGATIVE, tri.checkTriangle("0", "0", "-58"));
    }
    
    public void testErrorHierarchyZero(){
        assertEquals(Triangle.ZERO, tri.checkTriangle("81", "56", "0"));
    }
    
    public void testMaxIntegerEquilateral(){
        assertEquals(Triangle.EQUILATERAL, tri.checkTriangle(
                String.valueOf(Integer.MAX_VALUE),
                String.valueOf(Integer.MAX_VALUE),
                String.valueOf(Integer.MAX_VALUE)));
    }
    
    public void testMaxIntegerIsosceles(){
        assertEquals(Triangle.ISOSCELES, tri.checkTriangle("1",
                String.valueOf(Integer.MAX_VALUE),
                String.valueOf(Integer.MAX_VALUE)));
    }
    
    public void testMaxIntegerOverflow(){
        assertEquals(Triangle.NEGATIVE, tri.checkTriangle("2005970590", "1474869287",
                String.valueOf(Integer.MAX_VALUE+5000)));
    }
}
