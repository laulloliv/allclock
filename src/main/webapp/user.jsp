<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./user.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700;800&display=swap"
	rel="stylesheet" />
<title>AllClock</title>
</head>
<body>
	<header>
		<img src="./menu.png" alt="menu icon" id="menu" height="25em"
			style="margin-left: 2.5em" />
		<p id="marca" onclick="location.href='index.jsp';"
			style="cursor: default">ALLCLOCK</p>
		<img onclick="location.href='login.jsp';" src="./user.png"
			alt="user icon" height="35em"
			style="margin-bottom: -0.3em; margin-right: 2em; cursor: pointer" />
	</header>
	<main>
		<div class="img"></div>
		<div class="login">
			<p id="text">Bem-vindo. Acompanhe por aqui seus pedidos.</p>

			<div class="tab">
				<button id="tabLondon" class="tablinks"
					onclick="openCity(event, 'London')">Meus Pedidos</button>
				<button class="tablinks" onclick="openCity(event, 'Paris')">Minha
					Conta</button>
				<button class="tablinks" onclick="openCity(event, 'Tokyo')">Meu
					Endereço</button>
			</div>

			<div id="London" class="tabcontent">

				<c:choose>
					<c:when test="${!pedido}">
						<div id="pedidoOn">
							<p id="p" style="margin-left: 6.5em; margin-top: 2em">Em
								Processamento</p>
							<div class="etapas">
								<div id="etp-1"></div>
								<hr>
								<div id="etp-2"></div>
								<hr>
								<div id="etp-3"></div>
								<hr>
								<div id="etp-4"></div>
							</div>
							<p id="previa" style="margin-left: 5.7em;">Chega dia 20 de
								Agosto</p>
							<form action="userload">
								<input type="text" name="email" value="${username}"
									style="display: none" />
								<button type="submit" id="cancelar"
									style="background-color: #FFFFFF; margin-left: 12.6em">Cancelar
									Pedido</button>
							</form>
						</div>
					</c:when>
					<c:otherwise>
						<div id="pedidoOFF"
							style="margin-left: 3em; margin-top: -3em; font-size: 1.2em">
							<p>Você ainda não fez nunhum pedido :(</p>
						</div>
					</c:otherwise>
				</c:choose>

			</div>

			<div id="Paris" class="tabcontent">
				<form action="userDataUpdate">
					<div id="head"
						style="display: flex; align-items: center; justify-content: space-between">
						<h3>Dados Pessoais</h3>
						<img src="./icon-edit.png" class="editaDados" alt="editar icon"
							height="15em" style="cursor: pointer; margin-left: 15em" />
						<button style="background: none; margin-right: 8em" type="submit">
							<img src="./ok.png" class="confirmaDados" alt="editar icon"
								height="18em"
								style="cursor: pointer; display: none" />
						</button>

					</div>
					<div style="margin-left: 2em">					
					<input type="text" name="nome" id="iNome" placeholder="Nome"
						value="${nome}" readonly /> <input type="text" name="cpf"
						id="iCPF" placeholder="CPF" value="${cpf}" maxlength="11" readonly /> <input
						type="text" name="email" id="iEmail" placeholder="Email"
						value="${username}" readonly /> <input type="text"
						name="telefone" id="iTelefone" maxlength="11" placeholder="Telefone"
						value="${telefone}" readonly />
					</div>
				</form>
			</div>

			<div id="Tokyo" class="tabcontent">
			<form action="userUpdEndereco">
				<div id="head"
					style="display: flex; align-items: center; justify-content: space-around; margin-left: -7em;">
					<h3>Endereço de Entrega</h3>
					<img src="./icon-edit.png" class="editaEndereco" alt="editar icon" height="15em"
						style="cursor: pointer" />
					<button style="background: none; display: none" class="confirmaEndereco" type="submit">					
						<img src="./ok.png" alt="ok icon" height="18em"
						style="cursor: pointer" />
					</button>
				</div>
					<input type="text" name="cep" id="iCep" maxlength="8" placeholder="CEP"
						value="${cep}" readonly /> <input type="text" name="logradouro"
						id="ilog" placeholder="Logradouro" value="${logradouro}" readonly />
					<input type="text" name="numero" maxlength="5" id="iNum" placeholder="Número"
						value="${numero}" readonly /> <input type="text" name="cidade"
						id="iCidade" placeholder="Cidade" value="${cidade}" readonly /> <input
						type="text" name="estado" id="iEstado" maxlength="2" placeholder="Estado"
						value="${estado}" readonly />
						<input
						type="text" name="email" value="${email}" style="display: none" />
				</form>
			</div>

		</div>
	</main>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		$(document).ready(function() {

			$('.editaDados').click(function() {

				$("#iNome").removeAttr('readonly');
				$("#iCPF").removeAttr('readonly');
				$("#iEmail").removeAttr('readonly');
				$("#iTelefone").removeAttr('readonly');
				$(".editaDados").css("display", "none");
				$(".confirmaDados").css("display", "block");

			});

			$('.confirmaDados').click(function() {

				$("#iNome").attr('readonly', true);
				$("#iCPF").attr('readonly', true);
				$("#iEmail").attr('readonly', true);
				$("#iTelefone").attr('readonly', true);
				$(".editaDados").css("display", "block");
				$(".confirmaDados").css("display", "none");

			});

				$('.editaEndereco').click(function() {

					$("#iCep").removeAttr('readonly');
					$("#ilog").removeAttr('readonly');
					$("#iNum").removeAttr('readonly');
					$("#iCidade").removeAttr('readonly');
					$("#iEstado").removeAttr('readonly');
					$(".editaEndereco").css("display", "none");
					$(".confirmaEndereco").css("display", "block");

				});

				$('.confirmaEndereco').click(function() {

					$("#iCep").attr('readonly', true);
					$("#iLog").attr('readonly', true);
					$("#iNum").attr('readonly', true);
					$("#iCidade").attr('readonly', true);
					$("#iEstado").attr('readonly', true);
					$(".editaEndereco").css("display", "block");
					$(".confirmaEndereco").css("display", "none");

			});

		}

		);
	</script>
</body>
</html>