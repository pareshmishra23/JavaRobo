package com.robo.common.visitableinterface;

import com.robo.common.visitorinterface.Visitor;
import com.robo.userinterface.UserRequest;

public interface Visitables {
 
	public boolean accept(Visitor roboVisitor,UserRequest request)throws Exception;
	public boolean move(UserRequest request);
}
