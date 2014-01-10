package org.antonyframework.support.sms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {

	public static int PORT = 7688;

	public static void main(String[] agrs) { 
		while (true) {
			ServerSocket s = null;
			Socket socket = null;
			BufferedReader br = null;
			PrintWriter pw = null;
			try {
				s = new ServerSocket(PORT);
				System.out.println("ServerSocket Start:" + s);
				socket = s.accept();
				System.out.println("Connection accept socket:" + socket);
				br = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream())), true);
				while (true)
					try {
						String str = br.readLine();
						if (str.equals("live")) {
							break;
						}
						if (str.equals("stop")) {
							break;
						}
						System.out.println("Client Socket Message:" + str);
						Thread.sleep(1000);
						pw.println("18610083419,13123123");
						pw.flush();
					} catch (Exception e) {
						Thread.sleep(1000);
						System.out.println("living");
					}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Close.....");
				try {
					br.close();
					pw.close();
					socket.close();
					s.close();
				} catch (Exception e2) {

				}
			}
		}
	}
}