var Script = function() {


  /* initialize the external events
   -----------------------------------------------------------------*/

  $('#external-events div.external-event').each(function() {

    // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
    // it doesn't need to have a start or end
    var eventObject = {
      title: $.trim($(this).text()) // use the element's text as the event title
    };

    // store the Event Object in the DOM element so we can get to it later
    $(this).data('eventObject', eventObject);

    // make the event draggable using jQuery UI
    $(this).draggable({
      zIndex: 999,
      revert: true, // will cause the event to go back to its
      revertDuration: 0 //  original position after the drag
    });
  });


  /* initialize the calendar
   -----------------------------------------------------------------*/

  var date = new Date();
  var d = date.getDate();
  var m = date.getMonth();
  var y = date.getFullYear();
  $('#calendar').fullCalendar({
    buttonText: {
      today: '今天',
      month: '本月',
      week: '本周',
      day: '本日'
    },
    allDayText: "全天",
    timeFormat: {
      '': 'H:mm{-H:mm}'
    },
    weekMode: "variable",
    columnFormat: {
      month: 'dddd',
      week: 'dddd M-d',
      day: 'dddd M-d'
    },
    titleFormat: {
      month: 'yyyy年 MMMM月',
      week: "[yyyy年] MMMM月d日 { '&#8212;' [yyyy年] MMMM月d日}",
      day: 'yyyy年 MMMM月d日 dddd'
    },
    monthNames: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"],
    dayNames: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
    header: {
      left: 'prev,next',
      center: '本月课程安排',
      right: 'month,basicWeek,basicDay'
    },
    height: window.innerHeight-20,
    windowResize: function(view) {
        $('#calendar').fullCalendar('option', 'height', window.innerHeight-20);
    },
    editable: true,
    droppable: true, // this allows things to be dropped onto the calendar !!!
    drop: function(date, allDay) { // this function is called when something is dropped

      // retrieve the dropped element's stored Event Object
      var originalEventObject = $(this).data('eventObject');

      // we need to copy it, so that multiple events don't have a reference to the same object
      var copiedEventObject = $.extend({}, originalEventObject);

      // assign it the date that was reported
      copiedEventObject.start = date;
      copiedEventObject.allDay = allDay;

      // render the event on the calendar
      // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
      $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
      // is the "remove after drop" checkbox checked?
      if ($('#drop-remove').is(':checked')) {
        // if so, remove the element from the "Draggable Events" list
        $(this).remove();
      }

    },
    events: [{
        title: '工程经济学',
        start: new Date(y, m, d, 08, 10),
        end: new Date(y, m, d, 10, 00),
        allDay: false
      },
      {
          title: '网络及其计算',
          start: new Date(y, m, d+1, 10, 20),
          end: new Date(y, m, d+1, 12, 10),
          allDay: false
      },
      {
          title: '软件需求分析',
          start: new Date(y, m, d+1, 08, 10),
          end: new Date(y, m, d+1, 10, 00),
          allDay: false
      },
      {
          title: '统一建模语言UML',
          start: new Date(y, m, d+1, 14, 00),
          end: new Date(y, m, d+1, 16, 00),
          allDay: false
      }
    ]
  });
}();
