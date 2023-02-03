package composant;

import java.sql.Date;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import connexion.Connexion;
import fonction.Fonction;

public class Stock extends Fonction{

    int id_Stock;
    Date date_Stock;
    String nom_Produist;
    int entree;
    int sortie;
    int reste;
    double prix_Stock;
    String magasin;

    public String getMagasin(){return this.magasin;}
    public void setMagasin(String a){this.magasin=a;}

    public Stock() throws Exception{
        // super.setPrefix("Stk");
        super.setNomFonction("getSequenceSotck");
    }
    public Stock(int id_Stock, Date date_Stock, String nom_Produist, int entree, int sortie,
            int reste, double prix_Stock,String m) throws Exception{
        // super.setPrefix("Stk");
        super.setNomFonction("getSequenceSotck");
        this.setId_Stock(id_Stock);
        this.setDate_Stock(date_Stock);
        this.setNom_Produist(nom_Produist);
        this.setEntree(entree);
        this.setSortie(sortie);
        this.setReste(reste);
        this.setPrix_Stock(prix_Stock);
        this.setMagasin(m);
        
    }
    public int getId_Stock() {
        return id_Stock;
    }
    public void setId_Stock(int id_Stock) {
        this.id_Stock = id_Stock;
    }
    public Date getDate_Stock() {
        return date_Stock;
    }
    public void setDate_Stock(Date date_Stock) {
        this.date_Stock = date_Stock;
    }
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
    public double getPrix_Stock() {
        return prix_Stock;
    }
    public void setPrix_Stock(double prix_Stock) {
        this.prix_Stock = prix_Stock;
    }
    public Vector<Stock> getStock()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        String nom_De_Table = "Stocks";
        Stock stock= new Stock();
        Vector<Stock> stocks = new Vector<Stock>();
        Vector<Object> objet = this.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size(); i++){
            stocks.add((Stock)objet.get(i));
        }
       return stocks;
    }

    //maka nom produits et composant

    public String nom_Produits(String id)throws Exception{
        String a = null;
        Produit p = new Produit();
        if(p.getIdProduits()== id){
            a = p.getNomProduits();
        }
        return a;
    }

  
   
}