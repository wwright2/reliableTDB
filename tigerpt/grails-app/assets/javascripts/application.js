// TigerPT Application JavaScript

// Confirmation for delete actions
function confirmDelete(message) {
    return confirm(message || 'Are you sure you want to delete this record?');
}

// Format dates
document.addEventListener('DOMContentLoaded', function() {
    // Auto-hide flash messages after 5 seconds
    var flashMessages = document.querySelectorAll('.flash');
    flashMessages.forEach(function(flash) {
        setTimeout(function() {
            flash.style.opacity = '0';
            flash.style.transition = 'opacity 0.5s';
            setTimeout(function() {
                flash.style.display = 'none';
            }, 500);
        }, 5000);
    });
});

// Form validation helper
function validateForm(formId) {
    var form = document.getElementById(formId);
    if (!form) return true;
    
    var requiredFields = form.querySelectorAll('[required]');
    var isValid = true;
    
    requiredFields.forEach(function(field) {
        if (!field.value.trim()) {
            field.style.borderColor = 'red';
            isValid = false;
        } else {
            field.style.borderColor = '';
        }
    });
    
    if (!isValid) {
        alert('Please fill in all required fields.');
    }
    
    return isValid;
}

// Search functionality
function performSearch(searchTerm, targetUrl) {
    if (searchTerm.length < 2) {
        alert('Please enter at least 2 characters to search.');
        return;
    }
    window.location.href = targetUrl + '?q=' + encodeURIComponent(searchTerm);
}
