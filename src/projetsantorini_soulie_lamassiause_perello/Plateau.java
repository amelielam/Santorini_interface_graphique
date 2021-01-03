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
public class Plateau {

    Cellule[][] Cases;

    public Plateau() {
        Cases = new Cellule[5][5];
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                Cases[i][j]=new Cellule();
            }
        }
    }
    
    public void  viderPlateau(){
    //vide la grille
    for(int i=0;i<Cases.length;i++){
        for(int j=0;j<Cases[0].length;j++){
            Cases[i][j].BlocCellule.Etage=0;
            Cases[i][j].PionCourantCellule=null;
    }
}
}

    public boolean DeplacerPion(Pion PionJoue, int x_a, int y_a) {
        boolean test =false;
        //vérification que le pion est sur une case adjacente:
        if (x_a==0 && y_a!=0 && y_a!=4){
            if (Cases[x_a][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a][y_a - 1].PresencePion(PionJoue) == true) {
                if (Cases[x_a][y_a].BlocCellule.Etage <= 3) {
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 0) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 1) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                        PionJoue.EtagePion += 1;
                    }
                    if (PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage <= 3 && PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage > 0) {
                        PionJoue.EtagePion = Cases[x_a][y_a].BlocCellule.Etage;
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    test= true;
                }else {
                    test= false;
                }
            }    
        }
        else if (x_a==5 && y_a!=0 && y_a!=4){
            if (Cases[x_a - 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a].PresencePion(PionJoue) == true) {
                if (Cases[x_a][y_a].BlocCellule.Etage <= 3) {
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 0) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 1) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                        PionJoue.EtagePion += 1;
                    }
                    if (PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage <= 3 && PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage > 0) {
                        PionJoue.EtagePion = Cases[x_a][y_a].BlocCellule.Etage;
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    test= true;
                }else {
                    test= false;
                }
            }   
        }
        
        else if (y_a==0 && x_a!=0 && x_a!=4){
            if (Cases[x_a - 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a].PresencePion(PionJoue) == true) {
                if (Cases[x_a][y_a].BlocCellule.Etage <= 3) {
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 0) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 1) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                        PionJoue.EtagePion += 1;
                    }
                    if (PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage <= 3 && PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage > 0) {
                        PionJoue.EtagePion = Cases[x_a][y_a].BlocCellule.Etage;
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        else if (y_a==5 && x_a!=0 && x_a!=4){
            if (Cases[x_a + 1][y_a].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a].PresencePion(PionJoue) == true) {
                if (Cases[x_a][y_a].BlocCellule.Etage <= 3) {
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 0) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 1) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                        PionJoue.EtagePion += 1;
                    }
                    if (PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage <= 3 && PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage > 0) {
                        PionJoue.EtagePion = Cases[x_a][y_a].BlocCellule.Etage;
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        else if (y_a!=0 &&y_a!=4 && x_a!=0 && x_a!=4){
            if(Cases[x_a - 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a + 1].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a].PresencePion(PionJoue) == true || Cases[x_a + 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a - 1].PresencePion(PionJoue) == true || Cases[x_a - 1][y_a].PresencePion(PionJoue) == true) {
            //vérification que le pion est à un bon niveau:
                if (Cases[x_a][y_a].BlocCellule.Etage <= 3) {
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 0) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    if (Cases[x_a][y_a].BlocCellule.Etage - PionJoue.EtagePion == 1) {
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                        PionJoue.EtagePion += 1;
                    }
                    if (PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage <= 3 && PionJoue.EtagePion - Cases[x_a][y_a].BlocCellule.Etage > 0) {
                        PionJoue.EtagePion = Cases[x_a][y_a].BlocCellule.Etage;
                        Cases[x_a][y_a].AffecterPion(PionJoue);
                    }
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        return test;
    }
        

    public boolean AjouterBlocSurCellule(Bloc BlocJoue, Pion PionAdjacent, int i, int j) {
        boolean test =false;
        //vérification que le pion est sur une case adjacente:
        if (i==0 && j!=0 && j!=4){
            if (Cases[i][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j].PresencePion(PionAdjacent) == true || Cases[i + 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i][j - 1].PresencePion(PionAdjacent) == true) {
                if (Cases[i][j].BlocCellule.Etage <= 4) {
                    Cases[i][j].AffecterBloc(BlocJoue);
                    test= true;
                }else {
                    test= false;
                }
            }    
        }
        else if (i==5 && j!=0 && j!=4){
            if (Cases[i - 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i][j + 1].PresencePion(PionAdjacent) == true || Cases[i][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j].PresencePion(PionAdjacent) == true) {
                if (Cases[i][j].BlocCellule.Etage <= 4) {
                    Cases[i][j].AffecterBloc(BlocJoue);
                    test= true;
                }else {
                    test= false;
                }
            }   
        }
        
        else if (j==0 && i!=0 && i!=4){
            if (Cases[i - 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j].PresencePion(PionAdjacent) == true || Cases[i - 1][j].PresencePion(PionAdjacent) == true) {
                if (Cases[i][j].BlocCellule.Etage <= 4) {
                    Cases[i][j].AffecterBloc(BlocJoue);
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        else if (j==5 && i!=0 && i!=4){
            if (Cases[i + 1][j].PresencePion(PionAdjacent) == true || Cases[i + 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j].PresencePion(PionAdjacent) == true) {
                if (Cases[i][j].BlocCellule.Etage <= 4) {
                    Cases[i][j].AffecterBloc(BlocJoue);
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        else if (j!=0 &&j!=4 && i!=0 && i!=4){
            if(Cases[i - 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j + 1].PresencePion(PionAdjacent) == true || Cases[i + 1][j].PresencePion(PionAdjacent) == true || Cases[i + 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j - 1].PresencePion(PionAdjacent) == true || Cases[i - 1][j].PresencePion(PionAdjacent) == true) {
                if (Cases[i][j].BlocCellule.Etage <= 4) {
                    Cases[i][j].AffecterBloc(BlocJoue);
                    test= true;
                }else {
                    test= false;
                }
            }
        }
        return test;
    }
    
    
    public boolean AjouterPionSurCellule(Pion PionJoue, int ligne, int colonne){
        if (Cases[ligne][colonne].PresencePion(Cases[ligne][colonne].PionCourantCellule)==true){
            return false;
        }else{
            Cases[ligne][colonne].AffecterPion(PionJoue);
            return true;
        }
    }
    
    
    public boolean etrePerdantePourJoueur(Pion PionActuel){
        boolean test=false;
        for(int i=0; i<Cases.length;i++){
            for(int j=0; j<Cases[0].length;j++){
                if (DeplacerPion(PionActuel,i,j)==false){
                    test= true;
                }
            }
        }
        return test;
    }
    
    public boolean etreGagnantePourJoueur(Pion PionActuel){
        if (PionActuel.EtagePion==3) {
            return true;
        }else{
            return false;
        }
}
   
public void  afficherPlateauSurConsole(){
    //fonction d’affichage de la grille sur la console. Doit faire apparaitre les pions et les blocs avec leurs niveaux.
    for(int i=0;i<Cases.length;i++){
        for(int j=0;j<Cases[0].length;j++){
            if (Cases[i][j].PresenceBloc()==true && Cases[i][j].PresencePion(Cases[i][j].PionCourantCellule)!=true){
                if (Cases[i][j].BlocCellule.Etage==0){
                    System.out.print("\u2395 ");
                }
                        
                if (Cases[i][j].BlocCellule.Etage==1){
                    System.out.print("\u058D"+"1");
                }
                if (Cases[i][j].BlocCellule.Etage==2){
                    System.out.print("\u058D"+"2");
                }
                if (Cases[i][j].BlocCellule.Etage==3){
                    System.out.print("\u058D"+"3");
                }
                if (Cases[i][j].BlocCellule.Etage==4){
                    System.out.print("D ");
                }
            }
            if (Cases[i][j].PresencePion(Cases[i][j].PionCourantCellule)==true && Cases[i][j].PresenceBloc()==true) {    
                if (Cases[i][j].BlocCellule.Etage==0){
                    if ("rouge".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print(Cases[i][j].PionCourantCellule.EtagePion+"R");
                    }
                    if ("jaune".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print(Cases[i][j].PionCourantCellule.EtagePion+"J");
                    }
                }
                if (Cases[i][j].BlocCellule.Etage==1){
                    if ("rouge".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"R");
                    }
                    if ("jaune".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"J");
                    }
                }
                if (Cases[i][j].BlocCellule.Etage==2){
                    if ("rouge".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"R");
                    }
                    if ("jaune".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"J");
                    }
                }
                if (Cases[i][j].BlocCellule.Etage==3){
                    if ("rouge".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"R");
                    }
                    if ("jaune".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print("\u058D"+Cases[i][j].PionCourantCellule.EtagePion+"J");
                    }
                }
                if (Cases[i][j].BlocCellule.Etage==4){
                    System.out.print("D ");
                }
            }
            else if (Cases[i][j].PresencePion(Cases[i][j].PionCourantCellule)==true){
                if ("rouge".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                        System.out.print(Cases[i][j].PionCourantCellule.EtagePion+"R");
                }
                if ("jaune".equals(Cases[i][j].PionCourantCellule.CouleurPion)) {    
                    System.out.print(Cases[i][j].PionCourantCellule.EtagePion+"J");
                }
            }
            else if (Cases[i][j].PresenceBloc()!=true && Cases[i][j].PresencePion(Cases[i][j].PionCourantCellule)!=true){
                System.out.print("\u2395 ");
                
                }
       }
        System.out.println(" "+(i+1)); //afichage du numéro de ligne
    }
    for (int a=0;a<Cases[0].length;a++){ //affichage du numéro de colonne
        System.out.print((a+1)+" ");
    }
    System.out.println();
}
}
