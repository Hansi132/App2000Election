'use strict';

describe('myApp.home module', function() {

    beforeEach(module('myApp.home'));

    describe('home controller', function(){

        it('should ....', inject(function($controller) {
            //spec body
            var home = $controller('homeCtrl');
            expect(home).toBeDefined();
        }));
    });
});