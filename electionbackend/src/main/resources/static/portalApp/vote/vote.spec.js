'use strict';

describe('myApp.vote module', function() {

    beforeEach(module('myApp.vote'));

    describe('vote controller', function(){

        it('should ....', inject(function($controller) {
            //spec body
            var voteCtrl = $controller('VoteCtrl');
            expect(voteCtrl).toBeDefined();
        }));
    });
});