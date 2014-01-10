package com.antony.service.local.biz;

import org.antonyframework.service.common.BaseService;

public class LocalService extends BaseService {

	private static final double EARTH_RADIUS = 6378137.0;

	// 计算两个精度的 的距离 单位是km 参数1，2 为A点经纬度 2,3 为B点经纬度
	public static double gps2m(double lat_a, double lng_a, double lat_b,
			double lng_b) {

		double radLat1 = (lat_a * Math.PI / 180.0);
		double radLat2 = (lat_b * Math.PI / 180.0);
		double a = radLat1 - radLat2;
		double b = (lng_a - lng_b) * Math.PI / 180.0;
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	public static void main(String[] args) {
		double gps2m = gps2m(36.665862, 117.040834, 36.669188, 117.034707);
		System.out.println(gps2m);
	}

}
