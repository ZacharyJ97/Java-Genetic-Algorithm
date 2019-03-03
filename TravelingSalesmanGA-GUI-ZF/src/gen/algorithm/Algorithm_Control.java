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
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Button;

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
		textArea.setBounds(10, 10, 721, 607);
		frame.getContentPane().add(textArea);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBounds(737, 203, 221, 82);
		frame.getContentPane().add(selectionPanel);
		
		JRadioButton rdbtnRouletteStyle = new JRadioButton("Roulette Style");
		rdbtnRouletteStyle.setSelected(true);
		rdbtnRouletteStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnRouletteStyle);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tournament Style");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnNewRadioButton);
		
		JComboBox numGenerationCB = new JComboBox();
		numGenerationCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numGenerationCB.setMaximumRowCount(3);
		numGenerationCB.setModel(new DefaultComboBoxModel(new String[] {"100 Generations", "500 Generations", "1000 Generations"}));
		numGenerationCB.setBounds(737, 124, 221, 34);
		frame.getContentPane().add(numGenerationCB);
		
		JComboBox numPlacesCB = new JComboBox();
		numPlacesCB.setModel(new DefaultComboBoxModel(new String[] {"50 Places on Map", "100 Places on Map", "150 Places on Map", "200 Places on Map"}));
		numPlacesCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numPlacesCB.setMaximumRowCount(4);
		numPlacesCB.setBounds(737, 66, 221, 34);
		frame.getContentPane().add(numPlacesCB);
		
		JComboBox populationSizeCB = new JComboBox();
		populationSizeCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		populationSizeCB.setModel(new DefaultComboBoxModel(new String[] {"100 Paths in Population", "200 Paths in Population", "300 Paths in Population"}));
		populationSizeCB.setMaximumRowCount(3);
		populationSizeCB.setBounds(737, 10, 221, 34);
		frame.getContentPane().add(populationSizeCB);
		
		JLabel lblSelectionMethod = new JLabel("Selection Method:");
		lblSelectionMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectionMethod.setBounds(737, 164, 148, 34);
		frame.getContentPane().add(lblSelectionMethod);
		
		JPanel crossoverPanel = new JPanel();
		crossoverPanel.setBounds(737, 340, 221, 82);
		frame.getContentPane().add(crossoverPanel);
		
		JRadioButton rdbtnRandomSubset = new JRadioButton("Random Subset");
		rdbtnRandomSubset.setSelected(true);
		rdbtnRandomSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnRandomSubset);
		
		JRadioButton rdbtnHalf = new JRadioButton("Half Path Size");
		rdbtnHalf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnHalf);
		
		JLabel lblCrossoverMethod = new JLabel("Crossover Method:");
		lblCrossoverMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrossoverMethod.setBounds(737, 301, 148, 34);
		frame.getContentPane().add(lblCrossoverMethod);
		
		JPanel mutationPanel = new JPanel();
		mutationPanel.setBounds(737, 477, 221, 82);
		frame.getContentPane().add(mutationPanel);
		
		JRadioButton rdbtnSwapMutation = new JRadioButton("Swap Mutation");
		rdbtnSwapMutation.setSelected(true);
		rdbtnSwapMutation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnSwapMutation);
		
		JRadioButton rdbtnScrambleSubset = new JRadioButton("Scramble Subset");
		rdbtnScrambleSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnScrambleSubset);
		
		JLabel lblMutationMethod = new JLabel("Mutation Method:");
		lblMutationMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMutationMethod.setBounds(737, 438, 148, 34);
		frame.getContentPane().add(lblMutationMethod);
		
		Button startButton = new Button("Start Algorithm");
		startButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		startButton.setBounds(810, 565, 148, 52);
		frame.getContentPane().add(startButton);
	}
}
