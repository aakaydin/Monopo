import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//Ecouteur qui va permettre d'acheter une maison au joueur, se trouve dans la fenetre achat batiment 
public class EcouteurBtnAchatMaison implements ActionListener {

    private MaFenetreAchatBatiment fen; 
    private Plateau plateau; 
    private FenetreInterface fenInt;

    public EcouteurBtnAchatMaison(MaFenetreAchatBatiment f , Plateau p , FenetreInterface fI){
        fen = f; 
        plateau = p;
        fenInt = fI; 
    }

    public void actionPerformed(ActionEvent ae){
    //on vérifie que la valeur entrée pour la position de la propriété sur le plateau est bien un entier 
        boolean num = fen.getEntreeNumNature(); 
        int res; 
        //sinon il y a affichage d'un message d'erreur et fermeture de la fenêtre 
        if(num == false){
            FenetreErreurAchatBatiment f = new FenetreErreurAchatBatiment(9);
            fen.dispose();
        }else{
            res = fen.getEntreeNumInt(); 
            fen.setNumPropri(res); 
            fen.dispose();


            System.out.println("Recuperation numero prop " + res); 
            //méthode qui effecture l'achat d'une maison si cela est possible 
            fenInt.achatMaison(res);


            MaisonVerte m = new MaisonVerte(res , plateau); 
            fenInt.getJoueur().ajouterMaison(m); 
        }
    }

}
