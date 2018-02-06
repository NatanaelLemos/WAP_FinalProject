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