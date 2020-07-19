package cn.jmu.vo;


public class Revert {
	private int revertID;// 回复ID
	private int messageID;// 原帖ID
	private String content;// 回复内容
	private String writer;// 回帖者
	private String writeDate;// 回帖时间

	public int getRevertID() {
		return revertID;
	}

	public void setRevertID(int revertID) {
		this.revertID = revertID;
	}

	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "Revert [revertID=" + revertID + ", messageID=" + messageID + ", content=" + content + ", writer="
				+ writer + ", writeDate=" + writeDate + "]";
	}
}
