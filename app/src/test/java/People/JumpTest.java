package People;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class JumpTest {
    @Test public void jumpTest(){
        Jumper classUnderTest = new Jumper("Adam", 15, 20, 3);
        Random random = new Random();
        assertEquals(classUnderTest.jump(random.nextInt(20)), 0);
    }
    
}
