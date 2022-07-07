<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<p id="marca" onclick="location.href='index.jsp';"
			style="cursor: default">ALLCLOCK</p>
		<img onclick="location.href='login.jsp';" src="./user.png"
			alt="user icon" height="35em"
			style="margin-bottom: -0.3em; margin-right: 2em; cursor: pointer" />
	</header>
	<main>
		<div class="img"></div>
		<div class="login">
			<p id="text">Faça seu Login e acompanhe seus pedidos</p>

					<form name="frmLogin" action="user">
						<input type="text" name="email" id="email" placeholder="Email"
							required /> <input type="password" name="senha" id="senha"
							placeholder="Senha" required /> <a href="cadastro">Não é
							cadastrado? Cadastre-se aqui.</a>
						<button type="submit" style="cursor: pointer">Entrar</button>
					</form>

		</div>
	</main>
</body>
</html>