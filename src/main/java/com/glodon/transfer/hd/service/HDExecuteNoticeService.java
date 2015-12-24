/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月22日 下午5:13:23
 */
package com.glodon.transfer.hd.service;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.glodon.transfer.hd.model.HD_ExecuteNotice;

@Repository
public class HDExecuteNoticeService {

	@Autowired
	@Qualifier("jdbcPrimaryTemplate")
	private JdbcTemplate jdbcPrinaryTemplate;

	public HD_ExecuteNotice findOne(String xmid) {
		HD_ExecuteNotice notice = jdbcPrinaryTemplate.queryForObject("SELECT * FROM gb_t_execute_notice WHERE XMID=?",
				new BigDecimal[] { new BigDecimal(xmid) }, new HDExecuteNoticeMapper());

		return notice;
	}

	public boolean isExists(String xmid) {
		int count = jdbcPrinaryTemplate.queryForObject("SELECT count(1) FROM gb_t_execute_notice WHERE XMID=?", new BigDecimal[] { new BigDecimal(
				xmid) }, Integer.class);
		if (count > 0) {
			return true;
		}

		return false;
	}

	public List<HD_ExecuteNotice> findAll() {
		List<HD_ExecuteNotice> notices = jdbcPrinaryTemplate.query("SELECT * FROM gb_t_execute_notice", new HDExecuteNoticeMapper());

		return notices;
	}

	public int save(HD_ExecuteNotice notice) {
		StringBuffer sql = new StringBuffer().append("insert into gb_t_execute_notice (EXECUTE_NOTICE_ID,XMID,PROCUREMENT_UNIT_CODE,")
				.append("PROCUREMENT_UNIT,PROJECT_NAME,NOTICE_CODE,PROJECT_AMOUNT,BALANCE,")
				.append("FINANCE_AID_AMOUNT,FINANCE_SPECIAL_AMOUNT,OTHER_AMOUNT,PROJECT_CATEGORY_CODE,")
				.append("PROJECT_CATEGORY,ADVANCE_ITEM,EQUITY,MARKET_BID,").append("FLOOR_PRICE,SINGEL_PRICE,QULIFICATIONS,")
				.append("IMPORTS,UNIT_PERSON,UNIT_PHONE,").append("FINANCE_PERSON,FINANCE_PHONE,AGENCY_NAME,")
				.append("AGENCY_CODE,AGENCY_ID,AGENCY_CONTACT_PERSON,").append("ESTABLISH_DATE,IS_CANCEL,TIMESTAMP,")
				.append("CREATE_DATE,OWNER_ID,TENDER_WAY,").append("RECORD_STATUS)")
				.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		Object[] params = new Object[] { notice.getExecute_notice_id(), notice.getXmid(), notice.getProcurement_unit_code(),
				notice.getProcurement_unit(), notice.getProject_name(), notice.getNotice_code(), notice.getProject_amount(), notice.getBalance(),
				notice.getFinance_aid_amount(), notice.getFinance_special_amount(), notice.getOther_amount(), notice.getProject_category_code(),
				notice.getProject_category(), notice.getAdvance_item(), notice.getEquity(), notice.getMarket_bid(), notice.getFloor_price(),
				notice.getSingel_price(), notice.getQulifications(), notice.getImports(), notice.getUnit_person(), notice.getUnit_phone(),
				notice.getFinance_person(), notice.getFinance_phone(), notice.getAgency_name(), notice.getAgency_code(), notice.getAgency_id(),
				notice.getAgency_contact_person(), notice.getEstablish_date(), notice.getIs_cancel(), notice.getTimestamp(), notice.getCreate_date(),
				notice.getOwner_id(), notice.getTender_way(), notice.getRecord_status() };

		int count = jdbcPrinaryTemplate.update(sql.toString(), params);

		return count;
	}

