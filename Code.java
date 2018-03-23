package Assembler;

import java.util.HashMap;

public class Code 
{
	private HashMap<String, String> compCodes;
	private HashMap<String, String> destCodes;
	private HashMap<String, String> jumpCodes;
	
	//DESCRIPTION: initializes hashMaps with binary codes for easy lookup
	//PRECONDITION: the hashMap is going to be initialized
	//POSTCONDITION:the hashMap  has been initialized 
	Code()
	{
		compCodes = new HashMap <String, String>(); 
		destCodes = new HashMap <String, String>();
		jumpCodes = new HashMap <String, String>();
		
		compCodes.put("0", "101010");
		compCodes.put("1", "111111");
		compCodes.put("-1", "111010");
		compCodes.put("D", "001100");
		compCodes.put("A", "110000");
		compCodes.put("!D", "001101");
		compCodes.put("!A", "110001");
		compCodes.put("-D", "001111");
		compCodes.put("-A", "110011");
		compCodes.put("D+1", "011111");
		compCodes.put("A+1", "110111");
		compCodes.put("D-1", "001110");
		compCodes.put("A-1", "110010");
		compCodes.put("D+A", "000010");
		compCodes.put("D-A", "010011");
		compCodes.put("A-D", "000111");
		compCodes.put("D&A", "000000");
		compCodes.put("D|A", "010101");
		compCodes.put("M", "110000");
		compCodes.put("!M", "110001");
		compCodes.put("-M", "110011");
		compCodes.put("M+1", "110111");
		compCodes.put("M-1", "110010");
		compCodes.put("D+M", "000010");
		compCodes.put("D-M", "010011");
		compCodes.put("M-D", "000111");
		compCodes.put("D&M", "000000");
		compCodes.put("D|M", "010101");
		
		destCodes.put("null", "000");
		destCodes.put("M", "001");
		destCodes.put("D", "010");
		destCodes.put("MD", "011");
		destCodes.put("A", "100");
		destCodes.put("AM", "101");
		destCodes.put("AD", "110");
		destCodes.put("AMD", "111");
		
		jumpCodes.put("null", "000");
		jumpCodes.put("JGT", "001");
		jumpCodes.put("JEQ", "010");
		jumpCodes.put("JGE", "011");
		jumpCodes.put("JLT", "100");
		jumpCodes.put("JNE", "101");
		jumpCodes.put("JLE", "110");
		jumpCodes.put("JMP", "111");
	}
	//DESCRIPTION: converts to string of bits (7) for given mnemonic
	//PRECONDITION: converting string to bits
	//POSTCONDITION: string has been converted
	public String getComp(String mnemonic)
	{
		return compCodes.get(mnemonic);
	}
	//DESCRIPTION: converts to string of bits (3) for given mnemonic
	//PRECONDITION: converting string to bits
	//POSTCONDITION: string has been converted
	public String getDest(String mnemonic)
	{
		return destCodes.get(mnemonic);
	}
	//DESCRIPTION: converts to string of bits (3) for given mnemonic
	//PRECONDITION: converting string to bits
	//POSTCONDITION: string has been converted
	public String getjump(String mnemonic)
	{
		return jumpCodes.get(mnemonic);
	}
	
	//DESCRIPTION: converts integer from decimal notation to binary notation
	//PRECONDITION: converting decimal to binary
	//POSTCONDITION: decimal has been converted to binary
	public String decimalToBinary (int decimal)
		{
			String result= " ";
			for (int i=0; i<15; i++)
			{
				result =decimal % 2 + result;
				decimal = decimal /2;
			}
			return result;
		}
}
