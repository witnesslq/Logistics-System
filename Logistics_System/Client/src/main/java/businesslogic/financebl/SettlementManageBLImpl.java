package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.moneyInfomation.MoneyInListPO;
import po.moneyInfomation.MoneyOutListPO;
import dataservice.moneyInformation.MoneyInListDataService;
import utility.ResultMessage;
import vo.MoneyInListVO;
import vo.MoneyOutListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class SettlementManageBLImpl implements SettlementManageBLService {
    MoneyInListDataService moneyinlistdataservice=null;
    public SettlementManageBLImpl(){
    	this.moneyinlistdataservice=(MoneyInListDataService)RMIHelper.find("MoneyInListDataService");
    }

	public ArrayList<MoneyInListVO> searchbyhall(String start_day,
			String end_day, String hall_id) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyInListVO> moneyinvo=search(start_day,end_day);
		ArrayList<MoneyInListVO> moneyin=new ArrayList<MoneyInListVO>();
		
		return null;
	}
	public ArrayList<MoneyInListVO> search(String start_day, String end_day) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyInListVO> moneyinvo=new ArrayList<MoneyInListVO>();
		ArrayList<MoneyInListPO> moneyinpo=new ArrayList<MoneyInListPO>();
		try{
			moneyinpo=moneyinlistdataservice.showAll(start_day, end_day);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(MoneyInListPO po:moneyinpo){
			moneyinvo.add(new MoneyInListVO(po.getId(),po.getDate(),po.getMoneySum(),po.getStaffId(),po.getBarcode()));
		}
		
		return moneyinvo;
	
	}
	public ResultMessage createMoneyInList(MoneyInListVO moneyin) {
		// TODO 自动生成的方法存根
		return null;
	}

}
