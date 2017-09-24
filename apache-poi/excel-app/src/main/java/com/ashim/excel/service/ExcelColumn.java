package com.ashim.excel.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity object with maintains Excel Column Data
 *
 * @author Ashim Jung Khadka <br>
 *         Created Date : Sep 24, 2017
 *
 */
public class ExcelColumn {

	protected String name;

	private int rowStart;
	private int rowEnd;
	private int columnStart;
	private int columnEnd;

	protected ExcelColumn parent;
	protected List<ExcelColumn> childs;

	public ExcelColumn() {
	}

	public ExcelColumn(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
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

	/**
	 * Update all the parent column end by adding 1 in hierarchy order (Goes to
	 * upper level)
	 */
	public void notifyParent() {
		if (this.parent != null) {
			this.parent.columnEnd += 1;
			this.parent.notifyParent();
		}
	}

	@Override
	public String toString() {
		return "ExcelColumn [name=" + this.name + ", rowStart=" + this.rowStart + ", rowEnd=" + this.rowEnd
				+ ", columnStart=" + this.columnStart + ", columnEnd=" + this.columnEnd + ", parent=" + this.parent
				+ ", childs=" + this.childs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		ExcelColumn other = (ExcelColumn) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
