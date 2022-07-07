<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./buyFinal.css" />
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
			<div class="dados">
				<p id="text-t">Confirme seu Pedido</p>
				<div class="finalizar">
					<div class=resumo>
						<p id="text">Resumo</p>
						<div class="etps">
							<p class="detalhes" id="rel" style="margin-left: -0.1em">${produto}</p>
							<span  style="font-size: 1em">${qtdProduto}x</span>
						</div>
						<div class="etps">
							<p class="detalhes" id="total" style="margin-left: -0.1em">Total:</p>
							<span style="font-size: 1em">${total}</span>
						</div>
						<div class="etps">
							<p class="detalhes">${logradouro}, ${numero}</p>
							<span style="font-size: 1em">${cep}</span>
						</div>
						<div class="etps">
							<p class="detalhes">Cartão 8888 ****</p>
							<span style="font-size: 1em">${parcelas}</span>
						</div>
					</div>
					<div class="previa">
						<p id="t-1">Entrega prevista</p>
						<p id="t-2">Chega dia 20 de Agosto</p>
						<p id="t-3">Frete Grátis</p>
					</div>
				</div>
			</div>
			<div class="backOrGo">
				<a href="buyPag" id="voltar">Voltar</a>
				<a href="main" id="continuar" onclick="show();">Finalizar Compra</a>
			</div>
		</div>
	</main>
	<script type="text/javascript">
		function show(){
			window.alert("Compra Finalizada! Acompanhe o andamento dela em sua conta.");
		}
	</script>
</body>
</html>