<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./buy.css" />
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
		<div class="selectBuy">
			<form action="buyEnd">
						<div class="etapas">
							<div id="etp-1"></div>
							<hr>
							<div id="etp-2"></div>
							<hr>
							<div id="etp-3"></div>
							<hr>
							<div id="etp-4"></div>
						</div>
						
						<div class="pedidos">
							<div class="sacola">
								<p>Selecione seu AllClock</p>
								<select name="rels" id="rels" class="rels">
									<option value="img-rel-1">AllClock Smooth Brown</option>
									<option value="img-rel-2" selected>AllClock Black
										Adventure</option>
									<option value="img-rel-3">AllClock Soft W</option>
								</select> <br>


								<div class="qtd-b">
									<p id="qtd-t">Quantidade</p>
									<select name="qtd" id="qtd">
										<option value="1" selected>1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
									</select>
									<button type="button" onclick="rsmCompras();">Adicionar
										produto(s)</button>
								</div>
							</div>
							<div id="previa">
								<p id="rdm-p">Resumo</p>
								<div class="tot-pedidos"
									style="padding-left: 1em; display: block; align-items: center; justify-content: space-between; margin-top: 2em">
									<label style="font-size: 0.8em">Item: <input type=text
										id="iProd" name="iProd" readonly
										style="font-family: 'Raleway', sans-serif; font-size: 0.9em; background-color: #FFFFFF" />
									</label> <br> <label style="font-size: 0.8em">Qtd: <input
										type=text id="iQtd" name="iQtd" readonly
										style="font-family: 'Raleway', sans-serif; font-size: 0.9em; background-color: #FFFFFF" />
									</label> <br> <label style="font-size: 0.8em">Total: <input
										type=text id="total" name="iTotal" readonly
										style="font-family: 'Raleway', sans-serif; font-size: 0.9em; background-color: #FFFFFF" />
										<input type=text id="idPedido"
										name="idPedido" readonly style="display: none" />
									</label>
								</div>
							</div>
						</div>
						<div class="backOrGo">
							<a href="main" id="voltar">Voltar</a>
							<button type="submit" id="continuar">Continuar</button>
						</div>
					</form>
		</div>
	</main>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(".rels").change(function() {
			var value_my_select = $(this).val();
			$(".rels").css({
				"background" : "url(" + value_my_select + ".png) no-repeat",
				"background-size" : "contain"
			})
			var img_bg = '';
			var bg_p = '0 -2em';
			if (value_my_select == "img-rel-1") {
				img_bg = 'rel-5';
				bg_p = '-3em 0';
			} else if (value_my_select == "img-rel-2") {
				img_bg = 'rel-3';
			} else {
				img_bg = 'rel-2';
			}
			$(".img").css({
				"background-image" : "url(" + img_bg + ".jpg)",
				"background-position" : bg_p
			})
		}).trigger("change");
		
		function gerar()
		  {
		    var resp = document.getElementById('idPedido');
		    resp.value = Math.floor(9999 * Math.random());
		  }

		function rsmCompras() {
			var option = document.getElementById("rels");
			var qtd = document.getElementById("qtd");
			var qtd = qtd.value;
			var relOpt = option.value;
			var relogio = "";
			var valor = 0;
			if (relOpt == "img-rel-1") {
				relogio = "AllClock Smooth Brown";
				valor = 829.90;
			} else if (relOpt == "img-rel-2") {
				relogio = "AllClock Black Adventure";
				valor = 1289.15;
			} else {
				relogio = "AllClock Soft W";
				valor = 889.20;
			}
			var total = qtd * valor;

			document.getElementById("iProd").value = relogio;
			document.getElementById("iQtd").value = qtd;
			document.getElementById("total").value = total;
			
			gerar();
		}
		
	</script>
</body>
</html>