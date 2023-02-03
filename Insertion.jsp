<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="composant.*"%>
<%@page import="affichage.*"%>
<%@page import="java.util.*"%>

<%

Produit produit = new Produit();
Vector<Produit> list_Produit =  produit.getProduit();
Magasin mag = new Magasin();
Vector<Magasin> m1 = mag.getMagasin();
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="apple-touch-icon" href="assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="assets/img/favicons/favicon.ico">
    <title>Insertion de Stock Simple</title>
</head>
<style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }
  </style>

<body>
    <div class="container">
        <h1 style="text-align: center;"> Insertion de Stocks:</h1>
          
            <form class="needs-validation" action="Ok.jsp">
                <div class="row g-3">
                  
                  <div class="col-12">
                    <label for="username" class="form-label">Date</label>
                    <div class="input-group has-validation">
                      <input type="date" name="dates" class="form-control" id="username" placeholder="Username" required>
                    </div>
                  </div>
      
                  <div class="col-12">
                    <label for="email" class="form-label">Nom_Produits</label>
                    <select name="nom_Produits" class="form-control">
                        <option value="0">null</option>
                        <%for(int i=0; i<list_Produit.size();i++){%> 
                            <option value="<%out.print(list_Produit.get(i).getIdProduits());%>"><%out.println(list_Produit.get(i).getNomProduits());%></option>
                        <%}%>
                        
                    </select>
                  </div>
      
                  <div class="col-12">
                    <label for="address2" class="form-label">Nombre d'entrer Quantite</label>
                    <input type="number" name="entrer" class="form-control" id="address2" placeholder="quantite">
                  </div>
      
                  <div class="col-12">
                    <label for="address2" class="form-label">Nombre de sortie Quantite</label>
                    <input type="number" name="sortie" class="form-control" id="address2" placeholder="quantite">
                  </div>
      
                  <div class="col-12">
                    <label for="address2" class="form-label">Prix</label>
                    <input type="number" name="prix" class="form-control" id="address2" placeholder="Prix">
                  </div>
                  <div class="col-12">
                    <label for="address" class="form-label">Magasin</label>
                    <select name="magasin" class="form-control">
                        <option value="0">null</option>
                       <%for(int i=0; i<m1.size();i++){%> 
                        <option value="<%out.print(m1.get(i).getId_Magasin());%>"><%out.println(m1.get(i).getNom_Magasin());%></option>
                        <%}%>
                    </select>
                  </div>
      
                    <button class="w-100 btn btn-primary btn-lg" type="submit">Inserer</button>
                </div>
            </form>
            <a href="Index.jsp">Retour</a>
    </div>
</body>
</html>