<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Pessoa" import="java.util.List"%>
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

<title>Ponto de Partida | Cadastro de Usuário</title>

</head>
<body>
	<main>
		<header class="header">
			<h1 class="text-center" style="background-color:#126e51; color:#ffdf1b">Ponto De Partida - Usuário</h1>
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
			<form action="./edit-pessoa">
				<h2 class="text-center">Atualizar Usuario</h2>

				<div class="form-group mb-3">
					<label for="idPessoa" class="form-label"> ID Usuario </label> <input
						type="number" id="idPessoa" name="idPessoa"
						class="form-control"
						value="<%=request.getAttribute("idPessoa")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="cpf" class="form-label"> CPF </label> <input
						type="text" id="cpf" name="cpf" class="form-control"
						value="<%=request.getAttribute("cpf")%>" />
				</div>				

				<div class="form-group mb-3">
					<label for="nome" class="form-label"> Nome </label> <input
						type="text" id="nome" name="nome" class="form-control"
						value="<%=request.getAttribute("nome")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="dataNascimento" class="form-label"> Data de Nascimento </label> <input
						type="text" id="dataNascimento" name="dataNascimento" class="form-control"
						value="<%=request.getAttribute("dataNascimento")%>" />
				</div>
				
				<div class="form-group mb-3">
					<label for="sexo" class="form-label"> Sexo </label> <input
						type="text" id="sexo" name="sexo" class="form-control"
						value="<%=request.getAttribute("sexo")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="email" class="form-label"> Email </label> <input
						type="email" id="email" name="email" class="form-control"
						value="<%=request.getAttribute("email")%>" />
				</div>

				<div class="form-group mb-3">
					<label for="telefone" class="form-label"> Telefone </label> <input
						type="text" id="telefone" name="telefone" class="form-control"
						value="<%=request.getAttribute("telefone")%>" />
				</div>
				
				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="../../pessoa" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

	</main>

	<footer class="fixed-bottom" id="recodeP">
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