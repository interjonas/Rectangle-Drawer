// Assignment #: 7
//Name: Jonas Khan
//StudentID: 120-6550-640
//Lecture: 1
//Class Time:10:20
//Description: The whole panel creates components for the whole panel
//of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
//and PointListner classes.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{  
	//instance variables
	
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel primary, buttonPanel, leftPanel;
   private JButton erase, undo;
   private ArrayList rectList, tempList;
   private ArrayList<Integer> data = new ArrayList<Integer>();
   private JRadioButton[] colorRButtons;
   private Color[] colors;
   private int x1, y1, x2, y2, x3, y3, counter=0;
   private boolean mouseDragged = false;

   //Constructor to instantiate components

public WholePanel()
{
	//default color to draw rectangles is black
	
	currentColor = Color.black;
	rectList = new ArrayList();
	undo = new JButton("undo");
	erase = new JButton("erase");
	undo.addActionListener (new ButtonListener());
	
	//create buttons
	//create radio buttons for 5 colors
	//black will be chosen by default
	
	colorRButtons = new JRadioButton[5];
	colorRButtons[0] = new JRadioButton("black", true);
	colorRButtons[1] = new JRadioButton("red", false);
	colorRButtons[2] = new JRadioButton("blue", false);
	colorRButtons[3] = new JRadioButton("green", false);
	colorRButtons[4] = new JRadioButton("orange", false);
	
	//store 5 colors in an array
	//group radio buttons so that when one is selected,
	//others will be unselected.
	
	ButtonGroup group = new ButtonGroup();
	for (int i=0; i<colorRButtons.length; i++)
    group.add(colorRButtons[i]);

	//add ColorListener to radio buttons
	
	ColorListener listener = new ColorListener();
	for (int i=0; i<colorRButtons.length; i++)
	colorRButtons[i].addActionListener(listener);

	//primary panel contains all radiobuttons
	
	primary = new JPanel(new GridLayout(5,1));
	for (int i=0; i<colorRButtons.length; i++)
	primary.add(colorRButtons[i]);

	//canvas panel is where rectangles will be drawn, thus
	//it will be listening to a mouse.
	
	canvas = new CanvasPanel();
	canvas.setBackground(Color.white);
	canvas.addMouseListener(new PointListener());
	canvas.addMouseMotionListener(new PointListener());
	
	JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, canvas);
	
	setLayout(new BorderLayout());
	add(sp);
	//sp.add(undo);
}

   //ButtonListener class that takes action depending on what button is 
   //pushed
private class ButtonListener implements ActionListener
{
	public void actionPerformed (ActionEvent event)
	{
		
		int i1=10;
		int i2=10;
		int i3=20;
		int i4=20;
		data.add(i1);
		data.add(i2);
		data.add(i3);
		data.add(i4);
		
		
		i1=i1+10;
		i2=i2+10;
		i3=i3+10;
		i4=i4+10;
		canvas.repaint();
		
	}
} // end of ButtonListener

// listener class to set the color chosen by a user using
// the radio buttons.

private class ColorListener implements ActionListener
{
	public void actionPerformed(ActionEvent event)
	{
		if (event.getSource() == colorRButtons[0])
        currentColor = colors[0];
		else if (event.getSource() == colorRButtons[1])
		currentColor = colors[1];
		else if (event.getSource() == colorRButtons[2])
		currentColor = colors[2];
		else if (event.getSource() == colorRButtons[3])
		currentColor = colors[3];
		else if (event.getSource() == colorRButtons[4])
		currentColor = colors[4];
	}
}

//CanvasPanel is the panel where rectangles will be drawn

private class CanvasPanel extends JPanel
{
	
//this method draws all rectangles specified by a user

public void paintComponent(Graphics page)
{
	super.paintComponent(page);
	
          //draw all rectangles

	for (int i=0;i<data.size();i=i+4) 
	{
		page.fillRect(data.get(i),data.get(i+1),data.get(i+2),data.get(i+3));
	}
	
//draw an outline of the rectangle that is currently being drawn.

	if (x2!=0 && y2!=0)
		{
			page.setColor(Color.black);
			
			//Assume that a user will move a mouse only to left and down from
			//the first point that was pushed.
			
			page.fillRect(x1, y1, x3, y3);
		}
}

} //end of CanvasPanel class

// listener class that listens to the mouse

public class PointListener implements MouseListener, MouseMotionListener
{	
	
 //in case that a user presses using a mouse,
 //record the point where it was pressed.

	public void mousePressed (MouseEvent event)
	{
	
		//after "create" button is pushed.
		x1 = event.getX();
        y1 = event.getY();
	}
	
	//mouseReleased method takes the point where a mouse is released,
	//using the point and the pressed point to create a rectangle,
	//add it to the ArrayList "rectList", and call paintComponent method.

	public void mouseReleased (MouseEvent event)
	{
		x2 = event.getX();
		y2 = event.getY();
		x3= x2-x1;
		y3=y2-y1;
		data.add(x1);
		data.add(y1);
		data.add(x3);
		data.add(y3);
		counter=counter+4;
		
	}

     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent method

	public void mouseDragged(MouseEvent event)
	{
		x2 = event.getX();
		y2 = event.getY();
		x3= x2-x1;
		y3=y2-y1;
		canvas.repaint();
	}

	public void mouseClicked (MouseEvent event) 
	{
		
	}
	public void mouseEntered (MouseEvent event) 
	{
		
	}
	public void mouseExited (MouseEvent event) 
	{
		
	}
	public void mouseMoved(MouseEvent event) {
	}

    } // end of PointListener

} // end of Whole Panel Class
