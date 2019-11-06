package com.robo.movement;

import com.robo.common.robotinterface.Robo;


public class RoboMovement implements Movement{

	@Override
	public boolean moveNorth(Robo mRobo, int step) {
		mRobo.setyCoordinate(mRobo.getyCoordinate()+step);
		return true;
	}

	@Override
	public boolean moveSouth(Robo mRobo, int step) {
		mRobo.setyCoordinate(mRobo.getyCoordinate()-step);
		return true;
	}

	@Override
	public boolean moveEast(Robo mRobo, int step) {

		mRobo.setxCoordinate(mRobo.getxCoordinate()+step);
		return true;
	}

	@Override
	public boolean moveWest(Robo mRobo, int step) {
		mRobo.setxCoordinate(mRobo.getxCoordinate()-step);
		return true;
	}
}
