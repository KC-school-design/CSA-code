import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class practice2 extends JPanel {

	// Practice calling methods with parameters
	// by drawing the required shapes/patterns from the document
	public void paint(Graphics pen) {

		pen.setColor(Color.black);

		// rectangle and quadrant setup
		pen.drawRect(10, 10, 1000, 700);
		// pen.drawLine(10, 355, 1010, 355);
		// pen.drawLine(505, 10, 505, 710);

		// point a (x1, y 1)
		// point b (x2, y2)

		int x1 = 10; // top-left corner
		int y1 = 10; //
		int x2 = 10; // bottom left corner
		int y2 = 710;
		int xn = 110;
		int yn = 100;
		int lines = 1;
		pen.setColor(Color.orange);
		// for loop that runs 100 times (can vary)
		for (int layer = 0; layer < 4; layer++) {
		
			
			int factor = 1;
			int left;
			int right; 
			int top;
			int bottom;
			if (layer == 0) {
				lines = 100;
				 left = 10 + layer * xn;
				 right = 1010 - layer * xn;
				 top = 10 + layer * yn;
				 bottom = 710 - layer * yn;
			}
			else
			{
				if (layer < 3) {
					factor = layer * 2;
				}
				else {factor = layer * layer;}
				
				lines = 100/factor;
				 left = 10 + (500 - 500 / factor);
				 right = 1010 - (500 - 500 / factor);
				 top = 10 + (350 - 350 / factor);
				 bottom = 710 - (350 - 350 / factor);
				
			}

					
			
			double xStep = (double) (right - left) / lines;
			double yStep = (double) (bottom - top) / lines;

			x1 = left;
			y1 = top;
			x2 = left;
			y2 = bottom;

			for (int cntr = 0; cntr < lines; cntr++) {
				pen.drawLine(x1, y1, x2, y2);
				// top point moves to the right each time
				x1 = (int) (x1 + xStep);
				// bottom point moves up
				y2 = (int) (y2 - yStep);
			}

			// reset x1, y1, x2, y2 so the represent the right side vertical lines
			// reset means "assign" in this context

			x1 = right;
			y1 = top;
			x2 = right;
			y2 = bottom;
			for (int cntr = 0; cntr < lines; cntr++) {
				pen.drawLine(x1, y1, x2, y2);
				x1 = (int) (x1 - xStep); // top point moves left this time
				y2 = (int) (y2 - yStep);
			}

			x1 = left;
			y1 = bottom;
			x2 = left;
			y2 = top;

			for (int cntr = 0; cntr < lines; cntr++) {
				pen.drawLine(x1, y1, x2, y2);
				x1 = (int) (x1 + xStep);
				y2 = (int) (y2 + yStep);
			}

			x1 = right;
			y1 = bottom;
			x2 = right;
			y2 = top;

			for (int cntr = 0; cntr < lines; cntr++) {
				pen.drawLine(x1, y1, x2, y2);
				x1 = (int) (x1 - xStep);
				y2 = (int) (y2 + yStep);

			}
		}
	}

	// verticalLines(pen);
	// randomLines(pen);
	// randomSquares(pen);
	// randomCircles(pen);

	/*
	 * Top-left quadrant Draw 200 vertical lines with different colors per line
	 */
	public void verticalLines(Graphics pen) {
		pen.drawString("vertical lines", 30, 40);

		int x1 = 50;
		int y1 = 50;
		int x2 = 50;
		int y2 = 250;
		int cntr = 0;

		while (cntr < 200) {
			System.out.println("Hello");

			// Generate a random color per line
			// (int)(Math.random()*(max-min+1)) + min;
			int red = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int green = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int blue = (int) (Math.random() * (255 - 0 + 1)) + 0;

			Color randC = new Color(red, green, blue);
			pen.setColor(randC);

			pen.drawLine(x1, y1, x2, y2);
			x1 += 2;
			x2 += 2;

			// update the control variable
			// else you might end up in an infinite loop
			cntr++;
			// variables for point A and point B
			// the end points of drawLine

		}
	} // End code of randomLines method

	/*
	 * Top-right quadrant Draw a bunch of different lines with random orientation
	 * (random starting and ending point) Use different colors
	 */
	public void randomLines(Graphics pen) {
		pen.drawString("random lines", 520, 40);

		int x1 = 550;
		int y1 = 50;
		int x2 = 550;
		int y2 = 250;
		int cntr = 0;

		while (cntr < 200) {
			int red = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int green = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int blue = (int) (Math.random() * (255 - 0 + 1)) + 0;

			Color randC = new Color(red, green, blue);
			pen.setColor(randC);

			pen.drawLine(x1, y1, x2, y2);

			x1 = (int) (Math.random() * (980 - 550 + 1)) + 550;
			x2 = (int) (Math.random() * (980 - 550 + 1)) + 550;
			y1 = (int) (Math.random() * (355 - 10 + 1)) + 10;
			y2 = (int) (Math.random() * (355 - 10 + 1)) + 10;

			cntr++;

		}

	} // end or random lines

	/*
	 * Draw 100 squares randomly placed in bottom-left quadrant. Each square is a
	 * different color and is filled in.
	 * 
	 * They should not overflow out of the bottom-left quadrant.
	 */
	public void randomSquares(Graphics pen) {
		pen.drawString("random squares", 30, 390);

		int x1 = 50;
		int y1 = 500;
		int cntr = 0;

		while (cntr < 100) {
			int red = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int green = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int blue = (int) (Math.random() * (255 - 0 + 1)) + 0;

			Color randC = new Color(red, green, blue);
			pen.setColor(randC);

			pen.fillRect(x1, y1, 50, 50);

			x1 = (int) (Math.random() * (430 - 10 + 1)) + 10;
			y1 = (int) (Math.random() * (660 - 355 + 1)) + 355;

			cntr++;
		}

	}

	/*
	 * Draw 50 circles with random size from 30-200 in width. Use different colors.
	 * They should not overflow out of the bottom-right quadrant
	 */
	public void randomCircles(Graphics pen) {
		pen.drawString("random circles", 520, 390);

		int x1 = 700;
		int y1 = 500;
		int size1 = 100;

		int cntr = 0;

		while (cntr < 200) {
			int red = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int green = (int) (Math.random() * (255 - 0 + 1)) + 0;
			int blue = (int) (Math.random() * (255 - 0 + 1)) + 0;

			Color randC = new Color(red, green, blue);
			pen.setColor(randC);

			pen.drawOval(x1, y1, size1, size1);

			size1 = (int) (Math.random() * (200 - 20 + 1)) + 20;
			x1 = (int) (Math.random() * (800 - 540 + 1)) + 520;
			y1 = (int) (Math.random() * (510 - 355 + 1)) + 355;

			cntr++;
		}

	}

	public static void main(String[] arg) {
		practice2 m = new practice2();
	}

	public practice2() {
		JFrame f = new JFrame("Loops & Math.random");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1040, 768);
		f.setResizable(false);
		f.add(this);
		f.setVisible(true);

	}
}
