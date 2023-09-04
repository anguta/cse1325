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
	    return this.name() + " (" + String.format("0x%06X",rgb) + ") ";
	}  

}
