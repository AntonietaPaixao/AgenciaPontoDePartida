<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!-- mUDAR PARA utf-8 -->

<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Agencia Ponto de Partida</title>
<!-- link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"-->

<!--Fontes Google-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
	rel="stylesheet">

<!-- CSS e Icones Bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<!--CSS Pesronalizado-->
<link rel="stylesheet" href="../../css/estilos.css">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous">
	
</script>

</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg fixed-top bg-primary-color"
			id="navbar">
			<div class="container py-1">
				<a class="navbar-brand" href="#"> <img
					src="../../img/icone-PontoPartida.png" alt="Home" /> <span
					class="quaternary-color">Ponto de Partida</span>
				</a>
				<!--BotÃ£o responsivo de menu-->
				<button class="navbar-toggler bg-secondary-color" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbar-items"
					aria-controls="navbar-items" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="bi bi-list"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbar-items">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0" id="navbar-li">
						<li class="nav-item"><a class="nav-link" href="../../index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="../../pacotes.jsp">Pacotes</a></li>
						<li class="nav-item"><a class="nav-link" href="../../promocoes.jsp">Promoções</a></li>
						<li class="nav-item"><a class="nav-link" href="../../contato.jsp">Contato</a></li>
						<li class="nav-item"><a class="nav-link" href="../../login.jsp">Login</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="admPartidas.jsp">Admin</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<main class="container" id="slider">

		<!--Cabeçalho Interno-->
		<h2 class="text-center">Administração</h2>
		<ul class="nav justify-content-center mb-5">
			<li class="nav-item"><a class="nav-link active" aria-current="page" href="../Partida/indexPartida.html">Partidas</a></li>
			<li class="nav-item"><a class="nav-link" href="../Pacote/indexPacote.html">Pacotes</a></li>
			<li class="nav-item"><a class="nav-link" href="../Permissao/indexPermissao.html">Permissões</a></li>
			<li class="nav-item"><a class="nav-link" href="../Pessoa/indexPessoa.html">Usuários</a></li>		
		</ul>

		<!--FORMULÁRIOS-->
		<section class="container py-3 bg-secondary-color my-5">
			<form action="../../create-Permissao">

				<h4 class="text-center">Nova Permissão</h4>

				<div class="form-group mb-3">
					<label for="tipoPermissao" class="form-label"> Tipo de
						Permissão </label> <input type="text" id="tipoPermissao"
						name="tipoPermissao" class="form-control" />
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="./createPermissao.jsp" class="btn btn-danger" style="margin-left: 10px">
					Cancelar </a>
			</form>
		</section>

	</main>


	<!-- FOOTER -->
	<footer class="container-fluid bg-primary-color" id="footer">
		<div class="container">
			<div class="row">
				<!-- FOOTER TOP -->
				<div class="col-12" id="footer-top">
					<div class="row justify-content-between">
						<div class="col-4">
							<h2>Ponto de Partida</h2>
						</div>
						<div class="col-4" id="social-icons">
							<i class="bi bi-facebook"></i> <i class="bi bi-instagram"></i> <i
								class="bi bi-youtube"></i> <i class="bi bi-twitter"></i>
						</div>
					</div>
				</div>
				<!-- FOOTER DETAILS -->
				<div class="col-12" id="footer-details">
					<div class="row">
						<div class="col-12 col-md-4" id="news-container">
							<h4>Saiba o que estÃ¡ rolando em campo</h4>
							<p class="quaternary-color">Inscreva-se para saber em
								primeira mÃ£o</p>
							<form>
								<div class="mb-3">
									<input type="email" class="form-control"
										placeholder="Digite o seu e-mail" />
								</div>
								<button class="btn btn-dark">Inscrever</button>
							</form>
						</div>
						<div class="col-12 col-md-4" id="contact-container">
							<h4>Formas de contato</h4>
							<p class="quaternary-color">(99)9999-9999</p>
							<p class="quaternary-color">contato@pontodepartida.com.br</p>
						</div>
						<div class="col-12 col-md-4" id="links-container">
							<div class="row">
								<h4>VocÃª pode estar buscando por:</h4>
								<div class="col-6">
									<ul class="list-unstyled">
										<li><a href="#" class="quaternary-color">Pacotes</a></li>
										<li><a href="#" class="quaternary-color">Campeonatos</a></li>
										<li><a href="#" class="quaternary-color">Vendas</a></li>
									</ul>
								</div>
								<div class="col-6">
									<ul class="list-unstyled">
										<li><a href="#" class="quaternary-color">Contato</a></li>
										<li><a href="#" class="quaternary-color">EndereÃ§o</a></li>
										<li><a href="#" class="quaternary-color">Cancelamentos</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- FOOTER BOTTOM -->
				<div class="col-12" id="footer-bottom">
					<div class="row justify-content-between">
						<div class="col-12 col-md-3">
							<p class="tertiary-color">Ponto de Partida &copy</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>

</html>