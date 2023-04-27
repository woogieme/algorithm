package ver2_annotation;

import org.springframework.stereotype.Component;

// class BoardDaoMysql
@Component // 이름 안붙이면 자동으로 koreaTire
public class KoreaTire implements Tire {
	@Override
	public String getModel() {
		return "국산"; // 실제 sql 실행 구현부
	}
}
