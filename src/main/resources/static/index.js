angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1';

    $scope.loadUsers = function () {
        $http.get(contextPath + '/users').then(function (response) {
            $scope.userList = response.data;
        });
    }

    $scope.deleteUser = function (id) {
        $http.delete(contextPath + '/users/' + id).then(function (response) {
            $scope.loadUsers();
        });
    }

    $scope.addUser = function () {
        $http.post(contextPath + '/users', $scope.user).then(function (response) {
            $scope.loadUsers();
        });
    }

    $scope.updateUser = function () {
        $http.put(contextPath + '/users/' + $scope.user.id, $scope.user).then(function (response) {
            $scope.loadUsers();
        })
    }

    $scope.loadUsers();
})