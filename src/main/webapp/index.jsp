<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./style.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;500;600;700;800&display=swap"
	rel="stylesheet" />
<title>AllClock</title>
</head>
<body>
	<main>
		<section class="home">
		<header class="init" style="position: fixed">
		<img src="./menu.png" alt="menu icon" id="menu" height="25em"
			style="margin-left: 3em" />
		<p id="marca" onclick="location.href='index.jsp';" style="cursor: default">ALLCLOCK</p>
		<img onclick="location.href='login.jsp';" src="./user.png"
			alt="user icon" height="35em"
			style="margin-bottom: -0.3em; margin-right: 2em; cursor: pointer;" />
	</header>
	</a></section>
		<section class="relogios">
			<h1 class="text-b1">Choose your AllClock</h1>
			<div class="rels" style="margin-right: 4em">
				<div id="rel-1">
					<a class="a" id="b-1" href="buy">Buy now</a>
				</div>
				<div id="rel-2">
					<a class="a" id="b-2" href="buy">Buy now</a>
				</div>
				<div id="rel-3">
					<a class="a" id="b-3" href="buy">Buy now</a>
				</div>
			</div>
			<h1 class="text-b2">Don´t miss the chance. Buy now.</h1>
		</section>
	</main>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$(window).scroll(function() {
				$('.home').css("opacity", 1 - $(window).scrollTop() / 600)
			})
		})
	</script>
</body>
</html>