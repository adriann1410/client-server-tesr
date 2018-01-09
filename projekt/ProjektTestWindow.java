package projekt;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProjektTestWindow extends JFrame{

	private static final long serialVersionUID = -3283858661450989056L;
	Pytanie pyt1;
	
	ProjektTestWindow(Pytanie pytanie){
		super("TEST");
		this.pyt1 = pytanie;

		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
//		JPanel pytpanel1= new JPanel();
//		JPanel odppanel1 = new JPanel(new GridLayout(1,4));
		
		
		JLabel pyta0 = new JLabel((String)pyt1.pytanie ,JLabel.CENTER );
		add(pyta0);
//		
//		JCheckBox odp0 = new JCheckBox((String)pyt1.odpowiedzi[0]);
//		JCheckBox odp1 = new JCheckBox((String)pyt1.odpowiedzi[1]);
//		JCheckBox odp2 = new JCheckBox((String)pyt1.odpowiedzi[2]);
//		JCheckBox odp3 = new JCheckBox((String)pyt1.odpowiedzi[3]);
//		
//		odppanel1.add(odp0);
//		odppanel1.add(odp1);
//		odppanel1.add(odp2);
//		odppanel1.add(odp3);
//		
		JPanel buttonsPanel = new JPanel();
	}
}
