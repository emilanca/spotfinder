'use strict';

describe('Controller: SpotfinderCtrl', function () {

  // load the controller's module
  beforeEach(module('webappApp'));

  var SpotfinderCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SpotfinderCtrl = $controller('SpotfinderCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(SpotfinderCtrl.awesomeThings.length).toBe(3);
  });
});
