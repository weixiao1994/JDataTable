package per.wei.jdatatable;

public class JDataTable {
	
	private String tableName;
	
	public JDataColumnCollection columns;
	public JDataRowCollection rows;
	
	public JDataTable() {
		columns = new JDataColumnCollection(this);
		rows = new JDataRowCollection(this);
	}
	
	public JDataTable(String tableName) {
		this();
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public JDataRow newRow() {
		return new JDataRow(this);
	}
}
