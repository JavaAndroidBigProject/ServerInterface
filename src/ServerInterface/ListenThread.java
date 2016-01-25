package ServerInterface;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.function.BooleanSupplier;

/**
 * 监听服务器消息的线程
 */
class ListenThread extends Thread{
	Socket socket;
	OriginInterface originInterface;
	public ListenThread(Socket socket, OriginInterface originInterface){
		this.socket = socket;
		this.originInterface = originInterface;
	}
	@Override
	public void run(){
		try {
			Scanner scanner = new Scanner(socket.getInputStream());
			while(scanner.hasNext()){
				String commandsLine = scanner.nextLine();
				String [] commands = commandsLine.split("#");
				switch (commands[0]){
					case "ON_RESPOND_REGISTER":
						originInterface.onRespondRegister(Boolean.parseBoolean(commands[1]), commands[2]);
						break;
					case "ON_RESPOND_LOGIN":
						originInterface.onRespondLogin(Boolean.parseBoolean(commands[1]), Integer.parseInt(commands[2]));
						break;
					case "ON_RESPOND_GET_TABLES":
						//originInterface.onRespondGetTables();
						//TODO:还没想好
						break;
					case "ON_RESPOND_ENTER_TABLE":
						originInterface.onRespondEnterTable(Integer.parseInt(commands[1]),Boolean.parseBoolean(commands[2]), commands[3]);
						break;
					case "ON_TABLE_CHANGE":
						//originInterface.onTableChange();
						//TODO:还没想好
						break;
					case "ON_GAME_OVER":
						originInterface.onGameOver(Boolean.parseBoolean(commands[1]),Boolean.parseBoolean(commands[2]),Boolean.parseBoolean(commands[3]));
						break;
					case "ON_RESPOND_RETRACT":
						originInterface.onRespondRetract(Boolean.parseBoolean(commands[1]));
						break;
					case "ON_OPPONENT_RETRACT":
						originInterface.onOpponentRetract();
						break;
					case "ON_RECEIVE_MESSAGE":
						originInterface.onReceiveMessage(commands[1]);
						break;
					case "ON_RESPOND_QUIT_TABLE":
						originInterface.onRespondQuitTable(Boolean.parseBoolean(commands[1]));
						break;
					default:
						throw new Exception("Wrong command:" + commandsLine);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			originInterface.onLostConnection(e.getMessage());
		}
	}
}
