/** -----------------------------------------------------
*Assignment 3 Bibliography Creator
*Question: 3-7
*Written by: Shereece A.A. Victor 40105094
*-----------------------------------------------------
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * AuthorBibCreator Class
 *
 * Creates Bibliography files with IEEE, ACM and NJ formats from bib files input
 *
 */
public class AuthorBibCreator {

	/**
	 * Preprocess method
	 *
	 * Prepares the appropiate file to be outputted to
	 *
	 * @param aname The last name of the author being queried
	 * @return File[3] An array of 3 open output files
	 */
	public static File[] preprocess(String aname) {

		//Naming the files according to format
		/**
		 * Array of file names to be used
		 */
		String[] file = new String[3];

		file[0] = (aname + "-IEEE.json");
		file[1] = (aname + "-ACM.json");
		file[2] = (aname + "-NJ.json");

		/**
		 * Array of files created with the file names above
		 */
		File[] output = new File[3];

		/**
		 * The back up file to be used if a new version of a file is created
		 */
		File bu=null; //Holds the back up file when created

		//Loop to process a file for each bib format
		for (int i = 0; i < 3; i++) {

			output[i] = new File(file[i]);//Attaches the appropriate file to each index in the array

			try {

				if (output[i].exists()) {
					throw new FileExistsException();
				}
			}
			catch (FileExistsException e) {

				System.out.print("A file already exists with the name: "+output[i]+".\n");

				File replace=null;//Holds back up file to be replaced

				switch (i) {
					case (0):
						replace = new File(aname + "-IEEE-BU.json");
						file[i] = (aname + "-IEEE-BU.json");
						break;
					case (1):
						replace = new File(aname + "-ACM-BU.json");
						file[i] = (aname + "-ACM-BU.json");
						break;
					case (2):
						replace = new File(aname + "-NJ-BU.json");
						file[i] = (aname + "-NJ-BU.json");
						break;
				}

				if (replace.exists()) {//If back up file exists
					replace.delete();//Deletes existing back up file

					try {
						bu = new File(file[i]);
						output[i].renameTo(bu); //Renames existing file to a back up file
					} catch (Exception e1) {
						//No action
					}

				}//end if bu file exists
				else{ //if only original file exists
					try {
						bu = new File(file[i]);
						output[i].renameTo(bu);//Renames existing file to a back up file
					} catch (Exception e1) {
						//No action
					}
				}
				System.out.print("It will be renamed as: "+ bu +" and any old BUs will be deleted.\n");

			}//end catch block


		}//end for loop

		return output;//Returns an array of new format specific files o be used
	}

