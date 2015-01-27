
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class Rect
{
    private int x, y, width, height;
    private Color color;
   
    //constructor that takes position, size,  color
    public Rect( int x, int y, int width, int height,  Color color)    
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics page) //draws rectangle on screen
    {
        page.setColor(color);
        page.drawRect(x, y, width, height);
    }

}
