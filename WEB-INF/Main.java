package affichage;

import connexion.Connexion;
import fonction.Fonction;
import composant.   Magasin;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

import composant.Composant;
import composant.Insertion_Etat;
import composant.Produit;
import composant.Repport;


public class Main {
    public static void main(String[] args) throws Exception{
        
        // Insertion_Etat e = new Insertion_Etat();
        // String nom = "magasin2";
        // String d1="2023-01-10";
        // String d2="2023-01-30";
        // Vector<Insertion_Etat> dd = e.getListe2(d1,d2,nom);
        // for(int i=0 ;i<dd.size(); i++){
        //     System.out.println(dd.size());
        // }

       Repport re = new Repport();
       String nom = "repport_m1";
       Vector<Repport> rep = re.getRepport1(nom);
       for(int i=0; i<rep.size(); i++){
           System.out.println(rep.get(i).getDate());
           
       }
       String nom2 = "magasin1";
           
          Date dates = rep.get(1).getDate();
           String dates2 = "2023-01-30";
           Insertion_Etat e = new Insertion_Etat();
           Vector<Insertion_Etat> insert = e.getOptimiser(dates,dates2,nom2);
           for(int i=0; i<insert.size(); i++){
                System.out.println(insert.size());
            }
           
    }
}
