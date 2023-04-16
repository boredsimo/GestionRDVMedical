/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {

  $("#dialog").dialog({
     autoOpen: false,
     modal: true
   });

  $("#myButton").on("click", function(e) {
      e.preventDefault();
      $("#dialog").dialog("open");
  });

});
