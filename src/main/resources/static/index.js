$(document).ready(function () {
    $(".front-page-link").mouseover(function(){
        $(this).css("padding", "1.2em 0.2em")
    })
});

$(document).ready(function () {
    $(".front-page-link").mouseout(function(){
        $(this).css("padding", "1em 0")
    })
});


var LanguageList = {
  "EN" : "English",
  "EE" : "Eesti",
};

//languages Objects
var WORDS_EN = {
    "text1" : "Welcome to the best Runescape Private Server!",
    "register" : "Register",
    "email" : "Email",
    "password" : "Password",
    "repeatpassword" : "Repeat Password",
    "alreadyhave" : "Already have an account?",
    "download" : "Download",
    "forums" : "Forums"
    
};

var WORDS_EE = {
    "text1" : "Tere tulemast kõige paremasse Runescape'i privaatserverisse!",
    "register" : "Registreeru",
    "email" : "Email",
    "password" : "Parool",
    "repeatpassword": "Korda parooli",
    "alreadyhave" : "Kasutaja juba olemas?",
    "download" : "Lae alla",
    "forums" : "Foorumid"
    
};



window.onload = initialize;

function initialize() {

  var $dropdown = $("#country_select");    
  $.each(LanguageList, function(key, value) {
    $dropdown.
      append($("<option/>").
      val(key).
      text(value));
    });
    
  loadsLanguage("EN");
}

function loadsLanguage(lang){
  /*fills all the span tags with class=lang pattern*/ 
  $('span[class^="lang"]').each(function(){
    var LangVar = (this.className).replace('lang-','');
    var Text = window["WORDS_"+lang][LangVar];
    $(this).text(Text);        
  });
}