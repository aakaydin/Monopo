import java.awt.* ;
import javax.swing.*;
import java.util.*;

public class Plateau  {
	
	private LinkedList<Case> cases ;
    
    //Les differents groupes de proprietes (couleur)  
    private LinkedList<CaseProp> groupNoir; 
    private LinkedList<CaseProp> groupCyan; 
    private LinkedList<CaseProp> groupRose; 
    private LinkedList<CaseProp> groupOrange; 
    private LinkedList<CaseProp> groupRouge; 
    private LinkedList<CaseProp> groupJaune; 
    private LinkedList<CaseProp> groupVert; 
    private LinkedList<CaseProp> groupBleu; 
	
	int nbCases = 28 ; 
	
	//objet qui va seulement servir à initialiser les rapports entre plateau et case 

	
	public Plateau(){
		
		cases = new LinkedList<Case>();
        
        groupNoir = new LinkedList<CaseProp>(); 
        groupCyan = new LinkedList<CaseProp>(); 
        groupRose = new LinkedList<CaseProp>(); 
        groupOrange = new LinkedList<CaseProp>(); 
        groupRouge = new LinkedList<CaseProp>(); 
        groupJaune = new LinkedList<CaseProp>(); 
        groupVert = new LinkedList<CaseProp>(); 
        groupBleu = new LinkedList<CaseProp>(); 
		
		CaseDepart cdep = new CaseDepart();
		cases.add(cdep);
		CaseProp p = new CaseProp(1, "Belleville", 6000, 50);
		cases.add(p);
        groupNoir.add(p);
		p = new CaseProp(2, "Lecourbe", 6000, 50);
		cases.add(p);
        groupNoir.add(p);
		
		CaseChance cch = new CaseChance(3, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(4, "Vaugirard", 10000, 50);
		cases.add(p);
        groupCyan.add(p);
		p = new CaseProp(5, "Courcelles", 10000, 50);
		cases.add(p);
        groupCyan.add(p);
		p = new CaseProp(6, "Republique", 12000, 50);
		cases.add(p);
        groupCyan.add(p);
		
		CasePrison cpr = new CasePrison();
		cases.add(cpr);
		
		p = new CaseProp(8, "Neuilly", 14000, 100);
		cases.add(p);
        
		p = new CaseProp(9, "Paradis", 14000, 100);
		cases.add(p);
		groupRose.add(p);
		CaseTaxe ctaxe = new CaseTaxe("TAXE", 10, 2000);
		cases.add(ctaxe);
        groupRose.add(p);
		
		p = new CaseProp(11, "Mozart", 18000, 100);
		cases.add(p);
        groupOrange.add(p);
		p = new CaseProp(12, "Saint-Michel", 18000, 100);
		cases.add(p);
        groupOrange.add(p);
		p = new CaseProp(13, "Pigalle", 20000, 100);
		cases.add(p);
        groupOrange.add(p);
		
		CaseCagnotte ccagn = new CaseCagnotte() ;
		cases.add(ccagn) ;
		
		p = new CaseProp(15, "Matignon", 22000, 150);
		cases.add(p);
        groupRouge.add(p);
		p = new CaseProp(16, "Malesherbes", 22000, 150);
		cases.add(p);
        groupRouge.add(p);
		p = new CaseProp(17, "Henri-Martin", 24000, 150);
		cases.add(p);
        groupRouge.add(p);
		
		cch = new CaseChance(18, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(19, "Saint-Honore", 26000, 150);
		cases.add(p);
        groupJaune.add(p);
		p = new CaseProp(20, "La bourse", 26000, 150);
		cases.add(p);
        groupJaune.add(p);
		
		CaseAllerPrison casgopri = new CaseAllerPrison();
		cases.add(casgopri);
		
		p = new CaseProp(22, "Breteuil", 30000, 200);
		cases.add(p);
        groupVert.add(p);
		p = new CaseProp(23, "Foch", 30000, 200);
		cases.add(p);
        groupVert.add(p);
		p = new CaseProp(24, "Capucines", 32000, 200);
		cases.add(p);
        groupVert.add(p);
		
		cch = new CaseChance(25, "CHANCE");
		cases.add(cch);
		
		p = new CaseProp(26, "Champs-Elysee", 30000, 200);
		cases.add(p);
        groupBleu.add(p);
		p = new CaseProp(27, "Paix", 32000, 200);
		cases.add(p);
        groupBleu.add(p);
		
	 
	}
	
	public LinkedList<Case> getCases(){return cases;}
    
    public LinkedList<CaseProp> getGroupNoir(){return groupNoir;}
    public LinkedList<CaseProp> getGroupCyan(){return groupCyan;}
    public LinkedList<CaseProp> getGroupRose(){return groupRose;}
    public LinkedList<CaseProp> getGroupOrange(){return groupOrange;}
    public LinkedList<CaseProp> getGroupRouge(){return groupRouge;}
    public LinkedList<CaseProp> getGroupJaune(){return groupJaune;}
    public LinkedList<CaseProp> getGroupVert(){return groupVert;}
    public LinkedList<CaseProp> getGroupBleu(){return groupBleu;}
	
	public int getNbCase(){ return cases.size() ;}
	
	public Case getCaseAchatBatiment(int numProp){
        Case p = cases.get(numProp); 
        return p;
    }
	   
       
	

}
