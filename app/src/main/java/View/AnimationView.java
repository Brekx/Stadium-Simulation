package View;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class AnimationView implements Icon{

  int local_x=0, local_y=0;

  public void moveAnimation(SectorView start, SectorView end, Graphics g, JFrame frame){
    new Timer(100, new ActionListener() {
      int current_frame = 0, dx=(end.x-start.x)/50, dy=(end.y-start.y)/50, x=start.x, y=start.y;
      ImageIcon imageIcon = new ImageIcon("ludzik.png");
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.repaint();
        g.drawImage(imageIcon.getImage(), x+current_frame*dx, y+current_frame*dy, null);
        current_frame++;
        if(current_frame>50)
          ((Timer)e.getSource()).stop();
      }
    }).start();
  }

  AnimationView(JFrame frame, Dimension start_dimension, Dimension end_dimension){
    new Timer(100, new ActionListener(){
      int current_frame=0, dx=(int) (end_dimension.getWidth()-start_dimension.getWidth())/50,
        dy=(int) (end_dimension.getHeight()-start_dimension.getHeight())/50;

      @Override
      public void actionPerformed(ActionEvent e) {
        local_x+=dx;
        local_y+=dy;
        current_frame++;
        frame.revalidate();
        frame.repaint();
        if(current_frame>50)
          ((Timer)e.getSource()).stop();
      }
    }).start();
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    ImageIcon imageIcon = new ImageIcon("ludzik.png");
    g.drawImage(imageIcon.getImage(), x+local_x, y+local_y, null);
  }

  @Override
  public int getIconWidth() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  public int getIconHeight() {
    // TODO Auto-generated method stub
    return 100;
  }
}
