var cameraPic = "";
var cardPic = "";
$(function () {
    initFileInput();

    $("#camerabox").css("display", "none");
    $("#resultbox").css("display", "");


    // 发送验证码
/*    var codebtn = $("#codebtn");
    codebtn.click(function(){
        var email = $.trim($("#email").val());
        var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if(!reg.test(email)) {
            alert("邮箱地址格式不正确！");
            $("#email").focus();
            return false;
        }
        if($.trim(codebtn.val()) != "获取验证码") return false;
        $.post("UserServlet", {"op": "checkEmail", "email": email}, function(data){
        	data = parseInt($.trim(data));
        	if(data != 1){
                alert("该邮箱地址已被注册！");
                $("#email").focus();
                return false;
        	} else{
                var time = 60;
                codebtn.val("" + time + "秒后重试");
                $("#codebtn").attr("disabled", "disabled");
                var id = setInterval(function(){
                    time--;
                    if(time > 0){
                        codebtn.val("" + time + "秒后重试");
                    } else{
                        codebtn.val("获取验证码");
                        $("#codebtn").removeAttr("disabled");
                        clearInterval(id);
                    }
                }, 1000);
                $.post("RegisterServlet", {"op": "email", "address": email}, function(data){
                    data = parseInt($.trim(data));
                    if(data == 1){

                    } else{
                        alert("发送失败！");
                    }
                }, "text");
        	}
        }, "text");
    });*/

    // 提交表单
    $("#submit").click(function(){
        // 姓名
        var name = $.trim($("#name").val());
        if(name == ""){
            alert("姓名不能为空！");
            $("#name").focus();
            return false;
        }
        var sex = $.trim($("#sex").val());
        // 证件号码
        var cardid = $.trim($("#cardid").val());
        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        if(!reg.test(cardid)){
            alert("证件号码格式不正确！");
            $("#cardid").focus();
            return false;
        }
        // 确认号码
        var cardid_confirm = $.trim($("#cardid_confirm").val());
        if(cardid != cardid_confirm){
            alert("两次证件号码不一致！");
            $("#cardid_confirm").focus();
            return false;
        }
        // 密码
        var pwd = $.trim($("#pwd").val());
        var reg = /[0-9a-zA-Z]{6,12}/;
        if(!reg.test(pwd)){
            alert("密码格式不正确！");
            $("#pwd").focus();
            return false;
        }
        // 确认密码
        var pwd_confirm = $.trim($("#pwd_confirm").val());
        if(pwd != pwd_confirm){
            alert("两次密码不一致！");
            $("#pwd_confirm").focus();
            return false;
        }
        // 现居住地
        var province = $.trim($("#province").val());
        if(province == "请选择省份"){
            alert("请选择省份！");
            $("#province").focus();
            return false;
        }

        var city = $.trim($("#city").val());
        if(city == "请选择城市"){
            alert("请选择城市！");
            $("#city").focus();
            return false;
        }
        var area = $.trim($("#area").val());
        if(area == "请选择区县"){
            alert("请选择区县！");
            $("#area").focus();
            return false;
        }


        // 手机号码
        var tel = $.trim($("#tel").val());
        var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
        if(!reg.test(tel)){
            alert("手机号码格式不正确！");
            $("#tel").focus();
            return false;
        }
    });
});




function initFileInput() {
    var control = $("#cardfile");

    //初始化上传控件的样式
    control.fileinput({
        language: 'zh',                                     //设置语言
        uploadUrl: "UploadServlet",                         //上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png'],       //接收的文件后缀
        browseClass: "btn btn-primary",                     //按钮样式
        maxFileSize: 1024*10,                               //单位为kb，如果为0表示不限制文件大小
        maxFileCount: 1,                                    //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
    });

    //导入文件上传完成之后的事件
    control.on("fileuploaded", function (event, data, previewId, index) {
        var filepath = data.response.cardfile;
        console.info(filepath);
        cardPic = filepath;
    });
}

function initCamera() {
    var w = 320, h = 240;
    var pos = 0, ctx = null, saveCB, image = [];
    var canvas = document.createElement("canvas");
    canvas.setAttribute('width', w);
    canvas.setAttribute('height', h);
    console.log(canvas.toDataURL);
    if (canvas.toDataURL) {
        ctx = canvas.getContext("2d");
        image = ctx.getImageData(0, 0, w, h);
        saveCB = function (data) {
            var col = data.split(";");
            var img = image;
            for (var i = 0; i < w; i++) {
                var tmp = parseInt(col[i]);
                img.data[pos + 0] = (tmp >> 16) & 0xff;
                img.data[pos + 1] = (tmp >> 8) & 0xff;
                img.data[pos + 2] = tmp & 0xff;
                img.data[pos + 3] = 0xff;
                pos += 4;
            }
            if (pos >= 4 * w * h) {
                ctx.putImageData(img, 0, 0);
                $.post("uploadPhoto", { type: "data", image: canvas.toDataURL("image/png") }, function (msg) { 	// #######修改为servlet的url
                    console.log(msg);
                    pos = 0;
                    $("#img").attr("src", "../../" + msg);
                    cameraPic = msg;
                });
            }
        };
    } else {
        saveCB = function (data) {
            image.push(data);
            pos += 4 * w;
            if (pos >= 4 * w * h) {
                $.post("uploadPhoto", { type: "pixel", image: image.join('|') }, function (msg) { 				// #######修改为servlet的url
                    console.log(msg);
                    pos = 0;
                    $("#img").attr("src", "../../" + msg);
                    cameraPic = msg;
                });
            }
        };
    }
    $("#webcam").webcam({
        width: w,
        height: h,
        mode: "callback",
        swffile: "js/jscam_canvas_only.swf",
        onSave: saveCB,
        onCapture: function () {
            webcam.save();
        },
        debug: function (type, string) {
            console.log(type + ": " + string);
        }
    });
}

//拍照
function savePhoto() {		// #######保存时调用该方法即可
    webcam.capture();
}