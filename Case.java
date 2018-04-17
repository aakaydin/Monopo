import java.awt.* ;
import javax.swing.*;


public class Case{

	private int position;
	private String nom;
	private String desc;
	private JPanel panel;

	// Constructeur avec position + nom  
	public Case( int pos , String name, String desc ){
		
		nom = name;
		position = pos;
		this.desc = desc;
		
	}
	
	//Constructeur avec position et nom 
    	public Case(int pos , String name){
        	nom = name; 
        	position = pos;
    	}
		
	// Constructeur avec position	
	public Case( int pos){
		
		
		position = pos;
		
		
		}
	
	
	
	// Getteurs
	
	public String getNom(){
		
		
		return nom;
		
		}
	
	public int getPos(){
		
		
		return position;
		
		}
	
	public JPanel getPanel(){return panel;}
	
}
