<html>
<head>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script>
    $(document).ready(function() {
    	
        $("#showAllStudents").click(function() {
        	$("#tbl tr:not(:first)").remove();  // remove all but first row which is table header
        	
            // Get studentList from controller and append students to table.
            $.get("/getAllStudents", function(res) {
                $.each(res, function(idx, student) {  // for each student from response-studentList
                	
                	var trainerList = [];  // get trainerList of student
                	var trainerNames = "";
                	$.get("/getTrainerList/" + student.id, function(trainerListOfStudent) {
                		$.each(trainerListOfStudent, function(idx, trainer) {  // for each trainer of trainerList
                			trainerList.push(trainer.name);  // push names
                			trainerNames += trainer.name + " ";
                		});  // end for each trainer
                		
                        for (const trainerName of trainerList) {
                            console.log(trainerName)
                        }
                		
                        // append student to table. Do it here within getTrainerList call because of asynchronous behavior
                		$("#tbl").append("<tr>" + "<td>" + student.id + "</td>" + "<td>" + student.name + "</td>" + "<td>" + student.age + "</td>" + "<td>" + trainerNames + "</td>" + "</tr>");
                	});  // end ajax get trainerList
                	
                	// getTrainerList was called. Below codes runs before response is received.
                	
                    console.log(trainerList);  // shows array with elements
                	console.log(trainerList.length);  // array length 0 because of asynchronous behavior
                	
                    // for (const trainerName of trainerList) {  // array length 0 because of asynchronous behavior
                    //     console.log(trainerName)
                    // }
                	
                	// append student to table - trainerList or trainerNames here has no elements because of asynchronous behavior
                    // $("#tbl").append("<tr>" + "<td>" + student.id + "</td>" + "<td>" + student.name + "</td>" + "<td>" + student.age + "</td>" + "<td>" + trainerNames + "</td>" + "</tr>");
                
                });  // end for each student
            });  // end ajax get
        });  // end click

    });  // end dom.ready
</script>
</head>

<body>
    <div class="container">
    <div class="row">
    <div class="col-12">
    
    <br>
    <input type="button" id="showAllStudents" value="View Students"/><br><br>
    
    <h1>All Student Table</h1>
    <table id="tbl" class="table table-striped">
    <tr> <th>ID</th><th>Name</th><th>Age</th><th>Trainers</th> </tr>
    </table>
    <br><br>
    
    </div></div></div>
</body>
</html>
