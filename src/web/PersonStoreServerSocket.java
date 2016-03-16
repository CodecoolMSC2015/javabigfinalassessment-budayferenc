package web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import person.Person;

public class PersonStoreServerSocket {

	private ServerSocket serverSocket;
	String csvFilePath;
	List<Person> persons;

	public PersonStoreServerSocket(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public static void start() {
		try

		{
			ServerSocket serverSocket = new ServerSocket(8008);
			System.out.println("Server started.");
			Socket server = serverSocket.accept();
			System.out.println("Client connected.");

			ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());

			while (true) {
				// System.out.println("Connection closed!!");
				// ois.close();
				// oos.close();
				// server.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		start();

		// open file input stream
		BufferedReader reader = new BufferedReader(new FileReader("./Documentation/persons.csv"));

		// read file line by line
		String line = null;
		Scanner scanner = null;
		int index = 0;
		List<Person> personList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			Person per = new Person();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					per.setName((data));
				else if (index == 1)
					per.setEmail(data);
				else
					System.out.println(data);

			}
			index = 0;
			personList.add(per);
		}

		// close reader
		reader.close();
	}
}
