package com.example.demo;

public class ReadExcleTest {
//	@Override
//	public void test() throws Exception {
//		String file ="E:/yinhang/222.xlsx";
//		File files = new File(file);
//		InputStream in = new FileInputStream(files);
//		Workbook wb = WorkbookFactory.create(in);
//		   //获得excel文件对象
//		Sheet s = wb.getSheetAt(0);	//获取文件的指定工作表
//		List<BankCodes> bankCodesList = new ArrayList<BankCodes>();
//		for(int i=1;i<s.getPhysicalNumberOfRows();i++){
//			Row row = s.getRow(i);
//			List<String> rowList = new ArrayList<String>();
//			BankCodes bankCode = new BankCodes();
//			/** 循环Excel的列 */
//			for (int c = 0; c < row.getLastCellNum(); c++) {
//				Cell cell = row.getCell(c);
//				switch (c) {
//				case 0:
//					bankCode.setBankName(cell.toString());
//					break;
//				case 1:
//					bankCode.setBankCode(cell.toString());
//					break;
//				case 2:
//					bankCode.setBankArea(cell.toString());
//					break;
//				case 3:
//					bankCode.setBankAreaCode(cell.toString());
//					break;
//				case 4:
//					bankCode.setBankCity(cell.toString());
//					break;
//				case 5:
//					bankCode.setBankCityCode(cell.toString());
//					break;
//				case 6:
//					bankCode.setUnionBankName(cell.toString());
//					break;
//				case 7:
//					bankCode.setUnionBankCode(cell.toString());
//					break;	
//				default:
//					break;
//				}
//			}
//			bankCodesList.add(bankCode);
//			bankCode = null;
//			}
//		qrCodeProvider.createBnakInfo(bankCodesList);
//		}
}
