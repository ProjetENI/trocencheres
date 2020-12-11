<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Connexion"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Connexion"/>
</jsp:include>

	<!-- NOUVELLE PRESENTATION -->
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">

				<form class="login100-form validate-form validate-form-check" method="post" action="ConnectionServlet">

					<span class="login100-form-title p-b-43">
						Se connecter pour continuer
					</span>

					<div class="wrap-input100 validate-input validate-input-check" data-validate = "Pseudo ou email requis">
						<input class="input100 input-check" type="text" id="identifiant" name="identifiant">
						<span class="focus-input100"></span>
						<span class="label-input100">Identifiant</span>
					</div>

					<div class="wrap-input100 validate-input validate-input-check" data-validate="Mot de passe requis">
						<input class="input100 input-check" type="password" id="motdepasse" name="motdepasse">
						<span class="focus-input100"></span>
						<span class="label-input100">Mot de passe</span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Se souvenir de moi
							</label>
						</div>

						<div class="forgot-password">
							<a href="#" class="js-openSidebar txt1">
								Mot de passe oublié ?
							</a>
						</div>
					</div>
					
					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="text-center p-t-5 p-b-20 container-erreur100">
							<span class="text-danger">
								<c:if test="${!empty listeCodesErreur}">
									<div class="invalid-feedback" role="alert">
										<h2>Erreur!</h2>
										<c:forEach var="code" items="${listeCodesErreur}">
											${LecteurMessage.getMessageErreur(code)}<br/>
										</c:forEach>
										</ul>
									</div>
								</c:if>
							</span>
						</div>
					</div>


					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Se connecter
						</button>
					</div>

					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							Vous n'avez pas encore de compte ?
						</span>
						<a class="login100-form-btn" href="InscriptionServlet">Inscrivez-vous</a>
					</div>

				</form>
				
				<form id="retrievePassword" class="login100-form validate-form sidebar-closed" method="post" action="ConnectionServlet">
					<div class="sidebar">
						<span class="login100-form-title p-b-43">
							Mot de passe oublié
						</span>
	
						<div class="wrap-input100 validate-input" data-validate = "Email requis">
							<input class="input100" type="text" id="identifiant" name="identifiant">
							<span class="focus-input100"></span>
							<span class="label-input100">Email</span>
						</div>
					
						<div class="flex-sb-m w-full p-t-3">
							<div class="text-center p-t-5 p-b-20">
								<span class="text-danger">
									${error}
								</span>
							</div>
						</div>
	
	
						<div class="container-login100-form-btn">
							<button class="login100-form-btn">
								Renvoyer le mot de passe
							</button>
						</div>
	
						<div class="text-center p-t-46 p-b-20">
							<span class="txt2">
								Vous êtes ici par erreur ?
							</span>
							<a class="js-closeSidebar login100-form-btn" href="#">Retour à la connexion</a>
						</div>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('img/login_bg.jpg');"></div>

			</div><!-- End .wrap-login100 -->
		</div><!-- End .container-login100 -->
	</div><!-- End .limiter -->

     <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/script.js"></script>
    
</body>
</html>