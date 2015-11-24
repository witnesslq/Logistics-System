package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.moneyInfomation.MoneyOutListPO;
import dataservice.moneyInformation.MoneyOutListDataService;
import utility.ResultMessage;
import vo.MoneyOutListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.CostManagementBLService;

public class CostManagementBLImpl implements CostManagementBLService{
    MoneyOutListDataService moneyoutlistdataservice=null;
    public CostManagementBLImpl(){
    	this.moneyoutlistdataservice=(MoneyOutListDataService)RMIHelper.find("MoneyOutListDataService");
    }
	public ResultMessage createMoneyOutlist(MoneyOutListVO moneyOut) {
		// TODO Auto-generated method stub
		MoneyOutListPO moneyoutpo=new MoneyOutListPO(moneyOut.getId(),moneyOut.getDate(),moneyOut.getMoney(),moneyOut.getPayer(),moneyOut.getAccountNum(),moneyOut.getClause(),moneyOut.getNote());
		try{
			moneyoutlistdataservice.add(moneyoutpo);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"添加支出信息成功!");
	}
	public ArrayList<MoneyOutListVO> serach(String start_day, String end_day) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyOutListVO> moneyoutvo=new ArrayList<MoneyOutListVO>();
		ArrayList<MoneyOutListPO> moneyoutpo=new ArrayList<MoneyOutListPO>();
		try{
			moneyoutpo=moneyoutlistdataservice.showAll(start_day, end_day);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(MoneyOutListPO po:moneyoutpo){
			moneyoutvo.add(new MoneyOutListVO(po.getId(),po.getDate(),po.getMoney(),po.getPayer(),po.getAccountNum(),po.getClause(),po.getNote()));
		}
		
		return moneyoutvo;
	}

}
