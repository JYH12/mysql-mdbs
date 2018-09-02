$(function(){
  $('#username').on('blur',function(event){
    if($('#username').val().length == 0) {
      $('.usernameInput').text("* 用户名由6-20位英文字母和数字组成").css({'color':'red', 'fontSize':'10px'}).show();
    }else if($('#username').val().length != 0 && !(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/.test($('#username').val()))){
      $('.usernameInput').text("* 用户名由6-20位英文字母和数字组成").css({'color':'red', 'fontSize':'10px'}).show();
    }else if($('#username').val().length != 0 && (/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/.test($('#username').val()))){
      $('.usernameInput').hide();
    }
  });
  $('#password').on('blur',function(event){
    if($('#password').val().length == 0) {
      $('.passwordInput').text("* 密码由字母数字特殊字符组成").css({'color':'red', 'fontSize':'10px'}).show();
    }else if($('#password').val().length != 0 && !(/^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/.test($('#password').val()))){
      $('.passwordInput').text("* 密码由字母数字特殊字符组成").css({'color':'red', 'fontSize':'10px'}).show();
    }else if($('#password').val().length != 0 && (/^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/.test($('#password').val()))){
      $('.passwordInput').hide();
    }
  });
  $('.btn').on('click',function(event){
     $.ajax({
         type: "POST",
         url:"http://192.168.1.103:8080/login",
         data: {
             "username": $("#username").val(),
             "password": $("#password").val()
         },
         dataType: "json",
         success: function(data){
             console.log(data.total);
             if(data.total>0){
                if ($('#remember-password').attr('checked')) {
                    var cookie = new rememberPassword();
                    cookie.cookieRemeber();
                }
                sessionStorage.setItem("username", $("#username").val());
                sessionStorage.setItem("total",data.total);
                sessionStorage.setItem("dbArray",JSON.stringify(data.rows));
                window.location="http://192.168.1.103:8080/backup/";
             }else{
                $('.usernameInput').text("* 用户名由6-20位英文字母和数字组成").css({'color':'red', 'fontSize':'10px'}).show();
             }
         }
     });
  });
  $('#remember-password').click(function () {
        if (!$('#remember-password').attr('checked')) {
            var cookie = new Rememberpassword();
            cookie.cookieDelete();
        }
    });
    //cookie记住密码
    var cookie = new Rememberpassword();
    cookie.cookieInit();
});
function Rememberpassword() {
  this.username = $('#username').val();
  this.password = $('#password').val();
  this.cookie;
  if(!!$.cookie('user')){
    this.cookie = eval($.cookie('user'));
  }else{
    $.cookie('user', '[]');
       this.cookie = eval($.cookie('user'));
  }
};
Rememberpassword.prototype={
  cookieInit: function() {
    var temp = this.cookie,
        username = this.username,
        start = false;
        if (temp.length > 0) {
            $.each(temp, function(i, item) {
                if (item.first == true) {
                    $('#username').val(item.username);
                    $('#password').val(item.password);
                    $('#remember-password').attr('checked', true)
                }
            });
        }
        $('#username').blur(function() {
            //检查是否存在该用户名,存在则赋值，不存在则不做任何操作
            $.each(temp, function(i, item) {
                if (item.username == $('#username').val()) {
                    $('#username').val(item.username);
                    $('#password').val(item.password);
                    $('#remember-password').attr('checked', true)
                    start = true;
                    return false;
                } else {
                    $('#password').val('');
                }
            });
        });
    },
    cookieRemeber: function() {
        var temp = this.cookie,
            username = this.username,
            password = this.password,
            start = false;
        //检测用户是否存在
        $.each(temp, function(i, item) {
            if (item.username == username) {
                //记录最后一次是谁登录的
                item.first = true;
                $('#password').val(item.password);
                start = true;
                return;
            } else {
                item.first = false;
            }
        });
        //不存在就把用户名及密码保存到cookie中
        if (!start) {
            temp.push({
                username: username,
                password: password,
                first: true
            });
        }
        //存储到cookie中
        $.cookie('user', JSON.stringify(temp));
    },
    cookieDelete: function() {
        var temp = this.cookie,
            username = this.username,
            num = 0;
        //检测用户是否存在
        $.each(temp, function(i, item) {
            if (item.username === username) {
                num = i;
            }
        });
        //删除里面的密码
        temp.splice(num, 1);
        //存储到cookie中
        $.cookie('user', JSON.stringify(temp));
    }
}
