angular.
  module('core.perspectiva').
  factory('Perspectiva', ['$resource',
    function($resource) {
      return $resource('perspectivas/:idPerspectiva', {}, {
        addObjetivoAfectante: {
          method: 'POST',
          url: 'perspectivas/:idPerspectiva/objetivosAfectantes'
        },
        deleteObjetivoAfectante: {
          method: 'PUT',
          url: 'perspectivas/:idPerspectiva/objetivosAfectantes',
        },
      });
    }
  ]);