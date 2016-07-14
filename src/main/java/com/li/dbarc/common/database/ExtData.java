package com.li.dbarc.common.database;

import java.util.List;

/**
 * 
 * 分页结果信息
 * 
 * @param <T>
 *            记录类型
 */
public class ExtData<T> {

	/** 应答码. */
	private String resp_code;

	/** 应答信息. */
	private String resp_info;

	/** 总记录数. */
	private String total;

	private String dept_no;
	private String dept_name;
	private String sum_cnt;
	private String sum_amt;

	/** 结果列表 */
	private List<T> rows;

	public ExtData() {

	}

	public ExtData(String resp_code, String resp_info, String total,
			List<T> rows) {
		super();
		this.resp_code = resp_code;
		this.resp_info = resp_info;
		this.total = total;
		this.rows = rows;
	}

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public String getResp_info() {
		return resp_info;
	}

	public void setResp_info(String resp_info) {
		this.resp_info = resp_info;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public String getSum_cnt() {
		return sum_cnt;
	}

	public void setSum_cnt(String sum_cnt) {
		this.sum_cnt = sum_cnt;
	}

	public String getSum_amt() {
		return sum_amt;
	}

	public void setSum_amt(String sum_amt) {
		this.sum_amt = sum_amt;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

}
