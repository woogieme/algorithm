package ver2_annotation;

import org.springframework.stereotype.Component;

// class BoardDaoOracle
//@Component
public class ChinaTire implements Tire {
	@Override
	public String getModel() {
		return "대륙";
	}
}
