
//Contributed by Rohail Rasheed
//Contributed by Alyan Asif
//Contributed by Aarish Ahmed
//Contributed by Hussain Shams


package Exchange;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



class GUI {
	
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	public static Object lock3 = new Object();
	public static Object lock4 = new Object();
	

	
	public void text(String t) {
		File myObj = new File("Password.txt");
		try {
		      FileWriter myWriter = new FileWriter("Password.txt");
		      myWriter.write("Password: " + t);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	

	
    public static void main(String args[]) {
    	
    	//Creating object for Backend1 class
    	GUI obj = new GUI();
    	
    	Backend1 obj2 = new Backend1();
    	
    	obj2.start();
    	
        obj2.generatePassword(8);
        System.out.println(obj2.generatePassword(8));
        
        final char[] a = obj2.generatePassword(8);

        //Creating the Frame
        JFrame frame = new JFrame("Password Generator App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem(new AbstractAction("Saved") {
             
        	//Creating actions for button Save
        	final public void actionPerformed(ActionEvent ae) {
                obj.text(String.format("%h",a));
            }
        });

        m1.add(m11);
        
        //Creating the panel at center and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton generate = new JButton("Generate");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(generate);
        panel.add(reset);
        panel.setPreferredSize(new Dimension(100, 70));
        
        //Creating actions for button 1
        ActionListener actionListener1 = new ActionListener() {
            final public void actionPerformed(ActionEvent event) {
            	tf.setText(String.format("%h",a));
            }
         };         
         
         //Creating actions for button 2
         ActionListener actionListener2 = new ActionListener() {
             final public void actionPerformed(ActionEvent event) {
             	tf.setText("");
             	final char[] a = null;
             }
          }; 
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        //frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
       
                       
        generate.setActionCommand("Button1 is Pressed");
        generate.addActionListener(actionListener1);
        
        reset.setActionCommand("Button2 is Pressed");
        reset.addActionListener(actionListener2);
    }





public static class Backend1 extends Thread {

	   public static char[] generatePassword(int length) {
		   
		   String capitalCaseLetters;
		   String lowerCaseLetters;
		   String specialCharacters;
		   String numbers;
		   
		synchronized (lock1) {
	      capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      System.out.println("Thread 1 is holding Lock 1");
	      
		  try { Thread.sleep(10);}
		  catch (InterruptedException e) {}
		  System.out.println("Thread 1: waiting for Lock 2");
		  
		synchronized (lock2) {
	      lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      System.out.println("Thread 1 is holding Lock 2");
	      
	      try { Thread.sleep(10);}
		  catch (InterruptedException e) {}
		  System.out.println("Thread 1: waiting for Lock 3");
		
		synchronized (lock3) {
	      specialCharacters = "!@#$";
	      System.out.println("Thread 1 is holding Lock 3");
	      
	      
	      try { Thread.sleep(10);}
		  catch (InterruptedException e) {}
		  System.out.println("Thread 1: waiting for Lock 4");
		  
		synchronized (lock4) {
	      numbers = "1234567890";
	      System.out.println("Thread 1: waiting for Lock 4");  }}}}
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
		}
	   }


}

