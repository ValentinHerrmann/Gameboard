package bbe;

import java.awt.*;

@SuppressWarnings("unused")
class Hitbox
{
    private int x;
    private int y;
    private int previousX;
    private int previousY;
    private int width;
    private int height;
    private int previousHeight;
    private int previousWidth;

    private boolean intersectsFromTop;
    private boolean intersectsFromBottom;
    private boolean intersectsFromLeft;
    private boolean intersectsFromRight;

    private boolean intersectionsDetermined;

    private boolean lastWasCollision;


    Hitbox(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void setCoordinates(int x, int y)
    {
        previousX = this.x;
        previousY = this.y;
        this.x = x;
        this.y = y;

        intersectionsDetermined = false; // = intersectsFromTop = intersectsFromBottom = intersectsFromLeft = intersectsFromRight = false;
    }

    void setWidth(int width)
    {
        previousWidth = this.width;
        this.width = width;
    }

    void setHeight(int height)
    {
        previousHeight = this.height;
        this.height = height;
    }

    Polygon getPolygon()
    {
        int[] xPoints = {x, x + width, x + width, x};
        int[] yPoints = {y, y, y + height, y + height};

        return new Polygon(xPoints, yPoints, 4);
    }

    boolean collidesWithOther(Hitbox other)
    {
        Polygon lp = lastStepPolygon();
        Polygon op = other.getPolygon();
        lastWasCollision = lp.intersects(op.getBounds());
        return lastWasCollision;
    }

    boolean collidesWithOther_fromAbove(Hitbox other)
    {
        if(!collidesWithOther(other))
        {
            return false;
        }
        if(!intersectionsDetermined)
        {
            determineIntersections(other);
        }
        return intersectsFromTop;
    }

    boolean collidesWithOther_fromBelow(Hitbox other)
    {
        boolean prevWasCollission = lastWasCollision;
        if(!collidesWithOther(other))
        {
            return false;
        }

        if(!prevWasCollission || !intersectionsDetermined)
        {
            determineIntersections(other);
        }
        return intersectsFromBottom;
    }

    boolean collidesWithOther_fromLeft(Hitbox other)
    {
        boolean prevWasCollission = lastWasCollision;
        if(!collidesWithOther(other))
        {
            return false;
        }
        if(!prevWasCollission || !intersectionsDetermined)
        {
            determineIntersections(other);
        }
        return intersectsFromLeft;
    }

    boolean collidesWithOther_fromRight(Hitbox other)
    {
        boolean prevWasCollission = lastWasCollision;
        if(!collidesWithOther(other))
        {
            return false;
        }
        if(!prevWasCollission || !intersectionsDetermined)
        {
            determineIntersections(other);
        }
        return intersectsFromRight;
    }

    Polygon lastStepPolygon()
    {
        int[] xPoints = new int[8];
        System.arraycopy(getPolygon().xpoints, 0, xPoints, 0, 4);
        System.arraycopy(new Hitbox(previousX,previousY,previousWidth,previousHeight).getPolygon().xpoints, 0, xPoints, 4, 4);

        int[] yPoints = new int[8];
        System.arraycopy(getPolygon().ypoints, 0, yPoints, 0, 4);
        System.arraycopy(new Hitbox(previousX,previousY,previousWidth,previousHeight).getPolygon().ypoints, 0, yPoints, 4, 4);


        if(         previousX  <= 0 && xPoints[0] > previousX + 5*width    // links raus geflogen
                ||  xPoints[0] <= 0 && previousX > xPoints[0] + 5*width    // rechts raus geflogen
                ||  previousY  <= 0 && yPoints[0] > previousY + 5*height    // oben raus geflogen
                ||  yPoints[0] <= 0 && previousY > yPoints[0] + 5*height    // unten raus geflogen
        )
        {
            return getPolygon();
        }
        return new Polygon(xPoints, yPoints, 8);
    }

    private int[] getNormalizedMoveVector()
    {
        int dX = x - previousX;
        int dY = y - previousY;

        int divider = Math.max(Math.abs(dX), Math.abs(dY));
        if(divider == 0)
        {
            return new int[]{0,0};
        }
        return new int[]{(x-previousX)/divider, (y-previousY)/divider};
    }

    private void determineIntersections(Hitbox other)
    {
        boolean prevTop = intersectsFromTop;
        boolean prevBottom = intersectsFromBottom;
        boolean prevLeft = intersectsFromLeft;
        boolean prevRight = intersectsFromRight;

        intersectsFromTop = intersectsFromBottom = intersectsFromLeft = intersectsFromRight = false;

        Rectangle step = new Rectangle(previousX,previousY,width,height);
        int[] moveVector = getNormalizedMoveVector();

        if(moveVector[0] == 0 && moveVector[1] == 0)
        {
            intersectsFromTop = prevTop;
            intersectsFromBottom = prevBottom;
            intersectsFromLeft = prevLeft;
            intersectsFromRight = prevRight;
            return;
        }

        while((step.x != x || step.y != y) && (!intersectsFromTop && !intersectsFromBottom && !intersectsFromLeft && !intersectsFromRight))
        {
            intersectsFromTop = step.intersectsLine(other.x, other.y, other.x+other.width, other.y);
            intersectsFromBottom = step.intersectsLine(other.x, other.y+other.height, other.x+other.width, other.y+other.height);
            intersectsFromLeft = step.intersectsLine(other.x, other.y, other.x, other.y+other.height);
            intersectsFromRight = step.intersectsLine(other.x+other.width, other.y, other.x+other.width, other.y+other.height);

            if(intersectsFromTop || intersectsFromBottom || intersectsFromLeft || intersectsFromRight)
            {
                break;
            }

            step.setLocation((int)step.getX() + moveVector[0], (int)step.getY() + moveVector[1]);
        }
        intersectionsDetermined = true;
    }
}
