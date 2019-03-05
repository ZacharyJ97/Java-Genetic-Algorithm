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

/**
 * This class contains the auto code generated for Java GUI components but then also the main algorithm execution with the selected options
 * Variables contained are the mutation, number of objects, and booleans to control the chosen operators. Main executing code found at bottom of class under the start button
 * 
 * @author copyright Zachary Fitzpatrick, 2019.
 * Created under educational circumstances for an Intelligent Systems Undergraduate Course, a capstone for the Computer Science Program at Thomas College.
 */
public class Algorithm_Control {
	
	//My Declarations
	private static double mutationRate = .005;
	private static int numPlaces = 50;
    private static int numGenerations = 100;
    private static int numPaths = 100;
    
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
		frame.setBounds(100, 100, 995, 930);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextArea generationsTextArea = new TextArea();
		generationsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
		generationsTextArea.setBackground(Color.WHITE);
		generationsTextArea.setEditable(false);
		generationsTextArea.setBounds(10, 10, 721, 586);
		frame.getContentPane().add(generationsTextArea);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout = (FlowLayout) selectionPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		selectionPanel.setBounds(737, 252, 221, 82);
		frame.getContentPane().add(selectionPanel);
		
		JRadioButton rdbtnRouletteStyle = new JRadioButton("Roulette Style");
		rdbtnRouletteStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnRouletteStyle.isSelected())
				{
					rouletteStyle = true;
					tourneyStyle = false;
				}
			}
		});
		selectionGroup.add(rdbtnRouletteStyle);
		rdbtnRouletteStyle.setSelected(true);
		rdbtnRouletteStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnRouletteStyle);
		
		JRadioButton rdbtnTournamentStyle = new JRadioButton("Tournament Style");
		rdbtnTournamentStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnTournamentStyle.isSelected())
				{
					tourneyStyle = true;
					rouletteStyle = false;
				}
			}
		});
		selectionGroup.add(rdbtnTournamentStyle);
		rdbtnTournamentStyle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectionPanel.add(rdbtnTournamentStyle);
		
		JComboBox numGenerationCB = new JComboBox();
		numGenerationCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numGenerationCB.getSelectedIndex() == 0)
				{
					numGenerations = 100;
				}
				else if (numGenerationCB.getSelectedIndex() == 1)
				{
					numGenerations = 500;
				}
				else if (numGenerationCB.getSelectedIndex() == 2)
				{
					numGenerations = 1000;
				}
				else 
				{
					numGenerations = 2000;
				}
			}
		});
		numGenerationCB.setBackground(Color.WHITE);
		numGenerationCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numGenerationCB.setMaximumRowCount(4);
		numGenerationCB.setModel(new DefaultComboBoxModel(new String[] {"100 Generations", "500 Generations", "1000 Generations", "2000 Generations"}));
		numGenerationCB.setBounds(737, 124, 221, 34);
		frame.getContentPane().add(numGenerationCB);
		
		JComboBox numPlacesCB = new JComboBox();
		numPlacesCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numPlacesCB.getSelectedIndex() == 0)
				{
					numPlaces = 50;
				}
				else if (numPlacesCB.getSelectedIndex() == 1)
				{
					numPlaces = 100;
				}
				else if (numPlacesCB.getSelectedIndex() == 2)
				{
					numPlaces = 150;
				}
				else
				{
					numPlaces = 200;
				}
			}
		});
		numPlacesCB.setBackground(Color.WHITE);
		numPlacesCB.setModel(new DefaultComboBoxModel(new String[] {"50 Places on Map", "100 Places on Map", "150 Places on Map", "200 Places on Map"}));
		numPlacesCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numPlacesCB.setMaximumRowCount(4);
		numPlacesCB.setBounds(737, 66, 221, 34);
		frame.getContentPane().add(numPlacesCB);
		
		JComboBox populationSizeCB = new JComboBox();
		populationSizeCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (populationSizeCB.getSelectedIndex() == 0)
				{
					numPaths = 100;
				}
				else if (populationSizeCB.getSelectedIndex() == 1)
				{
					numPaths = 200;
				}
				else
				{
					numPaths = 300;
				}
			}
		});
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
				if (rdbtnRandomSubset.isSelected())
				{
					randCross = true;
					halfCross = false;
				}
			}
		});
		crossGroup.add(rdbtnRandomSubset);
		rdbtnRandomSubset.setSelected(true);
		rdbtnRandomSubset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		crossoverPanel.add(rdbtnRandomSubset);
		
		JRadioButton rdbtnHalf = new JRadioButton("Half Path Size");
		rdbtnHalf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnHalf.isSelected())
				{
					randCross = false;
					halfCross = true;
				}
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
		
		JComboBox mutationRateCB = new JComboBox();
		mutationRateCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mutationRateCB.getSelectedIndex() == 0)
				{
					mutationRate = .005;
				}
				else if (mutationRateCB.getSelectedIndex() == 1)
				{
					mutationRate = .01;
				}
				else if (mutationRateCB.getSelectedIndex() == 2)
				{
					mutationRate = .05;
				}
				else 
				{
					mutationRate = .1;
				}
			}
		});
		mutationRateCB.setModel(new DefaultComboBoxModel(new String[] {".005 Mutation Rate", ".01 Mutation Rate", ".05 Mutation Rate", ".1 Mutation Rate"}));
		mutationRateCB.setMaximumRowCount(4);
		mutationRateCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationRateCB.setBackground(Color.WHITE);
		mutationRateCB.setBounds(737, 174, 221, 34);
		frame.getContentPane().add(mutationRateCB);
		
		TextArea fittestTextArea = new TextArea();
		fittestTextArea.setFont(new Font("Arial", Font.BOLD, 18));
		fittestTextArea.setBackground(Color.WHITE);
		fittestTextArea.setEditable(false);
		fittestTextArea.setBounds(10, 660, 948, 204);
		frame.getContentPane().add(fittestTextArea);
		
		JLabel lblFinalGenerationOutput = new JLabel("Final Generation Output:");
		lblFinalGenerationOutput.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFinalGenerationOutput.setBounds(15, 613, 262, 41);
		frame.getContentPane().add(lblFinalGenerationOutput);
		
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
			    generationsTextArea.append("Initial Population: " + "\n" + "Best Path Length: " + initPop.getTopFitPath().calcPathDistance() + "\n" +
			    		"Fitness Score: " + initPop.getTopFitPath().GetPathFitness()
			    		);
			    
			    initPop = Algorithm.generateNewPop(initPop, randCross, halfCross, tourneyStyle, rouletteStyle, swapMutate, mutationRate);
			    for (gen = 0; gen < numGenerations; gen++)
			    {
			    	initPop = Algorithm.generateNewPop(initPop,randCross, halfCross, tourneyStyle, rouletteStyle, swapMutate, mutationRate);
			    	generationsTextArea.append("\n \n" + "Generation " + (gen+1) + ":" + "\n" + "Best Path Length: " + initPop.getTopFitPath().calcPathDistance() + "\n" +
				    		"Fitness Score: " + initPop.getTopFitPath().GetPathFitness() + "\n" + "Number of Places in Path: " + initPop.getTopFitPath().PathSize()
				    		);
			    	
			    }
			    fittestTextArea.append("Final Generation" + "\n" + "Best Path Length: " + initPop.getTopFitPath().calcPathDistance() + "\n" +
			    		"Final Fitness Score: " + initPop.getTopFitPath().GetPathFitness() + "\n"
			    		+ "Final Path: " + initPop.getTopFitPath().toString() + "\n"
			    		);
		        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
		        System.out.println("Final Pop Size: " + initPop.getPopSize());
		        System.out.println(mutationRate);
		        System.out.println(numGenerations);
		        //Had to do his to prevent number of places compounding for each consecutive algorithm start
		        Path.GetMap().clear();

		        
		        /*for (int index = 0; index < initPop.getPopSize(); index++)
		        {
		        	System.out.println(initPop.getPathFromPop(index));
		        	
		        }*/
			}
		});		
		startButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		startButton.setBounds(810, 602, 148, 52);
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
