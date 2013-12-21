package org.mocity;
/**
 * 程序入口
 * @author 墨城|叮当小魔怪29 mocsdn@gmail.com
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	private ImageButton btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (ImageButton) findViewById(R.id.kailu);
        btn.setOnClickListener(new btn_chatListener());
    }
    
    /**
     * 按钮事件监听
     */
	class btn_chatListener implements OnClickListener {
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this,ChatActivity.class);
			MainActivity.this.startActivity(intent);
		}
	}
}