package logic;

import java.util.List;

import model.Item;

//service는 Controller에 의해 호출되어 실제 비지니스 로직과 트랜잭션을 처리하고, 
//DB CRUD를 담당하는 DAO객체를 Spring으로 부터 주입받아서, DAO에 DB CRUD처리를 위임하고, 처리결과를 controller에게 반환
//쉽게 결과물인 요리를 만들어낸다. 기록을 남기기위해 장부도 작성한다
public interface ItemCatalog {
	List<Item> getItemList();
	Item getItemByItemId(Integer itemId);
}
