package com.fudan.edu.cn.MagicCube;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class myMagicCube {
	public static void main(String[] args) throws FileNotFoundException {
		//init original data
		//Scanner ss = new Scanner(System.in);
		//long starTime=System.currentTimeMillis();
		Scanner ss = new Scanner(new File("data.txt"));
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
			//MyUtil.strArrayPrint(strArr);
			if(flag == 1){
				initData = MyUtil.strArray2intArray(strArr);
				M = initData[0];
				N = initData[1];
				P = initData[2];
			}else if(flag == 2){
				int[] bigCubeNumbers = MyUtil.strArray2intArray(strArr);
				for (int i = 0; i < bigCubeNumbers.length; i++) {
					bigCubeNumbers[i] = P - bigCubeNumbers[i];
				}
				bigCube = new Cube(M, bigCubeNumbers);
			}else{
				int[] numbers = MyUtil.strArray2intArray(strArr);
				int smallCubeLength = numbers[0];
				int[] smallCubeNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
				Cube smallCube = new Cube(smallCubeLength, smallCubeNumbers);
				smallCubes.put(flag-2, smallCube);
			}
			flag++;
		}
		for (int i = 0; i < N; i++) {
			int biggest = MyUtil.getBiggestCube(smallCubes);
			Cube biggestCube = smallCubes.get(biggest);
			OK:
			for (int z = 0; z <= bigCube.length-biggestCube.length; z++) {
				for (int y = 0; y <= bigCube.length-biggestCube.length; y++) {
					for (int x = 0; x <= bigCube.length-biggestCube.length; x++) {
						Cube subCube = bigCube.subCube(z, y, x, biggestCube.length);
						if(subCube.equals(biggestCube)){
							result.put(biggest, z + " " + y + " " + x);
							MyUtil.handleCube(bigCube, z, y, x, biggestCube.length, P);
							smallCubes.remove(biggest);
							biggest = MyUtil.getBiggestCube(smallCubes);
							biggestCube = smallCubes.get(biggest);
							break OK;
						}
					}
				}
			}
		}
		System.out.println("end for");
		Object[] key_arr = result.keySet().toArray();     
		Arrays.sort(key_arr);     
		for  (Object key : key_arr) {     
		    Object value = result.get(key);  
		    System.out.println(value);
		} 
		//long endTime=System.currentTimeMillis();
		//long Time=endTime-starTime;
		//System.out.println(Time);
	}
}
