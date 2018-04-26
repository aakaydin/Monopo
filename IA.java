import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class IA{


	// Attributs
	private Joueur J;
	private ActionEvent AE;
	private FenetreInterface fen;
	private Plateau P;
	private Case caseCourante; 
	private LinkedList<Case> casesPossibles;
	
	// Constructeur
	public IA(FenetreInterface fen ){
		
		
		this.fen = fen;
		J = fen.getJoueurCourant();
		P = fen.p;
		caseCourante = P.getCases().get(J.getPos());
		casesPossibles = new LinkedList<Case>();
		
		Object obj = new Object();	
		AE  = new ActionEvent( obj ,  0,  "lol");
		
		
		
		}

	

	public void perform(){
		
		boolean temp;
		
		if( J.getPos() == 0){
			
			
			temp = true;
			
			}
		
		
		
		autoDes();
		testEnPrison();
		
		
		
		caseCourante = P.getCases().get(J.getPos());
		
		// all action listeners from all the cases;
		
		if( caseCourante instanceof CaseProp){ 
			
			CaseProp cp = (CaseProp) caseCourante;
			
			temp = realEstate( cp ); 
			
			if(temp)autoAchete( temp); // Sounds Good 
			  }
			
			 
		
		else if( caseCourante instanceof CaseTaxe  ){  // Sounds Good
			
			
			CaseTaxe c = (CaseTaxe)caseCourante;
			J.setArgent(-(c.valAPayer));
			
		}
		
		else if( caseCourante instanceof CasePrison ){
			
			J.allerEnPrison();
			}	
		
		else if( caseCourante instanceof CaseAllerPrison ){ 
			
			J.allerEnPrison();
			}
		
		else if( caseCourante instanceof CaseCagnotte ){} 
		
		else if( caseCourante instanceof CaseChance ){} 
		
		System.out.println(" ~~beep~~ ");
		fen.ecouterfintour.actionPerformed( AE);
		
	}
	
	public void testEnPrison(){
		
		if( J.enPrison ){
			
			if(J.getDe1() == J.getDe2()){
			J.setEnPrison(false); 
			J.avancer(J.getDe1() + J.getDe2()); 
			fen.getPanelCase(J.getPos()).dessinerJoueur(J);
			
                 
		}else if(J.getDe1() != J.getDe2() && J.getNbToursEnPrison() >= 3){
			J.setArgent(-50000); 
			J.setEnPrison(false); 
			
                    
            J.avancer(J.getDe1() + J.getDe2());
			fen.getPanelCase(J.getPos()).dessinerJoueur(J);
		
                    
		}else{
			J.resteEnPrison();
			fen.getPanelCase(J.getPos()).dessinerJoueur(J);
                    
		}
			
			
			
			
			}
		
		}
	
	public void autoDes(){  // Sounds Good
		
		fen.ecouteurdes.setJoueur( J );
		fen.ecouteurdes.actionPerformed( AE);
		
		}
	
	public void autoAchete( boolean b){  // Sounds Good
		
		CaseProp c = (CaseProp) caseCourante;
		
		if( c.getAchete() == false && b){
		
		J.setArgent(-c.getPrix());
		J.getMesProprietes().add(c);
		c.setProprietaire(J);
		c.setAchete(true);
		fen.plateau.getPanelCase( J.getPos()).setCouleurProp( J.col);
		fen.plateau.repaint();
		
		}else if( c.getAchete() ){
			
		int prix = c.getPrix()/10 ;
		J.setArgent(-prix);
		c.getPropri().setArgent(prix) ;
		
		}
		
		}
	
	public void fillCP(){  // Sounds Good
		
		int pos = J.getPos();
		
		for( int i = 0 ; i <= 12  ; i++){
			
			
			casesPossibles.add( P.getCases().get( pos ) );
			
			pos++;
			if( pos > 27 ) pos -= 27;
			
			}
		
		}
	
	public boolean realEstate( CaseProp cp ){ // Sounds Good dosent Work
		
			boolean buy = false;
			
			if( cp.getAchete() == false ){
				
				if( J.getSomme() > cp.getPrix()){
					
					int depenseMax = depenseMax();
					
					if( (J.getSomme() + depenseMax - cp.getPrix()) > 20000  ){
						
						
						buy = true;
						
						System.out.println(" j'achete hhahahaha");
						
						// peut ajouter more conditions
						
						}
					
					}
				
				
				}else{ System.out.println(" j'achete pas hohohohohohoho");  }
				
				
			
		
			return buy;
		
		}
		
	public int depenseMax(){
		
		fillCP();
		
		int max = 0;
		
		for( Case c : casesPossibles ){
			
			if( c instanceof CaseProp){ 
				
				CaseProp cp = (CaseProp) c;
				
				if( cp.getAchete() == true && cp.getPropri() != J ){
					
					max = -cp.getPrix();
					}
					
				if( cp.getAchete() == false ){
					
					max = -cp.getPrix();
					
				}
			}
			
			if( c instanceof CaseTaxe){
			
			CaseTaxe ct = (CaseTaxe) c;
			max = -ct.valAPayer;
				}
			
			
			// doit envisager des autres sources de perte d'argent 
			
			
			
			if( c instanceof CaseDepart){
				
				
				max += 10000;
				
				}
			
			}
			
			return max;
			
	}	
}

		
