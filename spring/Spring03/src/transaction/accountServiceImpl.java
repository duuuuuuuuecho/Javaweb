package transaction;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;


public class accountServiceImpl implements accountService {

	@Resource(name="accountDao")
	private accountDao accountdao;
	
	public void setAccountdao(accountDao accountdao) {
		this.accountdao = accountdao;
	}


	
	/*
	 * ת��
	 * */
	public void pay(String out, String in, double money) {
		// TODO Auto-generated method stub
		
		//��Ǯ
		accountdao.outMoney(out, money);
		//int a= 1/0;
		//��Ǯ
		accountdao.inMoney(in, money);
	    
	}
	
	@Transactional
	public void pay1(String out, String in, int money) {
		// TODO Auto-generated method stub
		//��Ǯ
				accountdao.outMoney(out, money);
				//int a= 1/0;
				//��Ǯ
				accountdao.inMoney(in, money);
	}

}
