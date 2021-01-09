/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsantorini_soulie_lamassiaude_perello;

/**
 *
 * @author Baptiste Soulié
 */
public class Joueur {
    String Nom ;
    String CouleurJoueur ;
    Pion Pion1;
    Pion Pion2;
            
    
    public Joueur(String LeNom) {
        Nom = LeNom ;
        CouleurJoueur = "" ;
             
    }
     public void AffecterCouleurAuJoueur (String LaCouleur){
         CouleurJoueur  = LaCouleur ;
     }
    
   
    
    
    
    
    
    
    
    
}
