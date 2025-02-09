package bbegameboard;

import java.awt.*;

public class Hitbox
{
    private int x;
    private int y;
    private int previousX;
    private int previousY;
    private int width;
    private int height;

    private boolean intersectsFromTop;
    private boolean intersectsFromBottom;
    private boolean intersectsFromLeft;
    private boolean intersectsFromRight;

    private boolean intersectionsDetermined;

    private boolean lastWasCollision;


    public Hitbox(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setCoordinates(int x, int y)
    {
        previousX = this.x;
        previousY = this.y;
        this.x = x;
        this.y = y;

        intersectionsDetermined = false; // = intersectsFromTop = intersectsFromBottom = intersectsFromLeft = intersectsFromRight = false;
    }

    public Polygon getPolygon()
    {
        int[] xPoints = {x, x + width, x + width, x};
        int[] yPoints = {y, y, y + height, y + height};

        return new Polygon(xPoints, yPoints, 4);
    }

    public boolean collidesWithOther(Hitbox other)
    {
        lastWasCollision = lastStepPolygon().intersects(other.getPolygon().getBounds());
        return lastWasCollision;
    }

    public boolean collidesWithOther_fromAbove(Hitbox other)
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

    public boolean collidesWithOther_fromBelow(Hitbox other)
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

    public boolean collidesWithOther_fromLeft(Hitbox other)
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

    public boolean collidesWithOther_fromRight(Hitbox other)
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

    public Polygon lastStepPolygon()
    {
        int[] xPoints = new int[8];
        System.arraycopy(getPolygon().xpoints, 0, xPoints, 0, 4);
        System.arraycopy(new Hitbox(previousX,previousY,width,height).getPolygon().xpoints, 0, xPoints, 4, 4);

        int[] yPoints = new int[8];
        System.arraycopy(getPolygon().ypoints, 0, yPoints, 0, 4);
        System.arraycopy(new Hitbox(previousX,previousY,width,height).getPolygon().ypoints, 0, yPoints, 4, 4);

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
