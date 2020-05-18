<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" crossorigin="anonymous"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha256-eSi1q2PG6J7g7ib17yAaWMcrr5GrtohYChqibrV7PBE=">
    <link rel="stylesheet" crossorigin="anonymous"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          integrity="sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0=">
    <link rel="stylesheet" crossorigin="anonymous"
          href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/css/ui.jqgrid.min.css"
          integrity="sha256-3oIi71IMpsoA+8ctSTIM+6ScXYjyZEV06q6bbK6CjsM=">

    <script src="js/jquery-3.2.1.min.js"></script>
    <script crossorigin="anonymous" src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="></script>
    <!-- the next line need be uncommented if you need to use bootstrap.min.js -->
    <script crossorigin="anonymous"
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha256-98vAGjEDGN79TjHkYWVD4s87rvWkdWLHPs5MC3FvFX4="></script>
    <script crossorigin="anonymous"
            src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha256-VsEqElsCHSGmnmHXGQzvoWjWwoznFSZc6hs7ARLRacQ="></script>


   <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script> -->
    <script src="js/jquery.jqGrid.min.js"></script>
    <script src="js/grid.locale-en.js"></script>
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/bikeRental.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/vehicles.js"></script>

    <title>LeasePlan Vehicles</title>
    <div id="header" style="height: 132px;">
        <a class="UL_logo" style="display: block; background: url(https://media.glassdoor.com/sqll/227921/leaseplan-infrastructure-services-squarelogo-1466794415688.png) no-repeat; height: 125px; margin-top: 5px;"></a>
        <button class="open-button" onclick="openForm()">Add Vehicle</button>
        <button class="close-button" onclick="deleteVehicles()">Delete Vehicle</button>
    </div>
    <table id="grid1"></table>

    <div class="form-popup" id="myForm">
        <form class="form-container" action="addVehicle" method = "POST">
            <label><b>Make Name</b></label>
            <input type="text" placeholder="Make Name" name="makeName" required>

            <label><b>Model Name</b></label>
            <input type="text" placeholder="Model Name" name="modelName" required>

            <label><b>Model Edition</b></label>
            <input type="text" placeholder="Model Edition" name="modelEdition" required>

            <label><b>Price</b></label>
            <input type="number" placeholder="Price" name="price" required>

            <button type="submit" class="btn">Save</button>
            <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
    </div>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Options</h4>
                </div>
                <div class="modal-body" id = body>
                    <div id="dynamic-content"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</head>
<body>
<script type="text/javascript">
    function openForm() {
        document.getElementById("myForm").style.display = "block";
    }

    function closeForm() {
        document.getElementById("myForm").style.display = "none";
    }
    $(document).ready(function () {
        loadVehiclesHomePage();
    });
</script>
</body>
</html>
