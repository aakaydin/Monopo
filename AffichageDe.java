import javax.swing.*;
import java.awt.*;

import java.util.LinkedList;

public class AffichageDe extends JPanel{

		private int de1;
		private int de2;
		
		
		private int cote = 50;
		private int rayon = cote/5;
		
		
	public AffichageDe(){
		
	
		de1 = 5;
		de2 = 6	;
		
		}

	 protected void paintComponent( Graphics g){
		
		
		
		super.paintComponent( g );
		
					 g.setColor(Color.WHITE);
					 g.fillRect( 5 , 5  , cote , cote) ; 
					 g.fillRect( cote+10 , 5  , cote , cote) ;
					 
					 g.setColor(Color.BLACK);
					 
					 if(de1 == 1  )  g.fillOval(  25 , 25    , rayon , rayon) ; 
					 
					 if(de2 == 1  )  g.fillOval( 25 + cote + 5 , 25  , rayon , rayon) ; 
					
					 if(de1 == 2  ){  
						 
						 g.fillOval( 15 , 15  , rayon , rayon) ; 
						 g.fillOval( 35 , 35  , rayon , rayon) ;
					 }
					 
					 if(de1 == 3  ){  
						 
						 g.fillOval( 15 , 15  , rayon , rayon) ; 
						 g.fillOval(  25 , 25  , rayon , rayon) ;
						 g.fillOval( 35 , 35  , rayon , rayon) ;
					 }
					 
					 if(de1 == 4  ){  
						 
						 g.fillOval( 15 , 15  , rayon , rayon) ; 
						 g.fillOval( 15 , 35  , rayon , rayon) ; 
						 g.fillOval( 35 , 35  , rayon , rayon) ;
						 g.fillOval( 35 , 15  , rayon , rayon) ; 
					 }
					 
					  if(de1 == 5  ){  
						 
						 g.fillOval( 15 , 15  , rayon , rayon) ; 
						 g.fillOval( 15 , 35  , rayon , rayon) ; 
						 g.fillOval(  25 , 25  , rayon , rayon) ;
						 g.fillOval( 35 , 35  , rayon , rayon) ;
						 g.fillOval( 35 , 15  , rayon , rayon) ; 
					 }
					 
					   if(de1 == 6  ){  
						 
						 g.fillOval( 15 , 15  , rayon , rayon) ; 
						 g.fillOval( 15 , 35  , rayon , rayon) ; 
						 g.fillOval( 15 , 25  , rayon , rayon) ;
						 g.fillOval( 35 , 25  , rayon , rayon) ;
						 g.fillOval( 35 , 35  , rayon , rayon) ;
						 g.fillOval( 35 , 15  , rayon , rayon) ; 
						  
					 }
					 
					  if(de2 == 2  ){  
						 
						 g.fillOval( 15 + cote + 5, 15  , rayon , rayon) ; 
						 g.fillOval( 35 + cote + 5, 35  , rayon , rayon) ;
					 }
					 
					 if(de2 == 3  ){  
						 
						 g.fillOval( 15 + cote + 5, 15  , rayon , rayon) ; 
						 g.fillOval( 25 + cote + 5, 25  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5, 35  , rayon , rayon) ;
					 }
					 
					 if(de2 == 4  ){  
						 
						 g.fillOval( 15 + cote + 5, 15  , rayon , rayon) ; 
						 g.fillOval( 15 + cote + 5, 35  , rayon , rayon) ; 
						 g.fillOval( 35 + cote + 5, 35  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5, 15  , rayon , rayon) ; 
					 }
					 
					  if(de2 == 5  ){  
						 
						 g.fillOval( 15 + cote + 5, 15  , rayon , rayon) ; 
						 g.fillOval( 15 + cote + 5, 35  , rayon , rayon) ; 
						 g.fillOval( 25 + cote + 5, 25  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5, 35  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5, 15  , rayon , rayon) ; 
					 }
					 
					   if(de2 == 6  ){  
						 
						 g.fillOval( 15 + cote + 5 , 15  , rayon , rayon) ; 
						 g.fillOval( 15 + cote + 5 , 35  , rayon , rayon) ; 
						 g.fillOval( 15 + cote + 5 , 25  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5 , 25  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5 , 35  , rayon , rayon) ;
						 g.fillOval( 35 + cote + 5 , 15  , rayon , rayon) ; 
						  
					 }
				
			}
			
}
							
			
		
			
