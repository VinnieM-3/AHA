package com.ls2;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.*;


public final class Settings {
	private static Settings _instance = null;
	
	public JFrame mainFrame = null;
	
    public static GlassOverlay overlay;
    
	public static Color Highlight_Color = new Color(255,0,0);
	public static Color Shadow_Color = new Color(0,0,255);
	public static int HighlightThreshold = 253;
	public static int ShadowThreshold = 3;
	
	public ArrayList<ImageAnalysis> ImageAnalysisCol = null;
	
	public boolean FilterState = false;
	
	public Settings() {
		ImageAnalysisCol = new ArrayList<ImageAnalysis>();
		overlay = new GlassOverlay();
	}
	
	public String getFilePath() {
		String path = "";
		for (int x=0;x<ImageAnalysisCol.size();x++) {
			if (x == 0) {
				path = ImageAnalysisCol.get(x).filePath;
			}else if ( !path.equals(ImageAnalysisCol.get(x).filePath) ) {
				path = "Multiple Folders";
				break;
			}
		}
		return path;
	}
	
	/*
	Determines how many photos are displayed.  Either all if filter off,
	or number selected if filter on.
	 */
	public int getNumImagesActive() {
		int numActive = 0;
		if ( FilterState == true ) {
			for (int x=0;x<ImageAnalysisCol.size();x++) {
				if ( !ImageAnalysisCol.get(x).Hidden ) {
					numActive++;
				}
			}
		}else {
			numActive = ImageAnalysisCol.size();
		}
		return numActive;
	}
	
	public synchronized static Settings getInstance() {
		if (_instance == null ) {
			_instance = new Settings();
		}
		return _instance;
	}
	
	public void loadConfig() throws Exception {
		try {
			FileInputStream fstream = new FileInputStream("Config.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				String[] result = strLine.split("=");
				if ( result.length == 2 ) {
					if ( result[0].equals("HighlightColor") ) {
						String[] rgb = result[1].split(",");
						int r = Integer.parseInt(rgb[0]);
						int g = Integer.parseInt(rgb[1]);							
						int b = Integer.parseInt(rgb[2]);
						Highlight_Color = new Color(r,g,b);
					}else if ( result[0].equals("ShadowColor") ) {
						String[] rgb = result[1].split(",");
						int r = Integer.parseInt(rgb[0]);
						int g = Integer.parseInt(rgb[1]);							
						int b = Integer.parseInt(rgb[2]);
						Shadow_Color = new Color(r,g,b);
					}else if ( result[0].equals("HighlightThreshold") ) {
						HighlightThreshold = Integer.parseInt(result[1]);
					}else if ( result[0].equals("ShadowThreshold") ) {
						ShadowThreshold = Integer.parseInt(result[1]);
					}
				}
			}
			in.close();
		}catch (Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	
}


