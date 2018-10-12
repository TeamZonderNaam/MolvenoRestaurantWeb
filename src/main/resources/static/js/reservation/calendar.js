var dp;
let dropdown = $('#time');
var personCount = $( ".amount" ).val();
//var personCount = 12;

$(document).ready(function ()
{
    dp = $('#datepicker');
    dp.datepicker({
        dateFormat: 'dd-mm-yy',
        autoPick: false,
        startDate: new Date(),
        changeMonth: false,
        changeYear: false,
        autoHide: true,
        onSelect: function(dateText, inst) {
            var date = dateText.split('-');
            getTimeSlots( date[0], date[1], date[2], personCount );
        }
    });
    setupCalendarTable();
});

function setupCalendarTable()
{
    $("#calendarTable").DataTable({
       columns: [
            { "data": "guest.firstName" },
            { "data": "guest.lastName" },
            { "data": "room.number" },
            { "data": "start"},
            { "data": "end"}
        ]
    });
}

function getTimeSlots(day, month, year, personCount)
{
    // Get the data from endpoint.
    $.ajax({
        url: "http://localhost:8080/api/reservation/ymd/"+year+'-'+month+'-'+day+'-'+personCount,
        type: "get",
        success: function (data) {
            dropdown.empty();
            dropdown.append('<option selected="true" disabled>Choose desired time frame...</option>');
            dropdown.prop('selectedIndex', 0);
            $.each(data, function (key, timeSlot) {

            var d = new Date();
                        d.setHours(timeSlot.startTime.hours);
                        d.setMinutes(timeSlot.startTime.minutes);
                        console.log(d);

                dropdown.append($('<option></option>')
                .attr('value', d)
                .text(tString(timeSlot.startTime.hours, timeSlot.startTime.minutes)));


              })
            $("#timeDiv").css("display", "block");
            $("#save").css("display", "block");
            $("#parkingDiv").css("display", "block");
            $("#choosetimeframelabel").css("display", "block");
            $("#choosetimelabel").css("display", "block");
            console.log(data);
        }
    });
}

function tString(hour, min){
    hour = hour.toString().length > 1 ? hour : '0'+hour;
    min = min.toString().length > 1 ? min : '0'+min;
    return hour+':'+min;
}