package treeGrow;

import treeGrow.Controller.Controller;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class TreeGrow {
	static long startTime = 0;
	static int frameX;
	static int frameY;
	static ForestPanel fp;
	static Simulation simulation;
	static Controller controller;

	// start timer
	private static void tick(){
		startTime = System.currentTimeMillis();
	}
	
	// stop timer, return time elapsed in seconds
	private static float tock(){
		return (System.currentTimeMillis() - startTime) / 1000.0f; 
	}
	
	public static void setupGUI(int frameX,int frameY,Tree [] trees) {
		Dimension fsize = new Dimension(800, 800);
		// Frame init and dimensions
    	JFrame frame = new JFrame("Photosynthesis"); 
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setPreferredSize(fsize);
    	frame.setSize(800, 800);
    	
      	JPanel g = new JPanel();
        g.setLayout(new BoxLayout(g, BoxLayout.PAGE_AXIS)); 
      	g.setPreferredSize(fsize);
 
		fp = new ForestPanel(trees);
		fp.setPreferredSize(new Dimension(frameX,frameY));
		JScrollPane scrollFrame = new JScrollPane(fp);
		fp.setAutoscrolls(true);
		scrollFrame.setPreferredSize(fsize);
	    g.add(scrollFrame);



	    ButtonsPanel bp = new ButtonsPanel(controller);
	    g.add(bp);
    	
      	frame.setLocationRelativeTo(null);  // Center window on screen.
      	frame.add(g); //add contents to window
        frame.setContentPane(g);     
        frame.setVisible(true);


        Thread fpt = new Thread(fp);
        fpt.start();
	}

	public static void setupSimulation(Tree[] trees, Land land){
		simulation = new Simulation(land, trees);
		Thread sim = new Thread(simulation);
		sim.start();

	}
	
		
	public static void main(String[] args) {
		SunData sundata = new SunData();
		
		// check that number of command line arguments is correct
//		if(args.length != 1)
//		{
//			System.out.println("Incorrect number of command line arguments. Should have form: java treeGrow.java intputfilename");
//			System.exit(0);
//		}
				
		// read in forest and landscape information from file supplied as argument
		String fileName = "sample_input.txt";
		sundata.readData(fileName);
		System.out.println("Data loaded");

		Land land = sundata.sunmap;
		Tree[] trees = sundata.trees;

		controller = new Controller(land, trees);
		
		frameX = sundata.sunmap.getDimX();
		frameY = sundata.sunmap.getDimY();
		setupGUI(frameX, frameY, trees);
		
		// create and start simulation loop here as separate thread

		setupSimulation(trees, land);

	}
}