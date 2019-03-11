'use strict',

angular.
    module('objetivosAfectantesTable').
        component('objetivosAfectantesTable', {
            templateUrl: 'js/angular/objetivos-page/objetivos-afectantes-table/objetivos-afectantes-table.html',
            bindings: {
              addObjetivos: '&',
              deleteObjetivos: '&',
              data: '<',
              objetivos: '<',
              objetivoAfectadoId: '<'             
            },
            controller: function ObjetivosAfectantesTableController($scope, NgTableParams){
              var controllerName = "OBJETIVOS-AFECTANTES-TABLE-CONTROLLER -> ";

              //Lista de ObjetivosAfectantes en caso de que no se seleccione un objetivo por default.
              $scope.objetivosAfectantes = [
                {
                  objetivoAfectante: {"id":1,"nombre":"Nombre 1"},
                },
                {
                  objetivoAfectante: {"id":2,"nombre":"Nombre 2"},
                },
                {
                  objetivoAfectante: {"id":3,"nombre":"Nombre 3"},
                }
              ];

              // Funciones del controller
              $scope.add = add;
              $scope.del = del;
              $scope.hasChanges = hasChanges;
              $scope.cancelChanges = cancelChanges;
              $scope.saveChanges = saveChanges;

              $scope.onSelectObjetivo = onSelectObjetivo;

              // Variables del controller
              $scope.objetivoSeleccionado = null;
              $scope.deleteCount = 0;
              var originalData = [];
              var listaObjetivosEliminados = [];
              var listaObjetivosAgregados = [];

              this.$onInit = function() {
                //originalData = $scope.objetivosAfectantes;
                if ($scope.$ctrl.data == undefined)
                  originalData = [];
                $scope.tableParams = new NgTableParams({
                  page: 1, // show first page
                  count: 10 // count per page
                  }, {
                  counts: [],
                  dataset: angular.copy(originalData)
                });

              };

              this.$onChanges = function(changes){
                if (changes.data){
                  if (changes.data.currentValue){
                    changeDataTable(changes.data.currentValue);
                  }
                  else{
                    changeDataTable([]);
                  }
                }
              };

              //Esta funcion recarga el dataset con los objetivosAfecantes del objetivo seleccionado
              function changeDataTable(data){
                if ($scope.tableParams == undefined){
                  $scope.tableParams = new NgTableParams({
                    page: 1, // show first page
                    count: 10 // count per page
                    }, {
                    counts: [],
                    dataset: angular.copy(originalData)
                  });
                }
                
                originalData = data;
                $scope.tableParams.settings({
                  dataset: angular.copy(originalData)
                });
                $scope.tableParams.reload();
              }

              //Carga el OBJETIVO seleccionado en el search-box.
              function onSelectObjetivo(value){
                $scope.objetivoSeleccionado = value;
              }

              function add() {
                if ($scope.tableParams.settings().dataset.findIndex(i => i.objetivoAfectante.id === $scope.objetivoSeleccionado.id) > -1 ){
                  alert("Objetivo afectante duplicado");
                  return;
                }

                if ($scope.$ctrl.objetivoAfectadoId === $scope.objetivoSeleccionado.id){
                  alert("Objetivo afectante igual a objetivo principal seleccionado");
                  return;
                }

                if ($scope.objetivoSeleccionado.objetivosAfectantes.findIndex(i => i.objetivoAfectante.id === $scope.$ctrl.objetivoAfectadoId) > -1 ){
                  alert("Ya existe una relación de afección entre el objetivo " + $scope.objetivoSeleccionado.nombre + " y el objetivo principal seleccionado");
                  return;
                }

                $scope.isEditing = true;
                $scope.isRowAdded = true;
                
                var objetivoAgregado = {
                  objetivoAfectante: $scope.objetivoSeleccionado
                };
                listaObjetivosAgregados.push(objetivoAgregado);

                $scope.tableParams.settings().dataset.push(objetivoAgregado);
                // we need to ensure the user sees the new row we've just added.
                // it seems a poor but reliable choice to remove sorting and move them to the first page
                // where we know that our new item was added to
                $scope.tableParams.sorting({});
                $scope.tableParams.page(1);
                $scope.tableParams.reload();
              }                

              function del(row) {
                listaObjetivosEliminados.push(row);
                $scope.isRowDeleted = true;
                _.remove($scope.tableParams.settings().dataset, function(item) {
                  return row.objetivoAfectante.id === item.objetivoAfectante.id;
                });
                $scope.deleteCount++;
                
                //Refresco la tabla de objetivos afectantes
                $scope.tableParams.reload().then(function(data) {
                  if (data.length === 0 && $scope.tableParams.total() > 0) {
                    $scope.tableParams.page($scope.tableParams.page() - 1);
                    $scope.tableParams.reload();
                  }
                });
              }
          
              function hasChanges() {
                return $scope.deleteCount > 0 || $scope.isRowAdded;
              }
          
              function resetTableStatus() {
                $scope.isEditing = false;
                $scope.isRowAdded = false;
                $scope.deleteCount = 0;
                listaObjetivosAgregados = [];
                listaObjetivosEliminados = [];
              }

              function cancelChanges() {
                resetTableStatus();
                var currentPage = $scope.tableParams.page();
                $scope.tableParams.settings({
                  dataset: angular.copy(originalData)
                });
              }

              function saveChanges() {
                if ($scope.deleteCount > 0)
                  $scope.$ctrl.deleteObjetivos({objetivos: listaObjetivosEliminados});
                if ($scope.isRowAdded)
                  $scope.$ctrl.addObjetivos({objetivos: listaObjetivosAgregados});
                
                resetTableStatus();
                //var currentPage = $scope.tableParams.page();
                originalData = angular.copy($scope.tableParams.settings().dataset);
                $scope.tableParams.reload();
              }
          }
      });
