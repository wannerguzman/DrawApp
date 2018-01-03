import java.awt.BasicStroke; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
/**
 * Class that performs the main functionalities of painting on the screen.
 * Extend the JPanel class and implements MouseMotionListener interface.
 * Must implement MouseMotionListener interface methods.
 * @author wanner
 *
 */
public class Painting extends JPanel implements MouseMotionListener{
	
	
	private static final long serialVersionUID = 1L;
	
	//Default brush size.
	private int brush = 5;
	
	//Store last we used to paint.
	private Color lastColor;
	
	//Mouse coordinates.
	private int currentX;
	private int currentY;
	private int oldX;
	private int oldY;
	
	//2D  object used to draw.
	private Graphics2D g2;
	
	//image in which we are going to draw.
	private Image image;
	/**
	 * Constructor to start the JPanel.
	 * Call super and add MouseMotionListener to this Panel.
	 */
	public Painting() {
		super();
		addMouseMotionListener(this);
	}
	/**
	 * method to paint on JPanel.
	 */
	public void paint(Graphics g) {
		if(image==null) {
			// image to draw null ==> we create.
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			// enable initializing.
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			// Clear draw area.
			clear();	
		}
		g.drawImage(image, 0, 0, null);
	}
	/**
	 * Method to clear what has been drawn.
	 */
	public void clear() {
		   g2.setPaint(Color.DARK_GRAY);
		   // draw white on entire draw area to clear.
		   g2.fillRect(0, 0, getSize().width, getSize().height);
		   g2.setPaint(Color.white);
		   repaint();
	}
	public void changeColor(Color c) {
		g2.setPaint(c);
	}
	/**
	 * Change the size of brush.
	 * @param s
	 */
	public void brushSize(int s) {
		brush = s;
	}
   /**
    * Set the color same as background to erase.
    */
   public void erase() {
	   lastColor = g2.getColor();
	   g2.setPaint(Color.DARK_GRAY);
   }
   /**
    * Undo erase from reseting the color to the last color.
    */
   public void undoerase() {
	   g2.setPaint(lastColor);
   }
   /**
    * Called when detects the mouse course being pressed and hold on screen.
    * Function draws a line from the old x and y coordinates to the new one.
    * Updates the last old x and y coordinates.
    * @param MouseEvent e
    */
   @Override
   public void mouseDragged(MouseEvent e) {
        // cord x,y when drag mouse
        currentX = e.getX();
        currentY = e.getY();
 
        if (g2 != null) {
          g2.setStroke(new BasicStroke(brush));
          // draw line if g2 context not null
          g2.drawLine(oldX, oldY, currentX, currentY);
          // refresh draw area to repaint
          repaint();
          // store current cords x,y as old x,y
          oldX = currentX;
          oldY = currentY;
        }
		
	}
	/**
	 * Called when detects the mouse courser.
	 * This is how I obtain the old x axis and the old y axis that the mouse last detected.
	 * Detects by move without touching the screen.
	 * @param MouseEvent e
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
	}
}
