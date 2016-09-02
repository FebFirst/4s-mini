/**
 * Created by googo on 16/9/2.
 */
$(function(){
    $('.tableFormat').each(function(index, element) {
        if(!$(this).hasClass('hide'))
        {
            var next=$(this).parent('tr').next('tr').children('.tableFormat');
            $(this).attr('rowspan',1);
            while($(this).text()==next.text())
            {
                $(this).attr('rowspan',parseInt($(this).attr('rowspan'))+1);
                next.hide();
                next.addClass('hide');
                next=next.parent('tr').next('tr').children('.tableFormat');
            }
        }
    });
});