package Utilities;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ResourceManagerTest {
  @Test public void resourcesAvailable() {
    assertNotNull(ResourceManager.getLudzik());
  }
}
