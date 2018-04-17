package Assembler;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Assembler {
	
	/* ALGORITHM:
	Getting input file name
	Creating output file name and stream
	
	Creating symbol table
	First pass to build symbol table (without output yet)
	Second pass to output translated ASM to HACK code
	
	Printing out "done" message to user
	Closing output file stream */
	public static void main(String[] args) {
		
		String inputFileName, outputFileName;
		PrintWriter outputFile = null; //keep compiler happy
		SymbolTable symbolTable;
		int romAddress, ramAddress;
	
		//Get input file name from command line or console input
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
		
		//Creating symbolTable 
	}
	//Creating output file name and stream
	Parser test= new Parser ("add.asm");
	
	/*Marching through the source code without generating any code
	for each label declaration (LABEL) that appears in the source code,
	I will add the pair <LABEL, n> to the symbol table
	n = romAddress which I will keep track of as I go through each line*/
	private static void firstPass(String inputFileName, SymbolTable symbolTable) {

	}
	
	/*Marching again through the source code and process each line:
	if the line is a c-instruction I will simple (translate)
	if the line is @xxx where xxx is a number, I will simple (translate)
	if the line is @xxx and xxx is a symbol, I will look it up in the symbol
	table Then:
		If the symbol is found, I will replace it with its numeric value and I will complete the commands translation
		If the symbol is not found, then it must represent a new variable:
		I will add the pair <xxx, n> to the symbol table, where n is the next available RAM address, and will complete the commands translation */
	private static void secondPass(String inputFileName, SymbolTable symbolTable, PrintWriter outputFile) {
		
	}

}