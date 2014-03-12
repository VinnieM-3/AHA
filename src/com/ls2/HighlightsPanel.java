package com.ls2;

import java.awt.image.BufferedImage;


public class HighlightsPanel extends AdjustmentPanel {
	
	public HighlightsPanel(BufferedImage srcImg) {
		super(srcImg);
	}
	
	float calcMagSetting(int pos) {
		return ((float)pos/100f)*0.5f;
	}
		
	String heading() {
		return "Hightlights";
	}
	
	BufferedImage applyAdj(BufferedImage srcImage, float magSetting) {
		return ImageAnalysis.Hightlights(srcImage, magSetting, null);
	}

}
