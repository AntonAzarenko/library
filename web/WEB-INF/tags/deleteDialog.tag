<%@ tag  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ attribute name="title" required="true"%>
<%@ attribute name="message" required="true"%>
<%@ attribute name="action" required="true"%>

<div class="modal fade" id="confirDialog" tabindex="-1" role="dialog" aria-labelledby="confirDialogLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="confirDialogLabel">${title}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <span>text</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"><ui:i19n message="cancel"/></button>
        <a href="#" class="btn btn-primary" id="delconfirm"><ui:i19n message="delete"/></a>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
$('#confirDialog').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget)
    var id = button.data('id')
    var text = button.data('text')
    var modal = $(this)
    modal.find('.modal-body span').text('${message} "' + text + '"?')
    $('#delconfirm').attr('href','${action}?id=' + id)
})
</script>