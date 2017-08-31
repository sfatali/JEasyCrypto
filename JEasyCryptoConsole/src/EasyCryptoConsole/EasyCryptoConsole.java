package EasyCryptoConsole;

import java.io.Console;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.BreakIterator;
import java.util.Locale;

import EasyCryptoLib.EasyCryptoLib;


public class EasyCryptoConsole {

	public static void main(String[] args) {

		try {
		    String antti = "\u2234";
		    System.out.println(antti);
		    
		    for (int codePoint = 0x1F600; codePoint <= 0x1F64F;) {
		        System.out.print(Character.toChars(codePoint));
		        codePoint++;
		        if (codePoint % 16 == 0) {
		            System.out.println();
		        }
		    }
		    
			System.setOut(new PrintStream(System.out, true, "UTF-8"));
			System.setProperty("file.encoding", "UTF-8");
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
					System.out.println(result.result());
					break;
				}
				case EError:
				case ENotSupported: {
					console.printf("Encrypted text is: %s \n", result.result());
					break;
				}
				}
			}

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
