/*
 * Author: Abdullah A Almsaeed
 * Date: 4 Jan 2014
 * Description:
 *      This is a demo file used only for the main dashboard (index.html)
 **/

/* global moment:false, Chart:false, Sparkline:false */

$(function () {
    'use strict'

    $.get( "arch", function( data ) {
        if(data == "x86_64") {
            $('#img-arch').html("<img src='imgs/aws.png' />");
        }
        else if(data == "s390x") {
            $('#img-arch').html("<img src='imgs/s390.png' />");
        }
        console.log("data = ", data);
    });
})
  