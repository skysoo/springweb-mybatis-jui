let main = {
    init : function () {
        let _this = this;

        $('#btn-select').on('click', function () {
            console.log("click the btn-select button")
            _this.select();
        });
    },
    select : function () {
        let tr = $('#control-chart-info-table tbody tr');
        let td = tr.children();
        // 반복문 사용해서 배열에 담자
        // let tdArr = new Array();
        // td.each(function (i){
        //     tdArr.push(td.eq(i).text());
        // });

        let data = {
            id: td.eq(0).text(),
            sampleCycle: td.eq(1).text(),
            sampleCnt: td.eq(2).text(),
            xbarUcl: td.eq(3).text(),
            xbarCl: td.eq(4).text(),
            xbarLcl: td.eq(5).text(),
            rUcl: td.eq(6).text(),
            rCl: td.eq(7).text(),
            rLcl: td.eq(8).text(),
            createTm: td.eq(9).text()
        };

        let s = JSON.stringify(data);
        console.log(s);

        $.ajax({
            type: 'POST',
            url: '/controlChart',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        });
    },
    select1 : function () {
        let url = "/postList";
        location.href = url;
    }
};

main.init();