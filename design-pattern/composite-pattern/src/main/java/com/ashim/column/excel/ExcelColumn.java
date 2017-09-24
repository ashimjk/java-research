package com.ashim.column.excel;

import java.util.ArrayList;
import java.util.List;

import com.ashim.column.dto.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExcelColumn {

	private int rowStart;
	private int rowEnd;
	private int columnStart;
	private int columnEnd;

	protected String name;

	@JsonIgnore
	protected ExcelColumn parent;
	protected List<ExcelColumn> childs;

	public ExcelColumn(Column column) {
		this.convertToExcelColumn(column);
	}

	public ExcelColumn(String name) {
		this.name = name;
	}

	public int getRowStart() {
		return this.rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowEnd() {
		return this.rowEnd;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

	public int getColumnStart() {
		return this.columnStart;
	}

	public void setColumnStart(int columnStart) {
		this.columnStart = columnStart;
	}

	public int getColumnEnd() {
		return this.columnEnd;
	}

	public void setColumnEnd(int columnEnd) {
		this.columnEnd = columnEnd;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExcelColumn getParent() {
		return this.parent;
	}

	public void setParent(ExcelColumn parent) {
		this.parent = parent;
	}

	public List<ExcelColumn> getChilds() {
		if (this.childs == null) {
			this.childs = new ArrayList<>();
		}
		return this.childs;
	}

	public boolean hasParent() {
		return this.parent != null && !this.parent.getName().isEmpty();
	}

	public boolean hasChild() {
		return !this.getChilds().isEmpty();
	}

	public void notifyParent() {
		if (this.parent != null) {
			this.parent.columnEnd += 1;
			this.parent.notifyParent();
		}
	}

	@Override
	public String toString() {
		return "ExcelColumn [rowStart=" + this.rowStart + ", rowEnd=" + this.rowEnd + ", columnStart="
				+ this.columnStart + ", columnEnd=" + this.columnEnd + ", name=" + this.name + ", parent=" + this.parent
				+ ", childs=" + this.childs + "]";
	}

	private void convertToExcelColumn(Column column) {

		this.name = column.getName();
		if (column.hasParent()) {
			this.parent = new ExcelColumn(column);
		}
		if (column.hasChild()) {

			for (Column col : column.getChilds()) {
				ExcelColumn e = new ExcelColumn(col);
				this.childs.add(e);
			}
		}
	}

}
