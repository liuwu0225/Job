package MagicCube;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class myMagicCube {
	public static void main(String[] args) throws FileNotFoundException {
		//init original data
		//Scanner ss = new Scanner(System.in);
		Scanner ss = new Scanner(new File("data.txt"));
		int M = 0;
		int N = 0;
		int P = 0;
		int[] initData = null;
		Cube bigCube = null;
		HashMap<Integer, Cube> smallCubes = new HashMap<Integer, Cube>();
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
			
		}
	}
}
