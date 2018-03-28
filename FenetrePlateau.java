import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//utiliser grid layout et changer les tailles, commencer par faire des JPanel
//dans les JPanel il faudra faire dessiner Joueur et dessiner propriétaire
//pour l'instant dans cette fenêtre il n'y a que la plateau, on peut la transormer en panel plateau qu'on placerait dans la fenêtre de jeu
public class FenetrePlateau extends JFrame {

   JLabel jlab ;
   JTextArea jtext ;
   PanelCase panecase ;
   JPanel pane ;
   LinkedList<PanelCase> listepanelcases = new LinkedList<PanelCase>() ;

    public FenetrePlateau() {
        super("MONOPOLY");
        
        //on devrait avoir un liste des panel case, cela pourrait être util
        
       
        pane = new JPanel(new GridLayout(0,8));
        JPanel pgris = new JPanel();
        
        panecase = new PanelCase(Color.GRAY, new JLabel(" CAGNOTTE"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Matignon"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Malesherbes"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Henri-Martin"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" CHANCE"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.YELLOW, new JLabel(" Saint-Honore"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
         panecase = new PanelCase(Color.YELLOW, new JLabel(" La bourse"), this); 
         listepanelcases.add(panecase);
        pane.add(panecase); 
         panecase = new PanelCase(Color.GRAY, new JLabel(" Allez en prison"), this); 
         listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Pigalle"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase);
        
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Breteuil"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Saint-Michel"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Foch"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Mozart"), this);
        listepanelcases.add(panecase); 
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Capucines"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        panecase = new PanelCase(Color.GRAY, new JLabel(" TAXE"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GRAY, new JLabel(" Chance"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        panecase = new PanelCase(Color.PINK, new JLabel(" Paradis"), this);
        listepanelcases.add(panecase); 
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.BLUE, new JLabel(" Champs-Elysees"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        panecase = new PanelCase(Color.PINK, new JLabel(" Neuilly"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.BLUE, new JLabel(" Paix"), this); 
		listepanelcases.add(panecase);
        pane.add(panecase);
        
        panecase = new PanelCase(Color.GRAY, new JLabel(" PRISON"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" La Republique"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" Courcelles"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" Vaugirard"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" CHANCE"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.BLACK, new JLabel(" Lecourbe"), this);
        listepanelcases.add(panecase); 
        pane.add(panecase); 
        panecase = new PanelCase(Color.BLACK, new JLabel(" Belleville"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" DEPART"), this); 
        listepanelcases.add(panecase);
        pane.add(panecase); 
        
        //test affichage joueur
        listepanelcases.get(10).dessinerJoueur() ; 
        listepanelcases.get(10).dessinerJoueur2() ; 
        

        
       this.setContentPane(pane); 
        
        this.setSize(800,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public JPanel getPane(){
		
		return pane;
		
		}

    //public static void main(String[] a){
    //    new FenetrePlateau();
    //}
}
