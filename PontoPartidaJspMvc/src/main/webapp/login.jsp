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
<link rel="stylesheet" href="css/estilos.css">
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
					src="img/icone-PontoPartida.png" alt="Home" /> <span
					class="quaternary-color">Ponto de Partida</span>
				</a>
				<!--Botão responsivo de menu-->
				<button class="navbar-toggler bg-secondary-color" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbar-items"
					aria-controls="navbar-items" aria-expanded="false"
					aria-label="Toggle navigation">
					<i class="bi bi-list"></i>
				</button>
				<div class="collapse navbar-collapse" id="navbar-items">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0" id="navbar-li">
						<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="pacotes.jsp">Pacotes</a>
							<!--ALTERAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARRRRR --></li>
						<li class="nav-item"><a class="nav-link" href="promocoes.jsp">Promoções</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="contato.jsp">Contato</a>
						</li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="login.jsp">Login</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main class="container" id="slider">
		<!--FORMULÁRIOS-->

		<section class="vh-100 bg-secondary-color">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6 text-black">

						<div
							class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

							<form style="width: 23rem;" action="../../create-usuario">
							
								<p><a href="./views/Partida/indexPartida.html" class="link-info">ACESSO PROVISÓRIO À ÁREA ADMINISTRATIVA</a></p>

								<h2 class="title">Login</h2>

								<div class="form-outline mb-3">
									<label for="inlineFormCustomSelectPref">Tipo de Acesso</label>
									<select class="custom-select my-1 mr-sm-2" id="tipoPermissao"
										name="tipoPermissao">
										<option selected="">Selecione...</option>
										<option value="cliente">Cliente</option>
										<option value="admin">Administrador</option>
									</select>
								</div>

								<div class="form-outline mb-3">
									<input type="email" id="email" name="email"
										class="form-control form-control-lg" /> <label
										class="form-label" for="form2Example18">Email de
										Acesso</label>
								</div>

								<div class="form-outline mb-3">
									<input type="password" id="senha" name="senha"
										class="form-control form-control-lg" /> <label
										class="form-label" for="form2Example28">Senha</label>
								</div>



								<div class="pt-1 mb-3">
									<button class="btn btn-success btn-lg btn-block" type="submit">Login</button>
								</div>

								<p class="small mb-3 pb-lg-2">
									<a class="text-muted" href="#!">Esqueceu a Senha?</a>
								</p>
								<p>
									Ainda não possui cadastro? <a
										href="./views/Pessoa/createCliente.jsp" class="link-info">Cadastre-se
										aqui </a>
								</p>

							</form>

						</div>

					</div>
					<div class="col-sm-6 px-0 d-none d-sm-block">
						<img src="img/login.png" alt="Login image" class="w-100 vh-100"
							style="object-fit: cover; object-position: left;">
					</div>
				</div>
			</div>
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