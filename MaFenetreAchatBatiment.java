import java.awt.*;
import javax.swing.*;

public class MaFenetreAchatBatiment extends JFrame{

    private JPanel panelHaut; 
    private JPanel panelBas; 
    
    private JLabel num; 
    private JTextField entreeNum; 
    private JButton fin; 
    
    private int numeroP;
    private Plateau plateau;
    private FenetreInterface f; 
    private String nat; 
    
    public MaFenetreAchatBatiment(Plateau p, FenetreInterface f , String nature){
        
        super("Achat" + nature); 
        setSize (1000 , 150); 
        
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
    
    public boolean getEntreeNumNature(){
		boolean res = false; 
        String entree = entreeNum.getText();  
        //il faut faire un catch exception 
        if(this.estUnEntier(entree) == true){
			res = true;
		}
		return res; 
    }
    
    public int getEntreeNumInt(){
		String entree = entreeNum.getText();
		int res = Integer.parseInt(entree); 
		return res; 
	}
    
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
