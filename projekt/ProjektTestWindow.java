package projekt;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProjektTestWindow extends JFrame{

	private static final long serialVersionUID = -3283858661450989056L;
	Pytanie[] pyt1;
	
	ProjektTestWindow(Pytanie[] pytanie){
		super("TEST");
		this.pyt1 = pytanie;

		setSize(500,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		JPanel pytpanel1= new JPanel(new GridLayout());
		JPanel odppanel1 = new JPanel(new GridLayout(1,4));
		
// Pytanie 1		
		JLabel pyta0 = new JLabel((String)pyt1[0].pytanie ,JLabel.CENTER );
		pytpanel1.add(pyta0);		
		JCheckBox odp0 = new JCheckBox((String)pyt1[0].odpowiedzi[0]);
		JCheckBox odp1 = new JCheckBox((String)pyt1[0].odpowiedzi[1]);
		JCheckBox odp2 = new JCheckBox((String)pyt1[0].odpowiedzi[2]);
		JCheckBox odp3 = new JCheckBox((String)pyt1[0].odpowiedzi[3]);		
		odppanel1.add(odp0);
		odppanel1.add(odp1);
		odppanel1.add(odp2);
		odppanel1.add(odp3);		
		
		add(pytpanel1);
		add(odppanel1);

//Pytanie 2
		JPanel pytpanel2= new JPanel(new GridLayout());
		JPanel odppanel2 = new JPanel(new GridLayout(1,4));
		JLabel pyta1 = new JLabel((String)pyt1[1].pytanie ,JLabel.CENTER );
		pytpanel2.add(pyta1);		
		JCheckBox odp01 = new JCheckBox((String)pyt1[1].odpowiedzi[0]);
		JCheckBox odp11 = new JCheckBox((String)pyt1[1].odpowiedzi[1]);
		JCheckBox odp21 = new JCheckBox((String)pyt1[1].odpowiedzi[2]);
		JCheckBox odp31 = new JCheckBox((String)pyt1[1].odpowiedzi[3]);		
		odppanel2.add(odp01);
		odppanel2.add(odp11);
		odppanel2.add(odp21);
		odppanel2.add(odp31);		
		
		add(pytpanel2);
		add(odppanel2);
		
//Pytanie 3
		JPanel pytpanel3= new JPanel(new GridLayout());
		JPanel odppanel3 = new JPanel(new GridLayout(1,4));
		JLabel pyta2 = new JLabel((String)pyt1[2].pytanie ,JLabel.CENTER );
		pytpanel3.add(pyta2);		
		JCheckBox odp02 = new JCheckBox((String)pyt1[2].odpowiedzi[0]);
		JCheckBox odp12 = new JCheckBox((String)pyt1[2].odpowiedzi[1]);
		JCheckBox odp22 = new JCheckBox((String)pyt1[2].odpowiedzi[2]);
		JCheckBox odp32 = new JCheckBox((String)pyt1[2].odpowiedzi[3]);		
		odppanel3.add(odp02);
		odppanel3.add(odp12);
		odppanel3.add(odp22);
		odppanel3.add(odp32);		
		
		add(pytpanel3);
		add(odppanel3);
		
//Pytanie 4
		
		JPanel pytpanel4= new JPanel(new GridLayout());
		JPanel odppanel4 = new JPanel(new GridLayout(1,4));
		JLabel pyta3 = new JLabel((String)pyt1[3].pytanie ,JLabel.CENTER );
		pytpanel4.add(pyta3);		
		JCheckBox odp03 = new JCheckBox((String)pyt1[3].odpowiedzi[0]);
		JCheckBox odp13 = new JCheckBox((String)pyt1[3].odpowiedzi[1]);
		JCheckBox odp23 = new JCheckBox((String)pyt1[3].odpowiedzi[2]);
		JCheckBox odp33 = new JCheckBox((String)pyt1[3].odpowiedzi[3]);		
		odppanel4.add(odp03);
		odppanel4.add(odp13);
		odppanel4.add(odp23);
		odppanel4.add(odp33);		
		
		add(pytpanel4);
		add(odppanel4);
		
		setLayout(new GridLayout(9,0));
		
		
		
	}
}
