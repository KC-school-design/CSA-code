import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopsPractice extends JPanel{
	
	// Practice calling methods with parameters
	// by drawing the required shapes/patterns from the document
	public void paint(Graphics pen) {
		
		pen.setColor(Color.black);
		
		//rectangle and quadrant setup
		pen.drawRect(10, 10, 1000, 700);
		pen.drawLine(10, 355, 1010, 355);
		pen.drawLine(505, 10, 505, 710);
		
		
		verticalLines(pen);
		randomLines(pen);
		randomSquares(pen);
		randomCircles(pen);
		
		
		
		
		
		
		
		
	
	}
	
	/*
	 * Top-left quadrant
	 * Draw 200 vertical lines
	 * with different colors per line
	 */
	public void verticalLines(Graphics pen) {
		pen.drawString("vertical lines", 30, 40);
		
		
		int x1 = 50;
		int y1 = 50;
		int x2 = 50;
		int y2 = 250;
		int cntr = 0;

			while(cntr < 200) {
			System.out.println("Hello");
			
			//Generate a random color per line
			//(int)(Math.random()*(max-min+1)) + min;
			int red = (int)(Math.random()*(255-0+1)) + 0;
			int green = (int)(Math.random()*(255-0+1)) + 0;
			int blue = (int)(Math.random()*(255-0+1)) + 0;
			
			Color randC = new Color(red, green, blue);
			pen.setColor(randC);
			
			pen.drawLine(x1, y1, x2, y2);
			x1 += 2;
			x2 += 2;
			
			//update the control variable
			// else you might end up in an infinite loop
			cntr++; 
			//variables for point A and point B 
			// the end points of drawLine
			
		
		}
	} //End code of randomLines method
	
	
	
	/*
	 * Top-right quadrant
	 * Draw a bunch of different lines with
	 * random orientation (random starting and ending point)
	 * Use different colors
	 */
	public void randomLines(Graphics pen) {
		pen.drawString("random lines", 520, 40);
		
		int x1 = 550;
		int y1 = 50;
		int x2 = 550;
		int y2 = 250;
		int cntr = 0;
		 
		
		while (cntr < 200) {
			int red = (int)(Math.random()*(255-0+1)) + 0;
			int green = (int)(Math.random()*(255-0+1)) + 0;
			int blue = (int)(Math.random()*(255-0+1)) + 0;
			
			Color randC = new Color(red, green, blue);
			pen.setColor(randC);
			
			
			
			pen.drawLine(x1, y1, x2, y2);
			
			x1 = (int)(Math.random()*(1000-550+1))+550;
			x2 = (int)(Math.random()*(1000-550+1))+550;
			y1 = (int)(Math.random()*(355-10+1))+10;
			y2 = (int)(Math.random()*(10);			

			
			cntr++;	
		
		
		}
		
	}
	
	
	/*
	 * Draw 100 squares randomly placed in 
	 * bottom-left quadrant. 
	 * Each square is a different color and
	 * is filled in.
	 * 
	 * They should not overflow out of the 
	 * bottom-left quadrant.
	 */
	public void randomSquares(Graphics pen) {
		pen.drawString("random squares", 30, 390);
		
		
	}
	
	/*
	 * Draw 50 circles with random size from 
	 * 30-200 in width.
	 * Use different colors. 
	 * They should not overflow out of the 
	 * bottom-right quadrant 
	 */
	public void randomCircles(Graphics pen) {
		pen.drawString("random circles", 520, 390);
		
		
	}
	
	
	public static void main(String[] arg) {
		LoopsPractice m = new LoopsPractice();
	}
	
	public LoopsPractice() {
		JFrame f = new JFrame("Loops & Math.random");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1040,768);
		f.setResizable(false);
		f.add(this);
		f.setVisible(true);
		
	}
}
