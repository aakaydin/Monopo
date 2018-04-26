import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FenetreInterface extends JFrame{
	
	public PanelPlateau plateau = new PanelPlateau();
	//private PanelPlateau plateau = new PanelPlateau();
	public Plateau p ;	
	//private Joueur jTour = new Jouer();
	//private Joueur[] jojo = new Joueur[2];  
	//private Joueur JC = new Joueur("Camille",0,0);

	public JPanel panelTemp = new JPanel();
	public JPanel panelInfo = new JPanel(new GridLayout(3,1)) ; 

	public JLabel labInfo = new JLabel() ;

	public EcouteurLancerLesDes ecouteurdes ;
	public EcouteurFinTour	ecouterfintour;
	public EcouteurAbandonner ecouteurabandonner;
	public EcouteurBanque ecouteurbanque;
	public EcouteurPayerCredit ecouteurpayercredit;
	public EcouteurAchatBatiment ecouteurachatM; 
	public EcouteurAchatBatiment ecouteurachatH; 

	JPanel panelWest = new JPanel( new GridLayout(2,1));
	JPanel panelEast = new JPanel( new GridLayout(7,1));
	JPanel panelSouth = new JPanel( new FlowLayout() );
	JPanel panelNorth = new JPanel( new FlowLayout() );


	private JLabel label;
	private JLabel label1;
	private JLabel label2;

	public JButton finTour;	
	public JButton lanceDe;	
	public JButton abandonner;	
	public JButton banque;
	public JButton payerDette;
	public JButton achatMaison;
	public JButton achatHotel;	


	public Joueur jcourant; 

	public AffichageDe aff = new AffichageDe( 1 , 1);
	JPanel cadrePrincipal = new JPanel(new BorderLayout());

	private LinkedList<Joueur> ListJoueur;

	//public boolean activeFin = false;
	//public boolean acitveDes = false;




	public FenetreInterface( int longue , int large, Plateau pl, Joueur jcourant, LinkedList<Joueur> LJ){


	super(" Monopoly");


	p = pl ;
	this.jcourant = jcourant; 
	ListJoueur = LJ;

	ecouteurdes = new EcouteurLancerLesDes(jcourant, this, p);
	ecouterfintour = new EcouteurFinTour(this,jcourant, ListJoueur);
	ecouteurabandonner = new EcouteurAbandonner(this);
	ecouteurbanque = new EcouteurBanque(this);
	ecouteurpayercredit =  new EcouteurPayerCredit(this);
	ecouteurachatM = new EcouteurAchatBatiment(this , p , achatMaison , "Maison");
	ecouteurachatH = new EcouteurAchatBatiment(this , p , achatHotel , "Hotel"); 

	this.setSize(new Dimension(longue,large));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 



	// 

	cadrePrincipal.setBackground(Color.CYAN);
	panelSouth.setBackground(Color.CYAN);
	panelNorth.setBackground(Color.CYAN);

	this.setContentPane(cadrePrincipal);

	//Creation des widgets


	label = new JLabel (" Joueur : " + jcourant.getNom());
	label1 = new JLabel(" Somme: " +jcourant.getSomme() );	
	label2 = new JLabel(" ");	


	finTour = new JButton(" End Turn");
	lanceDe = new JButton(" Lancer les Des ");
	abandonner = new JButton(" Abandonner ");
	banque = new JButton(" Banque");
	payerDette = new JButton(" Payer Credit");
	payerDette.setEnabled(false);
	achatMaison = new JButton("Acheter une maison"); 
	achatHotel = new JButton("Acheter un hotel"); 


	panelTemp = p.getCases().get(0).getPanel();

	panelInfo.add(new JLabel("	INFORMATION TOUR"));
	panelInfo.add(labInfo);

	panelWest.add(panelInfo);
	panelWest.add(panelTemp); 

	aff = new AffichageDe( jcourant.de1 , jcourant.de2);



	// Lien entre les buttons et les listeners


	lanceDe.addActionListener( ecouteurdes ); //est-ce que mon écouteur va bien changer son joueur quand je change le joueur de la fenêtre ? rep Aydin : non 
	finTour.addActionListener( ecouterfintour);
	abandonner.addActionListener(ecouteurabandonner);
	banque.addActionListener( ecouteurbanque );
	payerDette.addActionListener( ecouteurpayercredit );
	achatMaison.addActionListener(ecouteurachatM);
	achatHotel.addActionListener(ecouteurachatH); 

	//Object obj = new Object();	
	//ActionEvent AE  = new ActionEvent( obj ,  0,  "lol");
	//ecouteurdes.actionPerformed( AE);



	finTour.setEnabled( false);
	lanceDe.setEnabled( true);



	// Ajout des Gadgets dans les panels




	panelEast.add(banque);	
	panelEast.add(abandonner);
	panelEast.add(payerDette);	
	panelEast.add(achatMaison); 
	panelEast.add(achatHotel);	
	panelEast.add(aff);			
	panelEast.add(lanceDe);	



	panelNorth.add(finTour);

	panelSouth.add(label1 );
	panelSouth.add(label);
	//panelSouth.add(abandonner);	


	//ligne de test
	plateau.getPanelCase(jcourant.getPos()).dessinerJoueur(jcourant);


	// Ajout des panels avec tout les widgets dans un case de borderLayout

	cadrePrincipal.add(plateau , BorderLayout.CENTER);

	cadrePrincipal.add(panelWest , BorderLayout.WEST);

	cadrePrincipal.add(panelEast , BorderLayout.EAST);

	cadrePrincipal.add(panelSouth , BorderLayout.SOUTH);

	cadrePrincipal.add(panelNorth , BorderLayout.NORTH);

	//Test affichage maisons 
	this.getPanelCase(1).dessinerMaison(1);
	this.getPanelCase(5).dessinerHotel(); 
	this.getPanelCase(2).dessinerMaison(2);
    this.getPanelCase(2).dessinerMaison(3);
	//this.getPanelCase(2).dessinerHotel();
	this.getPanelCase(8).dessinerMaison(3);
    this.getPanelCase(9).dessinerMaison(3);
	this.getPanelCase(9).dessinerMaison(0);
 

	 this.setVisible(true);


	}

	public PanelPlateau getPanelPlateau(){return plateau;}
	public Plateau getPlateau(){return p;}
	public JPanel getPanelTemp(){return panelTemp;}
	public JPanel getPanelSouth(){return panelSouth;}
	public JPanel getPanelEast(){return panelEast;}
	public Joueur getJoueurCourant(){return jcourant;}

	//ne fonctionne pas 
	public void changerPanelTemp(JPanel p){

		panelWest.removeAll();

		panelTemp = p ;


		//panelTemp.repaint();

		panelWest.add(panelInfo);
		panelWest.add(panelTemp);	


	}

	public void setTextInfo(String s){

		labInfo.setText(s);

	}

	public Joueur getJoueur(){
		return jcourant;
	}

	public LinkedList<Joueur> getLesJoueurs(){
		return ListJoueur ;
	}

	public void setJoueur(Joueur j){

		jcourant = j;

	}

	public void changerPanelJoueur(Joueur j){

		//ce code fonctionne
		label.setText("Joueur : " +j.getNom());
		label1.setText("Somme : " +j.getSomme());
		panelSouth.repaint();

	}

	public void changerJoueurEcouteurDe(Joueur j){
		//il faut changer le bouton des des 
		panelEast.repaint();
		jcourant = j;
		panelEast.remove(lanceDe);
		lanceDe = new JButton("Lancer les des");
		lanceDe.addActionListener(new EcouteurLancerLesDes(jcourant, this, p)); 
		panelEast.add(lanceDe,  BorderLayout.NORTH);
		/*ecouteurdes.setJoueur(j);
		panelEast.repaint();*/



	}

	public PanelCase getPanelCase(int i){
		return plateau.getPanelCase(i);
	}

	public JLabel getL1(){ 
		return label1; 
	}

	public JButton getPayerDette(){ 
		return payerDette; 
	}
        
        public EcouteurPayerCredit getEcouteurPayerCredit(){ 
			return ecouteurpayercredit; 
		}
        
        
        public boolean peutAcheterMaison(){ //en general : servira notamment a l'activation du bouton 
            
            System.out.println("On teste peutAcheterMaison"); 
            LinkedList<CaseProp> immobilier = jcourant.getMesProprietes(); 
        
            boolean peutAcheter = false; 
            
            LinkedList<CaseProp> groupNoir = p.getGroupNoir(); 
            LinkedList<CaseProp> groupCyan = p.getGroupCyan(); 
            LinkedList<CaseProp> groupRose = p.getGroupRose(); 
            LinkedList<CaseProp> groupOrange = p.getGroupOrange(); 
            LinkedList<CaseProp> groupRouge = p.getGroupRouge(); 
            LinkedList<CaseProp> groupJaune = p.getGroupJaune(); 
            LinkedList<CaseProp> groupVert = p.getGroupVert(); 
            LinkedList<CaseProp> groupBleu = p.getGroupBleu(); 
            
            //On va tester chaque liste 
            boolean fin = false;
            int nbProp = 0; 
            int i = 0; 
            
            while(nbProp != 3 && fin == false){
                
                nbProp = 1;
                for(CaseProp c : groupNoir){
                    i = i + 1;
                    System.out.println("On etudie la case " + i); 
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                        System.out.println("On est dans la boucle groupeNoir : vrai"); 
                    }else{
                        System.out.println("On est dans la boucle groupeNoir : faux"); 
                    }
                }
                
                nbProp = 0; 
                for(CaseProp c : groupCyan){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 1; 
                for(CaseProp c : groupRose){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 0; 
                for(CaseProp c : groupOrange){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 0; 
                for(CaseProp c : groupRouge){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 1; 
                for(CaseProp c : groupJaune){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 0; 
                for(CaseProp c : groupVert){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                nbProp = 1; 
                for(CaseProp c : groupBleu){
                    if(immobilier.contains(c)){
                        nbProp = nbProp + 1;
                    }
                }
                
                fin = true;
                
            }
            
            if(nbProp == 3){
                peutAcheter = true; 
            }
            
            if(peutAcheter == true){
                System.out.println("peutAcheter est vrai"); 
            }else{
                System.out.println("peutAcheter est faux"); 
            }
            
            return peutAcheter;
        }
        
        
        public boolean peutAcheterCetteMaison(int num){ //sur cette propriete en particulier en comparaison avec les autres proprietes de son groupe couleur 
            boolean peutAcheter = false; 
            
            Case pr = p.getCaseAchatBatiment(num); 
            if(pr instanceof CaseProp){
                CaseProp prop = (CaseProp) pr; 
                Color color = this.getPanelCase(num).getCouleur();
                LinkedList<CaseProp> groupe = new LinkedList<CaseProp>();
                
                if(color == Color.BLACK){
                    groupe = p.getGroupNoir(); 
                }else if(color == Color.CYAN){
                    groupe = p.getGroupCyan(); 
                }else if(color == Color.PINK){
                    groupe = p.getGroupRose(); 
                }else if(color == Color.ORANGE){
                    groupe = p.getGroupOrange(); 
                }else if(color == Color.RED){
                    groupe = p.getGroupRouge(); 
                }else if(color == Color.YELLOW){
                    groupe = p.getGroupJaune(); 
                }else if(color == Color.GREEN){
                    groupe = p.getGroupVert(); 
                }else if(color == Color.BLUE){
                    groupe = p.getGroupBleu(); 
                }
                
                
                int nbMaisons = prop.getNbMaisons(); 
                //S'il n'y a pas encore de maison sur cette case 
                for(CaseProp c : groupe){
                    int nb = c.getNbMaisons(); 
                    if(nb == nbMaisons || nb == nbMaisons + 1){
                        peutAcheter = true; 
                    }
                }
            }
            
            return peutAcheter; 
        } 
                
        
        
        public void achatMaison(int num){
            Case pr = p.getCaseAchatBatiment(num);
            System.out.println(pr.getNom());
                        
            //On verifie que la case demandee repond aux differents criteres 
            if(!(pr instanceof CaseProp)){ //on verifie que c'est bien une case propriete 
                FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(1); 
            }
            else{  
                CaseProp prop = (CaseProp) pr;  
                
                if(prop.getNbHotel() == 1){
                    FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(8);
                }
                
                else{                   
                    Joueur propri = prop.getPropri(); 
                    
                    if(propri != jcourant){ //on verifie que notre joueur est proprietaire de cette case 
                        FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(2);
                    }
                    
                    else{
                        boolean maison = this.peutAcheterMaison(); 
                        if(maison == false){ //on verifie qu'il possede bien toutes les proprietes de cette couleur 
                            FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(3); 
                            System.out.println("Vous n'avez pas toutes les proprietes de cette couleur"); 
                        }
                        
                        else{
                            if(prop.getNbMaisons() == 4){
                                FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(4); 
                            }
                            
                            else{
                                if(this.peutAcheterCetteMaison(num) == false){
                                    FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(5); 
                                }
                                
                                else{
                                    System.out.println("La prop avant achat maison est de " + prop.getPrix());
                                    
                                    propri.setArgent(-prop.getPrixBatiment()); 
                                    
                                    prop.ajoutMaison();  
                                    
                                    System.out.println("Le prop est " + propri + "\n On a ajoute une maison et la case vaut maintenant " + prop.getPrix()); 
                                    
                                    //On doit ajouter l'affichage graphique de la maison 
                                    this.getPanelCase(num).dessinerMaison(prop.getNbMaisons()); 
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            
            public void achatHotel(int num){
                Case pr = p.getCaseAchatBatiment(num);
                System.out.println(pr.getNom());
                            
                //On verifie que la case demandee repond aux differents criteres 
                if(!(pr instanceof CaseProp)){ //on verifie que c'est bien une case propriete 
                    FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(1); 
                }
                
                else{  
                    CaseProp prop = (CaseProp) pr;  
                    
                    if(prop.getNbMaisons() != 4){
                        FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(6); 
                    }
                    
                    else{
                        if(prop.getNbHotel() == 1){
                            FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(7); 
                        }
                        else{
                            Joueur propri = prop.getPropri(); 
                        
                            if(propri != jcourant){ //on verifie que notre joueur est proprietaire de cette case 
                                FenetreErreurAchatBatiment fen = new FenetreErreurAchatBatiment(2);
                            }
                            
                            else{
                                System.out.println("La prop avant achat hotel est de " + prop.getPrix());
                                        
                                propri.setArgent(-prop.getPrixBatiment()); 
                                
                                
                                prop.ajoutHotel();  
                                
                                System.out.println("Le prop est " + propri + "\n On a ajoute un hotel et la case vaut maintenant " + prop.getPrix()); 
                                
                                //On doit ajouter l'affichage graphique de la maison 
                                this.getPanelCase(num).dessinerHotel(); 
                            }
                        }
                    }
                }
                            
            }
	
	/**
		
	   public static void main(String[] a){

		   LinkedList lj = new LinkedList<Joueur>();
		   lj.add(new Joueur("Cam",0,0));
		   lj.add(new Joueur("Lisa",10,2));

			FenetreInterface fi = new FenetreInterface( 1200, 600, new Plateau(), new Joueur("Cam",0,4), lj );

			JPanel p = new JPanel();
			p.add(new JLabel("dguileza"));

			fi.changerPanel(p);
			JPanel p2 = new JPanel();

			p2.add(new JLabel("dge"));
			fi.changerPanel(p2);
			Joueur claire = new Joueur("Claire", 0,0);
			claire.setArgent(1000);
			fi.changerPanelJoueur(claire);
			claire.setArgent(05);
			System.out.println(claire.getSomme());
			fi.changerPanelJoueur(claire);

			//fi.changerPanel(p);

			//test carte chance panel




	    } 

	*/
	
	
	
	
}
