let _data;
let draw = {
    init: function () {
        let _this = this;
    },
    moveDraw: function () {
        location.href = "/draw";
    },
    redirect: function (data){
        let jsonStr = JSON.stringify(data);
        console.log('jsonStr='+jsonStr);

        $.ajax({
            type: 'GET',
            url: '/dataRedirect',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: 'data='+encodeURI(JSON.stringify(data)),
            complete: function () {
                console.log('move');
                draw.moveDraw();
            }
        });
        _data = data;
    },
    drawChart: function (dto) {

    }
};

draw.init();