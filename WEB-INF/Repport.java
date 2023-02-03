package composant;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Repport extends Fonction{
    Date date;
    String produits;
    String magasin;
    int quantite;
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getProduits() {
        return produits;
    }
    public void setProduits(String produits) {
        this.produits = produits;
    }
    public String getMagasin() {
        return magasin;
    }
    public void setMagasin(String magasin) {
        this.magasin = magasin;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Vector<Repport> getRepport1(String nom)throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        Repport repport= new Repport();
        Vector<Repport> repports = new Vector<Repport>();
        Vector<Object> objet = this.getSelect2(con,nom);
        for(int i=0; i<objet.size(); i++){
            repports.add((Repport)objet.get(i));
        }
       return repports;
    }

    // public Vector<Insertion_Etat> getOptimiser(Date d1, String d2,String nom)throws Exception{
    //     Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
    //     Date date2=Date.valueOf(d2);
    //     String query = "select * from "+nom+" where dates_s>='"+d1+"' and dates_s<='"+date2+"'";
    //     Vector<Insertion_Etat> nouveau = new Vector<Insertion_Etat>();
    //     Connection c = con.getConnexion();
    //     Statement s = c.createStatement();
    //     ResultSet rs = s.executeQuery(query);
    //     while(rs.next()){
    //         Date a = rs.getDate("dates_s");
    //         String b = rs.getString("produits");
    //         int l = rs.getInt("entrer");
    //         int d = rs.getInt("sortie");
    //         int e = rs.getInt("restes");
    //         double f = rs.getDouble("prix");
    //         String g = rs.getString("magasin");

    //         Insertion_Etat aa = new Insertion_Etat(a,b,l,d,e,f,g);
    //        nouveau.add(aa);
           
    //     }
    //     System.out.println(query);
    //     return nouveau;
    // }
    
}
