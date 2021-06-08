package Utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
 
public class Frame extends JFrame implements ActionListener {
 
	JLabel lShowResultsJumpers,lShowResultsSprinters,lShowResultsLDRunners,ltext,lTextJumpers,lTextSprinters,lTextLDRunners;
	FlowControl flowControl;
    

 	public Frame(Map <CompetitorsTypes, String> scoreboard) {
		setSize(700,820);
		setTitle("Results in competition");
		setLayout(null);

		ltext = new JLabel("Oj jezu takie są wyniki");
		ltext.setFont(new Font("Cambria",Font.PLAIN,15));
		ltext.setForeground(new Color(0,0,0));
		ltext.setBounds(150,40,400,20);
		add(ltext);

		JButton button = new JButton("click");
		button.setBounds(190,80,300,40);
		button.setFont(new Font("Cambria",Font.BOLD,15));
		add(button);
		button.addActionListener(this);

		lTextJumpers = new JLabel();
		lTextJumpers.setBounds(120,300,400,20);
		lTextJumpers.setForeground(new Color(190,0,100));
		lTextJumpers.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextJumpers);

		lShowResultsJumpers = new JLabel();
		lShowResultsJumpers.setBounds(120,320,400,100);
		lShowResultsJumpers.setForeground(new Color(190,0,100));
		lShowResultsJumpers.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsJumpers);

		lTextSprinters = new JLabel();
		lTextSprinters.setBounds(120,450,400,20);
		lTextSprinters.setForeground(new Color(190,0,100));
		lTextSprinters.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextSprinters);

		lShowResultsSprinters = new JLabel();
		lShowResultsSprinters.setBounds(120,470,400,100);
		lShowResultsSprinters.setForeground(new Color(190,0,100));
		lShowResultsSprinters.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsSprinters);

		lTextLDRunners = new JLabel();
		lTextLDRunners.setBounds(120,590,400,20);
		lTextLDRunners.setForeground(new Color(190,0,100));
		lTextLDRunners.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lTextLDRunners);

		lShowResultsLDRunners = new JLabel();
		lShowResultsLDRunners.setBounds(120,610,400,100);
		lShowResultsLDRunners.setForeground(new Color(190,0,100));
		lShowResultsLDRunners.setFont(new Font("Bahnschrift",Font.PLAIN,15));
		add(lShowResultsLDRunners);   

		lTextJumpers.setText("CATEGORY:  JUMPING: ");
		lShowResultsJumpers.setText(scoreboard.get(CompetitorsTypes.jumper));//rzutowanie .toString()
		lTextSprinters.setText("CATEGORY:  SPRINT: ");
		lShowResultsSprinters.setText(scoreboard.get(CompetitorsTypes.sprinter));
		lTextLDRunners.setText("CATEGORY:  LONG DISTANCE RUN: ");
		lShowResultsLDRunners.setText(scoreboard.get(CompetitorsTypes.long_distance_runner));
		
	}

	public static void view(FlowControl flowControl){
		Frame frame = new Frame(flowControl.getResults());
		ImageIcon icon = new ImageIcon("app/src/main/resources/tabela_wynikow.jpg");
		JLabel label = new JLabel(icon);
		label.setBounds(0,0,700,800);
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

 	@Override
	public void actionPerformed(ActionEvent e){
		lTextJumpers.setText("CATEGORY:  JUMPING: ");
		lShowResultsJumpers.setText("-> wyniki do sciagniecia od jumpersow <-");//rzutowanie .toString()
		lTextSprinters.setText("CATEGORY:  SPRINT: ");
		lShowResultsSprinters.setText("-> wyniki do sciagniecia od sprinterow <-");
		lTextLDRunners.setText("CATEGORY:  LONG DISTANCE RUN: ");
		lShowResultsLDRunners.setText("-> wyniki do sciagniecia od skoczkow <-");
	}
}
