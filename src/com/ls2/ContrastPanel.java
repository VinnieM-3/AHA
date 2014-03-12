package com.ls2;

import java.awt.image.BufferedImage;


public class ContrastPanel extends AdjustmentPanel {
	
	public ContrastPanel(BufferedImage srcImg) {
		super(srcImg);
	}
	
	float calcMagSetting(int pos) {
		return (float)pos/200;
	}
		
	String heading() {
		return "Contrast Level";
	}
	
	BufferedImage applyAdj(BufferedImage srcImage, float magSetting) {
		return ImageAnalysis.Contrast(srcImage, magSetting, null);
	}

}
