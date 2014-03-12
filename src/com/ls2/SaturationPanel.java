package com.ls2;

import java.awt.image.BufferedImage;


public class SaturationPanel extends AdjustmentPanel {
	
	public SaturationPanel(BufferedImage srcImg) {
		super(srcImg);
	}
	
	float calcMagSetting(int pos) {
		return (float)pos/50;
	}
		
	String heading() {
		return "Saturation Level";
	}
	
	BufferedImage applyAdj(BufferedImage srcImage, float magSetting) {
		return ImageAnalysis.Saturation(srcImage, magSetting, null);
	}

}
