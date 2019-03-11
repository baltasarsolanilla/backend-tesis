'use strict',

angular.
    module('indicadoresPage').
        component('indicadoresPage', {
            templateUrl: 'js/angular/indicadores-page/indicadores-page.html',
            controller: function ObjetivosPageController($scope, Indicador){
                var controllerName = "INDICADOR-PAGE-CONTROLLER -> ";  
               
                this.$onInit = function(){
                    cargarIndicadores();
                }

                //AJAX
                function cargarIndicadores(){
                    Indicador.query(function(indicadores){
                      delete indicadores.$promise;
                      delete indicadores.$resolved;
                      $scope.indicadores = indicadores;
                    });
                }
            }
        });