package MagicCube;

public class Cube {
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
					System.out.print("(" + z + "," + y + "," + x + ") = " + values[i]);
					i++;
				}
			}
		}
		System.out.println("");
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
				for (int k = x; k < k + length; k++) {
					values[m] = this.values[i][j][k];
					m++;
				}
			}
		}
		Cube subCube = new Cube(length, values);
		return subCube;
	}
}
