function loadVehiclesHomePage()
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

function deleteVehicles()
{
    var selectedrows = $("#grid1").jqGrid('getGridParam','selarrrow');
    var rowid = jQuery("#grid1").jqGrid('getGridParam', 'selrow');
    console.log(rowid);
    $.ajax({
            type : "DELETE",
            url: "/vehicles-rest/deleteVehicle/"+rowid,
            contentType: "application/json",
            success: function (json){
                alert("Vehicle deleted");
                createRentalHistoryable(json);
            },
            error: function (xhr) {
                alert("Error:" + "Ooooops! We're down. Come back again.");
            }
        });
}

function loadView(id) {
    $.ajax({
        type: 'GET',
        url: "vehicles-rest/getOptions/"+id,
        contentType: "application/json",
        success: function (json){
            alert("Feature: "+json.feature+ " Price: " +json.price);
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    });
}

function createRentalHistoryable(json) {
    if(json.length===0)
    {json = "<html><p>No Vehicles added yet</p></html>";
    }
    jQuery('#grid1').empty();
    $("#grid1").GridUnload();
    jQuery("#grid1").jqGrid({
        datatype: "local",
        autoHeight: true,
        autowidth: true,
        colNames: ['ID','MakeName','ModelName','ModelEdition','price','select'],
        colModel: [
            { name: 'aid', key: true, sorttype: "int" },
            { name: 'makeName', fixed: true },
            { name: 'modelName' },
            { name: 'modelEdition' },
            { name: 'price' },
            { name: 'CanDo', width: 50, index: 'CanDo',
                editable: true,
                edittype: 'checkbox', editoptions: { value: "True:False" },
                formatter: "checkbox", formatoptions: { disabled: false}}
            ],
        caption: "List of Vehicles",
        ondblClickRow: function(rowId) {
            var rowData = jQuery(this).getRowData(rowId);
            var id = rowData['aid'];
            loadView(id);
        },
        data: json,
        pager: "#jqGridPager01",
        viewrecords: true,
        hidegrid:false,
        altRows: true
    });
}

function addData(){
    // this is the id of the form
    $("#myForm").submit(function(e) {
        var $inputs = $('#myForm :input');
        var values = {};
        values["aid"] = 123;
        e.preventDefault(); // avoid to execute the actual submit of the form.
        $inputs.each(function() {
           if($(this).val()!=""){
                values[this.name] = $(this).val();
            }
            if(this.name=="price"){
                var price = 0.0;
                var intPrice = parseInt($(this).val());
                price = intPrice.toFixed(2);
                values["price"] = 1.0;
            }
        });

        $.ajax({
            type: "POST",
            url: "vehicles-rest/addVehicle",
            data: JSON.stringify(values),
            success: function(data)
            {
                alert(data); // show response from the php script.
            }
        });


    });
}
