package MagicCube;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

public class myMagicCube {
	public static void main(String[] args) throws FileNotFoundException {
		//init original data
		//Scanner ss = new Scanner(System.in);
		Scanner ss = new Scanner(new File("data.txt"));
		int[] initData = null;
		Cube bigCube = null;
		ArrayList<Cube> smallCubes = new ArrayList<Cube>();
		int flag = 1;
		while(ss.hasNextLine()){
			String[] strArr = ss.nextLine().split(" ");
			MyUtil.strArrayPrint(strArr);
			if(flag == 1){
				initData = MyUtil.strArray2intArray(strArr);
			}else if(flag == 2){
				int[] bigCubeNumbers = MyUtil.strArray2intArray(strArr);
				bigCube = new Cube((int)Math.cbrt(bigCubeNumbers.length), bigCubeNumbers);
			}else{
				int[] numbers = MyUtil.strArray2intArray(strArr);
				int smallCubeLength = numbers[0];
				int[] smallCubeNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
				Cube smallCube = new Cube(smallCubeLength, smallCubeNumbers);
				smallCubes.add(smallCube);
			}
			flag++;
		}
		System.out.println("----------------");
		//set data
		System.out.println("smallCubes: " + smallCubes.size());
		int M = initData[0];
		int N = initData[1];
		int P = initData[2];
		//put samll cubes in bigger one
	    //split the big cube by length
		ArrayList<int[]> bigCubeSplit = MyUtil.splitByLength(bigCube);
		
	}
}
