package EasyCryptoConsole;

import java.io.Console;

import EasyCryptoLib.EasyCryptoLib;


public class EasyCryptoConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Console console = System.console();
		
		console.printf("Welcome to CryptoClient!\n");
		console.printf("Supported methods are: %s\n", EasyCryptoLib.methods());
		
		while (true) {
			String d = console.readLine("Do you wish to encrypt or decrypt (e or d)? > ");
			String e = console.readLine("Please enter text to be encrypted > ");
			String m = console.readLine("Please enter encryption method > ");
			
			EasyCryptoLib.Result result;
			
			
			if (d.equalsIgnoreCase("e")) {
				result = EasyCryptoLib.encrypt(e, m);
			} else if (d.equalsIgnoreCase("d")) {
				result = EasyCryptoLib.decrypt(e, m);
			} else {
				return;
			}
			console.printf("\nResult is: %d - %s\n", result.resultCode().ordinal(), result.resultCode().toString());
			switch (result.resultCode()) {
				case ESuccess: {
					console.printf("Encrypted text is: %s \n", result.result());
					break;
				}
				case EError:
				case ENotSupported: {
					console.printf("Encrypted text is: %s \n", result.result());
					break;
				}
			}
		}
		
	}

}
