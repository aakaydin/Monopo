import java.awt.event.*;
import java.util.*;

public class IA{


	// Attributs
	private Joueur J;
	private ActionEvent AE;
	private FenetreInterface fen;
	private Plateau P;
	private Case caseCourante; 
	
	
	
      
	
	// Constructeur
	public IA(FenetreInterface fen ){
		
		
		this.fen = fen;
		J = fen.getJoueurCourant();
		P = fen.p;
		caseCourante = P.getCases().get(J.getPos());
		
		
		Object obj = new Object();	
		AE  = new ActionEvent( obj ,  0,  "lol");
		
		
		
		}

	

	public void perform(){
		
		autoDes();
		
		/**
		
		
		
		
		
		
		
		
		
		*/
		
		System.out.println(" ~~beep~~ ");
		fen.ecouterfintour.actionPerformed( AE);
		
		}
	
	public void autoDes(){
		
		fen.ecouteurdes.setJoueur( J );
		fen.ecouteurdes.actionPerformed( AE);
		
		}
	
	public void traitementCase(){
		
		
		
		
		
		}
	
	
	public void autoAchete(){
		
		
		
		
		}
	
	
}


		
