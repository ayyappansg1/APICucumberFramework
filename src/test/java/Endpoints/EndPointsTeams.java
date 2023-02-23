package Endpoints;

public interface EndPointsTeams {
	//teams
	public static final String GETBaseUrl="https://cricbuzz-cricket.p.rapidapi.com/teams/v1/";
	public static final String GETTeamList="international";
	public static final String GETgetSchedules="/schedule";																				//2/scehdule    2-is an Team ID
	public static final String GETgetResults="/results";																						//2/results		2-is an Team ID
	public static final String GETgetNews="https://cricbuzz-cricket.p.rapidapi.com/news/v1/team/";				//2
	public static final String GETgetPlayers="players";																						//2/players    2-is an Team ID
	public static final String GETgetStatsFilters="https://cricbuzz-cricket.p.rapidapi.com/stats/v1/team/";		//2
	public static final String GETgetStats="https://cricbuzz-cricket.p.rapidapi.com/stats/v1/team/";					//2
	
	

}
