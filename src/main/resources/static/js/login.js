document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    // Clear previous error messages
    const errorMessage = document.getElementById('error-message');
    errorMessage.textContent = '';

    // Get form values
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Validate form values
    if (!validateEmail(email)) {
        errorMessage.textContent = 'Please enter a valid email address.';
        return;
    }

    if (password.length < 6) {
        errorMessage.textContent = 'Password must be at least 6 characters long.';
        return;
    }

    // Submit the form
    document.getElementById('login-form').submit();
});

function validateEmail(email) {
    const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return re.test(String(email).toLowerCase());
}
