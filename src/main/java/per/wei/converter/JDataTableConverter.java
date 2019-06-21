package per.wei.converter;

import per.wei.jdatatable.JDataTable;

public interface JDataTableConverter<T> {
	public JDataTable convert(T dataSet) throws Exception;
}
