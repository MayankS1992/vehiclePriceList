function loadVehiclesHomePage()
{
    {
        $.ajax({
            type: 'GET',
            url: "vehicles-rest/getAllVehicles",
            dataType: "json",
            data: {
            },
            success: function (json){
                createRentalHistoryable(json);
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
    }
}

function createRentalHistoryable(json) {
    if(json.length===0)
    {
        json = "<html><p>You're yet to ride with us</p></html>";
    }
    jQuery('#grid1').empty();
    $("#grid1").GridUnload();
    jQuery("#grid1").jqGrid({
        datatype: "local",
        height: 300,
        width:600,
        colNames: ['Bike ID','Bike Spot','Booking ID','','Start Booking','End Booking'],
        colModel: [
            { name: 'bikeId', key: true, sorttype: "int", width: 120 },
            { name: 'bikeSpot', fixed: true ,width: 120 },
            { name: 'bookingId', width: 120  },
            {
                name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='cancelBooking()'>Cancel Booking</a>";
                },
            },
            { name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='startTrip()'>Start trip</a>"; }
            },
            { name: '', align: 'center', sortable: false, width: 80,
                formatter: function () {
                    var grid = $('#grid'), rowid = $(this).closest("tr.jqgrow").attr("id");
                    var myCellData = grid.jqGrid('getCell', rowid, 'bikeId');
                    return "<a href='#' onclick='endTrip()'>End trip</a>"; }
            }
        ],
        caption: "Rental History",
        data: json,
        gridview: true,
        onCellSelect: function (rowid) {
            var rowData = $(this).jqGrid("getRowData", rowid);
            bikeCancelRow = rowData.bookingId;
            console.log(bikeCancelRow);
        }
    });
}
