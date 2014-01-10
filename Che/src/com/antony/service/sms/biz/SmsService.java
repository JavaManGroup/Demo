package com.antony.service.sms.biz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import org.antonyframework.service.common.BaseService;
import org.antonyframework.support.sms.SMSBean;
import org.antonyframework.support.sms.SMSManager;

public class SmsService extends BaseService {
	private static SMSManager smsManager;
	public static int PORT = 7688;
	private static Vector vector = new Vector();
	MobileThread thread = null;

	public void init() {

	}

	class MobileThread extends Thread implements Runnable {

		@Override
		public void run() {

			while (true) {
				System.out.println("启动短信线程");
				// TODO Auto-generated method stub
				ServerSocket s = null;
				Socket socket = null;
				BufferedReader br = null;
				PrintWriter pw = null;
				try {
					s = new ServerSocket(PORT);
					System.out.println("ServerSocket Start:" + s);
					socket = s.accept();
					SMSBean sms = new SMSBean();
					sms.setPhone("18640014656");
					sms.setMsg("13123123");
					vector.add(sms);
					System.out.println("Connection accept socket:" + socket);
					br = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					pw = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())),
							true);
					while (true)
						try {
							String str = br.readLine();
							if (str.equals("start")) {
								break;
							}
							if (str.equals("stop")) {
								break;
							}
							System.out.println("Client Socket Message:" + str);
							Thread.sleep(1000);
							pw.println("18640014656,13123123");
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

	public void sendSms(String phone, String msg) {
		SMSBean mBean = new SMSBean();
		mBean.setPhone("18640014656");
		mBean.setMsg("111111");
		smsManager.sendSms(mBean);
	}
}
