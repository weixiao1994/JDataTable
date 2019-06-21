package per.wei.jdatatable;

public class JDataRow {
	private JDataTable dataTable;
	private Object[] data;
	
	JDataRow(JDataTable dataTable) {
		this.dataTable = dataTable;
		data = new Object[dataTable.columns.size()];
	}
	
	public void add(String colName,Object val) {
		String lowerCaseColName = colName.toLowerCase();
		int colIndex = dataTable.columns.columnName2Index.get(lowerCaseColName);
		add(colIndex, val);
	}
	
	public void add(int colIndex,Object val) {
		data[colIndex] = val;
	}
	
	public Object get(String colName) {
		String lowerCaseColName = colName.toLowerCase();
		int colIndex = dataTable.columns.columnName2Index.get(lowerCaseColName);
		return data[colIndex];
	}
	
	public Object get(int colIndex) {
		return data[colIndex];
	}
}
