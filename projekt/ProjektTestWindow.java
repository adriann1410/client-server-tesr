package projekt;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProjektTestWindow extends JFrame{

	private static final long serialVersionUID = -3283858661450989056L;
	String[] pytania = new String[4];
	
	ProjektTestWindow(String[] pytania){
		super("TEST");
		this.pytania = pytania;
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setLayout(new GridLayout(0,1));
		JLabel pyt1 = new JLabel(pytania[0],JLabel.CENTER );
		add(pyt1);
		JLabel pyt2 = new JLabel(pytania[1],JLabel.CENTER );
		add(pyt2);
		JLabel pyt3 = new JLabel(pytania[2],JLabel.CENTER );
		add(pyt3);
		JLabel pyt4 = new JLabel(pytania[3],JLabel.CENTER );
		add(pyt4);
		
		
		JPanel buttonsPanel = new JPanel();
	}
}
