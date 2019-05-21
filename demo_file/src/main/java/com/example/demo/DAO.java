package com.example.demo;

public class DAO {
	//批量插入方法
//	public void createBnakInfo(List<BankCodes> bankCodesList) {
//		// TODO Auto-generated method stub
//		DSLContext context = dbProvider.getDslContext(AccessSpec.readWriteWith(BankCodes.class));
//		PayBankCodesDao dao = new PayBankCodesDao(context.configuration());
//		long id = this.dbProvider.allocPojoRecordId(BankCodes.class);
//		for(int i=0;i<bankCodesList.size();i++){
//			id++;
//			BankCodes bk = bankCodesList.get(i);
//			bk.setId(id);
//			bankCodesList.set(i, bk);
//		}
//		dao.insert(bankCodesList.stream().map(r ->ConvertHelper.convert(r, PayBankCodes.class)).collect(Collectors.toList()));
//		dao = null;
//	}
}
