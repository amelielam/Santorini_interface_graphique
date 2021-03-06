package projetsantorini_soulie_lamassiaude_perello;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class FenetreDeJeu extends javax.swing.JFrame {

    LinkedList<Joueur> ListeJoueur = new LinkedList<>();
    Joueur JoueurCourantPartie;
    Plateau PDJ = new Plateau();
    LinkedList<Bloc> BlocsDispo = new LinkedList<>();
    Bloc BlocCourantPartie;
    Pion PionSelectionne;
    int xlast;
    int ylast;
    boolean PlacementPion1_J1 = true;
    boolean PlacementPion2_J1 = false;
    boolean PlacementPion1_J2 = false;
    boolean PlacementPion2_J2 = false;
    boolean PlacementPion1_J3 = false;
    boolean PlacementPion2_J3 = false;
    boolean PlacementPion1_J4 = false;
    boolean PlacementPion2_J4 = false;
    boolean PersoSelectionne = false;
    boolean Deplacement = false;
    boolean Construction = false;
    boolean DeuxiemeClic = false;
    boolean ClicDeplacement = false;
    boolean ReSelectionDeplacement = false;

    /**
     * Creates new form FenetreDeJeu
     */
    public FenetreDeJeu() {
        initComponents();
        DebutDePartie.setVisible(false);
        PlateauDeJeu.setVisible(false);
        InfoJoueurs.setVisible(false);
        InfoPartie.setVisible(false);
        FinDePartie.setVisible(false);
        for (int i = 4; i >= 0; i--) {
            for (int j = 0; j < 5; j++) {
                CelluleGraphique CellGraph = new CelluleGraphique(PDJ.Cases[i][j], i, j);
                //while ((PDJ.etreGagnantePourJoueur(ListeJoueur.get(0).Pion1) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(0).Pion2) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(1).Pion1) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(1).Pion2) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(2).Pion1) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(2).Pion2) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(3).Pion1) != true) && (PDJ.etreGagnantePourJoueur(ListeJoueur.get(3).Pion2) != true)) {// && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[0].Pion2)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion1)!=true) && (PDJ.etrePerdantePourJoueur(ListeJoueur[1].Pion2)!=true)){
                CellGraph.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if (DeuxiemeClic == true) {
                            Deplacement = false;
                            PersoSelectionne = false;
                            DeuxiemeClic = false;
                        }
                        if (ClicDeplacement == true) {
                            Deplacement = true;
                            Construction = false;
                            ClicDeplacement = false;
                        }
                        if (Construction == true) {
                            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == false) {
                                message.setText("Cette case est déja occupée par un pion\n\nVous ne pouvez pas ajouter de bloc ici");
                            }else{
                                ConstruireBloc(CellGraph, PionSelectionne, CellGraph.coord_x, CellGraph.coord_y);
                                
                        }
                        }
                        if (Deplacement == true) {
                            DeplacerPerso(CellGraph, CellGraph.coord_x, CellGraph.coord_y);
                            if (PionSelectionne.EtagePion==3){
                                Construction=false;
                                JoueurGagnant.setText(JoueurCourantPartie.Nom);
                                PlateauDeJeu.setVisible(false);
                                btn_start.setEnabled(true);
                                FinDePartie.setVisible(true);
                                
                            }

                        }
                        PlacerPions(CellGraph);

                    }
                });
                PlateauDeJeu.add(CellGraph);
                //}
            }
        }
    }

    public void PlacerPions(CelluleGraphique CellGraph) {
        if (PlacementPion2_J4 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
                CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion2);
                JoueurSuivant();
                message.setText(JoueurCourantPartie.Nom + " quel pion souhaitez vous déplacer?");
                Deplacement = true;
                PlacementPion2_J4 = false;
            } else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion1_J4 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
                CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion1);
                message.setText(JoueurCourantPartie.Nom + " placez votre 2ème pion");
                PlacementPion2_J4 = true;
                PlacementPion1_J4 = false;
            } else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion2_J3 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
            CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion2);
            if (NombreDeJoueurs() == 4) {
                JoueurSuivant();
                message.setText("C'est au tour de " + JoueurCourantPartie.Nom + "\n\n" + JoueurCourantPartie.Nom + " vous pouvez placer votre premier pion");
                PlacementPion1_J4 = true;
            } else {
                JoueurSuivant();
                message.setText(JoueurCourantPartie.Nom + " quel pion souhaitez vous déplacer?");
                Deplacement = true;
            }
            PlacementPion2_J3 = false;
            }else{
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion1_J3 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
                CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion1);
                message.setText(JoueurCourantPartie.Nom + " placez votre 2ème pion");
                PlacementPion2_J3 = true;
                PlacementPion1_J3 = false;
            } else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion2_J2 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
            CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion2);
            if (NombreDeJoueurs() == 3 || NombreDeJoueurs() == 4) {
                JoueurSuivant();
                message.setText("C'est au tour de " + JoueurCourantPartie.Nom + "\n\n" + JoueurCourantPartie.Nom + " vous pouvez placer votre premier pion");
                PlacementPion1_J3 = true;
            } else {
                JoueurSuivant();
                message.setText(JoueurCourantPartie.Nom + " quel pion souhaitez vous déplacer?");
                Deplacement = true;
            }
            PlacementPion2_J2 = false;
            }else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion1_J2 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
                CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion1);
                message.setText(JoueurCourantPartie.Nom + " placez votre 2ème pion");
                PlacementPion2_J2 = true;
                PlacementPion1_J2 = false;
            } else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion2_J1 == true) {
            if (PDJ.Cases[CellGraph.coord_x][CellGraph.coord_y].CaseSansPion() == true) {
                CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion2);
                JoueurSuivant();
                message.setText("C'est au tour de " + JoueurCourantPartie.Nom + "\n\n" + JoueurCourantPartie.Nom + " vous pouvez placer votre premier pion");
                PlacementPion1_J2 = true;
                PlacementPion2_J1 = false;
            } else {
                message.setText("Cette case est déja occupée par un autre pion \nIl faut en choisir une autre");
            }
        }
        if (PlacementPion1_J1 == true) {
            CellGraph.CelluleAssociee.AffecterPion(JoueurCourantPartie.Pion1);
            message.setText(JoueurCourantPartie.Nom + " placez votre 2ème pion");
            PlacementPion2_J1 = true;
            PlacementPion1_J1 = false;
        }

    }

    public void DeplacerPerso(CelluleGraphique CellGraph, int i, int j) {
        //si pion sur case sélectionnée est bien le sien alors peut sinon non
        
        if (PersoSelectionne == true) {
            //phase de déplacement du personnage : on a cliqué sur la case de destination [i,j]
            if (ReSelectionDeplacement = true) {
                PersoSelectionne = true;
                ReSelectionDeplacement = false;
            }
            if (PDJ.Cases[i][j].CaseSansPion() == true) {
                PDJ.DeplacerPion(PionSelectionne, i, j);
                if (PDJ.DeplacerPion(PionSelectionne, i, j)==false){
                    message.setText("vous ne pouvez pas déplacer le pion ici");
                }else{
                    PDJ.Cases[xlast][ylast].SupprimerPion();//supprimer le pion qui était à la position d'avant
                    PlateauDeJeu.repaint();
                    message.setText(JoueurCourantPartie.Nom + " sélectionnez une case pour placer un bloc");
                    DeuxiemeClic = true;
                    Construction = true;
                }
            } else {
                message.setText("Cette case est déja occupée par un autre pion\n\nIl faut en choisir une autre");
                ReSelectionDeplacement = true;
            }
        }
        if (PersoSelectionne == false) {
            //phase de sélection de personnage qui se trouve sur la case [i,j]
            if (CellGraph.CelluleAssociee.PresencePion(JoueurCourantPartie.Pion1) == true){ 
                PionSelectionne=JoueurCourantPartie.Pion1;
                xlast = CellGraph.coord_x;
                ylast = CellGraph.coord_y;
                message.setText("Où voulez-vous le placer?");
                PersoSelectionne = true;
            }
            else if(CellGraph.CelluleAssociee.PresencePion(JoueurCourantPartie.Pion2) == true) {
                PionSelectionne=JoueurCourantPartie.Pion2;
                xlast = CellGraph.coord_x;
                ylast = CellGraph.coord_y;
                message.setText("Où voulez-vous le placer?");
                PersoSelectionne = true;
            }
        }

    }

    public void ConstruireBloc(CelluleGraphique CellGraph, Pion PionAdjacent, int i, int j) {
        //phase de sélection de de la case où on veut placer le bloc
        //phase de construction du bloc : on a cliqué sur la case de destination
        if (CellGraph.CelluleAssociee.BlocCellule.Etage==0){
            if (PDJ.AjouterBlocSurCellule(BlocsDispo.getLast(), PionAdjacent, i, j)==false){
                message.setText("Vous ne pouvez pas placer de bloc ici");
            }else{
                BlocsDispo.removeLast();
                JoueurSuivant();
                message.setText("C'est à " + JoueurCourantPartie.Nom + " de jouer.\nSélectionnez un pion à déplacer.");
                ClicDeplacement = true;
                PlateauDeJeu.repaint();
            }
        }else{ 
            if (PDJ.AjouterBlocSurCellule(CellGraph.CelluleAssociee.BlocCellule, PionAdjacent, i, j)==false){
                message.setText("Vous ne pouvez pas placer de bloc ici");
            }else{
                JoueurSuivant();
                message.setText("C'est à " + JoueurCourantPartie.Nom + " de jouer.\nSélectionnez un pion à déplacer.");
                ClicDeplacement = true;
                PlateauDeJeu.repaint();
            }
        }
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FinDePartie = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        JoueurGagnant = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        RestartButton = new javax.swing.JButton();
        DebPartie = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        PlateauDeJeu = new javax.swing.JPanel();
        DebutDePartie = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NomJoueur1 = new javax.swing.JTextField();
        NomJoueur2 = new javax.swing.JTextField();
        btn_start = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        NomJoueur3 = new javax.swing.JTextField();
        NomJoueur4 = new javax.swing.JTextField();
        InfoJoueurs = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlb_J1_nom = new javax.swing.JLabel();
        jlb_J1_couleur = new javax.swing.JLabel();
        jlb_J2_couleur = new javax.swing.JLabel();
        jlb_J2_nom = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlb_J3_couleur = new javax.swing.JLabel();
        jlb_J3_nom = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlb_J4_couleur = new javax.swing.JLabel();
        jlb_J4_nom = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        InfoPartie = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jlb_JoueurCourant = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        message = new javax.swing.JTextArea();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FinDePartie.setBackground(new java.awt.Color(51, 102, 255));
        FinDePartie.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        FinDePartie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("vous avez gagné !");
        FinDePartie.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        JoueurGagnant.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FinDePartie.add(JoueurGagnant, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 80, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Bravo");
        FinDePartie.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        RestartButton.setText("Rejouer");
        RestartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartButtonActionPerformed(evt);
            }
        });
        FinDePartie.add(RestartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 100, 30));

        getContentPane().add(FinDePartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 650, 240));

        DebPartie.setBackground(new java.awt.Color(153, 204, 255));
        DebPartie.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DebPartie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 23)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Santorini !");
        DebPartie.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(51, 102, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 joueurs", "3 joueurs" , "4 joueurs"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        DebPartie.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 110, 35));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Sélectionnez le nombre de joueurs :");
        DebPartie.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 225, -1));

        jLabel18.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel18.setText("Bienvenue dans le jeu ");
        DebPartie.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText(" Santorini !");
        DebPartie.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        getContentPane().add(DebPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 720, 380));

        PlateauDeJeu.setBackground(new java.awt.Color(255, 255, 255));
        PlateauDeJeu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlateauDeJeuMouseClicked(evt);
            }
        });
        PlateauDeJeu.setLayout(new java.awt.GridLayout(5, 5));
        getContentPane().add(PlateauDeJeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 500, 500));

        DebutDePartie.setBackground(new java.awt.Color(166, 227, 156));
        DebutDePartie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom du joueur 1 : ");
        DebutDePartie.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setText("Nom du joueur 2 : ");
        DebutDePartie.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        NomJoueur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomJoueur1ActionPerformed(evt);
            }
        });
        DebutDePartie.add(NomJoueur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, -1));
        DebutDePartie.add(NomJoueur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 120, -1));

        btn_start.setBackground(new java.awt.Color(255, 255, 255));
        btn_start.setFont(new java.awt.Font("Harrington", 1, 12)); // NOI18N
        btn_start.setForeground(new java.awt.Color(7, 127, 7));
        btn_start.setText("Démarrer partie");
        btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_startActionPerformed(evt);
            }
        });
        DebutDePartie.add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 130, 40));

        jLabel12.setText("Nom du joueur 3 : ");
        DebutDePartie.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel13.setText("Nom du joueur 4 : ");
        DebutDePartie.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        NomJoueur3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomJoueur3ActionPerformed(evt);
            }
        });
        DebutDePartie.add(NomJoueur3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));
        DebutDePartie.add(NomJoueur4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, -1));

        getContentPane().add(DebutDePartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 430, 150));

        InfoJoueurs.setBackground(new java.awt.Color(162, 200, 181));
        InfoJoueurs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Joueur  1 :");
        InfoJoueurs.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel5.setText("Couleur : ");
        InfoJoueurs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));
        InfoJoueurs.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 92, 390, 10));

        jlb_J1_nom.setText("nomJoueur1");
        InfoJoueurs.add(jlb_J1_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jlb_J1_couleur.setText("couleurJoueur1");
        InfoJoueurs.add(jlb_J1_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jlb_J2_couleur.setText("couleurJoueur2");
        InfoJoueurs.add(jlb_J2_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jlb_J2_nom.setText("nomJoueur2");
        InfoJoueurs.add(jlb_J2_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel6.setText("Couleur : ");
        InfoJoueurs.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel7.setText("Joueur  2 :");
        InfoJoueurs.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Harrington", 0, 14)); // NOI18N
        jLabel8.setText("Infos Joueurs:");
        InfoJoueurs.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlb_J3_couleur.setText("couleurJoueur3");
        InfoJoueurs.add(jlb_J3_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jlb_J3_nom.setText("nomJoueur3");
        InfoJoueurs.add(jlb_J3_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel14.setText("Couleur : ");
        InfoJoueurs.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel15.setText("Joueur  3 :");
        InfoJoueurs.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jlb_J4_couleur.setText("couleurJoueur4");
        InfoJoueurs.add(jlb_J4_couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jlb_J4_nom.setText("nomJoueur4");
        InfoJoueurs.add(jlb_J4_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel16.setText("Couleur : ");
        InfoJoueurs.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel17.setText("Joueur  4 :");
        InfoJoueurs.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        getContentPane().add(InfoJoueurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 430, 190));

        InfoPartie.setBackground(new java.awt.Color(101, 174, 120));
        InfoPartie.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Harrington", 0, 18)); // NOI18N
        jLabel3.setText("Infos Partie :");
        InfoPartie.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jlb_JoueurCourant.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlb_JoueurCourant.setText("nomJoueurCourant");
        InfoPartie.add(jlb_JoueurCourant, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jLabel9.setText("Joueur  Courant :");
        InfoPartie.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        message.setColumns(20);
        message.setRows(5);
        jScrollPane1.setViewportView(message);

        InfoPartie.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 410, -1));

        getContentPane().add(InfoPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 430, 180));

        jToggleButton1.setBackground(new java.awt.Color(153, 204, 255));
        jToggleButton1.setText("Règles du Jeu (Les parties se jouent sans les dieux et héros)");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 430, 40));

        setBounds(0, 0, 1059, 662);
    }// </editor-fold>//GEN-END:initComponents

    private void NomJoueur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomJoueur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomJoueur1ActionPerformed

    private void btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_startActionPerformed
        // TODO add your handling code here:
        InfoJoueurs.setVisible(true);
        InfoPartie.setVisible(true);
        PlateauDeJeu.setVisible(true);
        InitialiserPartie();
        PlateauDeJeu.repaint();
        btn_start.setEnabled(false);
    }//GEN-LAST:event_btn_startActionPerformed

    public int NombreDeJoueurs() {
        String NbDeJoueurs = (String) jComboBox1.getSelectedItem();
        int nbJoueurs = 0;
        if (NbDeJoueurs.equals("2 joueurs")) {
            nbJoueurs = 2;
        }
        if (NbDeJoueurs.equals("3 joueurs")) {
            nbJoueurs = 3;
        }
        if (NbDeJoueurs.equals("4 joueurs")) {
            nbJoueurs = 4;
        }
        return nbJoueurs;
    }

    public void InitialiserPartie() {
        //Nombre de joueurs: 
        int nbJoueurs = NombreDeJoueurs();

        InscriptionDesJoueurs(nbJoueurs);

        DeterminationDuPremierJoueur(nbJoueurs);

        DeterminationDesCouleurs(nbJoueurs);

        jlb_JoueurCourant.setText(JoueurCourantPartie.Nom);

        //Création de la grille:
        PDJ.viderPlateau();

        //Création des blocs dispos:
        for (int i = 0; i < 101; i++) {
            Bloc NouvBloc = new Bloc();
            BlocsDispo.add(NouvBloc);
        }

        //Création des pions:
        for (int numjoueur = 0; numjoueur < nbJoueurs; numjoueur++) {
            JoueurCourantPartie.Pion1 = new Pion(JoueurCourantPartie.CouleurJoueur);
            JoueurCourantPartie.Pion2 = new Pion(JoueurCourantPartie.CouleurJoueur);
            JoueurSuivant();
        }
        message.setText("DEBUT DE PARTIE : Placement des pions\n\n" + JoueurCourantPartie.Nom + " vous êtes le premier joueur à jouer. \n\nSélectionnez une case pour placer votre premier pion");

    }

    public void InscriptionDesJoueurs(int nbJoueurs) {
        //inscription des nb joueurs:
        String Joueur1 = NomJoueur1.getText();
        String Joueur2 = NomJoueur2.getText();
        Joueur J1 = new Joueur(Joueur1);
        Joueur J2 = new Joueur(Joueur2);
        ListeJoueur.add(J1);
        ListeJoueur.add(J2);
        jlb_J1_nom.setText(Joueur1);
        jlb_J2_nom.setText(Joueur2);
        if (nbJoueurs > 2) {
            String Joueur3 = NomJoueur3.getText();
            Joueur J3 = new Joueur(Joueur3);
            ListeJoueur.add(J3);
            jlb_J3_nom.setText(Joueur3);
            if (nbJoueurs == 4) {
                String Joueur4 = NomJoueur4.getText();
                Joueur J4 = new Joueur(Joueur4);
                ListeJoueur.add(J4);
                jlb_J4_nom.setText(Joueur4);
            }
        }
    }

    public Joueur DeterminationDuPremierJoueur(int nbJoueurs) {
        //détermination du 1er joueur :
        //pour une partie à 2 joueurs:
        if (nbJoueurs == 2) {
            int NombreAleatoire = 1 + (int) (Math.random() * ((2 - 1) + 1));
            if (NombreAleatoire == 1) {
                JoueurCourantPartie = ListeJoueur.get(0);
            } else {
                JoueurCourantPartie = ListeJoueur.get(1);
            }
        }
        // pour une partie à 3 joueurs:
        if (nbJoueurs == 3) {
            int NombreAleatoire = 1 + (int) (Math.random() * ((3 - 1) + 1));
            if (NombreAleatoire == 1) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
            if (NombreAleatoire == 2) {
                JoueurCourantPartie = ListeJoueur.get(1);
            }
            if (NombreAleatoire == 3) {
                JoueurCourantPartie = ListeJoueur.get(2);
            }
        }
        //pour une partie à 4 joueurs:
        if (nbJoueurs == 4) {
            int NombreAleatoire = 1 + (int) (Math.random() * ((4 - 1) + 1));
            if (NombreAleatoire == 1) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
            if (NombreAleatoire == 2) {
                JoueurCourantPartie = ListeJoueur.get(1);
            }
            if (NombreAleatoire == 3) {
                JoueurCourantPartie = ListeJoueur.get(2);
            }
            if (NombreAleatoire == 4) {
                JoueurCourantPartie = ListeJoueur.get(3);
            }
        }
        return JoueurCourantPartie;
    }

    public void DeterminationDesCouleurs(int nbJoueurs) {
        //Distribution des couleurs:
        //pour une partie à 2 joueurs:
        if (nbJoueurs == 2) {
            int CouleurAleatoire1 = 1 + (int) (Math.random() * ((2 - 1) + 1));
            if (CouleurAleatoire1 == 1) {
                ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
                jlb_J1_couleur.setForeground(new java.awt.Color(255, 51, 51));
                ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                jlb_J2_couleur.setForeground(new java.awt.Color(51, 102, 255));
            } else {
                ListeJoueur.get(1).AffecterCouleurAuJoueur("Rouge");
                jlb_J2_couleur.setForeground(new java.awt.Color(255, 51, 51));
                ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                jlb_J1_couleur.setForeground(new java.awt.Color(51, 102, 255));

            }
            jlb_J1_couleur.setText(ListeJoueur.get(0).CouleurJoueur);
            jlb_J2_couleur.setText(ListeJoueur.get(1).CouleurJoueur);
        }
        //pour une partie à 3 joueurs:
        if (nbJoueurs == 3) {
            int CouleurAleatoire1 = 1 + (int) (Math.random() * ((3 - 1) + 1));
            if (CouleurAleatoire1 == 1) {
                ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
                jlb_J1_couleur.setForeground(new java.awt.Color(255, 51, 51));
                int CouleurAleatoire2 = 1 + (int) (Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2 == 1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    jlb_J3_couleur.setForeground(new java.awt.Color(51, 102, 255));
                } else {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    jlb_J2_couleur.setForeground(new java.awt.Color(51, 102, 255));
                }
            }
            if (CouleurAleatoire1 == 2) {
                ListeJoueur.get(1).AffecterCouleurAuJoueur("Rouge");
                jlb_J2_couleur.setForeground(new java.awt.Color(255, 51, 51));
                int CouleurAleatoire2 = 1 + (int) (Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2 == 1) {
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    jlb_J1_couleur.setForeground(new java.awt.Color(51, 102, 255));
                } else {
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(2).AffecterCouleurAuJoueur("Bleue");
                    jlb_J3_couleur.setForeground(new java.awt.Color(51, 102, 255));
                }
            }
            if (CouleurAleatoire1 == 3) {
                ListeJoueur.get(2).AffecterCouleurAuJoueur("Rouge");
                jlb_J3_couleur.setForeground(new java.awt.Color(255, 51, 51));
                int CouleurAleatoire2 = 1 + (int) (Math.random() * ((2 - 1) + 1));
                if (CouleurAleatoire2 == 1) {
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Bleue");
                    jlb_J1_couleur.setForeground(new java.awt.Color(51, 102, 255));
                } else {
                    ListeJoueur.get(0).AffecterCouleurAuJoueur("Noire");
                    ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
                    jlb_J2_couleur.setForeground(new java.awt.Color(51, 102, 255));
                }
            }
            jlb_J1_couleur.setText(ListeJoueur.get(0).CouleurJoueur);
            jlb_J2_couleur.setText(ListeJoueur.get(1).CouleurJoueur);
            jlb_J3_couleur.setText(ListeJoueur.get(2).CouleurJoueur);
        }
        //pour une partie à 4 joueurs:
        if (nbJoueurs == 4) {
            ListeJoueur.get(0).AffecterCouleurAuJoueur("Rouge");
            jlb_J1_couleur.setForeground(new java.awt.Color(255, 51, 51));
            ListeJoueur.get(1).AffecterCouleurAuJoueur("Bleue");
            jlb_J2_couleur.setForeground(new java.awt.Color(51, 102, 255));
            ListeJoueur.get(2).AffecterCouleurAuJoueur("Noire");
            ListeJoueur.get(3).AffecterCouleurAuJoueur("Verte");
            jlb_J4_couleur.setForeground(new java.awt.Color(51, 153, 0));

            jlb_J1_couleur.setText(ListeJoueur.get(0).CouleurJoueur);
            jlb_J2_couleur.setText(ListeJoueur.get(1).CouleurJoueur);
            jlb_J3_couleur.setText(ListeJoueur.get(2).CouleurJoueur);
            jlb_J4_couleur.setText(ListeJoueur.get(3).CouleurJoueur);
     
    }
        }
    

    public void JoueurSuivant() {
        String NbDeJoueurs = (String) jComboBox1.getSelectedItem();
        if (NbDeJoueurs.equals("2 joueurs")) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            } else {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        if (NbDeJoueurs.equals("3 joueurs")) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            } else if (JoueurCourantPartie == ListeJoueur.get(1)) {
                JoueurCourantPartie = ListeJoueur.get(2);
            } else if (JoueurCourantPartie == ListeJoueur.get(2)) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        if (NbDeJoueurs.equals("4 joueurs")) {
            if (JoueurCourantPartie == ListeJoueur.get(0)) {
                JoueurCourantPartie = ListeJoueur.get(1);
            } else if (JoueurCourantPartie == ListeJoueur.get(1)) {
                JoueurCourantPartie = ListeJoueur.get(2);
            } else if (JoueurCourantPartie == ListeJoueur.get(2)) {
                JoueurCourantPartie = ListeJoueur.get(3);
            } else if (JoueurCourantPartie == ListeJoueur.get(3)) {
                JoueurCourantPartie = ListeJoueur.get(0);
            }
        }
        jlb_JoueurCourant.setText(JoueurCourantPartie.Nom);
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        DebutDePartie.setVisible(true);
        DebPartie.setVisible(false);
        String NbJoueurs = (String) jComboBox1.getSelectedItem();
        if (NbJoueurs.equals("2 joueurs")) {
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            NomJoueur3.setVisible(false);
            NomJoueur4.setVisible(false);
            jLabel14.setVisible(false);
            jLabel15.setVisible(false);
            jlb_J4_couleur.setVisible(false);
            jlb_J4_nom.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
            jlb_J3_couleur.setVisible(false);
            jlb_J3_nom.setVisible(false);
        }
        if (NbJoueurs.equals("3 joueurs")) {
            jLabel13.setVisible(false);
            NomJoueur4.setVisible(false);
            jlb_J4_couleur.setVisible(false);
            jlb_J4_nom.setVisible(false);
            jLabel16.setVisible(false);
            jLabel17.setVisible(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void NomJoueur3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomJoueur3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomJoueur3ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String url = "https://www.cwowd.com/wp-content/uploads/2017/02/R%C3%A8gles-Santorini-V2.pdf";

        Desktop dt = Desktop.getDesktop();
        URI uri;
        try {
            uri = new URI(url);
            dt.browse(uri.resolve(uri));
        } catch (IOException ex) {
            Logger.getLogger(FenetreDeJeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(FenetreDeJeu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void PlateauDeJeuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlateauDeJeuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PlateauDeJeuMouseClicked

    private void RestartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartButtonActionPerformed
        // TODO add your handling code here:
        restart();
    }//GEN-LAST:event_RestartButtonActionPerformed

    public void restart() {
        new FenetreDeJeu().setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreDeJeu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreDeJeu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DebPartie;
    private javax.swing.JPanel DebutDePartie;
    private javax.swing.JPanel FinDePartie;
    private javax.swing.JPanel InfoJoueurs;
    private javax.swing.JPanel InfoPartie;
    private javax.swing.JLabel JoueurGagnant;
    private javax.swing.JTextField NomJoueur1;
    private javax.swing.JTextField NomJoueur2;
    private javax.swing.JTextField NomJoueur3;
    private javax.swing.JTextField NomJoueur4;
    private javax.swing.JPanel PlateauDeJeu;
    private javax.swing.JButton RestartButton;
    private javax.swing.JButton btn_start;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jlb_J1_couleur;
    private javax.swing.JLabel jlb_J1_nom;
    private javax.swing.JLabel jlb_J2_couleur;
    private javax.swing.JLabel jlb_J2_nom;
    private javax.swing.JLabel jlb_J3_couleur;
    private javax.swing.JLabel jlb_J3_nom;
    private javax.swing.JLabel jlb_J4_couleur;
    private javax.swing.JLabel jlb_J4_nom;
    private javax.swing.JLabel jlb_JoueurCourant;
    private javax.swing.JTextArea message;
    // End of variables declaration//GEN-END:variables
}
