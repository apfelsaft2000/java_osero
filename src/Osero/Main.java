package Osero;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//ゲームが進行中かの管理フラグ
		boolean gameCheak =true;
		//場面表示のインスタンス化
		Screen screen = new Screen();
		//標準入力のインスタンス化
		Scanner scan = new Scanner(System.in);
		//乱数のインスタンス化
		Random ran = new Random();

		//画面の初期化
		screen.initialize();
		while(gameCheak) {
			screen.showBorad();
			String enemy_color=screen.getWHITE();
			String my_color=screen.getBLACK();
			System.out.println("あなたのコマ色は" + screen.getBLACK() + "です");
			System.out.println("あなたの手番です");
			while(true) {
				System.out.println("置くマスの縦軸の座標を入力してください.パスの場合はpを押してください");
				int inputx = scan.nextInt();
				System.out.println("置くマスの横軸の座標を入力してください.パスの場合はpを押してください");
				int inputy = scan.nextInt();
				if(Rule.rule(inputx,inputy,screen,enemy_color,my_color)) {
					Rule.frip(inputx,inputy,screen,enemy_color,my_color);
					screen.showBorad();
					break;
				}else {
					System.out.println("そこにはおけません。もう一度手を打ってください");
					continue;
				}
			}

			//コマの数をカウントして盤が埋まったらゲームを終了する
			gameCheak = screen.cal();
			System.out.println("CPUの手番です");
			//Rule.turn_switch(my_color,enemy_color);
			my_color=screen.getWHITE();
			enemy_color=screen.getBLACK();
			System.out.println(my_color);
			//CPUの設定を記述.手をランダムに生成し、打てる配置が生成されるまでループを続ける。
			int count =0;
			while(true) {
				int CPU_x = ran.nextInt(8);
				int CPU_y = ran.nextInt(8);
				if(Rule.rule(CPU_x,CPU_y,screen,enemy_color,my_color)) {
					Rule.frip(CPU_x,CPU_y,screen,enemy_color,my_color);
					screen.showBorad();
					break;
				}else {
					count +=1;
					if(count == 100) {
						break;
					}
					continue;

				}
			}
			//コマの数をカウントして盤が埋まったらゲームを終了する
			gameCheak = screen.cal();
			//Rule.turn_switch(my_color,enemy_color);

			//勝敗の判定、両者パスが続くと石の数をカウントして勝敗を出力。ゲームを終了する
			//break;
		}



	}

}
