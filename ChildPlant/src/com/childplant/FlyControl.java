package com.childplant;

import java.util.ArrayList;

public interface FlyControl {
	public void FlyStart();
	
	public void FlyStop();
	
	public boolean FlyCatch();	

	public void setFlyLine(ArrayList<FlyPosition> flyLine);
	
	public void setCatchRegion(int left, int top, int right, int bottom);
}
