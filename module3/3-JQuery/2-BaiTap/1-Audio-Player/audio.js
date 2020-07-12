$.ajax({
    type: "GET",
    url: "data.xml",
    dataType: "xml",
    success: function xmlParser(xml){            
        $(xml).find("track").each(function(){
    let url = $(this).find("location").text();
    let info =  $(this).find("title").text() + '-' + $(this).find("creator").text();
    let backgroundImg= $(this).find("bgimage").text();
    let image=$(this).find("avatar").text;
    })    
}
})