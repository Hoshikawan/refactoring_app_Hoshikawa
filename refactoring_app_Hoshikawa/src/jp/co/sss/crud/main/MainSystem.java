package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;
		final int ALL_DISPLAY = 1;
		final int EMPLOYEE_NAME_SEARCH = 2;
		final int DEPARTMENT_SEARCH = 3;
		final int NEW_INSERT = 4;
		final int UPDATE = 5;
		final int DELETE = 6;
		final int END_SYSTEM = 7;
		

		/*
		 * do-while文のdoは、条件チェックをすることなく必ず最初の一回はdoを通って処理を行う。
		 * 		→つまり、最初の１回だけ条件チェックをしない。という意味であり、戻らないという事ではない。
		 * ただ、条件チェックのタイミングがwhile文の後ろにあるだけで、条件式がないわけではない。
		 */
		do {
			// メニューの表示
			System.out.println("=== 社員管理システム ===");
			System.out.println("1.全件表示");
			System.out.println("2.社員名検索");
			System.out.println("3.部署ID検索");
			System.out.println("4.新規登録");
			System.out.println("5.更新");
			System.out.println("6.削除");
			System.out.println("7.終了");
			System.out.print("メニュー番号を入力してください：");

			// メニュー番号の入力
			String stringMenuNumber = br.readLine();
			menuNo = Integer.parseInt(stringMenuNumber);

			// 機能の呼出
			switch (menuNo) {
			case ALL_DISPLAY:
				// 全件表示機能の呼出
				// find → allDisplay（メソッド名の変更）
				DBController.allDisplay();
				break;

			case EMPLOYEE_NAME_SEARCH:
				// 社員名検索
				System.out.print("社員名:");

				// 検索機能の呼出
				// findB → employeeNameSearch（メソッド名の変更）
				DBController.employeeNameSearch();
				break;

			case DEPARTMENT_SEARCH:
				// 検索する部署IDを入力
				System.out.print("部署ID(1:営業部、2:経理部、3:総務部)を入力してください:");
				String deptIdA = br.readLine();

				// 検索機能の呼出
				// findC → divisionSearch（メソッド名の変更）
				DBController.divisionSearch(deptIdA);
				break;

			case NEW_INSERT:
				// 登録する値を入力
				System.out.print("社員名:");
				String emp_name = br.readLine();
				System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
				String Seibetsu = br.readLine();
				System.out.print("生年月日(西暦年/月/日):");
				String birthday = br.readLine();
				System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
				String deptIdB = br.readLine();

				// 登録機能の呼出
				// insert → newInsert（メソッド名の変更）
				DBController.newInsert(emp_name, Seibetsu, birthday, deptIdB);
				break;

			case UPDATE:
				// 更新する社員IDを入力
				System.out.print("更新する社員の社員IDを入力してください：");

				// 更新する値を入力する
				String empId_1 = br.readLine();
				Integer.parseInt(empId_1);

				// 更新機能の呼出
				DBController.update(empId_1);
				System.out.println("社員情報を更新しました");

				break;

			case DELETE:
				// 削除する社員IDを入力
				System.out.print("削除する社員の社員IDを入力してください：");

				// 削除機能の呼出
				DBController.delete();
				break;

			}
			/*
			 * whileの中に書く条件式は、「ループを続けたい条件」を書く。
			 * 	条件式は「質問文」だと認識すると理解がしやすい。
			 * 		menuNo != 7→「menuNoは7ではないか？」という質問。
			 * 		・menuNo が 7 以外の場合
			 * 			例）「1 != 7」, 「2 != 7」, 「3 != 7」, 「6 != 7」 など
			 * 			→ 条件は true
			 * 			→ ループを続ける
			 *
			 * 		・menuNo が 7 の場合
			 * 			「7 != 7」 は成り立たない
			 * 			→ 条件は false
			 * 			→ ループを終了する
			 * 	
			 *  つまりこの条件式は「終了番号（7）が選ばれるまで、処理を繰り返す」という意味になる。
			 * 	もし while (menuNo == 7) と書いてしまうと、「7 == 7」という意味になり、
			 * 「7が選ばれている間だけループする」ことになり、終了したいのにループし続ける、逆の動きになる。
			 */
		} while (menuNo != END_SYSTEM);
		System.out.println("システムを終了します。");
	}
}
