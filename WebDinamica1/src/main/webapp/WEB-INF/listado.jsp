<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
crossorigin="anonymous">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>Bootcamp Database</title>
</head>
<body>

	<h1 class="text-center">Bienvenido(a) a búsqueda de estudiantes Bootcamp!</h1>
	<br>
	

<div class="container">
	<div class="row">
	<form action="/" method="post">
		<div class="row">
		<div class="row" style="text-align:left;"><p class="col-4">Región</p><p class="col-2">Curso</p></div>
		<select name="region" class="form-control col">
			<option selected value=0>Elija una Region</option>
			
			<c:forEach items="${allRegiones}" var="region">
				<option value="${region.getCodigoRegion() }"><c:out value="${region.getNombreRegion() }"></c:out></option>
			</c:forEach>
		
		</select>
		<select name="curso" class="form-control col">
			<option selected value=0>Elija un Curso</option>
			
			<c:forEach items="${allPlanesFormativos}" var="planFormativo">
				<option value="${planFormativo.getCodigoPlanFormativo() }"><c:out value="${planFormativo.getDescripcionPlanDFormativo() }"></c:out></option>
			</c:forEach>
		</select>
		<button type="submit" class="btn btn-primary col">Filtrar</button>
		</div>
	</form>
	</div>
	</div>
	<br>
	<br>

<div class="row justify-content-center">
    <div class="col-auto">
	<table class="table table-primary table-striped">
		<thead>
			<tr>
				<th scope="col">Rut</th>
				<th scope="col">Nombre</th>
				<th scope="col">Apellido Paterno</th>
				<th scope="col">Apellido Materno</th>
				<th scope="col">Codigo Curso</th>
				<th scope="col">Descripcion Curso</th>
			</tr>
		</thead>
		
		<tbody>
		
		
		<c:forEach items="${estudiantesFiltrados }" var="estudiante">
				<tr>
					<td scope="row"><c:out value="${estudiante.getRut() }"></c:out></td>
					<td><c:out value="${estudiante.getNombreEstudiante() }"></c:out></td>
					<td><c:out value="${estudiante.getApellidoPaterno() }"></c:out></td>
					<td><c:out value="${estudiante.getApellidoMaterno() }"></c:out></td>
					<td><c:out value="${estudiante.getCodigoCurso() }"></c:out></td>
					<td><c:out value="${estudiante.getCurso().getPlanFormativo().getDescripcionPlanDFormativo() }"></c:out></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>

</body>
</html>