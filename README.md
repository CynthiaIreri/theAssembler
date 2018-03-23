# theAssembler
The assembler translates each assembly command into binary code

The assembler translates each assembly command into binary machine instructions.

The assembler program accepts three types of instructions which are A-instruction, C-instruction and the symbols.

The goal of the assembler is to translate the program written into Hack (assembly language) which is the machine language into a sequence of 16-bit instructions (binary).
The program translates each type of instructions and then it combines them to output the binary code.

In addition, the program does two passes through the code. The first pass goes through the entire source code, and add all the label symbols to the symbol table. The second pass goes again through the source code, and uses the symbol table to translate all the commands.

The assembler is written in java and it has 4 classes:  
Parser: This class will take out each command into its own field.
Code: This class will translate each field into binary value, and it will assemble the  
           values.
SymbolTable: This class manages the symbol table (hash tables). 
Assembler: This is the main class that manages the input and output fields.

