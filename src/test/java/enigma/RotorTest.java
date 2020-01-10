package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

    Rotor rotorTest = Rotor.rotorFactory("E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
        
    @Test
    public void rotor_convertForward_test(){
        int indexTest = 5;
        int test = rotorTest.convertForward(indexTest);
        int expected = 6;
        assertEquals(expected,test);
    }   
    
    @Test
    public void rotor_convertBackward_test(){
        int indexTest = 5;
        int test = rotorTest.convertForward(indexTest);
        int expected = 6;
        assertEquals(expected,test);
    } 
        
        
    @Test
    public void rotor_advance_test() {
        int position = rotorTest.getPosition();
        rotorTest.advance();
        assertEquals(position+1, rotorTest.getPosition());
    }
    
    @Test
    public void rotor_advance_testLimit() {
        rotorTest.setPosition(25);
        rotorTest.advance();
        assertEquals(0, rotorTest.getPosition());
    }

}
