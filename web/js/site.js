/* jshint esversion: 6 */
/* jshint browser: true */
"use strict";

function showLoading(parent) {
    const loading = $('.loading-original').clone();
    parent.attr('disabled', 'disabled');
    parent.append(loading);
    loading.removeClass('hide');
    loading.removeClass('loading-original');
}

function hideLoading(parent) {
    //Just to make the loading appear :D
    setTimeout(() => {
        parent.removeAttr('disabled');
        parent.find('.loading').remove();
    }, 400);
}

$(() => {

    $('.username')
        .attr("pattern", "^[a-zA-Z ]+$")
        .attr('maxlength', '200');

    $('.email')
        .attr('maxlength', '255');

    $('.currency')
        .attr("pattern", "^[0-9]{1,3}(?:,?[0-9]{3})*\\.[0-9]{2}$")
        .attr('placeholder', 'xx.xx')
        .attr('maxlength', '11');

    $('.phone')
        .attr('placeholder', 'xxx xxx xxxx')
        .attr('pattern', '^\\d{3} \\d{3} \\d{4}$')
        .keyup(validatePhone);

    $('.state')
        .attr('maxlength', '2')
        .attr('placeholder', 'State');

    $('.city')
        .attr('maxlength', '50');

    $('.zip')
        .attr('pattern', "^\\d{5}(?:[-\s]\d{4})?$");

    function validatePhone(){
        const input = $(this);
        let text = input.val();
        if(!text){ return; }

        if(text.length > 3 && text[3] != ' ') { text = `${text.substring(0, 3)} ${text.substring(3)}`; }
        if(text.length > 7 && text[7] != ' ') { text = `${text.substring(0, 7)} ${text.substring(7)}`; }

        if(text.length > 12) {
            text = text.substring(0, 12);
            for(const c of text){
                if((!$.isNumeric(c)) && (c != ' ')) {
                    text = '';
                }
            }
        }

        input.val(text);
    }
});