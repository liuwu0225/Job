package MagicCube;

import java.util.ArrayList;
import java.util.Arrays;

public class Cube {
	int len = 0;
	int[] values = null;
	
	public Cube(int len, int[] values) {
		super();
		this.len = len;
		this.values = values;
	}

	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int[] getValues() {
		return values;
	}
	public void setValues(int[] values) {
		this.values = values;
	}
	
	
}
