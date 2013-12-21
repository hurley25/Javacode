package org.mocity;

/**
 * ����Activity
 * @author ����Сħ��29
 */

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends Activity {

	private ChatAdapter chatHistoryAdapter;
	private List<ChatMessage> messages = new ArrayList<ChatMessage>();
	private ListView lv_chatHistory;
	private Button btn_send;
	private EditText et_content;
	private final String key = "8928e596-02d8-4029-a765-d64795072da4"; // simsimi����Ȩkey
	private final String location = "ch";// ���� ���ģ�ch Ӣ��:en
	private static final int COMPLETED = 0;
	Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == COMPLETED) {
				chatHistoryAdapter.notifyDataSetChanged();
			}
		}
	};

	/**
	 * Activity �״α�����ʱ����
	 */
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chat);

		lv_chatHistory = (ListView) findViewById(R.id.chatting_history_lv);
		setAdapterForThis();
		et_content = (EditText) findViewById(R.id.text_editor);
		btn_send = (Button) findViewById(R.id.send_button);
		btn_send.setOnClickListener(new sendBtnListener());
	}

	/**
	 * ����adapter
	 */
	private void setAdapterForThis() {

		initMessages();
		chatHistoryAdapter = new ChatAdapter(this, messages);
		lv_chatHistory.setAdapter(chatHistoryAdapter);

	}

	/**
	 * ��ΪlistView��ӳ�ʼ����
	 */
	private void initMessages() {
		
		messages.add(new ChatMessage(ChatMessage.MESSAGE_FROM,
				"�����а���С�Ƽ�������˵��ѽ��"));
	}

	/**
	 * �������Ͱ�ť�¼�
	 */

	public class sendBtnListener implements OnClickListener {
		String sendStr;
		String address;
		String str = null;
		String result;
		String msg;
		String response;

		JSONObject jo;

		public void onClick(View v) {
			str = et_content.getText().toString();
			if (str != null
					&& (sendStr = str.trim().replaceAll("\r", "")
							.replaceAll("\t", "").replaceAll("\n", "")
							.replaceAll("\f", "")).length() > 0) {

				messages.add(new ChatMessage(ChatMessage.MESSAGE_TO, sendStr));
				chatHistoryAdapter.notifyDataSetChanged();// �����Ϣ
				et_content.setText("");
				sendMessage(sendStr);
			}
		}

		/**
		 * ��ȡʹ�ö��̴߳�����Ϣ�������쳣��
		 */
		public void sendMessage(final String sendStr) {
			//address = ;
			try {
				address="http://api.simsimi.com/request.p?key=" + key + "&lc="
						+ location + "&ft=1.0&text="+URLEncoder.encode(sendStr,"UTF-8");
				System.out.println(address);
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("ת����ַʧ��"+address);
			}
			//address="http://api.simsimi.com/request.p?key=8928e596-02d8-4029-a765-d64795072da4&lc=ch&ft=1.0&text="+sendStr;
			new Thread(new Runnable() {

				public void run() {
					String replay = HttpTest.doGetNoUrlEncoding(address);
					System.out.println("��������ȡ��������" + replay);
					
					try {
						jo = new JSONObject(replay);

						result = jo.getString("result");
						msg = jo.getString("msg");
						response = jo.getString("response");
						response = URLDecoder.decode(response, "UTF-8");
						if (result.equals("100")) {
							messages.add(new ChatMessage(
									ChatMessage.MESSAGE_FROM, response));
							System.out.println(response);
						} else {
							messages.add(new ChatMessage(
									ChatMessage.MESSAGE_FROM, "ϵͳ��Ϣ��" + result + msg));
						}

					} catch (JSONException e) {
						if(result != null){
							switch (Integer.parseInt(result)) {
							case 404:
								messages.add(new ChatMessage(
										ChatMessage.MESSAGE_FROM, "˵�˻�"));
								break;

							default:
								messages.add(new ChatMessage(
										ChatMessage.MESSAGE_FROM, "���룺" + result + " ������" + msg));
								break;
							}
							
						}else{
							messages.add(new ChatMessage(ChatMessage.MESSAGE_FROM,
									"ϵͳ��Ϣ��δ��ȡ�����ص���Ϣ�������ԣ�"));
						}

						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//chatHistoryAdapter.notifyDataSetChanged();
					Message msg= new Message();
					msg.what=COMPLETED;
					handler.sendMessage(msg);
				}

			}).start();

		}
	}

}
