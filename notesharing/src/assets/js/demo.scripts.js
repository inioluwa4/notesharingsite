/* ************************************************************************************** */
/*                                                                                        */
/*   © Bitbenderz.com ... 2017                                                            */
/*                                                                                        */
/*   @ project : jQuery stockTicker Lite Demo                                             */
/*   @ author  : tom@bitbenderz.com                                                       */
/*   @ version : 1.0.0                                                                    */
/*   @ updated : June, 2017                                                               */
/*   @ licnese : Dual licensed under ...                                                  */
/*               MIT (http://www.opensource.org/licenses/mit-license.php)                 */
/*               GPL (http://www.opensource.org/licenses/gpl-license.php)                 */
/*                                                                                        */
/* ************************************************************************************** */


var stl_ops = new Array();
  stl_ops[1] = {};
  stl_ops[2] = {symbols:'msft, aapl, goog, fb, yhoo'};
  stl_ops[3] = {type: 'rtl'};
  stl_ops[4] = {theme: 'citrus'};
  stl_ops[5] = {theme: 'twitter', hoverPause: false};
  stl_ops[6] = {refresh: 20};
  stl_ops[7] = {theme:'default noBorder noSymbol', type:'ltr', refresh:300, symbols:'.DJI, .IXIC, .SPX, .GSPTSE, .N225', hoverPause:true};
  stl_ops[8] = {theme:'twitter noBorder noName', type:'rtl', refresh:300, symbols:'msft, aapl, goog, twtr, fb', hoverPause:true};
  stl_ops[9] = {theme:'citrus noBorder noName', type:'ltr', refresh:300, symbols:'cad=, eur=, jpy=, gbp=', hoverPause:true};

/* ************************************	*/
/* Window Resize                        */
/* ************************************	*/
$(window).resize(function(){

	var w = $(window).width();
	var h = $(window).innerHeight();

	/*  Used for Debug ONLY  */
//	window.status = w + ' x ' + h;

});

/* ************************************	*/
/* Window Loaded                        */
/* ************************************	*/
$(window).on('load', function(){

	setTimeout(function(){createOutputs();}, 100);
});

/* ************************************	*/
/* DOM Ready                            */
/* ************************************	*/
jQuery(document).ready(function(){
	var $ = jQuery;

	/*  Clean Up PRE Code  */
	$('pre').each(function(){
		var out = $(this).html().split('	').join('');
		$(this).html(out);
	});

	/*  Create Highlight Elements  */
	$('pre.code').highlight({source:0, zebra:1, indent:'space', list:'ol'});

	/*  Watch Highlight Tab Clicks  */
	$('.codewrap').find('.tab').off('click').on('click', function(e){
		if($(this).hasClass('active')){return;};

		var p = $(this).parent();
		var di = !isNaN(Number(p.attr('data-index'))) ? Number(p.attr('data-index')) : -1;

		if($(this).hasClass('code')){
			p.find('pre.source').hide();
			p.find('pre.code').show();

			/*  Kill stockTicker  */
			if(p.find('.stl').hasClass('stockTicker')){p.find('.stl').stockTicker('remove');};

		}else if($(this).hasClass('output')){
			p.find('pre.source').show();
			p.find('pre.code').hide();

			/*  Kill stockTicker  */
			if(p.find('.stl').hasClass('stockTicker')){p.find('.stl').stockTicker('remove');};

			/*  Init stockTicker  */
			p.find('.stl:eq(0)').stockTicker(stl_ops[di]);

			if(di === 7){
				p.find('.stl:eq(1)').stockTicker(stl_ops[8]);
				p.find('.stl:eq(2)').stockTicker(stl_ops[9]);
			};
		};

		p.find('.tab').removeClass('active');

		$(this).addClass('active');
	});

	/*  Init mt-scroll  */
	initScroller($('.front').find('.slimScrollMe'));

});

