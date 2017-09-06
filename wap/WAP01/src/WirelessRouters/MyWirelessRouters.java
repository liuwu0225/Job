/**
 * @author Wu Liu /Fudan University /15212010038@fudan.edu.cn
 * 
 * The core idea of the solution is to calculate the value of every room, 
 * and then select the maximum one. Next, put a new wireless router and 
 * calculate rooms value again and select the maximum one. We do iteration 
 * until the routers run out and output the maximum point of satisfaction.
 * 
 * ROOM VALUE is the sum of its own and adjacent rooms satisfaction point.
 * if the room is covered by Wifi, set its satisfaction point as 0.
 * */

package WirelessRouters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyWirelessRouters {
	public static void main(String[] args) throws FileNotFoundException {
		//MaxPoint is the maximum point of satisfaction, N is the number of room,
		//M is the number of wireless routers, rooms represents the satisfaction
		//point of each room, roomsValue saves the value of each room. room_linkedRooms
		//saves the relationship of each room and its adjacent rooms. 
		int MaxPoint = 0;
		int N = 0;
		int M = 0;
		int[] rooms = null;
		int[] roomsValue = null;
		HashMap<Integer, ArrayList<Integer>> room_linkedRooms = new HashMap<Integer, ArrayList<Integer>>();
		//Scanner ss = new Scanner(System.in);
		//'data2.txt' is used to test.
		Scanner ss = new Scanner(new File("data2.txt"));
		int flag = 1;
		//Initialize and process the input data. If flag = 1, initialize N and M,
		//if flag = 2, initialize the satisfaction point of each room, else handle the
		//relationship between rooms.
		while(ss.hasNext()){
			String[] strArr = ss.nextLine().split(" ");
			if(flag == 1){
				int[] intArr1= MyUtil.strArray2intArray(strArr);
				N = intArr1[0];
				M = intArr1[1];
			}else if(flag == 2){
				rooms = MyUtil.strArray2intArray(strArr);
				roomsValue = rooms.clone();
				roomsValue = MyUtil.intArrayClear(roomsValue);
			}else{
				int[] intArr2 = MyUtil.strArray2intArray(strArr);
				MyUtil.saveRoom(room_linkedRooms, intArr2);
			}
			flag++;
		}
		//calculate rooms value and save in roomsValue, then pick the maximum and
		//add to MaxPoint.
		for (int i = 0; i < M; i++) {
			MyUtil.calculateValue(room_linkedRooms, rooms, roomsValue);
			int[] selected = MyUtil.getMaxInArray(roomsValue);
			int roomNumber = selected[1];
			MaxPoint += selected[0];
			//set rooms which is covered by Wifi covered as value = 0
			if(roomNumber != 0){
				rooms[roomNumber-1] = 0;
				ArrayList<Integer> linkedRooms =  room_linkedRooms.get(roomNumber);
				for(int j = 0;j < linkedRooms.size(); j ++){
					rooms[linkedRooms.get(j)-1] = 0;
				}
			}
			roomsValue = MyUtil.intArrayClear(roomsValue);
		}
		//Output the maximum point of satisfaction.
		System.out.println(MaxPoint);
	}
}
