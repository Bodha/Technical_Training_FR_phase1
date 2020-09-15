package com.lockedMe.main;

import com.lockedMe.file.File;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.lockedMe.actions.FileActions;
import com.lockedMe.actions.exe.*;
import com.lockedMe.exceptions.FileExceptions;

public class LockedMeMain {

	public static void main(String[] args){// throws FileExceptions {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int c;
		//File file = new File();
		FileActions action = new ActionExecution();
		
		do {
			c = 0;
			System.out.println("You are using LockedMe app\n");
			System.out.println("Developed by Deepak Bodh, a trainee of FR.");
			System.out.println("==================================");
			System.out.println("Select the option you want to proceed with");
			System.out.println("------------------------------------------------");
			System.out.println("1. Display the files in sorted manner");
			System.out.println("2. Perform add, delete or searching.");
			System.out.println("3. Exit the program");
			System.out.println("------------------------------------------------");
			System.out.println("Enter your choice");
			try{
				c = Integer.parseInt(s.nextLine());
			}catch(NumberFormatException e) {
//				System.out.println(e0.getMessage());
			}
			switch(c) {
			case 1:
				System.out.println("Following files currently exist in the folder\n");
				try{
					ActionExecution.displayFiles();
				} catch(FileExceptions e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				do{
					c = 0;
					System.out.println("----------------------------------------------");
					System.out.println("You can perform following operations");
					System.out.println("=========================================");
					System.out.println("1. Add a file");
					System.out.println("2. Search a file");
					System.out.println("3. Delete a file");
					System.out.println("4. Return to main menu");
					System.out.println("----------------------------");
					System.out.println("Enter your choice");
					try{
						c = Integer.parseInt(s.nextLine());
					}catch(NumberFormatException e) {
//						System.out.println(e0.getMessage());
					}
					switch(c) {
					case 1:
						System.out.println("You have chosen to add a new file");
						File file = new File();
						System.out.println("Name your file: ");
						file.setName(s.nextLine());
						System.out.println("Type of file: ");
						file.setType(s.nextLine());
						file.setTime_of_creation(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
						try{
							file = action.addFile(file);
							System.out.println("Added file has following details:\n "+file);
						}catch(FileExceptions e1) {
							System.out.println(e1.getMessage());
						}
//						try{
//							ActionExecution.displayFiles();
//						} catch(FileExceptions e) {
//							System.out.println(e.getMessage());
//						}
						break;
						
					case 2:
						System.out.println("You have chosen to search for a file");
						System.out.println("Enter file name: ");
						String fname = s.nextLine();
						try {
							if(!action.searchFile(fname)) {
								System.out.println(fname+" file not found, Check case");
							}
						} catch (FileExceptions e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
//						try{
//							ActionExecution.displayFiles();
//						} catch(FileExceptions e) {
//							System.out.println(e.getMessage());
//						}
						break;
						
					case 3:
						System.out.println("You have chosen to delete a file.");
						System.out.println("Enter File name: ");
						String fn = s.nextLine();
						try {
							action.deleteFile(fn);
						} catch (FileExceptions e3) {
							// TODO Auto-generated catch block
							System.out.println(e3.getMessage());
						}
//						try{
//							ActionExecution.displayFiles();
//						} catch(FileExceptions e) {
//							System.out.println(e.getMessage());
//						}
						break;
						
					case 4:
						System.out.println("Returning to main menu.....");
						break;
						
					default:
						System.out.println("Please enter a valid option from 1 to 4.");
						break;
					}
					
					System.out.println("=====================================================");
				}while(c!=4);
				break;
			
			case 3:
				System.out.println("Exiting LockedMe................");
				break;
				
			default:
				System.out.println("Please enter a valid option from 1 to 3");
				break;
			}
			
			
			
		System.out.println("===============================================================");
		}while(c!=3);
		
		s.close();
		System.out.println("Program has ended.");
		
	}

}
