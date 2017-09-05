package com.temp.designPatterns.state;

public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		
		System.out.println("鎭枩浣犳姇绁ㄦ垚鍔�");
	}

}
