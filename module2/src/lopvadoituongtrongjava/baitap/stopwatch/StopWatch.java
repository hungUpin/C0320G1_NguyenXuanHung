package lopvadoituongtrongjava.baitap.stopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class StopWatch {
    //Getting the current date

    private long startTime;
    private long endTime;
    public long getStartTime(){
        return this.startTime;
    }
    public long getEndTime(){
        return this.endTime;
    }
    public void start(){
        Date date = new Date();
        this.startTime = date.getTime();
    }
    public void end(){
        Date date = new Date();
        this.endTime = date.getTime();
    }
    public long getElapsedTime(){
        return  getEndTime()-getStartTime();
    }
}

