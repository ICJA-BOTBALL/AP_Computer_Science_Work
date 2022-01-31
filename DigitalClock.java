/**
 * This class is intended to model a 12-hour digital clock (e.g. 07:34:52 or 12:02:59).
 * The clock is able to be set to a specific time and then accurately begin keeping time. 
 * When appropriate, the time rolls over to the next minute, next hour, or both. 
 * 
 * //Add your name after "author" below.
 * @author Hershel Thomas
 */
public class DigitalClock
{

    //Fill in the necessary fields below
    static boolean europeanTime;
    private int limit;
    private int hour;
    private int minute;
    private int second;
    private int cap;
    private String display;
    private String hourDisplay;
    private String minuteDisplay;
    private String secondDisplay;
    static void europeanTime(boolean armyTime)
    {
        if (armyTime == true)
        {
            europeanTime = true;
        } else
        {
            europeanTime = false;
        }
    }
    /**
     * Constructor for objects of class DigitalClock
     * Replace the constructor. 
     * Rather than assigning the fields with the parameters in 3 different statements,
     * make a call to the setTime method using the constructor's parameters as the 
     * setTime method's parameters
     */
    public DigitalClock(int h, int m, int s)
    { 
        if (europeanTime == true)
        {
            limit = 24;
        } else
        {
            limit = 13;
        }
        
        setTime(h, m, s);
    }

    /**
    * Assigns the fields by calling the appropriate set methods. 
    * In order to set the time, you must set the hour, set the minute, and set the second.
    */
    public void setTime(int h, int m, int s)
    {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    /**
    * Mutator method for the hour field. 
    * It should check if the parameter is valid. If the parameter is less than 1,
    * assign hour a value of 1. If the parameter is greater than 12, assign hour a value of 12.
    * Fill in below. 
    */
    public void setHour(int h)
    {
        if (europeanTime == true)
        {
            cap = 0;
        } else
        {
            cap = 1;
        }
        if (h < cap) 
        {
            hour = cap;
            setMinute(0);
            setSecond(0);
        } 
        else if (h >= limit) 
        {
            hour = limit - 1;
            setMinute(0);
            setSecond(0);
        } else 
        {
            hour = h;
        }
    }
    
    /**
     * Mutator method for the hour field. 
     * It should check if the parameter is valid. If the parameter is invalid,
     * assign it a value of 0.
     * Fill in below. 
     */
    public void setMinute(int m)
    {
        if (m < 0 || m > 59)
        {
            minute = 0;
        } else
        {
            minute = m;
        }
    }
    
    /**
     * Mutator method for the hour field. 
     * It should check if the parameter is valid. If the parameter is invalid,
     * assign it a value of 0.
     * Fill in below. 
     */
    public void setSecond(int s)
    {
        if (s < 0 || s > 59)
        {
            second = 0;
        } else
        {
            second = s;
        }
    }

    /**
     * Update the hour field to the next hour.
     * Take note that nextHour() of 23:47:12 is 00:47:12. 
     */
    public void nextHour()
    {
        if (europeanTime == true) 
        {
            
            if ((hour + 1) % limit == 0)
            {
                hour = 0;
            } else
            {
                hour = (hour + 1) % limit;
            }
        } else
        {
            hour += 1;
            if (hour % limit == 0)
            {
                hour = 1;
            }
        }
        
    }
    
    /**
     * Update the minute field to the next minute.
     * Take note that nextMinute() of 03:59:13 is 04:00:13. 
     */
    public void nextMinute()
    {
        minute = (minute + 1) % 60;
        if (minute == 0) 
        {
            nextHour();
        }
    }
    
    /**
     * Update the second field to the next second.
     * Take note that nextSecond() of 23:59:59 is 00:00:00. 
     */
    public void nextSecond()
    {
        second = (second + 1) % 60;
        if (second == 0)
        {
            nextMinute();
        }
    }
    
    /**
     * Accessor method for the hour field. 
     * Replace below. 
     */
    public int getHour()
    {
        if (hour < 10)
        {
            hourDisplay = "0";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        } else 
        {           
            hourDisplay = "";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        }
        return hour;
    }
    
    /**
     * Accessor method for the minute field. 
     * Replace below. 
     */
    public int getMinute()
    {
        
        if (minute < 10)
        {
            minuteDisplay = ":0";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        } else 
        {
            minuteDisplay = ":";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        }
        return minute;
    }
    
    /**
     * Accessor method for the second field. 
     * Replace below. 
     */
    public int getSecond()
    { 
        
        if (second < 10)
        {
            secondDisplay = ":0";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        } else 
        {
            secondDisplay = ":";
            displays(hourDisplay, minuteDisplay, secondDisplay);
        }
        
        return second;    
    }
    public String displays(String ho, String mi, String se)
    {
        display = ho + String.valueOf(hour) + mi + String.valueOf(minute) + se + String.valueOf(second);
        return display;
    }
    /**
     * returns "HH:MM:SS"
     * Hint: You might find it helpful to create a local String variable and progressively add to it.
     * Replace below. 
     */
    @Override 
    public String toString()
    {
        if (hour < 10 && minute < 10 && second < 10) 
        {
            return displays("0", ":0", ":0");
        } else if (hour < 10 && minute < 10) 
        {
            return displays("0", ":0", ":");
        } else if (hour < 10 ) 
        {
            return displays("0", ":", ":");
        } else if (minute < 10 && second < 10) 
        {
            return displays("", ":0", ":0");
        } else if (minute < 10) 
        {
            return displays("", ":0", ":");
        } else if (second < 10) 
        {
            return displays("", ":", ":0");
        } else
        {
            return displays("", ":", ":");
        }
        
    }

}
