package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi {
	private TeamDao teamDao;
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public void show() {
		showTeamList(this.teamDao.getTeamList());
		System.out.println("Enter를 누르세요.");
		this.getInputedString();
	}
	protected void showTeamList(List<Team> teamList) {
		System.out.println("======================");
		System.out.println(" ID       이름 ");
		for(Team team : teamList) {
			System.out.printf("%d %s%n", team.getTeam_id(), team.getName());
		}
	}

}
