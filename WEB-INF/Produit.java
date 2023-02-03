package composant;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Produit extends Fonction{

    String idProduits;
    String nomProduits;
    double prix;

    //constructeur
    public Produit() {
    }
    public Produit(String nomProduits) {
        this.setNomProduits(nomProduits);
    }

    //getter setter
    public String getIdProduits() {
        return idProduits;
    }
    public void setIdProduits(String idProduits) {
        this.idProduits = idProduits;
    }
    public String getNomProduits() {
        return nomProduits;
    }
    public void setNomProduits(String nomProduits) {
        this.nomProduits = nomProduits;
    }
    
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public Vector<Produit> getProduit()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        String nom_De_Table = "Produits";
        Produit produits= new Produit();
        Vector<Produit> produit = new Vector<Produit>();
        Vector<Object> objet = this.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size(); i++){
            produit.add((Produit)objet.get(i));
        }
       return produit;
    }

    //maka nom de Produit
    public Vector<String> getNomProduit() throws Exception{
        Vector<String> nom_Emp = new Vector<String>();
        Vector<Produit> comp = this.getProduit();
        for(int i=0; i<comp.size();i++){
            nom_Emp.add(comp.get(i).getNomProduits());
        }
        return nom_Emp;
    }

    //Affichage de nom Produit
    public void aseo_Nom()throws Exception{
        System.out.println("Nom de Produit:");
        Vector<String> name = this.getNomProduit();
        for(int i=0; i<name.size();i++){
            System.out.println("--------->>>"+name.get(i));
        }
    }
    
    //maka prix de Produit
    public Vector<Double> getPrix_Comp()throws Exception{
        Vector<Double> prix_Produits = new Vector<Double>();
        Vector<Produit> comp = this.getProduit();
        for(int i=0;i<comp.size();i++){
            prix_Produits.add(comp.get(i).getPrix());
        }
        return prix_Produits;
    }

    //Affichage de prix Produit
    public void aseo_Prix()throws Exception{
        System.out.println("Prix Produit:");
        Vector<Double> prix_s=this.getPrix_Comp();
        for(int i=0;i<prix_s.size();i++){
            System.out.println("--------->>>"+prix_s.get(i));
        }
    }

}
