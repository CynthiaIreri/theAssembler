package Assembler;
//Author info here
//TODO: don't forget to document each method in all classes!
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Assembler {
	
	// ALGORITHM:
	// get input file name
	// create output file name and stream
	
	// create symbol table
	// do first pass to build symbol table (no output yet!)
	// do second pass to output translated ASM to HACK code
	
	// print out "done" message to user
	// close output file stream
	public static void main(String[] args) {
		
		String inputFileName, outputFileName;
		PrintWriter outputFile = null; //keep compiler happy
		SymbolTable symbolTable;
		int romAddress, ramAddress;
	
		//get input file name from command line or console input
		if(args.length == 1) {
			System.out.println("command line arg = " + args[0]);
			inputFileName = args[0];
		}
		else
		{
			Scanner keyboard = new Scanner(System.in);

			System.out.println("Please enter assembly file name you would like to assemble.");
			System.out.println("Don't forget the .asm extension: ");
			inputFileName = keyboard.nextLine();
					
			keyboard.close();
		}
		
		outputFileName = inputFileName.substring(0,inputFileName.lastIndexOf('.')) + ".hack";
							
		try {
			outputFile = new PrintWriter(new FileOutputStream(outputFileName));
		} catch (FileNotFoundException ex) {
			System.err.println("Could not open output file " + outputFileName);
			System.err.println("Run program again, make sure you have write permissions, etc.");
			System.exit(0);
		}
		
		// TODO: finish driver as algorithm describes
		////create output file name and stream 
		
		//create symbolTable 
		
	}
	//create output file name and stream
	Parser test= new Parser ("add.asm");
	
	
	// TODO: march through the source code without generating any code
		//for each label declaration (LABEL) that appears in the source code,
		// add the pair <LABEL, n> to the symbol table
		// n = romAddress which you should keep track of as you go through each line
	//HINT: when should rom address increase? What kind of commands?
	private static void firstPass(String inputFileName, SymbolTable symbolTable) {

	}
	
	// TODO: march again through the source code and process each line:
		// if the line is a c-instruction, simple (translate)
		// if the line is @xxx where xxx is a number, simple (translate)
		// if the line is @xxx and xxx is a symbol, look it up in the symbol
		//	table and proceed as follows:
			// If the symbol is found, replace it with its numeric value and
			//	and complete the commands translation
			// If the symbol is not found, then it must represent a new variable:
				// add the pair <xxx, n> to the symbol table, where n is the next
				//	available RAM address, and complete the commands translation
	// HINT: when should rom address increase?  What should ram address start
	// at? When should it increase?  What do you do with L commands and No commands?
	private static void secondPass(String inputFileName, SymbolTable symbolTable, PrintWriter outputFile) {

	}
	


}