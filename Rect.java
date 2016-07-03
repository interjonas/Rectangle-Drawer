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
public class Rect 
{
int x;
int y;
Color color;
int width;
int height;
public Rect (int x1, int y1, int width, int height, Color color)
{
	x=x1;
	y=y1;
	this.width=width;
	this.height = height;
}
public void draw (Graphics page)
{
	
}
private class CanvasPanel extends JPanel
{
	public void paintComponent(Graphics page)
	{
		
	}	

}

}
