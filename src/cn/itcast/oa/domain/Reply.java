package cn.itcast.oa.domain;

/**
 * 话题
 * @author wxdsg
 *
 */
public class Reply extends Article{

	private Topic topic;//所属的话题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
}
