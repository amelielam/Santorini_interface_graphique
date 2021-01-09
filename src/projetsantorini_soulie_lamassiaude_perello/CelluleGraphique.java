/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsantorini_soulie_lamassiaude_perello;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Acer
 */
public class CelluleGraphique extends JButton {
    Cellule CelluleAssociee;
    int coord_x;
    int coord_y;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/case_vide.png"));
    
    ImageIcon img_dome = new javax.swing.ImageIcon(getClass().getResource("/images/dome.png"));
    ImageIcon img_bloc_etage_1 = new javax.swing.ImageIcon(getClass().getResource("/images/bloc_etage_1.png"));
    ImageIcon img_bloc_etage_2 = new javax.swing.ImageIcon(getClass().getResource("/images/bloc_etage_2.png"));
    ImageIcon img_bloc_etage_3 = new javax.swing.ImageIcon(getClass().getResource("/images/bloc_etage_3.png"));
    
    ImageIcon img_bleu_perso1_et0 = new javax.swing.ImageIcon(getClass().getResource("/images/bleu_perso1_et0.png"));
    ImageIcon img_bleu_perso1_et1 = new javax.swing.ImageIcon(getClass().getResource("/images/bleu_perso1_et1.png"));
    ImageIcon img_bleu_perso1_et2 = new javax.swing.ImageIcon(getClass().getResource("/images/bleu_perso1_et2.png"));
    ImageIcon img_bleu_perso1_et3 = new javax.swing.ImageIcon(getClass().getResource("/images/bleu_perso1_et3.png"));
    
    ImageIcon img_rouge_perso1_et0 = new javax.swing.ImageIcon(getClass().getResource("/images/rouge_perso1_et0.png"));
    ImageIcon img_rouge_perso1_et1 = new javax.swing.ImageIcon(getClass().getResource("/images/rouge_perso1_et1.png"));
    ImageIcon img_rouge_perso1_et2 = new javax.swing.ImageIcon(getClass().getResource("/images/rouge_perso1_et2.png"));
    ImageIcon img_rouge_perso1_et3 = new javax.swing.ImageIcon(getClass().getResource("/images/rouge_perso1_et3.png"));
    
    ImageIcon img_noir_perso1_et0 = new javax.swing.ImageIcon(getClass().getResource("/images/noir_perso1_et0.png"));
    ImageIcon img_noir_perso1_et1 = new javax.swing.ImageIcon(getClass().getResource("/images/noir_perso1_et1.png"));
    ImageIcon img_noir_perso1_et2 = new javax.swing.ImageIcon(getClass().getResource("/images/noir_perso1_et2.png"));
    ImageIcon img_noir_perso1_et3 = new javax.swing.ImageIcon(getClass().getResource("/images/noir_perso1_et3.png"));
    
    ImageIcon img_vert_perso1_et0 = new javax.swing.ImageIcon(getClass().getResource("/images/vert_perso1_et0.png"));
    ImageIcon img_vert_perso1_et1 = new javax.swing.ImageIcon(getClass().getResource("/images/vert_perso1_et1.png"));
    ImageIcon img_vert_perso1_et2 = new javax.swing.ImageIcon(getClass().getResource("/images/vert_perso1_et2.png"));
    ImageIcon img_vert_perso1_et3 = new javax.swing.ImageIcon(getClass().getResource("/images/vert_perso1_et3.png"));
    
    public CelluleGraphique (Cellule UneCellule, int  x,int  y){
        CelluleAssociee = UneCellule;
        coord_x=x;
        coord_y=y;
        
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        if (CelluleAssociee.PresenceBloc()==true && CelluleAssociee.PionCourantCellule==null){
                if (CelluleAssociee.BlocCellule.Etage==0){
                    setIcon(img_vide);
                }
                else if (CelluleAssociee.BlocCellule.Etage==1){
                    setIcon(img_bloc_etage_1);
                }
                else if (CelluleAssociee.BlocCellule.Etage==2){
                    setIcon(img_bloc_etage_2);
                }
                else if (CelluleAssociee.BlocCellule.Etage==3){
                    setIcon(img_bloc_etage_3);
                }
                else if (CelluleAssociee.BlocCellule.Etage==4){
                    setIcon(img_dome);
                }
        }
        else if (CelluleAssociee.PresencePion(CelluleAssociee.PionCourantCellule)==true && CelluleAssociee.PresenceBloc()==true) {    
                if (CelluleAssociee.BlocCellule.Etage==0){
                    if ("Rouge".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {
                        setIcon(img_rouge_perso1_et0);
                    }
                    
                    if ("Noire".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {
                        setIcon(img_noir_perso1_et0);
                    }
                    if ("Verte".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_vert_perso1_et0);
                        
                    }
                    if ("Bleue".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_bleu_perso1_et0);
                        }
                    }
                if (CelluleAssociee.BlocCellule.Etage==1){
                    if ("Rouge".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_rouge_perso1_et1);
                    }
                    if ("Noire".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_noir_perso1_et1);
                        
                    }
                    if ("Verte".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_vert_perso1_et1);
                        
                    }
                    if ("Bleue".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_bleu_perso1_et1);
                    }
                }
                if (CelluleAssociee.BlocCellule.Etage==2){
                    if ("Rouge".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_rouge_perso1_et2);
                        
                    }
                    if ("Noire".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_noir_perso1_et2);
                        
                    }
                    if ("Verte".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_vert_perso1_et2);
                        
                    }
                    if ("Bleue".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_bleu_perso1_et2);
                        
                    }
                }
                if (CelluleAssociee.BlocCellule.Etage==3){
                    if ("Rouge".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_rouge_perso1_et3);
                        
                    }
                    if ("Noire".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_noir_perso1_et3);
                        
                    }
                    if ("Verte".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_vert_perso1_et3);
                        
                    }
                    if ("Bleue".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                        setIcon(img_bleu_perso1_et3);
                        
                    }
                }
                if (CelluleAssociee.BlocCellule.Etage==4){
                    setIcon(img_dome);
                }
        }
        else if (CelluleAssociee.PresencePion(CelluleAssociee.PionCourantCellule)==true && CelluleAssociee.PresenceBloc()==false){
            if ("Rouge".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                    setIcon(img_rouge_perso1_et0);
            }
            if ("Noire".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                setIcon(img_noir_perso1_et0);
            }
            if ("Verte".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                setIcon(img_vert_perso1_et0);
            }
            if ("Bleue".equals(CelluleAssociee.PionCourantCellule.CouleurPion)) {    
                setIcon(img_bleu_perso1_et0);
            }
        }
    }
    
}
