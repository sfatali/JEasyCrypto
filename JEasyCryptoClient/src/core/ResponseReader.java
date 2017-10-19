package core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ResponseReader extends Thread {

	private DatagramSocket socket = null;
	private ReaderObserver observer = null;
	private byte[] incoming = null;
	private boolean isStopped = false;
	
	public ResponseReader(DatagramSocket s, ReaderObserver o) {
		socket = s;
		observer = o;
		isStopped = false;
	}
	
	@Override
	public void run() {
		super.run();
		incoming = new byte[4096];
		while (!Thread.currentThread().isInterrupted()) {
			DatagramPacket packet = new DatagramPacket(incoming, incoming.length);
			try {
				System.out.println("Starting to receive responses...");
				socket.receive(packet);
				System.out.println("Response received.");
				String receivedData = new String(packet.getData(), 0, packet.getLength(), StandardCharsets.UTF_16);
				System.out.println("Received raw data: " + receivedData);
				System.out.println("Parsing...");
				JSONObject root = (JSONObject) new JSONParser().parse(receivedData);
				System.out.println("Parsed, handing JSON object to observer.");
				Long test = new Long(-1);
				if(root.get("id") == test) {
					System.out.printf("Invalid data from Server");
					break;
				}
				else {
					observer.handleResponse(root);
				}
				
			} catch (IOException | ParseException | InterruptedException e) {
				// TODO Auto-generated catch block
				if (!isStopped){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void stopReading() {
		isStopped = true;
		interrupt();
	}

}
