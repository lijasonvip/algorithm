package com.bo.net;

import java.net.*; 

import java.io.*; 

public class Client {
	static Socket server;

	public static void main(String[] args) throws Exception {

		server = new Socket("219.223.246.143", 5678);

		BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

		PrintWriter out = new PrintWriter(server.getOutputStream());

		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String str = wt.readLine();

			out.println(str);

			out.flush();

			if (str.equals("end")) {

				break;

			}

			System.out.println(in.readLine());

		}

		server.close();

	}
}
