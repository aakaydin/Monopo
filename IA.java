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
	
	// les attributs pour credit
	private static boolean dette; 
	private static int montantCredit;
	private static int tourDette;
	
	// Constructeur
	public IA(FenetreInterface fen ){
		
		
		this.fen = fen;
		J = fen.getJoueurCourant();
		P = fen.p;
		caseCourante = P.getCases().get(J.getPos());
		casesPossibles = new LinkedList<Case>();
		
		
		// on cree un ActionEvent pour pouvoir utiliser les ActionListeners
		Object obj = new Object();	
		AE  = new ActionEvent( obj ,  0,  "lol");
		
		
		
		}

	
	
	// Un tour de IA 
	public void perform(){
		
		
		boolean temp;
		
		
		
		if( J.getPos() == 0){
			
			
			temp = true;
			
			}
		
		
		acheterMaison();
		autoDes();
		testEnPrison();
		
		
		
		caseCourante = P.getCases().get(J.getPos());
		
		// Les controles en pour les cases possibles ;
		
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
		
		
		// Pour le moment IA n'interagit pas avec CaseCagnotte ou CaseChance
		else if( caseCourante instanceof CaseCagnotte ){} 
		
		else if( caseCourante instanceof CaseChance ){} 
		
		System.out.println(" ~~beep~~ "); // C'est en vrai un robot
		fen.ecouterfintour.actionPerformed( AE);
		
		
		if( dette ) tourDette++;	
		
		
		// IA rejoue si il fait un double 
		if( J.getDe1() == J.getDe2() ){
			
			perform();
			tourDette--;
		}
		
		if( tourDette == 7){
			
			J.setArgent(-J.getMensualite());
			dette = false;
			}
			
		
	}
	
	// Meme methode que dans la class Jouer adjuste pour IA
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
	
	
	// Methode qui appuie sur les boutons automatiquement
	public void autoDes(){  
		
		fen.ecouteurdes.setJoueur( J );
		fen.ecouteurdes.actionPerformed( AE);
		
		}
	// Achat d'une proporiete ou le payement a son propriaitaire
	public void autoAchete( boolean b){  
		
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
	
	// Ce methode remplis l'attribut casesPossibles, les cases sur lesquelles l'IA peut arriver le tour prochaine
	public void fillCP(){  
		
		int pos = J.getPos();
		
		for( int i = 1 ; i <= 12  ; i++){
			
			
			casesPossibles.add( P.getCases().get( pos ) );
			
			pos++;
			if( pos > 27 ) pos -= 27;
			
			}
		
		}
	
	// Prise de decision pour acheter ou pas une case en fonction de depense de tour prochaine et le probabilites d'arriver sur chacun des cases
	public boolean realEstate( CaseProp cp ){ 
		
			boolean buy = false;
			
			if( cp.getAchete() == false ){
				
				if( J.getSomme() > cp.getPrix()){
					
					double depenseMax = depenseMax();
					
					if( (J.getSomme() + depenseMax - cp.getPrix()) > 20000   ){
						
						
						buy = true;
						
						System.out.println(" j'achete hhahahaha");
						
						// peut ajouter more conditions
						
					
						// Si l'IA n'a pas d'argent il peut prendre un credit
						}else if((J.getSomme() + depenseMax - cp.getPrix()) < 5000 && dette == false ){ 
							
							
							montantCredit = cp.getPrix();
							J.credit(montantCredit);
							dette = true;
							buy = true;
							tourDette = 0;
							
							
							
							 }
					}
				
				
				}else{ System.out.println(" j'achete pas hohohohohohoho");  }
				
			return buy;
		
		}
	
	// Calcule de depense moyenne pour la prochaine tour	
	public double depenseMax(){	
		
		fillCP();
		
		double max = 0;
		double prob;
		double prix;
		
		for( Case c : casesPossibles ){
			
			
			if( c instanceof CaseProp){ 
				
				CaseProp cp = (CaseProp) c;
				
				
				if( cp.getAchete() == true && cp.getPropri() != J ){
					
					prix = -cp.getPrix()/10;
					prob = probDes(cp.getPos());
					max += prix*prob;
					
					
					}
					
				if( cp.getAchete() == false ){
					
					prix = -cp.getPrix();
					prob = probDes(cp.getPos());
					max += prix*prob;
				}
			}
			
			if( c instanceof CaseTaxe){
			
			CaseTaxe ct = (CaseTaxe) c;
			prix = -ct.valAPayer;
			prob = probDes( ct.getPos());
			max += prix*prob;
			
			
				}
			
			
			// doit envisager des autres sources de perte d'argent 
			
			
			
			if( c instanceof CaseDepart){
				
				prob = probDes( c.getPos());
				prix= 10000;
				max += prix;
				
				}
			
			}
			
			System.out.println("max depense index ="+max);
			
			return max;
			
	}	

	// Attribution d'un chance d'arriver dessus pour chacun de cases possibles 
	public double probDes( int pos){
		
		double k = 0;
		
		if( pos == 2 || pos == 12) k = 1;
		if( pos == 3 || pos == 11) k = 2;
		if( pos == 4 || pos == 10) k = 3;
		if( pos == 5 || pos == 9) k = 4;
		if( pos == 6 || pos == 8) k = 5;
		if( pos == 7 ) k = 6;
		
		
		
		return k/36;
		
		}
		
	// Meme methode que dans la classe FenetreInterface adjuste pour IA, decision d'achat ou pas d'une maison
	public boolean achatMaison(int num){
            
            boolean acheteM = false;
            
            Case pr = P.getCaseAchatBatiment(num);
            System.out.println(pr.getNom());
                        
            //On verifie que la case demandee repond aux differents criteres 
            if(!(pr instanceof CaseProp)){ //on verifie que c'est bien une case propriete 
                
            }
            else{  
                CaseProp prop = (CaseProp) pr;  
                
                if(prop.getNbHotel() == 1){
                    
                }
                
                else{                   
                    Joueur propri = prop.getPropri(); 
                    
                    if(propri != J){ //on verifie que notre joueur est proprietaire de cette case 
                        
                    }
                    
                    else{
                        boolean maison = fen.peutAcheterMaison(); 
                        if(maison == false){ //on verifie qu'il possede bien toutes les proprietes de cette couleur 
                            
                            System.out.println("Vous n'avez pas toutes les proprietes de cette couleur"); 
                        }
                        
                        else{
                            if(prop.getNbMaisons() == 4){
                               
                            }
                            
                            else{
                                if(fen.peutAcheterCetteMaison(num) == false){
                                    
                                }
                                
                                else{
                                    
                                    acheteM = true;
                                    
                                    }
                                }
                            }
                        }
                    }
                }
                
                return acheteM;
                
            }
		
	// Methode qui s'occupe d'achat d'une maison
	public void acheterMaison(){
		
		for( CaseProp cp : J.getMesProprietes() ){
			
			int pos = cp.getPos();
			
			if(achatMaison( pos ) && J.getSomme() - cp.getPrixBatiment() > 10000 ){ 
			
			System.out.println("La prop avant achat maison est de " + cp.getPrix());
			J.setArgent(-cp.getPrixBatiment()); 
			cp.ajoutMaison();  
			System.out.println("Le prop est " + cp + "\n On a ajoute une maison et la case vaut maintenant " + cp.getPrix()); 
			//On doit ajouter l'affichage graphique de la maison 
			fen.getPanelCase(pos).dessinerMaison(cp.getNbMaisons()); 
			MaisonVerte m = new MaisonVerte(pos , P); 
			fen.getJoueur().ajouterMaison(m); 
			
				}
			}
		}
	

}

		
