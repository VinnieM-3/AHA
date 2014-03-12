package com.ls2;

import java.awt.image.BufferedImage;


public class ShadowsPanel extends AdjustmentPanel {
	
	public ShadowsPanel(BufferedImage srcImg) {
		super(srcImg);
	}
	
	float calcMagSetting(int pos) {
		return ((float)pos/100f)*0.5f;
	}
		
	String heading() {
		return "Shadows";
	}
	
	BufferedImage applyAdj(BufferedImage srcImage, float magSetting) {
		return ImageAnalysis.Shadows(srcImage, magSetting, null);
	}

}
