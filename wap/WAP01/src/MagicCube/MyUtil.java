package MagicCube;

import java.util.ArrayList;
import java.util.Arrays;

public class MyUtil {
	public static int[] strArray2intArray(String[] strArr){
		int[] intArr = new int[strArr.length];
		for(int i = 0; i<strArr.length; i++){
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}
	
	public static void strArrayPrint(String[] strArr){
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
		System.out.println("");
	}
	
	public static ArrayList<int[]> splitByLength(Cube cube){
		ArrayList<int[]> intArrayList = new ArrayList<int[]>();
		int length = cube.len;
		for (int i = 0; i < cube.values.length; i += length) {
			int[] intArr = Arrays.copyOfRange(cube.values, i, i + length);
			intArrayList.add(intArr);
		}
		return intArrayList;
	}
}
