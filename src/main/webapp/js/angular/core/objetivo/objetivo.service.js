angular.
  module('core.objetivo').
  factory('Objetivo', ['$resource',
    function($resource) {
      return $resource('objetivos/:idObjetivo', {idObjetivo: '@id'}, {
          update: {
            method: 'PUT'
          },
          addIndicadorAfectante: {
            method: 'POST',
            url: 'objetivos/:idObjetivo/indicadoresAfectantes'
          },
          deleteIndicadorAfectante: {
            method: 'PUT',
            url: 'objetivos/:idObjetivo/indicadoresAfectantes',
          },
          addObjetivoAfectante: {
            method: 'POST',
            url: 'objetivos/:idObjetivo/objetivosAfectantes'
          },
          deleteObjetivoAfectante: {
            method: 'PUT',
            url: 'objetivos/:idObjetivo/objetivosAfectantes',
          },
          getHistorico: {
            method: 'GET',
            url: 'objetivos/:idObjetivo/valoresHistoricos',
            isArray: true
          }
      });
    }
  ]);