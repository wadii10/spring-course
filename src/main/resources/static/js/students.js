function deleteStudentAjax(id) {
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this student!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
        if (willDelete) {
            $.ajax({
                url: "/students/delete-student-ajax",
                type: "POST",
                data: {
                    id: id
                },
                success: function() {
                    $("#" + id).remove();
                    swal("Success", "student has been deleted successfully!", "success").then(() => {
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

function editStudent(id) {
    $.ajax({
        url: '/students/get-student',
        type: 'GET',
        data: { id: id },
        success: function (data) {
            $('#editId').val(data.id);
            $('#editNameStudent').val(data.name);

            // Show the modal
            const editModal = new bootstrap.Modal(document.getElementById('editStudentModal'));
            editModal.show();
        },
        error: function () {
            swal("Error", "Failed to fetch Student details", "error");
        }
    });
}

// Save Changes in Modal
document.getElementById('saveStudentBtn').addEventListener('click', function () {
    const updatedStudent = {
        id: document.getElementById('editId').value,
        name: document.getElementById('editNameStudent').value,
    };

    $.ajax({
        url: '/students/update-student',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedStudent),
        success: function () {
            swal("Success", "Student updated successfully", "success").then(() => {
                // Close the modal
                const editModal = bootstrap.Modal.getInstance(document.getElementById('editStudentModal'));
                editModal.hide();
                location.reload();
            });
        },
        error: function () {
            swal("Error", "Failed to update compte", "error");
        }
    });
});