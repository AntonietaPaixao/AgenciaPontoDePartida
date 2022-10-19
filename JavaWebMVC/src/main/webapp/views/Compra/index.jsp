<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Compra"
    import="java.util.List"
%>

<%
@SuppressWarnings("unchecked")
List<Compra> lista = (List<Compra>) request.getAttribute("Compra");
%>


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

		<section class="container">
			<div class="p-4">
			
				<a href="./views/Pessoa/create.jsp" class="btn mb-2 botao1" style="background-color:#126e51; color:#ffdf1b"> Compra </a>

				<table class="table table-responsive table-hover">
					<thead class="table-light">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Valor Compra</th>
							<th scope="col">Data da Compra</th>
							<th scope="col">Nome</th>
							<th scope="col">Quantidade de Pacotes</th>
							<th scope="col">Cliente</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>

						<% for (Compra c : Compra) { %>
						<tr>
							<td><%=c.getIdCompra()%></td>
							<td><%=c.getValorCompra()%></td>
							<td><%=c.getDataCompra()%></td>
							<td><%=c.getQuantidadePacotes()%></td>
							<td><%=c.getPessoa()%></td>
						<td>
								<div class="d-flex">
									<a href="./update-compra?idCompra=<%=c.getIdCompra()%>" class="mx-1"
										title="Editar"> <i class="ri-file-edit-line"></i>
									</a> <a href="delete-compra?idCompra=<%=c.getIdCompra()%>" class="mx-1"
										title="Excluir"
										onclick="return confirm('Deseja excluir o compra de valor <%=c.getValorCompra()%>?')">
										<i class="ri-delete-bin-2-line"></i>
									</a>
								</div>
							</td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>

			</div>
		</section>

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