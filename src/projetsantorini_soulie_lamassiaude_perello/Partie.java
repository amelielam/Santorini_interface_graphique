/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsantorini_soulie_lamassiaude_perello;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Baptiste Soulié
 */
public class Partie {
    LinkedList <Joueur> ListeJoueur = new LinkedList<>();
    Joueur JoueurCourantPartie ;
    Plateau PDJ = new Plateau ();
    LinkedList <Bloc> BlocsDispo = new LinkedList<>();
    Bloc BlocCourantPartie;
    
    public Partie() {
        
    }
    
    public void debuterPartie(){
    //Nombre de joueurs:    
    Scanner nb = new Scanner(System.in);
    System.out.println("Entrez le nombre de joueurs : (min 2 et max 4) ");
    int nbJoueurs = nb.nextInt();
    while (nbJoueurs>4 || nbJoueurs<2){
            System.out.println("ERREUR: Veuillez ressaisir un nombre de joueurs correct:");
            nbJoueurs = nb.nextInt();
        }
    
    //inscription des nb joueurs:
    Scanner sca = new Scanner(System.in);
    System.out.println("Entrez le nom du premier joueur");
    String Joueur1=sca.next();
    System.out.println("Entrez le nom du second joueur");
    String Joueur2=sca.next();
    Joueur J1 = new Joueur(Joueur1);
    Joueur J2 = new Joueur(Joueur2);
    ListeJoueur.add(J1);
    ListeJoueur.add(J2);
    if (nbJoueurs > 2) {
        System.out.println("Entrez le nom du troisième joueur");
        String Joueur3=sca.next();
        Joueur J3 = new Joueur(Joueur3);
        ListeJoueur.add(J3);
        if (nbJoueurs == 4) {
            System.out.println("Entrez le nom du dernier joueur");
            String Joueur4=sca.next();
           Joueur J4 = new Joueur(Joueur4);
            ListeJoueur.add(J4);
        }
    }
    
    //détermination du 1er joueur :
        //pour une partie à 2 joueurs:
    if (nbJoueurs ==2){ 
        int NombreAleatoire = 1 + (int)(Math.random() * ((2 - 1) + 1));
        if (NombreAleatoire==1) {
            JoueurCourantPartie= ListeJoueur.get(0);
        }
        else{
            JoueurCourantPartie= ListeJoueur.get(1);
        }
    }
        // pour une partie à 3 joueurs:
    if (nbJoueurs ==3){ 
        int NombreAleatoire = 1 + (int)(Math.random() * ((3 - 1) + 1));
        if (NombreAleatoire==1) {
            JoueurCourantPartie= ListeJoueur.get(0);
        }
        if (NombreAleatoire==2) {
            JoueurCourantPartie= ListeJoueur.get(1);
        }
        if (NombreAleatoire==3) {
            JoueurCourantPartie= ListeJoueur.get(2);
        }
    }
        //pour une partie à 4 joueurs:
    if (nbJoueurs ==4){ 
        int NombreAleatoire = 1 + (int)(Math.random() * ((4 - 1) + 1));
        if (NombreAleatoire==1) {
            JoueurCourantPartie= ListeJoueur.get(0);
        }
        if (NombreAleatoire==2) {
            JoueurCourantPartie= ListeJoueur.get(1);
        }
        if (NombreAleatoire==3) {
            JoueurCourantPartie= ListeJoueur.get(2);
        }
        if (NombreAleatoire==4) {
            JoueurCourantPartie= ListeJoueur.get(3);
        }
    }
        
    System.out.println("Le premier joueur est : "+JoueurCourantPartie.Nom);
    
    //Distribution des couleurs:
        //pour une partie à 2 joueurs:
    if (nbJoueurs == 2){
        int CouleurAleatoire1 = 1 + (int)(Math.random() * ((2 - 1) + 1));
        if (CouleurAleatoire1==1) {
            ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
            ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
        }else{
            ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
            ListeJoueur.get(1).AffecterCouleurAuJoueur("Rouge");
        }
    }
        //pour une partie à 3 joueurs:
    if (nbJoueurs == 3){
        int CouleurAleatoire1 = 1 + (int)(Math.random() * ((3 - 1) + 1));
        if (CouleurAleatoire1==1) {
            ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2==1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                }else{
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                }
        }
        if (CouleurAleatoire1==2) {
            ListeJoueur.get(1).AffecterCouleurAuJoueur("Rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                }  
        }
        if (CouleurAleatoire1==3) {
            ListeJoueur.get(2).AffecterCouleurAuJoueur("Rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2==1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                }
        }
    }
        //pour une partie à 4 joueurs:
    if (nbJoueurs == 4){
        int CouleurAleatoire1 = 1 + (int)(Math.random() * ((4 - 1) + 1));
        if (CouleurAleatoire1==1) {
            ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((3 - 1) + 1));
            if (CouleurAleatoire2==1) {
                ListeJoueur.get(1).AffecterCouleurAuJoueur("Noire");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Verte");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==2) {
                ListeJoueur.get(2).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==3) {
               ListeJoueur.get(3).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
        }
        if (CouleurAleatoire1==2) {
            ListeJoueur.get(1).AffecterCouleurAuJoueur("rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((3 - 1) + 1));
            if (CouleurAleatoire2==1) {
                ListeJoueur.get(0).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==2) {
                ListeJoueur.get(2).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==3) {
               ListeJoueur.get(3).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
        }
        if (CouleurAleatoire1==3) {
            ListeJoueur.get(2).AffecterCouleurAuJoueur("rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((3 - 1) + 1));
            if (CouleurAleatoire2==1) {
                ListeJoueur.get(1).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==2) {
                ListeJoueur.get(0).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(3).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==3) {
               ListeJoueur.get(3).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
        }
        if (CouleurAleatoire1==4) {
            ListeJoueur.get(3).AffecterCouleurAuJoueur("rouge");
            int CouleurAleatoire2 = 1 + (int)(Math.random() * ((3 - 1) + 1));
            if (CouleurAleatoire2==1) {
                ListeJoueur.get(1).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==2) {
                ListeJoueur.get(2).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }
            }
            if (CouleurAleatoire2==3) {
               ListeJoueur.get(0).AffecterCouleurAuJoueur("jaune");
                int CouleurAleatoire3 = 1 + (int)(Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire3==1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("vert");
                }else{
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("vert");
                }
            }
        }
    }
    
    
    for (int numjoueur=0; numjoueur<nbJoueurs;numjoueur++){
        System.out.println(ListeJoueur.get(numjoueur).Nom+" a la couleur "+ListeJoueur.get(numjoueur).CouleurJoueur);
    }
    
      
    //Création de la grille:
    PDJ.viderPlateau();
    
    //Création des blocs dispos:
    for (int i=0 ; i<101 ; i++){
        Bloc NouvBloc = new Bloc();
        BlocsDispo.add(NouvBloc);
    }

    //Création des pions et placement: 
    for (int numjoueur=0; numjoueur<nbJoueurs;numjoueur++){
        //Pion1:
        Scanner lignechoisie = new Scanner(System.in);
        System.out.println(ListeJoueur.get(numjoueur).Nom+" Sélectionnez les coordonnées de la case de votre premier pion:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligne_P1 = lignechoisie.nextInt()-1;
        while (ligne_P1>4 || ligne_P1<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligne_P1 = lignechoisie.nextInt()-1;
            }
        Scanner colonnechoisie = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonne_P1 = colonnechoisie.nextInt()-1;
        while (colonne_P1>4 || colonne_P1<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonne_P1 = colonnechoisie.nextInt()-1;
            }
        
        //Création du pion 1 et affectation sur le plateau:
        ListeJoueur.get(numjoueur).Pion1 = new Pion(ListeJoueur.get(numjoueur).CouleurJoueur);
        PDJ.Cases[ligne_P1][colonne_P1].AffecterPion(ListeJoueur.get(numjoueur).Pion1);
        
        //Pion2:
        Scanner ligne2choisie = new Scanner(System.in);
        System.out.println(ListeJoueur.get(numjoueur).Nom+" Sélectionnez les coordonnées de la case du deuxième pion:");
        System.out.println("Sélectionnez un numéro de ligne:");
        int ligne_P2 = ligne2choisie.nextInt()-1;
        while (ligne_P2>4 || ligne_P2<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de ligne correct:");
            ligne_P2 = ligne2choisie.nextInt()-1;
        }
        Scanner colonne2choisie = new Scanner(System.in);
        System.out.println("Sélectionnez un numéro de colonne:");
        int colonne_P2 = colonne2choisie.nextInt()-1;
        while (colonne_P2>4 || colonne_P2<0){
            System.out.println("ERREUR: Veuillez ressaisir un numéro de colonne correct:");
            colonne_P2 = colonne2choisie.nextInt()-1;
        }
        
        //Création du pion 1 et affectation sur le plateau:
        ListeJoueur.get(numjoueur).Pion2 = new Pion(ListeJoueur.get(numjoueur).CouleurJoueur);    
        PDJ.AjouterPionSurCellule(ListeJoueur.get(numjoueur).Pion2, ligne_P2,colonne_P2);
    }
    
    while((PDJ.etreGagnantePourJoueur(ListeJoueur.get(0).Pion1)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(0).Pion2)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(1).Pion1)!=true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(1).Pion2)!=true)){// && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion2)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion2)!=true)){
        //afficher la grille
        PDJ.afficherPlateauSurConsole();
        
        
        //déplacer un pion:
        Scanner pion = new Scanner(System.in);
        System.out.println(JoueurCourantPartie.Nom+" Sélectionnez le pion que vous voulez déplacer:");
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
        System.out.println(JoueurCourantPartie.Nom+" Sélectionnez les coordonnées de la case où vous souhaitez placer un bloc:");
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
            PDJ.AjouterBlocSurCellule(BlocsDispo.getLast(),JoueurCourantPartie.Pion1,ligneB,colonneB);
        }else{
            PDJ.AjouterBlocSurCellule(BlocsDispo.getLast(),JoueurCourantPartie.Pion2,ligneB,colonneB);
        }
        PDJ.afficherPlateauSurConsole();
        
        //Prochain joueur:
        if (nbJoueurs==2) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            } else {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        if (nbJoueurs==3) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            }
            if (JoueurCourantPartie == ListeJoueur.get(1)) {
                JoueurCourantPartie = ListeJoueur.get(2);
            }
            if (JoueurCourantPartie == ListeJoueur.get(2)) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        if (nbJoueurs==3) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            }
            if (JoueurCourantPartie == ListeJoueur.get(1)) {
                JoueurCourantPartie = ListeJoueur.get(2);
            }
            if (JoueurCourantPartie == ListeJoueur.get(2)) {
                JoueurCourantPartie = ListeJoueur.get(3);
            }
            if (JoueurCourantPartie == ListeJoueur.get(3)) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        System.out.println("C'est au tour de: "+JoueurCourantPartie.Nom);
    }
    
}
}
   
