package gen.algorithm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Algorithm_Control {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algorithm_Control window = new Algorithm_Control();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Algorithm_Control() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 641, 607);
		frame.getContentPane().add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(657, 186, 301, 238);
		frame.getContentPane().add(panel);
		
		JComboBox numGenerationCB = new JComboBox();
		numGenerationCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numGenerationCB.setMaximumRowCount(3);
		numGenerationCB.setModel(new DefaultComboBoxModel(new String[] {"100 Generations", "500 Generations", "1000 Generations"}));
		numGenerationCB.setBounds(657, 124, 301, 34);
		frame.getContentPane().add(numGenerationCB);
		
		JComboBox numPlacesCB = new JComboBox();
		numPlacesCB.setModel(new DefaultComboBoxModel(new String[] {"50 Places on Map", "100 Places on Map", "150 Places on Map", "200 Places on Map"}));
		numPlacesCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numPlacesCB.setMaximumRowCount(4);
		numPlacesCB.setBounds(657, 66, 301, 34);
		frame.getContentPane().add(numPlacesCB);
		
		JComboBox populationSizeCB = new JComboBox();
		populationSizeCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		populationSizeCB.setModel(new DefaultComboBoxModel(new String[] {"100 Paths in Population", "200 Paths in Population", "300 Paths in Population"}));
		populationSizeCB.setMaximumRowCount(3);
		populationSizeCB.setBounds(657, 10, 301, 34);
		frame.getContentPane().add(populationSizeCB);
	}
}
