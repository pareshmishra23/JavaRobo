package com.robo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robo.common.enumconstants.Command;
import com.robo.common.enumconstants.Direction;

public class UtilValidator {
 
 public static boolean validateCommand(String command)
 {
	  boolean isValid=false;
	  String[] splitCommand=command.split("\\s");
	  try{
		  if(splitCommand.length==2 || splitCommand.length==1)
		  {
			   Command opted=Command.valueOf(splitCommand[0]);
			   if(opted!=null && opted.equals(Command.PLACE) && splitCommand.length==2)
			   {
			    String[] arrayPlace=splitCommand[1].split(",");
			    if(arrayPlace.length==3 && validateCommand("[+-]?\\d",arrayPlace[0]) && validateCommand("[+-]?\\d",arrayPlace[1]) &&  Direction.valueOf(arrayPlace[2])!=null)
			    {
			     isValid=true;
			    }
			    
			   } else if(opted != null && splitCommand.length==1 && !opted.equals(Command.PLACE)) {
			    isValid=true;
			   }
		  }
		  } catch(IllegalArgumentException exception){
	   
	  }
	  return isValid;
 }
	 public static boolean validateCommand(String comPattern,String command)
	 {
		  boolean isValid=false;
		  Pattern pattern=Pattern.compile(comPattern);
		  Matcher match=pattern.matcher(command);
		  if(match.matches())
		  {
		   isValid=true;
		  }
		  return isValid;
	 }
}
