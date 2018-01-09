package projekt;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ConnectWindow extends JFrame{
	
	private static final long serialVersionUID = -3283858661450989056L;
	public ConnectWindow(){
		super("TEST");
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setLayout(new GridLayout(0,1));
		JLabel headerLabel = new JLabel("Po��cz z baz�:",JLabel.CENTER );
		
		JButton connect = new JButton("Rozpocznij Test");
		connect.setSize(50, 20);
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				EventQueue.invokeLater(new Runnable() {
				    @Override
				    public void run() {
				         new ProjektTestWindow();
				         }
				    });
					
				}
				});
		
		add(headerLabel);
		add(connect);
	}
	
	
}
