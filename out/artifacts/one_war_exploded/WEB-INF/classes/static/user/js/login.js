function checkLogin(){
    var login_name =$("#login_name").val();
	if("" == login_name){
        layer.alert("用户名不能为空！");
		return false;
	}
    var password =$("#password").val();
    if("" == password){
        layer.alert("登录密码不能为空！");
        return false;
    }
    $.ajax({
        url: context+"/login",
        type: "post",
        dataType:"text",
        data: {login_name:login_name,password:password},
        success:function(data){
            if(data == "SUCCESS"){
               // alert("验证成功！");
                window.location.href=context+"/deploy";
            }else{
                layer.alert("登录用户不存在！",function(){
                    window.location.reload();
                });

            }
        },
        error:function(){
            layer.alert("登陆错误！")
        }
    });
}
function defultLogin(){
    window.location.reload();
}