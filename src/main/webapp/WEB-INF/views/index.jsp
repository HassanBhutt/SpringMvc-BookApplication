<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Library</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
	
        <div class="jumbotron">
            <h1>Spring Library</h1>
        </div>		  
		
		<div class="btn-group">
            <a href="redirect:/" class="btn btn-primary">Home</a>
		    <a href="addBook" class="btn btn-primary">Add Book</a>
		    <a href="searchBook" class="btn btn-primary">Search Book</a>
		</div>
		
		<hr />

        <form class="form-inline" action="Delete">
            <label for="bookId" class="form-control mr-2">Book ID: </label>
            <input type="text" class="form-control mr-2" placeholder="Enter book id to delete a book" id="bookId" name="Id">
            <button type="submit" class="btn btn-primary">Delete</button>
        </form>
		
        <hr />

        <h3>Books: </h3>
		<table class="table table-striped table-hover">
		    <thead>
		      <tr>
		      	<th>ID</th>
		        <th>Title</th>
		        <th>Author</th>
		        <th>Category</th>
		      </tr>
		    </thead>
		    <tbody>	
		    	<c:forEach var="book" items="${books}">	    
		    	
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.categoryName}</td>
                </tr> 
                </c:forEach>
			</tbody>
		</table>	
		
	</div>
</body>
</html>