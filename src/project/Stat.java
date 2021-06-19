package project;

/**
 * 
 * A value object class that contains the data for each player.
 * @author Alyanna Santos
 * 
 */
public class Stat {

    private int rank = 0;
    private String player = "";
    private String position = "";
    private int age = 0;
    private String team = "";
    private int gamesPlayed = 0;
    private int gamesStarted = 0;
    private int minsPlayed = 0;
    private int fieldGoal = 0;
    private int fieldGoalAttempt = 0;
    private double fieldGoalPct = 0.0;
    private int threePoint = 0;
    private int threePointAttempt = 0;
    private double threePointPct = 0.0;
    private int twoPoint = 0;
    private int twoPointAttempt = 0;
    private double twoPointPct = 0.0;
    private double effectiveFieldGoal = 0.0;
    private int freeThrow = 0;
    private int freeThrowAttempt = 0;
    private double freeThrowPct = 0.0;
    private int offensiveRebound = 0;
    private int defensiveRebound = 0;
    private int totalRebound = 0;
    private int assists = 0;
    private int steals = 0;
    private int blocks = 0;
    private int turnovers = 0;
    private int personalFouls = 0;
    private int points = 0;

    public Stat(String player, 
                    int gamesPlayed, 
                    int points, 
                    int totalRebound, 
                    int assists, 
                    int steals, 
                    int turnovers) {
        
        this.player = player;
        this.gamesPlayed = gamesPlayed;
        this.points = points;
        this.totalRebound = totalRebound;
        this.assists = assists;
        this.steals = steals;
        this.turnovers = turnovers;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getPlayer() {
        return this.player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesStarted() {
        return this.gamesStarted;
    }

    public void setGamesStarted(int gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public int getMinsPlayed() {
        return this.minsPlayed;
    }

    public void setMinsPlayed(int minsPlayed) {
        this.minsPlayed = minsPlayed;
    }

    public int getFieldGoal() {
        return this.fieldGoal;
    }

    public void setFieldGoal(int fieldGoal) {
        this.fieldGoal = fieldGoal;
    }

    public int getFieldGoalAttempt() {
        return this.fieldGoalAttempt;
    }

    public void setFieldGoalAttempt(int fieldGoalAttempt) {
        this.fieldGoalAttempt = fieldGoalAttempt;
    }

    public double getFieldGoalPct() {
        return this.fieldGoalPct;
    }

    public void setFieldGoalPct(double fieldGoalPct) {
        this.fieldGoalPct = fieldGoalPct;
    }

    public int getThreePoint() {
        return this.threePoint;
    }

    public void setThreePoint(int threePoint) {
        this.threePoint = threePoint;
    }

    public int getThreePointAttempt() {
        return this.threePointAttempt;
    }

    public void setThreePointAttempt(int threePointAttempt) {
        this.threePointAttempt = threePointAttempt;
    }

    public double getThreePointPct() {
        return this.threePointPct;
    }

    public void setThreePointPct(double threePointPct) {
        this.threePointPct = threePointPct;
    }

    public int getTwoPoint() {
        return this.twoPoint;
    }

    public void setTwoPoint(int twoPoint) {
        this.twoPoint = twoPoint;
    }

    public int getTwoPointAttempt() {
        return this.twoPointAttempt;
    }

    public void setTwoPointAttempt(int twoPointAttempt) {
        this.twoPointAttempt = twoPointAttempt;
    }

    public double getTwoPointPct() {
        return this.twoPointPct;
    }

    public void setTwoPointPct(double twoPointPct) {
        this.twoPointPct = twoPointPct;
    }

    public double getEffectiveFieldGoal() {
        return this.effectiveFieldGoal;
    }

    public void setEffectiveFieldGoal(double effectiveFieldGoal) {
        this.effectiveFieldGoal = effectiveFieldGoal;
    }

    public int getFreeThrow() {
        return this.freeThrow;
    }

    public void setFreeThrow(int freeThrow) {
        this.freeThrow = freeThrow;
    }

    public int getFreeThrowAttempt() {
        return this.freeThrowAttempt;
    }

    public void setFreeThrowAttempt(int freeThrowAttempt) {
        this.freeThrowAttempt = freeThrowAttempt;
    }

    public double getFreeThrowPct() {
        return this.freeThrowPct;
    }

    public void setFreeThrowPct(double freeThrowPct) {
        this.freeThrowPct = freeThrowPct;
    }

    public int getOffensiveRebound() {
        return this.offensiveRebound;
    }

    public void setOffensiveRebound(int offensiveRebound) {
        this.offensiveRebound = offensiveRebound;
    }

    public int getDefensiveRebound() {
        return this.defensiveRebound;
    }

    public void setDefensiveRebound(int defensiveRebound) {
        this.defensiveRebound = defensiveRebound;
    }

    public int getTotalRebound() {
        return this.totalRebound;
    }

    public void setTotalRebound(int totalRebound) {
        this.totalRebound = totalRebound;
    }

    public int getAssists() {
        return this.assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSteals() {
        return this.steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlocks() {
        return this.blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getTurnovers() {
        return this.turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getPersonalFouls() {
        return this.personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
