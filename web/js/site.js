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
    $('.date')
        .attr('pattern', '^\\d{2}\\/\\d{2}\\/\\d{4}$')
        .attr('placeholder', 'MM/dd/yyyy')
        .keyup(validateDate);

    $('.phone')
        .attr('placeholder', 'xxx xxx xxxx')
        .attr('pattern', '^\\d{3} \\d{3} \\d{4}$')
        .keyup(validatePhone);

    function validateDate(){
        const input = $(this);
        let text = input.val();
        if(!text){ return; }

        if(text.length > 2 && text[2] !== '/') { text = `${text.substring(0, 2)}/${text.substring(2)}`; }
        if(text.length > 5 && text[5] !== '/') { text = `${text.substring(0, 5)}/${text.substring(5)}`; }

        if(text.length > 9) {
            text = text.substring(0, 10);
            const month = text.substring(0, 2);
            const day = text.substring(3, 5);
            const year = text.substring(6, 10);

            for(const c of month + '' + day + '' + year) {
                if(!$.isNumeric(c)) {
                    text = '';
                }
            }

            if(parseInt(month) > 12 || parseInt(month) < 1) {
                text = '';
            }

            if(parseInt(day) > 31 || parseInt(day) < 1){
                text = '';
            }

            if(parseInt(year) > 2099 || parseInt(year) < 1000){
                text = '';
            }
        }

        input.val(text);
    }

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