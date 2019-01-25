package zestaw1;

public class Program
{
   public static void main(String[] args)     
   {                                          
      Punkt obj1;                             
      obj1=new Punkt(-1,1);                   
      System.out.println("punkt: "+obj1);     
 
      Prostokat obj2;                         
      obj2=new Prostokat(3,4,obj1);           
      System.out.println("prostokat: "+obj2); 
 	
	obj2.przesun(7, -3);
	System.out.println("prostokat: "+obj2);

      double p=obj2.pole();                   
      System.out.println("pole: "+p);    
	
	Punkt obj;
	obj = new Punkt(0,0);
	System.out.println("punkt: " + obj);
	 
	obj.przesun(-1,3);
	System.out.println("przesuniecie punktu: "+obj);   

	Okrag obj3;

	obj3=new Okrag(3, obj);
	System.out.println("okrag: " + obj3 +"\nzestaw1.Okrag zawiera punkt (x: 3, y: 2)? " + obj3.zawiera(new Punkt (3,2)) + "\n" +
			"zestaw1.Okrag zawiera punkt (x: 3, y: 2)? " + obj3.zawiera(new Punkt (-3,2)) + "\n");
	Punkt pkt = new Punkt(2,3);
	Punkt pkt2 = new Punkt(7,-1);
	System.out.println(obj2.toString());
	System.out.println("zestaw1.Prostokat zawiera punkt " + pkt.toString() + "? " + obj2.zawiera(pkt) +
			"\nzestaw1.Prostokat zawiera punkt " + pkt2.toString() + "? " + obj2.zawiera(pkt2) + "\n");
	Okrag obj4=new Okrag(4,new Punkt(3,5));
	Okrag obj5=new Okrag(4,new Punkt(6,5));
	System.out.println(obj3 + "\n" + obj4 + "\nOkregi sie przecinaja? " + obj3.przecina(obj4));
	System.out.println(obj3 + "\n" + obj4 + "\nOkregi sie przecinaja? " + obj3.przecina(obj5));
   	System.out.println(obj2.przecina(new Prostokat(10,10,new Punkt(10,10))));
   }
}


class Punkt
{
	double x;
	double y;

	Punkt(double x, double y)
	{
		this.x=x;
		this.y=y;
	}

	void przesun(double dx, double dy)
	{
		this.x=x+dx;
		this.y=y+dy;
	}

	public String toString()
	{
		return "[x: "+x+", y: "+y+"]";
	}


}


class Prostokat {
	double dlugosc;
	double szerokosc;
	Punkt wierzcholek;
	boolean zawiera;

	Prostokat(double dlugosc, double szerokosc) {
		this.dlugosc = dlugosc;
		this.szerokosc = szerokosc;
		this.wierzcholek = new Punkt(0, 0);
	}

	Prostokat(double dlugosc, double szerokosc, Punkt wierzcholek) {
		this.dlugosc = dlugosc;
		this.szerokosc = szerokosc;
		this.wierzcholek = wierzcholek;
	}

	public String toString() {
		return "[dl: " + dlugosc + ", sz: " + szerokosc + "]" + wierzcholek.toString();
	}

	double pole() {
		return dlugosc * szerokosc;
	}

	double obwod() {
		return 2 * dlugosc + 2 * szerokosc;
	}

	void przesun(double u, double v) {
		this.wierzcholek.przesun(u, v);
	}

	/**
	 * Method checking if square contains a point.
	 */
	public boolean zawiera(Punkt obj) {
		if (obj.x >= Prostokat.this.wierzcholek.x && obj.x <= Prostokat.this.wierzcholek.x + Prostokat.this.szerokosc &&
				obj.y >= Prostokat.this.wierzcholek.y && obj.y <= Prostokat.this.wierzcholek.y + Prostokat.this.dlugosc) {
			return true;
		} else {
			return false;
		}
	}
	public boolean przecina(Prostokat prostokat){
		if (prostokat.wierzcholek.x <= this.wierzcholek.x + szerokosc && prostokat.wierzcholek.y <= this.wierzcholek.y + dlugosc){
			return true;
		}
		else{
			return false;
		}
	}
}

class Okrag
{
	double r;
	Punkt srodek;

	Okrag(double r, Punkt srodek)
	{
		this.r=r;
		this.srodek=srodek;
	}

	double obwod()
	{
		return 2*Math.PI*r;
	}

	double pole()
	{
		return Math.PI*Math.pow(r, 2);
	}
	/** Method checking if circle contains a point. */

	public boolean zawiera(Punkt obj){
		double odl = Math.sqrt(Math.pow(obj.x - this.srodek.x, 2 ) + Math.pow(obj.y - this.srodek.y, 2));
		if (odl <= this.r){
			return true;
		}
		else {
			return false;
		}
	}
	/** Method checking if circles intersect. */

	public boolean przecina(Okrag obj){
		double odl = Math.sqrt(Math.pow(obj.srodek.x - this.srodek.x, 2) + Math.pow(obj.srodek.y - this.srodek.y, 2));
		if (odl <= obj.r + this.r){
			return true;
		}
		else {
			return false;
		}
	}

	public String toString()
	{
		return "[promien: "+r+", srodek: "+srodek+"]";
	}
}


