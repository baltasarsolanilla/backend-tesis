'use strict',

angular.
    module('estrategiasPage').
        component('estrategiasPage', {
            templateUrl: 'js/angular/estrategias-page/estrategias-page.html',
            controller: function PerspectivasPageController($scope, $window, $uibModal, Estrategia, GlobalStorageFactory){
                
                // FuncIones de controler
                $scope.createEstrategia = createEstrategia;
                $scope.updateEstrategia = updateEstrategia;
                $scope.deleteEstrategia = deleteEstrategia;

                $scope.addPerspectivasAfectantes = addPerspectivasAfectantes;
                $scope.deletePerspectivasAfectantes = deletePerspectivasAfectantes;

                // Variables de controller
                var controllerName = "ESTRATEGIAS-PAGE-CONTROLLER ->";

                this.$onInit = function() {
                };

                //Watcher para sincronizar la estrategia seleccionada con la estrategia seleccionada en el menu lateral.
                $scope.$watch(function() { return GlobalStorageFactory.getEstrategia(); }, function(estrategiaSeleccionada) {
                    if (estrategiaSeleccionada != undefined) {
                        $scope.selectedEstrategia = estrategiaSeleccionada;
                    }
                });

                function createEstrategia(){
                    // $window.console.log(controllerName + "createEstrategia()");
                    var modalInstance = $uibModal.open({
                      animation: true,
                      component: 'modalCrearEstrategia'
                    });

                    modalInstance.result.then(function (est) {
                      Estrategia.save(est, function(estrategia_creada){
                          GlobalStorageFactory.setActualizarEstrategias(true);
                          GlobalStorageFactory.setAccion("CREATE");
                          alert("Estrategia creada exitosamente");
                      });
                    }, function () {
                    //   $window.console.log('modal-component dismissed at: ' + new Date());
                    });
                }

                //UPDATE OBJETIVO
                function updateEstrategia(){
                    var est = {
                        id: $scope.selectedEstrategia.id,
                        nombre: $scope.selectedEstrategia.nombre,
                        descripcion: $scope.selectedEstrategia.descripcion
                    };
                    var modalInstance = $uibModal.open({
                        animation: true,
                        component: 'modalModificarEstrategia',
                        resolve: {
                          est: function () {
                            return est;
                          }
                        }
                    });
  
                    modalInstance.result.then(function (est) {
                        Estrategia.update(est, function(estrategia_modificada){
                            alert("Estrategia modificada exitosamente");
                            GlobalStorageFactory.setActualizarEstrategias(true);
                            GlobalStorageFactory.setAccion("UPDATE");
                        });
                    }, function () {
                        // $window.console.log('modal-component dismissed at: ' + new Date());
                    });
                }

                function deleteEstrategia(){
                  Estrategia.delete({idEstrategia: $scope.selectedEstrategia.id}, function(response) {
                        alert("Estrategia eliminada exitosamente");
                        GlobalStorageFactory.setActualizarEstrategias(true);
                        GlobalStorageFactory.setAccion("DELETE");
                        // $window.location.reload();
                    });
                }


                //ADD PERSPECTIVA AFECTANTE
                function addPerspectivasAfectantes(perspectivas){
                    angular.forEach(perspectivas, function(i) {
                        // console.log(i);
                        addSinglePerspectivaAfectante(i);
                    });
                    GlobalStorageFactory.setActualizarEstrategias(true);
                    GlobalStorageFactory.setAccion("UPDATE");

                }

                function addSinglePerspectivaAfectante(perspectiva){
                    var pers = {
                        nombre: perspectiva.nombre,
                        descripcion: perspectiva.descripcion
                    };
                    Estrategia.addPerspectivaAfectante({idEstrategia: $scope.selectedEstrategia.id}, pers, function(response){
                        alert("Perspectiva afectante relacionado exitosamente");
                        // console.log(response);
                    });
                }

                function deletePerspectivasAfectantes(perspectivas){
                    angular.forEach(perspectivas, function(p) {
                        deleteSinglePerspectivaAfectante(p);
                    });
                    GlobalStorageFactory.setActualizarEstrategias(true);
                    GlobalStorageFactory.setAccion("UPDATE");
                }

                function deleteSinglePerspectivaAfectante(perspectiva){
                    var p = {
                        id: perspectiva.id,
                        nombre: perspectiva.nombre
                    };
                    Estrategia.deletePerspectivaAfectante({idEstrategia: $scope.selectedEstrategia.id}, p, function(response){
                        alert("Perspectiva afectante eliminado exitosamente");
                        // console.log(response);
                    });
                }
            }
        });

angular.
    module('estrategiasPage').
        component('modalCrearEstrategia', {
            templateUrl: '../angular/estrategias-page/estrategias-page-modals/crear-estrategia.modal.html',
            bindings: {
              // resolve: '<',
              close: '&',
              dismiss: '&'
            },
            controller: function ModalController($scope, $window) {
              var $ctrl = this;
              var controllerName = "ESTRATEGIAS-PAGE-MODAL -> ";
              $ctrl.$onInit = function () {
                // $window.console.log(controllerName + "onInit()");
                // $ctrl.items = $ctrl.resolve.items;
                // $ctrl.selected = {
                //   item: $ctrl.items[0]
                // };
              };

              $ctrl.estrategiaForm = {
                  nombre: "",
                  descripcion: ""
              };

              $ctrl.ok = function () {
                // $window.console.log(controllerName + "ok()");
                $ctrl.close({$value: $ctrl.estrategiaForm});
              };

              $ctrl.cancel = function () {
                $ctrl.dismiss({$value: 'cancel'});
              };
            }
});

angular.
    module('estrategiasPage').
        component('modalModificarEstrategia', {
            templateUrl: '../angular/estrategias-page/estrategias-page-modals/modificar-estrategia.modal.html',
            bindings: {
              resolve: '<',
              close: '&',
              dismiss: '&'
            },
            controller: function ($window) {
              var $ctrl = this;

              $ctrl.$onInit = function () {
                $ctrl.estrategiaForm = $ctrl.resolve.est;
              };

              $ctrl.estrategiaForm = {
                  nombre: "",
                  descripcion: ""
              };

              $ctrl.ok = function () {
                $ctrl.close({$value: $ctrl.estrategiaForm});
              };

              $ctrl.cancel = function () {
                $ctrl.dismiss({$value: 'cancel'});
              };
            }
    });