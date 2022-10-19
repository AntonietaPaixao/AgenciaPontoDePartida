<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Pessoa"
    import="java.util.List"
%>

<%
@SuppressWarnings("unchecked")
List<Pessoa> lista = (List<Pessoa>) request.getAttribute("Pessoa");
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

		<section class="container">
			<div class="p-4">
			
				<a href="./views/Pessoa/create.jsp" class="btn mb-2 botao1" style="background-color:#126e51; color:#ffdf1b"> Cadastrar Usuário</a>

				<table class="table table-responsive table-hover">
					<thead class="table-light">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">CPF</th>
							<th scope="col">E-mail</th>
							<th scope="col">Nome</th>
							<th scope="col">Data Nascimento</th>
							<th scope="col">Sexo</th>
							<th scope="col">E-mail</th>
							<th scope="col">Telefone</th>
							<th scope="col">Endereço</th>
							<th scope="col">Cadastro Usuário</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>

						<% for (Pessoa c : listaPessoa) { %>
						<tr>
							<td><%=c.getIdPessoa()%></td>
							<td><%=c.getCpf()%></td>
							<td><%=c.getNomePessoa()%></td>
							<td><%=c.getDataNascimento()%></td>
							<td><%=c.getSexo()%></td>
							<td><%=c.getEmail()%></td>
							<td><%=c.getTelefone%></td>
							<td><%=c.getEndereco.toString()%></td>
							<td><%=c.getPermissao().getTipoPermissao()%></td>
							<td>
								<div class="d-flex">
									<a href="./update-pessoa?idPessoa=<%=c.getIdPessoa()%>" class="mx-1"
										title="Editar"> <i class="ri-file-edit-line"></i>
									</a> <a href="delete-pessoa?idPessoa=<%=c.getIdPessoa()%>" class="mx-1"
										title="Excluir"
										onclick="return confirm('Deseja excluir o usuário <%=c.getNomePessoa()%>?')">
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