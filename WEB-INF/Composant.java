package composant;

import java.util.Vector;

import connexion.Connexion;

import java.sql.Connection;
import java.util.*;

import fonction.Fonction;

public class Composant extends Fonction{

    String idComp;
    String nomComp;
    double prix;

    //constructeur
    public Composant(String nomComp) {
        this.setNomComp(nomComp);
    }

    public Composant() {
    }
    
    //getter setter
    public String getIdComp() {
        return idComp;
    }
    public void setIdComp(String idComp) {
        this.idComp = idComp;
    }
    public String getNomComp() {
        return nomComp;
    }
    public void setNomComp(String nomComp) {
        this.nomComp = nomComp;
    }
    
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }

    //maka composant
    public Vector<Composant> getComposant()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        String nom_De_Table = "Composant";
        Composant composant= new Composant();
        Vector<Composant> composants = new Vector<Composant>();
        Vector<Object> objet = composant.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size(); i++){
            composants.add((Composant)objet.get(i));
        }
       return composants;
    }

    //maka nom de composant
    public Vector<String> getNomComposant() throws Exception{
        Vector<String> nom_Emp = new Vector<String>();
        Vector<Composant> comp = this.getComposant();
        for(int i=0; i<comp.size();i++){
            nom_Emp.add(comp.get(i).getNomComp());
        }
        return nom_Emp;
    }

    
    //Affichage de nom composant
    public void aseo_Nom()throws Exception{
        System.out.println("Nom de Composant:");
        Vector<String> name = this.getNomComposant();
        for(int i=0; i<name.size();i++){
            System.out.println("--------->>>"+name.get(i));
        }
    }
    
    //maka prix de composant
    public Vector<Double> getPrix_Comp()throws Exception{
        Vector<Double> prix_Produits = new Vector<Double>();
        Vector<Composant> comp = this.getComposant();
        for(int i=0;i<comp.size();i++){
            prix_Produits.add(comp.get(i).getPrix());
        }
        return prix_Produits;
    }

    //Affichage de prix composant
    public void aseo_Prix()throws Exception{
        System.out.println("Prix Composant:");
        Vector<Double> prix_s=this.getPrix_Comp();
        for(int i=0;i<prix_s.size();i++){
            System.out.println("--------->>>"+prix_s.get(i));
        }
    }

}