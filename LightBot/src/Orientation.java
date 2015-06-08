package src;

public enum Orientation {
	
	NORD("Nord"), EST("Est"), SUD("Sud"), OUEST("");
	
	private String orientation;
	
	private Orientation(String o) {
		this.orientation = o;
	}
	
	public String toString() {
		return this.orientation;
	}

}
