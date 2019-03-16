package com.toy.robot.robot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@ShellCommandGroup("Robot Commands")
public class RobotCommands implements CommandLineRunner{
	
	String result[];
	boolean isPlaceExecute = false;

	@ShellMethod(value = "initiate place position")
	public void PLACE(String place) {
		result = place.split(",");
		isPlaceExecute = true;
	}
	
	@ShellMethod("MOVE will move the toy robot one unit forward in the direction it is currently facing")
	public void MOVE() {
		if(isPlaceExecute) {
			String direction = result[2];
			if("NORTH".equalsIgnoreCase(direction)) {
				int Y = Integer.parseInt(result[1]);
				int moveY = (Y + 1);
				if(moveY > 5) {
					System.out.println("Movement commands not allowed");
				}else {
					result[1] = String.valueOf(moveY);
				}
				
			}else if("SOUTH".equalsIgnoreCase(direction)) {
				int Y = Integer.parseInt(result[1]);
				int moveY = (Y - 1);
				if(moveY < 0) {
					System.out.println("Movement commands not allowed");
				}else {
					result[1] = String.valueOf(moveY);
				}
				
			}else if("EAST".equalsIgnoreCase(direction)) {
				int X = Integer.parseInt(result[0]);
				int moveX = (X + 1);
				if(moveX > 5) {
					System.out.println("Movement commands not allowed");
				}else {
					result[0] = String.valueOf(moveX);
				}
				
			}else if("WEST".equalsIgnoreCase(direction)) {
				int X = Integer.parseInt(result[0]);
				int moveX = (X - 1);
				if(moveX < 0) {
					System.out.println("Movement commands not allowed");
				}else {
					result[0] = String.valueOf(moveX);
				}
				
			}
		}else {
			System.out.println("The first valid command to the robot is a PLACE command");
		}
		
		
	}
	
	@ShellMethod("LEFT will rotate the robot 90 degrees in the specified direction without changing the position of the robot")
	public void LEFT() {
		
		if(isPlaceExecute) {
			String direction = result[2];
			if("NORTH".equalsIgnoreCase(direction)) {
				result[2] = "WEST";
				
			}else if("SOUTH".equalsIgnoreCase(direction)) {
				result[2] = "EAST";
				
			}else if("EAST".equalsIgnoreCase(direction)) {
				result[2] = "NORTH";
				
			}else if("WEST".equalsIgnoreCase(direction)) {
				result[2] = "SOUTH";
				
			}
		}else {
			System.out.println("The first valid command to the robot is a PLACE command");
		}
		
		
	}
	
	@ShellMethod("RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot")
	public void RIGHT() {
		
		if(isPlaceExecute) {
			String direction = result[2];
			if("NORTH".equalsIgnoreCase(direction)) {
				result[2] = "EAST";
				
			}else if("SOUTH".equalsIgnoreCase(direction)) {
				result[2] = "WEST";
				
			}else if("EAST".equalsIgnoreCase(direction)) {
				result[2] = "SOUTH";
				
			}else if("WEST".equalsIgnoreCase(direction)) {
				result[2] = "NORTH";
				
			}
		}else {
			System.out.println("The first valid command to the robot is a PLACE command");
		}

		
	}
	
	@ShellMethod("REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient")
	public String REPORT() {
		String reportResult = "";
		
		if(isPlaceExecute) {
			reportResult = result[0]+","+result[1]+","+result[2];
			
		}else {
			reportResult = "The first valid command to the robot is a PLACE command";
		}
		
		return reportResult;
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
