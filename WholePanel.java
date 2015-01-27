// Assignment #: 7
//         Name:Wade Kariniemi
//    StudentID: 120211213
//      Lecture: MWF
//      Class Time: 9-950
//  Description: The whole panel creates components for the whole panel
//  of this applet. It also contains CanvasPanel, ButtonListener, ColorListener,
//  and PointListner classes.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel primary, buttonPanel, leftPanel;
   private JButton erase, undo;
   private ArrayList rectList, tempList;
   private JRadioButton[] colorRButtons;
   private Color[] colors;
   private int x1, y1, x2, y2, x3, y3;
   private boolean mouseDragged = false;

   //Constructor to instantiate components
   public WholePanel()
   {
	  //default color to draw rectangles is black
      currentColor = Color.black;
	  rectList = new ArrayList();

      //create buttons
      erase = new JButton("Erase");
      undo = new JButton("Undo");

      //create radio buttons for 5 colors
      colorRButtons[0] = new JRadioButton("Black");
      colorRButtons[1] = new JRadioButton("Red");
      colorRButtons[2] = new JRadioButton("Blue");
      colorRButtons[3] = new JRadioButton("Green");
      colorRButtons[4] = new JRadioButton("Orange");
      
      //black will be chosen by default
	  colorRButtons = new JRadioButton[5];
	  colorRButtons[0] = new JRadioButton("black", true);


      //store 5 colors in an array
      colors[0] = Color.black;
      colors[1] = Color.red;
      colors[2] = Color.blue;
      colors[3] = Color.green;
      colors[4] = Color.orange;

      //group radio buttons so that when one is selected,
      //others will be unselected.
     
      ButtonGroup group  = new ButtonGroup();
      group.add(colorRButtons[0]);  
      group.add(colorRButtons[1]);  
      group.add(colorRButtons[2]);  
      group.add(colorRButtons[3]);  
      group.add(colorRButtons[4]);  
	 
      // ButtonGroup group = new ButtonGroup();
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
    }

   //ButtonListener defined actions to take in case "Create",
   //"Undo", or "Erase" is chosed.
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
          JButton selectedButton = (JButton) event.getSource();  

          if(selectedButton == undo)
          {
           //   for (int i > -1; i < rectList.size(); i--)
           //   {
                  rectList.remove(rectList.size()-1);
                  canvas.repaint();
           //   }
          }
             
          if(selectedButton == erase)
          {
              rectList.clear();
              canvas.repaint();
          }
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
		  for (int i=0; i < rectList.size(); i++)
          {
              ((Rect) rectList.get(i)).draw(page);
          }

          //draw an outline of the rectangle that is currently being drawn.
          if (mouseDragged == true)
          {
			page.setColor(currentColor);
            //Assume that a user will move a mouse only to left and down from
            //the first point that was pushed.
            page.drawRect(x1, y1, x3-x1, y3-y1);
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





     }

     //mouseReleased method takes the point where a mouse is released,
     //using the point and the pressed point to create a rectangle,
     //add it to the ArrayList "rectList", and call paintComponent method.
     public void mouseReleased (MouseEvent event)
     {




     }

     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent nethod
     public void mouseDragged(MouseEvent event)
     {



	            canvas.repaint();
     }

     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
     public void mouseMoved(MouseEvent event) {}

   } // end of PointListener

} // end of Whole Panel Class
