public class dlCalculator
{
    //0 for MB, 1 for GB
    private int mode = 0;

    public int getMode()
    {
        return mode;
    }

    public void setMode(int mode)
    {
        this.mode = mode;
    }

    public int mbCalc(double size, double speed)
    {
        double seconds;

        seconds = size/speed;

        return (int) Math.round(seconds);
    }

    public int gbCalc(double size, double speed)
    {
        double seconds;

        size *= 1000;
        seconds = size/speed;

        return (int) Math.round(seconds);
    }


}
