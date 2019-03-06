package gen.algorithm;

import java.awt.EventQueue;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
import java.text.DecimalFormat;
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
	
	//My Declarations and toString method
	private static double mutationRate = .005;
	private static int numPlaces = 50;
    private static int numGenerations = 100;
    private static int numPaths = 100;
    private static int algorithmCount = 1;
    
    JFrame chartFrame = new JFrame("Fittest Per Generation Chart");
    private ChartPanel cp;
    private XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
    
    
    private boolean rouletteStyle = true;
    private boolean tourneyStyle = false;
    private boolean randCross = true;
    private boolean halfCross = false;
    private boolean swapMutate = true;
    
    public DecimalFormat df = new DecimalFormat("###.##");
    public DecimalFormat df2 = new DecimalFormat("###.####");
	public String buttonToString(JRadioButton rb)
	{
		String label = rb.getText();
		return label;
	}


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
		frame.setBounds(0, 0, 1250, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Charting code
		chartFrame.setBounds(200, 30, 800, 600);
		chartFrame.getContentPane().setLayout(null);
        
		
		TextArea generationsTextArea = new TextArea();
		generationsTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
		generationsTextArea.setBackground(Color.WHITE);
		generationsTextArea.setEditable(false);
		generationsTextArea.setBounds(10, 10, 981, 575);
		frame.getContentPane().add(generationsTextArea);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout = (FlowLayout) selectionPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		selectionPanel.setBounds(997, 252, 221, 82);
		frame.getContentPane().add(selectionPanel);
		
		
		JRadioButton rdbtnRouletteStyle = new JRadioButton("Roulette Style");
		rdbtnRouletteStyle.setActionCommand("Roulette Selection");
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
		rdbtnTournamentStyle.setActionCommand("Tournament Selection");
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
					numGenerationCB.setActionCommand("100 Generations");
				}
				else if (numGenerationCB.getSelectedIndex() == 1)
				{
					numGenerations = 500;
					numGenerationCB.setActionCommand("500 Generations");
				}
				else if (numGenerationCB.getSelectedIndex() == 2)
				{
					numGenerations = 1000;
					numGenerationCB.setActionCommand("1000 Generations");
				}
				else 
				{
					numGenerations = 2000;
					numGenerationCB.setActionCommand("2000 Generations");
				}
			}
		});
		numGenerationCB.setBackground(Color.WHITE);
		numGenerationCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numGenerationCB.setMaximumRowCount(4);
		numGenerationCB.setModel(new DefaultComboBoxModel(new String[] {"100 Generations", "500 Generations", "1000 Generations", "2000 Generations"}));
		numGenerationCB.setBounds(997, 124, 221, 34);
		frame.getContentPane().add(numGenerationCB);
		
		JComboBox numPlacesCB = new JComboBox();
		numPlacesCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numPlacesCB.getSelectedIndex() == 0)
				{
					numPlaces = 50;
					numPlacesCB.setActionCommand("50 places were on the map.");
				}
				else if (numPlacesCB.getSelectedIndex() == 1)
				{
					numPlaces = 100;
					numPlacesCB.setActionCommand("100 places were on the map.");
				}
				else if (numPlacesCB.getSelectedIndex() == 2)
				{
					numPlaces = 150;
					numPlacesCB.setActionCommand("150 places were on the map.");
				}
				else
				{
					numPlaces = 200;
					numPlacesCB.setActionCommand("200 places were on the map.");
				}
			}
		});
		numPlacesCB.setBackground(Color.WHITE);
		numPlacesCB.setModel(new DefaultComboBoxModel(new String[] {"50 Places on Map", "100 Places on Map", "150 Places on Map", "200 Places on Map"}));
		numPlacesCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numPlacesCB.setMaximumRowCount(4);
		numPlacesCB.setBounds(997, 66, 221, 34);
		frame.getContentPane().add(numPlacesCB);
		
		JComboBox populationSizeCB = new JComboBox();
		populationSizeCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (populationSizeCB.getSelectedIndex() == 0)
				{
					numPaths = 100;
					populationSizeCB.setActionCommand("100 paths were in the population.");
				}
				else if (populationSizeCB.getSelectedIndex() == 1)
				{
					numPaths = 200;
					populationSizeCB.setActionCommand("200 paths were in the population.");
				}
				else
				{
					numPaths = 300;
					populationSizeCB.setActionCommand("300 paths were in the population.");
				}
			}
		});
		populationSizeCB.setBackground(Color.WHITE);
		populationSizeCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		populationSizeCB.setModel(new DefaultComboBoxModel(new String[] {"100 Paths in Population", "200 Paths in Population", "300 Paths in Population"}));
		populationSizeCB.setMaximumRowCount(3);
		populationSizeCB.setBounds(997, 10, 221, 34);
		frame.getContentPane().add(populationSizeCB);
		
		JLabel lblSelectionMethod = new JLabel("Selection Method:");
		lblSelectionMethod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectionMethod.setBounds(997, 213, 148, 34);
		frame.getContentPane().add(lblSelectionMethod);
		
		JPanel crossoverPanel = new JPanel();
		crossoverPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_1 = (FlowLayout) crossoverPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		crossoverPanel.setBounds(997, 377, 221, 82);
		frame.getContentPane().add(crossoverPanel);
		
		JRadioButton rdbtnRandomSubset = new JRadioButton("Random Subset");
		rdbtnRandomSubset.setActionCommand("Random Subset Crossover");
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
		rdbtnHalf.setActionCommand("Half Path Crossover");
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
		lblCrossoverMethod.setBounds(997, 338, 148, 34);
		frame.getContentPane().add(lblCrossoverMethod);
		
		JPanel mutationPanel = new JPanel();
		mutationPanel.setBorder(new LineBorder(Color.GRAY, 2, true));
		FlowLayout flowLayout_2 = (FlowLayout) mutationPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		mutationPanel.setBounds(997, 503, 221, 82);
		frame.getContentPane().add(mutationPanel);
		
		JRadioButton rdbtnSwapMutation = new JRadioButton("Swap Mutation");
		rdbtnSwapMutation.setActionCommand("Swap Mutation");
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
		rdbtnScrambleSubset.setActionCommand("Scramble Subset Mutation");
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
		lblMutationMethod.setBounds(997, 464, 148, 34);
		frame.getContentPane().add(lblMutationMethod);
		
		JComboBox mutationRateCB = new JComboBox();
		mutationRateCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mutationRateCB.getSelectedIndex() == 0)
				{
					mutationRate = .005;
					mutationRateCB.setActionCommand("The mutation rate was .005");
				}
				else if (mutationRateCB.getSelectedIndex() == 1)
				{
					mutationRate = .01;
					mutationRateCB.setActionCommand("The mutation rate was .01");
				}
				else if (mutationRateCB.getSelectedIndex() == 2)
				{
					mutationRate = .05;
					mutationRateCB.setActionCommand("The mutation rate was .05");
				}
				else 
				{
					mutationRate = .1;
					mutationRateCB.setActionCommand("The mutation rate was .1");
				}
			}
		});
		mutationRateCB.setModel(new DefaultComboBoxModel(new String[] {".005 Mutation Rate", ".01 Mutation Rate", ".05 Mutation Rate", ".1 Mutation Rate"}));
		mutationRateCB.setMaximumRowCount(4);
		mutationRateCB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mutationRateCB.setBackground(Color.WHITE);
		mutationRateCB.setBounds(997, 174, 221, 34);
		frame.getContentPane().add(mutationRateCB);
		
		TextArea fittestTextArea = new TextArea();
		fittestTextArea.setFont(new Font("Arial", Font.BOLD, 18));
		fittestTextArea.setBackground(Color.WHITE);
		fittestTextArea.setEditable(false);
		fittestTextArea.setBounds(10, 638, 1208, 296);
		frame.getContentPane().add(fittestTextArea);
		
		JLabel lblFinalGenerationOutput = new JLabel("Algorithm Summary Output:");
		lblFinalGenerationOutput.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFinalGenerationOutput.setBounds(10, 591, 298, 41);
		frame.getContentPane().add(lblFinalGenerationOutput);
		
		
		Button startButton = new Button("Start Algorithm");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0; i < numPlaces; i++)
				{
					Place place = new Place();
					Path.GetMap().add(place);
				}
				//Getting selected options for textual output
				String select = selectionGroup.getSelection().getActionCommand();
				String cross =crossGroup.getSelection().getActionCommand();
				String mut = mutateGroup.getSelection().getActionCommand();
			    
				//Resetting top text area for each start algorithm
				generationsTextArea.setText(null);

				int gen = 0;
				
			    Population initPop = new Population(numPaths,null,true);
			    //Text Output for GUI
			    generationsTextArea.append("Initial Population" + "\n" + "Initial Best Path Length: " + df.format(initPop.getTopFitPath().calcPathDistance()) + "\n" +
			    		"Fitness Score: " + df2.format(initPop.getTopFitPath().GetPathFitness()) + "\n"
			    		);
			    fittestTextArea.append("\n" + "Algorithm #" + algorithmCount + " used " + select + " with " + cross + " and " + mut + ". \n");
			    fittestTextArea.append("\n" + "Initial Population" + "\n" + "Initial Best Path Length: " + df.format(initPop.getTopFitPath().calcPathDistance()) + "\n" +
			    		"Fitness Score: " + df2.format(initPop.getTopFitPath().GetPathFitness()) + "\n"
			    		);

			    //Evolve Population
			    for (gen = 0; gen < numGenerations; gen++)
			    {
			    	initPop = Algorithm.generateNewPop(initPop,randCross, halfCross, tourneyStyle, rouletteStyle, swapMutate, mutationRate);
			    	
			    	
			    	generationsTextArea.append(" \n" + "Generation " + (gen+1) + ":" + "\n" + "Best Path Length: " + df.format(initPop.getTopFitPath().calcPathDistance()) + "\n" +
				    		"Fitness Score: " + df2.format(initPop.getTopFitPath().GetPathFitness()) + "\n"
				    		);

			    }
			    fittestTextArea.append("\nThis algorithm ran for " + numGenerations + " generations and had " + numPlaces + " places within each path, " + numPaths + " paths in the population, and a mutation rate of "
			    		+ mutationRate + ". \n");
			    
			    fittestTextArea.append("\n" + "Final Generation:" + "\n" + "Best Path Length: " + df.format(initPop.getTopFitPath().calcPathDistance()) + "\n" +
			    		"Final Fitness Score: " + df2.format(initPop.getTopFitPath().GetPathFitness()) + "\n"
			    		+ "Final Path: " + initPop.getTopFitPath().toString() + "\n"
			    		);
		        System.out.println("Final Path Size: " + initPop.getTopFitPath().PathSize());
		        System.out.println("Final Pop Size: " + initPop.getPopSize());
		        System.out.println(mutationRate);
		        System.out.println(numGenerations);
		        
		        //Had to do his to prevent number of places compounding for each consecutive algorithm start
		        Path.GetMap().clear();
		        algorithmCount++;
		        
		        
		        /*Charting code found at: https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
		        JFreeChart is a GNU Open Resource Library of charting and graphing functionalities for the Java language*/
		        /*DefaultXYDataset dataset = new DefaultXYDataset();
		        dataset.addSeries("Path Length", data);
		        
		        JFreeChart xylineChart = ChartFactory.createXYLineChart("Fittest Distance Per Generation", "Generation", "Fittest Path Length", dataset, PlotOrientation.VERTICAL,true,true,false);
		        cp = new ChartPanel(xylineChart);
		        //final XYPlot plot = xylineChart.getXYPlot();
		        //render.setSeriesPaint(0,Color.GREEN);
		        //plot.setRenderer(render);
		        chartFrame.setVisible(true);
		        cp.setVisible(true);
		        chartFrame.getContentPane().add(cp);*/
		        
		        

		        
		        
		        
		        /*for (int index = 0; index < initPop.getPopSize(); index++)
		        {
		        	System.out.println(initPop.getPathFromPop(index));
		        	
		        }*/
			}
		});		
		startButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		startButton.setBounds(1070, 591, 148, 41);
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
