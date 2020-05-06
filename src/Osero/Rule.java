package Osero;

public class Rule {
	//オセロのルールの記述
	//boolean my_color=true; //自分の色の把握:true:黒(自分)、false：白
	//盤のおけるコマの座標の指定
	//int x; //横
	//int y; //縦

	//ルールの記述,コマがおける時はtrueを返す
	public static boolean rule(int x,int y,Screen screen,String enemy_color,String my_color) {
		//置こうとした場所が空白以外ならfalseを返す
		if(screen.getBorad()[x][y] != screen.getEMPTY()) {
			return false;
		}
		//オセロのコマをおける場所の所得
		//if(my_color) {
		for(int i =0;i<screen.getBorad().length;i++) {
			int p=x;int q=y;
			p += Screen.dir[i][0];
			q += Screen.dir[i][1];
			//System.out.println(p);
			//System.out.println(q);
			//周囲8マスが盤外にある場合、スキップする
			if(p == -1 || p == 8 || q == -1 || q == 8) {
				continue;
			}

			//周囲8マスに相手のコマがある場合
			if(screen.getBorad()[p][q] == enemy_color) {
				while(true) {
					//更に周囲8マスを調べる
					p += Screen.dir[i][0];
					q += Screen.dir[i][1];
					//自分の色があったので、裏返せる
//					System.out.println(p);
//					System.out.println(q);
					//周囲8マスが盤外にある場合、スキップする
					if(p == -1 || p == 8 || q == -1 || q == 8) {
						continue;
					}
					if(screen.getBorad()[p][q] == my_color) {
						return true;
					//相手の色が続いているのでまだまだ先を探す
					}else if(screen.getBorad()[p][q] == enemy_color) {
						continue;
					}
					//盤の壁にぶつかったのでループを抜ける
					break;
				}
			}
		}
	return false;
	}

	//相手のコマをひっくり返すメソッド
	public static void frip(int x,int y,Screen screen,String enemy_color,String my_color) {
		//おいたマスを自分の色にする
		screen.getBorad()[x][y] = my_color;
		for(int i=0;i<screen.getBorad().length;i++) {
			int p=x;int q=y;
			p += Screen.dir[i][0];
			q += Screen.dir[i][1];
			//System.out.println(Screen.dir[i][1] + y);
			//System.out.print(i + "," + p + ",");
			//System.out.println(q);
			//System.out.println(screen.getBorad()[p][q] + "," + enemy_color);
			//周囲8マスが盤外にある場合、スキップする
			if(p == -1 || p == 8 || q == -1 || q == 8) {
				continue;
			}
			if(screen.getBorad()[p][q] == enemy_color) {
				//相手のコマが続いている範囲を調べる
				//System.out.print(p + ",");
				//System.out.println(q);

				while(true) {
					p += Screen.dir[i][0];
					q += Screen.dir[i][1];
					//System.out.println(screen.getBorad()[p][q]);
					//自分の色が来たので、それまでの色を自分の色にひっくり返す
					//周囲8マスが盤外にある場合、スキップする
					if(p == -1 || p == 8 || q == -1 || q == 8) {
						continue;
					}
					if(screen.getBorad()[p][q] == my_color) {
						while(true) {
							p -= Screen.dir[i][0];
							q -= Screen.dir[i][1];
							//if()
							//周囲8マスが盤外にある場合、スキップする
							if(p == -1 || p == 8 || q == -1 || q == 8) {
								continue;
							}
							screen.getBorad()[p][q] = my_color;
							//System.out.println(screen.getBorad()[p][q]);
							//自分の色まで来たらループから抜ける
							if(screen.getBorad()[p][q] == my_color) {
								break;
							}
						}
					}else if(screen.getBorad()[p][q] == enemy_color) {
						continue;
					}
					break;
				}
			}
		}
	}
	public static void turn_switch(String my_color,String enemy_color) {
		String my_turn = my_color;
		String enemy_turn = enemy_color;
		my_color = enemy_turn;
		enemy_color = my_turn;

	}

	//ゲームの終了条件.おける場所がなくなったらゲームをfasle,まだあるならtrueを返す
	public static void gameCheak() {

	}



}




