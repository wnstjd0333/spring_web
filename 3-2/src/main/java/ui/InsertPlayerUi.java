package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

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

	protected void showMenu(String wanted) {
		System.out.println("=====================");
		System.out.println("");
		System.out.printf("%s 를 입력하고 Enter를 누르세요.",wanted);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
	}
	@Override
	public void show() {
		final String playerName = "선수명";
		showMenu(playerName);
		String name = this.getInputedString(); //선수명을 입력받음
		if(StringUtils.isEmpty(name)) {
			return;//이름을 입력하지 않으면 메서드 종료
		} else if(name.length()<128) { //이름이 128자 이내인 경우
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		} else {
			show(); //이름이 128자 이상이면 동일한 메서드를 다시 호출
		}
	}
	protected void showTeamField(Player player) {
		final String teamId = "팀ID";
		showMenu(teamId);
		String id=this.getInputedString();//팀 번호를 입력 받음
		if(StringUtils.isEmpty(id)) {
			return; //메서드 종료
		}else if(NumberUtils.isNumber(id)) {//팀번호가 숫자인 경우
			Team team = this.teamDao.getTeam(Integer.valueOf(id));//팀 번호로 팀을 찾음
			if(team == null) {//입력된 번호의 팀이 없는 경우
			 	System.out.printf("%s인 팀은 존재하지 않습니다.",id);
			 	showTeamField(player);//현 메서드 다시 호출
			} else { //입력된 번호의 팀이 존재하는 경우
				player.setTeam_id(Integer.valueOf(id));
				showPlayerId(player,team);//선수 등록 결과를 출력한다.
			}
		}
	}
	protected void showPlayerId(Player player, Team team) {
		final String playerId = "선수ID";
		showMenu(playerId);
		String id = this.getInputedString(); //선수번호를 입력받음
		if(StringUtils.isEmpty(id)) { //선수 번호가 없는 경우
			return;//메서드 종료
		} else if(NumberUtils.isNumber(id)) {//선수번호가 숫자인 경우
			player.setPlayer_id(Integer.valueOf(id));
			playerDao.insertPlayer(player);//DB에 삽입
			System.out.printf("팀 %s에 %s 선수를 등록 했습니다.",team.getName(),player.getName());
		}
	}

}
