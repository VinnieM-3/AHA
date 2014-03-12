package com.ls2;

import java.awt.*;
import javax.swing.*;

public class HomePage extends View {
	private Dimension defaultPanelDimension = new Dimension(1000,600);
	private Color backGroundColor = new Color(0, 0, 0);
	private Settings settings = null;
	private Icon icon = null;
	
	public HomePage(int cols) {
	    super(new BorderLayout());
	    settings = Settings.getInstance();
		setBackground(backGroundColor);
	   	setSize(defaultPanelDimension);
 		try {
	 		java.net.URL imageURL = this.getClass().getResource("images/homepage.gif");
	 		if (imageURL != null) {
	 			icon = new ImageIcon(imageURL);
	 		}
	 		JLabel label = new JLabel(icon);
	 		this.add(label);
		}catch (Exception e) {
 			e.printStackTrace();
 		}
	}
	
	public void leaveView() {}
	
	public void displayView(int fileCollectionID) {
	   	this.setSize(getPreferredSize());
		this.getParent().validate();
		repaint();
	}
		
	public Dimension getPreferredSize() {
 		return defaultPanelDimension;
	}
	
 	protected void paintComponent(Graphics g) {
    	super.paintComponent(g); 
    	
 		g.setColor(TextColor150);
        g.setFont(fontBold20);
    	
      	int halfPageWidth = Math.round((float)this.getWidth()/2.0f);
      	int halfPageHeight = Math.round((float)this.getHeight()/2.0f);     	
      	int halfStrLen =0;
      	
      	int titleY = (int)Math.round((halfPageHeight - Math.round((float)icon.getIconHeight()/2.0f))/2.0f);
      	
        String licAppTitle = "AHA - Advanced Histogram Analyzer";
        halfStrLen = Math.round((float)licAppTitle.length()/2.0f)*10;
        if ( halfStrLen > halfPageWidth ) halfStrLen = halfPageWidth;
        g.drawString(licAppTitle, (halfPageWidth - halfStrLen), titleY);
   	
      	int licY = halfPageHeight + Math.round((float)icon.getIconHeight()/2.0f);
      	licY = Math.round((Math.round((float)this.getHeight()) - (float)licY)/2.0f) + licY;

	}	
 
}
