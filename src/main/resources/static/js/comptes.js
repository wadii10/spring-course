function deleteCompteAjax(rib) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this student!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: "/comptes/delete-compte-ajax",
                type: "POST",
                data: {
                    rib: rib
                },
                success: function() {
                    $("#" + rib).remove();
                     swal("Success", "the compte has been deleted successfully!", "success").then(() => {
                                    location.reload();
                     });
                },
                error: function() {
                    swal("Oops! Something went wrong. Please try again.", {
                        icon: "error",
                    });

                }
            });
        }
    });
}

function editCompte(rib) {
    $.ajax({
        url: '/comptes/get-compte',
        type: 'GET',
        data: { rib: rib },
        success: function (data) {
            $('#editRib').val(data.rib);
            $('#editNomClient').val(data.nomClient);
            $('#editSolde').val(data.solde);

            // Show the modal
            const editModal = new bootstrap.Modal(document.getElementById('editCompteModal'));
            editModal.show();
        },
        error: function () {
            swal("Error", "Failed to fetch compte details", "error");
        }
    });
}

// Save Changes in Modal
document.getElementById('saveCompteBtn').addEventListener('click', function () {
    const updatedCompte = {
        rib: document.getElementById('editRib').value,
        nomClient: document.getElementById('editNomClient').value,
        solde: document.getElementById('editSolde').value,
    };

    $.ajax({
        url: '/comptes/update-compte',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedCompte),
        success: function () {
            swal("Success", "Compte updated successfully", "success").then(() => {
                // Close the modal
                const editModal = bootstrap.Modal.getInstance(document.getElementById('editCompteModal'));
                editModal.hide();
                location.reload();
            });
        },
        error: function () {
            swal("Error", "Failed to update compte", "error");
        }
    });
});