/* ************************************	*/
/* Create Output Tab Content            */
/* ************************************	*/
var createOutputs = function(){

	$('.codewrap').each(function(){

		$(this).find('ul.tabs').remove();

		var di = !isNaN(Number($(this).attr('data-index'))) ? Number($(this).attr('data-index')) : -1;

		var cw = $(this).find('pre.code').width();
		var ch = $(this).find('pre.code').height();

		var so = '';

		if(di > 0 && di < 7){
			so = '<pre class="source"><div class="outdiv" style="height:' + (ch-10) + 'px; width:' + (cw-10) + 'px; padding:5px 0px 5px 0px; margin:5px 0px 5px 0px;"><meta class="stl" name="description" content="stockTicker Lite"/></div></pre>';
		} else if(di === 7){
			so = '<pre class="source"><div class="outdiv" style="height:' + (ch-10) + 'px; width:' + (cw-10) + 'px; padding:5px 0px 5px 0px; margin:5px 0px 5px 0px;"><meta class="stl" name="description" content="stockTicker Lite" style="border-top:1px solid #AAA; border-bottom:1px solid #AAA;"/><meta class="stl" name="description" content="stockTicker Lite" style="border-bottom:1px solid #AAA;"/><meta class="stl" name="description" content="stockTicker Lite" style="border-bottom:1px solid #AAA;"/></div></pre>';
		};

		$(this).find('.highlight').append(so);

	});
};

/* ************************************	*/
/* Scroll To Element                    */
/* ************************************	*/
var slimScrollTo = function(elm){
	var $ = jQuery;


	var fb = $(elm).closest('.slimScrollMe').parent();

	hldHeight = $('.front').find('.slimScrollMe').find('.mt-scroll-holder').height();
	cntHeight = $('.front').find('.slimScrollMe').find('.mt-scroll-content').height();
	elmTop = $('.front').find(elm).position().top;
	pctTop = elmTop > 0 ? elmTop / cntHeight : 0;
	$('.front').find('.slimScrollMe').find('.mt-scroll-content').css('top', -elmTop + 'px');
	$('.front').find('.slimScrollMe').find('.mt-scroll-vertical-bar').css('top', (hldHeight * pctTop) + 'px');
	$('.front').find('.slimScrollMe').find('.mt-scroll-content').trigger('click');

};


/* ************************************	*/
/* Init Scroller			*/
/* ************************************	*/
var initScroller = function(who){
	var $ = jQuery;

	if($(who).hasClass('mt-scroll')){killScroller($(who));};

	$(who).mtScroll({
		autoSize         : false,
		hideBars         : true,
		mouseSensitivity : 2,
		animationTime    : 400,
		barClass         : null,
		vBarClass        : 'styled-vBar',
		hBarClass        : null,
		easing           : 'easeOutCubic',
	});

	who.find('.mt-scroll-horizontal-bar').remove();
	who.find('.mt-scroll-vertical-bar').removeClass('ui-draggable').removeClass('ui-draggable-handle');
	who.find('.mt-scroll-content').removeClass('ui-draggable').removeClass('ui-draggable-handle');
	

};

/* ************************************	*/
/* Kill Scroller			*/
/* ************************************	*/
var killScroller = function(who){
	var $ = jQuery;

	$(who).mtScroll('remove');
};


