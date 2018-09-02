$(function(){
  var i,username,dbName,total;
  username = sessionStorage.getItem("username");
  total =JSON.parse( sessionStorage.getItem("total"));
  $(".userName").text(username);
  (function(){
    dbName = JSON.parse(sessionStorage.getItem("dbArray"));
    var $BD = $(".dbOption");
    for(i=0; i<total; i++){
      (function(){
        var $html = $('<option value='+ dbName[i].instanceName + '>'+ dbName[i].instanceName +'</option>');
        $BD.append($html);
      })(i);
    }
  })();
  $('.datetimepicker1').datepicker({
    language: 'zh-CN',
    calendarWeeks: true,
    format: 'yyyy-mm-dd'
  });
  (function(){
    var $selectionFirst = $('#selected-first'),
        $selectionSecond = $('#selected-second'),
        $selectionThird = $('#selected-third'),
        $selectionForth = $('#selected-forth'),
        $selectionFifth = $('#selected-fifth');
    for(i=0; i<24; i++){
      (function(){
        var $html = $('<option value='+ i +'>'+ i +'</option>');
        $selectionFirst.append($html);
      })(i);
    }
    for(i=0; i<24; i++){
      (function(){
        var $html = $('<option value='+ i +'>'+ i +'</option>');
        $selectionThird.append($html);
      })(i);
    }
    for(i=0; i<60; i++){
      (function(){
        var $html = $('<option value='+ i +'>'+ i +'</option>');
        $selectionSecond.append($html);
      })(i);
    }
    for(i=0; i<60; i++){
      (function(){
        var $html = $('<option value='+ i +'>'+ i +'</option>');
        $selectionForth.append($html);
      })(i);
    }
    for(i=0; i<60; i++){
      (function(){
        var $html = $('<option value='+ i +'>'+ i +'</option>');
        $selectionFifth.append($html);
      })(i);
    }
  })();
});
var $Li = $('.main-li'),
    $select_value = $(".main-div-select-third");
