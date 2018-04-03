import java.awt.*;
import javax.swing.*;

public class MaFenetreCartePrison extends JFrame{

    private JLabel indications; 
    private JButton btnOui; 
    private JButton btnNon;
    private boolean reponse = false;  
    
    private Joueur jcourant ;
    
    public MaFenetreCartePrison(Joueur j){ //des paramètres?
        super("Carte Prison"); 
        
        setSize (1000 , 100); 
        
        jcourant = j;
        
        //pas de setDefaultCloseOperation, on veut forcer à appuyer sur un bouton 
        
        JPanel cadrePrincipal = new JPanel (); 
        this.setContentPane(cadrePrincipal); 
        
        //Instructions 
        indications = new JLabel("Vous etes en prison or vous possedez une carte vous permettant d en sortir! Voulez-vous l utiliser?"); 
        cadrePrincipal.add(indications); 
        
        //Boutons 
        btnOui = new JButton("Oui"); 
        cadrePrincipal.add(btnOui); 
        EcouteurBtnOuiCartePrison ecouteurBtnOui = new EcouteurBtnOuiCartePrison(this); 
        btnOui.addActionListener(ecouteurBtnOui); 
        
        btnNon = new JButton("Non"); 
        cadrePrincipal.add(btnNon);
        EcouteurBtnNonCartePrison ecouteurBtnNon = new EcouteurBtnNonCartePrison(this); 
        btnNon.addActionListener(ecouteurBtnNon); 

        
        setVisible(true);
    }
    
    public void setReponse(boolean res){
        reponse = res; 
    }
    
    public boolean getReponse(){
        return reponse;
    }
    
    public Joueur getJoueur(){
		return jcourant;
	}
    
}
