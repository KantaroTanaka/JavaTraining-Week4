# タスク管理API (JavaTraining-Week5)
                        
Spring BootとH2 Databaseを使用したタスク管理APIです。
CRUD操作、バリデーション、例外処理を実装しています。

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
* ※データベース(H2)の設定は `src/main/resources/application.yml` に記述済みのため、追加のセットアップは不要です。

## 動作確認 (PowerShell)

### 1. タスク登録
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method Post -ContentType "application/json" -Body '{"title":"Test Task"}'

### 2. タスク一覧
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method Get

### 3. タスク更新 (ID:1)
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/1" -Method Put -ContentType "application/json" -Body '{"title":"Updated"}'

### 4. タスク削除 (ID:1)
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/1" -Method Delete

### エラーハンドリングの動作例
Validationエラー（400 Bad Request）の場合
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks" -Method Post -ContentType "application/json" -Body '{"title":""}'
**リモート サーバーがエラーを返しました: (400) 要求が不適切です**と表示されれば正常です

存在しないIDへのアクセス（404 Not Found）
Invoke-RestMethod -Uri "http://localhost:8080/api/tasks/999" -Method Delete
**リモート サーバーがエラーを返しました: (404) 見つかりません**と表示されれば正常です

## DBデータの確認 (H2 Console)
起動中にブラウザで以下のURLにアクセスすると、DBの中身を確認できます。

* **URL**: http://localhost:8080/h2-console
* **JDBC URL**: `jdbc:h2:mem:tasks`
* **User Name**: `sa`
* **Password**: (空欄のままConnect)