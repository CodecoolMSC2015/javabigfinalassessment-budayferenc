package web;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient {
	public static void main(String[] args) {
		Socket socket;

		try {

			socket = new Socket("localhost", 8008);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			System.out.println("Client disconnected!");
			ois.close();
			oos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}