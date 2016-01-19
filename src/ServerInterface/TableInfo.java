package ServerInterface;

/**
 * 游戏桌状态信息
 */
public class TableInfo {
	/**
	 * 游戏桌编号
	 */
	public int id;

	/**
	 * 玩家1信息
	 * 若空表示无玩家1
	 */
	public PlayerInfo player1;

	/**
	 * 玩家2信息
	 * 若空表示无玩家2
	 */
	public PlayerInfo player2;
}
