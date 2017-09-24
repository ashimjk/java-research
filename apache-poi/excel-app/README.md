# Excel App

- Flow of Execution
	- Calls the api of column-service
	- Build parent-child relation ship for excel-column
	- Build row-column merge region
    - Generating Excel
	    - Merge cell
	    - Formatting and Styling Cell
	    - Iterating Row and Cell for setting value
	    - Generate excel
- Implementation
	- Apache POI
	- Java Docs
 - Running the app
 	- run column-service (port : 8081)
 	- run excel-app (port : 8082)
 	- api : http://localhost:8082/excel
- Note : 
	- generated excel can be found in src/main/resources