public class TestLine{

	public static void main(String[] args) {
        
        Line line1 = new Line(0.625, 9.241, 2.037, 1.649, Color.PURPLE);
        Line line2 = new Line(1.757, 5.720, 3.015, 9.356, Color.CYAN);
        Line line3 = new Line(5.419, 8.229, 3.512, 4.056, Color.PINK);
        Line line4 = new Line(9.660, 7.412, 9.765, 1.750, Color.ORANGE);
        
        System.out.println(/*"\u001B[35m" + */line1.toString() + "\u001B[0m" + " has length " + line1.length());
        System.out.println(/*"\u001B[36m" + */line2.toString() + /*"\u001B[0m" + */" has length " + line2.length());
        System.out.println(/*"\u001B[38;5;212m" +*/ line3.toString() /*+ "\u001B[0m"*/ + " has length " + line3.length());
        System.out.println(/*"\u001B[38;5;202m" +*/ line4.toString() + /*"\u001B[0m" + */ " has length " + line4.length());
        
	}
}
