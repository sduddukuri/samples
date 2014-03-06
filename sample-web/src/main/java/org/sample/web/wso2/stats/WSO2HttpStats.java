package org.sample.web.wso2.stats;

public class WSO2HttpStats {
	
	private String connectionId;

	public WSO2HttpStats(String connectionId) {
		super();
		this.connectionId = connectionId;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}
	
	

}
