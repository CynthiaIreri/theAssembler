package Assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser 
{
	//constants 
	public char NO_COMMAND;
	public char A_COMMAND; 
	public char C_COMMAND;
	public char L_COMMAND;
	
	//file stuff +
	private Scanner inputFile; 
	private int lineNumber; 
	private String rawLine; 
	
	//parsed command parts
	private String cleanLine;
	private char commandType; 
	private String symbol; 
	private String destMnemonic; 
	private String compMnemonic; 
	private String jumpNemonic;
	//create the drivers of the command
	//get command String and the data type
	//create the getComp String 
	//drivers
	
	//DESCRIPTION: opens input file/stream and prepares to parse
	//PRECONDITION: the file is going to be opened
	//POSTCONDITION:the file has been opened
	public Parser(String inFileName)
	{
		File file = new File (inFileName);
		inputFile = null;
		try {
			inputFile = new Scanner(file);

		} catch (FileNotFoundException e) {
		    System.out.println("Could not open file: " + inFileName);
		}
		lineNumber = 0;
		rawLine= null;
	}
	//DESCRIPTION: returns boolean if more commands left, closes stream if not
	//PRECONDITION: if more commands left it returns boolean otherwise it closes the stream
	//POSTCONDITION: the commands has been returned
	public boolean hasMoreCommands()
	{
		if (inputFile.hasNextLine())
		{
			return true;
		}
		else 
		{
			inputFile.close();
			return false;
		}
	}
	//DESCRIPTION: reads next line from file and parses it into instance variables
	//PRECONDITION: reading line and parsing to instance variables
	//POSTCONDITION: the line has been parsed to instance variable
	public void advance()
	{
		rawLine = inputFile.nextLine();
		if (rawLine.length()==0);
		{
			cleanLine();
			parse();
		}
		lineNumber++;
		
	}
	//DESCRIPTION: Cleans raw instruction by removing non-essential parts
	//PRECONDITION: Eliminates comments
	//POSTCONDITION: Comments have been eliminated
	private void cleanLine()
	{
		cleanLine = rawLine;
		int commentLine = cleanLine.indexOf("//");
		
		//if there are "//" in the line of code erase everything that is after the line
		if (commentLine != -1)
		{
			cleanLine = cleanLine.substring(0, commentLine);
			cleanLine= cleanLine.trim();
		}
		//if there is no "//" in the line of code do not change anything
		cleanLine = cleanLine.replaceAll(" ", " ");

	}
	//DESCRIPTION: Determines command type for parameter
		//PRECONDITION: determining commad type
		//POSTCONDITION:command type has been determined
		private void parseCommandType()
		{
			//if there is nothing
			if (cleanLine == null || cleanLine.length()==0)
			{
				commandType= NO_COMMAND;
			}
			//if the first character is e
			else if (cleanLine.charAt(0)=='@')
			{
				commandType = A_COMMAND;
			}
			//if the first character is (
			else if (cleanLine.charAt(0)=='(')
			{
				commandType = L_COMMAND;
			}
			else if (cleanLine.charAt(0)== 'A'|| cleanLine.charAt(0)== 'M' || cleanLine.charAt(0)== 'D' || cleanLine.charAt(0)== '0')
			{
				commandType = C_COMMAND ;
			}
					
		}
		//DESCRIPTION: Parse symbol for A to L commands 
		//PRECONDITION: the symbol is going to get parsed
		//POSTCONDITION:the symbol has been parsed
		private void parseSymbol()
		{
			if (commandType== A_COMMAND)
			{ 
				
				cleanLine = cleanLine.substring(1);
			}
				
			else if (commandType ==L_COMMAND)
			{
				int last = cleanLine.length()-1;
				
				cleanLine = cleanLine.substring(1, last);
			}
		}
		//DESCRIPTION:helper method parse line to get dest part 
		//PRECONDITION: the dest part is going to be parsed
		//POSTCONDITION: the dest part has been parsed
		private void parseDest()
		{
			/// check for example D=A and get D what is on the left of the parenthesis  
			
			if (cleanLine.contains("="))
			{ 
				int endIndex = cleanLine.indexOf("=");
				cleanLine= cleanLine.substring(0, endIndex);
				destMnemonic = cleanLine;				
			}
		}
		//DESCRIPTION: helper method parse line to get comp part
		//PRECONDITION: comp part is going to be parsed
		//POSTCONDITION: comp part has been parsed
		private void parseComp()
		{
			if (cleanLine.contains("="));
			{
				int myIndex= cleanLine.indexOf("=");
				cleanLine= cleanLine.substring(myIndex+1);
				compMnemonic = cleanLine;
			}
			
		}
		//DESCRIPTION: helper method parses line to get jump part 
		//PRECONDITION: parsing line to get jump part
		//POSTCONDITION:the part jump has been parsed
		private void parseJump()
		{
			if (cleanLine.contains(";"));
			{
				int endIndex = cleanLine.indexOf(";");
				cleanLine= cleanLine.substring(0, endIndex);
				jumpNemonic = cleanLine; 
			}		
		}
		//DESCRIPTION: helper method parses line depending on instruction type
		//PRECONDITION: choosing which part is going to parse
		//POSTCONDITION: the part selected has been choosen
		private void parse()
		{
			if (commandType==A_COMMAND)
			{
				parseDest();
			}
			if (commandType==C_COMMAND)
			{
				parseComp();
			}
			if (commandType==L_COMMAND)
			{
				parseJump();
			}
		}
		//DESCRIPTION: getter for lineNumber
		//PRECONDITION:obtaining lineNumber
		//POSTCONDITION:lineNumber has been obtained
		public int getLineNumber()
		{
			return lineNumber;
		}
		//DESCRIPTION: getter for rawline from file (debbuger) 
		//PRECONDITION: getting rawline from file 
		//POSTCONDITION:raw line from file has been gotten
		public String getRawLine()
		{
			return rawLine;
		}
		//DESCRIPTION: getter for cleanLine from file (dubbuging)
		//PRECONDITION: obtaining cleanline 
		//POSTCONDITION: cleanLine has been obtained
		public String getCleanLine()
		{
			return cleanLine;
		}
		//DESCRIPTION: getter for command type char
		//PRECONDITION: obtaining the command type
		//POSTCONDITION: command type has been obtained
		public char getCommandType()
		{
			return commandType;
		}
		//DESCRIPTION: getter for command type string 
		//PRECONDITION: obtaining the command type
		//POSTCONDITION: command type has been obtained
		public String getCommandTypeString()
		{
			char c = getCommandType();
			String str = Character.toString(c);
			return str;
		}
		//DESCRIPTION: getter fir symbol name
		//PRECONDITION: getting the name of the symbol
		//POSTCONDITION:the name of the symbol has been gotten
		public String getSymbol()
		{
			return symbol;
		}
		//DESCRIPTION: getter for dest part of C- instructions 
		//PRECONDITION: obtaining dest part 
		//POSTCONDITION: dest part has been obtained
		public String getDestMnemonic()
		{
			return destMnemonic;
		}
		//DESCRIPTION: getter for comp part of C-instructions
		//PRECONDITION: obtaining comp part
		//POSTCONDITION:comp part has been obtained
		public String getCompMnemonic()
		{
			return compMnemonic;
		}
		//DESCRIPTION: getter for jump part of C-instructions
		//PRECONDITION: obtaining jump part of c
		//POSTCONDITION:jump part has been obtained
		public String getJumpNemonic()
		{
			return jumpNemonic;
		}
		
		
}
