/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package icroack.icroackadventures.controler;

import icroack.icroackadventures.model.DAOQuizz;
import icroack.icroackadventures.model.Question;
import icroack.icroackadventures.view.ViewQuizzII;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FroggyTeam
 * Débruillez-vous avec ce code, j'y comprends rien du tout, donc...
 * les commentaires seront APPROXIMATIFS.
 * Cordialement 
 * Pierre
 * 
 */
public class ControlerQuizz extends Thread{
    public static int qIngameScore;
    // Création d'un attribut privé et statique de la classe DAOQuizz
    private static DAOQuizz daoQuizz;
    // Création d'une ArrayList contenant les questions 
    private static ArrayList tab_question; 
    
    // Instance de la classe DAOQuizz;
    static {
        try {
            daoQuizz = new DAOQuizz(); // LOG BDD
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /* Remplissage de l'ArrayList tab_question grace à la 
     * méthode listerDAO(); 
     */
    static {
        try {
            tab_question = daoQuizz.listerDAO();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public ViewQuizzII vuequizz ;//= new ViewQuizzII(this); //LA VUE QCM
    public Countdown countdown ;//= new Countdown(this,vuequizz); // THREAD DECOMPTE

    public static int scoreQuizz = 0;
    public int cpt = 0; // Compteur
    
    
    /******************** PROCEDURE THREAD QCM **************************/
    public void run(){
        this.qIngameScore = qIngameScore;
        try {
            this.vuequizz = new ViewQuizzII(this);
        } catch (IOException ex) {
            Logger.getLogger(ControlerQuizz.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.countdown = new Countdown(this,vuequizz);
       vuequizz.labQuizzClose.setVisible(false);

        /******************** LANCEMENT DU JEU ( AFFICHAGE DES QUESTIONS) **************************/
        while(cpt <= tab_question.size()-1){ // FERME LE QCM QUAND LES 5 QUESTIONS ON ETE REPONDU
            if(cpt > 4){
                // Si le cpt est supérieur à 4 alors : 
                /*
                 * On désactive la possibilité de clicker sur les boutons de la vue (vrai/faux)
                 * On rend visible le bouton de fermeture de la vue
                 * On arrête le thread du QCM
                 */
                vuequizz.btn_true.setEnabled(false); 
                vuequizz.btn_false.setEnabled(false);
                vuequizz.labQuizzClose.setVisible(true);
                countdown.stop();
                this.stop();

            }else{
                /*
                 * On récupére la question à l'index de cpt 
                 * On affiche la question dans la vue du QCM
                 */
                Question objet = (Question) tab_question.get(cpt);
                vuequizz.getTxtQuestion().setText(objet.getQuestion()); // AFFICHAGE QUESTION DANS LA FRAME
                vuequizz.revalidate();
                vuequizz.repaint();
                vuequizz.setVisible(true);
            }
        }
        /******************** LANCEMENT DU JEU ( AFFICHAGE DES QUESTIONS) **************************/

        // RENVOIE VERS UNE VUE
        this.stop();    
    }

    /******************** PROCEDURE THREAD QCM **************************/



    /******************** RECUPERE LA REPONSE DE LA QUESTION **************************/

    public static int get_question_answer(ControlerQuizz cq) throws SQLException, ClassNotFoundException {
        ArrayList question = tab_question; // listerDAO retourne un tableau d'objet de QUESTION= daoQuizz.listerDAO();
        Question objet = (Question) question.get(cq.cpt); // JE RECUPERE UN OBJET A CHAQUE TOUR DE BOUCLE
        return objet.getAnwers();
    }

    /******************** RECUPERE LA REPONSE DE LA QUESTION **************************/

    /******************** VERIFICATION DE LA REPONSE  **************************/

    public void verify_answers(int a) throws SQLException, ClassNotFoundException {

        if(a == get_question_answer(this)){ 
            // SI LA REPONSE EST CORRECT ALORS +100 point
            this.qIngameScore = this.qIngameScore + 100 ;
            cpt ++; // COMPTEUR POUR PASSER A LA QUESTION SUIVANTE
           countdown.reset(); // RESET DECOMPTE

            // JE RAPPEL LA METHODE GAME() POUR POSER LA QUESTIONS SUIVANTE
        }else{ // SINON PAS DE POINT
            cpt ++;
            countdown.reset();

        }
    }

    public static int getqIngameScore() {return qIngameScore;}

    public void setqIngameScore(int qIngameScore) {this.qIngameScore = qIngameScore;}

    
}
