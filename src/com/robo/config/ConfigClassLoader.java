package com.robo.config;

import java.io.IOException;
import java.util.Properties;

import com.robo.common.enumconstants.RefConfigConstants;
import com.robo.common.grid.Coordinates;
import com.robo.common.grid.Grid;
import com.robo.common.gridinterface.BaseScale;
import com.robo.common.robotinterface.Robo;
import com.robo.common.visitableinterface.Visitables;
import com.robo.common.visitorinterface.Visitor;
import com.robo.userinterface.Handler;

public class ConfigClassLoader 
{
	private static Properties prop = null;
	public ConfigClassLoader() throws IOException {
		super();
		init(RefConfigConstants.CONFIG_FILE_PATH.toString());
	}

	private void init(String filePath) throws IOException {
		prop = new Properties();
		prop.load(ConfigClassLoader.class.getClassLoader().getResourceAsStream(filePath));
	}
	
	@SuppressWarnings("unchecked")
	public static Visitables getVisitables(RefConfigConstants constant) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return (Visitables)((Class<Visitables>) Class.forName(prop.getProperty(constant.toString()))).newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public static Robo getRobo(String clazzFullPath) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return (Robo)((Class<Robo>) Class.forName(prop.getProperty(clazzFullPath))).newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public static Grid getGrid(RefConfigConstants constant) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BaseScale xScale=(BaseScale)((Class<BaseScale>) Class.forName(prop.getProperty(constant.toString()))).newInstance();
		BaseScale yScale=(BaseScale)((Class<BaseScale>) Class.forName(prop.getProperty(constant.toString()))).newInstance();
		xScale.setHighPoint(getInteger(RefConfigConstants.X_SCALE_HIGHER));
		xScale.setLowerPoint(getInteger(RefConfigConstants.X_SCALE_LOWER));
		yScale.setHighPoint(getInteger(RefConfigConstants.Y_SCALE_HIGHER));
		yScale.setLowerPoint(getInteger(RefConfigConstants.Y_SCALE_LOWER));
		Coordinates coordinates=new Coordinates(xScale, yScale);
		Grid grid=new Grid(coordinates);
		return grid;
	}
	
	@SuppressWarnings("unchecked")
	public static Handler getHandler(RefConfigConstants constant) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		Handler handler=(Handler)((Class<Handler>) Class.forName(prop.getProperty(constant.toString()))).newInstance();
		return handler;
	}
	
	@SuppressWarnings("unchecked")
	public static Visitor getVisitor(RefConfigConstants constant) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		return (Visitor)((Class<Visitor>) Class.forName(prop.getProperty(constant.toString()))).newInstance();
	}
	
	public static Integer getInteger(RefConfigConstants constant)
	{
		String str=prop.getProperty(constant.toString());
		return Integer.valueOf(str);
	}
}