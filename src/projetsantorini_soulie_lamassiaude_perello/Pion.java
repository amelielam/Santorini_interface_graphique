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
public class Pion {
    String CouleurPion ;
    int EtagePion ;
     
    public Pion (String LaCouleur) {
        CouleurPion  = LaCouleur ;
        EtagePion = 0 ;
    }
    
    public String LireLaCouleur (){
        return CouleurPion ;
    }
    
    
    
    
    
    
    
}
