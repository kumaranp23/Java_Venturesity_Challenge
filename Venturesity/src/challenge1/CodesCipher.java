package challenge1;

import javax.swing.JOptionPane;

public class CodesCipher {

	String key,option;
	
	/**
	 * Read the Key, Message Type and the Message from the user
	 * @return inptTxt - String - Returns the input message received 
	 */
	public String readInput(){
		String inptTxt="";
		key= JOptionPane.showInputDialog("Please enter the Key: ");

		option= JOptionPane.showInputDialog("Is message plaintext (Y/N): ");

		if (option.equalsIgnoreCase("Y"))
			inptTxt= JOptionPane.showInputDialog("Please enter the Plaintext: ");
		else
			inptTxt= JOptionPane.showInputDialog("Please enter the Ciphertext: ");
		
		return inptTxt;
	}
	
	/**
	 * Write the encoded cipher text or the decoded plain text in console and dialog box
	 * @param chrOutput takes char[] of output message as input
	 */
	public void writeToConsole(char[] chrOutput){
		String otptTxt="";
		for(char c : chrOutput)
			otptTxt= otptTxt + c;

		System.out.println(otptTxt);

		if (option.equalsIgnoreCase("Y"))
			JOptionPane.showMessageDialog(null, "CipherText:" +otptTxt);
		else
			JOptionPane.showMessageDialog(null, "PlainText:" +otptTxt);
	}
	
	/**
	 * Encodes or decodes the input text based on Mod 26.
	 * Uses Key and input message for encoding
	 * Encoding or Decoding happens based on the option (Is message in plain text (Y/N):)
	 * @param inptTxt Input message read from the user in String format
	 * @return
	 */
	public char[] codeCipher(String inptTxt){
		
		int i=-1,j=0;
		int[] x = new int[inptTxt.length()];
		char[] chrKey = new char[inptTxt.length()];
		char[] chrInput = new char[inptTxt.length()];
		char[] chrOutput = new char[inptTxt.length()];
		
		for (char c : inptTxt.toCharArray())
		{    	   
			if(j==key.length())
				j=0;
			if(Character.isAlphabetic(c))
			{
				chrKey[++i] = key.charAt(j++);
				chrInput[i] =c;
				if (option.equalsIgnoreCase("Y"))
				{
					x[i]=(((int) Character.toLowerCase(chrKey[i]) + (int)Character.toLowerCase(chrInput[i]) -192)%26 ) +1;	
				}
				else
				{
					x[i]= (int)Character.toLowerCase(chrInput[i]) - (int) Character.toLowerCase(chrKey[i]);
					if (x[i]<0)
						x[i] = x[i]+26;
					if (x[i]!=0)					
						x[i] = (x[i] % 26) -1;
					if (x[i]==0)
						x[i] = 25;
				}
				chrOutput[i] = (char) (x[i] + 96);
				System.out.print(x[i]+" ");
			}
			else if(c!=' ')
				chrOutput[++i]=c;
				
		}
		System.out.println(); 	 	
		System.out.println(chrKey);
		System.out.println(chrInput);
		
		return chrOutput;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CodesCipher cphr = new CodesCipher();
		String inptTxt = cphr.readInput();
	
		char[] chrOutput = new char[inptTxt.length()];
		chrOutput = cphr.codeCipher(inptTxt);
		cphr.writeToConsole(chrOutput);
		
	}

}
