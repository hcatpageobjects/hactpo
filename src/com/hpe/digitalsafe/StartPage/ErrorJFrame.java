package com.hpe.digitalsafe.StartPage;

import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorJFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String messageDuplicate="There are Duplicate Records, please refer to the Excel sheet for more details.";
	private String messageEmptyCell="There is an empty field, please verify";
	private String title="iSTF Error";
	
	public ErrorJFrame() {}
	
	public void displayErrorMessageDuplicate(){
		JOptionPane.showMessageDialog(this, messageDuplicate, title , JOptionPane.ERROR_MESSAGE);
	}
	
	public void displayErrorMessageEmptycell(){
		JOptionPane.showMessageDialog(this, messageEmptyCell, title , JOptionPane.ERROR_MESSAGE);
	}
}
