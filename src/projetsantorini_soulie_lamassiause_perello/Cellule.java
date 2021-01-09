/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsantorini_soulie_lamassiause_perello;

/**
 *
 * @author Baptiste Soulié
 */
public class Cellule {
    Pion PionCourantCellule ;
    Bloc BlocCellule ;
   
    public Cellule () {
        BlocCellule = new Bloc() ;
        PionCourantCellule = null ;
    }
    
    public int LireNiveauBloc () {
        return BlocCellule.Etage ;
    }
    
    public boolean AffecterBloc (Bloc BlocCourant) {
        if (BlocCellule.Etage <= 4 ) {
            BlocCourant.Etage++ ;
            BlocCellule = BlocCourant;
            return true ;
        }    
        else{
            return false ;
        }        
    } 
    
    public boolean PresencePion (Pion PionJoue){
        if (PionCourantCellule == PionJoue) {
            return true ;
        }
        else {
            return false ;
        }
    }
    
    public boolean CaseSansPion (){
        if (PionCourantCellule == null) {
            return true ;
        }
        else {
            return false ;
        }
    }
    
    public boolean PresenceBloc (){
        if (BlocCellule!= null) {
            return true ;
        }
        else {
            return false ;
        }
    }
    
    public boolean AffecterPion(Pion PionJoue){
        if (PionCourantCellule==null){
            PionCourantCellule = PionJoue;
            return true;
        }else{
            return false;
        }
    }
    
public boolean SupprimerPion(){
    //supprime le pion et renvoie vrai si la suppression s’est bien passée, ou faux autrement (ex : pas de pion présent)
    if (PionCourantCellule==null){
        return false;
    }else{
        PionCourantCellule=null;
        return true;
    }   
}

}
    
            
            
            
 
