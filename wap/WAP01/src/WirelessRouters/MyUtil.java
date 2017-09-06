package WirelessRouters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MyUtil {
	/**
	 * Convert string array to int array
	 * @param strArr String array to be convert to int array
	 * **/
	public static int[] strArray2intArray(String[] strArr){
		int[] intArr = new int[strArr.length];
		for(int i = 0; i<strArr.length; i++){
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		return intArr;
	}
	
	/**
	 * Print int array for test
	 * @param intArr Int array to be printed
	 * **/
	public static void intArrayPrint(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
		System.out.println("");
	}
	
	/**
	 * Set all elements in a int array to 0
	 * @param intArr Int array to be cleared
	 * **/
	public static int[] intArrayClear(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = 0;
		}
		return intArr;
	}
	
	/**
	 * Save the relationship of rooms
	 * @param mhash Used to save relationships
	 * @param intArr A relationship pair of two rooms
	 * **/
	public static void saveRoom(HashMap<Integer, ArrayList<Integer>> mhash, int[] intArr) {
		ArrayList<Integer> mArrayList1 = new ArrayList<Integer>();
		if(!mhash.containsKey(intArr[0])){
			mArrayList1.add(intArr[1]);
			mhash.put(intArr[0], mArrayList1);
		}else {
			mArrayList1 = mhash.get(intArr[0]);
			mArrayList1.add(intArr[1]);
			mhash.put(intArr[0], mArrayList1);
		}
		
		ArrayList<Integer> mArrayList2 = new ArrayList<Integer>();
		if(!mhash.containsKey(intArr[1])){
			mArrayList2.add(intArr[0]);
			mhash.put(intArr[1], mArrayList2);
		}else {
			mArrayList2 = mhash.get(intArr[1]);
			mArrayList2.add(intArr[0]);
			mhash.put(intArr[1], mArrayList2);
		}
	}
	
	/**
	 * Get the maximum value in a int array
	 * @param intArr Int array  
	 * **/
	public static int[] getMaxInArray(int[] intArr){
		int Max = 0;
		int index = 0;
		for (int i = 0; i < intArr.length; i++) {
			if(intArr[i]>Max){
				Max = intArr[i];
				index = i + 1;
			}
		}
		int[] result = {Max, index};
		return result;
	}
	
	/**
	 * Calculate rooms value 
	 * @param mhash save relationships between rooms
	 * @param rooms save rooms satisfaction point
	 * @param roomsValue save rooms value
	 * **/
	public static void calculateValue(HashMap<Integer, ArrayList<Integer>> mhash, int[] rooms, int[] roomsValue) {
		Iterator it = mhash.keySet().iterator();
		while(it.hasNext()){
			int key = (int) it.next();
			ArrayList<Integer> linkedRooms = (ArrayList<Integer>) mhash.get(key);
			for (int i = 0; i < linkedRooms.size(); i++) {
				roomsValue[key-1] +=  rooms[linkedRooms.get(i)-1];
			}
			roomsValue[key-1] += rooms[key - 1];
		}
	}
}
