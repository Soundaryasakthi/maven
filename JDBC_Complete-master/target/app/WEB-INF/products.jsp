<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>

        <html lang="en">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Document</title>
        </head>

        <body>
            <div class="container table-responsive">
                <form method="post" action="show.jsp">
                    <br>
                    <center>
                        <h1>Table</h1>
                    </center>
                    <br>
                    <br>
                    <center>
                        <table  class="table table-striped table-bordered table-hover table-condensed">
                            <tr>
                                <td>
                                    <b>Id</b>
                                </td>
                                <td>
                                    <b>Name</b>
                                </td>
                                <td>
                                    <b>Description</b>
                                </td>
                                <td>
                                    <b>Quantity</b>
                                </td>
                                <td colspan="2">
                                    <center>
                                        <b>Actions</b>
                                    </center>
                                </td>
                            </tr>
                            <c:forEach items="${products}" var="p">
                                <tr  id="mytable" class="danger">
                                    <td id=${p.id}>${p.id}</td>
                                    <td>
                                        <c:out value="${p.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${p.description}" />
                                    </td>
                                    <td>
                                        <c:out value="${p.price}" />
                                    </td>
                                    <td>
                                        <a href='update?id=${p.id}'>update</a>
                                    </td>
                                    <td>
                                        <a href='delete?id=${p.id}'>delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </center>
                    <br>
                    <br>
                    <center>
                        <div class="input-group">
                            <i class="glyphicon glyphicon-plus"></i>
                            <input class="btn btn-default" type="submit" value="Insert" />
                        </div>

                    </center>
                </form>
            </div>
            <br>
            <br>


        </body>

        </html>