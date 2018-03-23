package Assembler;

import java.util.HashMap;

public class SymbolTable 
{
	private static final String INITIAL_VALID_CHARS = "the";
	private static final String ALL_VALID_CHARS = "ghjg";
	private HashMap<String, Integer> symbolTable; 

	public SymbolTable()
	{
		symbolTable = new HashMap <String, Integer>(); 
		
		symbolTable.put("R0", 0);
		symbolTable.put("R1", 1);
		symbolTable.put("R2", 2);
		symbolTable.put("R3", 3);
		symbolTable.put("R4", 4);
		symbolTable.put("R5", 5);
		symbolTable.put("R6", 6);
		symbolTable.put("R7", 7);
		symbolTable.put("R8", 8);
		symbolTable.put("R9", 9);
		symbolTable.put("R10", 10);
		symbolTable.put("R11", 11);
		symbolTable.put("R12", 12);
		symbolTable.put("R13", 13);
		symbolTable.put("R14", 14);
		symbolTable.put("R15", 15);
		symbolTable.put("SCREEN", 16384);
		symbolTable.put("KBD", 24576);
		symbolTable.put("SP", 0);
		symbolTable.put("LCL", 1);
		symbolTable.put("ARG", 2);
		symbolTable.put("THIS", 3);
		symbolTable.put("THAT", 4);
		symbolTable.put("WRITE", 18);
		symbolTable.put("END", 22);
		symbolTable.put("i", 16);
		symbolTable.put("sum", 17);
	}
	//DESCRIPTION: adds new pair of symbol / address to hashmap
	//PRECONDITION: method is adding a new pair of symbols and address to the hashTable
	//POSTCONDITION:the new pair of symbols and address has been added to the hashTable
	public boolean addEntry (String symbol, int address)
	{
		symbolTable.put(symbol, address);
		return true;
		
	}
	//DESCRIPTION: returns boolean on weather hashmap has symbol or not
	//PRECONDITION: checking if there is a symbol or not
	//POSTCONDITION: revised if there are symbols or not
	public boolean contains (String symbol)
	{
		if (symbolTable.containsKey(symbol))
		{ 
			return true;
		}
		else 
		{
			return false;
		}
	}
	//DESCRIPTION: returns address of hashmap of given symbol 
	//PRECONDITION: returning address of given symbol
	//POSTCONDITION: the address has been returned
	public int getAddress(String symbol)
	{
		return symbolTable.get(symbol);
	}
	
	
	private boolean isValidName(String symbol)
	{
		if(symbol == null || symbol.length() ==0)
		{
			return false;
		}
		else 
		{
			char current;
			boolean isValid = true;
			int i =0;
			String isValidChar =  "^[a-zA-Z]*$";;
			while (isValid && i< symbol.length())
			{
				current=symbol.charAt(i);
				if (isValidChar.indexOf(current)==-1)
				{
					isValid=false;
				}
				i++;
			}
			return isValid;
		}
	}
}
