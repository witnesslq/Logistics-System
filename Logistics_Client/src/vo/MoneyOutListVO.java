/**
 * 2015年10月22日
 *author:谭期友
 *description:付款单
 *付款单（付款日期、付款金额、付款人、付款账号、
 *付款条目（租金（按年收）运费（按次计算）人员工资（按月统计）奖励（一次性）、快递员提成、司机计次、业务员月薪））、
 *备注信息（租金年份、运单号、标注工资月份））
 */
package vo;
public class MoneyOutListVO extends ListVO{
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 * 金额
	 */
	private double money;
	
	/**
	 * 付款人
	 */
	private String payer;
	
	/**
	 * 银行账号
	 */
	private String accountNum;
	
	
	/**
	 * 构造方法
	 * @param date
	 * @param money
	 * @param payer
	 * @param accountNum
	 */
	public MoneyOutListVO(String date,double money,String payer,String accountNum
			){
		this.date = date;
		this.money = money;
		this.payer = payer;
		this.accountNum = accountNum;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public String getPayer() {
		return payer;
	}

	public String getAccountNum() {
		return accountNum;
	}

}
