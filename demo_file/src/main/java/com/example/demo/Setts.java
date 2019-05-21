package com.example.demo;

public class Setts {
	 private static String appKey = "222";

	    private static String secretKey;

	    private static String payHomeUrl;

	    private static String localServerUrl;

		public static String getAppKey() {
			return appKey;
		}

		public static void setAppKey(String appKey) {
			Setts.appKey = appKey;
		}

		public static String getSecretKey() {
			return secretKey;
		}

		public static void setSecretKey(String secretKey) {
			Setts.secretKey = secretKey;
		}

		public static String getPayHomeUrl() {
			return payHomeUrl;
		}

		public static void setPayHomeUrl(String payHomeUrl) {
			Setts.payHomeUrl = payHomeUrl;
		}

		public static String getLocalServerUrl() {
			return localServerUrl;
		}

		public static void setLocalServerUrl(String localServerUrl) {
			Setts.localServerUrl = localServerUrl;
		}

}
