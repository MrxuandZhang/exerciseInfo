function getXmlHttp() {
    var xmlHttp=null;
    if (window.ActiveXObject){
        try {
            xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
        }catch (e) {
            xmlHttp=new ActiveXObject("microsoft.XMLHTTP");
        }
    }else if (window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
    }else{
        alert("请您更换浏览器！")
    }
    return xmlHttp;
}
function toAjax(url,fun) {
    var xmlHttp=getXmlHttp();
    xmlHttp.onreadystatechange=function (){
        if (xmlHttp.readyState==4 && xmlHttp.status==200){
            var str=xmlHttp.responseText;
            fun(str);
        }
    }
    xmlHttp.open("get",url,true);
    xmlHttp.send();
}