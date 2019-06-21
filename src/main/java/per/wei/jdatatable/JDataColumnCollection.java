package per.wei.jdatatable;

import java.util.*;

public class JDataColumnCollection {
	private JDataTable dataTable;
	
	HashMap<String, Integer> columnName2Index;
	
	List<JDataColumn> columnCollection;
	
	private int size;
	
	public JDataColumnCollection(JDataTable dataTable) {
		this.dataTable = dataTable;
		columnName2Index = new HashMap<String, Integer>();
		columnCollection = new ArrayList<JDataColumn>();
	}
	
	public void add(String columnName) throws Exception{
		JDataColumn column = new JDataColumn(columnName);
		columnName2Index.put(column.getColumnName(),size);
		column.setIndex(size);
		columnCollection.add(column);
		size++;
	}
	
	public void add(JDataColumn column){
		columnName2Index.put(column.getColumnName(),size);
		column.setIndex(size);
		columnCollection.add(column);
		size++;
	}
	
	public int getIndex(String colName) {
		return columnName2Index.get(colName);
	}
	
	public String getString(int index) {
		return columnCollection.get(index).getColumnName();
	}
	
	public int size() {
		return size;
	}
}
