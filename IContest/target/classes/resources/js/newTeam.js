function checkName()
{
    // var name = $("#name").val();
    // var reg_name = /^\w+$/;
    // var flag = reg_name.test(name)
    // if(!flag)
    // {
    //     alert("请输入队名");
    // }
    // return flag;

    if($("#name").val().length<1)
    {
        alert("请输入队名");
        return false;
    }
    else return true;
}

function checkType()
{
    if($("#type").val().length<1)
    {
        alert("请输入竞赛类型");
        return false;
    }
    else return true;
    // var name = $("#type").val();
    // var reg_name = /^\w+$/;
    // var flag = reg_name.test(name)
    // if(!flag)
    // {
    //     alert("请输入竞赛类型");
    // }
    // return flag;
}
function checkInfo()
{
    if($("#info").val().length<1)
    {
        alert("请输入队伍简介");
        return false;
    }
    else return true;
    // var name = $("#info").val();
    // var reg_name = /^\w+$/;
    // var flag = reg_name.test(name)
    // if(!flag)
    // {
    //     alert("请输入队伍简介");
    // }
    // return flag;
}


$(function (){
    $("#create").submit(function (){
        return checkName()&&checkType()&&checkInfo();
    });
});
