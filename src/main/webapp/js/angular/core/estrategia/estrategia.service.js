angular.
  module('core.estrategia').
  factory('Estrategia', ['$resource',
    function($resource) {
      return $resource('estrategias/:idEstrategia', {idEstrategia: '@id'}, {
        update: {method: 'PUT'},
        addPerspectivaAfectante: {
            method: 'POST',
            url: 'estrategias/:idEstrategia/perspectivasAfectantes'
          },
          deletePerspectivaAfectante: {
            method: 'PUT',
            url: 'estrategias/:idEstrategia/perspectivasAfectantes',
          },
      });
    }
  ]);