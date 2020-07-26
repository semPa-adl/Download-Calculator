public class timeCalc
{
    static public String convert(int seconds)
    {
        StringBuilder bld = new StringBuilder();

        int mins;
        int secs;
        int hours = 0;

        mins = seconds/60;
        secs = seconds-(mins*60);

        if (mins >= 60)
        {
            hours = mins/60;
            mins = mins - (hours*60);
        }

        if (hours > 0)
        {
            if (hours == 1)
            {
                bld.append(hours + " hour ");
            }
            else
            {
                bld.append(hours + " hours ");
            }
        }

        if (mins > 0)
        {
            if (mins == 1)
            {
                bld.append(mins + " minute ");
            }
            else
            {
                bld.append(mins + " minutes ");
            }
        }

        if (secs > 0)
        {
            if (mins == 0 && hours == 0)
            {
                bld.append(secs + " seconds");
            }
            else if (secs == 1)
            {
                bld.append("and " + secs + " second");
            }
            else
            {
                bld.append("and " + secs + " seconds");
            }
        }

        return bld.toString();
    }
}
