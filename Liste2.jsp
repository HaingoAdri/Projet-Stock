<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="composant.*"%>
<%@page import="affichage.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.*,java.io.PrintWriter"%>

<%

    Repport repport = new Repport();
    String nom = "repport_M3";
    Vector<Repport> hafa = repport.getRepport1(nom);
%>


<!doctype html>
<html lang="en">


<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Liste stock Date</title>

    <link rel="canonical" href="index.html">



    <!-- Bootstrap core CSS -->
    <link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" >

        <!-- Favicons -->
    <link rel="apple-touch-icon" href="assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">


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


    <!-- Custom styles for this template -->
  </head>
  <body >
    <h1>Magasin 3</h1>
    <div class="container">
      <h1 style="text-align: center;"> Insertion de Date:</h1>
        
          <form class="needs-validation" action="Page3.jsp">
              <div class="row g-3">
                
                <div class="col-4">
                  <label for="username" class="form-label">Date_1</label>
                  <div class="input-group has-validation">
                    <input type="date" name="dates1" class="form-control" id="username" placeholder="Username" required>
                  </div>
                </div>
               
    
                  <button class=" w-100 btn btn-primary btn-lg" type="submit">Inserer</button>
              </div>
          </form>

          <h2>Liste des Repport en Magasin3</h2>

    <div class="table-responsive">
      <table class="table table-striped table-sm">
        <thead>
          <tr>
            <th scope="col">Date</th>
            <th scope="col">Produits</th>
            <th scope="col">Magasin</th>
            <th scope="col">Quantite</th>
            
          </tr>
        </thead>
        <tbody>
          <%for(int i=0;i<hafa.size();i++){%>
            <tr>
              <td><%out.println(hafa.get(i).getDate());%></td>
              <td><%out.println(hafa.get(i).getProduits());%></td>
              <td><%out.println(hafa.get(i).getMagasin());%></td>
              <td><%out.println(hafa.get(i).getQuantite());%></td>
             
            </tr>
           <%}%> 
        </tbody>
      </table>
    </div>

         
          <a href="Liste_Stock1.jsp">Retour</a>
 
    </main>
  </div>
</div>


    <script src="../../dist/js/bootstrap.bundle.min.js" ></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"></script><script src="dashboard.js"></script>
  </body>


</html>

