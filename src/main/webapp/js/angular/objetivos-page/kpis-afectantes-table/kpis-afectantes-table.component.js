'use strict',

angular.
    module('kpisAfectantesTable').
        component('kpisAfectantesTable', {
            templateUrl: 'js/angular/objetivos-page/kpis-afectantes-table/kpis-afectantes-table.html',
            bindings: {
              addIndicadores: '&',
              deleteIndicadores: '&',
              data: '<'              
            },
            controller: function KPIsTableController($scope, NgTableParams, Indicador, BuilderTable){
              var controllerName = "KPI-TABLE-CONTROLLER -> ";

              //Lista de indicadoresAfectantes en caso de que no se seleccione un objetivo por default.
              $scope.indicadores = [
                {
                  indicador: {"id":1,"nombre":"Nombre 1"},
                  peso: 0.0
                },
                {
                  indicador: {"id":2,"nombre":"Nombre 2"},
                  peso: 0.0
                },
                {
                  indicador: {"id":3,"nombre":"Nombre 3"},
                  peso: 0.0
                }
              ];

              $scope.pesos = [{"id":1,"nombre":1.0},
                              {"id":2,"nombre":2.0},
                              {"id":3,"nombre":3.0},
                              {"id":3,"nombre":4.0},
                              {"id":3,"nombre":5.0}];

              
                // Funciones del controller
                $scope.add = add;
                $scope.del = del;
                $scope.hasChanges = hasChanges;
                $scope.cancelChanges = cancelChanges;
                $scope.saveChanges = saveChanges;
                
                $scope.onSelectKpi = onSelectKpi;
                $scope.onSelectPeso = onSelectPeso;
                pesoTotal = 0.0;

                //AJAX
                $scope.cargarIndicadores = cargarIndicadores;

                // Variables del controller
                $scope.indicadorSeleccionado = null;
                $scope.pesoSeleccionado = null;
                $scope.deleteCount = 0;
                var originalData = [];
                var listaIndicadoresEliminados = [];
                var listaIndicadoresAgregados = [];

                this.$onInit = function() {
                  cargarIndicadores();

                  //originalData = $scope.indicadores;
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

                //Esta funcion recarga el dataset con los indicadoresAfecantes del objetivo seleccionado
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
                  pesoTotal = BuilderTable.getPesoTotal(data);
                  $scope.tableParams.settings({
                    dataset: angular.copy(originalData)
                  });
                  $scope.tableParams.reload();
                }

                $scope.getPorcentaje = function(valor){
                  return (valor / pesoTotal) * 100;
                }
               
                //Carga el KPI seleccionado en el search-box.
                function onSelectKpi(value){
                  $scope.indicadorSeleccionado = value;
                }

                //Carga el PESO seleccionado en el search-box.
                function onSelectPeso(value){
                  $scope.pesoSeleccionado = value;
                }

                function add() {
                  if ($scope.tableParams.settings().dataset.findIndex(i => i.indicador.id === $scope.indicadorSeleccionado.id) > -1){
                    alert("Indicador afectante duplicado");
                    return;
                  }

                  $scope.isEditing = true;
                  $scope.isRowAdded = true;
                  var indicadorAgregado = {
                    indicador: $scope.indicadorSeleccionado,
                    peso: $scope.pesoSeleccionado.nombre
                  };
                  listaIndicadoresAgregados.push(indicadorAgregado);

                  pesoTotal += indicadorAgregado.peso;
                  $scope.tableParams.settings().dataset.push(indicadorAgregado);
                  // we need to ensure the user sees the new row we've just added.
                  // it seems a poor but reliable choice to remove sorting and move them to the first page
                  // where we know that our new item was added to
                  $scope.tableParams.sorting({});
                  $scope.tableParams.page(1);
                  $scope.tableParams.reload();
                }                
                
                function del(row) {
                  listaIndicadoresEliminados.push(row);
                  $scope.isRowDeleted = true;
                  _.remove($scope.tableParams.settings().dataset, function(item) {
                    return row.indicador.id === item.indicador.id;
                  });
                  $scope.deleteCount++;
                  pesoTotal -= row.peso;
                
                  //Refresco la tabla de indicadores afectantes
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
                  listaIndicadoresAgregados = [];
                  listaIndicadoresEliminados = [];
                }
            
                function cancelChanges() {
                  resetTableStatus();
                  pesoTotal = BuilderTable.getPesoTotal(originalData);
                  $scope.tableParams.settings({
                    dataset: angular.copy(originalData)
                  });
                }
            
                function saveChanges() {
                  if ($scope.deleteCount > 0)
                    $scope.$ctrl.deleteIndicadores({indicadores: listaIndicadoresEliminados});
                  if ($scope.isRowAdded)
                    $scope.$ctrl.addIndicadores({indicadores: listaIndicadoresAgregados});
                  
                  resetTableStatus();
                  //var currentPage = $scope.tableParams.page();
                  originalData = angular.copy($scope.tableParams.settings().dataset);
                  $scope.tableParams.reload();
                }

                //AJAX
                function cargarIndicadores(){
                  Indicador.query(function(indicadores){
                    delete indicadores.$promise;
                    delete indicadores.$resolved;
                    $scope.indicadores = indicadores;
                    // console.log($scope.indicadores);
                  });
                }
                
            }
        });
