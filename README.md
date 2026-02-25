# JavaTraining-Week7

## 開発環境
**JDK**：21
**Framework**：Spring Boot 3.5.9
**Build Tool**: Gradle
**IDE**: VS Code
**Database**: H2 Database

## セットアップ手順
1. リポジトリをクローンまたはダウンロードします。
2. VS Codeでプロジェクトを開きます。
3. `src/main/java/com/example/taskapp/TaskApplication.java` を実行してサーバーを起動します
4. ブラウザで以下のURLにアクセスしてください。
    http://localhost:8080/tasks
    ※アクセスすると自動的にログイン画面（`/login`）へリダイレクトされます。

## 確認用アカウント（テストユーザー）
アプリケーション起動時に、自動で以下のテストユーザーが作成されます。動作確認にご利用ください。
* **ユーザー名**: testuser2
* **パスワード**: password