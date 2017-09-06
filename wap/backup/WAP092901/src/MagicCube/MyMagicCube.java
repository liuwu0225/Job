package MagicCube;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MyMagicCube {
	public static void main(String[] args) throws FileNotFoundException {
		//init original data
		//Scanner ss = new Scanner(System.in);
		Scanner ss = new Scanner(new File("data1.txt"));
		int M = 0;
		int N = 0;
		int P = 0;
		int[] initData = null;
		Cube bigCube = null;
		HashMap<Integer, Cube> smallCubes = new HashMap<Integer, Cube>();
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		int flag = 1;
		while(ss.hasNextLine()){
			String[] strArr = ss.nextLine().split(" ");
			//strArrayPrint(strArr);
			if(flag == 1){
				initData = strArray2intArray(strArr);
				M = initData[0];
				N = initData[1];
				P = initData[2];
			}else if(flag == 2){
				int[] bigCubeNumbers = strArray2intArray(strArr);
				for (int i = 0; i < bigCubeNumbers.length; i++) {
					bigCubeNumbers[i] = P - bigCubeNumbers[i];
				}
				bigCube = new Cube(M, bigCubeNumbers);
			}else{
				int[] numbers = strArray2intArray(strArr);
				int smallCubeLength = numbers[0];
				int[] smallCubeNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
				Cube smallCube = new Cube(smallCubeLength, smallCubeNumbers);
				smallCubes.put(flag-2, smallCube);
			}
			flag++;
		}
		
		for (int i = 0; i < N; i++) {
			int biggest = getBiggestCube(smallCubes);
			Cube biggestCube = smallCubes.get(biggest);
			OK:
			for (int z = 0; z <= bigCube.length-biggestCube.length; z++) {
				for (int y = 0; y <= bigCube.length-biggestCube.length; y++) {
					for (int x = 0; x <= bigCube.length-biggestCube.length; x++) {
						Cube subCube = bigCube.subCube(z, y, x, biggestCube.length);
						if(subCube.equals(biggestCube)){
							result.put(biggest, z + " " + y + " " + x);
							handleCube(bigCube, z, y, x, biggestCube.length, P);
							smallCubes.remove(biggest);
							biggest = getBiggestCube(smallCubes);
							biggestCube = smallCubes.get(biggest);
							break OK;
						}
					}
				}
			}
		}
		Object[] key_arr = result.keySet().toArray();     
		Arrays.sort(key_arr);     
		for  (Object key : key_arr) {     
		    Object value = result.get(key);  
		    System.out.println(value);
		} 
	}
	
	public static class Cube {
		int length = 0;
		int[][][] values = null;
		
		public Cube(int len, int[] values) {
			super();
			this.length = len;
			this.values = initValue(values);
		}
		
		private int[][][] initValue(int[] values){
			int length = (int)Math.cbrt(values.length);
			int i = 0;
			int[][][] mvalues = new int[length][length][length];
			for (int z = 0; z < length; z++) {
				for (int y = 0; y < length; y++) {
					for (int x = 0; x < mvalues.length; x++) {
						mvalues[z][y][x] = values[i];
						//System.out.print("(" + z + "," + y + "," + x + ") = " + values[i]);
						i++;
					}
				}
			}
			//System.out.println("");
			return mvalues;
		}
		
		public boolean equals(Cube compare){
			boolean result = true;
			if(this.length != compare.length){
				result = false;
				return result;
			}
			for (int z = 0; z < this.length; z++) {
				for (int y = 0; y < this.length; y++) {
					for (int x = 0; x < this.length; x++) {
						if(this.values[z][y][x] != compare.values[z][y][x])
							result = false;
					}
				}
			}
			return result;
		}
		
		public Cube subCube(int z, int y, int x, int length) {
			if(z+length > this.length || y+length > this.length || x+length > this.length){
				return null;
			}
			int[] values = new int[length*length*length];
			int m = 0;
			for (int i = z; i < z + length; i++) {
				for (int j = y; j < y + length; j++) {
					for (int k = x; k < x + length; k++) {
						values[m] = this.values[i][j][k];
						m++;
					}
				}
			}
			//System.out.print("sub cube ");
			Cube subCube = new Cube(length, values);
			return subCube;
		}
	}
	
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
