package com.robo.visitorimpl;

import com.robo.common.visitableinterface.Visitables;
import com.robo.common.visitorinterface.Visitor;
import com.robo.userinterface.UserRequest;

public class RoboVisitor implements Visitor{

	@Override
	public boolean visit(Visitables vistable, UserRequest request)
			throws Exception 
	{
		return vistable.move(request);
	}
}
