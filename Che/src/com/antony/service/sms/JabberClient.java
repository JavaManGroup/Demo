package com.antony.service.sms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class JabberClient {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			socket = new Socket("192.168.0.103", 7688);
			System.out.println("Socket=" + socket);
			br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())));
			for (int i = 0; i < 10; i++) {
				pw.println("howdy " + i);
				pw.flush();
				String str = br.readLine();
				System.out.println(str + "test");
				if(i == 5){
					pw.println("start");
					pw.flush();
				}
			}
			pw.println("END");
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("close......");
				br.close();
				pw.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}