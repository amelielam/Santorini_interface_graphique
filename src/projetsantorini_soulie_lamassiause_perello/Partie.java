/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsantorini_soulie_lamassiause_perello;

import java.util.Scanner;

/**
 *
 * @author Baptiste Soulié
 */
public class Partie {
    Joueur [] ListeJoueur = new Joueur[2];
    Joueur JoueurCourantPartie ;
    Plateau PDJ = new Plateau ();
    Bloc BlocCourantPartie;
    
    public Partie() {
        
    }
    
    public void attribuerCouleursAuxJoueurs(){
    double nbalea=Math.random();
    if (nbalea>0.5) {
        ListeJoueur[0].AffecterCouleurAuJoueur("rouge");
        ListeJoueur[1].AffecterCouleurAuJoueur("jaune");
        System.out.println(ListeJoueur[0].Nom+" a la couleur ROUGE");
        System.out.println(ListeJoueur[1].Nom+" a la couleur JAUNE");
    }else{
        ListeJoueur[0].AffecterCouleurAuJoueur("jaune");
        ListeJoueur[1].AffecterCouleurAuJoueur("rouge");
        System.out.println(ListeJoueur[1].Nom+" a la couleur ROUGE");
        System.out.println(ListeJoueur[0].Nom+" a la couleur JAUNE");
    }
}
    
    public void initialiserPartie(){
        
    //Création de la grille:
    PDJ.viderPlateau();
    
    //Création des pions:
    ListeJoueur[0].Pion1 = new Pion(ListeJoueur[0].CouleurJoueur);
    ListeJoueur[0].Pion2 = new Pion(ListeJoueur[0].CouleurJoueur);
    ListeJoueur[1].Pion1 = new Pion(ListeJoueur[1].CouleurJoueur);
    ListeJoueur[1].Pion2 = new Pion(ListeJoueur[1].CouleurJoueur);

    //Placer pions:
    for (int numjoueur=0; numjoueur<2;numjoueur++){
        //Pion1:
        Scanner lignechoisie = new Scanner(System.in);
        System.out.println(ListeJoueur[numjoueur].Nom+" Sélectionnez les coordonnées de la case de votre premier pion:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligne = lignechoisie.nextInt()-1;
        while (ligne>4 || ligne<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligne = lignechoisie.nextInt()-1;
            }
        Scanner colonnechoisie = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonne = colonnechoisie.nextInt()-1;
        while (colonne>4 || colonne<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonne = colonnechoisie.nextInt()-1;
            }
        PDJ.Cases[ligne][colonne].AffecterPion(ListeJoueur[numjoueur].Pion1);
        
        //Pion2:
        Scanner ligne2choisie = new Scanner(System.in);
        System.out.println(ListeJoueur[numjoueur].Nom+"Sélectionnez les coordonnées de la case du deuxième pion:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligne2 = ligne2choisie.nextInt()-1;
        while (ligne2>4 || ligne2<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligne2 = ligne2choisie.nextInt()-1;
        }
        Scanner colonne2choisie = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonne2 = colonne2choisie.nextInt()-1;
        while (colonne2>4 || colonne2<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonne2 = colonne2choisie.nextInt()-1;
        }
        PDJ.AjouterPionSurCellule(ListeJoueur[numjoueur].Pion2, ligne2,colonne2);
    }
    }

    public void debuterPartie(){
    //inscription des 2 joueurs:
    Scanner sca = new Scanner(System.in);
    System.out.println("Entrez le nom du premier joueur");
    String Joueur1=sca.next();
    System.out.println("Entrez le nom du second joueur");
    String Joueur2=sca.next();
    Joueur J1 = new Joueur(Joueur1);
    Joueur J2 = new Joueur(Joueur2);
    ListeJoueur[0]=J1;
    ListeJoueur[1]=J2;
    
    //détermination du 1er joueur:
    double nbalea=Math.random();
    if (nbalea>0.5) {
        JoueurCourantPartie= ListeJoueur[0];
    }
    else{
        JoueurCourantPartie= ListeJoueur[1];
    }
    System.out.println("Le premier joueur est : "+JoueurCourantPartie.Nom);
    
    //Distribution des couleurs:
    attribuerCouleursAuxJoueurs();
    
    //Creation de la grille et répartition des pions
    initialiserPartie();
    
    while((PDJ.etreGagnantePourJoueur(ListeJoueur[0].Pion1)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur[0].Pion2)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur[1].Pion1)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur[1].Pion2)!=true)){// && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion2)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion2)!=true)){
        //afficher la grille
        PDJ.afficherPlateauSurConsole();
        
        
        //déplacer un pion:
        Scanner pion = new Scanner(System.in);
        System.out.println("Sélectionnez le pion que vous voulez déplacer:");
        int pionchoisi = pion.nextInt();
        Scanner li = new Scanner(System.in);
        System.out.println("Sélectionnez les coordonnées de la case:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligne = li.nextInt()-1;
        while (ligne>4 || ligne<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligne = li.nextInt()-1;
        }
        Scanner col = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonne = col.nextInt()-1;
        while (colonne>4 || colonne<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonne = col.nextInt()-1;   
        }
        if (pionchoisi==1){
            PDJ.DeplacerPion(JoueurCourantPartie.Pion1,ligne,colonne);
        }else{
            PDJ.DeplacerPion(JoueurCourantPartie.Pion2,ligne,colonne);
        }
        PDJ.afficherPlateauSurConsole();
        
        //placer un bloc:
        Scanner lig = new Scanner(System.in);
        System.out.println("Sélectionnez les coordonnées de la case:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligneB = lig.nextInt()-1;
        while (ligneB>4 || ligneB<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligneB = lig.nextInt()-1;
        }
        Scanner colo = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonneB = colo.nextInt()-1;
        while (colonneB>4 || colonneB<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonneB = colo.nextInt()-1;   
        }
        if (pionchoisi==1){
            PDJ.AjouterBlocSurCellule(BlocCourantPartie,JoueurCourantPartie.Pion1,ligneB,colonneB);
        }else{
            PDJ.AjouterBlocSurCellule(BlocCourantPartie,JoueurCourantPartie.Pion2,ligneB,colonneB);
        }
    }
    
}
}
   
