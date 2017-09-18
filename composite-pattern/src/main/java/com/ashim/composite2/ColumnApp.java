package com.ashim.composite2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class for running Composite Design Pattern With Tree Structure. It handles
 * Unto 7 level only.
 *
 * @author ashimkhadka
 */
public class ColumnApp {

	private static final int LEVEL_POSITION = 1;
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Runs the program
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String... args) throws Exception {

		List<Column> columns = getColumns(true);
		System.out.println();
		System.out.println("All Column List");
		System.out.println(mapper.writeValueAsString(columns));

	}

	/**
	 * Construct Column List with its parent-child relation
	 *
	 * @param isPrintLevelMap
	 *            to print level wise column list
	 * @return list of column with hierarchy
	 *
	 * @throws Exception
	 *             when node level doesn't match its parent node
	 */
	private static List<Column> getColumns(boolean isPrintLevelMap) throws Exception {
		// Initialize Node with its child
		Node node = getNode();

		// Initialize list new blank column name
		List<Column> columns = new ArrayList<>();
		columns.add(new Column(""));

		// Initialize map for a root level
		Map<Integer, List<Column>> maps = new HashMap<>();
		maps.put(LEVEL_POSITION, columns);

		maps = constructColumnLevels(maps, node, LEVEL_POSITION);
		columns = new ArrayList<>();

		if (isPrintLevelMap) {
			System.out.println("Level Wise Column List");
			System.out.println(mapper.writeValueAsString(maps));
		}

		for (Map.Entry<Integer, List<Column>> map : maps.entrySet()) {
			for (Column col : map.getValue()) {
				columns.add(col);
			}
		}
		return columns;
	}

	/**
	 * Construct the column hierarchy in recursive order. Also, it handles any
	 * exception thrown and print it in console and returns the parent map.
	 *
	 * @param parentMaps
	 *            contains parent column list
	 * @param node
	 *            defines the level of column and its position
	 * @param curPos
	 *            contains the current position of recursive { starting position
	 *            with always be 0 }
	 * @return the list of column with hierarchy maintain in map with level
	 *
	 * @throws Exception
	 */
	private static Map<Integer, List<Column>> constructColumnLevels(Map<Integer, List<Column>> parentMaps, Node node,
			int curPos) throws Exception {

		try {
			Map<Integer, List<Column>> maps = new HashMap<>();
			List<Column> cols = new ArrayList<>();

			List<Column> parentCols = parentMaps.get(curPos - 1);
			Column parentColumn = parentCols == null ? new Column("") : parentCols.get(node.getId() - 1);

			for (int i = 1; i <= node.getLevel(); i++) {
				Column column = new Column(parentColumn.getName() + ColumnLvl.getDesc(i));
				column.setParent(parentColumn);
				cols.add(column);
			}

			maps.put(curPos, cols);

			for (Node childNode : node.getNode()) {
				Map<Integer, List<Column>> tmpMaps = constructColumnLevels(maps, childNode, curPos + 1);

				for (Map.Entry<Integer, List<Column>> e : tmpMaps.entrySet()) {
					if (maps.containsKey(e.getKey())) {
						List<Column> tmpCols = e.getValue();
						tmpCols.addAll(maps.get(e.getKey()));
						maps.put(e.getKey(), tmpCols);
					} else {
						maps.put(e.getKey(), e.getValue());
					}
				}
			}

			return maps;
		} catch (Exception e) {
			System.out.println(parentMaps);
		}

		return parentMaps;
	}

	/**
	 * Load Node from resources path
	 *
	 * @return node with its child node
	 *
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	private static Node getNode() throws JsonParseException, JsonMappingException, IOException {
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		return mapper.readValue(new File("src/main/resources/node.json"), Node.class);
	}

}
