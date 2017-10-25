package com.company;

public class Move
{
    private com.company.Coordinate firstC;
    private com.company.Hopper firstH;
    private com.company.Coordinate middleC;
    private com.company.Hopper middleH;
    private com.company.Coordinate endC;
    private com.company.Hopper endH;
    public Move(com.company.Coordinate firstC, com.company.Hopper firstH, com.company.Coordinate middleC, com.company.Hopper middleH, com.company.Coordinate endC, com.company.Hopper endH)
    {
        this.firstC = firstC;
        this.firstH = firstH;
        this.middleC = middleC;
        this.middleH = middleH;
        this.endC = endC;
        this.endH = endH;
    }

    public com.company.Coordinate getFirstC()
    {
        return firstC;
    }

    public com.company.Hopper getFirstH()
    {
        return firstH;
    }

    public com.company.Coordinate getMiddleC()
    {
        return middleC;
    }

    public com.company.Hopper getMiddleH()
    {
        return middleH;
    }

    public com.company.Coordinate getEndC()
    {
        return endC;
    }

    public com.company.Hopper getEndH()
    {
        return endH;
    }
}


