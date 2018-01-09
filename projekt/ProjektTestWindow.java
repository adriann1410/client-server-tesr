package projekt;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProjektTestWindow extends JFrame{

	private static final long serialVersionUID = -3283858661450989056L;
	Pytanie[] pyt1;
	String odp;
	ProjektTestWindow(){
		super("TEST");
		ProjektClient klient = new ProjektClient();

		setSize(500,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		JPanel pytpanel1= new JPanel(new GridLayout());
		JPanel odppanel1 = new JPanel(new GridLayout(1,4));
		
		pyt1 = klient.pobierzDane();
		
// Pytanie 1		
		JLabel pyta0 = new JLabel("1. " +(String)pyt1[0].pytanie ,JLabel.CENTER );
		pytpanel1.add(pyta0);		
		JCheckBox odp0 = new JCheckBox("1."+(String)pyt1[0].odpowiedzi[0]);
		JCheckBox odp1 = new JCheckBox("2."+(String)pyt1[0].odpowiedzi[1]);
		JCheckBox odp2 = new JCheckBox("3."+(String)pyt1[0].odpowiedzi[2]);
		JCheckBox odp3 = new JCheckBox("4."+(String)pyt1[0].odpowiedzi[3]);		
		odppanel1.add(odp0);
		odppanel1.add(odp1);
		odppanel1.add(odp2);
		odppanel1.add(odp3);		
		
		add(pytpanel1);
		add(odppanel1);

//Pytanie 2
		JPanel pytpanel2= new JPanel(new GridLayout());
		JPanel odppanel2 = new JPanel(new GridLayout(1,4));
		JLabel pyta1 = new JLabel("2. " +(String)pyt1[1].pytanie ,JLabel.CENTER );
		pytpanel2.add(pyta1);		
		JCheckBox odp01 = new JCheckBox("1."+(String)pyt1[1].odpowiedzi[0]);
		JCheckBox odp11 = new JCheckBox("2."+(String)pyt1[1].odpowiedzi[1]);
		JCheckBox odp21 = new JCheckBox("3."+(String)pyt1[1].odpowiedzi[2]);
		JCheckBox odp31 = new JCheckBox("4."+(String)pyt1[1].odpowiedzi[3]);		
		odppanel2.add(odp01);
		odppanel2.add(odp11);
		odppanel2.add(odp21);
		odppanel2.add(odp31);		
		
		add(pytpanel2);
		add(odppanel2);
		
//Pytanie 3
		JPanel pytpanel3= new JPanel(new GridLayout());
		JPanel odppanel3 = new JPanel(new GridLayout(1,4));
		JLabel pyta2 = new JLabel("3. " +(String)pyt1[2].pytanie ,JLabel.CENTER );
		pytpanel3.add(pyta2);		
		JCheckBox odp02 = new JCheckBox("1."+(String)pyt1[2].odpowiedzi[0]);
		JCheckBox odp12 = new JCheckBox("2."+(String)pyt1[2].odpowiedzi[1]);
		JCheckBox odp22 = new JCheckBox("3."+(String)pyt1[2].odpowiedzi[2]);
		JCheckBox odp32 = new JCheckBox("4."+(String)pyt1[2].odpowiedzi[3]);		
		odppanel3.add(odp02);
		odppanel3.add(odp12);
		odppanel3.add(odp22);
		odppanel3.add(odp32);		
		
		add(pytpanel3);
		add(odppanel3);
		
//Pytanie 4
		
		JPanel pytpanel4= new JPanel(new GridLayout());
		JPanel odppanel4 = new JPanel(new GridLayout(1,4));
		JLabel pyta3 = new JLabel("4. " +(String)pyt1[3].pytanie ,JLabel.CENTER );
		pytpanel4.add(pyta3);		
		JCheckBox odp03 = new JCheckBox("1."+(String)pyt1[3].odpowiedzi[0]);
		JCheckBox odp13 = new JCheckBox("2."+(String)pyt1[3].odpowiedzi[1]);
		JCheckBox odp23 = new JCheckBox("3."+(String)pyt1[3].odpowiedzi[2]);
		JCheckBox odp33 = new JCheckBox("4."+(String)pyt1[3].odpowiedzi[3]);		
		odppanel4.add(odp03);
		odppanel4.add(odp13);
		odppanel4.add(odp23);
		odppanel4.add(odp33);		
		
		add(pytpanel4);
		add(odppanel4);
		
		
		JButton send = new JButton("Przeslij Odpowiedzi");
		add(send);
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//przesy³anie odpowiedzi na server
				String odp = new String();
				if(odp0.isSelected()){
					odp += "1";
				}
				if(odp1.isSelected()){
					odp += "2";
				}
				if(odp2.isSelected()){
					odp += "3";
				}
				if(odp3.isSelected()){
					odp += "4";
				}
				if(odp01.isSelected()){
					odp += "1";
				}
				if(odp11.isSelected()){
					odp += "2";
				}
				if(odp21.isSelected()){
					odp += "3";
				}
				if(odp31.isSelected()){
					odp += "4";
				}
				if(odp02.isSelected()){
					odp += "1";
				}
				if(odp12.isSelected()){
					odp += "2";
				}
				if(odp22.isSelected()){
					odp += "3";
				}
				if(odp32.isSelected()){
					odp += "4";
				}
				if(odp03.isSelected()){
					odp += "1";
				}
				if(odp13.isSelected()){
					odp += "2";
				}
				if(odp23.isSelected()){
					odp += "3";
				}
				if(odp33.isSelected()){
					odp += "4";
				}
				
				klient.przeslijOdp(odp);	
				
				String poprawneodp = klient.pobierzBazeOdp();
				int wynik =0;
				for(int i=0; i<4; i++){
					if(odp.charAt(i) == poprawneodp.charAt(i)){
						wynik++;
					}
				}
				
				
				
				

				
//				JPanel odppanel= new JPanel(new GridLayout());
//				JLabel wyniki = new JLabel("Uzyskany wynik: " + odp + "/4" ,JLabel.CENTER );
//				odppanel.add(wyniki);
//				add(odppanel);				
//				klient.zamknijPo³¹czenie();
				JOptionPane.showMessageDialog(null,"Uzyskany wynik: " + wynik + "/4 \n"
						+ "Poprawne odpowiedzi to:\n"
						+ "Pytanie 1: " + poprawneodp.charAt(0) + "\n"
						+ "Pytanie 2: " + poprawneodp.charAt(1) + "\n"
						+ "Pytanie 3: " + poprawneodp.charAt(2) + "\n"
						+ "Pytanie 4: " + poprawneodp.charAt(3));  
				}
				});
			
		setLayout(new GridLayout(9,0));
		
		
		
	}
}
