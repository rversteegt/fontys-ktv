ws = 
    endpoint: "http://localhost:8083/api/"
    services: 
        competitions: 
            endpoint: "http://localhost:8083/api/competitions/"
            all: (error, success) -> 
                $.ajax
                    url: "http://localhost:8083/api/competitions/"
                    method: "GET"
                    dataType: "application/json"
                    error: error
                    success: success
        authentication:
            endpoint: "http://localhost:8083/api/security/"
            login: (login, pass, error, success) -> 
                    $.post(
                        "http://localhost:8083/api/security/"
                        login + ";" + pass
                        success
                    )

login = "admin"
password = "admin"

$ ->
    ws.services.authentication.login(
        login
        password
        (error, b, c) -> 
            console.log error
            console.log b
            console.log c            
            #window.location.replace "/mok/login"
        () -> console.log "succesfully logged in.")

    ws.services.competitions.all(
        () -> $('.error').html "Er trad een fout op bij het laden van wedstrijden."
        (data) -> console.log JSON.parse data)