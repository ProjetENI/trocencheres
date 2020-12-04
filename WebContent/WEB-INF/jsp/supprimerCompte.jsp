<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container">
	<section class="mb-5">
		<h2>Supprimer mon compte</h2>
		<p>Vous pouvez supprimer votre compte en cliquant sur "Supprimer le compte".<br/>
		Attention: Toutes vos données seront perdue.</p>
		<button class="btn btn-outline-danger" data-toggle="modal" data-target="#confirm-delete">Supprimer le compte</button>
<!-- 		<a href="SupprimerCompteServlet" class="btn btn-outline-danger">Supprimer le compte</a>	 -->
	</section>
	
	<div class="modal fade" id="confirm-delete" tabindex="-1" aria-labelled="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					Confirmation de suppression
				</div>
				<div class="modal-body">
					Attention, vous êtes sur le point de supprimer votre compte.<br/>
					Cette action est irréversible.
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
					<a href="SupprimerCompteServlet" class="btn btn-danger btn-ok">Supprimer le compte</a>	
				</div>
			</div>
		</div>
	</div>

</div>

