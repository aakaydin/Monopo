import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FenetreFinPartie extends JFrame{
	
	//liste des joueurs de ma partie
	private LinkedList<Joueur> lesjoueurs ;
	//panel d'affichage du classement des joueurs 
	private JPanel panel = new JPanel( new GridLayout(0,1));
	//bouton pour lancer une nouvelle partie
	private JButton partieagain = new JButton("Nouvelle Partie");
	private FenetreInterface fen ;
	public FenetreFinPartie(LinkedList<Joueur> lj){
		
		super("PARTIE FINIE");
	
		lesjoueurs = lj ;
		
		int nbJoueurs = lesjoueurs.size() ; 
		
		//réglage de la taille en fonction du nombre de joueurs 
		this.setSize(600,100*nbJoueurs);
		
		partieagain.addActionListener(new EcouteurNouvellePartie(this));
		
		//trier les joueurs dans l'ordre
		Collections.sort(lesjoueurs);
		//afficher les joeurs 
		for(int i = 0; i < nbJoueurs; i ++){
			panel.add(new JLabel(lesjoueurs.get(i).toString()));
		}
		//ajouter les boutons et le panel 
		panel.add(partieagain);
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
