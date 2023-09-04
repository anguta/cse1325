public class TestLine{

	public static void main(String[] args) {
        
        Line line1 = new Line(0.625, 9.241, 2.037, 1.649, Color.PURPLE);
        Line line2 = new Line(1.757, 5.720, 3.015, 9.356, Color.CYAN);
        Line line3 = new Line(5.419, 8.229, 3.512, 4.056, Color.PINK);
        Line line4 = new Line(9.660, 7.412, 9.765, 1.750, Color.ORANGE);
        
        System.out.println(line1.toString() + " has length " + line1.length());
        System.out.println(line2.toString() + " has length " + line2.length());
        System.out.println(line3.toString() + " has length " + line3.length());
        System.out.println(line4.toString() + " has length " + line4.length());
        
	} 
}
