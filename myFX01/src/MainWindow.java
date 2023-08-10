import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// JavaFXのApplicationクラスを継承している
public class MainWindow extends Application {

    // GUIでのエントリーポイント
    public static void main(String[] args) throws Exception {
        launch();
    }

    // JavaFXでの実働処理
    @Override
    public void start(Stage stage) throws Exception {
        // 標準出力をフックするオブジェクト
        ByteArrayOutputStream bos = this.setTextPrintStream();
        // 好きなロジックを書いたメソッドを実行
        LogicBoard.main(null);

        // 標準出力を文字列に変換
        String msg = bos.toString();
        // 文字列をラベルにセット
        Label lable01 = new Label(msg);
        // ラベルつきのシーンを作成
        Scene scene = new Scene(new StackPane(lable01), 640, 480);
        // シーンをステージにセットして表示
        stage.setScene(scene);
        stage.show();
        // 標準出力を元に戻す
        this.setStandartOutStream();
    }
    // 標準出力をオブジェクトにフックしてオブジェクトを返す
    private ByteArrayOutputStream setTextPrintStream(){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(bos);
        // System.out.println("System.setOut(ps)");
        System.setOut(tps);
        return bos;
    }
    // 標準出力を元に戻す
    private void setStandartOutStream(){
        PrintStream stdout = System.out;
        System.setOut(stdout);
    }
}
