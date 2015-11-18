/**
 * 2015年11月13日
 *author:
 *description:
 */
package dataservice.Impl.system;

import java.util.ArrayList;

import po.system.UserPO;
import utility.UserType;
import data.DataJDBCConnection;
import dataservice.system.UserDataService;


/**
 * @author 谭期友
 *
 */
public class UserDataImpl implements UserDataService{

	/**
	 * 因为UserDataService接口继承了Serializable接口才有这个
	 */
	private static final long serialVersionUID = -2473929898619936668L;

	public static void main(String args[]){
		UserDataService userdata=new UserDataImpl();
		userdata.add(new UserPO("wangjaiwei","1232321",UserType.ADMIN,"123332212"));
	}
	
	public void add(UserPO user) {
		
		String operate="insert into User values"+user.getId()+" "+user.getAdmin()+" "+user.getPassword()+" "+user.getPosition();
		DataJDBCConnection.getResultSet(operate);
	}

	public void delete(UserPO user) {
		
	}

	public void update(UserPO user) {
		
	}

	public UserPO findonId(String id) {
		return null;
	}

	public UserPO findonAdmin(String admin) {
		//数据库操作，如果不存在返回null，否则返回UserPO
		
		//模拟，数据库中的po是“找”出来的不是new出来的
		UserPO po=null;
		if(admin.compareTo("admin")==0)
			po = new UserPO("admin","admin",UserType.COURIER,"无权限汪");
		
		return po;
	}

	public ArrayList<UserPO> showAll() {
		return null;
	}

}