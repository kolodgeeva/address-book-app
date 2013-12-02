$(document).ready(function(){

    $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);

    $(document).ajaxComplete(function(){
        $.unblockUI();
    });

    //load templates
    $.post('ajax_route.php', {action: 'getTemplates'}, function(resp){
        $('.templatesCol').html(resp);
    });

});

$(document).on('click', '.editTemplate', function(){

    $('.ajaxPlace').hide('fast');
    var id = $(this).data('id');

    $.post('ajax_route.php', {action: 'getTemplate', id: id}, function(resp){
        $('.ajaxPlace').html(resp);
        $('.ajaxPlace').show('slow');
    });
});

$(document).on('click', '.addArticles', function(){

    $('.ajaxPlace').hide('fast');
    var id = $(this).data('id');

    $.post('ajax_route.php', {action: 'getArticlesForm', id: id}, function(resp){
        $('.ajaxPlace').html(resp);
        $('.ajaxPlace').show('slow');
    });
});

$(document).on('click', '#saveTemplate', function(){

    var data = $('#templateForm').serializeArray();

    $.post('ajax_route.php', data, function(resp){
        alert(resp);
    });


});

$(document).on('click', '#saveArticles', function(){

    var data = $('#articlesForm').serializeArray();

    $.post('ajax_route.php', data, function(resp){
        alert(resp);
        $('#reset').click();
    });

});
