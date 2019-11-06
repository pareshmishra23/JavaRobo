package com.robo.common.enumconstants;

public enum RefConfigConstants {LEFT_VISITABLE("left_clazz"),
								RIGHT_VISITABLE("right_clazz"),
								MOVE_VISITABLE("move_clazz"),
								XY_POINT_VISITABLE("xypoint_clazz"),
								REPORT("report_clazz"),
								VISITOR("visitor_clazz"),
								X_SCALE_HIGHER("x_scale_higher"),
								X_SCALE_LOWER("x_scale_lower"),
								Y_SCALE_HIGHER("y_scale_higher"),
								Y_SCALE_LOWER("y_scale_lower"),
								SCALE("scale_clazz"),
								ROBO("robo_clazz"),
								CONFIG_FILE_PATH("com/robo/resources/config.properties");
							private String name=null;
							private RefConfigConstants(String name)
							{
								this.name=name;
							}
							public String toString()
							{
								return this.name;
							}
							}
