# タスク管理システム (JavaTraining-Final)

## プロダクト概要
ログイン機能とREST APIを備えた、シンプルなタスク管理Webアプリケーションです。
タスクの登録・閲覧・編集・削除（CRUD操作）を行うことができます。

## 開発環境
* **JDK:** 21
* **Framework:** Spring Boot 3.5.9
* **Build Tool:** Gradle
* **IDE:** VS Code
* **Database:** H2 Database (インメモリ)

## セットアップ手順
1. リポジトリをクローンまたはダウンロードします。
2. VS Codeでプロジェクトを開きます。
3. アプリケーションを起動します。
   * **方法A（IDE）:** `src/main/java/com/example/taskapp/TaskApplication.java` を実行します。
   * **方法B（コマンド）:** ターミナルで `./gradlew.bat bootRun` を実行します。
4. ブラウザで以下のURLにアクセスしてください。
   http://localhost:8080/tasks

## 動作確認手順
### 1. 画面からの操作
自動的にログイン画面へリダイレクトされるため、以下の初期ユーザー情報でログインしてください。
* **ユーザー名:** testuser
* **パスワード:** password

ログイン後は、画面上のボタンからタスクの新規登録、編集、削除、およびログアウトの操作が可能です。

### 2. APIの操作
以下のエンドポイントでJSON形式のデータ通信が可能です。
* **全件取得 (GET):**
  ```bash
  curl http://localhost:8080/api/tasks
  curl -X POST -H "Content-Type: application/json" -d "{\"title\":\"APIテスト\",\"completed\":false}" http://localhost:8080/api/tasks

## アーキテクチャ図・パッケージ構成
  com.example.taskapp
 ┣ config/      # Spring Securityの認証・アクセス制御設定
 ┣ controller/  # 画面用(View)とAPI用(REST)の窓口
 ┣ entity/      # データベースのテーブル設計(Task)
 ┣ exception/   # 404エラーなどの例外ハンドリング
 ┣ repository/  # データベースとのやり取り(JPA)
 ┗ service/     # ビジネスロジック・処理のまとめ役

 ## 今後の改善点
 1. パスワードの再発行機能の追加
 2. タスクの検索・絞り込み機能の実装
 3. タスクの優先度（高・中・低）を設定・並び替えできる機能