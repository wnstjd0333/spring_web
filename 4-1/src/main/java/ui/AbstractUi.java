package ui;

import java.util.Scanner;

public abstract class AbstractUi {
	protected String getInputedString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();//�엯�젰�맂 臾몄옣�쓣 由ы꽩
	}
	abstract public void show();
}
