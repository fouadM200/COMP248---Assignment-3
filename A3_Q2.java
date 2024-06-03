// -------------------------------------------------------------------------
// Assignment 3
// Written by: Fouad Meida 40249310
// For COMP 248 Section EC - Fall 2022

/* This Simple Electronic Voting System (SEVS) program aims to serve the electoral manager to compute the votes' number of every candidate of an electoral
 * campaign. The electoral manager will input candidates' id following by their names. Then, a menu window will be displayed to the electoral manager, which
 * possesses many capabilities defined by description codes.*/

// Import keyboard from java.util.Scanner.
import java.util.Scanner;
public class A3_Q2
{
	public static void main(String[] args)
	{
		// Display a welcome message.
		System.out.println("Welcome to the Simple Electronic Voting System (SEVS):");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// Prompt the user to enter all candidates' particulars in the form {id_1},{name_1};{id_2},{name_2};...
		System.out.println("\nPlease enter a String collection of electoral candidates below:");
		// Define a scanner object.
		Scanner keyboard = new Scanner(System.in);
		/* Create a 1D String array which contains the user's input. Adding to that, eliminate the unwanted spaces using the method .trim(). Then, split 
		 * every two words separated by a semicolon or a comma in the String using the method .split(). Consequently, every word will be considered
		 * as an element.*/
		String[] candidatesInput = keyboard.nextLine().trim().split(";|,");
		// Create a 1D array for candidates' ID with a size of the half of the elements' number in candidatesInput string array.
		String[] id = new String [(candidatesInput.length)/2];
		// Create a 1D array for candidates' names with a size of the half of the elements' number in candidatesInput string array.
		String[] names = new String [(candidatesInput.length)/2];
		// Create a 1D array for candidates' votes with a size of the half of the elements' number in candidatesInput string array.
		int[] votes = new int [(candidatesInput.length)/2];
		// Store the input of candidates' IDs in the 1D id String array using for loop.
		for (int i=0; i<candidatesInput.length; i+=2)
			id [i/2] = candidatesInput[i].trim();
		// Store the input of candidates' names in the 1D names String array using for loop.
		for (int j=1; j<candidatesInput.length; j+=2)
			names [j/2] = candidatesInput[j].trim();
		// Create three temporary arrays for candidates' ID, names and number of votes and initialize them to null (these arrays will be used later).
		String[] temp_id = null;
		String[] temp_names = null;
		int[] temp_votes = null;
		// Create three new arrays for candidates' ID, names and number of votes and initialize them to null (these arrays will be used later).
		String [] new_id = null;
		String [] new_names = null;
		int [] new_votes = null;
		// Display the codes with their following description.
		System.out.println("********************************");
		System.out.println("| Code >> Description          |");
		System.out.println("********************************");
		System.out.println("|  1   >> Display candidates   |");
		System.out.println("|  2   >> Vote a candidate     |");
		System.out.println("|  3   >> Add new candidate(s) |");
		System.out.println("|  4   >> Display results      |");
		System.out.println("|  0   >> End SEVS             |");
		System.out.println("********************************");
		// Prompt the user to input a description code.
		System.out.print("\nEnter a code, from the aforementioned, that corresponds to your task: ");
		/* Create a while loop and initialize the condition to be always true so the user can return to the main menu after executing a specific task based
		 * on his description code input. */ 
		while(true)
		{
			// Define a String variable so it can be used to store the entered description code.
			String code = keyboard.next();
			// Create a switch statement and compare the code variable to the following cases.
			switch(code)
			{
			// If the code variable equals to the case "0", execute the following task:
			case "0":
				{
					// Kindly terminate the execution of SEVS with a compliment close message.
					System.out.println("\nThank you for using our Simple Electronic Voting System (SEVS).");
					System.exit(0);
					// Close the keyboard.
					keyboard.close();
				}
			// If the code variable equals to the case "1", execute the following tasks:
			case "1":
				{
					// Display a complete list of all eligible candidates.
					System.out.println("****************************************");
					System.out.println("| ID >> Candidates's Name              |");	
					System.out.println("****************************************");
					/* Use a for loop to display the eligible candidates using id and names arrays and print the same sentence form with respect
					 * of the value k and the corresponding index of element in id and names String arrays.*/
					for (int k=0; (k<id.length)&&(k<names.length); k++)
					{
						// Display candidates names in capital letters using the method .toUpperCase();
						names[k]=names[k].toUpperCase();
						System.out.println("| "+id[k]+" >> "+names[k]+"\t\t       |");	
					}
					System.out.println("****************************************");
					// Prompt the user to enter another valid description code which corresponds to the wanted task to be executed.
					System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
					// Use break to get out from the switch statement.
					break;
				}
			// If the code variable equals to the case "2", execute the following tasks:
			case "2":
				{
					// Prompt the user to enter the ID of the candidate s/he wishes to vote for by creating a String variable called numID to store the user's input.
					System.out.print("\nPlease enter the ID of the candidate you wish to vote for: ");
					String numID = keyboard.next();
					// Use a for loop to compare every element of the id array with the numID variable using an if statement.
					for (int t=0; t<id.length; t++)
						/* If the numID String variable equals to the index of the chosen element (t) in the id String array with respect of the value of t,
						 * then execute the following tasks: */
						if (numID.equals(id[t]))
						{
							/* Take the index of the element in the votes integer array with respect of the value of t, increment the corresponding element by one
							 * and store the result in the same index of the element in the votes integer array.*/
							votes[t]= votes[t]+1;
							/* Display a message to confirm that user's ballot has been successfully casted for the candidate s/he wishes to vote for with the 
							 * corresponding index of the element in the names and id String arrays with respect of the value of t. */
							System.out.println("Your ballot has been successfully casted for: "+names[t]+" bearing Candidate ID: "+id[t]);
						}
					// Prompt the user to enter another valid description code which corresponds to the wanted task to be executed.
					System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
					// Use break to get out from the switch statement.
					break;
				}
			// If the code variable equals to the case "3", execute the following tasks:
			case "3":
				{
					/* Prompt the electoral manager to enter a string/text input comprising a collection of all the new candidates' particulars that should be 
					 * appended to the already existing list of eligible candidates. */
					System.out.println("\nPlease enter a string collection of the NEW electoral candidates below:");
					keyboard.nextLine();
					/* Create a 1D temporary String array which contains the user's input of the new candidates' names and their ID's. Adding to that, eliminate the unwanted  
					 * spaces using the method .trim(). Then, split every two words separated by either a semicolon or a comma in the String using .split(). Consequently, 
					 * every word will be considered as an element.*/
					String[] temp_candidatesInput = keyboard.nextLine().trim().split(";|,");
					/* Define the size of the three 1D temporary arrays for the new candidates' ID, their names and the number of their votes to be the half of
					 * the elements' number in temp_candidatesInput string array.*/
					temp_id = new String [(temp_candidatesInput.length)/2];
					temp_names = new String [(temp_candidatesInput.length)/2];
					temp_votes = new int [(temp_candidatesInput.length)/2];
					// Store the input of the added candidates' IDs in the 1D temp_id String array using for loop.
					for (int m=0; m<temp_candidatesInput.length; m+=2)
						temp_id [m/2] = temp_candidatesInput[m].trim().toUpperCase(); // Display candidates names in capital letters using the method .toUpperCase();
					// Store the input of the added candidates' names in 1D temp_names array using for loop.
					for (int n=1; n<temp_candidatesInput.length; n+=2)
						temp_names [n/2] = temp_candidatesInput[n].trim().toUpperCase(); // Display candidates names in capital letters using the method .toUpperCase();
					/* Set three new predefined arrays to combine the original arrays of each type to their corresponding temporary arrays with a size of the total
					number of elements in the two combined arrays. */
					new_id = new String [id.length+temp_id.length];
					new_names = new String [names.length+temp_names.length];
					new_votes = new int [votes.length+temp_votes.length];
					// Store every element from the three original arrays in the 1D new_id, new_names and new_votes arrays using for loop with respect of the value of a.
					for (int a=0; a<names.length; a++)
						{
						new_id[a]=id[a];
						new_names[a]=names[a].toUpperCase();
						new_votes[a]=votes[a];
						}
					// Store every element from the three temporary arrays in the 1D new_id, new_names and new_votes arrays using for loop with respect of the value of b and c.
					for (int b=names.length, c=0; b<new_names.length; b++, c++)
						{
						new_id[b]=temp_id[c];
						new_names[b]=temp_names[c];
						new_votes[b]=temp_votes[c];
						}
					// Store the three new arrays in the original ones:
					id=new_id;
					names=new_names;
					votes=new_votes;
					// Display a message to the electoral manager to confirm the add a new set of electoral candidates to the SEVS.
					System.out.println("Successfully added a NEW set of electoral candidates to the Simple Electronic Voting System (SEVS).");
					// Prompt the user to enter another valid description code which corresponds to the wanted task to be executed.
					System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
					// Use break to get out from the switch statement.
					break;
				}
			// If the code variable equals to the case "4", execute the following tasks:
			case "4":
				{
					// Sort the three arrays (id, names and votes) based on the descending order of votes array using nested for loop with and if statement.
					/* Set the starting value of i as the last index of element of the votes array in the outer loop and the starting value of j as the
					 * second last element of the votes array in the inner loop. */
					for (int i=(votes.length-1); i>=0; i--)
						for (int j=i-1; j>=0; j--)
						{
							// Define two temporary string variables and a temporary integer variable. They will be used in the swapping procedure.
							int temp1;
							String temp2, temp3;
							/* If the stored value in the last element of the votes array is greater than the value of the second last element, then
							 * swap the content of the variables votes[i] and votes[j] using a temporary integer variable called temp1.*/
							if (votes[i]>votes[j])
							{
								temp1=votes[i];
								votes[i]=votes[j];
								votes[j]=temp1;
							 /* Based on the swapped values in votes array, swap again the content of the variables names[i] and names[j] using a temporary
							  * String variable called temp2.*/
								temp2=names[i];
								names[i]=names[j];
								names[j]=temp2;
							 /* Based on the swapped values in votes array, swap again the content of the variables id[i] and id[j] using a temporary
						      * String variable called temp3.*/
								temp3=id[i];
								id[i]=id[j];
								id[j]=temp3;
							}
						}
					// Print the results.
					System.out.println("******************************************************************");
					System.out.println("| Position | Votes/Ballots | ID | Candidate's Name               |");
					System.out.println("******************************************************************");
					/* Set an integer variable r to 0 so we can print the first result using this variable to display the first element of id, names and votes
					 * sorted arrays with the position 1. */
					int r=0;
					System.out.println("|\t "+(r+1)+" |\t\t "+votes[r]+" | "+id[r]+" | "+names[r]+"\t\t\t |");
					/* Use a for loop to display the remained results and set the integer variable p as the index of element of the three arrays and the integer
					 * variable of q as the position of a candidate. */
					for (int p=1, q=1; p<votes.length; p++)
					{
						/* If the stored values in the first and the second element of the votes array are equivalent, then we keep the value of the position (q) 
						 * and we print the following sentence. */
						if (votes[p]==votes[p-1])
						{
							System.out.println("|\t "+q+" |\t\t "+votes[p]+" | "+id[p]+" | "+names[p]+"\t\t\t |");
						}
						/* If the stored values in the first and the second element of the votes array are not equivalent, then we increment the position (q) by one
						 * and we print the following sentence. */
						else
						{
							q++;
							System.out.println("|\t "+q+" |\t\t "+votes[p]+" | "+id[p]+" | "+names[p]+"\t\t\t |");
						}
					}
					System.out.println("******************************************************************");
					// Prompt the user to enter another valid description code which corresponds to the wanted task to be executed.
					System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
					// Use break to get out from the switch statement.
					break;
				}
			// If the code variable is not equal to any of the above mentioned cases, execute the following task:
			default:
				{
					// Prompt the user to enter another valid description code which corresponds to the wanted task to be executed.
					System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
					// Use break to get out from the switch statement.
					break;
				}
			}
		}
	}
}