package org.usfirst.frc.team2557.robot.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class Logger extends Thread {

	/*
	 * Singleton section.
	 */
	
	/* The only instance of this Singleton. */
	private static Logger s_logger;
	
	/* Private constructor to enforce the Singleton. */
	private Logger() {
		queue = new ArrayBlockingQueue<>(INITIAL_QUEUE_SIZE);
	}
	
	/* The way to get the one and only instance (Singleton) of the class. */
	public static Logger getInstance() {
		/* See if there is a instance yet. */
		if (s_logger == null) {
			s_logger = new Logger();
			
			/* Start the thread so nothing else needs to. */
			s_logger.start();
		}
		
		return s_logger;
	}
	
	/*
	 * Thread section.
	 */
	
	// The number of messages the queue will hold before
	// the queue will block on adding a message.
	public static final int INITIAL_QUEUE_SIZE = 100;
	
	// The queue for the messages needing to be written to the log file.
	private ArrayBlockingQueue<String> queue;
	
	// Run - the main for the thread.
	@Override
	public void run() {
		FileWriter currentFile = null;
		Boolean keepRunning = true;
		try {
			// Keep running unless we are interrupted, but keep running until
			// the queue is empty.
			while (keepRunning || !queue.isEmpty()) {
				try {
					// Open the file for appending.
					currentFile = new FileWriter(logFileName, true);
					
					// Take waits until there is a message in the queue and
					// then returns one.
					String currentMessage = queue.take();
					
					// Write the message to the file with DOS/Windows line endings.
					currentFile.write(currentMessage + "\r\n");
					
					// Close the file.
					currentFile.close();
					currentFile = null;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Look into threads to see if this is the correct way
				// to check and see if it needs to shutdown.
				if (this.isInterrupted()) {
					keepRunning = false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s_logger = null;
	}
	
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
	public static int currentLogLevel = INFORMATION;
	
	// A default log file.
	public static String logFileName = "azthar.out";
	
	// The general logging method.
	// When the log level is at or lower than the current log level
	// logs the message to the console and puts the message in the queue
	// to be written to the file.
	public static void LogMessage(int level, String message) {
		// Don't log messages at a log level higher than the current log level.
		if (level > currentLogLevel) {
			return;
		}
		
		// Output message to the console.
		System.out.println(message);
		
		try {
			// Put the message in the queue.
			// Note: It might block if the queue is full.
			// TODO add a time stamp here.
			getInstance().queue.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Logs a message at log level critical.
	public static void LogCritical(String message) {
		LogMessage(CRITICAL, message);
	}
	
	// Logs a message at log level emergency.
	public static void LogEmergency(String message) {
		LogMessage(EMERGENCY, message);
	}
	
	// Logs a message at log level warning.
	public static void LogWarning(String message) {
		LogMessage(WARNING, message);
	}
	
	// Logs a message at log level information.
	public static void LogInformation(String message) {
		LogMessage(INFORMATION, message);
	}
	
	// Logs a message at log level debug.
	public static void LogDebug(String message) {
		LogMessage(DEBUG, message);
	}
}
