package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("######ORM �봽濡쒖젥�듃#######");
		System.out.println("1. 종료");
		System.out.println("2. 팀");
		System.out.println();
		System.out.println("enter를 누르세요.");

	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number) {
		case 1: System.out.println("�떆�뒪�뀥�씠 醫낅즺�릺�뿀�뒿�땲�떎.");
				System.exit(0);
				break;
		case 2: this.selectTeamUi.show();
				break;
		}

	}

	public static void main(String[] args) {
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("beans.xml");
			MenuUi menuUi = (MenuUi)ctx.getBean("menuUi");
			while(true) {
				menuUi.show();
			}

	}

}
