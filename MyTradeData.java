package com.ontheway;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

class Data {
	public Data(String date, Double open, Double high, Double low, Double close, Double volume, Double oi) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.oi = oi;
	}

	String date;
	Double open, low, close, high, volume, oi;

	public String toString() {
		return date + "," + open + "," + high + "," + low + "," + close + "," + volume + "," + oi;
	}
}

public class MyTradeData {

	static double close1[] = null;
	static double high1[] = null;
	static double low1[] = null;
	static double open1[] = null;
	static double vol2[] = null;
	static double oi[] = null;
	static String vol1[] = null;
	static String dates[] = null, dates1[] = null;

	public static void main(String arr[]) throws Exception {
		
		System.out.println(new Date());

		

		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.set("Authorization",
				"enctoken kBL0PHSZVJ1FalVGuJEeDusOdnu08ZhMgItslJDcnWczeTysRrQQlJzH7ZixCY1m4Dz4AP6m32vjWZIwWk8pXxg586ukAhbnMPlXdQr0ZLsU5B0o9PVIvQ==");
		headers.set("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String output = template.exchange(
				"https://api.kite.trade/instruments",
				HttpMethod.GET, entity, String.class).getBody();
		
		List<String> instruments=Arrays.asList(output.split("\n"));
		
		System.out.println(instruments.stream().filter(o->o.indexOf("\"NIFTY\"")!=-1 && o.indexOf("2023-06-01")!=-1 && o.indexOf("18500")!=-1).collect(Collectors.toList()));
		System.out.println(new Date());
//		int index = output.indexOf("candles");
//		int index1 = output.indexOf("[[", index);
//		String dataStr = output.toString().substring(index1 + 2).replace("],[", "\n").replace("]]}}", "");
//		String candles[] = dataStr.split("\n");
//
//		List<Data> data = new ArrayList<>();
//
//		for (int i = 0; i < candles.length; i++) {
//
//			String date1;
//			Double open1, high1, close1, low1, volume1, oi1;
//			date1 = candles[i].split(",")[0];
//			open1 = Double.parseDouble(candles[i].split(",")[1]);
//			high1 = Double.parseDouble(candles[i].split(",")[2]);
//			low1 = Double.parseDouble(candles[i].split(",")[3]);
//			close1 = Double.parseDouble(candles[i].split(",")[4]);
//			volume1 = Double.parseDouble(candles[i].split(",")[5]);
//			oi1 = Double.parseDouble(candles[i].split(",")[6]);
//			data.add(new Data(date1, open1, high1, low1, close1, volume1, oi1));
//		}
//		System.out.println(new Date());
//		System.out.println(data.size());

	}

}
