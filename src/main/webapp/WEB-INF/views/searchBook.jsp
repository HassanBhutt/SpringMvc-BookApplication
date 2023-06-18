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
            <a href="/FinalAssignment/" class="btn btn-primary">Home</a>
		    <a href="addBook" class="btn btn-primary">Add Book</a>
		    <a href="searchBook" class="btn btn-primary">Search Book</a>
		</div>

        <hr />
        
        <h3>Search Book: </h3>

        <div class="row">
            <div class="col-md-10 mx-auto">
                <form action="BookForSearch" method="post">
                    <div class="form-group row">
                        <div class="col-sm-6">
                            <label for="title">Title:</label>
                            <input type="text" class="form-control" placeholder="Enter book title" id="title" name = "title">
                        </div>
                        <div class="col-sm-6">
                            <label for="author">Author:</label>
                            <input type="text" class="form-control" placeholder="Enter book auhtor" id="author" name = "author">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="category">Category:<b><i>(All categories should be fetched from database from Categories table)</i></b></label>
                        <select class="form-control" id="catId" name="catId">
                         <c:forEach var="cat" items="${categories}">
                          <option value="${cat.id}">${cat.name}</option>
                          </c:forEach>
                        </select>
                    </div>
                    
                    <button type="submit" class="btn btn-primary px-4 float-right">Search</button>
                </form>
            </div>
        </div>
		
        <h3>Search Results: </h3>
		<table class="table table-striped table-hover">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Title</th>
		        <th>Author</th>
		        <th>Category</th>
		      </tr>
		    </thead>
		    <tbody>		    	
               <c:forEach var="b" items="${books}">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.title}</td>
                    <td>${b.author}</td>
                    <td>${b.categoryName}</td>
                </tr> 
                </c:forEach>
            
			</tbody>
		</table>	
		
	</div>
</body>
</html>