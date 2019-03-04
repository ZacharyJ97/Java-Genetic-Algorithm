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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

public class Algorithm_Control {

	private JFrame frame;
	private final Action action = new SwingAction();
	private final ButtonGroup selectionGroup = new ButtonGroup();
	private final ButtonGroup crossGroup = new ButtonGroup();
	private final ButtonGroup mutateGroup = new ButtonGroup();

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
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 721, 607);
		frame.getContentPane().add(textArea);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout = (FlowLayout) selectionPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		selectionPanel.setBounds(737, 203, 221, 82);
		frame.getContentPane().add(selectionPanel);
		
		JRadioButton rdbtnRouletteStyle = new JRadioButton("Roulette Style");
		selectionGroup.add(rdbtnRouletteStyle);
		rdbtnRouletteStyle.setSelected(true);
		rdbtnRouletteStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnRouletteStyle);
		
		JRadioButton rdbtnTournamentStyle = new JRadioButton("Tournament Style");
		selectionGroup.add(rdbtnTournamentStyle);
		rdbtnTournamentStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnTournamentStyle);
		
		JComboBox numGenerationCB = new JComboBox();
		numGenerationCB.setBackground(Color.WHITE);
		numGenerationCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numGenerationCB.setMaximumRowCount(3);
		numGenerationCB.setModel(new DefaultComboBoxModel(new String[] {"100 Generations", "500 Generations", "1000 Generations"}));
		numGenerationCB.setBounds(737, 124, 221, 34);
		frame.getContentPane().add(numGenerationCB);
		
		JComboBox numPlacesCB = new JComboBox();
		numPlacesCB.setBackground(Color.WHITE);
		numPlacesCB.setModel(new DefaultComboBoxModel(new String[] {"50 Places on Map", "100 Places on Map", "150 Places on Map", "200 Places on Map"}));
		numPlacesCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numPlacesCB.setMaximumRowCount(4);
		numPlacesCB.setBounds(737, 66, 221, 34);
		frame.getContentPane().add(numPlacesCB);
		
		JComboBox populationSizeCB = new JComboBox();
		populationSizeCB.setBackground(Color.WHITE);
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
		crossoverPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_1 = (FlowLayout) crossoverPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		crossoverPanel.setBounds(737, 340, 221, 82);
		frame.getContentPane().add(crossoverPanel);
		
		JRadioButton rdbtnRandomSubset = new JRadioButton("Random Subset");
		crossGroup.add(rdbtnRandomSubset);
		rdbtnRandomSubset.setSelected(true);
		rdbtnRandomSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnRandomSubset);
		
		JRadioButton rdbtnHalf = new JRadioButton("Half Path Size");
		crossGroup.add(rdbtnHalf);
		rdbtnHalf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnHalf);
		
		JLabel lblCrossoverMethod = new JLabel("Crossover Method:");
		lblCrossoverMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrossoverMethod.setBounds(737, 301, 148, 34);
		frame.getContentPane().add(lblCrossoverMethod);
		
		JPanel mutationPanel = new JPanel();
		mutationPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_2 = (FlowLayout) mutationPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		mutationPanel.setBounds(737, 477, 221, 82);
		frame.getContentPane().add(mutationPanel);
		
		JRadioButton rdbtnSwapMutation = new JRadioButton("Swap Mutation");
		mutateGroup.add(rdbtnSwapMutation);
		rdbtnSwapMutation.setSelected(true);
		rdbtnSwapMutation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnSwapMutation);
		
		JRadioButton rdbtnScrambleSubset = new JRadioButton("Scramble Subset");
		mutateGroup.add(rdbtnScrambleSubset);
		rdbtnScrambleSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnScrambleSubset);
		
		JLabel lblMutationMethod = new JLabel("Mutation Method:");
		lblMutationMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMutationMethod.setBounds(737, 438, 148, 34);
		frame.getContentPane().add(lblMutationMethod);
		
		Button startButton = new Button("Start Algorithm");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int numPlaces = 100;
				for (int i=0; i < numPlaces; i++)
				{
					Place place = new Place();
					Path.GetMap().add(place);
				}
			    
			    int numGenerations = 500;
			    
			    Population initPop = new Population(100,null,true);
			    System.out.println("First Path Length: " + initPop.getTopFitPath().calcPathDistance());
			    
			    initPop = Algorithm.generateNewPop(initPop,true,false,false,true, true);
			    for (int gen = 0; gen < numGenerations; gen++)
			    {
			    	initPop = Algorithm.generateNewPop(initPop,true,false,false,true, true);
			    	
			    }
			    
		        System.out.println("Final Path Length: " + initPop.getTopFitPath().calcPathDistance());
		        System.out.println("Final Fitness Score: " + initPop.getTopFitPath().GetPathFitness());
		        System.out.println("Final Path:");
		        System.out.println(initPop.getTopFitPath().toString());
		        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
				
				System.out.println("button clicked");
			}
		});
		startButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		startButton.setBounds(810, 565, 148, 52);
		frame.getContentPane().add(startButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