$Li.click(function(){
  if($(this).find('img').attr('src') == 'img/recover1.png'){
    $(this).find('img').attr('src','img/recover2.png');
    $(".img-second").attr("src","img/date1.png");
    $(".img-third").attr("src","img/example1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/recover2.png'){
    $(this).find('img').attr('src','img/recover1.png');
    $(".img-second").attr("src","img/date1.png");
    $(".img-third").attr("src","img/example1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/date1.png'){
    $(this).find('img').attr('src','img/date2.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-third").attr("src","img/example1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/date2.png'){
    $(this).find('img').attr('src','img/date1.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-third").attr("src","img/example1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/example1.png'){
    $(this).find('img').attr('src','img/example2.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-second").attr("src","img/date1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/example2.png'){
    $(this).find('img').attr('src','img/example1.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-second").attr("src","img/date1.png");
    $(".img-forth").attr("src","img/install1.png");
  }else if($(this).find('img').attr('src') == 'img/install1.png'){
    $(this).find('img').attr('src','img/install2.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-second").attr("src","img/date1.png");
    $(".img-third").attr("src","img/example1.png");
  }else if($(this).find('img').attr('src') == 'img/install2.png'){
    $(this).find('img').attr('src','img/install1.png');
    $(".img-first").attr("src","img/recover2.png");
    $(".img-second").attr("src","img/date1.png");
    $(".img-third").attr("src","img/example1.png");
  }
  $(this).addClass("main-left-click")
         .siblings().removeClass("main-left-click");
  var index = $Li.index(this);
  $(".main-div").eq(index).show()
               .siblings().hide();
});
$('.radioSelect').on('click',function(event){
  if($(this).text() == "单库备份"){
    $(".input-group").show();
    $(".span-first").hide();
    $(".span-second").show();
  }else if($(this).text() == "实例备份"){
    $(".input-group").hide();
    $(".span-first").show();
    $(".span-second").hide();
  }
});
$select_value.change(function(event){
  if($select_value.val() == 1){
    $(".Radio").show();
    if($(".radioSelect_second").find("img").attr("src") == "img/selected.png"){
      $(".input-group").show();
      $(".span-first").hide();
      $(".span-second").show();
     }else if ($(".radioSelect_first").find("img").attr("src") == "img/selected.png") {
       $(".Radio").show();
       $(".input-group").hide();
       $(".span-first").show();
       $(".span-second").hide();
     }
   }else if($select_value.val() == 0){
     $(".Radio").hide();
     $(".input-group").hide();
     $(".span-first").show();
     $(".span-second").hide();
   }
});
$(".radioSelect").click(function(event){
  if($(this).find("img").attr("src") == "img/unselected.png"){
    $(this).find("img").attr("src", "img/selected.png")
    .parent().siblings().find("img").attr("src", "img/unselected.png");
  }
});
$(".first-btn").click(function(event){
  var $selected_value = $(".dbOption").val(),
      $timeFrom = $(".timeFrom").val(),
      $timeTo = $(".timeTo").val(),
      $instanceId;
  if($selected_value == "请选择你的实例"){
    $(".database-select select").css("border", "1px solid red");
    return false;
  }else if(!$timeFrom || !$timeTo || $timeFrom > $timeTo){
    $(".first-square input").css("border", "1px solid red");
    return false
  }else{
    $(".database-select select").css("border", "1px solid white");
    $(".first-square input").css("border", "1px solid white");
    var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
    $.each($jp, function(i, n){
      if(n.instanceName == $selected_value){
        $instanceId = n.instanceid;
      }
    })
      $timeFrom = $timeFrom + " 00:00:00";
      $timeTo = $timeTo + " 00:00:00";
    $.ajax({
      type: "POST",
      url: 'http://192.168.1.103:8080/backup/search',
      data: {
        "instanceId": $instanceId,
        "dateFrom": $timeFrom,
        "dateTo": $timeTo
      },
      dataType: "json",
      success: function(data){
        var Row = data.total,
            trList = data.rows;
        $.each(trList, function(i,n){
          var dateChange = n.time,
              time;
          time = timestampToTime(dateChange);
          n.time = time;
        });
        sessionStorage.setItem("instance",JSON.stringify(data.rows));
        $(".tbody").empty();
        for(var i=0; i<Row; i++) {
            var $trTemp = $("<tr></tr>");
            $trTemp.append("<td>" + trList[i].time + "</td>");
            $trTemp.append("<td>" + trList[i].strategy + "</td>");
            $trTemp.append("<td>" + trList[i].size + "</td>");
            $trTemp.append("<td>" + trList[i].type + "</td>");
            $trTemp.append("<td>完成备份</td>");
            $trTemp.append("<td><a  class='download'>下载</a></td>");
            $trTemp.append("<td class='recover'>恢复</td>");
            $(".tbody").append($trTemp);
        }
        var $table = $('table'),
      	    currentPage = 0,//当前页默认值为0
      	    pageSize = 4;//每一页显示的数目
      	$table.bind('paging',function(){
      		$table.find('tbody tr').hide().slice(currentPage*pageSize,(currentPage+1)*pageSize).show();
      	});
      	var sumRows = $table.find('tbody tr').length,
      	    sumPages = Math.ceil(sumRows/pageSize),//总页数
            $pager = $('<div class="page"></div>');  //新建div，放入a标签,显示底部分页码
      	for(var pageIndex = 0 ; pageIndex<sumPages ; pageIndex++){
      		$('<a href="#" id="pageStyle" onclick="changCss(this)"><span>'+(pageIndex+1)+'</span></a>').bind("click",{"newPage":pageIndex},function(event){
      			currentPage = event.data["newPage"];
      			$table.trigger("paging");
      			   //触发分页函数
      			}).appendTo($pager);
      			$pager.append(" ");
      		}
      	$pager.insertAfter($table);
      	$table.trigger("paging"); //默认第一页的a标签效果
      	var $pagess = $('#pageStyle');
        $pagess[0].style.backgroundColor="#2d3035";
        $pagess[0].style.color="#00f6ff";
      }
    });
  }
});
$(".second-btn").click(function(event){
  var $host,
      $instanceUser,
      $instancePassword,
      $check_value = '',
      $dateFrom = $("#selected-first").val(),
      $dateTo = $("#selected-second").val(),
      $selected_value = $(".dbOption").val();
  $("input[name='check']:checked").each(function(i){
    $check_value =  $check_value+ $(this).val() + ',';
  });
  if($selected_value == "请选择你的实例"){
    $(".database-select select").css("border", "1px solid red");
    return false;
  }else if($check_value.length == 0){
    $(".errorPrompt").show();
    return false;
  }else if(!$dateFrom || !$dateTo ){
    $(".Prompt select").css("border", "1px solid red");
    return false;
  }else{
    $(".errorPrompt").hide();
    $(".Prompt select").css("border", "1px solid white");
    $(".database-select select").css("border", "1px solid white");
    var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
    $.each($jp, function(i, n){
      if(n.instanceName == $selected_value){
        $host = n.host;
        $instanceUser = n.instanceUser;
        $instancePassword = n.instancePassword;
      }
    });
     $.ajax({
      type: "POST",
      url: 'http://192.168.1.103:8080/backup/settings',
      data: {
        "days": $check_value,
        "hour": $dateFrom,
        "minute": $dateTo,
        "host": $host,
        "instanceUser": $instanceUser,
        "instancePassword": $instancePassword
      },
      dataType: "json",
      success: function(data){
          alert(data.msg);
      }
    });
  }
});
$(".dbclean").click(function(event){
  $(".databaseInput").val('');
});
$(".backupInstance").click(function(event){
  var $host,
      $instanceUser,
      $instancePassword,
      $selected_value = $(".dbOption").val(),
      $backupWay = $(".main-div-select-third").val(),
      $databaseInput = $(".databaseInput").val(),
      $backupOption;
  if($(".radioSelect_first").find("img").attr("src") == "img/selected.png"){
    $backupOption = 0;
  }else if($(".radioSelect_second").find("img").attr("src") == "img/selected.png"){
    $backupOption = 1;
  }
  if($selected_value == "请选择你的实例"){
    $(".database-select select").css("border", "1px solid red");
    return false;
  }else{
    $(".database-select select").css("border", "1px solid white");
    var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
    $.each($jp, function(i, n){
      if(n.instanceName == $selected_value){
        $host = n.host;
        $instanceId = n.instanceid;
        $instanceUser = n.instanceUser;
        $instancePassword = n.instancePassword;
      }
    });
    $.ajax({
      type: "POST",
      url: "http://192.168.1.103:8080/backup/backupinstance",
      data: {
        "type": $backupWay,
        "strategyType": $backupOption,
        "databaseName": $databaseInput,
        "host": $host,
        "instanceId": $instanceId,
        "instanceUser": $instanceUser,
        "instancePassword": $instancePassword
      },
      dataType: "json",
      success: function(data){
        alert(data.msg);
      }
    });
  }
});
function changCss(obj){
	var arr = document.getElementsByTagName("a");
	for(var i=0;i<arr.length;i++){
	 if(obj==arr[i]){       //当前页样式
	  obj.style.backgroundColor="#2d3035";
	  obj.style.color="#00f6ff";
	}
	 else
	 {
	   arr[i].style.color="white";
	   arr[i].style.backgroundColor="";
	 }
	}
}
$("table").on("click",".recover",function(event){
   var $index = $(this).parent().index(),
       $instance = JSON.parse(sessionStorage.getItem("instance")),
       $selected_value = $(".dbOption").val();
   var $download = $instance[$index];
   if($selected_value == "请选择你的实例"){
     $(".database-select select").css("border", "1px solid red");
     return false;
   }else{
     $(".database-select select").css("border", "1px solid white");
     var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
     $.each($jp, function(i, n){
       if(n.instanceName == $selected_value){
         $host = n.host;
         $instanceUser = n.instanceUser;
         $instancePassword = n.instancePassword;
       }
     });
     $.ajax({
       type: "POST",
       url: "http://192.168.1.103:8080/backup/recovery",
       data: {
         "backup.strategy": $download.strategy,
         "backup.type": $download.type,
         "backup.size": $download.size,
         "backup.url": $download.url,
         "backup.host": $download.$host,
         "backup.backupName": $download.backupName,
         "host": $host,
         "instanceUser": $instanceUser,
         "instancePassword": $instancePassword
       },
       dataType: "json",
       success: function(data){
         alert(data.msg);
       }
     });
   }
});
$("table").on("click",".download",function(event){
  var $index = $(this).closest("tr").index(),
      $instance = JSON.parse(sessionStorage.getItem("instance"));
  var $download = $instance[$index];
  $(this).parent().find("a").attr("href",$download.url);
});
$(".increasebtn").click(function(event){
  var $selected_value = $(".dbOption").val(),
      $Option;
  if($(".radioClose").find("img").attr("src") == "img/selected.png"){
    $Option = "关闭";
  }else if($(".radioOpen").find("img").attr("src") == "img/selected.png"){
    $Option = "开启";
  }
  if($selected_value == "请选择你的实例"){
    $(".database-select select").css("border", "1px solid red");
    return false;
  }else if(!$Option){
    $(".errorPrompt2").show();
    return false;
  }else{
    $(".database-select select").css("border", "1px solid white");
    $(".errorPrompt2").hide();
    if($Option == "开启"){
      var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
      $.each($jp, function(i, n){
        if(n.instanceName == $selected_value){
          $host = n.host;
          $instanceUser = n.instanceUser;
          $instancePassword = n.instancePassword;
          $replUser = n.replUser;
          $replPassword = n.replPassword
        }
      });
      $.ajax({
        type: "POST",
        url: "http://192.168.1.103:8080/backup/openslave",
        data: {
          "host": $host,
          "instanceUser": $instanceUser,
          "instancePassword": $instancePassword,
          "replUser": $replUser,
          "replPassword": $replPassword
        },
        dataType: "json",
        success: function(data){
          alert(data.msg);
        }
      });
    }
  }
});
$(".datebtn").click(function(event){
  var $selected_value = $(".dbOption").val(),
      $day = $(".timeThree").val(),
      $hour = $("#selected-third").val(),
      $minute = $("#selected-forth").val(),
      $second = $("#selected-fifth").val(),
      time;
  if($selected_value == "请选择你的实例"){
    $(".database-select select").css("border", "1px solid red");
    return false;
  }else if(!$day){
    $(".install input").css("border", "1px solid red");
  }else if(!$hour || !$minute || !$second){
    $(".install input").css("border", "1px solid white");
    $(".install select").css("border", "1px solid red");
  }else{
    if($hour<10){
      $hour = '0'+ $hour;
    }
    if($minute<10){
      $minute = '0'+ $minute;
    }
    if($second<10){
      $second = '0'+ $second;
    }
    $(".install input").css("border", "1px solid white");
    $(".install select").css("border", "1px solid white");
    var $jp = JSON.parse(sessionStorage.getItem("dbArray"));
    $.each($jp, function(i, n){
      if(n.instanceName == $selected_value){
        $host = n.host;
        $instanceUser = n.instanceUser;
        $instancePassword = n.instancePassword;
      }
    });
    time = $day+' ' + $hour + ':' + $minute + ':' + $second;
    $.ajax({
      type: "POST",
      url: "http://192.168.1.103:8080/backup/pointintime",
      data: {
        "time": time,
        "host": $host,
        "instanceUser": $instanceUser,
        "instancePassword": $instancePassword
      },
      dataType: "json",
      success: function(data){
        alert(data.msg);
      }
    })
  }
});
function timestampToTime(timestamp) {
    var Y,M,D,h,m,s;
    var date = new Date(timestamp);
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate();
    h = date.getHours();
    m = date.getMinutes();
    s = date.getSeconds();
    if(D<10){
      D = '0' + D;
    }
    if(h<10){
      h = '0' + h;
    }
    if(m<10){
      m = '0'+ m;
    }
    if(s<10){
      s = '0' + s;
    }
    return Y+M+D+ " "+h+ ':' +m+ ':' +s;
}
