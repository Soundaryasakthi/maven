<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>AJAX JsonArray Example</title>
    <link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
    <style type="text/css">
        table,
        td,
        th {
            border: 1px solid rgb(2, 8, 98);
            font-family: 'Oxygen', sans-serif;
        }

        th {
            background-color: rgb(0, 3, 179);
            color: white;
        }

        body {
            text-align: center;
        }

        .container {
            margin-left: auto;
            margin-right: auto;
            width: 40em;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#tablediv").hide();
            $("#showTable").click(function (event) {
                $.get('PopulateTable', function (responseJson) {
                    if (responseJson != null) {
                     $("#countrytable").find("tr:gt(0)").remove();
                        var table1 = $("#countrytable");
                        $.each(responseJson, function (key, value) {
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['code']);
                            rowNew.children().eq(1).text(value['name']);
                            rowNew.children().eq(2).text(value['continent']);
                            rowNew.children().eq(3).text(value['region']);
                            rowNew.children().eq(4).text(value['population']);
                            rowNew.children().eq(5).text(value['capital']);
                            rowNew.children().eq(6).append('<a href="/update?code='+value['code']+'">edit</a>');
rowNew.children().eq(7).append('<a href="/delete?code='+value['code']+'">delete</a>');
                           // <a href="PopulateTable.java">Delete</a>
                           //rowNew.children().eq(6).text();
                           rowNew.appendTo(table1);
                        
            });
                    }
                });
                //window.location = $(this).attr('href');
               // return false;
                $("#tablediv").show();
            });
        });
    </script>
</head>

<body class="container">
    <h1>AJAX Retrieve Data from Database in Servlet and JSP using JSONArray</h1>
    <input type="button" value="Show Table" id="showTable" />
    <a href="addCountry.jsp">Add User</a>
    <div id="tablediv">
        <table cellspacing="0" id="countrytable">
        
            <tr>
            
                <th scope="col">Code</th>
            
                <th scope="col">Name</th>
            
                <th scope="col">Continent</th>
            
                <th scope="col">Region</th>

                <th scope="col">Population</th>

                <th scope="col">Capital</th>

                <th scope="col">Delete</th>

                <th scope="col">Update</th>
           <!--  <input type="button" value="Delete" id="Deleterow" />    
             <input type="button" value="Update" id="updaterow" />-->
            </tr>
        </table>
    </div>
</body>

</html>