import java.awt.*;
import javax.swing.*;

public class MaFenetreAchatBatiment extends JFrame{
	
	//affichage dans la fenêtre 
	private JPanel panelHaut; 
	private JPanel panelBas; 
	private JLabel num; 
	
	//entré du joueur 
	private JTextField entreeNum; 
	
	private JButton fin; 
	//position de la propriété surlaquelle on va construire 
	private int numeroP;
	//le plateau permet d'avoir la liste des cases de la partie 
	private Plateau plateau;
	//avoir la fenêtre interface en attribut permet de mettre à jour l'affichage 
	private FenetreInterface f; 
	//il s'agit de la nature du batiment qui va être acheté Hotel ou Maison 
	private String nat; 

	public MaFenetreAchatBatiment(Plateau p, FenetreInterface f , String nature){

		super("Achat" + nature); 
		setSize (1000 , 150); 
		
		//initialisation des différents attributs 
		plateau = p;
		this.f = f;
		nat = nature; 

		JPanel cadrePrincipal = new JPanel (new GridLayout(2 , 1)); 
		this.setContentPane(cadrePrincipal); 

		panelHaut = new JPanel(); 
		panelBas = new JPanel(); 

		num = new JLabel("Numero propriete :"); 
		entreeNum = new JTextField(5);
		fin = new JButton("Ok"); 
		
		//adaptation de la fenêtre à la nature du batiment qui va être créé
		if(nat == "Maison"){
			EcouteurBtnAchatMaison ecouteurBtnFin = new EcouteurBtnAchatMaison(this , plateau , f); 
			fin.addActionListener(ecouteurBtnFin);
		}else if(nat == "Hotel"){
			EcouteurBtnAchatHotel ecouteurBtnFin = new EcouteurBtnAchatHotel(this , plateau , f);
			fin.addActionListener(ecouteurBtnFin);
		}



		panelHaut.add(num); 
		panelHaut.add(entreeNum);

		panelBas.add(fin); 

		cadrePrincipal.add(panelHaut); 
		cadrePrincipal.add(panelBas);  

		setVisible(true);

	}
	
	//permet de vérifier si on a bien entré un entier dans le champ
	public boolean getEntreeNumNature(){
		boolean res = false; 
		String entree = entreeNum.getText();  
		
		if(this.estUnEntier(entree) == true){ //Appel une méthode de cette classe qui utilise un try catch 
			res = true;
		}
		return res; 
	}

	//récupère la valeur qui  a été entré dans le champ par le joueur 
	public int getEntreeNumInt(){
		String entree = entreeNum.getText();
		int res = Integer.parseInt(entree); 
		return res; 
	}
	
	//test si la donné entrée en paramètre est un entier 
	public boolean estUnEntier(String chaine) { //J'ai recupere cette methode sur internet (dans un forum)
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}

	public void setNumPropri(int n){
		numeroP = n;
	}

	public int getNumPropri(){return numeroP;}

}
