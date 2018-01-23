package cn.com.agree.MinaTest2;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.log4j.Level;  
import org.apache.log4j.Logger;  
import org.apache.mina.core.session.IdleStatus;  
import org.apache.mina.core.session.IoSession;  
import org.apache.mina.core.write.WriteRequest;  
import org.apache.mina.filter.logging.LogLevel;  
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;  
/**
 * 自己创建的日志类
 * @author 赵乾泽
 *
 */
public class Log4jFilter extends IoFilterAdapter{
	/** The logger name */  
    private final String name;  
      
    /** The logger */  
    private final Logger logger;  
      
    /** The log level for the exceptionCaught event. Default to WARN. */  
    private LogLevel exceptionCaughtLevel = LogLevel.WARN;  
      
    /** The log level for the messageSent event. Default to INFO. */  
    private LogLevel messageSentLevel = LogLevel.INFO;  
      
    /** The log level for the messageReceived event. Default to INFO. */  
    private LogLevel messageReceivedLevel = LogLevel.INFO;  
      
    /** The log level for the sessionCreated event. Default to INFO. */  
    private LogLevel sessionCreatedLevel = LogLevel.INFO;  
      
    /** The log level for the sessionOpened event. Default to INFO. */  
    private LogLevel sessionOpenedLevel = LogLevel.INFO;  
      
    /** The log level for the sessionIdle event. Default to INFO. */  
    private LogLevel sessionIdleLevel = LogLevel.INFO;  
      
    /** The log level for the sessionClosed event. Default to INFO. */  
    private LogLevel sessionClosedLevel = LogLevel.INFO;  
      
    /** 
     * Default Constructor. 
     */  
    public Log4jFilter(Logger logger) {  
        this.logger=logger;  
        this.name=logger.getName();  
    }  
      
       
       
    /** 
     * @return The logger's name 
     */  
    public String getName() {  
        return name;  
    }  
      
    /** 
     * Log if the logger and the current event log level are compatible. We log 
     * a message and an exception. 
     * 
     * @param eventLevel the event log level as requested by the user 
     * @param message the message to log 
     * @param cause the exception cause to log 
     */  
    private void log(LogLevel eventLevel, String message, Throwable cause) {  
        if (eventLevel == LogLevel.TRACE) {  
            logger.trace(message, cause);  
        } else if (eventLevel.getLevel() > LogLevel.INFO.getLevel()) {  
            logger.info(message, cause);  
        } else if (eventLevel.getLevel() > LogLevel.WARN.getLevel()) {  
            logger.warn(message, cause);  
        } else if (eventLevel.getLevel() > LogLevel.ERROR.getLevel()) {  
            logger.error(message, cause);  
        }  
    }  
    /** 
     * Log if the logger and the current event log level are compatible. We log 
     * a formated message and its parameters. 
     * 
     * @param eventLevel the event log level as requested by the user 
     * @param message the formated message to log 
     * @param param the parameter injected into the message 
     */  
    private void log(LogLevel eventLevel, String message, Object param) {  
        FormattingTuple msgStr = MessageFormatter.format(message, param);  
        if (eventLevel == LogLevel.TRACE) {  
            logger.log(name, Level.TRACE, msgStr, null);  
              
        } else if (eventLevel.getLevel() > LogLevel.INFO.getLevel()) {  
            logger.log(name, Level.INFO, msgStr, null);  
        } else if (eventLevel.getLevel() > LogLevel.WARN.getLevel()) {  
            logger.log(name, Level.WARN, msgStr, null);  
        } else if (eventLevel.getLevel() > LogLevel.ERROR.getLevel()) {  
            logger.log(name, Level.ERROR, msgStr, null);  
        }  
    }  
    /** 
     * Log if the logger and the current event log level are compatible. We log 
     * a simple message. 
     * 
     * @param eventLevel the event log level as requested by the user 
     * @param message the message to log 
     */  
    private void log(LogLevel eventLevel, String message) {  
        if (eventLevel == LogLevel.TRACE) {  
            logger.trace(message);  
        } else if (eventLevel.getLevel() > LogLevel.INFO.getLevel()) {  
            logger.info(message);  
        } else if (eventLevel.getLevel() > LogLevel.WARN.getLevel()) {  
            logger.warn(message);  
        } else if (eventLevel.getLevel() > LogLevel.ERROR.getLevel()) {  
            logger.error(message);  
        }  
    }  
    @Override  
    public void exceptionCaught(NextFilter nextFilter, IoSession session,  
            Throwable cause) throws Exception {  
        log(exceptionCaughtLevel, "EXCEPTION :", cause);  
        nextFilter.exceptionCaught(session, cause);  
    }  
    @Override  
    public void messageReceived(NextFilter nextFilter, IoSession session,  
            Object message) throws Exception {  
        log(messageReceivedLevel, "RECEIVED: {}", message );  
        nextFilter.messageReceived(session, message);  
    }  
    @Override  
    public void messageSent(NextFilter nextFilter, IoSession session,  
            WriteRequest writeRequest) throws Exception {  
        log(messageSentLevel, "SENT: {}", writeRequest.getMessage() );  
        nextFilter.messageSent(session, writeRequest);  
    }  
    @Override  
    public void sessionCreated(NextFilter nextFilter, IoSession session)  
            throws Exception {  
        log(sessionCreatedLevel, "CREATED");  
        nextFilter.sessionCreated(session);  
    }  
    @Override  
    public void sessionOpened(NextFilter nextFilter, IoSession session)  
    throws Exception {  
        log(sessionOpenedLevel, "OPENED");  
        nextFilter.sessionOpened(session);  
    }  
    @Override  
    public void sessionIdle(NextFilter nextFilter, IoSession session,  
            IdleStatus status) throws Exception {  
        log(sessionIdleLevel, "IDLE");  
        nextFilter.sessionIdle(session, status);  
    }  
    @Override  
    public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {  
        log(sessionClosedLevel, "CLOSED");  
        nextFilter.sessionClosed(session);  
    }  
      
