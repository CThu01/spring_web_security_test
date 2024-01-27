package com.jdc.cthu.entity.projection;

import com.jdc.cthu.entity.State.Type;

public interface StateDtoInf {

	int getId();
	String getName();
	Type getType();
//	String getRegion();
//	String getCapital();
//	int getPorpulation();
	
	default String getDisplayName() {
		return "%s : %s".formatted(getName(),getType());
	}
	
}
