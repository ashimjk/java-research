package com.ashim.column.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashim.column.constant.ColumnLvlEnum;
import com.ashim.column.dto.Column;
import com.ashim.column.dto.Node;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Prepare a column list using node json and returns level wise column.
 *
 * @author ashimkhadka
 */
@Service
public class ColumnService {

	private static final int STARTING_LEVEL_POSITION = 1;

	@Autowired
	private ObjectMapper mapper;

	/**
	 * Construct Column List with its parent-child relation
	 *
	 */
	public Map<Integer, List<Column>> getColumns() {
		try {
			// Initialize Node with its child
			Node node = this.getNode();

			Map<Integer, List<Column>> maps = this.constructColumnLevels(new HashMap<>(), node,
					STARTING_LEVEL_POSITION);

			return maps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	private Map<Integer, List<Column>> constructColumnLevels(Map<Integer, List<Column>> parentMaps, Node node,
			int curPos) throws Exception {

		try {
			Map<Integer, List<Column>> maps = new HashMap<>();
			List<Column> cols = new ArrayList<>();

			List<Column> parentCols = parentMaps.get(curPos - 1);
			Column parentColumn = parentCols == null ? new Column("") : parentCols.get(node.getId() - 1);

			for (int i = 1; i <= node.getLevel(); i++) {
				Column column = new Column(parentColumn.getName() + ColumnLvlEnum.getDesc(i));

				if (!parentColumn.getName().isEmpty()) {
					column.setParent(parentColumn);
				}

				cols.add(column);
			}

			maps.put(curPos, cols);

			for (Node childNode : node.getNode()) {
				Map<Integer, List<Column>> tmpMaps = this.constructColumnLevels(maps, childNode, curPos + 1);

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
	private Node getNode() throws JsonParseException, JsonMappingException, IOException {
		return this.mapper.readValue(new File("src/main/resources/node.json"), Node.class);
	}

}
