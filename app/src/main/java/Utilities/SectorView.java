package Utilities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.ImageIcon; 
import javax.swing.Timer;

/**Class representing sector view */
public class SectorView {
  private ImageIcon ludzik = new ImageIcon(new ImageIcon("app/src/main/resources/ludzik.png").getImage().getScaledInstance(30, 70, Image.SCALE_SMOOTH)); ///< person
  private ImageIcon image; ///< image
  int current_people = 0; ///< current person
  int x; ///< variable x
  int y; ///< variable y
  int current_frame=0; ///< current frame
  SectorTypes type; ///< type
  boolean animation = false; ///< animation
  Dimension ludzik_position = new Dimension(); ///< person's position

  /**
   * Constructor
   * 
   * @param type type
   * @param x variable x
   * @param y variable y
   */
  SectorView(SectorTypes type, int x, int y){
    this.x = x;
    this.y = y;
    this.type = type;
    switch(type){
      case track:
        image = new ImageIcon(ResourceManager.getTrack().getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH));
        break;
      case cloakroom:
        image = new ImageIcon(ResourceManager.getCloakroom().getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH));
        break;
      case sandpit:
        image = new ImageIcon(ResourceManager.getSandpit().getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH));
        break;
    }
  }

  /** 
   * Drawing people on the board
   * 
   * @param g graphics
   * @param x varable x
   * @param y variable y
   * @param dx delta x
   * @param dy delta y
   * @param count count
   */
  private void drawPeople(Graphics g, int x, int y, int dx, int dy, int count){
    for(int i=0; i<count; i++)
      g.drawImage(ludzik.getImage(), x+(i*dx/count), y+(i*dy/count), null);
  }

  /** 
   * Drawing sector on board
   * 
   * @param g graphics to draw
   */
  public void drawSector(Graphics g) {
    g.drawImage(image.getImage(), (int) x-image.getIconWidth()/2, (int) y-image.getIconHeight()/2, null);
    drawPeople(g, x-100, y, 50, 0, current_people);
    if(animation){
      g.drawImage(ludzik.getImage(), ludzik_position.width, ludzik_position.height, null);
    }
  }

  /**
   * Getter of position
   * 
   * @return returns new dimension
   */
  public Dimension getPosition(){
    return new Dimension(x, y);
  }

  /** 
   * Letting people competite and animate it 
   * 
   */
  public void animate(){
    if(current_people>0){
      animation  = true;
      Timer timer = new Timer(10, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
          switch(type){
            case cloakroom:
              ludzik_position = cloakroom_path(current_frame);
              break;
            case sandpit:
              ludzik_position = sandpit_path(current_frame);
              break;
            case track:
              ludzik_position = track_path(current_frame);
              break;
          }
          current_frame++;
          if(current_frame>100){
            current_frame = 0;
            animation = false;
            ((Timer)e.getSource()).stop();
          }
        }
      });
      timer.start();
      while(timer.isRunning())
        continue;
    }
  }

  /** 
   * Cloakroom animation path
   * 
   * @param frame frame
   * @return returns new dimension
   */
  private Dimension cloakroom_path(int frame){
    if(frame<33)
      return new Dimension(x-65+3*frame, y-20-frame);
    if(frame<66)
      return new Dimension(x+35, y-50+(frame-33));
    return new Dimension(x+35-3*(frame-66), y-20-(frame-66));
  }

  /** 
   * Sandpit animation path
   * 
   * @param frame frame
   * @return returns new dimension
   */
  private Dimension sandpit_path(int frame){
    if(frame<33)
      return new Dimension(x-81+2*frame, y-68+frame);
    if(frame<66)
      return new Dimension(x-15+(frame-33)/2, y-35-(frame-33)/2);
    return new Dimension(x+(frame-66)/2, y-50+(frame-66)/2);
  }

  /** 
   * Track animation path
   * 
   * @param frame frame
   * @return returns new dimension
   */
  private Dimension track_path(int frame){
    return new Dimension(x-100+frame, y-100+frame);
  }
}
