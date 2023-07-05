function check(form){
    var reg= /^s*|s*$/g;
    if(form.username.value.replace(reg,'')=="")
        {
        alert("请输入用户名");
        form.username.focus(); 
        return falue;
        }
    else if(form.password.value.replace(reg,'')=="")
        {
         alert("请输入密码");
         form.password.focus();
         return falue;
        }
    else if(form.password2.value.replace(reg,'')==''){
        alert("请确认密码");
        form.password2.focus();
        return falue;
    }
    else{
        return true;
    }
}