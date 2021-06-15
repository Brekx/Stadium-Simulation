package Utilities;

import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceManager {

  protected static InputStream getNames(){
    return getFileFromResourceAsStream("names.txt");
  }

  protected static ImageIcon getStadion() {
    return loadIcon("stadion.png");
  }
  protected static ImageIcon getLudzik() {
    return loadIcon("ludzik.png");
  }
  protected static ImageIcon getCloakroom() {
    return loadIcon("cloakroom.png");
  }
  protected static ImageIcon getSandpit() {
    return loadIcon("sandpit.png");
  }
  protected static ImageIcon getTrack() {
    return loadIcon("track.png");
  }
  protected static ImageIcon getTabela_wynikow() {
    return loadIcon("tabela_wynikow.jpg");
  }

  private static ImageIcon loadIcon(String filename) {
    try {
      return new ImageIcon(ImageIO.read(getFileFromResourceAsStream(filename)));
    } catch (Exception e) {
      throw new Error(e.toString());
    }
  }

  private static InputStream getFileFromResourceAsStream(String fileName) {

    // The class loader that loaded the class
    ClassLoader classLoader = ResourceManager.class.getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    // the stream holding the file content
    if (inputStream == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return inputStream;
    }

  }
}
