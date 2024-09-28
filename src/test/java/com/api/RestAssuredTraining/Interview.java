package com.api.RestAssuredTraining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 7, 5, 4, 8, 16, 23 };

		for (int i = 0; i < arr.length; i++) {

			int d = (int)Math.sqrt(arr[i]);
			if (d*d!=arr[i]) {
				System.out.println(arr[i]);
			}
		}

		//=========================================
		
		String str = "DDHHHL";

		char[] ch = str.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char cha : ch) {
			if (map.containsKey(cha)) {
				map.put(cha, map.get(cha) + 1);
			} else {
				map.put(cha, 1);
			}
		}

		for (char ch1 : map.keySet()) {
			System.out.println(ch1 + " : " + map.get(ch1));
		}
		
		
		
		//===============================
		
		String name1 = "Jane";
		String name2 = "Joe";
		String name3 = "Evelyn";
		String name4 = "Patrick";
		String name5 = "Aaron";
		String name6 = "Leia";
		
		String[] strArr = {name1,name2,name3,name4,name5,name6};
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
	}
}
