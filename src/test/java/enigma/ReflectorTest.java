package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReflectorTest {

    Reflector reflectorTest = Reflector.reflectorFactory("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T");
	
        @Test
	public void eflector_convertForward_test() {
            int indexTest = 5;
            int test = reflectorTest.convertForward(indexTest);
            int expected = 18;
            assertEquals(expected,test);
	}

}
