package Osero;

public class Screen {
	//オセロ版の初期化
	static String[][] borad = new String[8][8];

	//コマの情報
	private final String BLACK = "●";
	private final String WHITE = "○";
	private final String EMPTY = "□";
	//盤の数値バージョン
	static int[][] bord = new int[10][10];
	//コマの周囲8マスの座標
	static int[][] dir =
				{{0,1},   //下
				 {0,-1},  //上
				 {1,0},   //右
				 {-1,0},  //左
				 {1,1},   //右下
				 {1,-1},  //右上
				 {-1,-1}, //左上
				 {-1,1}   //左下
				 };



	public String[][] getBorad() {
		return Screen.borad;
	}

	public void setBorad(String[][] borad) {
		Screen.borad = borad;
	}


	public String getBLACK() {
		return BLACK;
	}

	public String getWHITE() {
		return WHITE;
	}

	public String getEMPTY() {
		return EMPTY;
	}

	//駒の配置を初期状態にする
	public void initialize() {
		//コマの要素を全てクリア
		for(int i=0;i<borad.length;i++) {
			for(int j=0;j<borad.length;j++) {
				borad[i][j] = EMPTY;
			}
		}
		//コマを初期配置する
		borad[3][3] = BLACK;
		borad[4][4] = BLACK;
		borad[3][4] = WHITE;
		borad[4][3] = WHITE;

	}
	//コマを描画する
	public void showBorad() {
		System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
		//System.out.println("  ー ー ー  ー ー  ー ー ー");
		for(int i=0;i<borad.length;i++) {
			System.out.print(i);
			for(int j=0;j<borad.length;j++) {
				System.out.print("\t"+ borad[i][j]);
			}
			System.out.println("\n");
			//System.out.println("  ー ー ー  ー ー  ー ー ー");

		}
	}

	//コマの数を集計し、ゲーム終了状況を出力する,true:ゲーム継続、false:ゲーム終了
	public boolean cal() {
		//System.out.println("各コマの数を集計します");
		int kuro=0;int siro=0;int kuhaku=0;
		for(int i =0;i<borad.length;i++) {
			for(int j=0;j<borad.length;j++) {
				if(borad[i][j] == BLACK) {
					kuro +=1;
				}else if(borad[i][j] == WHITE) {
					siro +=1;
				}else {
					kuhaku +=1;
					continue;
				}
			}
		}
		if(kuhaku ==0) {
			System.out.println("ゲーム終了!");
			System.out.println("最終的な各コマ数の集計結果：");
			System.out.println("黒：" + kuro);
			System.out.println("白：" + siro);
			if(kuro<siro) {
				System.out.println("白の勝ち!");
			}else if(kuro>siro) {
				System.out.println("黒の勝ち!");
			}else {
				System.out.println("引き分け!");
			}
			return false;
		}else {
			System.out.println("現状の各コマ数の集計結果：");
			System.out.println("黒：" + kuro);
			System.out.println("白：" + siro);
			return true;
		}

	}





}
