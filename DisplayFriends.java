/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package displayfriends;

// Java program to read from file "friendsContact.txt"
// and display the contacts

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.NumberFormatException;

class DisplayFriends {

	public static void main(String data[])
	{	
                try {
                    
			String nameNumberString;
			String name;
                        String newName = "juliana";
			long number;
			int index;

			// Using file pointer creating the file.
			File file = new File("C:\\Users\\Daniela Arbelaez\\OneDrive\\Documentos\\NetBeansProjects\\AddFriend\\friendsContact.txt");

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			// Traversing the file
			// getFilePointer() give the current offset
			// value from start of the file.
			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				nameNumberString = raf.readLine();

				// splitting the string to get name and
				// number
				String[] lineSplit = nameNumberString.split("!");

				// separating name and number.
				name = lineSplit[0];
				number = Long.parseLong(lineSplit[1]);
                                
                                if (name.equals(newName)){
                                    // // Print the contact data
                                    System.out.println("Friend Name: " + name + "\n"+ "Contact Number: " + number + "\n");
                                    found = true;
                                    break; // No need to continue checking if the name is found
                                }     
                        	                                          
                }
                        if (!found){
                        System.out.println("There's no record with the name " + newName);
                        }
                }
                
			catch (IOException ioe){
				System.out.println(ioe);
			}
			catch (NumberFormatException nef){
				System.out.println(nef);
			}
		}
	}

