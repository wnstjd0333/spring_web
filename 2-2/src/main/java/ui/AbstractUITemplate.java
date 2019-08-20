package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public abstract class AbstractUITemplate extends AbstractUi {

	@Override
	public void show() {
		showMenu();
		String inputedString = this.getInputedString();
		if(isValidNumber(inputedString)) {
			execute(NumberUtils.toInt(inputedString));
		}

	}
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
	protected boolean isValidNumber(String str) {
		if(StringUtils.isBlank(str)) return false;
		if(! StringUtils.isNumeric(str)) return false;
		int number = NumberUtils.toInt(str);
		if(getMinMenuNumber()<=number && number <= getMaxMenuNumber()) return true;
		return false;
	}
	
}
