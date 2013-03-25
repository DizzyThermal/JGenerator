import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class GUI extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	private static final int NON_PERSISTENT_SERIAL		= 0;
	private static final int NON_PERSISTENT_PARALLEL	= 1;
	private static final int PERSISTENT_WITH_PIPE		= 2;
	private static final int PERSISTENT_WITHOUT_PIPE	= 3;
	
	// Panel Objects
	private static final int MODE		= 1;
	private static final int RATE		= 3;
	private static final int DURATION	= 5;

	private String[] panelOptions = { "Mode", "Rate", "Duration" };
	private String[] modes = {	"Non-Persistent Serial", "Non-Persistent Parallel",
								"Persistent With Pipe", "Persistent Without Pipe"	};

	// GUI Panel
	JPanel mainPanel = new JPanel();

	// Generate Traffic and Clear Buttons
	JButton generateTrafficButton = new JButton("Generate Traffic");
	JButton resetButton = new JButton("Reset");
	
	GUI()
	{
		super("ECE 369 - JGenerator");
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		setLayout(fl);
		
		createPanel();
		
		add(mainPanel);
	}
	
	public void createPanel()
	{
		mainPanel.setPreferredSize(new Dimension(425,500));
		mainPanel.add(new JLabel(panelOptions[0] + ":"));
		mainPanel.add(new JComboBox(modes));
		mainPanel.add(new JLabel(panelOptions[1] + ":"));
		mainPanel.add(new JSpinner());
		mainPanel.add(new JLabel(panelOptions[2] + ":"));
		mainPanel.add(new JSpinner());
		
		generateTrafficButton.addActionListener(this);
		resetButton.addActionListener(this);
		mainPanel.add(generateTrafficButton);
		mainPanel.add(resetButton);
		
		for(int i = 0; i < mainPanel.getComponentCount(); i++)
			mainPanel.getComponent(i).setPreferredSize(new Dimension(200, 25));
		
		defaultFields();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == generateTrafficButton)
		{
			int[] parameters = new int[3];
			parameters[0] = ((JComboBox)mainPanel.getComponent(MODE)).getSelectedIndex();
			parameters[1] = Integer.parseInt(((JSpinner)mainPanel.getComponent(RATE)).getValue().toString());
			parameters[2] = Integer.parseInt(((JSpinner)mainPanel.getComponent(DURATION)).getValue().toString());

			try { JOptionPane.showMessageDialog(this, JGenerator.GUIExecute(parameters)); }
			catch (IOException exception) { exception.printStackTrace(); }
		}
		else if(e.getSource() == resetButton)
			defaultFields();
	}
	
	public void defaultFields()
	{
		((JComboBox)mainPanel.getComponent(MODE)).setSelectedIndex(0);
		((JSpinner)mainPanel.getComponent(RATE)).setValue(1);
		((JSpinner)mainPanel.getComponent(DURATION)).setValue(30);
	}
}