package per.wei.jdatatable;

public class JDataColumn {
	private String columnName;
	private Class<?> dataType;
	private int index;
	
	public JDataColumn(String columnName) throws Exception {
		if(columnName==null||columnName.trim().length()==0) {
			throw new Exception("column name is null");
		}
		String lowerCaseColName = columnName.toLowerCase();
		this.columnName = lowerCaseColName;
	}
	
	public JDataColumn(String columnName,Class<?> dataType) throws Exception {
		this(columnName);
		this.dataType = dataType;
	}
	
	public JDataColumn(String columnName,String dataTypeStr) throws Exception {
		this(columnName);
		this.dataType = Class.forName(dataTypeStr);
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public Class<?> getDataType() {
		return dataType;
	}

	public int getIndex() {
		return index;
	}
	void setIndex(int index) {
		this.index = index;
	}
}
