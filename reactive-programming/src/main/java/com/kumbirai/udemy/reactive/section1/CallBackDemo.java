package com.kumbirai.udemy.reactive.section1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallBackDemo
{
	private static final Logger LOG = LoggerFactory.getLogger(CallBackDemo.class);

	public static void main(String[] args) throws InterruptedException
	{
		LOG.info("Main Thread is running");

		Runnable r = new Runnable()
		{
			@Override
			public void run()
			{
				new CallBackDemo().runningAsync(new CallBack()
				{
					@Override
					public void pushData(String data)
					{
						LOG.info("CallBack data: {}",
								data);
					}

					@Override
					public void pushComplete()
					{
						LOG.info("Callback done !");
					}

					@Override
					public void pushError(Exception ex)
					{
						LOG.error("Callback Error called, exception caught:",
								ex);
					}
				});
			}
		};

		Thread t = new Thread(r);
		t.start();

		Thread.sleep(2000);

		LOG.info("Main thread Completed!");
	}

	public void runningAsync(CallBack callback)
	{
		LOG.info("I am running in a separate thread");
		sleep(1000);
		callback.pushData("Data1");
		callback.pushData("Data2");
		callback.pushData("Data3");

		callback.pushError(new RuntimeException("Oops!"));
		callback.pushComplete();
	}

	private void sleep(int duration)
	{
		try
		{
			Thread.sleep(duration);
		}
		catch (InterruptedException e)
		{
			LOG.error("Exception Caught: ",
					e);
			Thread.currentThread()
					.interrupt();
		}
	}
}
