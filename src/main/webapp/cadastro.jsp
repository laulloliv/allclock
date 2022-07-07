<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./login.css" />
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
		<p id="marca" onclick="location.href='index.jsp';" style="cursor: default">ALLCLOCK</p>
		<img onclick="location.href='login.jsp';" src="./user.png"
			alt="user icon" height="35em"
			style="margin-bottom: -0.3em; margin-right: 2em; cursor: pointer" />
	</header>
	<main>
		<div class="img"></div>
		<div class="login">
			<p id="text-c">Faça seu cadastro e acompanhe seus pedidos</p>
			<form name="cadastroCliente" action="login">
				<input type="text" name="nome" id="nome" placeholder="Nome" /> 
				<input type="text" name="email" id="email" placeholder="Email" /> 
				<input type="password" name="senha" id="senha" placeholder="Senha" />
				<a href="login">Já é cadastrado? Faça seu login aqui.</a>
				<button type="submit">Criar conta</button>
			</form>
		</div>
	</main>
</body>
</html>