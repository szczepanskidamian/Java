package zestaw9.cw1;

class BallEngine extends Thread
{
    Ball a;

    BallEngine(Ball a)
    {
        this.a=a;
        start();
    }

    public void run()
    {
        try
        {
            while(true) {
                if (!a.p.stop && !a.p.hold) {
//                if (!a.p.stop && !(a.p.hold && a.barHit())) {
                    a.nextKrok();
                }
                sleep(15);

            }
        }
        catch(InterruptedException e){}
    }
}
