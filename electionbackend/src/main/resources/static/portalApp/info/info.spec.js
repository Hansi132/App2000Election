'use strict';

describe('myApp.info module', function() {

    beforeEach(module('myApp.info'));

    describe('info controller', function(){

        it('should ....', inject(function($controller) {
            //spec body
            var home = $controller('infoCtrl');
            expect(home).toBeDefined();
        }));
    });
});