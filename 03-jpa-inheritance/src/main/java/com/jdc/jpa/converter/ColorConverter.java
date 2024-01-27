package com.jdc.jpa.converter;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.AttributeConverter;

public class ColorConverter implements AttributeConverter<Color, String>{

	@Override
	public String convertToDatabaseColumn(Color color) {
		return "%s,%s,%s".formatted(color.getRed(),color.getGreen(),color.getBlue());
	}

	@Override
	public Color convertToEntityAttribute(String str) {
		
		if(null != str && !str.isBlank()) {
			var strArray = str.split(",");
			return new Color(colorCode(strArray[0]), colorCode(strArray[0]), colorCode(strArray[0]));
		}
		
		return null;
	}

	private float colorCode(String string) {
		var biDecimal = new BigDecimal(string);
		return biDecimal.divide(new BigDecimal(255),16,RoundingMode.HALF_UP).floatValue();
	}

}
