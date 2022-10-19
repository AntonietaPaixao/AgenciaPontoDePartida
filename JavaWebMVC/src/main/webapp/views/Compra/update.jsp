<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.PacotePartida" import="java.util.List"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./assets/css/estilos.css" />

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">

<title>Ponto de Partida | Compra</title>

</head>
<body>
	<main>
		<header class="header">
			<h1 class="text-center" style="background-color:#126e51; color:#ffdf1b">Ponto De Partida - Compra</h1>
		</header>

		<ul class="nav justify-content-center mb-5">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="./index.html">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./Pacotes">Pacotes</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./Compra">Compra</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./pessoa">Cadastro de usuário</a></li>
		</ul>


		<div class="container py-3">
			<form action="./edit-pacotePartida">
				<h2 class="text-center">Atualizar Compra</h2>

				<div class="form-group mb-3">
					<label for="idcompra" class="form-label"> ID Compra </label> <input
						type="number" id="idCompra" name="idCompra"
						class="form-control"
						value="<%=request.getAttribute("idCompra")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="valorCompra" class="form-label">Valor da Compra</label> <input
						type="text" id="valorCompra" name="valorCompra" class="form-control"
						value="<%=request.getAttribute("valorCompra")%>" />
				</div>				

				<div class="form-group mb-3">
					<label for="dataCompra" class="form-label"> Data da Compra</label> <input
						type="text" id="dataCompra" name="dataCompra" class="form-control"
						value="<%=request.getAttribute("dataCompra")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="quantidadePacotes" class="form-label"> Quantidade Pacotes </label> <input
						type="text" id="quantidadePacotes" name="quantidadePacotes" class="form-control"
						value="<%=request.getAttribute("quantidadePacotes")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="pessoa" class="form-label"> Cliente </label> <input
						type="text" id="pessoa" name="pessoa" class="form-control"
						value="<%=request.getAttribute("pessoa")%>" />
				</div>

							
				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="../../compra" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

	</main>

	<footer class="fixed-bottom">
		<div class="container">
			<P>Ponto de Partida - Todos os direitos reservados</p>
		</div>
	</footer>

	<script src="script.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>