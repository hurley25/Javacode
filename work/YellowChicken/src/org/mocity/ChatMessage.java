package org.mocity;

/**
 * ChatMessage
 * @author ¶£µ±Ð¡Ä§¹Ö29
 *
 */

public class ChatMessage {

	public static final int MESSAGE_FROM = 0;
	public static final int MESSAGE_TO = 1;

	private int direction;
	private String content;

	public ChatMessage(int direction, String content) {
		super();
		this.direction = direction;
		this.content = content;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CharSequence getContent() {
		return content;
	}

}
