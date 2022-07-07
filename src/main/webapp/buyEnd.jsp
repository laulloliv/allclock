<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./buyEnd.css" />
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
		<div class="endBuy">
			<div class="etapas">
				<div id="etp-1"></div>
				<hr>
				<div id="etp-2"></div>
				<hr>
				<div id="etp-3"></div>
				<hr>
				<div id="etp-4"></div>
			</div>
			<form action="buyPag">
				<div class="dados">
					<div class="dadosPessoais">
						<p>Informe seus dados</p>
						<input type="text" name="nome" required placeholder="Nome Completo" /> <input
							type="text" name="telefone" required placeholder="Telefone" maxlength="11" /> <input
							type="text" name="cpf" required maxlength="11" placeholder="CPF" />
							<input
							type="text" name="email" required placeholder="Email" />
							<input
							type="text" name="idPedido" value="${idPedido}" style="display: none" />
							<input
							type="text" name="total" value="${total}" style="display: none" />
							
					</div>
					<div class="endereco">
						<p>Informe seus endereço</p>
						<input type="text" name="cep" required maxlength="8" placeholder="CEP" /> <input
							type="text" name="logradouro" required placeholder="Logradouro" /> <input
							type="text" name="numero" required maxlength="5" placeholder="Número" /> <input
							type="text" name="cidade" required placeholder="Cidade" /> <input
							type="text" name="estado" required maxlength="2" placeholder="Estado" />
					</div>
				</div>
				<div class="backOrGo">
					<a href="buy" id="voltar">Voltar</a>
					<button type="submit" id="continuar">Continuar</button>
				</div>
			</form>
		</div>

	</main>
</body>
</html>