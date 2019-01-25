package zestaw9.cw1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

class Brick extends Rectangle2D.Float
{
    int health;
    Brick(float x, float y, int health)
    {
        this.x=x;
        this.y=y;
        this.width=40;
        this.height=15;
        this.health = health;
    }
}
