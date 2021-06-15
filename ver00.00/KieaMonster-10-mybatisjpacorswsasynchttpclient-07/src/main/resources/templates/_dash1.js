
$('#applybtn1').click(function(){
  $('.item:nth-child(1)').css('grid-column-start', $('#x1').val());
  $('.item:nth-child(1)').css('grid-row-start', $('#y1').val());
  $('.item:nth-child(1)').css('grid-column-end', parseInt($('#x1').val())+parseInt($('#w1').val()));
  $('.item:nth-child(1)').css('grid-row-end', parseInt($('#y1').val())+parseInt($('#h1').val()));
});

$('#applybtn2').click(function(){
  $('.item:nth-child(2)').css('grid-column-start', $('#x2').val());
  $('.item:nth-child(2)').css('grid-row-start', $('#y2').val());
  $('.item:nth-child(2)').css('grid-column-end', parseInt($('#x2').val())+parseInt($('#w2').val()));
  $('.item:nth-child(2)').css('grid-row-end', parseInt($('#y2').val())+parseInt($('#h2').val()));
});

$('#applybtn3').click(function(){
  $('.item:nth-child(3)').css('grid-column-start', $('#x3').val());
  $('.item:nth-child(3)').css('grid-row-start', $('#y3').val());
  $('.item:nth-child(3)').css('grid-column-end', parseInt($('#x3').val())+parseInt($('#w3').val()));
  $('.item:nth-child(3)').css('grid-row-end', parseInt($('#y3').val())+parseInt($('#h3').val()));
});

$('#applybtn4').click(function(){
  $('.item:nth-child(4)').css('grid-column-start', $('#x4').val());
  $('.item:nth-child(4)').css('grid-row-start', $('#y4').val());
  $('.item:nth-child(4)').css('grid-column-end', parseInt($('#x4').val())+parseInt($('#w4').val()));
  $('.item:nth-child(4)').css('grid-row-end', parseInt($('#y4').val())+parseInt($('#h4').val()));
});

$('#applybtn5').click(function(){
  $('.item:nth-child(5)').css('grid-column-start', $('#x5').val());
  $('.item:nth-child(5)').css('grid-row-start', $('#y5').val());
  $('.item:nth-child(5)').css('grid-column-end', parseInt($('#x5').val())+parseInt($('#w5').val()));
  $('.item:nth-child(5)').css('grid-row-end', parseInt($('#y5').val())+parseInt($('#h5').val()));
});