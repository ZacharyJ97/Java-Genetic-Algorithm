package gen.algorithm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Algorithm_Control {
	
	//My Declarations
	private double mutationRate = .01;
	private int numPlaces = 50;
    private int numGenerations = 100;
    private int numPaths = 100;
    
    private boolean rouletteStyle = true;
    private boolean tourneyStyle = false;
    private boolean randCross = true;
    private boolean halfCross = false;
    private boolean swapMutate = true;

	

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
		frame.setBounds(100, 100, 995, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 721, 644);
		frame.getContentPane().add(textArea);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout = (FlowLayout) selectionPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		selectionPanel.setBounds(737, 252, 221, 82);
		frame.getContentPane().add(selectionPanel);
		
		JRadioButton rdbtnRouletteStyle = new JRadioButton("Roulette Style");
		rdbtnRouletteStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rouletteStyle = true;
				tourneyStyle = false;
			}
		});
		selectionGroup.add(rdbtnRouletteStyle);
		rdbtnRouletteStyle.setSelected(true);
		rdbtnRouletteStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnRouletteStyle);
		
		JRadioButton rdbtnTournamentStyle = new JRadioButton("Tournament Style");
		rdbtnTournamentStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tourneyStyle = true;
				rouletteStyle = false;
			}
		});
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
		lblSelectionMethod.setBounds(737, 213, 148, 34);
		frame.getContentPane().add(lblSelectionMethod);
		
		JPanel crossoverPanel = new JPanel();
		crossoverPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_1 = (FlowLayout) crossoverPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		crossoverPanel.setBounds(737, 377, 221, 82);
		frame.getContentPane().add(crossoverPanel);
		
		JRadioButton rdbtnRandomSubset = new JRadioButton("Random Subset");
		rdbtnRandomSubset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randCross = true;
				halfCross = false;
			}
		});
		crossGroup.add(rdbtnRandomSubset);
		rdbtnRandomSubset.setSelected(true);
		rdbtnRandomSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnRandomSubset);
		
		JRadioButton rdbtnHalf = new JRadioButton("Half Path Size");
		rdbtnHalf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randCross = false;
				halfCross = true;
			}
		});
		crossGroup.add(rdbtnHalf);
		rdbtnHalf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnHalf);
		
		JLabel lblCrossoverMethod = new JLabel("Crossover Method:");
		lblCrossoverMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCrossoverMethod.setBounds(737, 338, 148, 34);
		frame.getContentPane().add(lblCrossoverMethod);
		
		JPanel mutationPanel = new JPanel();
		mutationPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_2 = (FlowLayout) mutationPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		mutationPanel.setBounds(737, 514, 221, 82);
		frame.getContentPane().add(mutationPanel);
		
		JRadioButton rdbtnSwapMutation = new JRadioButton("Swap Mutation");
		rdbtnSwapMutation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnSwapMutation.isSelected())
				{
					swapMutate = true;
				}
			}
		});

		mutateGroup.add(rdbtnSwapMutation);
		rdbtnSwapMutation.setSelected(true);
		rdbtnSwapMutation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnSwapMutation);
		
		JRadioButton rdbtnScrambleSubset = new JRadioButton("Scramble Subset");
		rdbtnScrambleSubset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnScrambleSubset.isSelected())
				{
					swapMutate = false;
				}
			}
		});
		mutateGroup.add(rdbtnScrambleSubset);
		rdbtnScrambleSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationPanel.add(rdbtnScrambleSubset);
		
		JLabel lblMutationMethod = new JLabel("Mutation Method:");
		lblMutationMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMutationMethod.setBounds(737, 475, 148, 34);
		frame.getContentPane().add(lblMutationMethod);
		
		Button startButton = new Button("Start Algorithm");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
				for (int i=0; i < numPlaces; i++)
				{
					Place place = new Place();
					Path.GetMap().add(place);
				}
			    
				int gen = 0;
				
			    Population initPop = new Population(numPaths,null,true);
			    System.out.println("Generation " + gen + ":" );
			    System.out.println("Best Path Length: " + initPop.getTopFitPath().calcPathDistance());
			    System.out.println("Fitness Score: " + initPop.getTopFitPath().GetPathFitness());
			    System.out.println("Number of Places in Path: " + initPop.getTopFitPath().PathSize());
			    
			    initPop = Algorithm.generateNewPop(initPop, randCross, halfCross, tourneyStyle, rouletteStyle, swapMutate, mutationRate);
			    for (gen = 0; gen < numGenerations; gen++)
			    {
			    	initPop = Algorithm.generateNewPop(initPop,randCross, halfCross, tourneyStyle, rouletteStyle, swapMutate, mutationRate);
			    	
			    }
			    
		        System.out.println("Final Path Length: " + initPop.getTopFitPath().calcPathDistance());
		        System.out.println("Final Fitness Score: " + initPop.getTopFitPath().GetPathFitness());
		        System.out.println("Final Path:");
		        System.out.println(initPop.getTopFitPath().toString());
		        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
			}
		});
		startButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		startButton.setBounds(810, 602, 148, 52);
		frame.getContentPane().add(startButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {".01 Mutation Rate", ".05 Mutation Rate", ".1 Mutation Rate", ".2 Mutation Rate"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(737, 174, 221, 34);
		frame.getContentPane().add(comboBox);
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
