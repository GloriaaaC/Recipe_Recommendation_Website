$(function() {
    $('.ct-pageWrapper .container p').on('click', 'span.iconfont.icon-delete', function() {
        const $self = $(this);
        $self.remove();
    });
});


/**
 * 传入的参数: userID(int) ,id(String),title(String),image(String，是图像的url)
 * 请求方式: post
 * 返回: 状态码，200代表成功接收到数据，然后通过ajax带参数食谱ID跳转页面
*/
$(function () {
    $('.ct-pageWrapper .container .row .col-md-9 .row').on('click','.col-sm-4 .ct-product .inner button',function () {
        const $self = $(this);
        $.ajax({
            url:'/recipes/createAndUpdate',
            type:'post',
            dataType:'json',
            data:{"recipeId":$self.attr("id"),"recipeName":$self.siblings("h2").text(),"imageUrl":$self.parent().siblings().children().attr("src")},
            success:function (data) {
                console.log(data);
                if (data.state === 200){
                    alert("success");
                    window.location.href = "/recipe?id="+$self.attr("id");
                } else {
                    alert("failure");
                }
            }
        })
    })
});

$(function () {
    $('a.fa-search').on('click',function () {
        window.location.reload();
    });
    $('a.fa-history').on('click',function () {
        window.location.href = "/history";
    });
    $('a.fa-bookmark-o').on('click',function () {
        window.location.href = "/favourite";
    });
    $('a.fa-user-o').on('click',function () {
        window.location.href = "/account";
    });
});

$(function() {
    $('.brand_left .numA-Z a').on('click', function(event) {
        event.preventDefault();
        const $self = $(this),
            navT = $self.text(),
            $list = $self.closest('.brand_left').find('.brand_list');

        $self.addClass('active').siblings().removeClass('active');
        $list.animate({
            scrollTop: $list.find('.name:contains(' + navT + ')').prop('offsetTop')
        }, 'fast');
    });

    $('.brand_list .list_cont li span.iconfont.icon-success').click(function() {
        const $self = $(this);
        const navT = $self.parent().text();
        $('.ct-pageWrapper .container .selected p').append('<span>' + navT + '</span>');
        $('.ct-pageWrapper .container .selected p span').addClass('iconfont icon-delete');
    });

    $('.brand_list .list_cont li span.iconfont.icon-delete').on('click', function() {
        const $self = $(this);
        const navT = $self.parent().text();
        $('.ct-pageWrapper .container .avoided p').append('<span>' + navT + '</span>');
        $('.ct-pageWrapper .container .avoided p span').addClass('iconfont icon-delete');
    });
});