import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
 
public class Frame extends JFrame implements ActionListener {
 
	JLabel lShowResultsJumpers,lShowResultsSprinters,lShowResultsLDRunners,ltext,lTextJumpers,lTextSprinters,lTextLDRunners;
    table g;

 	public Frame() {
		setSize(500,700);
		setTitle("Results in competition");
		setLayout(null);

		ltext = new JLabel("to simulate competition and get results click the button below");
		ltext.setFont(new Font("Cambria",Font.PLAIN,15));
		ltext.setForeground(new Color(0,0,190));
		ltext.setBounds(60,20,400,20);
		add(ltext);

		JButton button = new JButton("click");
		button.setBounds(100,50,300,40);
		button.setFont(new Font("Cambria",Font.BOLD,15));
		add(button);
		button.addActionListener(this);

		lTextJumpers = new JLabel();
		lTextJumpers.setBounds(50,150,400,20);
		lTextJumpers.setForeground(new Color(190,0,100));
		lTextJumpers.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextJumpers);

		lShowResultsJumpers = new JLabel();
		lShowResultsJumpers.setBounds(50,170,400,20);
		lShowResultsJumpers.setForeground(new Color(190,0,100));
		lShowResultsJumpers.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsJumpers);

		lTextSprinters = new JLabel();
		lTextSprinters.setBounds(50,290,400,20);
		lTextSprinters.setForeground(new Color(190,0,100));
		lTextSprinters.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextSprinters);

		lShowResultsSprinters = new JLabel();
		lShowResultsSprinters.setBounds(50,310,400,20);
		lShowResultsSprinters.setForeground(new Color(190,0,100));
		lShowResultsSprinters.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsSprinters);

		lTextLDRunners = new JLabel();
		lTextLDRunners.setBounds(50,430,400,20);
		lTextLDRunners.setForeground(new Color(190,0,100));
		lTextLDRunners.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextLDRunners);

		lShowResultsLDRunners = new JLabel();
		lShowResultsLDRunners.setBounds(50,450,400,20);
		lShowResultsLDRunners.setForeground(new Color(190,0,100));
		lShowResultsLDRunners.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsLDRunners);

        // g= new table();
        // add(g);
		
	}
	public static void main(String[] args){
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
 	@Override
	public void actionPerformed(ActionEvent e){
	lTextJumpers.setText("SCOREBOARD - JUMPERS: ");
	lShowResultsJumpers.setText("-> wyniki do sciagniecia od jumpersow <-");//rzutowanie .toString()
	lTextSprinters.setText("SCOREBOARD - SPRINTERS: ");
	lShowResultsSprinters.setText("-> wyniki do sciagniecia od sprinterow <-");
	lTextLDRunners.setText("SCOREBOARD - LONG DISTANCE RUNNERS: ");
	lShowResultsLDRunners.setText("-> wyniki do sciagniecia od skoczkow <-");
	}
}