	/**
	 * ProcessBibFiles method
	 *
	 * Accepts 10 open  files, searches them for articles with a specific author name
	 * and outputs to the files passed in.
	 *
	 * @param aname The last name of the author being queried
	 * @param s An array of Scanners to access the open input files
	 * @param a An array of Article classes to store extracted data
	 * @param output An array of output files
	 */
	public static void processBibFiles(String aname, Scanner[] s, Article []a, File [] output){


	String data;//Temporary holder for read in data
	String check="empty"; //String used to check for the correct author name
	String name;//Stores the unchanged author name as entered by the user
		name=aname;
	int count=0;//Stores a count of the number of article records created
	a[count]=new Article();


	for(int count1=1; count1<11; count1++){ //Loops through each of the 10 files

		try{

			while (s[count1].hasNext()){ //Loops while the file has articles

				data= s[count1].nextLine();

					while (!data.equals("}")){ //Loops through each article within a file

			
						if(data.contains("author") ){ //Selects and reads from 'author' tag

							data= data.substring(8, data.length()-3);
							check = data; //stores the author line for later check
							String [] a_input = data.split("and ");//Selects and stores each name separately
							a[count].setAuthors(a_input);

						}
		
						if(data.contains("journal")){ //Selects and reads from 'journal' tag
							a[count].setJournal(data.substring(9, data.length()-3));

						}
		
						if(data.contains("title")) { //Selects and reads from 'title' tag
							a[count].setTitle(data.substring(7, data.length() - 3));

						}

						if(data.contains("month")){ //Selects and reads from 'month' tag
							a[count].setMonth(data.substring(7, data.length()-2));

						}

						if(data.contains("year")){ //Selects and reads from 'year' tag
							a[count].setYear(data.substring(6, data.length()-3));

						}

						if(data.contains("volume")){ //Selects and reads from 'volume' tag
							a[count].setVolume(data.substring(8, data.length()-3));

						}

						if(data.contains("number")){ //Selects and reads from 'number' tag
							a[count].setNumber(data.substring(8, data.length()-3));

						}

						if(data.contains("pages")){ //Selects and reads from 'pages' tag
							a[count].setPages(data.substring(7, data.length()-3));

						}

						if(data.contains("doi")){ //Selects and reads from 'doi' tag
							a[count].setDoi(data.substring(5, data.length()-3));

						}

						data = s[count1].nextLine();

					} //end while: article loop


			/*
				Stores only the articles with the name queried in the array to be printed
			*/
				if (!aname.equalsIgnoreCase("and")){ //Ensures that "and" isn't processed as a name
				/*	Converting both strings to lowercase to cater for badly formatted
					data and entries by the user
				*/
					check = check.toLowerCase();
					aname = aname.toLowerCase();

				if(check.contains(aname)  ){ //To ensure only Articles with the queried name are stored
					count++;

					if (s[count1].hasNext()) { //Prevents a new Article from being created at the end of input
						a[count] = new Article();
					}
				}
				}

		
			}//end while : file loop
			}//try block
	
			catch(Exception e){
				//No action
			}
	} // end for : 10 file loop

		//If the author is not found do the following:
		if (count==0){
			System.out.println("No records were found for author(s) with name: "+ name+
							"\nNo files have been created!\n");
		}

	if (count>0) { //Ensures that output is only generated when necessary
		PrintWriter[] out = new PrintWriter[3]; //Enables output to 3 files

		try {
			//Printing IEEE format to file
			out[0] = new PrintWriter(output[0]);
			for (int i = 0; i < count; i++)
				out[0].write(a[i].printIEEE());

			//Printing ACM format to file
			out[1] = new PrintWriter(output[1]);
			for (int i = 0; i < count; i++)
				out[1].write(a[i].printACM());

			//Printing NJ format to file
			out[2] = new PrintWriter(output[2]);
			for (int i = 0; i < count; i++)
				out[2].write(a[i].printNJ());

			System.out.print("A total of " + count + " records were found for author(s) with name: " + name + ".\n"
					+ "Files " + output[0] + ", " + output[1] + ", " + output[2] + " have been created!\n");

		} catch (FileNotFoundException e) {

			for (int y = 0; y < 3; y++) { //Prints which file is unable to write
				if (!output[y].canWrite())
					System.out.print("Unable to write to " + output[y] + ".\n");
			}

			for (int y = 0; y < 3; y++) { //Deletes all output files if any cannot be written to
				output[0].delete();
			}

		}//end catch block

		//Closing PrintWriters
		out[0].close();
		out[1].close();
		out[2].close();
	}

	}//end process bib method
	
	public static void main(String[] args) {
		System.out.println("Welcome to BibCreator!\n");
		
		Article[]articles = new Article[20];//Assuming no more than 20 articles would be found
		
		System.out.print("Please enter author you are targeting:");
		String aname = new Scanner(System.in).nextLine(); //Stores the author name being queried

		String filename= null;

		int count = 1;
		
		Scanner[] input =new Scanner[11];//Holds the scanners for all 10 files
		
		//Opening 10 files for reading 
		for(int i=1; i<11; i++){
			filename = "Latex" +i+".bib";
			
			try{
		
				input[i] = new Scanner( new FileInputStream(filename));
			
			}
			catch( FileNotFoundException e ){
				System.out.print("Could not open input file " + filename + " for reading."+
					" Please check if file exists! Program will terminate after closing any opened files.\n");
		
				for (int c=1; c<=count; c++){
					try {
						input[c].close();
					}
					catch (NullPointerException e3){
						System.out.println("Oof, nothing to delete here. Next!\n");
					}
				}
				System.out.print("\nFiles closed.\nSystem Terminated.");
				System.exit(1);
		
			}
			count++;
		}//end for loop

		File [] output = preprocess(aname);
		processBibFiles(aname,input, articles, output);
		
		//Closing all 10 files 
		for(int i=1; i<11; i++){
			try{

				input[i].close();
			
			}
			catch(Exception e){
				//No action
			}
		}

		System.out.println("Goodbye! Hope you have enjoyed creating needed files using AuthorBibCreator.\n");

}//end main


}