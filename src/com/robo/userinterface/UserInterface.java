package com.robo.userinterface;

import java.io.IOException;
import java.util.Scanner;

import com.robo.common.enumconstants.Command;
import com.robo.common.enumconstants.Direction;
import com.robo.common.enumconstants.RefConfigConstants;
import com.robo.common.grid.Grid;
import com.robo.common.robotinterface.Robo;
import com.robo.common.visitableinterface.Visitables;
import com.robo.common.visitorinterface.Visitor;
import com.robo.config.ConfigClassLoader;
import com.robo.utils.RoboUtils;
import com.robo.utils.UtilValidator;

public class UserInterface 
{
	private Grid grid=null;
	private Scanner scan=null;
	 public UserInterface() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		super();
		init();
	}

	private void init() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		new ConfigClassLoader();
		grid=ConfigClassLoader.getGrid(RefConfigConstants.SCALE);
		scan=new Scanner(System.in);
	}
	
	public static void main(String[] args) throws Exception {
		UserInterface uInterface=new UserInterface();
		Robo robo=ConfigClassLoader.getRobo(RefConfigConstants.ROBO.toString());
		String uCommand=uInterface.getUserCommand();
		//Handler handler=ConfigClassLoader.getHandler(RefConfigConstants.REQUEST_HANDLER);
		Visitor visitor=null;
		Visitables visitable=null;
		boolean isFirstCommandExecuted=false;
		boolean result=false;
		UserRequest request=null;
		 while(!"exit".equalsIgnoreCase(uCommand))
		  {
			 if(UtilValidator.validateCommand(uCommand))
			 {
				 Command command=RoboUtils.getCommand(uCommand);
				   request=new UserRequest();
				   request.setRobo(robo);
				   request.setGrid(uInterface.grid);
				   switch (command) 
				   {
					    case PLACE:
						     Object[] ojArr=RoboUtils.getCommandArray(uCommand);
						     request.setX((Integer)ojArr[0]);request.setY((Integer)ojArr[1]);request.setDirection((Direction)ojArr[2]);
						     visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
						     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.XY_POINT_VISITABLE);
						     break;
					    case MOVE:
						     request.setCommand(command);request.setNoOfStep(1);
						     visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
						     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.MOVE_VISITABLE);
						     break;
					    case LEFT:
					    	 request.setCommand(command);
					    	 visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
						     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.LEFT_VISITABLE);
						     break;
					    case RIGHT:
					    	 request.setCommand(command);
					    	 visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
						     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.RIGHT_VISITABLE);
						     break;
					    case REPORT:
					    	 request.setCommand(command);
					    	 visitor=ConfigClassLoader.getVisitor(RefConfigConstants.VISITOR);
						     visitable=ConfigClassLoader.getVisitables(RefConfigConstants.REPORT);
						     break;
					    default:
					    	 break;
					}
				   if(visitor !=null && visitable!=null && (Command.PLACE.equals(command) || isFirstCommandExecuted)){
					   result=visitable.accept(visitor, request);   
				   }
				   if(!isFirstCommandExecuted && result)
				   {
					   isFirstCommandExecuted=true; 
				   }
					   
			 }
			 uCommand=uInterface.getUserCommand();
		  } 
		
	}
	
	 public String getUserCommand()
	 {
		 return scan.nextLine();
	 }
	 
	 public void displayInstruction()
	 {
		 System.out.println(" Enter PLACE X,Y,D   where X,Y is coordinates and D is direction as EAST,WEST,NORTH,SOUTH  (Ex: PLACE 0,0,NORTH)");
	 }
}
