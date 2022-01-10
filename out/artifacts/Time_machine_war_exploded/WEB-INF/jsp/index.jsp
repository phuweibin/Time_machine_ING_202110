<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="../js/json2.js"></script>
    <title>index</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #container{height:100%}
    </style>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=3.0&ak=ow10CzGI9ow4g38An0DAu9LGjVQrXuA8">
    </script>
    <script src="/Time_machine/js/BMapLib_RichMarker.js"></script>

</head>

<body>
<div>
    <div id="head">
        <div id="logo">
            <img src="../images/logo.jpg" alt="logo"/>
        </div>
        <div id="userinfo" align="right">
            <div v-if="user.id!=''">
            </div>
            <div v-else>
                <a href="/Time_machine/pages/login.html">登录</a>
                <a href="/Time_machine/pages/registry.html">注册</a>
            </div>
        </div>
    </div>
    <div id="map" style="position: relative;width: 80%; height: 650px;margin-left: 10%">
        <div id="container">
        </div>
    </div>
    <div id="foot">
        <p align="center">time_machine</p><p align="center">copy right reserved</p>
    </div>
</div>

</body>
</html>
<script type="text/javascript">

    var vue = new Vue({
        el:"#head",
        data:{
            user:{
                id:"",
                userName:"",
                passwordMD5:"",
                location:"",
                longitude:"",
                latitude:"",
                userType:"",
                email:"",
                phoneNumber:"",
                gender:"",
            },
            isLocationAllowed:false,
        },
        methods:{
            logout:function (){

            }
        }
    });


    let sessionUser = window.sessionStorage.getItem("user");
    console.log(sessionUser);


    let map = new BMap.Map("container");
    // 创建地图实例
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.addControl(new BMap.MapTypeControl());
    map.setCurrentCity("南京"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用

    //用户定位
    function userLocation(){
        let allowedLocation = confirm("是否网页获取您的定位？");
        if(allowedLocation){
            vue.isLocationAllowed = true;
            let geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(
                function(position){//获取地理位置成功时所做的处理
                    if(this.getStatus() == BMAP_STATUS_SUCCESS){
                        let point = position.point;
                        let marker = new BMap.Marker(point);        // 创建标注
                        map.addOverlay(marker);                     // 将标注添加到地图中
                    }
                    else {
                        alert("定位失败，使用默认定位（南京理工大学）。");
                        let point = new BMap.Point(118.863318,32.028845);//南京理工大学
                        // 创建点坐标
                        map.centerAndZoom(point, 16);
                        // 初始化地图，设置中心点坐标和地图级别
                    }
                },
                function(error){//获取地理位置信息失败时所做的处理
                }
            );
        }else{
            vue.isLocationAllowed = false;
            alert("您拒绝了定位，使用默认定位（南京理工大学）。");
            let point = new BMap.Point(118.863318,32.028845);//南京理工大学
            // 创建点坐标
            map.centerAndZoom(point, 16);
            // 初始化地图，设置中心点坐标和地图级别
        }
    }
    userLocation();


    //添加事件
    var geoc = new BMap.Geocoder();
    map.addEventListener("click", function(e) {
        //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
        var pt = e.point;
        geoc.getLocation(pt, function (rs) {
            //addressComponents对象可以获取到详细的地址信息
            var addComp = rs.addressComponents;
            var site = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
            var longitude = pt.lng;
            var latitude = pt.lat;
            console.log("site:" + site);
            console.log("longitude:" + longitude);
            console.log("latitude:" + latitude);
        });
    });



</script>