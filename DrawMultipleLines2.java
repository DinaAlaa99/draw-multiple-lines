import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawMultipleLines2 extends Applet{
	
    int iStart=0;
	int iEnd=0;
	
	ArrayList<Point> pStart = new ArrayList<Point>() ;
	ArrayList<Point> pEnd  = new ArrayList<Point>();
   
    Point p;
	
	boolean dragged;
    int draggedX;
	int draggedY;

	
	public class Point {
		int x;
		int y;
	}
	

	
	public void init(){
	  
	 
		
        
		this.addMouseListener(new MouseAdapter() {
	
		public void mousePressed(MouseEvent e) { 
		    
		    Point p=new Point();
		   
		
			
			p.x=e.getX();
			p.y=e.getY();
			
			pStart.add(p);
			iStart++;
			
			
			
		    	
		    
			
		}
		
	    public void mouseReleased(MouseEvent e) { 
		    
			Point p=new Point();
			
			
		
			dragged=false;
			
			p.x=e.getX();
			p.y=e.getY();
			
			pEnd.add(p);
		    
		    repaint();
			iEnd++;
			
			
			
		    
			
			
			   
		}
		});
		
		this.addMouseMotionListener(new MouseAdapter(){
	    public void mouseDragged(MouseEvent e) { 
		   
		 	dragged=true;
			draggedX=e.getX();
			draggedY=e.getY();
		    
			repaint(); 
		} 
	    });
	}	
		
	
	public void paint (Graphics g){
		  int i;
		  
		  for (i=0 ;i<pEnd.size();i++)		      
			    g.drawLine(pStart.get(i).x,pStart.get(i).y,pEnd.get(i).x,pEnd.get(i).y);
			  
		 if(dragged) 
			    g.drawLine(pStart.get(i).x,pStart.get(i).y,draggedX,draggedY);
	}
	
	
}