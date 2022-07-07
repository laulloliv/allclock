<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./buyPag.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700;800&display=swap"
	rel="stylesheet" />
<title>AllClock</title>
</head>
<body>
	<header>
		<img src="./menu.png" alt="menu icon" id="menu" height="25em" style="margin-left: 2.5em"/>
		<p id="marca" onclick="location.href='index.jsp';" style="cursor: default">ALLCLOCK</p>
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
			<form action="buyFinal">
			<div class="dados">
				<div class="pagamento">
					<p id="text">Informe sua forma de Pagamento</p>
					<input type="text" name="numCartao" maxlength="16" required placeholder="Número do Cartão " />
					<input type="text" name="email" value="${email}" style="display: none" />
					<input type="text" name="nomeCartao" required placeholder="Nome do Cartão" />
					<input type="text" name="validade" required id="val" placeholder="Validade" />
					<input type="text" name="codCartao" maxlength="3" required id="cod" placeholder="Código" /> <select
						name="tipoPagamento" id="pag">
						<option value="credito" selected>Crédito</option>
						<option value="debito">Débito</option>
					</select> <select name="parcelas" id="parcelas">
						<option value="1x de ${total}" selected>1x de ${(total)}</option>
						<option value="2x de ${Math.floor(total/2)+ 0.5}">2x de ${Math.floor(total/2)+ 0.5}</option>
						<option value="3x de ${Math.floor(total/3) + 0.4}">3x de ${Math.floor(total/3) + 0.4}</option>
					</select>
				</div>
			</div>
			<div class="backOrGo">
				<a href="buyEnd" id="voltar">Voltar</a> <button type="submit"
					id="continuar">Continuar</button>
			</div>
			</form>
		</div>
	</main>
</body>
</html>