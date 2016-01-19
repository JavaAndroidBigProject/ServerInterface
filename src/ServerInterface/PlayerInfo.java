package ServerInterface;

/**
 * 玩家信息
 */
public class PlayerInfo {
	/**
	 * 用户名
	 */
	public String name;

	/**
	 * 分数
	 * 指玩家玩游戏的总分,存在数据库
	 * 暂定赢一盘加2分,输一盘减1分,平局得1分
	 */
	public int score;
}
