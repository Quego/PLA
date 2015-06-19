package enumere;


public enum Orientation {

	NORD("Nord"), EST("Est"), SUD("Sud"), OUEST("Ouest");
	
	private String orientation;
	
	private Orientation(String o) {
		this.orientation = o;
	}
	
	public int orientationToInt() {
		if (this == NORD) return 0;
		if (this == OUEST) return 1;
		if (this == SUD) return 2;
		return 3;
	}
	
	public String toString() {
		return this.orientation;
	}
	
}
