package com.robo.common.visitorinterface;

import com.robo.common.visitableinterface.Visitables;
import com.robo.userinterface.UserRequest;

public interface Visitor {
	public abstract boolean visit(Visitables gridVisitables,UserRequest request)  throws Exception;
}
