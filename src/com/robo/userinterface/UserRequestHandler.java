package com.robo.userinterface;

import com.robo.common.enumconstants.Command;
import com.robo.common.enumconstants.RefConfigConstants;
import com.robo.common.visitableinterface.Visitables;
import com.robo.common.visitorinterface.Visitor;
import com.robo.config.ConfigClassLoader;

public class UserRequestHandler implements Handler
{
	@Override
	public boolean move(UserRequest request) throws Exception
	{
		Command command=request.getCommand();
		Visitor visitor=null;
		Visitables visitable=null;
		 switch (command) 
		   {
			    case PLACE:
				     visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
				     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.XY_POINT_VISITABLE);
				     break;
			    case MOVE:
			    	visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
				     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.MOVE_VISITABLE);
				     break;
			    case LEFT:
			    	visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
				     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.LEFT_VISITABLE);
				     break;
			    case RIGHT:
			    	visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
				     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.RIGHT_VISITABLE);
				     break;
			    case REPORT:
			    	visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
				     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.REPORT);
				     break;
			    default:
			    	 break;
			}
		 
		return visitable.accept(visitor, request);
	}
}
