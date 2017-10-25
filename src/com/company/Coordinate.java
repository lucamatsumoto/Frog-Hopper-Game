package com.company;

public class Coordinate
{
    private static Coordinate[][] coo = new Coordinate[5][5];
    static
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                coo[i][j] = new Coordinate(i, j);
            }
        }
    }
    // instance variables - replace the example below with your own
    private int x;
    private int y;

    private Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if(o == null)
        {
            return false;
        }

        if (o == this)
        {
            return true;
        }

        /* Check if o is an instance of Complex or not
        "null instanceof [type]" also returns false */
        if (!(o instanceof Coordinate))
        {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Coordinate l = (Coordinate) o;

        // Compare the data members and return accordingly
        return x == l.getX() && y == l.getY();

    }
    public static Coordinate get(int x, int y)
    {
        return coo[x][y];
    }
}
