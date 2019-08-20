package ui;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {
	private TeamDao teamDao;
	private PlayerDao playerDao;
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	public void showMenu(String str) {
		System.out.println("==========================");
		System.out.println();
		System.out.printf("%s를 입력하고 Enter를 누르세요.\n",str);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
	}
	private void showTeamField(Player p) {
		showMenu("팀 번호");
		String id=this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else {
			Team team = teamDao.getTeam(Integer.valueOf(id));
			p.setTeam(team);
			showPlayerId(p, team);
		}
	}
	protected void showPlayerId(Player p, Team t) {
		showMenu("선수 번호");
		String id=this.getInputedString();
		if(StringUtils.isEmpty(id)) return;
		else {
			p.setPlayer_id(Integer.valueOf(id));
			playerDao.insertPlayer(p);
			System.out.printf("팀 %s에 %s 선수를 등록했습니다.\n",t.getName(),p.getName());
		}
	}

	
	//트랜잭션의 속성				설명
	//Propagation.REQUIRED 		현재 트랜잭션이 존재하면, 그것을 사용, 트랜잭션이 없으면 새로 생성
	//Propagation.SUPPORTS		현재 트랜잭션이 존재하면, 그것을 사용, 트랜잭션이 없으면 트랜잭션을 사용하지 않음
	//Propagation.MANDATORY		현재 트랜잭션이 존재하면, 그것을 사용, 없으면 예외발생
	//Propagation.REQUIRES_NEW	항상 새로운 트랜잭션을 발생.
	//Propagation.NOT_SUPPORTED	항상 트랜잭션을 이용하지 않고 실행. 트랜잭션이 있으면 그것을 중단
	//Propagation.NEVER			항상 트랜잭션을 이용하지 않고 실행. 이미 트랜잭션이 있으면 예외발생
	//Propagation.NESTED		
	@Transactional(propagation=Propagation.REQUIRED)
	public void show() {
		showMenu("선수 이름");
		String name = this.getInputedString();
		if(StringUtils.isEmpty(name)) return;
		else {
			Player player=new Player();
			player.setName(name);
			showTeamField(player);
		}

	}

}
