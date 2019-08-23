package com.wipro.MongoGamification;

public class Rules {
	
	private String mName;
	private int reward;
	public Rules(String mName, int reward) {
		super();
		this.mName = mName;
		this.reward = reward;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}

}
