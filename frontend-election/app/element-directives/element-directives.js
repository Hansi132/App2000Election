angular.module('element-directives', [])
    .directive('alert', function () {
    return {
        scope: {
            alertType: "@",
            text: "@"
        },
        link: alertError,
        restrict: 'E',
        templateUrl: 'element-directives/alert.html'
    }
    function alertError(scope, elem, attrs) {
        const close = document.getElementsByClassName("closebtn");
        let i;

        for (i = 0; i < close.length; i++) {
            close[i].onclick = function(){
                const div = this.parentElement;
                div.style.opacity = "0";
                setTimeout(function(){ div.style.display = "none"; }, 600);
            }
        }
    }
})