package com.kumbirai.udemy.functional.section8;

public class CommandDesignDemo
{
	public static void main(String[] args)
	{
		AC ac1 = new AC();
		AC ac2 = new AC();

		ACAutomationRemote remote = new ACAutomationRemote();
		remote.setCommand(() -> ac1.incTemp());
		remote.buttonPressed();

		//		ACAutomationRemote remote = new ACAutomationRemote()
		remote.setCommand(() -> ac2.turnOn());
		remote.buttonPressed();
	}
}
