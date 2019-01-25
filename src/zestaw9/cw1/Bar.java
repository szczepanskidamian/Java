package zestaw9.cw1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Bar extends Rectangle2D.Float
{
    Bar(int x)
    {
        this.x=x;
        this.y=320;
        this.width=60;
        this.height=10;
    }

    void setX(int x)
    {
        this.x=x;
    }
}
