package Utilities;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ResourceManagerTest {
  @Test public void isLudzik() {
    assertNotNull(ResourceManager.getLudzik());
  }
  @Test public void isCloakroom() {
    assertNotNull(ResourceManager.getCloakroom());
  }
  @Test public void isTrack() {
    assertNotNull(ResourceManager.getTrack());
  }
  @Test public void isSandpit() {
    assertNotNull(ResourceManager.getSandpit());
  }
  @Test public void isStadion() {
    assertNotNull(ResourceManager.getStadion());
  }
  @Test public void areNames() {
    assertNotNull(ResourceManager.getNames());
  }
}
