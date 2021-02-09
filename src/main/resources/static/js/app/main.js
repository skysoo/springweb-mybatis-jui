let main = {
    init : function () {
        let _this = this;

        $('#btn-select').on('click', function () {
            console.log("click the btn-select button")
            _this.select();
        });
    },
    select : function () {
        let td = $('#control-chart-info-table tbody tr').text();
        console.log("click data : "+td);
        console.log("td data : "+ td.eq(0).text());
        // 반복문 사용해서 배열에 담자
        // let tdArr = new Array();
        // td.each(function (i){
        //     tdArr.push(td.eq(i).text());
        // });

        let data = {
            id: $('td:eq(0)'),
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

        $.ajax({
            type: 'POST',
            url: '/controlChart',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).error(function (error) {
            alert('에러가 발생했습니다.'+ error);
        });
    },
    select1 : function () {
        let url = "/postList";
        location.href = url;
    }
};

main.init();