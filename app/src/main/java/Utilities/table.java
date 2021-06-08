
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

public class table extends JPanel {
    Image img;
    table(){
        img = new ImageIcon("tabela_wynikow.jpg").getImage();
    }

    public void paint(Graphics g){
        g.drawImage(img,0,0,null);
    }
}
