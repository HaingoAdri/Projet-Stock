package composant;

import java.util.Vector;

import connexion.Connexion;
import fonction.Fonction;

public class Magasin extends Fonction{
    String id_Magasin;
    String nom_Magasin;
    public String getId_Magasin() {
        return id_Magasin;
    }
    public void setId_Magasin(String id_Magasin) {
        this.id_Magasin = id_Magasin;
    }
    public String getNom_Magasin() {
        return nom_Magasin;
    }
    public void setNom_Magasin(String nom_Magasin) {
        this.nom_Magasin = nom_Magasin;
    }

    public Vector<Magasin> getMagasin()throws Exception{
        Connexion con = new Connexion("jdbc:postgresql://localhost:5432/stocks","haingo","haingo");
        String nom_De_Table = "Magasin";
        Magasin Magasin= new Magasin();
        Vector<Magasin> magasins = new Vector<Magasin>();
        Vector<Object> objet = this.getSelect2(con,nom_De_Table);
        for(int i=0; i<objet.size(); i++){
            magasins.add((Magasin)objet.get(i));
        }
       return magasins;
    }

    //maka nom de Magasin
    public Vector<String> getNomMagasin() throws Exception{
        Vector<String> nom_Emp = new Vector<String>();
        Vector<Magasin> comp = this.getMagasin();
        for(int i=0; i<comp.size();i++){
            nom_Emp.add(comp.get(i).getNom_Magasin());
        }
        return nom_Emp;
    }

    //Affichage de nom Magasin
    public void aseo_Nom()throws Exception{
        System.out.println("Nom de Magasin:");
        Vector<String> name = this.getNomMagasin();
        for(int i=0; i<name.size();i++){
            System.out.println("--------->>>"+name.get(i));
        }
    }
    
    
}
