package per.wei.jdatatable;

import java.util.*;

public class JDataRowCollection {
	private JDataTable dataTable;
	List<JDataRow> dataRowCollection;
	
	private int size;
	
	public JDataRowCollection(JDataTable dataTable) {
		this.dataTable = dataTable;
		dataRowCollection = new ArrayList<JDataRow>();
	}
	
	public void add(JDataRow dataRow) {
		dataRowCollection.add(dataRow);
		size++;
	}
	
	public Object get(int rowIndex,String colName) {
		return dataRowCollection.get(rowIndex).get(colName);
	}
	
	public Object get(int rowIndex,int colIndex) {
		return dataRowCollection.get(rowIndex).get(colIndex);
	}
	
	public int size() {
		return size;
	}
}
