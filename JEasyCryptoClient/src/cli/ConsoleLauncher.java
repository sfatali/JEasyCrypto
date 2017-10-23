package cli;

import java.io.Console;
import java.net.InetAddress;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import core.*;

public class ConsoleLauncher implements Runnable, ClientObserver {

	private static final int CAPABILITY_MENU = 1;
	private static final int ENCRYPT_MENU = 2;
	private static final int DECRYPT_MENU = 3;
	private static final int QUIT_MENU = 4;
	
	private Console console = System.console();
    private CryptoClient client = null;

	public static void main(String[] args) {
		new ConsoleLauncher().run();
    }
    
	@Override
	public void run() {
		// Prepare variables.
		try {			
			InetAddress serverAddr = queryServerAddress();
			if (null == serverAddr) {
				console.printf("Server address not given / invalid!\n");
				console.printf("Quitting CryptoClient!\n");
				return;
			}
            
            this.client = new CryptoClient(serverAddr);
			this.client.setObserver(this);
			
			int choice;
			do {
				// Display menu.
				choice = selectMenuItem();

				switch (choice) {
				// Handle Capability menu command.
				case CAPABILITY_MENU: {
					handleCapabilityRequest();
					break;
				}
				// Handle Encrypt menu command.
				case ENCRYPT_MENU: {
					handleEncryptRequest();
					break;
				}
				// Handle Decrypt menu command.
				case DECRYPT_MENU: {
					handleDecryptRequest();
					break;
				}
				// Handle Quit menu command.
				case QUIT_MENU: {
					handleQuitRequest();
					break;
				}
				}
			} while (choice != QUIT_MENU);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			client.stop();
		}
	}

	private InetAddress queryServerAddress() {
		console.printf("Welcome to CryptoClient!\n");
		console.printf("Enter CryptoServer address in the form \"123.123.123.123\" or hostname\n");
		String address = console.readLine("Address > ");
		InetAddress addr;
		try {
			addr = InetAddress.getByName(address);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			addr = null;
		}
		return addr;
	}

	private int selectMenuItem() {
		int choice = -1;
		do {
			console.printf("Welcome to CryptoClient!\n");
			console.printf("Select command (1-4):\n");
			console.printf(" 1: Send capability request to service\n");
			console.printf(" 2: Send encrypt request to service\n");
			console.printf(" 3: Send decrypt request to service\n");
			console.printf(" 4: Quit application\n");
			console.flush();
			String selection = console.readLine("Your choice > ");
			try {
				choice = Integer.parseInt(selection);
			} catch (NumberFormatException e) {
				console.printf("** Error - not a valid number ** !\n");
				choice = -1;
			}
		} while (choice < 1 || choice > 4);
		return choice;
	}

	private String enterText(String prompt, boolean required) {
		String s = "";
		do {
			s = console.readLine(prompt+" > ");
		} while (s.length() == 0 && required);
		return s;
	}
	
	private void handleCapabilityRequest() throws IOException {
		String data = client.sendCapabilityRequest();
		console.printf("Request for capability info: " + data + "\n\n");
	}
	
	private void handleEncryptRequest() throws IOException {
		String method = enterText("Give encryption method", true);
        String text = enterText("Give text to encrypt", false);
		String key = enterText("Give encryption key", false);
		String data = client.sendEncryptRequest(method, text, key);
		console.printf("Request for encryption: " + data + "\n\n");
	}
	
	private void handleDecryptRequest() throws IOException {
		String method = enterText("Give decryption method", true);
        String text = enterText("Give text to decrypt", false);
        String key = enterText("Give encryption key", false);
		String data = client.sendDecryptRequest(method, text, key);
		console.printf("Request for decryption: " + data + "\n\n");
	}
	
	private void handleQuitRequest() {
		client.stop();
	}

	@Override
	public void handleResponse(String response) {
		System.out.print(response);
	}
}