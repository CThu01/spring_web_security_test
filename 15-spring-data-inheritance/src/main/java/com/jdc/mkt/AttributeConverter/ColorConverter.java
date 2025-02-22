package com.jdc.mkt.AttributeConverter;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.AttributeConverter;

public class ColorConverter implements AttributeConverter<Color, String>{

	@Override
	public String convertToDatabaseColumn(Color obj) {
		// TODO Auto-generated method stub
		
		return obj != null ? 
				"%s,%s,%s".formatted(obj.getRed(),obj.getGreen(),obj.getBlue()) 
				: null;
	}

	@Override
	public Color convertToEntityAttribute(String str) {
		var array = str.split(",");
		return str != null ? 
				new Color(
						getColorValue(array[0]),
						getColorValue(array[1]),
						getColorValue(array[2]))
					: null;
	}
	
	private float getColorValue(String str) {
		var divisor = Float.parseFloat(str);
		return divisor/255;
		
//		var divisor = new BigDecimal(255);
//		var color = new BigDecimal(str);
//		return color.divide(divisor,12,RoundingMode.HALF_UP).floatValue();
	}

}
