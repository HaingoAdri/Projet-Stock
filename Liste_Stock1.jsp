<!-- import de toutes les classe -->
<%@page import="connexion.*"%>
<%@page import="fonction.*"%>
<%@page import="composant.*"%>
<%@page import="affichage.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.*,java.io.PrintWriter"%>

<%
    Magasin mag = new Magasin();
    Vector<Magasin> m1 = mag.getMagasin();
    Insertion_Etat stock_Hafa = new Insertion_Etat();
    Vector<Insertion_Etat> hafa = stock_Hafa.getInsertion_Etat();
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
    <title>Liste stock sans Date</title>

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
   
      <a href="m1.jsp"><%out.println(m1.get(0).getNom_Magasin());%><br></a>
      <a href="m2.jsp"><%out.println(m1.get(1).getNom_Magasin());%><br></a>
     
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">Nom_Produits</th>
              <th scope="col">Entrer</th>
              <th scope="col">Sortie</th>
              <th scope="col">Reste</th>
              <!-- <th scope="col">Prix</th> -->
              <th scope="col">Magasin</th>
            </tr>
          </thead>
          <tbody>
          <%for(int i=0;i<hafa.size();i++){%>
            <tr>
              <td><%out.println(hafa.get(i).getNom_Produist());%></td>
              <td><%out.println(hafa.get(i).getEntree());%></td>
              <td><%out.println(hafa.get(i).getSortie());%></td>
              <td><%out.println(hafa.get(i).getReste());%></td>
              <!-- <td><%out.println(hafa.get(i).getPrix());%></td> -->
              <td><%out.println(hafa.get(i).getMagasin());%></td>
            </tr>
           <%}%> 
          </tbody>
        </table>
      </div>

    <a href="Index.jsp">Retour</a>
    </main>
  </div>
</div>


    <script src="../../dist/js/bootstrap.bundle.min.js" ></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"></script><script src="dashboard.js"></script>
  </body>


</html>

