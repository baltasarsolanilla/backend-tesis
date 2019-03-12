angular.
  module('core.indicador').
  factory('Indicador', ['$resource',
    function($resource) {
      return $resource('indicadores/:idIndicador', {}, {
        // query: {
        //   method: 'GET',
        //   isArray: true
        // }
      });
    }
  ]);