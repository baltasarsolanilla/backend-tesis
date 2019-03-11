
angular.
module('diagramaHistorico').
component('diagramaHistorico', {
    bindings: {
        data: '<'              
    }, 
    templateUrl: 'js/angular/tablero-page/diagrama-historico/diagrama-historico.html',
    controller: function DiagramaHistoricoController($scope, Objetivo){
        $scope.labels = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"];
        $scope.series = ['MALO', 'REGULAR', 'BUENO', 'MUY BUENO', 'VALOR'];
        var umbralMalo = 2.50;
        var umbralRegular = 5.00;
        var umbralBueno = 7.50;
        var umbralMuyBueno = 10.00;
        $scope.data = [
            [2.50, 2.50, 2.50, 2.50, 2.50, 2.50],
            [5.00, 5.00, 5.00, 5.00, 5.00, 5.00],
            [7.50, 7.50, 7.50, 7.50, 7.50, 7.50],
            [10.00, 10.00, 10.00, 10.00, 10.00, 10.00],
            [2.00, 3.80, 6.20, 1.40, 7.30, 9.90],
        ];

        var valoresHistoricosFAKE = [
            {"valor":Math.random()*10,"fecha":"2018-12-01"}, 
            {"valor":Math.random()*10,"fecha":"2018-12-04"},
            {"valor":Math.random()*10,"fecha":"2018-12-07"},
            {"valor":Math.random()*10,"fecha":"2018-12-11"},
            {"valor":Math.random()*10,"fecha":"2018-12-13"},
            {"valor":Math.random()*10,"fecha":"2018-12-17"}
        ];
        

        var VERDE = '#91d202';
        var AMARILLO = '#f6d900';
        var NARANJA = '#FC8C28';
        var ROJO = '#eb4b25';
        var AZUL = '#36A2EB';
        $scope.colors = [ROJO, NARANJA, AMARILLO, VERDE, AZUL];
        
        $scope.options = {
            scales: {
                yAxes: [
                    {
                        type: 'linear',
                        display: true,
                        position: 'left',
                        ticks: {
                            beginAtZero: true
                        }
                    }
                ]
            }
        };

        var idObjetivo = -1;

        this.$onInit = function() {
            if ($scope.$ctrl.data != null){
                idObjetivo = data;
            }
        };

        this.$onChanges = function(changes){
            if (changes.data.currentValue){
                idObjetivo = changes.data.currentValue;
                var fechaDesde = getFechaHoyMenosSeisMeses();
                var fechaHasta = getFechaMañana();
                graficarFechaDesdeHasta(fechaDesde, fechaHasta);
            }
        };

        $scope.graficar = function(){
            if ($("#fechaDesdeInput").val() == ""){
                return;
            }
            if ($("#fechaHastaInput").val() == ""){
                return;
            }

            var fechaDesde = prepararFecha($("#fechaDesdeInput").val());
            var fechaHasta = prepararFecha($("#fechaHastaInput").val());
            graficarFechaDesdeHasta(fechaDesde, fechaHasta);

            return;
        };

        //Me llega: dd-mm-yyyy, devuelvo:ddmmyyyy
        function prepararFecha(fecha){
            var fechaFormateada = '';
            _.filter(fecha, function(caracter){
                if (caracter != '-'){
                    fechaFormateada+= caracter;
                }
                return;
            });
            
            //Parchisimo, para cuando la fecha es igual a HOY:
            var date = new Date();
            var dd = date.getDate(); //Incluyo HOY;
            var mm = date.getMonth()+1; //January is 0!
            if (mm < 10){mm = '0'+mm;}
            var yyyy = date.getFullYear();
            var fechaHoy = dd + "" + mm + "" +yyyy;
            if (fechaFormateada == fechaHoy){
                fechaFormateada = getFechaMañana();
            }
            //Fin parchisimo.
            
            return fechaFormateada;
        }
        
        function graficarFechaDesdeHasta(fechaDesde, fechaHasta){
            // console.log("Fecha desde:",fechaDesde);
            // console.log("Fecha hasta:",fechaHasta);
            if (idObjetivo != -2) {
                Objetivo.getHistorico({
                    idObjetivo: idObjetivo,
                    fromDate: fechaDesde,
                    toDate: fechaHasta
                }, function(valoresHistoricos){
                    prepararValores(valoresHistoricos);
                    // graficar();
                }, function (err) {
                    alert("Error al recuperar los valores históricos");
                });
            }
            else{
                //Le paso un arreglo vacio en caso de que se haya seleccionado una perspectiva.
                prepararValores([]);
            }
        }

        function prepararValores(valoresHistoricos){
            // console.log("Valores historicos recuperados: ", valoresHistoricos)
            var newLabels = [];
            var newData = [];
            var newUmbralesMalos = [];
            var newUmbralesRegulares = [];
            var newUmbralesBuenos = [];
            var newUmbralesMuyBuenos = [];

            //Si el arreglo es vacio -> se selecciono una perspectiva.
            if (valoresHistoricos.length == 0){
                newUmbralesMalos.push(umbralMalo);
                newUmbralesRegulares.push(umbralRegular);
                newUmbralesBuenos.push(umbralBueno); 
                newUmbralesMuyBuenos.push(umbralMuyBueno);
                $scope.data = [newUmbralesMalos, newUmbralesRegulares, newUmbralesBuenos, newUmbralesMuyBuenos];
                $scope.labels = [];
            } else{
                angular.forEach(valoresHistoricos, function(valor) {
                    newLabels.unshift(valor.fecha);
                    newData.unshift(valor.valor.toFixed(2));
                    newUmbralesMalos.push(umbralMalo);
                    newUmbralesRegulares.push(umbralRegular);
                    newUmbralesBuenos.push(umbralBueno); 
                    newUmbralesMuyBuenos.push(umbralMuyBueno);
                });
                
                $scope.data = [newUmbralesMalos, newUmbralesRegulares, newUmbralesBuenos, newUmbralesMuyBuenos, newData];
                $scope.labels = newLabels;
            }
           
        }

        // VER EL FORMATO -- la funcion backend no espera las barras '/'
        function getFechaMañana(){
            var tomorrow = new Date();
            tomorrow.setDate(tomorrow.getDate() + 1);
            var dd = tomorrow.getDate(); //Incluyo HOY;
            var mm = tomorrow.getMonth()+1; //January is 0!
            var yyyy = tomorrow.getFullYear();

            if(dd<10) {
                dd = '0'+dd;
            } 

            if(mm<10) {
                mm = '0'+mm;
            } 

            return dd + "" + mm + "" +yyyy;
        }

        // VER EL FORMATO -- la funcion backend no espera las barras '/'
        function getFechaHoyMenosSeisMeses(){
            var today = new Date();
            var  todayMenos6 = new Date(today);
            todayMenos6.setMonth(today.getMonth() - 6);
            todayMenos6.setDate(today.getDate() +1);
            var ddv = todayMenos6.getDate(); //Incluyo HOY
            var mmv = todayMenos6.getMonth()+1; //January is 0!
            var yyyyv = todayMenos6.getFullYear();

            if(ddv<10) {
                ddv = '0'+ddv;
            } 

            if(mmv<10) {
                mmv = '0'+mmv;
            } 

           return ddv + "" + mmv + "" + yyyyv;
        }
    }
});