	public void saveBatch(final List<HD_ExecuteNotice> lst) {
		StringBuffer sql = new StringBuffer().append("insert into gb_t_execute_notice (EXECUTE_NOTICE_ID,XMID,PROCUREMENT_UNIT_CODE,")
				.append("PROCUREMENT_UNIT,PROJECT_NAME,NOTICE_CODE,PROJECT_AMOUNT,BALANCE,")
				.append("FINANCE_AID_AMOUNT,FINANCE_SPECIAL_AMOUNT,OTHER_AMOUNT,PROJECT_CATEGORY_CODE,")
				.append("PROJECT_CATEGORY,ADVANCE_ITEM,EQUITY,MARKET_BID,").append("FLOOR_PRICE,SINGEL_PRICE,QULIFICATIONS,")
				.append("IMPORTS,UNIT_PERSON,UNIT_PHONE,").append("FINANCE_PERSON,FINANCE_PHONE,AGENCY_NAME,")
				.append("AGENCY_CODE,AGENCY_ID,AGENCY_CONTACT_PERSON,").append("ESTABLISH_DATE,IS_CANCEL,TIMESTAMP,")
				.append("CREATE_DATE,OWNER_ID,TENDER_WAY,").append("RECORD_STATUS)")
				.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		jdbcPrinaryTemplate.batchUpdate(sql.toString(), new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				HD_ExecuteNotice notice = lst.get(i);
				ps.setString(1, notice.getExecute_notice_id());
				ps.setString(2, notice.getXmid());
				ps.setString(3, notice.getProcurement_unit_code());
				ps.setString(4, notice.getProcurement_unit());
				ps.setString(5, notice.getProject_name());
				ps.setString(6, notice.getNotice_code());
				ps.setDouble(7, notice.getProject_amount() == null ? null : notice.getProject_amount().doubleValue());
				ps.setDouble(8, notice.getBalance() == null ? null : notice.getBalance().doubleValue());
				ps.setDouble(9, notice.getFinance_aid_amount() == null ? null : notice.getFinance_aid_amount().doubleValue());
				ps.setDouble(10, notice.getFinance_special_amount() == null ? null : notice.getFinance_special_amount().doubleValue());
				ps.setDouble(11, notice.getOther_amount() == null ? null : notice.getOther_amount().doubleValue());
				ps.setString(12, notice.getProject_category_code());
				ps.setString(13, notice.getProject_category());
				ps.setString(14, notice.getAdvance_item());
				ps.setString(15, notice.getEquity());
				ps.setString(16, notice.getMarket_bid());
				ps.setString(17, notice.getFloor_price());
				ps.setString(18, notice.getSingel_price());
				ps.setString(19, notice.getQulifications());
				ps.setString(20, notice.getImports());
				ps.setString(21, notice.getUnit_person());
				ps.setString(22, notice.getUnit_phone());
				ps.setString(23, notice.getFinance_person());

				ps.setString(24, notice.getFinance_phone());
				ps.setString(25, notice.getAgency_name());
				ps.setString(26, notice.getAgency_code());
				ps.setString(27, notice.getAgency_id());
				ps.setString(28, notice.getAgency_contact_person());
				ps.setDate(29, notice.getEstablish_date() == null ? null : new java.sql.Date(notice.getEstablish_date().getTime()));
				ps.setString(30, notice.getIs_cancel());
				ps.setDate(31, notice.getTimestamp() == null ? null : new java.sql.Date(notice.getTimestamp().getTime()));

				ps.setDate(32, notice.getCreate_date() == null ? null : new java.sql.Date(notice.getCreate_date().getTime()));

				ps.setString(33, notice.getOwner_id());

				ps.setString(34, notice.getTender_way());
				ps.setString(35, notice.getRecord_status());
			}

			public int getBatchSize() {
				return lst.size();
			}
		});
	}

	private class HDExecuteNoticeMapper implements RowMapper<HD_ExecuteNotice> {

		public HD_ExecuteNotice mapRow(ResultSet rs, int rowNum) throws SQLException {
			HD_ExecuteNotice notice = new HD_ExecuteNotice();
			notice.setExecute_notice_id(rs.getString("execute_notice_id"));
			notice.setXmid(rs.getString("xmid"));
			notice.setProcurement_unit_code(rs.getString("procurement_unit_code"));
			notice.setProcurement_unit(rs.getString("procurement_unit"));
			notice.setProject_name(rs.getString("project_name"));
			notice.setNotice_code(rs.getString("notice_code"));
			notice.setTender_way(rs.getString("tender_way"));
			notice.setProject_amount(rs.getBigDecimal("project_amount"));
			notice.setBalance(rs.getBigDecimal("balance"));
			notice.setFinance_aid_amount(rs.getBigDecimal("finance_aid_amount"));
			notice.setFinance_special_amount(rs.getBigDecimal("finance_special_amount"));
			notice.setOther_amount(rs.getBigDecimal("other_amount"));
			notice.setProject_category_code(rs.getString("project_category_code"));
			notice.setProject_category(rs.getString("project_category"));
			notice.setAdvance_item(rs.getString("advance_item"));
			notice.setEquity(rs.getString("equity"));
			notice.setMarket_bid(rs.getString("market_bid"));
			notice.setFloor_price(rs.getString("singel_price"));
			notice.setQulifications(rs.getString("qulifications"));
			notice.setImports(rs.getString("imports"));
			notice.setUnit_person(rs.getString("unit_person"));
			notice.setUnit_phone(rs.getString("unit_phone"));
			notice.setFinance_person(rs.getString("finance_person"));
			notice.setFinance_phone(rs.getString("finance_phone"));
			notice.setAgency_name(rs.getString("agency_name"));
			notice.setAgency_code(rs.getString("agency_code"));
			notice.setAgency_id(rs.getString("agency_id"));
			notice.setAgency_contact_person(rs.getString("agency_contact_person"));
			notice.setEstablish_date(rs.getDate("establish_date"));
			notice.setIs_cancel(rs.getString("is_cancel"));
			notice.setTimestamp(rs.getDate("timestamp"));
			notice.setCreate_date(rs.getDate("create_date"));
			notice.setOwner_id(rs.getString("owner_id"));
			notice.setRecord_status(rs.getString("record_status"));
			return notice;
		}

	}

}
