// Assignment #: 7
//Name: Jonas Khan
//StudentID: 120-6550-640
//Lecture: 1
//Class Time:10:20
//Description: The whole panel creates components for the whole panel
//of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
//and PointListner classes.


import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}





