package org.usfirst.frc.team2557.robot.math;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

import org.usfirst.frc.team2557.robot.Robot;

public class MemLog {

	/* Helper class to hold file name log message pairs (tuple). */
	private class Message {
		public String file;
		public long message;
		
		
		
		public Message(String logFile, String logMessage) {
			
			file = "C:/Users/Michael/Desktop/MemoryStats";
			message = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		}
	}
	
	/* Helper class for writing messages to files. */
	private static class LogWritter extends Thread {
		
		public LogWritter() {
			
		}
		
		/*
		 * Thread section.
		 */

		// Run - the main for the thread.
		@Override
		public void run() {
			FileWriter currentFile = null;
			Boolean keepRunning = true;
			Message currentMessage;
			try {
				// Keep running unless we are interrupted, but keep running until
				// the queue is empty.
				while (keepRunning || !queue.isEmpty()) {
					try {
						// Take waits until there is a message in the queue and
						// then returns one.
						currentMessage = queue.take();
						
						// Open the file for appending.
						currentFile = new FileWriter(currentMessage.file, true);
						
						// Write the message to the file with DOS/Windows line endings.
						currentFile.write(currentMessage.message + "\r\n");
						
						// Close the file.
						currentFile.close();
						currentFile = null;
					} catch (InterruptedException e) {
						// Try again, but print the exception.
						e.printStackTrace();
					}
					// TODO Look into threads to see if this is the correct way
					// to check and see if it needs to shutdown.
					if (this.isInterrupted()) {
						keepRunning = false;
					}
				}
			} catch (IOException e) {
				// TODO Not having a thread will eventually cause logging to block.
				// So a way to start over would be good.
				e.printStackTrace();
			}
			
			s_logWritter = null;
		}
	}

	public MemLog(String logFile) {
		logFileName = logFile;
		
		/* See if there is a queue yet. */
		if (queue == null) {
			queue = new ArrayBlockingQueue<>(INITIAL_QUEUE_SIZE);
		}
		
		/* See if there is a LogWritter thread yet. */
		if (s_logWritter == null) {
			s_logWritter = new LogWritter();
			
			/* Start the thread so nothing else needs to. */
			s_logWritter.start();
		}

	}
	
	// The number of messages the queue will hold before
	// the queue will block on adding a message.
	public static final int INITIAL_QUEUE_SIZE = 100;
	
	// The queue for the messages needing to be written to the log file.
	private static ArrayBlockingQueue<Message> queue;

	// The writer thread for writing messages to log files.
	private static LogWritter s_logWritter;
	
	/*
	 * Logging section.
	 */

	// Anything logged at or lower than the current log level will be logged.
	// An enum would be nice, but comparing them is a pain in Java.
	public static final int CRITICAL = 0;
	public static final int EMERGENCY = 1;
	public static final int WARNING = 2;
	public static final int INFORMATION = 3;
	public static final int DEBUG = 4;
	
	// Current log level.
	public int currentLogLevel = INFORMATION;
	
	// A default log file.
	private String logFileName = "azthar.out";
	
	// The general logging method.
	// When the log level is at or lower than the current log level
	// puts the message in the queue to be written to the file and logs the
	// message to the console.
	public void LogMessage(int level, String message) {
		// Don't log messages at a log level higher than the current log level.
		if (level > currentLogLevel) {
			return;
		}
		
		try {
			Message currentMessage = new Message(logFileName, message);
			
			// Put the message in the queue.
			// Note: It might block if the queue is full.
			// TODO add a time stamp to the message here.
			queue.put(currentMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Output message to the console.
		System.out.println(message);
	}
	
	// Logs a message at log level critical.
	public void LogCritical(String message) {
		LogMessage(CRITICAL, message);
	}
	
	// Logs a message at log level emergency.
	public void LogEmergency(String message) {
		LogMessage(EMERGENCY, message);
	}
	
	// Logs a message at log level warning.
	public void LogWarning(String message) {
		LogMessage(WARNING, message);
	}
	
	// Logs a message at log level information.
	public void LogInformation(String message) {
		LogMessage(INFORMATION, message);
	}
	
	// Logs a message at log level debug.
	public void LogDebug(String message) {
		LogMessage(DEBUG, message);
	}
}