/* ************************************************************************************** */
/*                                                                                        */
/*   © Bitbenderz.com ... 2016                                                            */
/*                                                                                        */
/*   @ project : jQuery mtScroll No Touch                                                 */
/*   @ author  : tom@bitbenderz.com                                                       */
/*   @ version : 1.2.1                                                                    */
/*   @ updated : Jan, 2016                                                                */
/*   @ licnese : Dual licensed under ...                                                  */
/*               MIT (http://www.opensource.org/licenses/mit-license.php)                 */
/*               GPL (http://www.opensource.org/licenses/gpl-license.php)                 */
/*                                                                                        */
/* ************************************************************************************** */
(function(e){var t={init:function(t){this.each(function(){function M(){f.css({height:"auto",width:"auto"});if(f.height()!=c||f.width()!=l||u.width()!=r||u.height()!=i){r=u.width();i=u.height();a.width(r).height(i);l=f.width();f.css("width",l);c=f.height();h=i/c;p=r/l;w=Math.floor(i*h);if(h<1){y.height(w-parseInt(y.css("margin-bottom")));if(!n["hideBars"])y.stop(true,true).fadeIn(n["animationTime"]/2)}else{y.stop(true,true).fadeOut(n["animationTime"]/2)}x=Math.floor(r*p);if(p<1){E.width(x-T);if(!n["hideBars"])E.stop(true,true).fadeIn(n["animationTime"]/2)}else{E.stop(true,true).fadeOut(n["animationTime"]/2)}N=(i-c)/(i-w);C=(r-l)/(r-x);var e=parseInt(f.css("left"));if(e<r-l)e=r-l;if(e>0)e=0;var t=parseInt(f.css("top"));if(t<i-c)t=i-c;if(t>0)t=0;f.stop(true,false).animate({left:e,top:t},{duration:n["animationTime"]/2,queue:true});y.css("top",t/N);E.css("left",e/C);if(g){k=a.offset().top;L=a.offset().left;A=i-c;if(A>0)A=0;O=r-l;if(O>0)O=0;f.draggable({containment:[O+L,A+k,L,k]})}}}function _(e){if(e){if(window.addEventListener){window.addEventListener("DOMMouseScroll",D,false)}window.onmousewheel=document.onmousewheel=D}else{if(window.removeEventListener){window.removeEventListener("DOMMouseScroll",D)}window.onmousewheel=document.onmousewheel=null}}function D(e){var t=0;if(!e){e=window.event}if(e.wheelDelta){t=e.wheelDelta/120}else if(e.detail){t=-e.detail/3}if(t==0){return}if(h>=1){return}var r=parseInt(f.css("top"))+Math.floor(t*i/n["mouseSensitivity"]);if(r>0){r=0}if(r<i-c){r=i-c}f.stop(true,false).animate({top:r},{duration:n["animationTime"],queue:true,easing:n["easing"]});y.stop(true,false).animate({top:r/N},{duration:n["animationTime"],queue:true,easing:n["easing"]});if(e.preventDefault){e.preventDefault()}e.returnValue=false}function P(){var e=/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase());try{document.createEvent("TouchEvent");return true&&e}catch(t){return false&&e}}function H(e,t){if(e.style.getPropertyValue){return e.style.getPropertyValue(t)}else{return e.style.getAttribute(t)}}if(e(this).hasClass("mt-scroll"))return;e(this).addClass("mt-scroll");var n=e.extend({animationTime:500,barClass:"",vBarClass:"",hBarClass:"",mouseSensitivity:2,autoSize:true,hideBars:true,easing:"easeOutCubic"},t);var r=e(this).width();var i=e(this).height();var s=e(this).css("overflow");var o=e(this).css("float");var u=e(this).scrollTop(0).scrollLeft(0).css({overflow:"hidden"}).data({"prev-overflow":s,"prev-float":o});u.wrapInner('<div class="mt-scroll-holder" style="position: relative;"><div class="mt-scroll-content" style="position: absolute; top: 0; left: 0"></div></div>');var a=e(".mt-scroll-holder",u);var f=e(".mt-scroll-content",u);a.width(r).height(i);var l=f.width();f.css("width",l);var c=f.height();var h=i/c;var p=r/l;var d;var v;var m;var g=P();a.append('<div class="mt-scroll-vertical-bar '+n["barClass"]+" "+n["vBarClass"]+'"><ins></ins></div>');var y=e(".mt-scroll-vertical-bar",a);if(document.all&&document.documentMode<=8&&n["barClass"]==""&&n["vBarClass"]=="")y.css({background:"gray",marginBottom:"4px"});y.css({display:"block",position:"absolute",top:0,right:0});if(y.css("background-color")=="rgba(0, 0, 0, 0)"&&y.css("background-image")=="none")y.css("background-color","rgba(0, 0, 0, 0.3)");if(y.css("background-color")=="transparent"&&y.css("background-image")=="none")y.css("background-color","rgba(0, 0, 0, 0.3)");if(parseInt(y.css("width"))==0||y.css("width")=="auto")y.css({width:7,"border-radius":3,cursor:"default"});var b=y.width();var w=Math.floor(i*h);y.height(w-parseInt(y.css("margin-bottom")));if(h<1){if(n["hideBars"])y.delay(2*n["animationTime"]).fadeOut(n["animationTime"]/2)}else{y.hide()}a.append('<div class="mt-scroll-horizontal-bar '+n["barClass"]+" "+n["hBarClass"]+'"><ins></ins></div>');var E=e(".mt-scroll-horizontal-bar",a);E.css({display:"block",position:"absolute",bottom:0,left:0});if(E.css("background-color")=="rgba(0, 0, 0, 0)"&&E.css("background-image")=="none")E.css("background-color","rgba(0, 0, 0, 0.3)");if(E.css("background-color")=="transparent"&&E.css("background-image")=="none")E.css("background-color","rgba(0, 0, 0, 0.3)");if(parseInt(E.css("height"))==0||E.css("height")=="auto")E.css({height:7,"border-radius":3,cursor:"default"});var S=E.height();var x=Math.floor(r*p);var T=0;if(y){T=parseInt(E.css("margin-right"))+Math.ceil(b*1.2);E.css({"margin-right":T})}E.width(x-T);if(p<1){if(n["hideBars"])E.delay(2*n["animationTime"]).fadeOut(n["animationTime"]/2)}else{E.hide()}var N=(i-c)/(i-w);var C=(r-l)/(r-x);if(g){var k=a.offset().top;var L=a.offset().left;var A=i-c;if(A>0)A=0;var O=r-l;if(O>0)O=0;f.draggable({scrollSensitivity:40,containment:[O+L,A+k,L,k]}).bind("drag",function(){y.stop(true,true).css("top",parseInt(e(this).css("top"))/N);E.stop(true,true).css("left",parseInt(e(this).css("left"))/C)}).mousedown(function(){e(this).stop(true,false);var t=new Date;m=t.getTime();d=parseInt(e(this).css("top"));v=parseInt(e(this).css("left"));if(n["hideBars"]){if(h<1)y.stop(true,true).fadeIn(n["animationTime"]/2);if(p<1)E.stop(true,true).fadeIn(n["animationTime"]/2)}}).mouseup(function(){var t=new Date;var s=parseInt(e(this).css("top"));var o=parseInt(e(this).css("left"));var u=s+(s-d)*50/(t.getTime()-m);if(u<i-c)u=i-c;if(u>0)u=0;var a=o+(o-v)*50/(t.getTime()-m);if(a<r-l)a=r-l;if(a>0)a=0;e(this).stop(true,false).animate({top:u,left:a},n["animationTime"]);y.stop(true,true).animate({top:u/N},n["animationTime"]);E.stop(true,true).animate({left:a/C},n["animationTime"]);if(n["hideBars"]){y.fadeOut(n["animationTime"]);E.fadeOut(n["animationTime"])}})}else{y.draggable({containment:u,axis:"y"}).bind("drag",function(){f.css("top",parseInt(e(this).css("top"))*N)});E.draggable({containment:u,axis:"x"}).bind("drag",function(){f.css("left",parseInt(e(this).css("left"))*C)});u.hover(function(){if(n["hideBars"]){if(h<1){y.stop(true,true).css("opacity","").fadeIn(n["animationTime"]/4)}if(p<1){E.stop(true,true).css("opacity","").fadeIn(n["animationTime"]/4)}}_(true)},function(){if(n["hideBars"]){if(h<1){y.stop(true,true).fadeOut(n["animationTime"]/2)}if(p<1){E.stop(true,true).fadeOut(n["animationTime"]/2)}}_(false)})}if(n["autoSize"]){setInterval(function(){M()},240)}})},remove:function(){this.each(function(){var t=e(this);if(!t.hasClass("mt-scroll"))return;e(".mt-scroll-vertical-bar",t).remove();e(".mt-scroll-horizontal-bar",t).remove();var h = e(".mt-scroll-content",t).html();t.html(h).css({overflow:t.data("prev-overflow"),"float":t.data("prev-float")}).removeClass("mt-scroll")})}};e.fn.mtScroll=function(n){if(document.all&&typeof XDomainRequest=="undefined")return;if(t[n]){return t[n].apply(this,Array.prototype.slice.call(arguments,1))}else if(typeof n==="object"||!n){return t.init.apply(this,arguments)}else{e.error("Method "+n+" does not exist on jQuery.mtScroll")}}})(jQuery)

