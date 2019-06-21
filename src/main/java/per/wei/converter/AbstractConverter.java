package per.wei.converter;

import java.sql.ResultSetMetaData;

import per.wei.jdatatable.JDataRow;
import per.wei.jdatatable.JDataTable;

public abstract class AbstractConverter<T> implements JDataTableConverter<T>{
	protected JDataTable dataTable = new JDataTable();
	protected T t;
	protected int columnCnt;
	
	public abstract int getColumnCnt();
	public abstract String getColumnName(int index);
	public abstract Object getData(int colIndex);
	public abstract boolean hasNext();
	
	@Override
	public JDataTable convert(T t) throws Exception{
		this.t = t;
		
		//fill column
		columnCnt = getColumnCnt();
		for(int i=0;i<columnCnt;i++) {
			String columnName = getColumnName(i);
			dataTable.columns.add(columnName);
		}
		//fill data
		while(hasNext()) {
			JDataRow row = dataTable.newRow();
			dataTable.rows.add(row);
			for(int i=0;i<columnCnt;i++) {
				row.add(i, getData(i));
			}
		}
		return dataTable;
	}
}
