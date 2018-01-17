/**
 * Created by 01368080 on 2018/1/17.
 */
// angular.module('hello',[])
//     .controller('home', function ($scope) {
//         $scope.greeting={id:'xxx',content:'hello world!'}
//     })

angular.module('hello',[])
    .controller('home', function ($scope, $http) {
        $http.get('/resource/').success(function(data){
            debugger;
            $scope.greeting = data;
        })
    })

