package core;

import java.nio.charset.StandardCharsets;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import org.json.simple.JSONObject;
import java.io.IOException;

public class CryptoClient implements ReaderObserver {

	private ResponseReader reader = null;
	private DatagramSocket socket = null;
	private InetAddress serverAddr = null;
	private int serverPort = 10000;
	int requestId = 0;
	
	private ClientObserver observer = null;
	
	public CryptoClient(InetAddress serverAddress, ClientObserver observer) throws SocketException {
		this.observer = observer;
		this.serverAddr = serverAddress;
		this.socket = new DatagramSocket(10001);
		this.reader = new ResponseReader(socket, this);
		reader.start();
	}
	
	public void sendCapabilityRequest() throws SocketException, IOException {
		JSONObject request = new JSONObject();
		request.put("id", requestId++);
		request.put("operation", "capabilities");

		String data = request.toJSONString();
		byte[] serializedData = data.getBytes(StandardCharsets.UTF_16);
		DatagramPacket packet = new DatagramPacket(serializedData, serializedData.length, serverAddr, serverPort);

		socket.send(packet);
	}
	
	public void sendEncryptRequest(String method, String text) throws SocketException, IOException {
		JSONObject request = new JSONObject();
		request.put("id", requestId++);
		request.put("operation", "encrypt");
		request.put("method", method);
		request.put("data", text);

		String data = request.toJSONString();
		byte[] serializedData = data.getBytes(StandardCharsets.UTF_16);
		DatagramPacket packet = new DatagramPacket(serializedData, serializedData.length, serverAddr, serverPort);

		socket.send(packet);
	}
	
	public void sendDecryptRequest(String method, String text) throws SocketException, IOException {
		JSONObject request = new JSONObject();
		request.put("id", requestId++);
		request.put("operation", "decrypt");
		request.put("method", method);
		request.put("data", text);

		String data = request.toJSONString();
		byte[] serializedData = data.getBytes(StandardCharsets.UTF_16);
		DatagramPacket packet = new DatagramPacket(serializedData, serializedData.length, serverAddr, serverPort);
		
		socket.send(packet);
	}
	
	public void stop() {
		reader.stopReading();
		socket.close();
	}

	@Override
	public void handleResponse(JSONObject response) throws InterruptedException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Got response from reader...");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("Request ID: ");
		stringBuilder.append(response.get("id"));
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("Operation: ");
		stringBuilder.append(response.get("operation"));
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("Result: ");
		stringBuilder.append(response.get("result"));
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("Data: ");
		stringBuilder.append(response.get("data"));
		stringBuilder.append(System.getProperty("line.separator"));

		String result = stringBuilder.toString();
		observer.handleResponse(result);
	}

	public void registerObserver(ClientObserver observer){
		this.observer = observer;
	}
}
