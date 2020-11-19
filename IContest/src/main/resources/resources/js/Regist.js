
function checkUsername()
{
    if($("#username").val().length<1)
    {
        alert("请输入用户名");
        return false;
    }
    else return true;
}

function checkNickname()
{
    if($("#nickname").val().length<1)
    {
        alert("请输入昵称");
        return false;
    }
    else return true;
}

function checkPswd()
{
    if($("#Pswd").val().length<1)
    {
        alert("请输入密码");
        return false;
    }
    else return true;
}



function checkRepeatPswd()
{
    if($("#Pswd").val()!=$("#RepeatPswd").val())
    {
        alert("两次输入的密码不一致");
        return false;
    }
    else return true;
}

$(function (){
    $("#RegistForm").submit(function (){
        return checkRepeatPswd()&&checkUsername()&&checkNickname()&&checkPswd();
        });
    });
