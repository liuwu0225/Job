package demo;

public class DemoEntity {
	//private String Object1;
	//private String Object2;
	//private String Object3;
	//private String Object4;
	//private String Object5;

	private List<String> Objects = new ArrayList<String>();
	
	public DemoEntity() {
		super();
	}
	public DemoEntity(String object1, String object2, String object3,
			String object4, String object5) {
		super();
		//Object1 = object1;
		//Object2 = object2;
		//Object3 = object3;
		//Object4 = object4;
		//Object5 = object5;
		Objects.add()
	}
	public String getObject1() {
		return Object1;
	}
	public void setObject1(String object1) {
		Object1 = object1;
	}
	public String getObject2() {
		return Object2;
	}
	public void setObject2(String object2) {
		Object2 = object2;
	}
	public String getObject3() {
		return Object3;
	}
	public void setObject3(String object3) {
		Object3 = object3;
	}
	public String getObject4() {
		return Object4;
	}
	public void setObject4(String object4) {
		Object4 = object4;
	}
	public String getObject5() {
		return Object5;
	}
	public void setObject5(String object5) {
		Object5 = object5;
	}
}
