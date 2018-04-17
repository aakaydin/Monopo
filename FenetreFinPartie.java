import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FenetreFinPartie extends JFrame{
	
	
	private LinkedList<Joueur> lesjoueurs ;
	private JPanel panel = new JPanel( new GridLayout(0,1));
	private JButton partieagain = new JButton("Nouvelle Partie");
	private FenetreInterface fen ;
	
	public FenetreFinPartie(LinkedList<Joueur> lj){
		
		super("PARTIE FINIE");
		
		
		
		lesjoueurs = lj ;
		
		int nbJoueurs = lesjoueurs.size() ; 
		
		this.setSize(600,100*nbJoueurs);
		
		partieagain.addActionListener(new EcouteurNouvellePartie(this));
		
		//trier les joueurs dans l'ordre de somme croissant 
		Collections.sort(lesjoueurs);
		for(int i = 0; i < nbJoueurs; i ++){
			panel.add(new JLabel(lesjoueurs.get(i).toString()));
		}
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
