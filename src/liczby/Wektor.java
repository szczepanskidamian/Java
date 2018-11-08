package liczby;

public class Wektor {

    private int x;
    private int y;
    private int z;

    public Wektor (int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString(){
        return "("+x+", "+y+", "+z+")";
    }

    Wektor plus(Wektor wektor){
        return new Wektor(this.x+wektor.x, this.y+wektor.y, this.z+wektor.z);
    }

    Wektor minus(Wektor wektor){
        return new Wektor(this.x-wektor.x, this.y-wektor.y, this.z-wektor.z);
    }

    Wektor iloczynWektorowy(Wektor wektor){
        return new Wektor(
                this.y*wektor.z - this.z*wektor.y,
                this.z*wektor.x - this.x*wektor.z,
                this.x*wektor.y - this.y*wektor.x);
    }

    double iloczynSkalarny(Wektor wektor){
        return Math.sqrt((this.x*wektor.x) + (this.y*wektor.y) + (this.z*wektor.z));
    }

}
