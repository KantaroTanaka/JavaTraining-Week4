# JavaTraining-Week4

## プロジェクト概要
Spring Boot3を使用して、最小限のREST APIを構築しました。Hello APIからTaskモデルを用いたメモリ内でのタスク管理までを実装しています。

## 開発環境
**JDK**：21
**Framework**：Spring Boot 3.5.9
**Build Tool**: Gradle
**IDE**: VS Code

## セットアップと手順
**1．リポジトリをクローン**
**2．サーバー起動（PowerShell）**　./gradlew.bat bootRun
**3．動作確認（PowerShell）**
Hello API: Invoke-RestMethod http://localhost:8080/hello
タスク登録: Invoke-RestMethod -Uri http://localhost:8080/api/tasks -Method Post -ContentType "application/json" -Body '{"title":"new task"}'
タスク一覧: Invoke-RestMethod http://localhost:8080/api/tasks

## 苦労した点、解決した内容
Java25がインストールされていたため、Gradleのビルドに失敗したので、Java21をインストール、環境変数の再設定をし、正常に起動できるようになった。

標準的なcurlコマンドがエラーになったため、Invoke-RestMethodを使用した動作確認手順を確立した。

## 提出に関する補足
課題提出というコミットで、課題1から課題3をまとめて提出しておりますが、これは当初自身で作成した別リポジトリにて進めてしまい、提出直前にForkが必要であることに気づきファイルを移行したためです。本来であれば、機能ごとにコミットを分けるべきところ、一括での反映となってしまいました。開発過程では、Javaバージョンの解決、REST APIの段階的な実装を確実に行っております。

