// 退出登录
function signOut() {
    layer.open({
        content: "确定退出登录？",
        btn: ['确定', '取消'],
        yes: function () {
            location.href = 'login.html'
        }
    });
}