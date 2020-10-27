package kr.co.ch03;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LgTV implements TV {

	@Inject
	private Speaker spk;
		
	@Autowired
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("LgTV power...");
		internet.access();
	}

	@Override
	public void chUp() {
		System.out.println("LgTV chUp...");
	}

	@Override
	public void soundUp() {
		spk.soundUp();
	}

}
