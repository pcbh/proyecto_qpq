/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
                //ARRAYS DE PROVINCIAS
                var Andalucia = [
                    {display: "Almeria", value: "Almería"},
                    {display: "Cadiz", value: "Cadiz"},
                    {display: "Cordoba", value: "Córdoba"},
                    {display: "Granada", value: "Granada"},
                    {display: "Huelva", value: "Huelva"},
                    {display: "Jaen", value: "Jaén"},
                    {display: "Malaga", value: "Málaga"},
                    {display: "Sevilla", value: "Sevilla"}
                ];
                var Aragon = [
                    {display: "Huesca", value: "Huesca"},
                    {display: "Teruel", value: "Teruel"},
                    {display: "Zaragoza", value: "Zaragoza"}
                ];
                var Asturias = [
                    {display: "Asturias", value: "Asturias"}
                ];
                var Islas_Baleares = [
                    {display: "Islas Baleares", value: "Islas Baleares"}
                ];
                var Islas_Canarias = [
                    {display: "Las Palmas de Gran Canaria", value: "Las Palmas de Gran Canaria"},
                    {display: "Santa Cruz de Tenerife", value: "Santa Cruz de Tenerife"}                    
                ];
                var Cantabria = [
                    {display: "Cantabria", value: "Cantabria"}                   
                ];
                var Castilla_la_mancha = [
                    {display: "Albacete", value: "Albacete"},
                    {display: "Ciudad Real", value: "Ciudad Real"},
                    {display: "Cuenca", value: "Cuenca"},
                    {display: "Guadalajara", value: "Guadalajara"},
                    {display: "Toledo", value: "Toledo"}
                ];
                var Castilla_leon = [
                    {display: "Avila", value: "Ávila"},
                    {display: "Burgos", value: "Burgos"},
                    {display: "Leon", value: "León"},
                    {display: "Palencia", value: "Palencia"},
                    {display: "Salamanca", value: "Salamanca"},
                    {display: "Segovia", value: "Segovia"},
                    {display: "Soria", value: "Soria"},
                    {display: "Valladolid", value: "Valladolid"},
                    {display: "Zamora", value: "Zamora"}
                ];
                var Catalunya = [
                    {display: "Barcelona", value: "Barcelona"},
                    {display: "Gerona", value: "Gerona"},
                    {display: "Lerida", value: "Lérida"},
                    {display: "Tarragona", value: "Tarragona"}
                ];
                var Comunidad_valenciana = [
                    {display: "Alicante", value: "Alicante"},
                    {display: "Castellon", value: "Castellón"},
                    {display: "Valencia", value: "Valencia"}
                ];
                var Extremadura = [
                    {display: "Badajoz", value: "Badajoz"},
                    {display: "Caceres", value: "Cáceres"}
                ];
                var Galicia = [
                    {display: "La Coruña", value: "Alicante"},
                    {display: "Lugo", value: "Castellón"},
                    {display: "Orense", value: "Valencia"},
                    {display: "Pontevedra", value: "Pontevedra"}
                ];
                var La_rioja = [
                    {display: "La Rioja", value: "La Rioja"}
                ];
                var Madrid = [
                    {display: "Madrid", value: "Madrid"}                    
                ];
                var Murcia = [
                    {display: "Murcia", value: "Murcia"}
                ];
                var Navarra = [
                    {display: "Navarra", value: "Navarra"}
                ];
                var País_vasco = [
                    {display: "Alava", value: "Álava"},
                    {display: "Guipuzcoa", value: "Guipúzcoa"},
                    {display: "Vizcaya", value: "Vizcaya"}
                ];
                var Ceuta = [
                    {display: "Ceuta", value: "Ceuta"}
                ];
                var Melilla = [
                    {display: "Melilla", value: "Melilla"}
                ];                
                
                
                
                $("#parent_selection").change(function() {
                    var parent = $(this).val();
                    switch(parent){
                        case 'Andalucia':
                            list(Andalucia);
                            break;
                        case 'Aragon':
                            list(Aragon);
                            break;
                        case 'Asturias':
                            list(Asturias);
                            break;
                        case 'Islas_Baleares':
                            list(Islas_Baleares);
                            break;
                        case 'Islas_Canarias':
                            list(Islas_Canarias);
                            break;
                        case 'Cantabria':
                            list(Cantabria);
                            break;
                        case 'Castilla_la_mancha':
                            list(Castilla_la_mancha);
                            break;
                        case 'Castilla_leon':
                            list(Castilla_leon);
                            break;
                        case 'Catalunya':
                            list(Catalunya);
                            break;
                        case 'Comunidad_valenciana':
                            list(Comunidad_valenciana);
                            break;
                        case 'Extremadura':
                            list(Extremadura);
                            break;
                        case 'Galicia':
                            list(Galicia);
                            break;
                        case 'La_rioja':
                            list(La_rioja);
                            break;
                        case 'Madrid':
                            list(Madrid);
                            break;
                        case 'Murcia':
                            list(Murcia);
                            break;
                        case 'Navarra':
                            list(Navarra);
                            break;
                        case 'Pais_vasco':
                            list(Pais_vasco);
                            break;
                        case 'Ceuta':
                            list(Ceuta);
                            break;
                        case 'Melilla':
                            list(Melilla);
                            break;
                        default: 
                            $("#child_selection").html('');
                            break;
                    }
                });
                
                function list(array_list) {
                    $("#child_selection").html(""); //reset child options
                    $(array_list).each(function (i) { //populate child options 
                        $("#child_selection").append("<option value=\""+array_list[i].value+"\">"+array_list[i].display+"</option>");
                    });
                }
                //DIV ID=SEPARADORDECONTENEDORES
                $(".contenedorDeTareas").mouseover(function(){
                    $(this).addClass("selected");
                });
                $(".contenedorDeTareas").mouseout(function(){
                    $(this).removeClass("selected");
                });
                $(this).find(".contenedorDeTareas .slidewrapper ul li a").each(function(n){
                    $(this).mouseover(function(){
                        $(this).children("span").show();
                    });
                    $(this).mouseout(function(){
                        $(this).children("span").hide();
                        $(this).children("span.selected").show();
                    });
                    $(this).click(function(){
                        removeSelected();
                        $(this).children("span").toggleClass("selected");
                        $(this).children("span.selected").show();
                        $("#escondidaTarea").val($(this).attr("id").replace("Categoria",""));

                    });                                                
                });
                $(this).find("#ul1").each(function(n){                                                
                    var hijos = $(this).children("li").length;                         
                    hijos = hijos*(parseInt($("#ul1 li").css("width"))+parseInt($("#ul1 li").css("margin-right")));
                    $(this).width(hijos);
                });
                $("#previo").click(function(){
                    var prueba2 = parseInt($(this).next("div").children("ul").css("margin-left"));       

                    var mar2 = prueba2 + parseInt($("#ul1 li").css("width"))+parseInt($("#ul1 li").css("margin-right"));
                    alert(prueba2);
                    if (prueba2 !== 0) {
                        alert("ENTRA");
                        $(this).next("div").children("ul").css("margin-left",mar2);
                    }
                });
                $("#siguiente").click(function(){
                    var prueba2 = parseInt($(this).next("div").children("ul").css("margin-left"));   
                    var mar2 = prueba2 + parseInt($("#ul1 li").css("width"))-parseInt($("#ul1 li").css("margin-right"));
                    var positions = $("#ul1").children("li").length;
                    var compare1=Math.abs(prueba2) + (5*(parseInt($("#ul1 li").css("width"))-parseInt($("#ul1 li").css("margin-right"))))-50;

                    var compare2=positions*(parseInt($("#ul1 li").css("width"))- parseInt($("#ul1 li").css("margin-right")));                                                
                    if (compare1 !== compare2) {
                        $(this).prev("div").children("ul").css("margin-left",mar2);
                    }
                });
                var removeSelected = function(){
                    $("#ul1 li a").each(function(){
                        $(this).mouseout();
                        $(this).children("span").removeClass("selected");
                        $(this).children("span").hide();
                    });
                };
                //DIV CLASS=COL
                $("#ul1 li a").each(function(){
                    $(this).click(function(){
                        hideAllSubacategories();
                        var subCategoriaCont = $(this).attr("id").replace("Categoria","subCategoria");
                        $("#" + subCategoriaCont).show();
                    });
                });
                function hideAllSubacategories() {
                    $("#ul1 li a").each(function(){
                    $("#" + $(this).attr("id").replace("Categoria","subCategoria")).hide();
                    });                                                    
                };
                $("#ul1 li a").first().click();
                //DIV ID=APARTADRESS
                $("#changeLocationDiv").show();
                //\DIV CHANGELOCATIONIDV
                $("#TaskLocationWithLocationDivGroup").append($("#TaskLocationWithLocationDivGroupContent"));
                $("#TaskLOCATIONTYPEWITHOUTLOCATION").click(function() {
                    if ($("#TaskLOCATIONTYPEWITHOUTLOCATION").prop("checked")) {
                            $("#TaskLocationWithLocationDiv").hide();
                    }
                });
                $("#TaskLOCATIONTYPEWITHLOCATION").click(function() {
                    if ($("#TaskLOCATIONTYPEWITHLOCATION").prop("checked")) {
                            $("#TaskLocationWithLocationDiv").show();
                    }
                });
                
                //\DIV APART_WHEN
                $("#ImplementationDeadLineByTimeDivGroup").append($("#ImplementationDeadLineAnyTimeDivGroupContent"));
                $("#editImplementationDeadLineLink").click(function() {
                    $("#changeImplementationDeadLineDiv").show();
                    $("#selectedImplementationDeadLineDiv").hide();
                });
                
                //SPAN CLASS=HELP
                $("#TaskAMOUNT").keypress(function(event) {
                        onlyFloat(event);
                });

                $("#TaskAMOUNT").blur(function() {
                        $(this).val($(this).val().replace(",","."));
                });
                
                 //\DIV id=closedvisibility
                 $("#TaskAbierta").click(function() {
                    if ($("#TaskAbierta").prop("checked")) {
                        if($("#TaskCerrada").prop("checked"))
                            $("#TaskCerrada").prop("checked", "");
                    }
                });
                $("#TaskCerrada").click(function() {
                    if ($("#TaskCerrada").prop("checked")) {
                        if($("#TaskAbierta").prop("checked"))
                            $("#TaskAbierta").prop("checked","");
                    }
                });
                 
                    
            });
            
            