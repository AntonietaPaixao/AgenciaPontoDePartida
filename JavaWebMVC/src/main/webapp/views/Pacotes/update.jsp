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

<title>Ponto de Partida | Cadastro de Pacotes</title>

</head>
<body>
	<main>
		<header class="header">
			<h1 class="text-center" style="background-color:#126e51; color:#ffdf1b">Ponto De Partida - Pacotes</h1>
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
				<h2 class="text-center">Atualizar Pacotes</h2>

				<div class="form-group mb-3">
					<label for="idPacotePartida" class="form-label"> ID Pacote </label> <input
						type="number" id="idPacotePartida" name="idPacotePartida"
						class="form-control"
						value="<%=request.getAttribute("idPacotePartida")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="nomePacote" class="form-label"> Nome do Pacote </label> <input
						type="text" id="nomePacote" name="nomePacote" class="form-control"
						value="<%=request.getAttribute("nomePacote")%>" />
				</div>				

				<div class="form-group mb-3">
					<label for="dataSaida" class="form-label"> Data de Saida </label> <input
						type="text" id="dataSaida" name="dataSaida" class="form-control"
						value="<%=request.getAttribute("dataSaida")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="dataRetorno" class="form-label"> Data de Retorno </label> <input
						type="text" id="dataRetorno" name="dataRetorno" class="form-control"
						value="<%=request.getAttribute("dataRetorno")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="valorPacote" class="form-label"> Valor do Pacote </label> <input
						type="text" id="valorPacote" name="valorPacote" class="form-control"
						value="<%=request.getAttribute("valorPacote")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="partida" class="form-label"> Partida(Jogo) </label> <input
						type="text" id="partida" name="partida" class="form-control"
						value="<%=request.getAttribute("partida")%>" />
				</div>
				
				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="../../pacotePartida" class="btn btn-danger"
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