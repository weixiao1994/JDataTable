package per.wei.jdatatable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class JDataTableUtils {
	public JDataTable dataTable;

	public JDataTableUtils(JDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public static <T> T get(Class<T> clz, Object o) {
		if (clz.isInstance(o)) {
			return clz.cast(o);
		}
		return null;
	}

	private enum CalculateType {
		max, min, sum, avg
	}

	private BigDecimal max_min(String colName, CalculateType calType) throws Exception {
		Map<String, Integer> colMap = dataTable.columns.columnName2Index;
		if (!colMap.containsKey(colName)) {
			throw new Exception("no column called:" + colName);
		}
		int colIndex = colMap.get(colName);
		List<JDataRow> rows = dataTable.rows.dataRowCollection;

		BigDecimal maxOrMin = null;
		int firstNull = 0;
		for (int i = 0; i < rows.size(); i++) {
			Object obj = rows.get(i).get(colIndex);
			firstNull = i;
			if (obj != null && obj.toString().trim().length() != 0) {
				try {
					maxOrMin = new BigDecimal(obj.toString());
				} catch (NumberFormatException e) {
					continue;
				}
				break;
			}
		}

		for (int i = firstNull; i < rows.size(); i++) {
			Object obj = rows.get(i).get(colIndex);
			if (obj != null && obj.toString().trim().length() != 0) {
				BigDecimal tmp = null;
				try {
					tmp = new BigDecimal(obj.toString());
				} catch (NumberFormatException e) {
					continue;
				}
				maxOrMin = calType == CalculateType.max ? maxOrMin.max(tmp) : maxOrMin.min(tmp);
			}
		}
		return maxOrMin;
	}

	public BigDecimal max(String colName) throws Exception {
		return max_min(colName, CalculateType.max);
	}

	public BigDecimal min(String colName) throws Exception {
		return max_min(colName, CalculateType.min);
	}

	private BigDecimal sum_avg(String colName, CalculateType calType) throws Exception {
		Map<String, Integer> colMap = dataTable.columns.columnName2Index;
		if (!colMap.containsKey(colName)) {
			throw new Exception("no column called:" + colName);
		}
		int colIndex = colMap.get(colName);
		List<JDataRow> rows = dataTable.rows.dataRowCollection;

		BigDecimal sum = new BigDecimal(0);
		int cnt = 0;
		for (int i = 0; i < rows.size(); i++) {
			Object obj = rows.get(i).get(colIndex);
			if (obj != null && obj.toString().trim().length() != 0) {
				BigDecimal tmp = null;
				try {
					tmp = new BigDecimal(obj.toString());
				} catch (NumberFormatException e) {
					continue;
				}
				sum.add(tmp);
				cnt++;
			}
		}
		BigDecimal count = new BigDecimal(cnt);
		return calType == CalculateType.avg ? sum.divide(count) : sum;
	}
	
	public BigDecimal avg(String colName) throws Exception {
		return sum_avg(colName, CalculateType.avg);
	}
	
	public BigDecimal sum(String colName) throws Exception {
		return sum_avg(colName, CalculateType.sum);
	}
	
	
	private String regexKeywords = "";
	
	public JDataTable select(String filter) {
		String condition[] = filter.split("\\s+");
		return null;
	}
	
	
	
	public static void main(String[] args) {
		String arg = "main  ooo   ggg";
		String[] arrays = arg.split("\\s+");
		for(int i=0;i<arrays.length;i++) {
			System.out.print(i+"\t");
			System.out.println(arrays[i]);
		}
	}
}
