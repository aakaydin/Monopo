import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//utiliser grid layout et changer les tailles, commencer par faire des JPanel
//dans les JPanel il faudra faire dessiner Joueur et dessiner propriétaire
//pour l'instant dans cette fenêtre il n'y a que la plateau, on peut la transormer en panel plateau qu'on placerait dans la fenêtre de jeu
public class PanelPlateau extends JPanel {

   JLabel jlab ;
   JTextArea jtext ;
   PanelCase panecase ;
   JPanel pane ;
   PanelCase[] listepanelcases = new PanelCase[28] ;

    public PanelPlateau() {
        super();
        
        //on devrait avoir un liste des panel case, cela pourrait être util
        
		this.setLayout(new BorderLayout());
        pane = new JPanel(new GridLayout(0,8));
        JPanel pgris = new JPanel();
        
        panecase = new PanelCase(Color.GRAY, new JLabel(" CAGNOTTE"), this, 14); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Matignon"), this, 15); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Malesherbes"), this,16); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.RED, new JLabel(" Henri-Martin"), this,17); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" CHANCE"), this,18); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.YELLOW, new JLabel(" Saint-Honore"), this,19); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
         panecase = new PanelCase(Color.YELLOW, new JLabel(" La bourse"), this,20); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
         panecase = new PanelCase(Color.GRAY, new JLabel(" Allez en prison"), this,21); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Pigalle"), this,13); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Breteuil"), this,22); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Saint-Michel"), this,12); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Foch"), this,23); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        panecase = new PanelCase(Color.ORANGE, new JLabel(" Mozart"), this,11);
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GREEN, new JLabel(" Capucines"), this,24); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        panecase = new PanelCase(Color.GRAY, new JLabel(" TAXE"), this,10); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.GRAY, new JLabel(" Chance"), this,25); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        panecase = new PanelCase(Color.PINK, new JLabel(" Paradis"), this,9);
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.BLUE, new JLabel(" Champs-Elysees"), this,26); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        panecase = new PanelCase(Color.PINK, new JLabel(" Neuilly"), this,8); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		pane.add(new JPanel());
		
		panecase = new PanelCase(Color.BLUE, new JLabel(" Paix"), this,27); 
		listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase);
        
        panecase = new PanelCase(Color.GRAY, new JLabel(" PRISON"), this,7); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" La Republique"), this,6); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" Courcelles"), this,5); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.CYAN, new JLabel(" Vaugirard"), this,4); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" CHANCE"), this,3); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.BLACK, new JLabel(" Lecourbe"), this,2);
        listepanelcases[panecase.getPlace()] = panecase; 
        pane.add(panecase); 
        panecase = new PanelCase(Color.BLACK, new JLabel(" Belleville"), this,1); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        panecase = new PanelCase(Color.GRAY, new JLabel(" DEPART"), this,0); 
        listepanelcases[panecase.getPlace()] = panecase;
        pane.add(panecase); 
        
        
		this.add(pane, BorderLayout.CENTER);
        
    }
    
    public JPanel getPane(){
		
		return pane;
		
	}
	
	public PanelCase getPanelCase(int i){
		//on veut que ça nous retourne dans le même sens où sont compté les joueurs donc départ est 0 etc ...
		return listepanelcases[i];
	}
		
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		
	}

    //public static void main(String[] a){
    //    new FenetrePlateau();
//}
}
