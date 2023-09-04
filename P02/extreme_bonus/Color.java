public enum Color {
	PURPLE(0x800080),
	CYAN(0x00FFFF),
	PINK(0xFFC0CB),
	ORANGE(0xFFA500);
	
	private final int rgb;
	
	private Color(int rgb) {
	    this.rgb = rgb;
	}
	
	@Override
	// toString
	public String toString() {
	    if(this == PURPLE) {
	        return this.name() + " (" + "\u001B[35m" + String.format("0x%06X",rgb) + "\u001B[0m" + ") ";
	    }
	    else if(this == CYAN) {
	        return this.name() + " (" + "\u001B[36m" + String.format("0x%06X",rgb) + "\u001B[0m" + ") ";
	    }
	    else if(this == PINK) {
	        return this.name() + " (" + "\u001B[38;5;212m" + String.format("0x%06X",rgb) + "\u001B[0m" + ") ";
	    }
	    else {
	        return this.name() + " (" + "\u001B[38;5;202m" + String.format("0x%06X",rgb) + "\u001B[0m" + ") ";
	    }
	    /* return this.name() + " (" + String.format("0x%06X",rgb) + ") "; */
	} 

}
