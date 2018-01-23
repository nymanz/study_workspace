package cn.com.agree.FSMTest;

import org.apache.mina.statemachine.StateMachine;
import org.apache.mina.statemachine.StateMachineFactory;
import org.apache.mina.statemachine.StateMachineProxyBuilder;
import org.apache.mina.statemachine.annotation.State;
import org.apache.mina.statemachine.annotation.Transition;
import org.apache.mina.statemachine.annotation.Transitions;
import org.apache.mina.statemachine.event.Event;

public class TapeDeckHandler {
	//定义状态常量  
	 @State public static final String ROOT = "Root";
    @State(ROOT) public static final String EMPTY = "Empty";  
    @State(ROOT) public static final String LOADED = "Loaded";  
    @State(ROOT) public static final String PLAYING = "Playing";  
    @State(ROOT) public static final String PAUSED = "Paused";
    /**
     * on表示动作的ID，对应着动作接口中的方法名，
     * in表示的是动作的起始状态，
     * next表示的是动作的后续状态
     * @param nameOfTape
     */
    //当执行load方法 从empty状态转换到loaded状态时执行的方法  
    @Transition(on = "load", in = EMPTY, next = LOADED)  
    public void loadTape(String nameOfTape) {  
        System.out.println("Tape '" + nameOfTape + "' loaded");  
    }  
   
    @Transitions({  
        @Transition(on = "play", in = LOADED, next = PLAYING),  
        @Transition(on = "play", in = PAUSED, next = PLAYING)  
    })  
    public void playTape() {  
        System.out.println("Playing tape");  
    }  
      
    @Transition(on = "pause", in = PLAYING, next = PAUSED)  
    public void pauseTape() {  
        System.out.println("Tape paused");  
    }  
      
    @Transition(on = "stop", in = PLAYING, next = LOADED)  
    public void stopTape() {  
        System.out.println("Tape stopped");  
    }  
      
    @Transition(on = "eject", in = LOADED, next = EMPTY)  
    public void ejectTape() {  
        System.out.println("Tape ejected");  
    }  
    @Transitions({
        @Transition(on = "*", in = ROOT)
    })
    public void error(Event event) {
        System.out.println("Cannot '" + event.getId() + "' at this time");
    }
    
    public static void main(String[] args)
    {
        //  创建录音机事件的句柄
        TapeDeckHandler handler = new TapeDeckHandler();
        // 创建录音机的状态机
        StateMachine sm = StateMachineFactory.getInstance(Transition.class).create(TapeDeckHandler.EMPTY, handler);
        // 使用上面的状态机，通过一个代理创建一个TapeDeck的实例
        TapeDeck deck = new StateMachineProxyBuilder().create(TapeDeck.class, sm);   
        // 加载磁带
        deck.load("The Knife - Silent Shout");
        // 播放
        deck.play();
        // 暂停
        deck.pause();
        // 播放
        deck.play();
        // 停止
        deck.stop();
        //!deck.pause();
        // 退出
        deck.eject();
        deck.play();
    }
     
}
