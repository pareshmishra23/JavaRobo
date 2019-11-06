package com.robo.utils;

import com.robo.common.enumconstants.Command;
import com.robo.common.enumconstants.Direction;

public class RoboUtils 
{
	 public static Command getCommand(String string)
	 {
		 return Command.valueOf(string.split("\\s")[0]);
	 }
	 
	 public static Object[] getCommandArray(String roboCoordinates) 
	 {
		  Object[] objects=null;
		  String[] str=roboCoordinates.split(",");
		  Direction direction = null;
		  if(Direction.EAST.toString().equals(str[2])){
		   direction=Direction.EAST;
		   
		  }else if(Direction.WEST.toString().equals(str[2])){
		   direction=Direction.WEST;
		   
		  }else if(Direction.SOUTH.toString().equals(str[2])){
		   direction=Direction.SOUTH;
		   
		  }else if(Direction.NORTH.toString().equals(str[2])){
		   
		   direction=Direction.NORTH;
		  }
		  objects= new Object[str.length];
		  objects[0]= Integer.parseInt(str[0].replace("PLACE ",""));
		  objects[1]= Integer.parseInt(str[1]);
		  objects[2]= direction;
		  return objects;
	 }
}
