import java.awt.Color;    
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Draw class create a JFrame to draw with different options of choosing your brush size, color and other options.
 * Main Method below.
 * @author wanner
 *
 */
public class Draw{
	
	/**
	 * Constructor creates main from for drawing.
	 * We set the bounds, background, It then calls the Menu method with creates a Menu bar.
	 * It also creates a Painting object and adds it to the frame, also adds the Menu bar to frame.
	 */
	public Draw() {	
		//make a JFrame.
		//JFrame is the window.
		JFrame obj = new JFrame();
		
		Painting painting = new Painting();
		
		obj.setLayout(null);    
		obj.setBounds(10, 10, 905, 720);
		obj.setTitle("Paint");
		obj.getContentPane().setBackground(Color.white);
		obj.setResizable(false); 							//setResizable to false so user can't change size of frame.
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit application using system exit.
		//Create button needed add to frame as well as painting.
		
		painting.setBounds(0,0,905,720);
		obj.add(painting);
		Menu(obj,painting);
		obj.setVisible(true);								//True to make window visible. 
	}
	/**
	 * Create A Menu Bar and add it to the JFrame. We add three different JMenu Bar tabs and change the font of the tabs.
	 * We then call the OptionMenu to add to the file tab.
	 * Call the brushSize method to add different brush sizes options.
	 * calls the colorOptions to add different color options to the color tab.
	 * @param obj
	 * @param painting
	 */
	private void Menu(JFrame obj, Painting painting) {
		JMenuBar menuBar = new JMenuBar();
		obj.setJMenuBar(menuBar);
		
		Font bigFont = new Font("Serif", Font.BOLD,24);
		
		//Add File tab to menu and add to drop down menu for other options.
		JMenu file = new JMenu("File");
		file.setFont(bigFont);
		menuBar.add(file);
		optionMenu(file,painting,bigFont);
		
		//Add Color JMenu option and add drop down menu for different color options.
		JMenu color = new JMenu("Color");
		color.setFont(bigFont);
		menuBar.add(color);
		colorOptions(color, painting, bigFont);
		
		
		//Add Brush size Option and add drop down menu for different brush sizes.
		JMenu brush = new JMenu("Brush Size");
		brush.setFont(bigFont);
		menuBar.add(brush);	
		brushSize(brush,painting,bigFont);
	}
	/**
	 * This method adds to the drop down menu file.
	 * I add four different options, which were paint, erase, delete.
	 * It receives the JMenu file created in the constructor, a Font for the MenuItems and a Painting JPanel.
	 * We will add the options to the JMenu parameter.
	 * We need a Painting JPanel so we can modify the options.
	 * Font parameter makes it for easier to set the font for the JMenuItem.
	 * Adds actionListener to all JMemuItem each item so we can change it to the option chosen.
	 * @param file
	 * @param painting
	 * @param bigFont
	 */
	private void optionMenu(JMenu file,Painting painting,Font bigFont) {
		JMenuItem erase = new JMenuItem("Erase");
		erase.setFont(bigFont);
		erase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.erase();
			}
			
		});
		JMenuItem delete = new JMenuItem("Delete");
		delete.setFont(bigFont);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.clear();
			}
			
		});
		JMenuItem paint = new JMenuItem("Paint");
		paint.setFont(bigFont);
		paint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.undoerase();
			}
			
		});
		file.add(erase);
		file.addSeparator();
		file.add(delete);
		file.addSeparator();
		file.add(paint);
	}
	/**
	 * This method adds to the drop down menu of brush size.
	 * I add four different brush sizes.
	 * It receives the JMenu stroke created in the constructor, a Font for the MenuItems and a Painting JPanel.
	 * We will add brush sizes to the JMenu parameter.
	 * We need a Painting JPanel so we can modify the brush size.
	 * Font parameter makes it for easier to set the font for the JMenuItem.
	 * Adds actionListener to all JMemuItem and changes the size when chosen.
	 * @param brush
	 * @param painting
	 * @param bigFont
	 */
	private void brushSize(JMenu brush, Painting painting, Font bigFont) {
		JMenuItem small = new JMenuItem("Small");
		small.setFont(bigFont);
		small.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.brushSize(1);

			}
			
		});
		JMenuItem regular = new JMenuItem("Regular");
		regular.setFont(bigFont);
		regular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.brushSize(5);

			}
			
		});
		JMenuItem large = new JMenuItem("Large");
		large.setFont(bigFont);
		large.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.brushSize(15);
	
			}
			
		});
		JMenuItem extralarge = new JMenuItem("ExtraLarge");
		extralarge.setFont(bigFont);
		extralarge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.brushSize(25);
	
			}
			
		});
		brush.add(small);
		brush.addSeparator();
		brush.add(regular);
		brush.addSeparator();
		brush.add(large);
		brush.addSeparator();
		brush.add(extralarge);
	}
	/**
	 * This method adds to the drop down menu of Color.
	 * I added all the possible colors I could add.
	 * It receives the JMenu Color created in the constructor, a Font for the MenuItems and a Painting JPanel.
	 * We will add colors to the JMenu parameter.
	 * We need a Painting JPanel so we can modify the color.
	 * Font parameter makes it for easier to set the font for the JMenuItem.
	 * Adds actionListener to all JMemuItem and changes the color when chosen.
	 * @param color
	 * @param painting
	 * @param bigFont
	 */
	private void colorOptions(JMenu color, Painting painting, Font bigFont) {
		JMenuItem blue = new JMenuItem("Blue");
		blue.setFont(bigFont);
		blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.BLUE);

			}
			
		});
		JMenuItem green = new JMenuItem("Green");
		green.setFont(bigFont);
		green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.GREEN);

			}
			
		});
		JMenuItem orange = new JMenuItem("Orange");
		orange.setFont(bigFont);
		orange.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.ORANGE);
	
			}
			
		});
		JMenuItem red = new JMenuItem("Red");
		red.setFont(bigFont);
		red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.RED);
	
			}
			
		});
		JMenuItem yellow = new JMenuItem("Yellow");
		yellow.setFont(bigFont);
		yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.YELLOW);
	
			}
			
		});
		JMenuItem white = new JMenuItem("White");
		white.setFont(bigFont);
		white.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.white);
	
			}
			
		});
		JMenuItem pink = new JMenuItem("Pink");
		pink.setFont(bigFont);
		pink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.PINK);
	
			}
			
		});
		JMenuItem cyan = new JMenuItem("Cyan");
		cyan.setFont(bigFont);
		cyan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.CYAN);
	
			}
			
		});
		JMenuItem magenta = new JMenuItem("Magenta");
		magenta.setFont(bigFont);
		magenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				painting.changeColor(Color.magenta);
	
			}
			
		});
		color.add(blue);
		color.addSeparator();
		color.add(green);
		color.addSeparator();
		color.add(orange);
		color.addSeparator();
		color.add(red);
		color.addSeparator();
		color.add(yellow);
		color.addSeparator();
		color.add(white);
		color.addSeparator();
		color.add(pink);
		color.addSeparator();
		color.add(cyan);
		color.addSeparator();
		color.add(magenta);
	}
	/**
	 * Main method create the class to perform all the functionalities
	 * @param args
	 */
	public static void main(String[] args) {
		new Draw();
	}
}
