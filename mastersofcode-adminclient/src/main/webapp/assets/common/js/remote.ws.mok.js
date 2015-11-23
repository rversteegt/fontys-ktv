var login, password, ws;

ws = {
  endpoint: "http://localhost:8083/api/",
  services: {
    competitions: {
      endpoint: "http://localhost:8083/api/competitions/",
      all: function(error, success) {
        return $.ajax({
          url: "http://localhost:8083/api/competitions/",
          method: "GET",
          dataType: "application/json",
          error: error,
          success: success
        });
      }
    },
    authentication: {
      endpoint: "http://localhost:8083/api/security/",
      login: function(login, pass, error, success) {
        return $.post("http://localhost:8083/api/security/", login + ";" + pass, success);
      }
    }
  }
};

login = "admin";

password = "admin";

$(function() {
  ws.services.authentication.login(login, password, function(error, b, c) {
    console.log(error);
    console.log(b);
    return console.log(c);
  }, function() {
    return console.log("succesfully logged in.");
  });
  return ws.services.competitions.all(function() {
    return $('.error').html("Er trad een fout op bij het laden van wedstrijden.");
  }, function(data) {
    return console.log(JSON.parse(data));
  });
});
