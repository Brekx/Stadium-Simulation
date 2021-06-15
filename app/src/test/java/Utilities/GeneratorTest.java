package Utilities;

import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

public class GeneratorTest {
  @Test public void generatorNotNull() {
    Random random = new Random();
    Generator generator = new Generator(random.nextInt(100));
    assertNotNull(generator.generateCompetitors(random));
  }
}
