package idv.shawn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.shawn.dao.ExpenseRecordMapper;
import idv.shawn.entity.ExpenseRecord;

@Service
public class ExpenseRecordService {

	@Autowired
	private ExpenseRecordMapper expenseRecordMapper;
	
	public int addRecord(ExpenseRecord record) {
		return expenseRecordMapper.insert(record);
	}
	
	public List<ExpenseRecord> findByMemberId(Long memberId) {
		return expenseRecordMapper.selectByMemberId(memberId);
	}
	
	public int deleteByPK(Long expenseId, Long memberId) {
		return expenseRecordMapper.deleteByPrimaryKey(expenseId, memberId);
	}
}
