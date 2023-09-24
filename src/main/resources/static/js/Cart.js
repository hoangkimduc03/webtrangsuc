let host = "https://java6-ph28107-default-rtdb.firebaseio.com/";
const app = angular.module("app", []);
app.controller("cart-ctrl", function ($scope, $http) {
    alert("Xin chào bạn")
    $scope.cart = {
        items: [],
        add(id) {
            alert(id)
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(rest => {
                    rest.data.qty = 1;
                    this.items.push(rest.data);
                    this.saveToLocalStorage();
                })
            }
        },
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear() {
        },
        amt_of(item) {
        },
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
            // console.log(items);
        },
        loadFormLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }
    $scope.cart.loadFormLocalStorage();
    $scope.order = {
        createDate: new Date(),
        address: "",
        account: {username: $("#username").text().trim()},
        get orderDetails() {
            return $scope.cart.items.map(item => ({
                product: {id: item.id},
                price: item.price,
                quantity: item.qty
            }));
        },
        purchase() {
            alert("Đặt hàng");
            var order = angular.copy(this);
            $http.post("/rest/orders", order).then(resp => {
                alert("đặt hàng thành công");
                $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi");
                console.log(error);
            })
        }
    }

})