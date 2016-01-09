package ServerInterface;


/**
 * Created by Jason Song(wolfogre@outlook.com) on 01/10/2016.
 */
public abstract class OriginalInterface {

	/**
	 * 请求注册
	 * @param username
	 * 用户名
	 * @param password
	 * 密码
	 */
	final public void register(String username, String password){
		//TODO
	}

	/**
	 * 请求登陆
	 * @param username
	 * 用户名
	 * @param password
	 * 密码
	 */
	final public void login(String username, String password){
		//TODO
	}

	/**
	 * 请求所有游戏桌状态
	 */
	final public void getTables(){
		//TODO
	}

	/**
	 * 请求进入游戏桌
	 * @param tableId
	 * 游戏桌编号
	 */
	final public void enterTable(int tableId){
		//TODO
	}

	/**
	 * 请求举手
	 */
	final public void handUp(){
		//TODO
	}

	/**
	 * 请求落子
	 * @param raw
	 * 行
	 * @param col
	 * 列
	 */
	final public void move(int raw, int col){
		//TODO
	}

	/**
	 * 请求认输
	 */
	final public void giveUp(){
		//TODO
	}

	/**
	 * 请求悔棋
	 */
	final public void retract(){
		//TODO
	}

	/**
	 * 响应对手悔棋
	 * @param ifAgree
	 * 是否同意
	 */
	final public void respondRetract(boolean ifAgree){
		//TODO
	}

	/**
	 * 发送消息
	 * @param message
	 * 消息内容
	 */
	final public void sengMessage(String message){
		//TODO
	}

	/**
	 * 请求退出游戏桌
	 */
	final public void quitTable(){
		//TODO
	}

	/**
	 * 当收到注册响应
	 * @param ifRegistered
	 * 是否注册成功
	 * @param reason
	 * 注册失败的原因
	 */
	abstract public void onRespondRegister(boolean ifRegistered, String reason);

	/**
	 * 当连接服务器失败
	 * @param reason
	 * 连接失败原因
	 */
	abstract public void onConnectionFail(String reason);

	/**
	 * 当失去服务器连接
	 * @param reason
	 * 失去服务器连接原因
	 */
	abstract public void onLostConnection(String reason);

	/**
	 * 当收到登陆响应
	 * @param ifLogined
	 * 是否登陆成功
	 * @param score
	 * 玩家的分数
	 */
	abstract public void onRespondLogin(boolean ifLogined, int score);

	/**
	 * 当收到请求各游戏桌状态响应
	 * @param tables
	 * 各游戏桌状态
	 */
	abstract public void onRespondGetTables(Table[] tables);

	/**
	 * 当收到请求进入游戏桌响应
	 * @param tableId
	 * 游戏桌编号
	 * @param ifEntered
	 * 是否进入游戏桌
	 * @param reason
	 * 进入失败的原因
	 */
	abstract public void onRespondEnterTable(int tableId, boolean ifEntered, String reason);

	/**
	 * 当所在游戏桌状态变化
	 * @param opponentInfo
	 * 对手信息
	 * @param ifMyHandUp
	 * 自己是否举手
	 * @param ifOpponentHandUp
	 * 对手是否举手
	 * @param isPlaying
	 * 游戏是否进行中
	 * @param board
	 * 棋盘的逻辑数组，1表黑棋，2表白旗，0表空
	 * @param isBlack
	 * 自己是否执黑子
	 * @param isMyTurn
	 * 是否轮到自己下
	 */
	abstract public void onTableChange(PlayerInfo opponentInfo,
	                                   boolean ifMyHandUp,
	                                   boolean ifOpponentHandUp,
	                                   boolean isPlaying,
	                                   int board [][],
	                                   boolean isBlack,
	                                   boolean isMyTurn);

	/**
	 * 当游戏结束
	 * @param ifWin
	 * 是否是自己赢
	 * @param ifGiveUp
	 * 是否是某一方认输
	 */
	abstract public void onGameOver(boolean ifWin, boolean ifGiveUp);

	/**
	 * 当收到请求悔棋响应
	 * @param ifAgree
	 * 对手是否同意悔棋，若同意，会随后收到onBoardChange
	 */
	abstract public void onRespondRetract(boolean ifAgree);

	/**
	 * 当收到对手请求悔棋
	 */
	abstract public void onOpponentRetract();

	/**
	 * 当收到消息
	 * @param message
	 * 消息内容
	 */
	abstract public void onReceiveMessage(String message);

	/**
	 * 当请求退出游戏桌响应
	 * @param ifAgree
	 * 退出游戏桌是否成功
	 */
	abstract public void onRespondQuitTable(boolean ifAgree);

}
