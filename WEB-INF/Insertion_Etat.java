package composant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;

import javax.print.DocFlavor.INPUT_STREAM;

import connexion.Connexion;
import fonction.Fonction;

public class Insertion_Etat extends Fonction{

    Date dates;
    String nom_Produist;
    int entree;
    int sortie;
    int reste;
    double prix;
    String magasin;

    //constructeur
    public Insertion_Etat(Date dates, String nom_Produist,  int entree, int sortie, int reste,double pri, String magasin) {
       
        this.setDates(dates);
        this.setNom_Produist(nom_Produist);
        this.setEntree(entree);
        this.setSortie(sortie);
        this.setReste(reste);
        this.setPrix(pri);
        this.setMagasin(magasin);
    }
    public Insertion_Etat() throws Exception{
        
    }
 
    

    //getter setter
    public String getNom_Produist() {
        return nom_Produist;
    }
    public void setNom_Produist(String nom_Produist) {
        this.nom_Produist = nom_Produist;
    }
   
    public int getEntree() {
        return entree;
    }
    public void setEntree(int entree) {
        this.entree = entree;
    }
    public int getSortie() {
        return sortie;
    }
    public void setSortie(int sortie) {
        this.sortie = sortie;
    }
    public int getReste() {
        return this.entree-this.sortie;
    }
    public void setReste(int reste) {
        this.reste = reste;
    }
    public double getPrix() {
            return prix;
        }
    public void setPrix(double prix) {
            this.prix = prix;
        }
      
    public String getMagasin() {
        return magasin;
    }
    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }
    public Date getDates() {
        return dates;
    }
    public void setDates(Date dates) {
        this.dates = dates;
    }


//maka views
    
    public Vector<Insertion_Etat> getInsertion_Etat()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        Insertion_Etat insertion_Etat= new Insertion_Etat();
        Vector<Insertion_Etat> insertion_Etats = new Vector<Insertion_Etat>();
        Vector<Object> objet = this.getSelect2(con,"stock_dates");
        for(int i=0; i<objet.size(); i++){
            insertion_Etats.add((Insertion_Etat)objet.get(i));
        }
       return insertion_Etats;
    }
    public Vector<Insertion_Etat> getInsertion_Etat1(String nom)throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        Insertion_Etat insertion_Etat= new Insertion_Etat();
        Vector<Insertion_Etat> insertion_Etats = new Vector<Insertion_Etat>();
        Vector<Object> objet = this.getSelect2(con,nom);
        for(int i=0; i<objet.size(); i++){
            insertion_Etats.add((Insertion_Etat)objet.get(i));
        }
       return insertion_Etats;
    }

    //select avec where

    public Vector<Insertion_Etat> getListe2(String d1, String d2,String nom)throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        Date date1=Date.valueOf(d1);
        Date date2=Date.valueOf(d2);
        String query = "select * from "+nom+" where dates_s>='"+date1+"' and dates_s<='"+date2+"'";
        Vector<Insertion_Etat> nouveau = new Vector<Insertion_Etat>();
        Connection c = con.getConnexion();
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()){
            Date a = rs.getDate("dates_S");
            String b = rs.getString("produits");
            int l = rs.getInt("entrer");
            int d = rs.getInt("sortie");
            int e = rs.getInt("restes");
            double f = rs.getDouble("prix");
            String g = rs.getString("magasin");

            Insertion_Etat aa = new Insertion_Etat(a,b,l,d,e,f,g);
           nouveau.add(aa);
        }
        return nouveau;
    }
    public Vector<Insertion_Etat> getOptimiser(Date d1, String d2,String nom)throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        Date date2=Date.valueOf(d2);
        String query = "select * from "+nom+" where dates_s>='"+d1+"' and dates_s<='"+date2+"'";
        Vector<Insertion_Etat> nouveau = new Vector<Insertion_Etat>();
        Connection c = con.getConnexion();
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()){
            Date a = rs.getDate("dates_s");
            String b = rs.getString("produits");
            int l = rs.getInt("entrer");
            int d = rs.getInt("sortie");
            int e = rs.getInt("restes");
            double f = rs.getDouble("prix");
            String g = rs.getString("magasin");

            Insertion_Etat aa = new Insertion_Etat(a,b,l,d,e,f,g);
           nouveau.add(aa);
           
        }
        System.out.println(query);
        return nouveau;
    }
}