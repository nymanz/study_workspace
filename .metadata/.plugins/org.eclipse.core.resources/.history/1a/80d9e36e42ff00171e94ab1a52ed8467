package cn.com.agree.OleTest;

import java.awt.BorderLayout;
import java.io.File;   

import org.eclipse.swt.SWT;   
import org.eclipse.swt.SWTError;   
import org.eclipse.swt.layout.FillLayout;   
import org.eclipse.swt.ole.win32.OLE;   
import org.eclipse.swt.ole.win32.OleAutomation;   
import org.eclipse.swt.ole.win32.OleControlSite;   
import org.eclipse.swt.ole.win32.OleFrame;   
import org.eclipse.swt.ole.win32.Variant;   
import org.eclipse.swt.widgets.Composite;   
import org.eclipse.swt.widgets.Display;   

public class WMP extends Composite {
	 private OleAutomation player;   
	  
	    /**  
	     * Create the composite  
	     * @param parent  
	     * @param style  
	     */  
	    public WMP(Composite parent, int style)   
	    {   
	        super(parent, style);   
	        setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));   
	        createContents();   
	    }   
	  
	    protected void createContents()   
	    {   
	        setLayout(new FillLayout());   
	        OleControlSite controlSite;   
	  
	        try  
	        {   
	            OleFrame frame = new OleFrame(this, SWT.NO_TRIM);   
	            frame.setLayoutData(new BorderLayout(0, 0));   
	            frame.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));   
	            controlSite = new OleControlSite(frame, SWT.None, "WMPlayer.OCX.7");   
	            controlSite.setBackgroundImage(SWTResourceManager.getImage(WMP.class,   
	             "/img/1.jpg"));   
	            controlSite.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));   
	            controlSite.setRedraw(true);   
	            controlSite.setLayoutDeferred(true);   
	            controlSite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));   
	            controlSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);   
	            controlSite.pack();   
	        }   
	        catch (SWTError e)   
	        {   
	            System.out.println("Unable to open activeX control");   
	            return;   
	        }   
	        player = new OleAutomation(controlSite);   
	        setFocus();   
	        setUIMode("none");    
	        File file = new File(".");   
	        if (file.exists())   
	        {   
	            File fs[] = file.listFiles();   
	            addPlayList(fs);   
	        }   
	        setMode("loop", true);   
	        play();   
	  
	    }   
	  
	    public boolean loadFile(String URL)   
	    {   
	        int[] ids = player.getIDsOfNames(new String[] { "URL" });   
	        if (ids != null)   
	        {   
	            Variant theFile = new Variant(URL);   
	            return player.setProperty(ids[0], theFile);   
	        }   
	        return false; 
	    }   
	  
	    public void setUIMode(String s)   
	    {   
	        int ids[] = player.getIDsOfNames(new String[] { "uiMode" });   
	        if (ids != null)
	        {   
	            player.setProperty(ids[0], new Variant(s));   
	        }   
	    }   
	  
	    public void setVolume(int v)   
	    {   
	        int value = getVolume();   
	        OleAutomation o = getSetting();    
	        int id[] = o.getIDsOfNames(new String[] { "volume" });   
	        if (id != null)   
	        {   
	            int vv = v + value;   
	            if (vv > 100)   
	            {   
	                vv = 100;   
	            }   
	            o.setProperty(id[0], new Variant(vv));   
	        }   
	  
	    }   
	  
	    public int getVolume()   
	    {   
	        int value = 0;   
	        OleAutomation o = getSetting();   
	        int id[] = o.getIDsOfNames(new String[] { "volume" });   
	        if (id != null)   
	        {   
	            Variant vv = o.getProperty(id[0]);   
	            if (vv != null)   
	                value = vv.getInt();   
	        }   
	        return value;   
	    }   
	  
	    /**  
	     * autoRewind Mode ———indicating whether the tracks are rewound to the  
	     * beginning after playing to the end. Default state is true.  
	     *   
	     * loop Mode ——– indicating whether the sequence of tracks repeats itself.  
	     * Default state is false.  
	     *   
	     * showFrame Mode ——— indicating whether the nearest video key frame is  
	     * displayed at the current position when not playing. Default state is  
	     * false. Has no effect on audio tracks.  
	     *   
	     * shuffle Mode ———- indicating whether the tracks are played in random  
	     * order. Default state is false.  
	     *   
	     * @param m  
	     * @param flag  
	     */  
	  
	    public void setMode(String m, boolean flag)   
	    {   
	        OleAutomation o = getSetting();   
	        int ids[] = o.getIDsOfNames(new String[] { "setMode" });   
	        if (ids != null)   
	        {   
	            o.invoke(ids[0], new Variant[] { new Variant(m), new Variant(flag) });   
	        }   
	  
	    }   
	  
	    private OleAutomation getSetting()   
	    {   
	        OleAutomation o = null;   
	        int ids[] = player.getIDsOfNames(new String[] { "settings" });   
	        if (ids != null)   
	        {   
	            o = player.getProperty(ids[0]).getAutomation();   
	        }   
	        return o;   
	    }   
	  
	    private OleAutomation getControls()   
	    {   
	        OleAutomation o = null;   
	        int ids[] = player.getIDsOfNames(new String[] { "controls" });   
	        if (ids != null)   
	        {   
	            o = player.getProperty(ids[0]).getAutomation();   
	        }   
	        return o;   
	    }   
	  
	    public void setPostion(int s)   
	    {   
	        OleAutomation o = getControls();   
	        int ids[] = o.getIDsOfNames(new String[] { "currentPosition" });   
	        if (ids != null)   
	        {   
	            o.setProperty(ids[0], new Variant(s));   
	        }   
	    }   
	  
	    public void play()   
	    {   
	        OleAutomation o = getControls();   
	        int ids[] = o.getIDsOfNames(new String[] { "play" });   
	        if (ids != null)   
	        {   
	            o.invoke(ids[0]);   
	        }   
	    }   
	  
	    public void stop()   
	    {   
	        OleAutomation o = getControls();   
	        int ids[] = o.getIDsOfNames(new String[] { "stop" });   
	        if (ids != null)   
	        {   
	            o.invoke(ids[0]);   
	        }   
	    }   
	  
	    public void pause()   
	    {   
	        OleAutomation o = getControls();   
	        int ids[] = o.getIDsOfNames(new String[] { "pause" });   
	        if (ids != null)   
	        {   
	            o.invoke(ids[0]);   
	        }   
	    }   
	  
	    public void fullScreen(boolean b)   
	    {   
	        if (true && getSize().x == 0)   
	        {   
	            return;   
	        }   
	        int ids[] = player.getIDsOfNames(new String[] { "fullScreen" });   
	        if (ids != null)   
	        {   
	            player.setProperty(ids[0], new Variant(b));   
	        }   
	    }   
	  
	    public int getPlayState()   
	    {   
	        int state = 0;   
	        int ids[] = player.getIDsOfNames(new String[] { "playState" });   
	        if (ids != null)   
	        {   
	            Variant sv = player.getProperty(ids[0]);   
	            if (sv != null)   
	                state = sv.getInt();   
	        }   
	        return state;   
	    }   
	  
	    public void closeMedia()   
	    {   
	        int ids[] = player.getIDsOfNames(new String[] { "close" });   
	        if (ids != null)   
	        {   
	            player.invoke(ids[0]);   
	        }   
	  
	    }   
	  
	    public void addPlayList(File urls[])   
	    {   
	        int ids[] = player.getIDsOfNames(new String[] { "currentPlaylist" });   
	        if (ids != null)   
	        {   
	            OleAutomation o = player.getProperty(ids[0]).getAutomation();   
	            int idsaddma[] = o.getIDsOfNames(new String[] { "appendItem" });   
	            int idsma[] = player.getIDsOfNames(new String[] { "newMedia" });   
	            if (idsaddma != null && idsma != null)   
	            {   
	                for (File url : urls)   
	                {   
	                    Variant media = player.invoke(idsma[0], new Variant[] { new Variant(url.getAbsolutePath()) });   
	                    if (media != null)   
	                    {   
	                        o.invoke(idsaddma[0], new Variant[] { media });   
	                    }   
	  
	                }   
	            }   
	  
	        }   
	    }   
	  
	    public void play(String url)   
	    {   
	        int idsma[] = player.getIDsOfNames(new String[] { "newMedia" });   
	        if (idsma != null)   
	        {   
	            Variant media = player.invoke(idsma[0], new Variant[] { new Variant(url) });   
	            int cmedia[] = player.getIDsOfNames(new String[] { "currentMedia" });   
	            if (cmedia != null)   
	            {   
	                player.setProperty(cmedia[0], media);   
	                play();   
	            }   
	        }   
	    }   
	  
	  
	    public void playList()   
	    {   
	        File file = new File("");   
	        if (file.exists())   
	        {   
	            File fs[] = file.listFiles();   
	            addPlayList(fs);   
	        }   
	        setMode("loop", true);   
	        play();   
	    }   
	  
}