    /** 
     * Set the LogLevel for the ExceptionCaught event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setExceptionCaughtLoglevel(LogLevel level) {  
        exceptionCaughtLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the ExceptionCaught event. 
     * 
     * @return The LogLevel for the ExceptionCaught eventType 
     */  
    public LogLevel getExceptionCaughtLoglevel() {  
        return exceptionCaughtLevel;  
    }  
      
    /** 
     * Set the LogLevel for the MessageReceived event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setMessageReceivedLoglevel(LogLevel level) {  
        messageReceivedLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the MessageReceived event. 
     * 
     * @return The LogLevel for the MessageReceived eventType 
     */  
    public LogLevel getMessageReceivedLoglevel() {  
        return messageReceivedLevel;  
    }  
      
    /** 
     * Set the LogLevel for the MessageSent event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setMessageSentLoglevel(LogLevel level) {  
        messageSentLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the MessageSent event. 
     * 
     * @return The LogLevel for the MessageSent eventType 
     */  
    public LogLevel getMessageSentLoglevel() {  
        return messageSentLevel;  
    }  
      
    /** 
     * Set the LogLevel for the SessionCreated event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setSessionCreatedLoglevel(LogLevel level) {  
        sessionCreatedLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the SessionCreated event. 
     * 
     * @return The LogLevel for the SessionCreated eventType 
     */  
    public LogLevel getSessionCreatedLoglevel() {  
        return sessionCreatedLevel;  
    }  
      
    /** 
     * Set the LogLevel for the SessionOpened event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setSessionOpenedLoglevel(LogLevel level) {  
        sessionOpenedLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the SessionOpened event. 
     * 
     * @return The LogLevel for the SessionOpened eventType 
     */  
    public LogLevel getSessionOpenedLoglevel() {  
        return sessionOpenedLevel;  
    }  
      
    /** 
     * Set the LogLevel for the SessionIdle event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setSessionIdleLoglevel(LogLevel level) {  
        sessionIdleLevel = level;  
    }  
      
    /** 
     * Get the LogLevel for the SessionIdle event. 
     * 
     * @return The LogLevel for the SessionIdle eventType 
     */  
    public LogLevel getSessionIdleLoglevel() {  
        return sessionIdleLevel;  
    }  
      
    /** 
     * Set the LogLevel for the SessionClosed event. 
     * 
     * @param level The LogLevel to set 
     */  
    public void setSessionClosedLoglevel(LogLevel level) {  
        sessionClosedLevel = level;  
    }  
    /** 
     * Get the LogLevel for the SessionClosed event. 
     * 
     * @return The LogLevel for the SessionClosed eventType 
     */  
    public LogLevel getSessionClosedLoglevel() {  
        return sessionClosedLevel;  
    }



	@Override
	public void onPreAdd(IoFilterChain parent, String name,
			NextFilter nextFilter) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：onPreAdd");
		super.onPreAdd(parent, name, nextFilter);
	}



	@Override
	public void onPostAdd(IoFilterChain parent, String name,
			NextFilter nextFilter) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：onPostAdd");
		super.onPostAdd(parent, name, nextFilter);
	}



	@Override
	public void onPreRemove(IoFilterChain parent, String name,
			NextFilter nextFilter) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：onPreRemove");
		super.onPreRemove(parent, name, nextFilter);
	}



	@Override
	public void onPostRemove(IoFilterChain parent, String name,
			NextFilter nextFilter) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：onPostRemove");
		super.onPostRemove(parent, name, nextFilter);
	}



	@Override
	public void filterWrite(NextFilter nextFilter, IoSession session,
			WriteRequest writeRequest) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：filterWrite");
		super.filterWrite(nextFilter, session, writeRequest);
	}



	@Override
	public void filterClose(NextFilter nextFilter, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：filterClose");
		super.filterClose(nextFilter, session);
	}



	@Override
	public void inputClosed(NextFilter nextFilter, IoSession session)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Log4jFilter：inputClosed");
		super.inputClosed(nextFilter, session);
	}  
    
}
