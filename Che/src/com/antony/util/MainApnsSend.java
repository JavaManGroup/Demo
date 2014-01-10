package com.antony.util;


import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class MainApnsSend {
	public static void main(String[] args) throws Exception {
		sendCommerceAPNS();
	}

	public static void sendCommerceAPNS() {
		try {
			String deviceToken = "68209400 c1c54d06 4641f914 bf032912 b37603db 5e35b20f 0b6251a6 5896698a";// iphone手机获取的token
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert("我的push测试");// push的内容
			payLoad.addBadge(100);// 图标小红圈的数值
			// payLoad.addSound("default");//铃音
			PushNotificationManager pushManager = PushNotificationManager
					.getInstance();
			pushManager.addDevice("iPhone", deviceToken);
			// Connect to APNs
			/***********************************************************************************************************
			 * 测试的服务器地址：gateway.sandbox.push.apple.com /端口2195
			 * 产品推送服务器地址：gateway.push.apple.com / 2195
			 **********************************************************************************************************/
			String host = "gateway.sandbox.push.apple.com";
			int port = 2195;
			String certificatePath = "D:/aps_development.p12";// 导出的证书
			String certificatePassword = "123456";// 此处注意导出的证书密码不能为空因为空密码会报错
			pushManager.initializeConnection(host, port, certificatePath,
					certificatePassword,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// Send Push
			Device client = pushManager.getDevice("iPhone");
			pushManager.sendNotification(client, payLoad);
			pushManager.stopConnection();
			pushManager.removeDevice("iPhone");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendCustomerAPNS() {
		try {
			String deviceToken = "c60b33344dc727bff137bbddb0216fcce9579c48de4873845d094f0e47134275";// iphone手机获取的token
			PayLoad payLoad = new PayLoad();
			payLoad.addAlert("我的push测试");// push的内容
			payLoad.addBadge(100);// 图标小红圈的数值
			// payLoad.addSound("default");//铃音
			PushNotificationManager pushManager = PushNotificationManager
					.getInstance();
			pushManager.addDevice("iPhone", deviceToken);
			// Connect to APNs
			/***********************************************************************************************************
			 * 测试的服务器地址：gateway.sandbox.push.apple.com /端口2195
			 * 产品推送服务器地址：gateway.push.apple.com / 2195
			 **********************************************************************************************************/
			String host = "gateway.sandbox.push.apple.com";
			int port = 2195;
			String certificatePath = "E:/ruixinWorkspace/apns/apnsFile/TianGouCustomerAPNSCertificates.p12";// 导出的证书
			String certificatePassword = "123456";// 此处注意导出的证书密码不能为空因为空密码会报错
			pushManager.initializeConnection(host, port, certificatePath,
					certificatePassword,
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			// Send Push
			Device client = pushManager.getDevice("iPhone");
			pushManager.sendNotification(client, payLoad);
			pushManager.stopConnection();
			pushManager.removeDevice("iPhone");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}