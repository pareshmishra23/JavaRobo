package com.robo.visitablesimpl;

import com.robo.common.visitableinterface.Visitables;
import com.robo.common.visitorinterface.Visitor;
import com.robo.movingrobo.actions.MovingRoboAction;
import com.robo.userinterface.UserRequest;

public class XY_Point_Visitable implements Visitables{

	@Override
	public boolean accept(Visitor roboVisitor, UserRequest request)
	throws Exception 
	{
		return roboVisitor.visit(this, request);
	}

	@Override
	public boolean move(UserRequest request) {
		return MovingRoboAction.getInstance().moveToPoint(request.getGrid(), request.getRobo(), request.getX(), request.getY(), request.getDirection());
	}

}
