function loadDefualtDatas() {
	$.ajax({
		url:"vipAction!findVipInfo.action",
		type:"post",
		dataType:"json", 
		success:function(){
			alert("数据查找成功!");
		},
		error:function(){
			alert("数据查找失败!");
		}
	});
}