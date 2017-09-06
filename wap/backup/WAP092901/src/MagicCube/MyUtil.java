package MagicCube;

import java.util.HashMap;
import java.util.Iterator;

import MagicCube.MyMagicCube.Cube;

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
	
	public static int getBiggestCube(HashMap<Integer, Cube> smallCubes) {
		int MaxLength = 0;
		int index = 0;
		Iterator it = smallCubes.keySet().iterator();
		while (it.hasNext()) {
			int key = (int) it.next();
			if(smallCubes.get(key).length > MaxLength){
				MaxLength = smallCubes.get(key).length;
				index = key;
			}
		}
		return index;
	}
	
	public static void handleCube(Cube cube, int z, int y, int x, int length, int P) {
		for (int i = z; i < z+length; i++) {
			for (int j = y; j < y+length; j++) {
				for (int k = x; k < x+length; k++) {
					cube.values[i][j][k] = P+1;
				}
			}
		}
	}
}
