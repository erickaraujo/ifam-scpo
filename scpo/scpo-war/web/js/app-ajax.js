function testaFuncao(){
    $.ajax({ 
        type: 'GET', 
        url: 'localhost:8080/scpo/api/estado', 
        dataType: 'json',
        success: function (data) { 
            $.each(data, function(index, element) {
                $('body').append($('<div>', {
                    text: element.name
                }));
            });
        }
    });
}