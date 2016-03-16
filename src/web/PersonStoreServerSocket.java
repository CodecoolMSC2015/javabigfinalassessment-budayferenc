package web;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import data.CSVDataReader;
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

	public static void readCsv() {
		String csvFile = "./Documentation/persons.csv";
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// comma as separator
				String[] csvLine = line.split(splitBy);

				System.out.println(csvLine[0] + "\t" + csvLine[1] + "\t" + csvLine[2]);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// start();

		CSVDataReader obj = new CSVDataReader();
		readCsv();
	}

}
