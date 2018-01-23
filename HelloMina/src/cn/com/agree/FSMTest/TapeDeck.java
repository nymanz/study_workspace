package cn.com.agree.FSMTest;

public interface TapeDeck {
	void load(String nameOfTape);
    void eject();
    void start();
    void play();
    void pause();
    void stop();
}
