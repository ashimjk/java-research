# Column Service

- Flow of execution
	- Load node from json
	- Build Column with parent child relationship
	- Build the column in level wise
- Running
	- port : 8081
	- api : http://localhost:8081/columns
			http://localhost:8081/columns/1
- Note
	- Tree Hierarchy (Look tree structure in src/main/resources/column.png)
	- Input Configuration : JSON (src/main/resources/node.json)
	- Output : JSON
	- JSON Node Generate - http://objgen.com/json/models/GHFe
